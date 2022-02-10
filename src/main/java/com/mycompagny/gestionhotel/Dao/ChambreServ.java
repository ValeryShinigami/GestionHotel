package com.mycompagny.gestionhotel.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mycompagny.gestionhotel.Models.Chambre;

public class ChambreServ implements IDao<Chambre> {
	
	

	Connection conn;

	public ChambreServ() throws SQLException {
		
		String dbURL = "jdbc:mysql://localhost:8889/GestionHotel";
		String username = "root";
		String password = "root";
		
		
		try {
			
			 
		    conn = DriverManager.getConnection(dbURL, username, password);
		 
		    if (conn != null) {
		        System.out.println("Connected");
		    }
		} catch (SQLException ex) {
		    ex.printStackTrace();
		}
	
	}
	
	@Override
	public boolean create(Chambre chambre) {
		
		String sql = "INSERT INTO Chambres (numero,prix,description) VALUES (?, ?, ?)";
		int result = 0;
		
		 try {
			 PreparedStatement statement = conn.prepareStatement(sql);
				statement.setString(1, chambre.getNumero());
				statement.setDouble(2, chambre.getPrix());
				statement.setString(3, chambre.getDescription());
	            result = statement.executeUpdate();
	        } catch (SQLException ex) {
	            Logger.getLogger(ChambreServ.class.getName()).log(Level.SEVERE, null, ex);
	        }
			
		 return (result == 1);
	}

	@Override
	public boolean delete(Chambre chambre) {
		
		String sql = "DELETE FROM Chambres WHERE numero=?"; 
		int result = 0;
		
		 try {
			 PreparedStatement statement = conn.prepareStatement(sql);
				statement.setString(1, chambre.getNumero());
				statement.setDouble(2, chambre.getPrix());
				statement.setString(3, chambre.getDescription());
	            result = statement.executeUpdate();
	        } catch (SQLException ex) {
	            Logger.getLogger(ChambreServ.class.getName()).log(Level.SEVERE, null, ex);
	        }
			
		 return (result == 1);
		
	}

	@Override
	public boolean update(Chambre chambre) {
		
		String sql = "UPDATE FROM Chambres SET numero=?, prix=?, description=? WHERE id=?"; 
		int result = 0;
		
		 try {
			 PreparedStatement statement = conn.prepareStatement(sql);
				statement.setString(1, chambre.getNumero());
				statement.setDouble(2, chambre.getPrix());
				statement.setString(3, chambre.getDescription());
	            result = statement.executeUpdate();
	            
	        } catch (SQLException ex) {
	            Logger.getLogger(ChambreServ.class.getName()).log(Level.SEVERE, null, ex);
	        }
			
		 return (result == 1);
	}

	@Override
	public Chambre findById(int id) {
	
		String sql = "SELECT * FROM Chambres WHERE id=?";
		
		Chambre chambre = new Chambre();
			 
		try{
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while (result.next()){
			chambre.setId(result.getInt("id"));	
			chambre.setNumero(result.getString("numero"));
            chambre.setDescription(result.getString("description"));
            chambre.setPrix(result.getDouble("prix"));
            chambre.setStatusDisponible(result.getInt("status_disponible"));
		   
		}
		}catch(SQLException ex) {
			Logger.getLogger(ChambreServ.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		
		return chambre;
	}

	@Override
	public List<Chambre> findAll() {
		
		
		String sql = "SELECT * FROM Chambres";
		ArrayList<Chambre> ListChambres = new ArrayList<>();
		
		try{
			Chambre chambre = new Chambre();
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while (result.next()){
			chambre.setId(result.getInt("id"));	
			chambre.setNumero(result.getString("numero"));
            chambre.setDescription(result.getString("description"));
            chambre.setPrix(result.getDouble("prix"));
            chambre.setStatusDisponible(result.getInt("status_disponible"));
            
            ListChambres.add(chambre);
            
		   
		}
		}catch(SQLException ex) {
			Logger.getLogger(ChambreServ.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return ListChambres;
	}

}


