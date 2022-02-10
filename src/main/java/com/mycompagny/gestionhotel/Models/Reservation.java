package com.mycompagny.gestionhotel.Models;

import java.sql.Date;

public class Reservation {
	
	private int id;
	private Date dateReservation;
	private int nbreJours;
	private double prixTotal;
	private int chambreId;
	private Chambre chambre;
	private String dateDepart;
	
	

	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Reservation(Date dateReservation, int nbreJours, double prixTotal, int chambreId) {
		super();
		this.dateReservation = dateReservation;
		this.nbreJours = nbreJours;
		this.prixTotal = prixTotal;
		this.chambreId = chambreId;
	}



	public Reservation(int id, Date dateReservation, int nbreJours, double prixTotal, int chambreId, Chambre chambre,
			String dateDepart) {
		super();
		this.id = id;
		this.dateReservation = dateReservation;
		this.nbreJours = nbreJours;
		this.prixTotal = prixTotal;
		this.chambreId = chambreId;
		this.chambre = chambre;
		this.dateDepart = dateDepart;
	}

	public Reservation(Date dateReservation, int nbreJours, double prixTotal, int chambreId, Chambre chambre,
			String dateDepart) {
		super();
		this.dateReservation = dateReservation;
		this.nbreJours = nbreJours;
		this.prixTotal = prixTotal;
		this.chambreId = chambreId;
		this.chambre = chambre;
		this.dateDepart = dateDepart;
	}
	

	public Chambre getChambre() {
		return chambre;
	}

	public void setChambre(Chambre chambre) {
		this.chambre = chambre;
	}

	public String getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(String dateDepart) {
		this.dateDepart = dateDepart;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateReservation() {
		return dateReservation;
	}

	public void setDateReservation(Date dateReservation) {
		this.dateReservation = dateReservation;
	}

	public int getNbreJours() {
		return nbreJours;
	}

	public void setNbreJours(int nbreJours) {
		this.nbreJours = nbreJours;
	}

	public double getPrixTotal() {
		return prixTotal;
	}

	public void setPrixTotal(double prixTotal) {
		this.prixTotal = prixTotal;
	}

	public int getChambreId() {
		return chambreId;
	}

	public void setChambreId(int chambreId) {
		this.chambreId = chambreId;
	}
	
	
	
	

}
