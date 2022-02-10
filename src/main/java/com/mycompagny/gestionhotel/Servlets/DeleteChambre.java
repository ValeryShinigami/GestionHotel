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

@WebServlet(name = "DeleteChambre", urlPatterns = {"/delete-chambre"})
public class DeleteChambre extends HttpServlet {

   
	private static final long serialVersionUID = 1L;

	
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        int idChambre = Integer.parseInt(request.getParameter("id")) ;
        
        try {
            ChambreService chambreService = new ChambreService();
            // Suppression de la chambre
            Chambre chambre = chambreService.findById(idChambre);
            chambreService.delete(chambre);

            //requestDispatcher va raffraichir la page pour redirection vers la liste chambres
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/chambres");

            requestDispatcher.forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AddChambre.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}