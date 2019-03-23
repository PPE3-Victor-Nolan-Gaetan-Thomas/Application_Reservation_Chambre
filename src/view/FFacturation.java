package view;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.toedter.calendar.JDateChooser;

import model.Client;
import model.Login;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FFacturation extends JFrame {
	private JTextField txtNom;
	private JTextField txtPrenom;
	private JTextField txtNumRes;
	private JTextField txtDureeSejour;
	private JTextField txtMail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FFacturation frame = new FFacturation();
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
	DefaultListModel DLM = new DefaultListModel();
	public FFacturation() {
		setBounds(100, 100, 638, 503);
		getContentPane().setLayout(null);
		setResizable(false);
		
		JLabel lblFacturation = new JLabel("Facturation : ");
		lblFacturation.setFont(new Font("Tahoma", Font.PLAIN, 38));
		lblFacturation.setBounds(12, 13, 236, 47);
		getContentPane().add(lblFacturation);
		
		JList list = new JList();
		list.setBounds(12, 61, 258, 382);
		getContentPane().add(list);
		
		JLabel label = new JLabel("Nom : ");
		label.setBounds(282, 67, 56, 16);
		getContentPane().add(label);
		
		txtNom = new JTextField();
		txtNom.setColumns(10);
		txtNom.setBounds(437, 61, 174, 22);
		getContentPane().add(txtNom);
		
		JLabel label_1 = new JLabel("Pr\u00E9nom : ");
		label_1.setBounds(282, 99, 73, 16);
		getContentPane().add(label_1);
		
		txtPrenom = new JTextField();
		txtPrenom.setColumns(10);
		txtPrenom.setBounds(437, 93, 174, 22);
		getContentPane().add(txtPrenom);
		
		JLabel label_2 = new JLabel("Num\u00E9ro r\u00E9servation : ");
		label_2.setBounds(282, 131, 126, 16);
		getContentPane().add(label_2);
		
		txtNumRes = new JTextField();
		txtNumRes.setColumns(10);
		txtNumRes.setBounds(437, 125, 174, 22);
		getContentPane().add(txtNumRes);
		//a faire, si on saisie le num de réservation, ca affiche les informations manquantes comme le client etc 
		
		JLabel label_3 = new JLabel("Date arriv\u00E9e : ");
		label_3.setBounds(282, 160, 126, 16);
		getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("Dur\u00E9e s\u00E9jour : ");
		label_4.setBounds(282, 192, 126, 16);
		getContentPane().add(label_4);
		
		txtDureeSejour = new JTextField();
		txtDureeSejour.setColumns(10);
		txtDureeSejour.setBounds(437, 189, 174, 22);
		getContentPane().add(txtDureeSejour);
		
		JLabel label_5 = new JLabel("Mail : ");
		label_5.setBounds(282, 224, 126, 16);
		getContentPane().add(label_5);
		
		txtMail = new JTextField();
		txtMail.setColumns(10);
		txtMail.setBounds(437, 221, 174, 22);
		getContentPane().add(txtMail);
		//a faire controle de saisie format mail
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(437, 160, 174, 22);
		getContentPane().add(dateChooser);
		
		JLabel label_6 = new JLabel("Type de chambre : ");
		label_6.setBounds(282, 259, 126, 16);
		getContentPane().add(label_6);
		
		JComboBox comboBoxTypeChambre = new JComboBox();
		comboBoxTypeChambre.setBounds(437, 256, 174, 22);
		getContentPane().add(comboBoxTypeChambre);
		
		JLabel label_7 = new JLabel("Type de r\u00E9glement : ");
		label_7.setBounds(282, 291, 126, 16);
		getContentPane().add(label_7);
		
		JComboBox comboBoxTypeReglement = new JComboBox();
		comboBoxTypeReglement.setBounds(437, 288, 174, 22);
		getContentPane().add(comboBoxTypeReglement);
		
		JButton btnValiderFacture = new JButton("Valider");
		btnValiderFacture.setBounds(294, 364, 143, 66);
		getContentPane().add(btnValiderFacture);
		
		list.setModel(DLM);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBounds(465, 364, 143, 66);
		getContentPane().add(btnSupprimer);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				FAccueil fa = new FAccueil();
				fa.setVisible(true);
			}
		});
		btnRetour.setBackground(Color.ORANGE);
		btnRetour.setBounds(493, 13, 118, 35);
		getContentPane().add(btnRetour);
		Login.recupClient();
		/*for(Client clienttmp : Login.listeClients) {
			if(clienttmp.getId_client() != "0") {
				DLM.addElement(clienttmp.getNom_client().toUpperCase() + " " + clienttmp.getPrenom_client());
			}
		}*/
		
		/*list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				txtNom.setText(Login.listeClients.get(list.getSelectedIndex()).getNom_client().toUpperCase());
				txtPrenom.setText(Login.listeClients.get(list.getSelectedIndex()).getPrenom_client());
				//txtNumRes.setText(Login.listeClients.get(list.getSelectedIndex()));
				txtMail.setText(Login.listeClients.get(list.getSelectedIndex()).getMail());
			}
		});*/
	}
}
