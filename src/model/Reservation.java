package model;

import java.util.ArrayList;

public class Reservation {
	

	public static ArrayList<Reservation> listeReservation = new ArrayList<Reservation>();
	public static ArrayList<Reservation> lesReservationsDeCeType = new ArrayList<Reservation>();
	
	private int idRes;
	private String dateDebut;
	private String dateFin;
	private int idchambre;
	private int idclient;
	
	
	public Reservation() {}

	public Reservation(int idRes, String dateDebut, String dateFin, int pidclient, int idchambre) {
		super();
		this.idRes = idRes;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.idclient = pidclient;
		this.idchambre = idchambre;
	}
	

	public int getIdRes() {
		return idRes;
	}

	public void setIdRes(int id) {
		this.idRes = id;
	}

	public int getidchambre() {
		return idchambre;
	}

	public void setidchambre(int idchambre) {
		this.idchambre = idchambre;
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
