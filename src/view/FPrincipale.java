package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.regex.Pattern;

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
	private JTextField txt_nom;
	private JTextField txt_prenom;
	private JTextField txt_num_res;
	private JTextField txt_nb_jour_res;
	private JTextField txt_mail;
	public ArrayList<Client> listReservation = new ArrayList<Client>();

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
	DefaultListModel DLM = new DefaultListModel();
	
	
	//Fin d'instantiation des composants

	/**
	 * Create the frame.
	 */
	public FPrincipale() {
		setTitle("R\u00E9servation chambre");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1074, 503);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		list.setModel(DLM);
		
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
		txt_num_res.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();
		        if (!((c >= '0') && (c <= '9') ||
		           (c == KeyEvent.VK_BACK_SPACE) ||
		           (c == KeyEvent.VK_DELETE))) {
		          getToolkit().beep();
		          e.consume();
		        }
		      }
		    });
		contentPane.add(txt_num_res);
		
		lblDate.setBounds(12, 203, 126, 16);
		contentPane.add(lblDate);
		
		lblNbJourRes.setBounds(12, 235, 126, 16);
		contentPane.add(lblNbJourRes);
		
		txt_nb_jour_res = new JTextField();
		txt_nb_jour_res.setColumns(10);
		txt_nb_jour_res.setBounds(167, 232, 174, 22);
		txt_nb_jour_res.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();
		        if (!((c >= '0') && (c <= '9') ||
		           (c == KeyEvent.VK_BACK_SPACE) ||
		           (c == KeyEvent.VK_DELETE))) {
		          getToolkit().beep();
		          e.consume();
		        }
		      }
		    });
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
	//	date.setDateFormatString("dd/MM/yyyy");
		
		combo_type_chambre.addItem("Suite");
		combo_type_chambre.addItem("Suite Junior");
		combo_type_chambre.addItem("Prestige");
		combo_type_chambre.addItem("Executive");
		combo_type_chambre.addItem("Classic");
		combo_type_chambre.addItem("Single");
		combo_type_chambre.setSelectedItem(null);
		combo_type_chambre.setBounds(167, 299, 174, 22);
		contentPane.add(combo_type_chambre);
		
		combo_reglement.addItem("Carte bancaire");
		combo_reglement.addItem("Espèce");
		combo_reglement.addItem("Chèque");
		combo_reglement.setSelectedItem(null);
		combo_reglement.setBounds(167, 331, 174, 22);
		contentPane.add(combo_reglement);
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(txt_nom.getText()==null || txt_prenom.getText()==null || txt_mail.getText() == null || txt_nb_jour_res.getText() == null || txt_num_res.getText() == null || combo_reglement.getSelectedIndex() == -1 || combo_type_chambre.getSelectedIndex() == -1 || date.getDate() == null) {
					JOptionPane.showMessageDialog(contentPane, "Vous devez remplir tout les champs", "Attention", NORMAL);
				}else {
					if (!(Pattern.matches("^[a-zA-Z0-9]+[@]{1}+[a-zA-Z0-9]+[.]{1}+[a-zA-Z0-9]+$", txt_mail.getText()))) //rajouter +[.]{1}+ ??
					{ 
						JOptionPane.showMessageDialog(contentPane, "Veuillez entrer un email valide", "Error", JOptionPane.ERROR_MESSAGE); 
					}else {
						java.util.Date jud = date.getDate();
						java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
						ajouterReservation(txt_nom.getText(), txt_prenom.getText(), txt_num_res.getText(), sdf.format(jud), txt_nb_jour_res.getText(), txt_mail.getText(), combo_type_chambre.getSelectedItem().toString(), combo_reglement.getSelectedItem().toString());
						resetChamps();
					}
					
				}
				
				
			}
		});
		
		btnValider.setBounds(12, 384, 126, 59);
		contentPane.add(btnValider);
		
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				resetChamps();
			}
		});
		btnAnnuler.setBounds(167, 384, 126, 59);
		contentPane.add(btnAnnuler);
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(list.getSelectedIndex() == -1) {}else {
					if(JOptionPane.showConfirmDialog(contentPane, "Etes-vous sur de vouloir supprimer cette réservation ?") == JOptionPane.YES_OPTION) {
						DLM.removeElementAt(list.getSelectedIndex());
					}
					
				}
				
			}
		});
		
		btnSupprimer.setBounds(321, 384, 126, 59);
		contentPane.add(btnSupprimer);
		
		list.setBounds(497, 41, 547, 402);
		contentPane.add(list);
		
		
		
		
		
	}
	
	public void resetChamps() {
		txt_nom.setText(null);
		txt_prenom.setText(null);
		txt_num_res.setText(null);
		txt_nb_jour_res.setText(null);
		txt_mail.setText(null);
		date.setDate(null);
		combo_type_chambre.setSelectedItem(null);
		combo_reglement.setSelectedItem(null);
	}
	
	public void ajouterReservation(String pNom, String pPrenom, String pNumeroReservation, String dateArrivee, String dureeSejour, String mail, String typeChambre, String typeReglement) {
		DLM.addElement(pNom + " " + pPrenom + " | " + pNumeroReservation + " | " + dateArrivee + " | " + dureeSejour + " | " + mail + " | " + typeChambre + " | " + typeReglement);
	}
	
	
	
}
