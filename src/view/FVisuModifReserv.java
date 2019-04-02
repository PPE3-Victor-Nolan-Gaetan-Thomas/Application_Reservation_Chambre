package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;

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
		
		JList list = new JList();
		list.setBounds(12, 13, 313, 367);
		contentPane.add(list);
		
		JLabel lblModificationsuppression = new JLabel("Modification/\r\nSuppression");
		lblModificationsuppression.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblModificationsuppression.setBounds(374, 13, 292, 36);
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
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(492, 140, 174, 22);
		contentPane.add(dateChooser);
		
		JLabel label_2 = new JLabel("Date de fin : ");
		label_2.setBounds(337, 183, 126, 16);
		contentPane.add(label_2);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(492, 183, 174, 22);
		contentPane.add(dateChooser_1);
		
		JLabel label_3 = new JLabel("Type de chambre : ");
		label_3.setBounds(337, 234, 126, 16);
		contentPane.add(label_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(492, 231, 174, 22);
		contentPane.add(comboBox);
	}
}
