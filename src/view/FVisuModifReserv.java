package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import model.Login;
import model.Reservation;

public class FVisuModifReserv extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

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
	static JDateChooser dateChooser = new JDateChooser();
	static JDateChooser dateChooser_1 = new JDateChooser();
	static JComboBox comboBox = new JComboBox();
	static JButton btnModifier = new JButton("Modifier");
	static JButton btnSupprimer = new JButton("Supprimer");
	static JButton btnRetour = new JButton("Retour");
	static DefaultListModel DLM = new DefaultListModel();

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
		for(Reservation res : Reservation.listeReservation) {
		//	DLM.addElement();
		}
		list.setModel(DLM);
		
		JLabel lblModificationsuppression = new JLabel("Modification/\r\nSuppression");
		lblModificationsuppression.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblModificationsuppression.setBounds(337, 13, 233, 36);
		contentPane.add(lblModificationsuppression);
		
		JLabel label = new JLabel("Num\u00E9ro client : ");
		label.setBounds(337, 95, 143, 16);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(492, 92, 174, 22);
		contentPane.add(textField);
		
		JLabel label_1 = new JLabel("Date arriv\u00E9e : ");
		label_1.setBounds(337, 140, 126, 16);
		contentPane.add(label_1);
		
		
		dateChooser.setBounds(492, 140, 174, 22);
		contentPane.add(dateChooser);
		
		JLabel label_2 = new JLabel("Date de fin : ");
		label_2.setBounds(337, 183, 126, 16);
		contentPane.add(label_2);
		
		
		dateChooser_1.setBounds(492, 183, 174, 22);
		contentPane.add(dateChooser_1);
		
		JLabel label_3 = new JLabel("Type de chambre : ");
		label_3.setBounds(337, 234, 126, 16);
		contentPane.add(label_3);
		
		
		comboBox.setBounds(492, 231, 174, 22);
		contentPane.add(comboBox);
		
		
		btnModifier.setBounds(347, 302, 160, 59);
		contentPane.add(btnModifier);
		
		
		btnSupprimer.setBounds(519, 302, 157, 59);
		contentPane.add(btnSupprimer);
		
		
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FMenuReservation fmr = new FMenuReservation();
				fmr.setVisible(true);
				dispose();
			}
		});
		btnRetour.setBackground(Color.ORANGE);
		btnRetour.setBounds(582, 13, 97, 36);
		contentPane.add(btnRetour);
	}
}
