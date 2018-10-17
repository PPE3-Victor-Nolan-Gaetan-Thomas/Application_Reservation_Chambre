package view;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FPrincipale extends JFrame {

	private JPanel contentPane;
	private JTextField txt_nom;
	private JTextField txt_prenom;
	private JTextField txt_num_res;
	private JTextField txt_nb_jour_res;
	private JTextField txt_mail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FPrincipale frame = new FPrincipale();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	//Instanciation de tout les composants
	JLabel lblRservation = new JLabel("R\u00E9servation : ");
	JLabel lblNom = new JLabel("Nom : ");
	JLabel lblPrenom = new JLabel("Pr\u00E9nom : ");
	JLabel lblNumRes = new JLabel("Num\u00E9ro r\u00E9servation : ");
	JLabel lblDate = new JLabel("Date arriv\u00E9e : ");
	JLabel lblNbJourRes = new JLabel("Dur\u00E9e s\u00E9jour : ");
	JLabel lbl_reglement = new JLabel("Type de r\u00E9glement : ");
	JLabel lblMail = new JLabel("Mail : ");
	JLabel type_chambre = new JLabel("Type de chambre : ");
	JDateChooser date = new JDateChooser();
	JComboBox combo_type_chambre = new JComboBox();
	JComboBox combo_reglement = new JComboBox();
	JButton btnValider = new JButton("Valider");
	JButton btnAnnuler = new JButton("Annuler");
	JButton btnSupprimer = new JButton("Supprimer");
	JList list = new JList();
	
	
	//Fin d'instantiation des composants

	/**
	 * Create the frame.
	 */
	public FPrincipale() {
		setTitle("R\u00E9servation chambre");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 890, 503);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		lblRservation.setFont(new Font("Tahoma", Font.PLAIN, 38));
		lblRservation.setBounds(12, 13, 235, 48);
		contentPane.add(lblRservation);
		
		lblNom.setBounds(12, 110, 56, 16);
		contentPane.add(lblNom);
		
		txt_nom = new JTextField();
		txt_nom.setBounds(167, 104, 174, 22);
		contentPane.add(txt_nom);
		txt_nom.setColumns(10);
		
		lblPrenom.setBounds(12, 142, 73, 16);
		contentPane.add(lblPrenom);
		
		txt_prenom = new JTextField();
		txt_prenom.setColumns(10);
		txt_prenom.setBounds(167, 136, 174, 22);
		contentPane.add(txt_prenom);
		
		lblNumRes.setBounds(12, 174, 126, 16);
		contentPane.add(lblNumRes);
		
		txt_num_res = new JTextField();
		txt_num_res.setColumns(10);
		txt_num_res.setBounds(167, 168, 174, 22);
		contentPane.add(txt_num_res);
		
		lblDate.setBounds(12, 203, 126, 16);
		contentPane.add(lblDate);
		
		lblNbJourRes.setBounds(12, 235, 126, 16);
		contentPane.add(lblNbJourRes);
		
		txt_nb_jour_res = new JTextField();
		txt_nb_jour_res.setColumns(10);
		txt_nb_jour_res.setBounds(167, 232, 174, 22);
		contentPane.add(txt_nb_jour_res);
		
		lbl_reglement.setBounds(12, 334, 126, 16);
		contentPane.add(lbl_reglement);
		
		lblMail.setBounds(12, 267, 126, 16);
		contentPane.add(lblMail);
		
		txt_mail = new JTextField();
		txt_mail.setColumns(10);
		txt_mail.setBounds(167, 264, 174, 22);
		contentPane.add(txt_mail);
		
		type_chambre.setBounds(12, 302, 126, 16);
		contentPane.add(type_chambre);
		
		contentPane.add(date);
		date.setBounds(167,  203, 174, 22);
		
		combo_type_chambre.setBounds(167, 299, 174, 22);
		contentPane.add(combo_type_chambre);
		
		combo_reglement.setBounds(167, 331, 174, 22);
		contentPane.add(combo_reglement);
		
		btnValider.setBounds(12, 384, 126, 59);
		contentPane.add(btnValider);
		
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txt_nom.setText(null);
				txt_prenom.setText(null);
				txt_num_res.setText(null);
				txt_nb_jour_res.setText(null);
				txt_mail.setText(null);
				date.setDate(null);
				combo_type_chambre.setSelectedItem(null);
				combo_reglement.setSelectedItem(null);
			}
		});
		btnAnnuler.setBounds(167, 384, 126, 59);
		contentPane.add(btnAnnuler);
		
		btnSupprimer.setBounds(321, 384, 126, 59);
		contentPane.add(btnSupprimer);
		
		list.setBounds(497, 13, 363, 430);
		contentPane.add(list);
		
		
		
	}
}
