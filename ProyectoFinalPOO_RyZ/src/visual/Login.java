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
import javax.swing.DropMode;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JToggleButton;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUser;
	private JPasswordField txtPassword;
	private JButton btnIngresar;
	private JLabel lblNewLabel;
	private JSeparator separator_1;
	private JLabel lblNewLabel_1;
	private JLabel label;
	private JTextField txtContVisible;
	private JLabel lblOjoCer;
	private JLabel lblOjoAbierto;

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
					clinicaViene = new FileInputStream ("clinica.dat");
					clinicaRead = new ObjectInputStream(clinicaViene);
					ClinicaSONS temp = (ClinicaSONS)clinicaRead.readObject();
					ClinicaSONS.setClinica(temp);
					clinicaViene.close();
					clinicaRead.close();
				} catch (FileNotFoundException e) {
					try {
						clinicaVa = new  FileOutputStream("clinica.dat");
						clinicaWrite = new ObjectOutputStream(clinicaVa);
						Administrador admin = new Administrador("Admin","12345");
						ClinicaSONS.getInstance().insertarUsuario(admin);
						clinicaWrite.writeObject(ClinicaSONS.getInstance());
						clinicaVa.close();
						clinicaWrite.close();
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
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
		setBounds(100, 100, 950, 550);
		setTitle("Cl\u00EDnicaSONS - Iniciar Sesión");
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

		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(40, 274, 341, 2);
		panel.add(separator);

		separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(40, 367, 341, 2);
		panel.add(separator_1);

		lblOjoCer = new JLabel("");
		lblOjoCer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtPassword.setVisible(false);
				txtContVisible.setVisible(true);
				txtContVisible.setText(new String(txtPassword.getPassword()));
				lblOjoCer.setVisible(false);
				lblOjoAbierto.setVisible(true);
			}
		});
		lblOjoCer.setIcon(new ImageIcon(Login.class.getResource("/fotos/Ojo cerrado.png")));
		lblOjoCer.setBounds(326, 332, 55, 37);
		panel.add(lblOjoCer);

		lblOjoAbierto = new JLabel("");
		lblOjoAbierto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtPassword.setVisible(true);
				txtContVisible.setVisible(false);
				txtPassword.setText(txtContVisible.getText());
				lblOjoCer.setVisible(true);
				lblOjoAbierto.setVisible(false);
			}
		});
		lblOjoAbierto.setIcon(new ImageIcon(Login.class.getResource("/fotos/Ojo abierto.png")));
		lblOjoAbierto.setBounds(326, 332, 55, 37);
		lblOjoAbierto.setVisible(false);
		panel.add(lblOjoAbierto);

		label = new JLabel("Contraseña:");
		label.setFont(new Font("Sylfaen", Font.BOLD, 16));
		label.setBounds(40, 313, 91, 15);
		panel.add(label);

		lblNewLabel_1 = new JLabel("Usuario:");
		lblNewLabel_1.setFont(new Font("Sylfaen", Font.BOLD, 16));
		lblNewLabel_1.setBounds(40, 220, 73, 15);
		panel.add(lblNewLabel_1);

		txtPassword = new JPasswordField();
		txtPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String con = new String(txtPassword.getPassword());
				if(con.equalsIgnoreCase("Ingrese su contraseña")) {
					txtPassword.setText("");
				}
			}
		});
		txtPassword.setForeground(Color.GRAY);
		txtPassword.setBounds(40, 341, 294, 21);
		panel.add(txtPassword);
		txtPassword.setText("12345");
		txtPassword.setBorder(null);

		txtContVisible = new JTextField();
		txtContVisible.setForeground(Color.GRAY);
		txtContVisible.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(txtContVisible.getText().equalsIgnoreCase("Ingrese su contraseña")) {
					txtContVisible.setText("");
				}
			}
		});
		txtContVisible.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		txtContVisible.setBounds(40, 341, 280, 21);
		panel.add(txtContVisible);
		txtContVisible.setColumns(10);
		txtContVisible.setBorder(null);
		txtContVisible.setVisible(false);

		txtUser = new JTextField();
		txtUser.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(txtUser.getText().equalsIgnoreCase("Ingrese su nombre de usuario")) {
					txtUser.setText("Admin");
				}
			}
		});
		txtUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(txtUser.getText().equalsIgnoreCase("Ingrese su nombre de usuario")) {
					txtUser.setText("Admin");
				}
			}
		});
		txtUser.setBorder(null);
		txtUser.setFont(new Font("Sylfaen", Font.PLAIN, 15));

		txtUser.setForeground(Color.GRAY);
		txtUser.setText("Ingrese su nombre de usuario");
		txtUser.setBounds(40, 248, 341, 21);
		panel.add(txtUser);
		txtUser.setColumns(10);



		btnIngresar = new JButton("Iniciar Sesi\u00F3n");
		btnIngresar.setBackground(Color.WHITE);
		btnIngresar.setFont(new Font("Sylfaen", Font.BOLD, 15));
		btnIngresar.setBounds(40, 419, 341, 29);
		panel.add(btnIngresar);
		btnIngresar.setForeground(Color.BLACK);
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usuario = txtUser.getText();
				char[] arrayC = txtPassword.getPassword();
				String password = null;
				if(txtPassword.isVisible()) {
					password = new String(arrayC);
				}else{
					password = txtContVisible.getText();
				}
				System.out.println(password);
				if (ClinicaSONS.getInstance().confirmLoginAdmin(usuario, password)||ClinicaSONS.getInstance().confirmLoginSecre(usuario, password)||ClinicaSONS.getInstance().confirmLoginDoc(usuario, password)) {
					try {
						dispose();
						Principal frame = new Principal();
						frame.setVisible(true);
					} catch (Exception exception) {
						exception.printStackTrace();
					}
				}else {
					JOptionPane.showMessageDialog(null, "Usuario o constraseña incorrecto(s)","Ha ocurrido un error",JOptionPane.ERROR_MESSAGE);
				}
			}


		});
		lblNewLabel = new JLabel("INICIO DE SESI\u00D3N");
		lblNewLabel.setFont(new Font("Sylfaen", Font.BOLD, 30));
		lblNewLabel.setBounds(64, 140, 285, 37);
		panel.add(lblNewLabel);

		btnIngresar.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
		JLabel Fondo = new JLabel("");
		Fondo.setIcon(new ImageIcon(Login.class.getResource("/fotos/FondoLogin.png")));
		Fondo.setBounds(0, 0, 934, 505);
		panel.add(Fondo);


	}
}
