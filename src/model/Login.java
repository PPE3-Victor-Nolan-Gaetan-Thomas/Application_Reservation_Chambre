package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import java.sql.CallableStatement;

public class Login {
	public static ArrayList<String> listeNumClient = new ArrayList<String>();
	public static ArrayList<TypeChambre> listInfoChambres = new ArrayList<TypeChambre>();
	public static ArrayList<String> lesDatesDebutOccupation = new ArrayList<String>();
	public static ArrayList<String> lesDatesFinOccupation = new ArrayList<String>();
	public static ArrayList<String> lesDatesOccupations = new ArrayList<String>();
	public static ArrayList<Integer> listNumChambreDeCeType = new ArrayList<Integer>();
	public static ArrayList<Chambre> listNumChambreReserverDeCeType = new ArrayList<Chambre>();
	public static ArrayList<Chambre> lesChambresDisponiblesALaReservation = new ArrayList<Chambre>();
	public static boolean mdpIncorrect = false;
	public static boolean idIncorrect = false;
	public static String leTitulaire ="";
	public static int idClient=0;
	
	
	public static void recupClient() {
		Connexion con = new Connexion();
		Connection conn = con.getConn();
	
		try {
			CallableStatement state = conn.prepareCall("{CALL recup_client()}");
			ResultSet resultat = state.executeQuery();

			String id_Client;
			String nom_Client;
			String prenom_Client;
			String adresseCP_Client;
			String adresseVille_Client;
			String adresseRue_Client;
			String mailClient;
			Client.listeClients.clear();
			if (resultat.first()) {
				do {
					id_Client = resultat.getString(1);
					nom_Client = resultat.getString(2);
					prenom_Client = resultat.getString(3);
					adresseCP_Client = resultat.getString(4);
					adresseVille_Client = resultat.getString(5);
					adresseRue_Client = resultat.getString(6);
					mailClient = resultat.getString(7);
					
					Client.listeClients.add(new Client(id_Client, nom_Client, prenom_Client, adresseCP_Client, adresseVille_Client, adresseRue_Client, mailClient));
					
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
	
	//a voir
	public static void recupIdClients() {
		Connexion con = new Connexion();
		Connection conn = con.getConn();
		
		try {
			Statement state = conn.createStatement();
			ResultSet resultat = state.executeQuery("{CALL recupIdClient()}");

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
			Chambre.listChambre.clear();
			

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
	
	public static void supprimerReservation(int pIdRes) {
		Connexion con = new Connexion();
		Connection conn = con.getConn();
		
		try {
			PreparedStatement state = conn.prepareStatement("{CALL supprimerReservation(?)}");
			state.setInt(1, pIdRes);
			state.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void recupAllChambreByNumType(int pIdType) {//TODO
		Connexion con = new Connexion();
		Connection conn = con.getConn();
		
		
		
		try {
			PreparedStatement state = conn.prepareStatement("{CALL recupAllChambreFromSpecifiedType(?)}");
			state.setInt(1, pIdType);
			ResultSet resultat = state.executeQuery();
			
			int idchambre;
			int numerochambre;
			int idtypechambre;
			Chambre.listChambreDeCeType.clear();
			

			if (resultat.first()) {
				do {
					idchambre = resultat.getInt(1);
					numerochambre = resultat.getInt(2);
					idtypechambre = resultat.getInt(3);
					Chambre.listChambreDeCeType.add(new Chambre(idchambre, numerochambre, idtypechambre));
				} while (resultat.next());

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void  recupNumChambreDeCeTypeDeChambreDepuisReservation(int pidTypeChambre) {
		Connexion con = new Connexion();
		Connection conn = con.getConn();
		
		
		
		try {
			PreparedStatement state = conn.prepareStatement("{CALL recupNumChambreDeCeTypeDeChambreDepuisReservation(?)}");
			state.setInt(1, pidTypeChambre);
			ResultSet resultat = state.executeQuery();
			
			int idchambre;
			int numerochambre;
			int idtypechambre;
			listNumChambreReserverDeCeType.clear();
			//TODO
			

			if (resultat.first()) {
				do {
					idchambre = resultat.getInt(1);
					numerochambre = resultat.getInt(2);
					idtypechambre = resultat.getInt(3);
					listNumChambreReserverDeCeType.add(new Chambre(idchambre, numerochambre, idtypechambre));
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
	
	
	
	public static int nombreChambresRestanteSuiteJunior() {
		Connexion con = new Connexion();
		Connection conn = con.getConn();
		int reponse = 0;
		
		try {
			PreparedStatement state = conn.prepareStatement("{CALL recupTypeChambre()}");
			ResultSet resultat = state.executeQuery();
			

			if (resultat.first()) {
				do {
					
					
				} while (resultat.next());

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return reponse;
		
	}
	
	public static void remplirTypeChambreBDD() { //goto fill
		Connexion con = new Connexion();
		Connection conn = con.getConn();
		
		for(int i = 0; i<1;i++) {
			try {
				PreparedStatement state = conn.prepareStatement("INSERT INTO chambre (numerochambre, id_typechambre) VALUES(?, ?)");
				
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
				PreparedStatement state = conn.prepareStatement("INSERT INTO chambre (numerochambre, id_typechambre) VALUES(?, ?)");
				
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
				PreparedStatement state = conn.prepareStatement("INSERT INTO chambre (numerochambre, id_typechambre) VALUES(?, ?)");
				
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
				PreparedStatement state = conn.prepareStatement("INSERT INTO chambre (numerochambre, id_typechambre) VALUES(?, ?)");
				
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
				PreparedStatement state = conn.prepareStatement("INSERT INTO chambre (numerochambre, id_typechambre) VALUES(?, ?)");
				
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
				PreparedStatement state = conn.prepareStatement("INSERT INTO chambre (numerochambre, id_typechambre) VALUES(?, ?)");
				
				state.setInt(1, i);
				state.setInt(2, 6);
				
				state.execute();
				
			} catch (SQLException e) {
				e.printStackTrace();
				System.err.println("Erreur lors de l'ajout d'un type de chambre dans la base de données");
			}
		}
		
		
	}
	
	public static void chambreDisponible(int pIdType, String pDateDeb, String pDateFin) {//TODO
		Connexion con = new Connexion();
		Connection conn = con.getConn();
		
		try {
			PreparedStatement state = conn.prepareStatement("{CALL recupChambreDisponible(?)}");
			state.setInt(1, pIdType);
			ResultSet resultat = state.executeQuery();
			
			int id_chambre, numerochambre, id_typechambre;
			Chambre.listChambreDispo.clear();

			if (resultat.first()) {
				do {
					id_chambre = resultat.getInt(1);
					numerochambre = resultat.getInt(2);
					id_typechambre = resultat.getInt(3);
					
					Chambre.listChambreDispo.add(new Chambre(id_chambre, numerochambre, id_typechambre));
					
				} while (resultat.next());

			}
			//con.fermerConnexion();
			
			if(Chambre.listChambreDispo.isEmpty()) {
				chambreDisponible2(pDateDeb, pDateFin, pIdType);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	public static void chambreDisponible2(String pDateDeb, String pDateFin, int pIdType) {//TODO
		Connexion con = new Connexion();
		Connection conn = con.getConn();
		
		try {
			PreparedStatement state = conn.prepareStatement("{CALL recupChambreDispo2(?, ?, ?)}");
			state.setString(1, pDateDeb);
			state.setString(2, pDateFin);
			state.setInt(3, pIdType);
			ResultSet resultat = state.executeQuery();
			
			int id_chambre, numerochambre, id_typechambre;
			Chambre.listChambreDispo.clear();

			if (resultat.first()) {
				do {
					id_chambre = resultat.getInt(1);
					numerochambre = resultat.getInt(2);
					id_typechambre = resultat.getInt(3);
					
					Chambre.listChambreDispo.add(new Chambre(id_chambre, numerochambre, id_typechambre));
					
				} while (resultat.next());

			}
			//con.fermerConnexion();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void recupClientWhereId(String pIdClient) {//TODO
		Connexion con = new Connexion();
		Connection conn = con.getConn();
		
		try {
			PreparedStatement state = conn.prepareStatement("{CALL recupClientWhereId(?)}");
			state.setString(1, pIdClient);
			ResultSet resultat = state.executeQuery();
			
			
			String id_client, nom_client, prenom_client, cp_client, ville_client, rue_client, mail_client;
			Client.listClientTemp.clear();
			if (resultat.first()) {
				do {
					id_client = resultat.getString(1);
					nom_client = resultat.getString(2);
					prenom_client = resultat.getString(3);
					cp_client = resultat.getString(4);
					ville_client = resultat.getString(5);
					rue_client = resultat.getString(6);
					mail_client = resultat.getString(7);
					
					
					Client.listClientTemp.add(new Client(id_client, nom_client, prenom_client, cp_client, ville_client, rue_client, mail_client));
					
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
			PreparedStatement state = conn.prepareStatement("{CALL recupReservation()}");
			ResultSet resultat = state.executeQuery();
			
			int idRes;
			String dateFin;
			String dateDebut;
			int idchambre;
			int idclient;
			Reservation.listeReservation.clear();

			if (resultat.first()) {
				do {
					idRes = resultat.getInt(1);
					dateFin = resultat.getString(2);
					dateDebut = resultat.getString(3);
					idclient = resultat.getInt(4);
					idchambre = resultat.getInt(5);
					
					Reservation.listeReservation.add(new Reservation(idRes, dateDebut, dateFin, idclient, idchambre));
					
				} while (resultat.next());

			}
			//con.fermerConnexion();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void recupReservationDeCeType(int pIdType) {
		Connexion con = new Connexion();
		Connection conn = con.getConn();
		
		
		
		try {
			PreparedStatement state = conn.prepareStatement("{CALL recupReservationDeCeType(?)}");
			state.setInt(1, pIdType);
			ResultSet resultat = state.executeQuery();
			
			int idRes;
			String dateFin;
			String dateDebut;
			int idchambre;
			int idclient;
			Reservation.lesReservationsDeCeType.clear();

			if (resultat.first()) {
				do {
					idRes = resultat.getInt(1);
					dateDebut = resultat.getString(2);
					dateFin = resultat.getString(3);
					idclient = resultat.getInt(4);
					idchambre = resultat.getInt(5);
					
					Reservation.lesReservationsDeCeType.add(new Reservation(idRes, dateDebut, dateFin, idclient, idchambre));
					
				} while (resultat.next());

			}
			//con.fermerConnexion();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void recupDateOccupationByNumChambre(int pNumChambre) throws ParseException {
		lesDatesDebutOccupation.clear();
		lesDatesFinOccupation.clear();
		Connexion con = new Connexion();
		Connection conn = con.getConn();
		
		
		
		
		try {
			PreparedStatement state = conn.prepareStatement("{CALL recupDateOccupationByNumChambre(?)}");
			state.setInt(1, pNumChambre);
			ResultSet resultat = state.executeQuery();
			
			
			String dateFin;
			String dateDebut;

			if (resultat.first()) {
				do {
					dateFin = resultat.getString(1);
					dateDebut = resultat.getString(2);
					
					lesDatesDebutOccupation.add(dateDebut);
					lesDatesFinOccupation.add(dateFin);
					
				} while (resultat.next());

			}
			//con.fermerConnexion();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void ajouterReservation(String dateDebut, String dateFin, int id_client, int id_chambre) {
		Connexion con = new Connexion();
		Connection conn = con.getConn();
		
		try {
			PreparedStatement state = conn.prepareStatement("{CALL ajouterReservation(?, ?, ?, ?)}");
			
			state.setString(1, dateDebut);
			state.setString(2, dateFin);
			state.setInt(3, id_client);
			state.setInt(4, id_chambre);
			
			state.execute();
			System.out.println("Réservation ajoutée !");
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Erreur lors de l'ajout d'une réservation dans la base de données");
		}
		
	}
	
	
	public static void ajouterClient(String idclient, String nom_client, String prenom_client, String cp_client, String ville_client, String rue_client, String mail) {
		Connexion con = new Connexion();
		Connection conn = con.getConn();
		
		try {
			PreparedStatement state = conn.prepareStatement("INSERT INTO client (id_client, nom_client, prenom_client, cp_client, ville_client, rue_client, mail_client) VALUES (?, ?, ?, ?, ?, ?, ?)");
		
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
			PreparedStatement state = conn.prepareStatement("UPDATE client SET id_client=\"?\" WHERE id=?");
		
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
			PreparedStatement state = conn.prepareStatement("{CALL supprimerClient(?)}");
			
			state.setInt(1, pId);
			state.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Erreur lors de la suppression d'un client de la bdd");
		}
		
	}
	
	public static void modifierClient(int pId, String pNom, String pPrenom, String pCP, String pVille, String pRue, String pMail) {
		Connexion con = new Connexion();
		Connection conn = con.getConn();//a faire goto
		
		try {
			PreparedStatement state = conn.prepareStatement("{CALL modifierClient(?, ?, ?, ?, ?, ?, ?)}");
			
			state.setInt(1, pId);
			state.setString(2, pNom);
			state.setString(3, pPrenom);
			state.setString(4, pCP);
			state.setString(5, pVille);
			state.setString(6, pRue);
			state.setString(7, pMail);
			
			state.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Erreur lors de la modification d'un client de la bdd");
		}
	}
	
	public static String convertEtoF(String pDateE) {
		String reponse = null;
		String jour, mois, annee;
		annee = pDateE.substring(0, 4);
		mois = pDateE.substring(5, 7);
		jour = pDateE.substring(8);
		reponse = jour + "/" + mois + "/" + annee;
		return reponse;
	}
}