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

public class FMenuReservation extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FMenuReservation frame = new FMenuReservation();
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
	public FMenuReservation() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 470, 318);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMenuRservation = new JLabel("Menu R\u00E9servation");
		lblMenuRservation.setFont(new Font("Tahoma", Font.PLAIN, 48));
		lblMenuRservation.setBounds(39, 13, 398, 58);
		contentPane.add(lblMenuRservation);
		
		JButton btnVisuReservation = new JButton("Visualiser/modifier");
		btnVisuReservation.setBackground(Color.YELLOW);
		btnVisuReservation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FVisuModifReserv fvmr = new FVisuModifReserv();
				setVisible(false);
				fvmr.setVisible(true);
			}
		});
		btnVisuReservation.setBounds(236, 84, 201, 115);
		contentPane.add(btnVisuReservation);
		
		JButton btnAjouterReservation = new JButton("Ajouter");
		btnAjouterReservation.setBackground(Color.GREEN);
		btnAjouterReservation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FReservation fp = new FReservation();
				setVisible(false);
				fp.setVisible(true);
			}
		});
		btnAjouterReservation.setBounds(23, 84, 201, 115);
		contentPane.add(btnAjouterReservation);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FAccueil fa = new FAccueil();
				fa.setVisible(true);
				dispose();
			}
		});
		btnRetour.setBackground(Color.ORANGE);
		btnRetour.setBounds(23, 216, 414, 42);
		contentPane.add(btnRetour);
	}
}
