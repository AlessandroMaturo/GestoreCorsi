package it.polito.tdp.corsi.model;

import java.util.List;

import it.polito.tdp.corsi.db.CorsoDAO;

public class Model {
	
	
	private CorsoDAO CorsoDAO;
	
	public Model() {
		this.CorsoDAO= new CorsoDAO();
	}
	
	public List<Corso> getCorsiByPeriodo(int periodo){
		return this.CorsoDAO.getCorsoByPeriodo(periodo);
	}
	
}
