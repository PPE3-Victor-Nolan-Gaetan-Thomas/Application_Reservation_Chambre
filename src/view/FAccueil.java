package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class FAccueil extends JFrame {

	private JPanel contentPane;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FAccueil frame = new FAccueil();
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
	public FAccueil() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 429, 331);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblConnexion = new JLabel("Menu principal");
		lblConnexion.setFont(new Font("Tahoma", Font.BOLD, 37));
		lblConnexion.setBounds(60, 0, 297, 74);
		contentPane.add(lblConnexion);
		
		JButton btsResChambreMenu = new JButton("R\u00E9servation chambre");
		btsResChambreMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FPrincipale fprincipal = new FPrincipale();
				setVisible(false);
				fprincipal.setVisible(true);
			}
		});
		btsResChambreMenu.setBounds(24, 87, 172, 105);
		contentPane.add(btsResChambreMenu);
		
		JButton btnFacturationMenu = new JButton("Facturation");
		btnFacturationMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FFacturation ffac = new FFacturation();
				setVisible(false);
				ffac.setVisible(true);
			}
		});
		btnFacturationMenu.setBounds(222, 87, 172, 105);
		contentPane.add(btnFacturationMenu);
		
		JButton btnRetourCon = new JButton("D\u00E9connexion");
		btnRetourCon.setIcon(new ImageIcon("..\\..\\PPE3\\Application_Reservation_Chambre\\img\\exit.jpg"));
		btnRetourCon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				FConnexion fcon = new FConnexion();
				fcon.setVisible(true);
			}
		});
		btnRetourCon.setBounds(24, 205, 370, 66);
		contentPane.add(btnRetourCon);
	}
}
