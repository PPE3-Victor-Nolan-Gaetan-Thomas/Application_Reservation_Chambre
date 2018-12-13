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
			ResultSet resultat = state.executeQuery("SELECT * FROM client");
			
			int id;
			String nom;
			String prenom;
			int numRes;
			int nbJourRes;
			String mail;
			Date date;
			String typeChambre;
			String reglement;

			if (resultat.first()) {
				do {
					id = resultat.getInt(1);
					nom = resultat.getString(2);
					prenom = resultat.getString(3);
					numRes = resultat.getInt(4);
					nbJourRes = resultat.getInt(5);
					mail = resultat.getString(6);
					date = resultat.getDate(7);
					typeChambre = resultat.getString(8);
					reglement = resultat.getString(9);
					
					listeReservation.add(new Reservation(id, nom, prenom, numRes, nbJourRes, mail, date, typeChambre, reglement));
					
				} while (resultat.next());

			}
			//con.fermerConnexion();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void ajouterReservation(int id, String nom, String prenom, int numRes, int nbJourRes, String mail, Date date, String typeChambre, String reglement, int idClient) {
		//faire une requete preparer
		Connexion con = new Connexion();
	Connection conn = con.getConn();
		
		try {//regarder comment faire une requete preparer
			PreparedStatement state = conn.prepareStatement("INSERT INTO reservation VALUES(?, \"?\", \"?\", ?, ?, \"?\", \"?\", \"?\", \"?\", ?");
			
			state.setInt(1,  id);
			state.setString(2,  nom);
			state.setString(3, prenom);
			state.setInt(4,  numRes);
			state.setInt(5, nbJourRes);
			state.setString(6, mail);
			state.setDate(7, (java.sql.Date) date); 
			state.setString(8, typeChambre);
			state.setString(9, reglement);
			state.setInt(10, idClient);
			
			state.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Erreur lors de l'ajout d'une réservation dans la base de données");
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