package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Connexion {
    //Déclaration des attributs
    private String nomBDD, login, mdp, url;
    private Connection conn;
   // private static Connection connDAO;
    private ResultSet result;
    private Statement state;
    
    //Déclaration d'un constructeur d'objet ConnexionSQL
    public Connexion(String pNomBDD, String pLogin, String pMdp, String pUrl) {
        this.nomBDD = pNomBDD;
        this.login = pLogin;
        this.mdp = pMdp;
        this.url = pUrl;
    }
    
    public Connexion() {
        this.nomBDD = "eastmaster";
        this.login = "root";
        this.mdp = "";
        this.url = "127.0.0.1";
        
        // Ici, la bdd est en local donc pas de danger. Par contre, si on est en prod, remove les identifiants pour les mettre dans un autre fichier (pour Github)
        
        this.SeConnecter();
    }
    

    
    //Méthode permettant la connexion au serveur
    public void SeConnecter(){
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
            } catch (InstantiationException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("Driver O.K.");

            String chemin = "jdbc:mysql://" + this.url + "/" + this.nomBDD;
            
             //conn = DriverManager.getConnection(chemin + "?user=" + this.login + "&password=" + this.mdp);
            conn = DriverManager.getConnection(chemin, this.login, this.mdp);
            
            System.out.println("Connexion effective !");    
        } 
        catch (SQLException  ex) {
            Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Méthode qui execute la requête passé en paramètre retournant un résultat de requête
    public ResultSet requeteRetourneDonnees(String pRequete) throws SQLException{
        //Création d'un objet Statement
        state = conn.createStatement(); 
        //L'objet ResultSet contient le résultat de la requête SQL
        result = state.executeQuery(pRequete);
        //On récupère les MetaData
        
        return result;
    }    
    
    //requete executant une requete sans retour (UPDATE,INSERT..)
    public void requeteSansDonnes(String pRequete) throws SQLException{
        //Création d'un objet Statement
        Statement state = conn.createStatement();
        //L'objet ResultSet contient le résultat de la requête SQL
        state.execute(pRequete);
        state.close();
    }
    
    //Méthode fermant la connexion au serveur
    public void fermerConnexion() throws SQLException{
        state.close();
        result.close();
    }
    
    public Connection getConn() {
    	return this.conn;
    }

}
    


