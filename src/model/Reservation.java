package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Reservation {
	
	private int id;
	private int numRes;
	private int nbJourRes;
	private String date;
	private String typeChambre;
	private String reglement;
	
	


	public Reservation() {
		
	}

	public Reservation(int id, int numRes, int nbJourRes, String date, String typeChambre,
			String reglement) {
		this.id = id;
		this.numRes = numRes;
		this.nbJourRes = nbJourRes;
		this.date = date;
		this.typeChambre = typeChambre;
		this.reglement = reglement;
	}

	public int getNumRes() {
		return numRes;
	}

	public void setNumRes(int numRes) {
		this.numRes = numRes;
	}

	public int getNbJourRes() {
		return nbJourRes;
	}

	public void setNbJourRes(int nbJourRes) {
		this.nbJourRes = nbJourRes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTypeChambre() {
		return typeChambre;
	}

	public void setTypeChambre(String typeChambre) {
		this.typeChambre = typeChambre;
	}

	public String getReglement() {
		return reglement;
	}

	public void setReglement(String reglement) {
		this.reglement = reglement;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getDate() {
		return date;
	}
}
