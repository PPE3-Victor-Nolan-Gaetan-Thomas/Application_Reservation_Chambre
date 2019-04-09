package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import model.Login;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class Debug extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Debug frame = new Debug();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	JDateChooser dateDebut = new JDateChooser();
	JDateChooser dateFin = new JDateChooser();

	/**
	 * Create the frame.
	 */
	public Debug() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 669, 362);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnDebug = new JButton("Remplir bdd chambre");
		btnDebug.setBounds(12, 13, 243, 129);
		btnDebug.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login.remplirTypeChambreBDD();
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnDebug);
		
		JButton btnTestNbJour = new JButton("test date");
		btnTestNbJour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String message;
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				message = sdf.format(dateDebut.getDate());
				JOptionPane.showMessageDialog(contentPane, message, "test", NORMAL);
			}
		});
		
		btnTestNbJour.setBounds(267, 38, 340, 73);
		contentPane.add(btnTestNbJour);
		contentPane.add(dateDebut);
		contentPane.add(dateFin);
		dateDebut.setBounds(267, 148, 174, 22);
		dateFin.setBounds(267, 170, 174, 22);
		
	}
}
