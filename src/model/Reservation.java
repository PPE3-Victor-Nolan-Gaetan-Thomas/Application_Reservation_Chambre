package model;

import java.util.Date;

public class Reservation {
	
	private int id;
	private String nom;
	private String prenom;
	private int numRes;
	private int nbJourRes;
	private String mail;
	private Date date;
	private String typeChambre;
	private String reglement;
	
	
	
	public Reservation() {
		
	}

	public Reservation(int id, String nom, String prenom, int numRes, int nbJourRes, String mail, Date date, String typeChambre,
			String reglement) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.numRes = numRes;
		this.nbJourRes = nbJourRes;
		this.mail = mail;
		this.date = date;
		this.typeChambre = typeChambre;
		this.reglement = reglement;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
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

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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

}
