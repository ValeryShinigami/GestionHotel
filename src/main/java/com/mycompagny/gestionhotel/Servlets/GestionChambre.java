package com.mycompagny.gestionhotel.Servlets;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax .servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.RequestDispatcher;

import com.mycompagny.gestionhotel.Dao.ChambreService;
import com.mycompagny.gestionhotel.Models.Chambre;


@WebServlet(name = "GestionChambre", urlPatterns = {"/chambres"})
public class GestionChambre extends HttpServlet {

   
	private static final long serialVersionUID = 1L;


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         try {
            ChambreService chambreService = new ChambreService();
            List<Chambre> listeChambres = chambreService.findAll();
            request.setAttribute("listeChambres", listeChambres);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("gestion_chambres.jsp");
            requestDispatcher.forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(GestionChambre.class.getName()).log(Level.SEVERE, null, ex);
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