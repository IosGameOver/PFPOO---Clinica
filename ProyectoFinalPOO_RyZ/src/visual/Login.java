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
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.border.TitledBorder;
import javax.swing.ImageIcon;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUser;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		setTitle("Cl\u00EDnicaSONS - LOGIN");
		setResizable(false);
		setLocationRelativeTo(null);
		Usuario admin = new Administrador("Admin", "Admin");
		ClinicaSONS.getInstance().insertarUsuario(admin);
		Doctor doc = new Doctor("D-1", "031", "Pepe", "Masc", "Soltero/a", "809", new Date(), "Pepe", "A+", 
				"5BS", "pucmm", "Aja", "Pepe", "Pepe","Pepe@gmail.com");
		ClinicaSONS.getInstance().insertarDoctor(doc);
		Usuario secre = new Administrador("Secre", "Secre");
		ClinicaSONS.getInstance().insertarUsuario(secre);
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

		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.setBounds(110, 185, 91, 29);
		panel_1.add(btnIngresar);
		btnIngresar.setForeground(Color.DARK_GRAY);
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usuario = txtUser.getText();
				char[] arrayC = txtPassword.getPassword();
				String password = new String(arrayC);
				System.out.println(password);
			
				if (ClinicaSONS.getInstance().confirmLogin(usuario, password) || ClinicaSONS.getInstance().confirmLoginDoc(usuario, password)) { 
					if (ClinicaSONS.getInstance().buscarUsuarioPorUser(usuario, password).getNvlAutoridad() == 1) {
						//Administrador
						Administrador admin = ClinicaSONS.getInstance().buscarAdministradorPorUsuario(usuario, password); 
						Principal ventana = new Principal(null,admin);
						ventana.setVisible(true);
						dispose();
					}else if (ClinicaSONS.getInstance().buscarDoctorPorUsuarioExistente(usuario, password).getNvlAutoridad() == 5) {
						//Doctor(a) a limitar
						Doctor doc = ClinicaSONS.getInstance().buscarDoctorPorUsuarioExistente(usuario, password);
						Principal ventana = new Principal(doc,null);
						ventana.setVisible(true);
						ventana.mnAdministracion.setEnabled(false);
						ventana.mntmRegEnferm.setEnabled(false);
						ventana.mntmProgCita.setEnabled(false);
						ventana.mntmRegVacu.setEnabled(false);
						dispose();
					} else if (ClinicaSONS.getInstance().buscarUsuarioPorUser(usuario, password).getNvlAutoridad() == 10) {
						//Secretario(a) a limitar
						Principal ventana = new Principal(null,null);
						ventana.setVisible(true);
						ventana.mnAdministracion.setEnabled(false);
						ventana.mnConsulta.setEnabled(false);
						ventana.mnDoctor.setEnabled(false);
						ventana.mnPaciente.setEnabled(false);
						ventana.mnVacuna.setEnabled(false);
						ventana.mnEnfermedad.setEnabled(false);
						dispose();
					}
				}else{
					JOptionPane.showMessageDialog(null, "El usuario no existe", "Ha occurrido un error", JOptionPane.ERROR_MESSAGE);
				}

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
