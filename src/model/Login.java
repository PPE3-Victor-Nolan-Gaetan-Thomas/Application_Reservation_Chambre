package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Login {
	public static ArrayList<Client> listeClients = new ArrayList<Client>();
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

			if (resultat.first()) {
				do {
					id_Client = resultat.getInt(1);
					nom_Client = resultat.getString(2);
					prenom_Client = resultat.getString(3);
					adresseCP_Client = resultat.getString(4);
					adresseVille_Client = resultat.getString(5);
					adresseRue_Client = resultat.getString(6);
					
					listeClients.add(new Client(id_Client, nom_Client, prenom_Client, adresseCP_Client, adresseVille_Client, adresseRue_Client));
					
				} while (resultat.next());

			}
			//con.fermerConnexion();

		} catch (SQLException e) {
			e.printStackTrace();
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