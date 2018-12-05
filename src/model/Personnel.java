package model;

public class Personnel {
	
	private int id_personnel;
	private String nom_personnel;
	private String prenom_personnel;
	private String mdp_personnel;
	
	public Personnel(int id_personnel, String nom_personnel, String prenom_personnel, String mdp_personnel) {
		this.id_personnel = id_personnel;
		this.nom_personnel = nom_personnel;
		this.prenom_personnel = prenom_personnel;
		this.mdp_personnel = mdp_personnel;
	}
	
	
	public int getId_personnel() {
		return id_personnel;
	}
	public void setId_personnel(int id_personnel) {
		this.id_personnel = id_personnel;
	}
	public String getNom_personnel() {
		return nom_personnel;
	}
	public void setNom_personnel(String nom_personnel) {
		this.nom_personnel = nom_personnel;
	}
	public String getPrenom_personnel() {
		return prenom_personnel;
	}
	public void setPrenom_personnel(String prenom_personnel) {
		this.prenom_personnel = prenom_personnel;
	}
	public String getMdp_personnel() {
		return mdp_personnel;
	}
	public void setMdp_personnel(String mdp_personnel) {
		this.mdp_personnel = mdp_personnel;
	}

}
