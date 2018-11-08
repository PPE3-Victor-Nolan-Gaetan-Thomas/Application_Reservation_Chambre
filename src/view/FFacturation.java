package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;

public class FFacturation extends JFrame {

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
	public FFacturation() {
		setBounds(100, 100, 1074, 503);
		getContentPane().setLayout(null);
		
		JLabel lblFacturation = new JLabel("Facturation : ");
		lblFacturation.setFont(new Font("Tahoma", Font.PLAIN, 38));
		lblFacturation.setBounds(12, 13, 236, 47);
		getContentPane().add(lblFacturation);
		
		JList list = new JList();
		list.setBounds(12, 61, 451, 382);
		getContentPane().add(list);
	}
}
