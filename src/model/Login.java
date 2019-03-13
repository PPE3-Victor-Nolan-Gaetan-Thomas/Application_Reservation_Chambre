package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import java.sql.CallableStatement;

public class Login {
	public static ArrayList<Client> listeClients = new ArrayList<Client>();
	public static ArrayList<Reservation> listeReservation = new ArrayList<Reservation>();
	public static ArrayList<String> listeNumClient = new ArrayList<String>();
	public static ArrayList<TypeChambre> listInfoChambres = new ArrayList<TypeChambre>();
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
	
	public static void recupClienttest() {
		Connexion con = new Connexion();
		Connection conn = con.getConn();
		
		
		
		try {
			CallableStatement state = conn.prepareCall("{CALL recup_client_test()}");
			ResultSet resultat = state.executeQuery();

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
			PreparedStatement state = conn.prepareStatement("{CALL recupNombreClient()}");
			ResultSet resultat = state.executeQuery();
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
	
	public static void recupChambre() {
		Connexion con = new Connexion();
		Connection conn = con.getConn();
		
		try {
			PreparedStatement state = conn.prepareStatement("{CALL recupChambre()}");
			ResultSet resultat = state.executeQuery();

			int idchambre;
			int numerochambre;
			int idtypechambre;
			

			if (resultat.first()) {
				do {
					idchambre = resultat.getInt(1);
					numerochambre = resultat.getInt(2);
					idtypechambre = resultat.getInt(3);
					Chambre.listChambre.add(new Chambre(idchambre, numerochambre, idtypechambre));
				} while (resultat.next());

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void recupTypeChambre() {
		Connexion con = new Connexion();
		Connection conn = con.getConn();
		
		try {
			PreparedStatement state = conn.prepareStatement("{CALL recupTypeChambre()}");
			ResultSet resultat = state.executeQuery();

			int id;
			String typeChambre;
			int nbChambreMax;
			int prixChambre;
			

			if (resultat.first()) {
				do {
					id = resultat.getInt(1);
					typeChambre = resultat.getString(2);
					nbChambreMax = resultat.getInt(3);
					prixChambre = resultat.getInt(4);
					TypeChambre.listTypeChambre.add(new TypeChambre(id, typeChambre, nbChambreMax, prixChambre));
				} while (resultat.next());

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void remplirTypeChambreBDD() { //goto fill
		Connexion con = new Connexion();
		Connection conn = con.getConn();
		
		for(int i = 0; i<1;i++) {
			try {
				PreparedStatement state = conn.prepareStatement("INSERT INTO chambre (numerochambre, idtypechambre) VALUES(?, ?)");
				
				state.setInt(1, i);
				state.setInt(2, 1);
				
				state.execute();
				
			} catch (SQLException e) {
				e.printStackTrace();
				System.err.println("Erreur lors de l'ajout d'un type de chambre dans la base de données");
			}
		}
		
		for(int i = 1; i<5;i++) {
			try {
				PreparedStatement state = conn.prepareStatement("INSERT INTO chambre (numerochambre, idtypechambre) VALUES(?, ?)");
				
				state.setInt(1, i);
				state.setInt(2, 2);
				
				state.execute();
				
			} catch (SQLException e) {
				e.printStackTrace();
				System.err.println("Erreur lors de l'ajout d'un type de chambre dans la base de données");
			}
		}
		
		for(int i = 6; i<21;i++) {
			try {
				PreparedStatement state = conn.prepareStatement("INSERT INTO chambre (numerochambre, idtypechambre) VALUES(?, ?)");
				
				state.setInt(1, i);
				state.setInt(2, 3);
				
				state.execute();
				
			} catch (SQLException e) {
				e.printStackTrace();
				System.err.println("Erreur lors de l'ajout d'un type de chambre dans la base de données");
			}
		}
		
		for(int i = 22; i<57;i++) {
			try {
				PreparedStatement state = conn.prepareStatement("INSERT INTO chambre (numerochambre, idtypechambre) VALUES(?, ?)");
				
				state.setInt(1, i);
				state.setInt(2, 4);
				
				state.execute();
				
			} catch (SQLException e) {
				e.printStackTrace();
				System.err.println("Erreur lors de l'ajout d'un type de chambre dans la base de données");
			}
		}
		
		for(int i = 58; i<93;i++) {
			try {
				PreparedStatement state = conn.prepareStatement("INSERT INTO chambre (numerochambre, idtypechambre) VALUES(?, ?)");
				
				state.setInt(1, i);
				state.setInt(2, 5);
				
				state.execute();
				
			} catch (SQLException e) {
				e.printStackTrace();
				System.err.println("Erreur lors de l'ajout d'un type de chambre dans la base de données");
			}
		}
		
		for(int i = 94; i<119;i++) {
			try {
				PreparedStatement state = conn.prepareStatement("INSERT INTO chambre (numerochambre, idtypechambre) VALUES(?, ?)");
				
				state.setInt(1, i);
				state.setInt(2, 6);
				
				state.execute();
				
			} catch (SQLException e) {
				e.printStackTrace();
				System.err.println("Erreur lors de l'ajout d'un type de chambre dans la base de données");
			}
		}
		
		
	}
	
	public static void recupInfoChambre() {
		Connexion con = new Connexion();
		Connection conn = con.getConn();
		
		try {
			Statement state = conn.createStatement();
			ResultSet resultat = state.executeQuery("SELECT * FROM chambre");
			
			int chambreid;
			int numerochambre;
			int typechambre;
			
			if (resultat.first()) {
				do {
					chambreid = resultat.getInt(1);
					numerochambre = resultat.getInt(2);
					typechambre = resultat.getInt(3);
					
					Chambre.listChambre.add(new Chambre(chambreid, numerochambre, typechambre));
				} while (resultat.next());

			}
			//con.fermerConnexion();
			state.close();
			resultat.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static float nbJourReservation(String dateDeb, String dateFin) {
		
		System.out.println(dateDeb);//debug
		
		   SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		   float res = 0;
		   try {
		       Date dateAvant = sdf.parse(dateDeb);
		       Date dateApres = sdf.parse(dateFin);
		       long diff = dateApres.getTime() - dateAvant.getTime();
		       res = (diff / (1000*60*60*24));
		       System.out.println("Nombre de jours entre les deux dates est: "+res);
		   } catch (Exception e) {
		         e.printStackTrace();
		   }
		   return res;
	}
	
	public static void mettreCompteurAJour(int pChambreId, String pTypeChambre, int pNbChambresRestantes) {//goto //procedure
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
			
		}else {
			System.err.println("Problème lors de la mise a jour du nombres de chambres restantes");
		}
		
		
	}
	
	public static void recupReservation() {
		Connexion con = new Connexion();
		Connection conn = con.getConn();
		
		
		
		try {
			PreparedStatement state = conn.prepareStatement("{CALL recupReservation()}");
			ResultSet resultat = state.executeQuery();
			
			int idRes;
			String dateFin;
			String dateDebut;
			String typeChambre;
			String reglement;
			int idclient;
			int nbJourRes;

			if (resultat.first()) {
				do {
					idRes = resultat.getInt(1);
					dateFin = resultat.getString(2);
					dateDebut = resultat.getString(3);
					typeChambre = resultat.getString(4);
					reglement = resultat.getString(5);
					idclient = resultat.getInt(6);
					nbJourRes = resultat.getInt(7);
					
					listeReservation.add(new Reservation(idRes, nbJourRes, dateDebut, dateFin, typeChambre, reglement, idclient));
					
				} while (resultat.next());

			}
			//con.fermerConnexion();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void ajouterReservation(String dateDebut, String dateFin, String typeChambre, String reglement, int idClient) {
		Connexion con = new Connexion();
		Connection conn = con.getConn();
		
		try {
			PreparedStatement state = conn.prepareStatement("INSERT INTO reservation (dateFin, dateDebut, typechambre, reglement, id_client) VALUES(?, ?, ?, ?, ?)");
			
			state.setString(1, dateFin);
			state.setString(2,  dateDebut);
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