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

import com.toedter.calendar.JDateChooser;

import model.Client;
import model.Login;

public class FFacturation extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

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
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(437, 61, 174, 22);
		getContentPane().add(textField);
		
		JLabel label_1 = new JLabel("Pr\u00E9nom : ");
		label_1.setBounds(282, 99, 73, 16);
		getContentPane().add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(437, 93, 174, 22);
		getContentPane().add(textField_1);
		
		JLabel label_2 = new JLabel("Num\u00E9ro r\u00E9servation : ");
		label_2.setBounds(282, 131, 126, 16);
		getContentPane().add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(437, 125, 174, 22);
		getContentPane().add(textField_2);
		
		JLabel label_3 = new JLabel("Date arriv\u00E9e : ");
		label_3.setBounds(282, 160, 126, 16);
		getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("Dur\u00E9e s\u00E9jour : ");
		label_4.setBounds(282, 192, 126, 16);
		getContentPane().add(label_4);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(437, 189, 174, 22);
		getContentPane().add(textField_3);
		
		JLabel label_5 = new JLabel("Mail : ");
		label_5.setBounds(282, 224, 126, 16);
		getContentPane().add(label_5);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(437, 221, 174, 22);
		getContentPane().add(textField_4);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(437, 160, 174, 22);
		getContentPane().add(dateChooser);
		
		JLabel label_6 = new JLabel("Type de chambre : ");
		label_6.setBounds(282, 259, 126, 16);
		getContentPane().add(label_6);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(437, 256, 174, 22);
		getContentPane().add(comboBox);
		
		JLabel label_7 = new JLabel("Type de r\u00E9glement : ");
		label_7.setBounds(282, 291, 126, 16);
		getContentPane().add(label_7);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(437, 288, 174, 22);
		getContentPane().add(comboBox_1);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(382, 366, 143, 66);
		getContentPane().add(btnNewButton);
		
		list.setModel(DLM);
		Login.recupClient();
		for(Client clienttmp : Login.listeClients) {
			if(clienttmp.getId_client() != 0) {
				DLM.addElement(clienttmp.getNom_client().toUpperCase() + " " + clienttmp.getPrenom_client());
			}
		}
	}
}
