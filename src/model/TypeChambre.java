package model;

import java.util.ArrayList;

public class TypeChambre {
	
	public static ArrayList<TypeChambre> listTypeChambre = new ArrayList<TypeChambre>();
	
	private int chambreid;
	private String typeChambre;
	private int nbChambreMax;
	private int nbChambresRestantes;
	private int prixChambre;
	
	public TypeChambre() {}
	
	public TypeChambre(int chambreid, String typeChambre, int nbChambreMax, int prixChambre) {
		this.chambreid = chambreid;
		this.typeChambre = typeChambre;
		this.nbChambreMax = nbChambreMax;
		this.prixChambre = prixChambre;
	}
	
	public int getChambreid() {
		return chambreid;
	}
	public void setChambreid(int chambreid) {
		this.chambreid = chambreid;
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
	public int getNbChambresRestantes() {
		return nbChambresRestantes;
	}
	public void setNbChambresRestantes(int nbChambresRestantes) {
		this.nbChambresRestantes = nbChambresRestantes;
	}
	public int getPrixChambre() {
		return prixChambre;
	}
	public void setPrixChambre(int prixChambre) {
		this.prixChambre = prixChambre;
	}

}
