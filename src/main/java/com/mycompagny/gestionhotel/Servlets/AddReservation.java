package com.mycompagny.gestionhotel.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mycompagny.gestionhotel.Dao.ChambreService;
import com.mycompagny.gestionhotel.Dao.ReservationService;
import com.mycompagny.gestionhotel.Models.Chambre;
import com.mycompagny.gestionhotel.Models.Reservation;

@WebServlet(name = "AddReservation", urlPatterns = {"/add-reservation"})
public class AddReservation extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		
		try (PrintWriter out = response.getWriter()) {

			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet AddReservation</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Servlet AddReservation at " + request.getContextPath() + "</h1>");
			out.println("</body>");
			out.println("</html>");
		}
	}


	@Override
	//pour avoir la liste
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			ChambreService chambreService = new ChambreService();
			List<Chambre> listeChambres = chambreService.findAll();


			request.setAttribute("listeChambres", listeChambres);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("add_reservation.jsp");

			requestDispatcher.forward(request, response);
		} catch (SQLException ex) {
			Logger.getLogger(GestionChambre.class.getName()).log(Level.SEVERE, null, ex);
		}

	}


	@Override
	//pour stocker les données dans la base de donnée
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//le formulaire vient en string donc on le transforme en int avec parseInt
		Date dateReservation = Date.valueOf(request.getParameter("date_reservation"));
		int chambreId = Integer.parseInt(request.getParameter("chambre"));
		int nbreJrs = Integer.parseInt(request.getParameter("nbre_jrs"));

		try {
			ChambreService chambreService = new ChambreService();
			ReservationService reservationService = new ReservationService();

			Chambre chambre = chambreService.findById(chambreId);

			Double prixTotal = chambre.getPrix() * nbreJrs;

			// Création de la reservation
			Reservation reservation = new Reservation(dateReservation, nbreJrs, prixTotal, chambreId);
			reservationService.create(reservation);

			request.setAttribute("added", 1);

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("add_reservation.jsp");

			requestDispatcher.forward(request, response);
			
		} catch (SQLException ex) {
			Logger.getLogger(AddReservation.class.getName()).log(Level.SEVERE, null, ex);
		}
	}


	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>

}
