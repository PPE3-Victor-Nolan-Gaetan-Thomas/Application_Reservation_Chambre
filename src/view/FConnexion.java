package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class FConnexion extends JFrame {

	private JPanel contentPane;
	private JTextField txtIdentifiant;
	private JTextField txtMdp;
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
	public FConnexion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 449, 260);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		
		txtMdp = new JTextField();
		txtMdp.setColumns(10);
		txtMdp.setBounds(151, 119, 157, 22);
		txtMdp.addKeyListener(new KeyListener() {

			
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					conn();
				}
				
			}
			public void keyReleased(KeyEvent e) {}
			public void keyTyped(KeyEvent e) {}
			
		});
		contentPane.add(txtMdp);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe : ");
		lblMotDePasse.setBounds(12, 122, 124, 16);
		contentPane.add(lblMotDePasse);
		
		
		lblStatutCon.setBounds(101, 165, 124, 16);
		contentPane.add(lblStatutCon);
		
		JButton btnValider = new JButton("Valider");
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				conn();
			}
		});
		btnValider.setBounds(300, 154, 119, 48);
		contentPane.add(btnValider);
	}
	
	public void conn() {
		if(txtIdentifiant.getText().equals("admin") && txtMdp.getText().equals("admin")) {
			lblStatutCon.setText("Accès autorisé");
			FAccueil acceuil = new FAccueil();
			acceuil.setVisible(true);
			setVisible(false);
		}else {
			lblStatutCon.setText("Accès refusé");
		}
	}

}
