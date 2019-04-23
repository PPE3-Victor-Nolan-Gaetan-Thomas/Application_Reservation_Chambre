package model;

import java.util.ArrayList;

public class Chambre {
	public static ArrayList<Chambre> listChambre = new ArrayList<Chambre>();
	public static ArrayList<Chambre> listChambreDeCeType = new ArrayList<Chambre>();
	public static ArrayList<Chambre> listChambreDispo = new ArrayList<Chambre>();
	public static ArrayList<Chambre> listChambreTemp = new ArrayList<Chambre>();
	
	private int chambreid;
	private int numerochambre;
	private int idtypechambre;
	
	public Chambre() {}
	
	public Chambre(int chambreid, int numerochambre, int idtypechambre) {
		this.chambreid = chambreid;
		this.numerochambre = numerochambre;
		this.idtypechambre = idtypechambre;
	}
	
	
	
	public int getChambreid() {
		return chambreid;
	}
	public void setChambreid(int chambreid) {
		this.chambreid = chambreid;
	}
	public int getNumerochambre() {
		return numerochambre;
	}
	public void setNumerochambre(int numerochambre) {
		this.numerochambre = numerochambre;
	}
	public int getIdtypechambre() {
		return idtypechambre;
	}
	public void setIdtypechambre(int idtypechambre) {
		this.idtypechambre = idtypechambre;
	}
	
	

}
