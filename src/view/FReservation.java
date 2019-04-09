package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import model.Login;
import model.TypeChambre;

public class FReservation extends JFrame {

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
					FReservation frame = new FReservation();
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
	JLabel type_chambre = new JLabel("Type de chambre : ");
	JDateChooser dateDebutSejour = new JDateChooser();
	JDateChooser dateFinSejour = new JDateChooser();
	JComboBox combo_type_chambre = new JComboBox();
	JButton btnValider = new JButton("Valider");
	JButton btnAnnuler = new JButton("Annuler");
	DefaultListModel DLM = new DefaultListModel();
	private final JButton btnRetour = new JButton("Retour");
	private static JTextField txtNumClient;
	
	
	//Fin d'instantiation des composants

	/**
	 * Create the frame.
	 */
	public FReservation() {
		setTitle("R\u00E9servation chambre");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 468, 339);
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
		
		type_chambre.setBounds(12, 203, 126, 16);
		contentPane.add(type_chambre);
		
		contentPane.add(dateDebutSejour);
		dateDebutSejour.setBounds(167,  139, 174, 22);
		
		//goto insert
		
		//remplirChampsTypeChambre();
		
		//TEMPORAIRE
		/*
		combo_type_chambre.addItem("Suite");
		combo_type_chambre.addItem("Suite Junior");
		combo_type_chambre.addItem("Prestige");
		combo_type_chambre.addItem("Executive");
		combo_type_chambre.addItem("Classic");
		combo_type_chambre.addItem("Single");
		*/
		
		Login.recupTypeChambre();
		for(TypeChambre tp : TypeChambre.listTypeChambre) {
			combo_type_chambre.addItem(tp.getTypeChambre());
		}
		
		combo_type_chambre.setSelectedItem(null);
		combo_type_chambre.setBounds(167, 200, 174, 22);
		contentPane.add(combo_type_chambre);
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//TODO
				//recupérer tout les numéros de chambres du type demandé
				//ensuite vérifier si elles sont disponibles avec une boucle
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String deb = sdf.format(dateDebutSejour.getDate());
				String fin = sdf.format(dateFinSejour.getDate());
				try {
					Date d = sdf.parse(deb);
					Date f = sdf.parse(fin);
					Login.estDisponible(0, d, f);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				
			}
		});
		
		btnValider.setBounds(12, 232, 203, 59);
		contentPane.add(btnValider);
		
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				resetChamps();
			}
		});
		btnAnnuler.setBounds(244, 232, 203, 59);
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
				FMenuReservation fmr = new FMenuReservation();
				fmr.setVisible(true);
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
	
	/*public void remplirChampsTypeChambre() {//goto
		Login.listInfoChambres.clear();
		Login.recupChambre();
		int nbChambresRestantes = 0;
		if(TypeChambre.listTypeChambre.get(0).getNbChambresRestantes() != 0) {
			System.out.println("Suite" + TypeChambre.listTypeChambre.get(0).getNbChambresRestantes());//debug
			combo_type_chambre.addItem("Suite (" + TypeChambre.listTypeChambre.get(0).getNbChambresRestantes() + ")");
		}else {
			System.err.println("INFORMATION : euh y a plus de place sorry (suite)");//debug
		}
		
		if(TypeChambre.listTypeChambre.get(1).getNbChambresRestantes() != 0) {
			System.out.println("Suite junior" + TypeChambre.listTypeChambre.get(1).getNbChambresRestantes());//debug
			combo_type_chambre.addItem("Suite junior (" + TypeChambre.listTypeChambre.get(1).getNbChambresRestantes() + ")");
		}else {
			System.err.println("INFORMATION : euh y a plus de place sorry (suite junior)");//debug
		}
		
		if(TypeChambre.listTypeChambre.get(2).getNbChambresRestantes() != 0) {
			System.out.println("Chambre prestige" + TypeChambre.listTypeChambre.get(2).getNbChambresRestantes());//debug
			combo_type_chambre.addItem("Chambre prestige (" + TypeChambre.listTypeChambre.get(2).getNbChambresRestantes() + ")");
		}else {
			System.err.println("INFORMATION : euh y a plus de place sorry (Chambre prestige)");//debug
		}
		
		if(TypeChambre.listTypeChambre.get(3).getNbChambresRestantes() != 0) {
			System.out.println("Chambre executive" + TypeChambre.listTypeChambre.get(3).getNbChambresRestantes());//debug
			combo_type_chambre.addItem("Chambre executive (" + TypeChambre.listTypeChambre.get(3).getNbChambresRestantes() + ")");
		}else {
			System.err.println("INFORMATION : euh y a plus de place sorry (Chambre executive)");//debug
		}
		
		if(TypeChambre.listTypeChambre.get(4).getNbChambresRestantes() != 0) {
			System.out.println("Chambre classique" + TypeChambre.listTypeChambre.get(4).getNbChambresRestantes());//debug
			combo_type_chambre.addItem("Chambre classique (" + TypeChambre.listTypeChambre.get(4).getNbChambresRestantes() + ")");
		}else {
			System.err.println("INFORMATION : euh y a plus de place sorry (Chambre classique)");//debug
		}
		
		if(TypeChambre.listTypeChambre.get(5).getNbChambresRestantes() != 0) {
			System.out.println("Chambre single" + TypeChambre.listTypeChambre.get(5).getNbChambresRestantes());//debug
			combo_type_chambre.addItem("Chambre single (" + TypeChambre.listTypeChambre.get(5).getNbChambresRestantes() + ")");
		}else {
			System.err.println("INFORMATION : euh y a plus de place sorry (Chambre single)");//debug
		}
		
	}*/
	
	public void resetChamps() {
		txtNumClient.setText(null);
		dateFinSejour.setDate(null);
		dateDebutSejour.setDate(null);
		combo_type_chambre.setSelectedItem(null);
	}

	public void setNewClientByButtonAdd(boolean newClientByButtonAdd) {
		this.newClientByButtonAdd = newClientByButtonAdd;
	}
	
	public static void setTxtIdClient(String pIdClient) {
		txtNumClient.setText(pIdClient);
	}
}
