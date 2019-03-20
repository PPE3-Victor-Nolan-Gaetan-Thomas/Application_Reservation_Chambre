package model;

public class Reservation {
	
	private int idRes;
	private int nbJourRes;
	private String dateDebut;
	private String dateFin;
	private String typeChambre;
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
		this.idclient = pidclient;
	}
	
	public Reservation(int idRes, int nbJourRes, String typeChambre,
			String reglement, int pidclient) {
		super();
		this.idRes = idRes;
		this.nbJourRes = nbJourRes;
		this.typeChambre = typeChambre;
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
