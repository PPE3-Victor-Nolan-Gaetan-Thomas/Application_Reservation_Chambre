package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Login;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FClient extends JFrame {

	private JPanel contentPane;
	private JTextField txtNom;
	private JTextField txtPrenom;
	private JTextField txtCP;
	private JTextField txtVille;
	private JTextField txtRue;
	private JTextField txtMail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FClient frame = new FClient();
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
	public FClient() {
		setTitle("Ajout d'un client");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 343);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAjouterUnClient = new JLabel("Ajouter un client : ");
		lblAjouterUnClient.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblAjouterUnClient.setBounds(12, 13, 209, 30);
		contentPane.add(lblAjouterUnClient);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(txtNom.getText().isEmpty() || txtPrenom.getText().isEmpty() || txtCP.getText().isEmpty() || txtVille.getText().isEmpty() || txtRue.getText().isEmpty() || txtMail.getText().isEmpty()) {
					JOptionPane.showMessageDialog(contentPane, "Veuillez remplir tout les champs", "Attention !", NORMAL);
				}else {
					Login.ajouterClient(txtNom.getText(), txtPrenom.getText(), txtCP.getText(), txtVille.getText(), txtRue.getText(), txtMail.getText());
				}
			}
		});
		btnAjouter.setBounds(329, 233, 171, 56);
		contentPane.add(btnAjouter);
		
		JLabel lblNom = new JLabel("Nom : ");
		lblNom.setBounds(12, 56, 56, 16);
		contentPane.add(lblNom);
		
		JLabel lblPrenom = new JLabel("Prenom : ");
		lblPrenom.setBounds(12, 85, 69, 16);
		contentPane.add(lblPrenom);
		
		JLabel lblCodePostal = new JLabel("Code postal : ");
		lblCodePostal.setBounds(12, 114, 80, 16);
		contentPane.add(lblCodePostal);
		
		JLabel lblVille = new JLabel("Ville : ");
		lblVille.setBounds(12, 143, 56, 16);
		contentPane.add(lblVille);
		
		JLabel lblRue = new JLabel("Rue : ");
		lblRue.setBounds(12, 172, 56, 16);
		contentPane.add(lblRue);
		
		JLabel lblMail = new JLabel("Mail : ");
		lblMail.setBounds(12, 201, 56, 16);
		contentPane.add(lblMail);
		
		txtNom = new JTextField();
		txtNom.setBounds(122, 56, 255, 22);
		contentPane.add(txtNom);
		txtNom.setColumns(10);
		
		txtPrenom = new JTextField();
		txtPrenom.setColumns(10);
		txtPrenom.setBounds(122, 82, 255, 22);
		contentPane.add(txtPrenom);
		
		txtCP = new JTextField();
		txtCP.setColumns(10);
		txtCP.setBounds(122, 111, 116, 22);
		contentPane.add(txtCP);
		
		txtVille = new JTextField();
		txtVille.setColumns(10);
		txtVille.setBounds(122, 140, 255, 22);
		contentPane.add(txtVille);
		
		txtRue = new JTextField();
		txtRue.setColumns(10);
		txtRue.setBounds(122, 169, 255, 22);
		contentPane.add(txtRue);
		
		txtMail = new JTextField();
		txtMail.setColumns(10);
		txtMail.setBounds(122, 198, 255, 22);
		contentPane.add(txtMail);
	}
}
