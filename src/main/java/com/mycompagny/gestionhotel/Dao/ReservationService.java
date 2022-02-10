package com.mycompagny.gestionhotel.Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mycompagny.gestionhotel.Models.Chambre;
import com.mycompagny.gestionhotel.Models.Reservation;
import com.mysql.cj.jdbc.Driver;

/**
 *
 * @author farouk228
 */
public class ReservationService implements IDao< Reservation> {

   Connection connexion;
	Statement smt;

	public ReservationService() throws SQLException {

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
    public boolean create(Reservation reservation) {
        String insertSql = "insert into reservations(date_reservation,nbre_jrs,"
                + "prix_total,chambre_id)values('" + reservation.getDateReservation()+ "',"
                + "" + reservation.getNbreJours()+ "," + reservation.getPrixTotal()+ "," + reservation.getChambreId()+ ")";
        int result = 0;
        try {
            result = smt.executeUpdate(insertSql);
            if (result == 1) {
                String updateSQL = "UPDATE chambres set status_disponible=1  WHERE id=" + reservation.getChambreId();
                smt.executeUpdate(updateSQL);   
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReservationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (result == 1); 
    }

    @Override
    public boolean update(Reservation reservation) {
        String updateSql = "UPDATE reservations set date_reservation = '"
                + "" + reservation.getDateReservation()+ "',nbre_jrs=" + reservation.getNbreJours() + ""
                + ",prix_total='" + reservation.getPrixTotal() + ",chambre_id='" + reservation.getChambreId() + ""
                + " where id = " + reservation.getId();
        int result = 0;
        try {
            result = smt.executeUpdate(updateSql);
        } catch (SQLException ex) {
            Logger.getLogger(ReservationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (result == 1); 
    }

    @Override
    public boolean delete(Reservation reservation) {
        String deleteSql = "DELETE FROM reservations where id =" + reservation.getId();
        int result = 0;
        try {
            result = smt.executeUpdate(deleteSql);
        } catch (SQLException ex) {
            Logger.getLogger(ReservationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (result == 1);
        
    }

    @Override
    public Reservation findById(int id) {
        String selectSQL = "SELECT * FROM reservations JOIN chambres on reservations.chambre_id = chambres.id WHERE id=" + id;
        Reservation reservation = new Reservation();
        try {
            ResultSet result = smt.executeQuery(selectSQL);
            if (result.next()) {
                // Informations de la chambre
                Chambre chambre = new Chambre();
                chambre.setId(result.getInt("chambre_id"));
                chambre.setNumero(result.getString("numero"));
                chambre.setDescription(result.getString("description"));
                chambre.setPrix(result.getDouble("prix"));
                chambre.setStatusDisponible(result.getInt("status_disponible"));
 
                reservation.setId(result.getInt("id"));
                reservation.setDateReservation(result.getDate("date_reservation"));
                reservation.setNbreJours(result.getInt("nbre_jrs"));
                reservation.setPrixTotal(result.getDouble("prix_total"));
                reservation.setChambre(chambre);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReservationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return reservation; 
    }
    
    @Override
    public List<Reservation> findAll() {
        String selectSQL = "SELECT * FROM reservations JOIN chambres on reservations.chambre_id = chambres.id";
        ArrayList<Reservation> reservationsList = new ArrayList<>();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            ResultSet result = smt.executeQuery(selectSQL);
            while (result.next()) {
                Reservation reservation = new Reservation();
                
                // Informations de la chambre
                Chambre chambre = new Chambre();
                chambre.setId(result.getInt("chambre_id"));
                chambre.setNumero(result.getString("numero"));
                chambre.setDescription(result.getString("description"));
                chambre.setPrix(result.getDouble("prix"));
                chambre.setStatusDisponible(result.getInt("status_disponible"));
                
                Date dateReservation = result.getDate("date_reservation");
                Calendar c = Calendar.getInstance();
                c.setTime(dateReservation);
                c.add(Calendar.DATE, result.getInt("nbre_jrs"));
                
                java.util.Date dateDepart = c.getTime();
                
                reservation.setId(result.getInt("id"));
                reservation.setDateReservation(result.getDate("date_reservation"));
                reservation.setDateDepart(dateFormat.format(dateDepart));
                reservation.setNbreJours(result.getInt("nbre_jrs"));
                reservation.setPrixTotal(result.getDouble("prix_total"));
                reservation.setChambre(chambre);
                
                
                reservationsList.add(reservation);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReservationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return reservationsList;
    }


   

}