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
	
	public static boolean estDisponible(int pNumChambre, Date datedebut, Date datefin) {
		boolean reponse = false;
		ArrayList<String> lesDatesVoulus = new ArrayList<String>();
		lesDatesVoulus.clear();
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
		boolean test = false;
		
		String date = sdf5.format(datedebut);
		Date df = null;
		//recupération de toutes les dates de la période
		while(!date.equals(datefin.toString())) {
			
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Calendar c = Calendar.getInstance();
				c.setTime(sdf.parse(date));
				c.add(Calendar.DATE, 1);  // nombre de jour à ajouter
				date = sdf.format(c.getTime());  // date est la nouvelle date
				df = sdf2.parse(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			lesDatesVoulus.add(df.toString()); //toutes les dates sont au format français
			
		}
		
		for(String dt : lesDatesDebutOccupation) {
			int i = 0;
			String datedeb = lesDatesDebutOccupation.get(i);
			while(!datedeb.equals(lesDatesFinOccupation.get(i))) {
				
				try {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					Calendar c = Calendar.getInstance();
					c.setTime(sdf.parse(date));
					c.add(Calendar.DATE, 1);  // nombre de jour à ajouter
					date = sdf.format(c.getTime());  // date est la nouvelle date
					df = sdf2.parse(date);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				lesDatesOccupations.add(df.toString()); //toutes les dates sont au format français
				i++;
				
			}
		}
		
		
		//debug
		for(String tmp : lesDatesOccupations) {
			System.out.println(tmp);
		}
		
		//TODO
		
		//verification de s'il existe déja une réservation pour cette date la
		
		try {
			recupDateOccupationByNumChambre(pNumChambre);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		for(String datetmp : lesDatesVoulus) {
			for(String uneDate : lesDatesOccupations) {
				if(datetmp.equals(uneDate)) {
					reponse = false;
					test=true;
					break;
				}else {
					test=false;
					reponse = true;
				}
			}
			if(test==false){break;}
		}
		
		
		
		
		
		
		return reponse;
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
			String idchambre;
			int idclient;

			if (resultat.first()) {
				do {
					idRes = resultat.getInt(1);
					dateFin = resultat.getString(2);
					dateDebut = resultat.getString(3);
					idchambre = resultat.getString(4);
					idclient = resultat.getInt(5);
					
					Reservation.listeReservation.add(new Reservation(idRes, dateDebut, dateFin, idchambre, idclient));
					
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
			PreparedStatement state = conn.prepareStatement("INSERT INTO reservation (datedebutoccupation, datefinoccupation, id_client, id_chambre) VALUES(?, ?, ?, ?)");
			
			state.setString(1, dateDebut);
			state.setString(2, dateFin);
			state.setInt(3, id_client);
			state.setInt(5, id_chambre);
			
			state.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Erreur lors de l'ajout d'une réservation dans la base de données");
		}
		
	}
	
	public static void recupChambreDispo() {
		Connexion con = new Connexion();
		Connection conn = con.getConn();
		
		try {
			PreparedStatement state = conn.prepareStatement("{CALL recupChambreDispo()}");
			ResultSet resultat = state.executeQuery();
			
			int id_chambre;
			int numerochambre;
			int id_typechambre;
			

			if (resultat.first()) {
				do {
					id_chambre = resultat.getInt(1);
					numerochambre = resultat.getInt(2);
					id_typechambre = resultat.getInt(3);
					
					
					Chambre.listChambreDispo.add(new Chambre(id_chambre, numerochambre, id_typechambre));
					
				} while (resultat.next());

			}
		}catch (SQLException e) {
			e.printStackTrace();
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
	
	public static void supprimerClient(int pId) {//changer en requete préparée
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