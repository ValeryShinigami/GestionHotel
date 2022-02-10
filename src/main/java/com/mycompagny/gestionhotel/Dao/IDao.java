package com.mycompagny.gestionhotel.Dao;

import java.util.List;

public interface IDao<T> {
	
	boolean create (T personne);
	boolean delete (T personne);
	boolean update (T personne);
	
	T findById(int id);
	
	List<T>findAll();

}
