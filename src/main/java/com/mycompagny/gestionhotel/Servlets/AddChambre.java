package com.mycompagny.gestionhotel.Servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mycompagny.gestionhotel.Dao.ChambreService;
import com.mycompagny.gestionhotel.Models.Chambre;

/**
 * Servlet implementation class AddChambre
 */
@WebServlet("/add-chambre")
public class AddChambre extends HttpServlet {
	private static final long serialVersionUID = 1L;



	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");

		String numero = request.getParameter("numero");
		String description = request.getParameter("description");
		Double prix = Double.parseDouble(request.getParameter("prix"));
		
		try {
			ChambreService chambreService = new ChambreService();
			// Creat chamber
			Chambre chambre = new Chambre(numero, prix, description);
			boolean status = chambreService.create(chambre);

			if(status){
				request.setAttribute("added", 1);
				request.setAttribute("numero", numero);
			}

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("add_chambre.jsp");

			requestDispatcher.forward(request, response);
		} catch (SQLException ex) {
			Logger.getLogger(AddChambre.class.getName()).log(Level.SEVERE, null, ex);
		}
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		processRequest(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		processRequest(request, response);
	}

}
