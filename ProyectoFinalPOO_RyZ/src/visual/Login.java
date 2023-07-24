package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import logico.ClinicaSONS;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Rectangle;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JPasswordField;

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
		setTitle("Cl\u00EDnicaSONS - LOGIN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 440, 418);
		contentPane = new JPanel();
		setLocationRelativeTo(null);
		setResizable(false);
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBounds(new Rectangle(0, 0, 0, 250));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setBounds(80, 58, 54, 20);
		panel.add(lblNewLabel);
		
		txtUser = new JTextField();
		txtUser.setBounds(149, 55, 146, 26);
		panel.add(txtUser);
		txtUser.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Contras\u00F1a");
		lblNewLabel_1.setBounds(63, 135, 71, 20);
		panel.add(lblNewLabel_1);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.setForeground(Color.DARK_GRAY);
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String usuario = txtUser.getText();
			String password = txtPassword.getText();
			if ((usuario.trim().isEmpty()||password.trim().isEmpty())) {
				JOptionPane.showMessageDialog(null, "CAMPO OBLIGATORIO VACIO", "Ha occurrido un error", JOptionPane.ERROR_MESSAGE);
			}
			if ((usuario.equals("Admin") && password.equals("Admin")||ClinicaSONS.getInstance().confirmLogin(usuario, password)||ClinicaSONS.getInstance().confirmLoginDoc(usuario, password))) { 
				if (usuario.equals("Admin") && password.equals("Admin")) {
					Principal ventana = new Principal();
					ventana.setVisible(true);
					
					dispose();
				}
				if (ClinicaSONS.getInstance().buscarUsuarioPorUser(usuario, password).getNvlAutoridad()==1) {
					//Administrador
					Principal ventana = new Principal();
					ventana.setVisible(true);
					dispose();
				}
				if (ClinicaSONS.getInstance().buscarDoctorPorUsuarioExistente(usuario, password).getNvlAutoridad()==5) {
					//Doctor(a) a limitar
 					Principal ventana = new Principal();
					ventana.setVisible(true);
					ventana.mnAdministracion.setEnabled(false);
					
					dispose();
					
				}
				if (ClinicaSONS.getInstance().buscarUsuarioPorUser(usuario, password).getNvlAutoridad()==10) {
					//Secretario(a) a limitar
 					Principal ventana = new Principal();
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
				JOptionPane.showMessageDialog(null, "CAMPO OBLIGATORIO INCORRECTO", "Ha occurrido un error", JOptionPane.ERROR_MESSAGE);
				}


			}
		});
		btnIngresar.setBounds(173, 214, 91, 29);
		btnIngresar.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
		panel.add(btnIngresar);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(149, 132, 146, 26);
		panel.add(txtPassword);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(new Rectangle(0, 0, 250, 250));
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		contentPane.add(panel_1, BorderLayout.SOUTH);
	}
}
