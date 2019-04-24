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
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.toedter.calendar.JDateChooser;

import model.Client;
import model.Login;
import model.Reservation;
import model.TypeChambre;

public class FVisuModifReserv extends JFrame {

	private JPanel contentPane;
	static JTextField txtNumClient;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FVisuModifReserv frame = new FVisuModifReserv();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	static JList list = new JList();
	static JDateChooser dtArrivee = new JDateChooser();
	static JDateChooser dtDepart = new JDateChooser();
	static JComboBox comboBoxTypeChambre = new JComboBox();
	static JButton btnModifier = new JButton("Modifier");
	static JButton btnSupprimer = new JButton("Supprimer");
	static JButton btnRetour = new JButton("Retour");
	static DefaultListModel DLM = new DefaultListModel();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	/**
	 * Create the frame.
	 */
	public FVisuModifReserv() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 706, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		list.setBounds(12, 13, 313, 367);
		contentPane.add(list);
		
		Login.recupReservation();
//		for(Reservation r : Reservation.listeReservation)
//			System.out.println(r.getidchambre());
//		Login.recupClient();
//		for(Client c : Client.listeClients)
//			System.out.println(c.getNom_client());
//		Login.recupChambre();
		for(Reservation res : Reservation.listeReservation) {
//			String nomClient = null;
//			String prenomClient = null;
//			String numRes = null;
			
			Login.recupClientWhereId(String.valueOf(res.getIdclient()));
			
			DLM.addElement(res.getIdRes() + "-" + Client.listClientTemp.get(0).getNom_client().toUpperCase() + " " + Client.listClientTemp.get(0).getPrenom_client() + " : " + res.getDateDebut() + " - " + res.getDateFin());
		}
		list.setModel(DLM);
		
		JLabel lblModificationsuppression = new JLabel("Modification/\r\nSuppression");
		lblModificationsuppression.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblModificationsuppression.setBounds(337, 13, 233, 36);
		contentPane.add(lblModificationsuppression);
		
		JLabel label = new JLabel("Num\u00E9ro client : ");
		label.setBounds(337, 95, 143, 16);
		contentPane.add(label);
		
		txtNumClient = new JTextField();
		txtNumClient.setColumns(10);
		txtNumClient.setBounds(492, 92, 174, 22);
		contentPane.add(txtNumClient);
		txtNumClient.setEnabled(false);
		
		JLabel label_1 = new JLabel("Date arriv\u00E9e : ");
		label_1.setBounds(337, 140, 126, 16);
		contentPane.add(label_1);
		
		
		dtArrivee.setBounds(492, 140, 174, 22);
		contentPane.add(dtArrivee);
		
		JLabel label_2 = new JLabel("Date de fin : ");
		label_2.setBounds(337, 183, 126, 16);
		contentPane.add(label_2);
		
		
		dtDepart.setBounds(492, 183, 174, 22);
		contentPane.add(dtDepart);
		
		JLabel label_3 = new JLabel("Type de chambre : ");
		label_3.setBounds(337, 234, 126, 16);
		contentPane.add(label_3);
		
		
		comboBoxTypeChambre.setBounds(492, 231, 174, 22);
		contentPane.add(comboBoxTypeChambre);
		Login.recupTypeChambre();
		for(TypeChambre tp : TypeChambre.listTypeChambre)
			comboBoxTypeChambre.addItem(tp.getTypeChambre());
		comboBoxTypeChambre.setSelectedItem(null);
		
		list.addListSelectionListener(new ListSelectionListener() {//TODO list
			public void valueChanged(ListSelectionEvent e) {
				if(list.getSelectedIndex()!=-1) {
					Date d = null;
					Date f = null;
//					int idtype = Login.recupTypeResByIdChambre(Integer.parseInt(Reservation.listeReservation.get(list.getSelectedIndex()).getIdRes()));
					try {
						d = sdf.parse(Reservation.listeReservation.get(list.getSelectedIndex()).getDateDebut());
						f = sdf.parse(Reservation.listeReservation.get(list.getSelectedIndex()).getDateFin());
					} catch (ParseException e1) {e1.printStackTrace();}
					
					txtNumClient.setText(Client.listClientTemp.get(0).getId_client());
					dtArrivee.setDate(d);
					dtDepart.setDate(f);
				}
			}
		});
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				if(txtNumClient.getText()!="" && dtArrivee.getDate()!=null && dtDepart.getDate()!=null) {
					if(dtArrivee.getDate().before(dtDepart.getDate())) {
						Login.modifierReservation(Reservation.listeReservation.get(list.getSelectedIndex()).getIdRes(), sdf.format(dtArrivee.getDate()), sdf.format(dtDepart.getDate()));
						JOptionPane.showMessageDialog(contentPane, "Réservation modifiée", "Information", NORMAL);
						list.clearSelection();
						FMenuReservation fmr = new FMenuReservation();
						fmr.setVisible(true);
						dispose();
						DLM.clear();
						resetChamps();
					}else {
						JOptionPane.showMessageDialog(contentPane, "Vous ne pouvez pas réserver dans le passé ...", "Attention", NORMAL);
					}
					
				}
			}
		});
		
		
		btnModifier.setBounds(347, 302, 160, 59);
		contentPane.add(btnModifier);
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(list.getSelectedIndex()!=-1) {
					int id_res_a_suppr = Reservation.listeReservation.get(list.getSelectedIndex()).getIdRes();
					Login.supprimerReservation(id_res_a_suppr);					
					JOptionPane.showMessageDialog(contentPane, "Réservation supprimée", "Information", NORMAL);
					FMenuReservation fmr = new FMenuReservation();
					fmr.setVisible(true);
					dispose();
					DLM.clear();
				}else {
					JOptionPane.showMessageDialog(contentPane, "Aucune réservation sélectionnée", "Attention", NORMAL);
				}
				
			}
		});
		
		
		btnSupprimer.setBounds(519, 302, 157, 59);
		contentPane.add(btnSupprimer);
		
		
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FMenuReservation fmr = new FMenuReservation();
				fmr.setVisible(true);
//				DLM.clear();
				dispose();
			}
		});
		btnRetour.setBackground(Color.ORANGE);
		btnRetour.setBounds(582, 13, 97, 36);
		contentPane.add(btnRetour);
		
	}
	public static void resetChamps() {
		txtNumClient.setText(null);
		dtArrivee.setDate(null);
		dtDepart.setDate(null);
		comboBoxTypeChambre.setSelectedIndex(-1);
	}
}
