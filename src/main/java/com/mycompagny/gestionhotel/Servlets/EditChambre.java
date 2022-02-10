package com.mycompagny.gestionhotel.Servlets;

import com.mycompagny.gestionhotel.Dao.ChambreService;
import com.mycompagny.gestionhotel.Models.Chambre;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax .servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.RequestDispatcher;

@WebServlet(name = "EditChambre", urlPatterns = {"/edit-chambre"})
public class EditChambre extends HttpServlet {

    
private static final long serialVersionUID = 1L;


    
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idChambre = Integer.parseInt(request.getParameter("id"));
        try {
            ChambreService chambreService = new ChambreService();
            // Edit de la chambre
            Chambre chambre = chambreService.findById(idChambre);

            request.setAttribute("chambre", chambre);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("edit_chambre.jsp");

            requestDispatcher.forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(EditChambre.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idChambre = Integer.parseInt(request.getParameter("id"));
        String numero = request.getParameter("numero");
        String description = request.getParameter("description");
        Double prix = Double.parseDouble(request.getParameter("prix"));
        try {
            ChambreService chambreService = new ChambreService();
            // Suppression de la chambre
            Chambre chambre = chambreService.findById(idChambre);
            chambre.setNumero(numero);
            chambre.setDescription(description);
            chambre.setPrix(prix);
            chambreService.update(chambre);
            
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/chambres");

            requestDispatcher.forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(EditChambre.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
