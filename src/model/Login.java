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
	public static ArrayList<String> listeNumClient = new ArrayList<String>();
	public static ArrayList<Chambre> listInfoChambres = new ArrayList<Chambre>();
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

			int id;
			String id_Client;
			String nom_Client;
			String prenom_Client;
			String adresseCP_Client;
			String adresseVille_Client;
			String adresseRue_Client;
			String mailClient;

			if (resultat.first()) {
				do {
					id = resultat.getInt(1);
					id_Client = resultat.getString(2);
					nom_Client = resultat.getString(3);
					prenom_Client = resultat.getString(4);
					adresseCP_Client = resultat.getString(5);
					adresseVille_Client = resultat.getString(6);
					adresseRue_Client = resultat.getString(7);
					mailClient = resultat.getString(8);
					
					listeClients.add(new Client(id, id_Client, nom_Client, prenom_Client, adresseCP_Client, adresseVille_Client, adresseRue_Client, mailClient));
					
				} while (resultat.next());

			}
			//con.fermerConnexion();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static int recupNombbreClient() {
		Connexion con = new Connexion();
		Connection conn = con.getConn();
		int nbreClient = 0;
		
		try {
			Statement state = conn.createStatement();
			ResultSet resultat = state.executeQuery("SELECT COUNT(*) FROM client");
			if(resultat.first()) {
				do {
					nbreClient = resultat.getInt(1);
				}while(resultat.next());
			}
			
			//con.fermerConnexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nbreClient;
	}
	
	public static void recupIdClients() {
		Connexion con = new Connexion();
		Connection conn = con.getConn();
		
		try {
			Statement state = conn.createStatement();
			ResultSet resultat = state.executeQuery("SELECT idclient FROM client");

			String id_Client;

			if (resultat.first()) {
				do {
					id_Client = resultat.getString(1);
					listeNumClient.add(id_Client.toString());
				} while (resultat.next());

			}
			//con.fermerConnexion();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void recupInfoChambre() {
		Connexion con = new Connexion();
		Connection conn = con.getConn();
		
		try {
			Statement state = conn.createStatement();
			ResultSet resultat = state.executeQuery("SELECT * FROM chambre");
			
			int chambreid;
			String typechambre;
			int nbChambreMax;
			int nbChambresRestantes;
			int prixChambre;

			if (resultat.first()) {
				do {
					chambreid = resultat.getInt(1);
					typechambre = resultat.getString(2);
					nbChambreMax = resultat.getInt(3);
					nbChambresRestantes = resultat.getInt(4);
					prixChambre = resultat.getInt(5);
					
					listInfoChambres.add(new Chambre(chambreid, typechambre, nbChambreMax, nbChambresRestantes, prixChambre));
				} while (resultat.next());

			}
			//con.fermerConnexion();
			state.close();
			resultat.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void mettreCompteurAJour(int pChambreId, String pTypeChambre, int pNbChambresRestantes) {//goto
		Connexion con = new Connexion();
		Connection conn = con.getConn();
		
		if(pTypeChambre.equals("Suite")) {
			try {
				Statement state = conn.createStatement();
				ResultSet resultat = state.executeQuery("UPDATE chambre SET nbChambresRestantes=" + pNbChambresRestantes+1 + "WHERE chambreid=" + pChambreId);
				
				listInfoChambres.clear();
				recupInfoChambre();

			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}else if(pTypeChambre.equals("Suite junior")) {
			try {
				Statement state = conn.createStatement();
				ResultSet resultat = state.executeQuery("UPDATE chambre SET nbChambresRestantes=" + pNbChambresRestantes+1 + "WHERE chambreid=" + pChambreId);
				
				listInfoChambres.clear();
				recupInfoChambre();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else if(pTypeChambre.equals("Chambre prestige")) {
			try {
				Statement state = conn.createStatement();
				ResultSet resultat = state.executeQuery("UPDATE chambre SET nbChambresRestantes=" + pNbChambresRestantes+1 + "WHERE chambreid=" + pChambreId);
				
				listInfoChambres.clear();
				recupInfoChambre();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else if(pTypeChambre.equals("Chambre executive")) {
			try {
				Statement state = conn.createStatement();
				ResultSet resultat = state.executeQuery("UPDATE chambre SET nbChambresRestantes=" + pNbChambresRestantes+1 + "WHERE chambreid=" + pChambreId);
				
				listInfoChambres.clear();
				recupInfoChambre();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else if(pTypeChambre.equals("Chambre classique")) {
			try {
				Statement state = conn.createStatement();
				ResultSet resultat = state.executeQuery("UPDATE chambre SET nbChambresRestantes=" + pNbChambresRestantes+1 + "WHERE chambreid=" + pChambreId);
				
				listInfoChambres.clear();
				recupInfoChambre();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else if(pTypeChambre.equals("Chambre single")) {
			try {
				Statement state = conn.createStatement();
				ResultSet resultat = state.executeQuery("UPDATE chambre SET nbChambresRestantes=" + pNbChambresRestantes+1 + "WHERE chambreid=" + pChambreId);
				
				listInfoChambres.clear();
				recupInfoChambre();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else {
			System.err.println("Problème lors de la mise a jour du nombres de chambres restantes");
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
	
	public static void ajouterClient(String idclient, String nom_client, String prenom_client, String cp_client, String ville_client, String rue_client, String mail) {
		Connexion con = new Connexion();
		Connection conn = con.getConn();
		
		try {
			PreparedStatement state = conn.prepareStatement("INSERT INTO client (idclient, nomclient, prenomclient, cpclient, villeclient, rueclient, mail) VALUES (?, ?, ?, ?, ?, ?, ?)");
		
			state.setString(1, idclient);
			state.setString(2, nom_client);
			state.setString(3, prenom_client);
			state.setString(4, cp_client);
			state.setString(5, ville_client);
			state.setString(6, rue_client);
			state.setString(7, mail);
			
			state.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Erreur lors de l'ajout d'un client dans la base de données");
		}
		
	}
	
	public static void ajouterIdClient(int idclient, String prenom_client, String nom_client) {//en cours
		Connexion con = new Connexion();
		Connection conn = con.getConn();
		
		try {
			PreparedStatement state = conn.prepareStatement("UPDATE client SET idclient=\"?\" WHERE id=?");
		
			state.setString(1, prenom_client+"."+nom_client+Math.random()*1000);
			state.setInt(2, idclient);
			
			
			state.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Erreur lors de l'ajout d'un client dans la base de données");
		}
	}
	
	public static void supprimerClient(int pId) {
		Connexion con = new Connexion();
		Connection conn = con.getConn();
		
		try {
			String idclient = "\"" + pId + "\"";
			PreparedStatement state = conn.prepareStatement("DELETE FROM client WHERE idclient=" + idclient);
			state.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Erreur lors de la suppression d'un client de la bdd");
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