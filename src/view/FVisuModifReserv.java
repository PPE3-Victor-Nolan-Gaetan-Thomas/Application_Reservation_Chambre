package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.Font;

public class FVisuModifReserv extends JFrame {

	private JPanel contentPane;

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
		
		JLabel lblModificationsuppression = new JLabel("Modification/suppression");
		lblModificationsuppression.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblModificationsuppression.setBounds(388, 13, 252, 36);
		contentPane.add(lblModificationsuppression);
	}
}
