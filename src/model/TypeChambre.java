package model;

import java.util.ArrayList;

public class TypeChambre {
	
	public static ArrayList<TypeChambre> listTypeChambre = new ArrayList<TypeChambre>();
	
	private int idTypeChambre;
	private String typeChambre;
	private double prixChambre;
	private int nbChambreMax;
	
	public TypeChambre() {}
	
	public TypeChambre(int chambreid, String typeChambre, double prixChambre, int nbChambreMax) {
		this.idTypeChambre = chambreid;
		this.typeChambre = typeChambre;
		this.nbChambreMax = nbChambreMax;
		this.prixChambre = prixChambre;
	}
	
	public int getidTypeChambre() {
		return idTypeChambre;
	}
	public void setidTypeChambre(int chambreid) {
		this.idTypeChambre = chambreid;
	}
	public String getTypeChambre() {
		return typeChambre;
	}
	public void setTypeChambre(String typeChambre) {
		this.typeChambre = typeChambre;
	}
	public int getNbChambreMax() {
		return nbChambreMax;
	}
	public void setNbChambreMax(int nbChambreMax) {
		this.nbChambreMax = nbChambreMax;
	}
	public double getPrixChambre() {
		return prixChambre;
	}
	public void setPrixChambre(int prixChambre) {
		this.prixChambre = prixChambre;
	}

}
