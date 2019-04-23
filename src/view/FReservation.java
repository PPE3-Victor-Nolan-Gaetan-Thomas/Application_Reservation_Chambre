package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import model.Chambre;
import model.Login;
import model.Reservation;
import model.TypeChambre;

public class FReservation extends JFrame {

	private JPanel contentPane;
	public static boolean newClientByButtonAdd = false;
	public static boolean exist = true;
	ArrayList<String> listDateVoulu = new ArrayList<String>();
	
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
		
		//remplissage du type de chambre
		
		Login.recupTypeChambre();
		for(TypeChambre tp : TypeChambre.listTypeChambre) {
			combo_type_chambre.addItem(tp.getTypeChambre());
		}
		
		combo_type_chambre.setSelectedItem(null);
		combo_type_chambre.setBounds(167, 200, 174, 22);
		contentPane.add(combo_type_chambre);
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listDateVoulu.clear();
				Chambre.listChambreDispo.clear();

				int idtypechambre = 0;
				String datd = null;
				String datf = null;
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				
				if(combo_type_chambre.getSelectedItem().equals("Suite")) {
					idtypechambre = 1;
				}else {
					if(combo_type_chambre.getSelectedItem().equals("Suite Junior")) {
						idtypechambre = 2;
					}else {
						if(combo_type_chambre.getSelectedItem().equals("Chambre Prestige")) {
							idtypechambre = 3;
						}else {
							if(combo_type_chambre.getSelectedItem().equals("Chambre Executive")) {
								idtypechambre = 4;
							}else {
								if(combo_type_chambre.getSelectedItem().equals("Chambre Classic")){
									idtypechambre = 5;
								}else {
									if(combo_type_chambre.getSelectedItem().equals("Chambre Single")) {
										idtypechambre = 6;
									}
								}
							}
						}
					}
				}
				
				SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
				
				//try
				String d1 = sdf2.format(dateDebutSejour.getDate());
				String d2 = sdf2.format(dateFinSejour.getDate());
				
				//debug
				System.out.println("d1" + d1 + " et d2 : " + d2); //sort le bon format (anglais)
				
				Date dateDebut = null;
				Date dateFin = null;
				
				try {
					dateDebut = sdf2.parse(d1);
					dateFin = sdf2.parse(d2);
				} catch (java.text.ParseException e2) {
					e2.printStackTrace();
				}
				
				System.out.println(dateDebut);//debug
				System.out.println(dateFin);//debug
				
				
				
				if(dateDebut.before(dateFin)) {
					System.out.println("on est dans le if");//debug
					
					listDateVoulu.add(d1);
					listDateVoulu.add(d2);
					
				}else {
					JOptionPane.showMessageDialog(contentPane, "Vous ne pouvez pas réserver dans le passé ...", "Attention", NORMAL);
				}
				
				
				
				//debug
				
				System.out.println("------------ Affichage de la liste pour debug---------------");
				for(String d : listDateVoulu)
					System.out.println(d);
				
				//fin debug
				
				
				//on recherche les chambres disponibles
				Login.chambreDisponible(idtypechambre, listDateVoulu.get(0), listDateVoulu.get(listDateVoulu.size()-1));
//				System.out.println(idtypechambre);//debug
				
				//debug
				for(Chambre c : Chambre.listChambreDispo) {
					System.out.println("Chambre : "  + c.getChambreid());
				}
				//findebug
				
				
				if(!Chambre.listChambreDispo.isEmpty()) {
					if(!txtNumClient.getText().equals("") && (dateDebutSejour.getDate()!=null) && (dateFinSejour.getDate()!=null) && combo_type_chambre.getSelectedIndex()!=-1) {
						datd = listDateVoulu.get(0);
						datf = listDateVoulu.get(listDateVoulu.size()-1);
						try {
							Login.ajouterReservation(datd, datf, Integer.parseInt(txtNumClient.getText()), Chambre.listChambreDispo.get(0).getChambreid());
							JOptionPane.showMessageDialog(contentPane, "Ajout réussi", "Information", NORMAL);
							Chambre.listChambreDispo.clear();
//							Chambre.listChambreDispo.remove(0);
//							resetChamps();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}else {
						JOptionPane.showMessageDialog(contentPane, "Veuillez remplir tout les champs", "Attention", NORMAL);
					}
				}else {//ca commence la LA LISTE DES DISPO EST VIDE
					//TODO
					JOptionPane.showMessageDialog(contentPane, "Aucune chambre n'est disponible à ces dates", "Attention", NORMAL);
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
				FMenuReservation fmr = new FMenuReservation();
				fmr.setVisible(true);
				dispose();
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
	
	
	public static Calendar asCalendar(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal;
	}
	
	
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
