package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import model.Client;
import model.Login;

public class FPrincipale extends JFrame {

	private JPanel contentPane;
	public static boolean newClientByButtonAdd = false;
	public static boolean exist = true;
	
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
	JLabel lblNumClient = new JLabel("Num\u00E9ro client : ");
	JLabel lblDate = new JLabel("Date arriv\u00E9e : ");
	JLabel lblDateFin = new JLabel("Date de fin : ");
	JLabel lbl_reglement = new JLabel("Type de r\u00E9glement : ");
	JLabel type_chambre = new JLabel("Type de chambre : ");
	JDateChooser dateDebutSejour = new JDateChooser();
	JDateChooser dateFinSejour = new JDateChooser();
	JComboBox combo_type_chambre = new JComboBox();
	JComboBox combo_reglement = new JComboBox();
	JButton btnValider = new JButton("Valider");
	JButton btnAnnuler = new JButton("Annuler");
	DefaultListModel DLM = new DefaultListModel();
	private final JButton btnRetour = new JButton("Retour");
	private static JTextField txtNumClient;
	
	
	//Fin d'instantiation des composants

	/**
	 * Create the frame.
	 */
	public FPrincipale() {
		setTitle("R\u00E9servation chambre");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 468, 386);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		 System.out.println(Login.recupNombbreClient());//debug
		
		lblRservation.setFont(new Font("Tahoma", Font.PLAIN, 38));
		lblRservation.setBounds(12, 13, 235, 48);
		contentPane.add(lblRservation);
		
		lblNumClient.setBounds(12, 110, 143, 16);
		contentPane.add(lblNumClient);
		
		lblDate.setBounds(12, 139, 126, 16);
		contentPane.add(lblDate);
		
		lblDateFin.setBounds(12, 171, 126, 16);
		contentPane.add(lblDateFin);
		
		lbl_reglement.setBounds(12, 235, 126, 16);
		contentPane.add(lbl_reglement);
		
		type_chambre.setBounds(12, 203, 126, 16);
		contentPane.add(type_chambre);
		
		contentPane.add(dateDebutSejour);
		dateDebutSejour.setBounds(167,  139, 174, 22);
		
		combo_type_chambre.addItem("Suite");
		combo_type_chambre.addItem("Suite Junior");
		combo_type_chambre.addItem("Prestige");
		combo_type_chambre.addItem("Executive");
		combo_type_chambre.addItem("Classic");
		combo_type_chambre.addItem("Single");
		combo_type_chambre.setSelectedItem(null);
		combo_type_chambre.setBounds(167, 200, 174, 22);
		contentPane.add(combo_type_chambre);
		
		combo_reglement.addItem("Carte bancaire");
		combo_reglement.addItem("Espèce");
		combo_reglement.addItem("Chèque");
		combo_reglement.setSelectedItem(null);
		combo_reglement.setBounds(167, 232, 174, 22);
		contentPane.add(combo_reglement);
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login.recupIdClients();
				
				if(dateFinSejour.getDate() == null || txtNumClient.getText() == null || combo_reglement.getSelectedIndex() == -1 || combo_type_chambre.getSelectedIndex() == -1 || dateDebutSejour.getDate() == null) {
					JOptionPane.showMessageDialog(contentPane, "Vous devez remplir tout les champs", "Attention", NORMAL);
				}else {
					for(String str : Login.listeNumClient) {
						if(!str.equals(txtNumClient.getText())) {
							exist = false;
							System.out.println("Client inconnu");//debug
						}else {
							exist = true;
							java.util.Date jud = dateDebutSejour.getDate();
							java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
							Login.ajouterReservation(Integer.valueOf(dateFinSejour.getDateFormatString()), String.valueOf(sdf.format(jud)), String.valueOf(combo_type_chambre.getSelectedItem()), String.valueOf(combo_reglement.getSelectedItem()), Integer.valueOf(txtNumClient.getText()));
							break;
						}
					}
					
					if(exist == false) {
						JOptionPane.showMessageDialog(contentPane, "Client inconnu", "Attention", NORMAL);
					}else {
						resetChamps();
					}
					
					
				}
				
				
			}
		});
		
		btnValider.setBounds(12, 279, 203, 59);
		contentPane.add(btnValider);
		
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				resetChamps();
			}
		});
		btnAnnuler.setBounds(244, 279, 203, 59);
		contentPane.add(btnAnnuler);
		
		JButton btnNouveauClient = new JButton("...");
		btnNouveauClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				newClientByButtonAdd = true;
				FClient fc = new FClient();
				fc.setVisible(true);
			}
		});
		btnNouveauClient.setBounds(350, 106, 32, 25);
		contentPane.add(btnNouveauClient);
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				FAccueil fa = new FAccueil();
				fa.setVisible(true);
			}
		});
		btnRetour.setBackground(Color.ORANGE);
		btnRetour.setBounds(321, 26, 126, 35);
		
		contentPane.add(btnRetour);
		
		txtNumClient = new JTextField();
		txtNumClient.setBounds(167, 107, 174, 22);
		contentPane.add(txtNumClient);
		txtNumClient.setColumns(10);
		
		
		dateFinSejour.setBounds(167, 171, 174, 22);
		contentPane.add(dateFinSejour);
		
		
	}
	
	public void resetChamps() {
		txtNumClient.setText(null);
		dateFinSejour.setDate(null);
		dateDebutSejour.setDate(null);
		combo_type_chambre.setSelectedItem(null);
		combo_reglement.setSelectedItem(null);
	}

	public void setNewClientByButtonAdd(boolean newClientByButtonAdd) {
		this.newClientByButtonAdd = newClientByButtonAdd;
	}
	
	public static void setTxtIdClient(String pIdClient) {
		txtNumClient.setText(pIdClient);
	}
}
