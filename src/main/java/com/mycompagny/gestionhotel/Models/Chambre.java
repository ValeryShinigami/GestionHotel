package com.mycompagny.gestionhotel.Models;

public class Chambre {
	
	private int id;
	private String numero;
	private double prix;
	private String description;
	private int statusDisponible;
	
	

	public Chambre() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Chambre(String numero, double prix, String description) {
		super();
		this.numero = numero;
		this.prix = prix;
		this.description = description;
	}

	public Chambre(int id, String numero, double prix, String description, int statusDisponible) {
		super();
		this.id = id;
		this.numero = numero;
		this.prix = prix;
		this.description = description;
		this.statusDisponible = statusDisponible;
	}

	public Chambre(String numero, double prix, String description, int statusDisponible) {
		super();
		this.numero = numero;
		this.prix = prix;
		this.description = description;
		this.statusDisponible = statusDisponible;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStatusDisponible() {
		return statusDisponible;
	}

	public void setStatusDisponible(int statusDisponible) {
		this.statusDisponible = statusDisponible;
	}
	
	
	
	

}
