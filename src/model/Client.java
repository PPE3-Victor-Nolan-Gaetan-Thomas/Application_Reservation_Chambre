package model;

import java.util.ArrayList;

public class Client {
	
	public static ArrayList<Client> listeClients = new ArrayList<Client>();
	public static ArrayList<String> listeNumClient = new ArrayList<String>();
	
	private String id_client;
	private String nom_client;
	private String prenom_client;
	private String cp_client;
	private String ville_client;
	private String rue_client;
	private String mail;
	
	
	public Client(String id_client, String nom_client, String prenom_client, String cp_client, String ville_client,
			String rue_client, String mail) {
		this.id_client = id_client;
		this.nom_client = nom_client;
		this.prenom_client = prenom_client;
		this.cp_client = cp_client;
		this.ville_client = ville_client;
		this.rue_client = rue_client;
		this.mail = mail;
	}
	
	
	
	
	
	
	public String getId_client() {
		return id_client;
	}
	public void setId_client(String id_client) {
		this.id_client = id_client;
	}
	public String getNom_client() {
		return nom_client;
	}
	public void setNom_client(String nom_client) {
		this.nom_client = nom_client;
	}
	public String getPrenom_client() {
		return prenom_client;
	}
	public void setPrenom_client(String prenom_client) {
		this.prenom_client = prenom_client;
	}
	public String getCp_client() {
		return cp_client;
	}
	public void setCp_client(String cp_client) {
		this.cp_client = cp_client;
	}
	public String getVille_client() {
		return ville_client;
	}
	public void setVille_client(String ville_client) {
		this.ville_client = ville_client;
	}
	public String getRue_client() {
		return rue_client;
	}
	public void setRue_client(String rue_client) {
		this.rue_client = rue_client;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
}
