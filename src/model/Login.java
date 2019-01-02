package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class Login {
	public static ArrayList<Client> listeClients = new ArrayList<Client>();
	public static ArrayList<Reservation> listeReservation = new ArrayList<Reservation>();
	public static boolean mdpIncorrect = false;
	public static boolean idIncorrect = false;
	public static String leTitulaire ="";
	public static int idClient=0;
	
	public static void recupClient() {
		Connexion con = new Connexion();
		Connection conn = con.getConn();
		
		
		
		try {
			Statement state = conn.createStatement();
			ResultSet resultat = state.executeQuery("SELECT * FROM client");

			int id_Client;
			String nom_Client;
			String prenom_Client;
			String adresseCP_Client;
			String adresseVille_Client;
			String adresseRue_Client;
			String mdpClient;
			String mailClient;

			if (resultat.first()) {
				do {
					id_Client = resultat.getInt(1);
					nom_Client = resultat.getString(2);
					prenom_Client = resultat.getString(3);
					adresseCP_Client = resultat.getString(4);
					adresseVille_Client = resultat.getString(5);
					adresseRue_Client = resultat.getString(6);
					mailClient = resultat.getString(7);
					
					listeClients.add(new Client(id_Client, nom_Client, prenom_Client, adresseCP_Client, adresseVille_Client, adresseRue_Client, mailClient));
					
				} while (resultat.next());

			}
			//con.fermerConnexion();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void recupReservation() {
		Connexion con = new Connexion();
		Connection conn = con.getConn();
		
		
		
		try {
			Statement state = conn.createStatement();
			ResultSet resultat = state.executeQuery("SELECT * FROM reservation");
			
			int id;
			int numRes;
			int nbJourRes;
			String date;
			String typeChambre;
			String reglement;

			if (resultat.first()) {
				do {
					id = resultat.getInt(1);
					numRes = resultat.getInt(2);
					nbJourRes = resultat.getInt(3);
					date = resultat.getString(4);
					typeChambre = resultat.getString(5);
					reglement = resultat.getString(6);
					
					listeReservation.add(new Reservation(id, numRes, nbJourRes, date, typeChambre, reglement));
					
				} while (resultat.next());

			}
			//con.fermerConnexion();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void ajouterReservation(int nbJourRes, String date, String typeChambre, String reglement, int idClient) {
		Connexion con = new Connexion();
		Connection conn = con.getConn();
		
		try {
			PreparedStatement state = conn.prepareStatement("INSERT INTO reservation (nbjourres, date, typechambre, reglement, id_client) VALUES(?, ?, ?, ?, ?)");
			
			state.setInt(1, nbJourRes);
			state.setString(2, date);
			state.setString(3, typeChambre);
			state.setString(4, reglement);
			state.setInt(5, idClient);
			
			state.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Erreur lors de l'ajout d'une réservation dans la base de données");
		}
		
	}
	
	public static void ajouterClient(String nom_client, String prenom_client, String cp_client, String ville_client, String rue_client, String mail) {
		Connexion con = new Connexion();
		Connection conn = con.getConn();
		
		try {
			PreparedStatement state = conn.prepareStatement("INSERT INTO client (nomclient, prenomclient, cpclient, villeclient, rueclient, mail) VALUES (?, ?, ?, ?, ?, ?)");
		
			
			state.setString(1, nom_client);
			state.setString(2, prenom_client);
			state.setString(3, cp_client);
			state.setString(4, ville_client);
			state.setString(5, rue_client);
			state.setString(6, mail);
			
			state.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("Erreur lors de l'ajout d'un client dans la base de données");
		}
		
	}
	
	
	public static void modifierReservation() {
		
	}
	
	
	/*public static void loginClient(int pID) {
		Client tmp = new Client(0, "", "", "", "", "");
		
		for(Client leClient: listeClients) {
			if(leClient.getId_client()==pID) {
				tmp=leClient;
			}
		}
		System.out.println(tmp.getId_client());
		if (tmp.getId_client()==pID) {
			if (String.valueOf(FPrincipale.txtPassword.getPassword()).equals(tmp.getMdp_client())) {
				leTitulaire = tmp.getNom_client()+" "+tmp.getPrenom_client();
				idClient=tmp.getId_client();
				//FMesComptes jf=new FMesComptes();
				//FPrincipal fp = new FPrincipal();
				//fp.setVisible(false);
				//jf.setVisible(true);
			}else {
				mdpIncorrect = true;
				
			}
		}else {
			idIncorrect = true;
		}
		
	}*/
}