package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.BCrypt;
import model.Connexion;

public class FConnexion extends JFrame {

	private JPanel contentPane;
	public static JTextField txtIdentifiant;
	final String idtest = "admin";
	final String mdptest = "admin";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FConnexion frame = new FConnexion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	JLabel lblStatutCon = new JLabel("");
	public static JPasswordField txtMdp;
	public FConnexion() {
		String hashed = BCrypt.hashpw("dtuvdjwh", BCrypt.gensalt());//retirer
		//System.out.println(hashed); //debug
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 449, 260);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		JLabel lblConnexion = new JLabel("Connexion");
		lblConnexion.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblConnexion.setBounds(146, 13, 195, 46);
		contentPane.add(lblConnexion);
		
		JLabel lblIdentifiant = new JLabel("Identifiant : ");
		lblIdentifiant.setBounds(12, 90, 124, 16);
		contentPane.add(lblIdentifiant);
		
		txtIdentifiant = new JTextField();
		txtIdentifiant.setBounds(151, 87, 157, 22);
		contentPane.add(txtIdentifiant);
		txtIdentifiant.setColumns(10);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe : ");
		lblMotDePasse.setBounds(12, 122, 124, 16);
		contentPane.add(lblMotDePasse);
		
		
		lblStatutCon.setBounds(28, 166, 124, 16);
		contentPane.add(lblStatutCon);
		
		JButton btnValider = new JButton("Valider");
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				authentication();
			}
		});
		btnValider.setBounds(171, 152, 119, 48);
		contentPane.add(btnValider);
		
		txtMdp = new JPasswordField();
		txtMdp.setBounds(151, 119, 157, 22);
		txtMdp.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {}
			public void keyReleased(KeyEvent e) {}
			public void keyPressed(KeyEvent e) {
				if(e.getKeyChar() == KeyEvent.VK_ENTER) {
					authentication();
				}
			}
		});
		contentPane.add(txtMdp);
		
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnQuitter.setBounds(302, 152, 119, 48);
		contentPane.add(btnQuitter);
	}
	
	public void conn() {//plus utile
		if(txtIdentifiant.getText().equals("admin") && txtMdp.getPassword().equals("admin")) {
			lblStatutCon.setText("Accès autorisé");
			FAccueil acceuil = new FAccueil();
			acceuil.setVisible(true);
			setVisible(false);
		}else {
			lblStatutCon.setText("Accès refusé");
		}
	}
	
	public void authentication() {
		String loginbdd = "";
		String mdpbdd = "";
		Connexion con = new Connexion();
		Connection conn = con.getConn();
		
		try {
			Statement state = conn.createStatement();
			ResultSet result = state.executeQuery("SELECT * FROM personnel");
			
			if(result.first()) {
				do {
					loginbdd = result.getString(2);
					mdpbdd = result.getString(3);
				}while(result.next());
			}
			
			if(txtIdentifiant.getText().equals(loginbdd)) {
				if(BCrypt.checkpw(String.valueOf(txtMdp.getPassword()),mdpbdd)) {
					FAccueil fa = new FAccueil();
					fa.setVisible(true);
					dispose();
				}else {
					//mdp incorrect
					JOptionPane.showMessageDialog(contentPane, "Mot de passe incorrect", "Attention", NORMAL);
				}
			}else {
				//identifiant inconnu
				System.out.println("txt : " + txtIdentifiant.getText() + " bdd : " + String.valueOf(loginbdd));//debug
				JOptionPane.showMessageDialog(contentPane, "Identifiant inconnu", "Attention", NORMAL);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
