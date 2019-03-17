package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class FMenuClient extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FMenuClient frame = new FMenuClient();
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
	public FMenuClient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 467, 274);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblClient = new JLabel("Client");
		lblClient.setFont(new Font("Tahoma", Font.PLAIN, 48));
		lblClient.setBounds(147, 13, 130, 43);
		contentPane.add(lblClient);
		
		JButton btnNewButton = new JButton("Ajouter client");
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				FClient fc = new FClient();
				fc.setVisible(true);
			}
		});
		btnNewButton.setBounds(12, 85, 206, 129);
		contentPane.add(btnNewButton);
		
		JButton btnSupprimerClient = new JButton("Supprimer/modifier client");
		btnSupprimerClient.setBackground(Color.YELLOW);
		btnSupprimerClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				FRetirerClient frc = new FRetirerClient();
				frc.setVisible(true);
			}
		});
		btnSupprimerClient.setBounds(231, 85, 206, 129);
		contentPane.add(btnSupprimerClient);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				FAccueil fa = new FAccueil();
				fa.setVisible(true);
			}
		});
		btnRetour.setBackground(Color.ORANGE);
		btnRetour.setBounds(340, 13, 97, 43);
		contentPane.add(btnRetour);
	}
}
