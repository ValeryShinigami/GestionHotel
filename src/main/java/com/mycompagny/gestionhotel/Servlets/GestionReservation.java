package com.mycompagny.gestionhotel.Servlets;

import java.io.IOException;
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


@WebServlet("/reservations")
public class GestionReservation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public GestionReservation() {
        super();
        
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         try {
            ReservationService ReservationService = new ReservationService();
            List<Reservation> listeReservations = ReservationService.findAll();
            request.setAttribute("listeReservations", listeReservations);
            
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("gestion_reservations.jsp");
            requestDispatcher.forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(GestionChambre.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		 processRequest(request, response);
	}

}
