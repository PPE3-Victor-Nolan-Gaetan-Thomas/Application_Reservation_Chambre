package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.MaskFormatter;

import model.Client;
import model.Login;

public class FRetirerClient extends JFrame {

	private JPanel contentPane;
	private JTextField txtNom;
	private JTextField txtPrenom;
	private JTextField txtCP;
	private JTextField txtVille;
	private JTextField txtRue;
	private JTextField txtMail;
	static DefaultListModel DLM = new DefaultListModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FRetirerClient frame = new FRetirerClient();
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
	public FRetirerClient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 682, 399);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();//ajout
		JList list = new JList();
		scrollPane.setViewportView(list);//ajout
		contentPane.add(scrollPane);
		scrollPane.setBounds(12, 13, 311, 322);
		list.setBounds(12, 13, 311, 322);
		//contentPane.add(list);
		list.setModel(DLM);
		JLabel lblNom = new JLabel("Nom : ");
		lblNom.setBounds(335, 79, 56, 16);
		contentPane.add(lblNom);
		
		JLabel lblPrenom = new JLabel("Prenom : ");
		lblPrenom.setBounds(335, 108, 69, 16);
		contentPane.add(lblPrenom);
		
		JLabel lblId = new JLabel("Id : ");
		lblId.setBounds(335, 55, 56, 16);
		contentPane.add(lblId);
		
		JLabel lblIdAffichage = new JLabel("");
		lblIdAffichage.setBounds(426, 55, 56, 16);
		contentPane.add(lblIdAffichage);
		
		JLabel lblCodePostal = new JLabel("Code postal : ");
		lblCodePostal.setBounds(335, 137, 80, 16);
		contentPane.add(lblCodePostal);
		
		JLabel lblVille = new JLabel("Ville : ");
		lblVille.setBounds(335, 166, 56, 16);
		contentPane.add(lblVille);
		
		JLabel lblRue = new JLabel("Rue : ");
		lblRue.setBounds(335, 195, 56, 16);
		contentPane.add(lblRue);
		
		JLabel lblMail = new JLabel("Mail  : ");
		lblMail.setBounds(335, 224, 56, 16);
		contentPane.add(lblMail);
		
		txtNom = new JTextField();
		txtNom.setBounds(426, 76, 226, 22);
		contentPane.add(txtNom);
		txtNom.setColumns(10);
		
		txtPrenom = new JTextField();
		txtPrenom.setColumns(10);
		txtPrenom.setBounds(426, 105, 226, 22);
		contentPane.add(txtPrenom);
		
		loadProfile();
		
		txtCP = new JTextField();
		txtCP.setColumns(10);
		txtCP.setBounds(426, 134, 88, 22);
        
		
		contentPane.add(txtCP);
		txtCP.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();
		        if (!((c >= '0') && (c <= '9') ||
		           (c == KeyEvent.VK_BACK_SPACE) ||
		           (c == KeyEvent.VK_DELETE)) && txtCP.getText().length() <=5) {
		          getToolkit().beep();
		          e.consume();
		        }
		      }
		    });
		
		txtVille = new JTextField();
		txtVille.setColumns(10);
		txtVille.setBounds(426, 163, 226, 22);
		contentPane.add(txtVille);
		
		txtRue = new JTextField();
		txtRue.setColumns(10);
		txtRue.setBounds(426, 192, 226, 22);
		contentPane.add(txtRue);
		
		txtMail = new JTextField();
		txtMail.setColumns(10);
		txtMail.setBounds(426, 221, 226, 22);
		contentPane.add(txtMail);
		
		JLabel lblInformations = new JLabel("Informations : ");
		lblInformations.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblInformations.setBounds(335, 14, 317, 33);
		contentPane.add(lblInformations);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.setBounds(335, 256, 147, 79);
		contentPane.add(btnModifier);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!list.isSelectionEmpty()) {
					if(JOptionPane.showConfirmDialog(contentPane, "Etes-vous sur de vouloir supprimer cette réservation ?") == JOptionPane.YES_OPTION) {
						
						Login.supprimerClient(Integer.parseInt(lblIdAffichage.getText()));
						Login.listeClients.clear();
						list.setModel(new DefaultListModel());
						DLM.clear();
						loadProfile();
						list.setModel(DLM);
						
						/*Login.listeClients.clear();
						dispose();
						FRetirerClient frc = new FRetirerClient();
						frc.setVisible(true);*/
						
						
						//DLM.removeElementAt(list.getSelectedIndex());
						
					}
				}
			}
		});
		btnSupprimer.setBounds(505, 256, 147, 79);
		contentPane.add(btnSupprimer);
		
		JButton button = new JButton("Retour");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FMenuClient fmc = new FMenuClient();
				fmc.setVisible(true);
				dispose();
			}
		});
		button.setBackground(Color.ORANGE);
		button.setBounds(559, 13, 97, 43);
		contentPane.add(button);
		
		
		
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				lblIdAffichage.setText(String.valueOf(Login.listeClients.get(list.getSelectedIndex()).getId_client()));
				txtNom.setText(Login.listeClients.get(list.getSelectedIndex()).getNom_client().toUpperCase());
				txtPrenom.setText(Login.listeClients.get(list.getSelectedIndex()).getPrenom_client());
				txtCP.setText(Login.listeClients.get(list.getSelectedIndex()).getCp_client());
				txtVille.setText(Login.listeClients.get(list.getSelectedIndex()).getVille_client());
				txtRue.setText(Login.listeClients.get(list.getSelectedIndex()).getRue_client());
				txtMail.setText(Login.listeClients.get(list.getSelectedIndex()).getMail());
			}
		});
		
		
		
	}
	public static void loadProfile() {
		Login.recupClienttest();
		for(Client clienttmp : Login.listeClients) {
			if(clienttmp.getId_client() != "0") {
				DLM.addElement(clienttmp.getNom_client().toUpperCase() + " " + clienttmp.getPrenom_client());
			}
		}
	}
}
