package com.mycompagny.gestionhotel.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mycompagny.gestionhotel.Models.Chambre;
import com.mysql.cj.jdbc.Driver;

public class ChambreService implements IDao <Chambre>{


	Connection connexion;
	Statement smt;

	public ChambreService() throws SQLException {

		try {
			// TODO code application logic here
			Class c = Class.forName("com.mysql.cj.jdbc.Driver");
			Driver pilote = (Driver) c.newInstance();

			DriverManager.registerDriver(pilote);

			String protocole = "jdbc:mysql:";

			String ip = "localhost";  // dépend du contexte
			String port = "8889";  // port MySQL par défaut
			// Nom de la base ;
			String nomBase = "GestionHotel";  // dépend du contexte
			// Chaîne de connexion
			String conString = protocole + "//" + ip + ":" + port + "/" + nomBase;
			// Identifiants de connexion et mot de passe
			String nomConnexion = "root";  // dépend du contexte
			String motDePasse = "root";  // dépend du contexte
			// Connexion
			connexion = DriverManager.getConnection(
					conString, nomConnexion, motDePasse);
			smt = connexion.createStatement();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
			Logger.getLogger(ChambreService.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@Override
	public boolean create(Chambre chambre) {
		
		String insertSQL = "INSERT INTO chambres(numero,prix,description) VALUES('" + chambre.getNumero() + "',"
                + "" + chambre.getPrix() + ",'" + chambre.getDescription() + "')";
        int result = 0;
        try {
            result = smt.executeUpdate(insertSQL);
        } catch (SQLException ex) {
            Logger.getLogger(ChambreService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (result == 1);
	}

	@Override
	public boolean delete(Chambre chambre) {
		
		String deleteSQL = "DELETE FROM chambres WHERE id =" + chambre.getId();
        int result = 0;
        try {
            result = smt.executeUpdate(deleteSQL);
        } catch (SQLException ex) {
            Logger.getLogger(ChambreService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return (result == 1);
		
	}

	@Override
	public boolean update(Chambre chambre) {
		String updateSQL = "UPDATE chambres set numero='" + chambre.getNumero() + "',description='" + chambre.getDescription() + "'"
                + ",prix=" + chambre.getPrix() + ",status_disponible=" + chambre.getStatusDisponible() + ""
                + " WHERE id=" + chambre.getId();
        int result = 0;
        try {
            result = smt.executeUpdate(updateSQL);
        } catch (SQLException ex) {
            Logger.getLogger(ChambreService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return (result == 1);
	}

	@Override
	public Chambre findById(int id) {
		
		String selectSQL = "SELECT * FROM chambres WHERE id=" + id;
        Chambre chambre = new Chambre();
        try {
            ResultSet result = smt.executeQuery(selectSQL);
            if (result.next()) {
                chambre.setId(result.getInt("id"));
                chambre.setNumero(result.getString("numero"));
                chambre.setDescription(result.getString("description"));
                chambre.setPrix(result.getDouble("prix"));
                chambre.setStatusDisponible(result.getInt("status_disponible"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ChambreService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chambre;
	}

	@Override
	public List<Chambre> findAll() {
		
		String selectSQL = "SELECT * FROM chambres";
        ArrayList<Chambre> listChambres = new ArrayList<>();
        try {
            ResultSet result = smt.executeQuery(selectSQL);
            while (result.next()) {
                Chambre chambre = new Chambre();
                // Mise à jour des données du chambre
                chambre.setId(result.getInt("id"));
                chambre.setNumero(result.getString("numero"));
                chambre.setDescription(result.getString("description"));
                chambre.setPrix(result.getDouble("prix"));
                chambre.setStatusDisponible(result.getInt("status_disponible"));

                listChambres.add(chambre);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChambreService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listChambres;
		
	}
	
	


}
