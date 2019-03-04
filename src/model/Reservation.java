package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Reservation {
	
	private int idRes;
	private int nbJourRes;
	private String dateDebut;
	private String dateFin;
	private String typeChambre;
	private String reglement;
	private int idclient;
	
	
	public Reservation() {}

	public Reservation(int idRes, int nbJourRes, String dateDebut, String dateFin, String typeChambre,
			String reglement, int pidclient) {
		super();
		this.idRes = idRes;
		this.nbJourRes = nbJourRes;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.typeChambre = typeChambre;
		this.reglement = reglement;
		this.idclient = pidclient;
	}

	public int getNbJourRes() {
		return nbJourRes;
	}

	public void setNbJourRes(int nbJourRes) {
		this.nbJourRes = nbJourRes;
	}

	public int getIdRes() {
		return idRes;
	}

	public void setIdRes(int id) {
		this.idRes = id;
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

	public String getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}

	public String getDateFin() {
		return dateFin;
	}

	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	}

	public int getIdclient() {
		return idclient;
	}

	public void setIdclient(int idclient) {
		this.idclient = idclient;
	}
}
