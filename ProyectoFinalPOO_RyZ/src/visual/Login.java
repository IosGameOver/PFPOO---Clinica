package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import logico.Administrador;
import logico.ClinicaSONS;
import logico.Doctor;
import logico.Secretario;
import logico.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Rectangle;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.logging.ErrorManager;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.border.TitledBorder;
import javax.xml.transform.ErrorListener;


import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.peer.PanelPeer;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUser;
	private JPasswordField txtPassword;
	private JButton btnIngresar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				FileInputStream clinicaViene;
				FileOutputStream clinicaVa;
				ObjectInputStream clinicaRead;
				ObjectOutputStream clinicaWrite;
				try {
					clinicaViene = new FileInputStream ("Clinica.dat");
					clinicaRead = new ObjectInputStream(clinicaViene);
					ClinicaSONS temp = (ClinicaSONS)clinicaRead.readObject();
					ClinicaSONS.setClinica(temp);
					clinicaViene.close();
					clinicaRead.close();
				} catch (FileNotFoundException e) {
					try {
						clinicaVa = new  FileOutputStream("Clinica.dat");
						clinicaWrite = new ObjectOutputStream(clinicaVa);
						Usuario aux = new Administrador("Elmaca","non");
						Usuario aux2 = new Secretario("Secre", "Secre");
						Doctor doc = new Doctor("D-1", "031", "Bat-Man", "Masc", "Soltero/a", "010", new Date(), "BRUCE", "A+", 
								"5BS", "GOTICA", "Aja", "BATMAN", "ROBIN","BATMAN@ELCABALLERODELANOCHE.com");
						ClinicaSONS.getInstance().insertarUsuario(aux);
						ClinicaSONS.getInstance().insertarUsuario(aux2);
						ClinicaSONS.getInstance().insertarDoctor(doc);
						clinicaWrite.writeObject(ClinicaSONS.getInstance());
						clinicaVa.close();
						clinicaWrite.close();
					} catch (FileNotFoundException e1) {
					} catch (IOException e1) {
						// TODO Auto-generated catch block
					}
				} catch (IOException e) {
					
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				try {
					Login frame = new Login();
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

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		setTitle("Cl\u00EDnicaSONS - LOGIN");
		setResizable(false);
		setLocationRelativeTo(null);
		initComponents();
	}

	private void initComponents() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(new Rectangle(0, 0, 0, 250));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(271, 141, 343, 227);
		panel.add(panel_1);
		panel_1.setLayout(null);

		btnIngresar = new JButton("Ingresar");
		btnIngresar.setBounds(110, 185, 91, 29);
		panel_1.add(btnIngresar);
		btnIngresar.setForeground(Color.DARK_GRAY);
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usuario = txtUser.getText();
				char[] arrayC = txtPassword.getPassword();
				String password = new String(arrayC);
				System.out.println(password);
				
				
				if (ClinicaSONS.getInstance().confirmLogin(usuario, password)||ClinicaSONS.getInstance().confirmLoginDoc(usuario, password)) {
					Principal main = new Principal();
					try {
						Principal frame = new Principal();
						frame.setVisible(true);
					} catch (Exception exception) {
						exception.printStackTrace();
					}
										
				}else {
					JOptionPane.showMessageDialog(null, "Usuario o constraseña incorrecto(s)","Ha ocurrido un error",JOptionPane.ERROR_MESSAGE);
				
				
				}dispose();
			}
		});
		btnIngresar.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));

		txtPassword = new JPasswordField();
		txtPassword.setBounds(86, 103, 146, 26);
		panel_1.add(txtPassword);

		JLabel lblNewLabel_1 = new JLabel("Contras\u00F1a");
		lblNewLabel_1.setBounds(0, 106, 71, 20);
		panel_1.add(lblNewLabel_1);

		txtUser = new JTextField();
		txtUser.setBounds(86, 26, 146, 26);
		panel_1.add(txtUser);
		txtUser.setColumns(10);

		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setBounds(17, 29, 54, 20);
		panel_1.add(lblNewLabel);
	}




}
