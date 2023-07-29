package visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import logico.Administrador;
import logico.ClinicaSONS;
import logico.Doctor;
import logico.FicheroSalida;
import logico.Secretario;
import logico.Usuario;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class Principal extends JFrame {

	private JPanel contentPane;
	private Dimension dim;
	public JMenu mnAdministracion;
	public JMenu mnVacuna;
	public JMenu mnEnfermedad;
	public JMenu mnCita;
	public JMenu mnPaciente;
	public JMenu mnDoctor;
	public JMenu mnConsulta;
	private Doctor miDoc;
	public JMenuItem mntmRegEnferm;
	public JMenuItem mntmRegVacu;
	public JMenuItem mntmProgCita;
	private Administrador miAdmin = null;

	private static Principal panelPrincipal = null;
	private JMenuBar menuBar;
	private JButton btnCerrarSesion;
	private JMenuItem mntmRegDoctor;
	private JMenuItem mntmListDoc;
	private JMenuItem mntmListarPaciente;
	
		/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param doc 
	 */
	public Principal(/*Doctor doc, Administrador admin*/) {
//		this.miAdmin = admin;
//		this.miDoc = doc;
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				FileOutputStream clinica;
				ObjectOutputStream clinicaWrite;
				try {
					clinica = new  FileOutputStream("empresa.dat");
					clinicaWrite = new ObjectOutputStream(clinica);
					clinicaWrite.writeObject(ClinicaSONS.getInstance());
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		initComponents();
	}
	
	public static Principal getInstance() {
		if(panelPrincipal == null)
			panelPrincipal = new Principal();
		return panelPrincipal;
	}
	
	private void initComponents() {
		setBounds(-10, 0, 450, 300);
		dim = getToolkit().getScreenSize();
        setSize(dim.width+20,dim.height-40);
        setResizable(false);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnDoctor = new JMenu("Doctores");
		menuBar.add(mnDoctor);
		
		mntmRegDoctor = new JMenuItem("Registrar doctor");
		mntmRegDoctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegDoctor reg = new RegDoctor(null);
				reg.setModal(true);
				reg.setVisible(true);
			}
		});
		mnDoctor.add(mntmRegDoctor);
		
		mntmListDoc = new JMenuItem("Listar doctor");
		mntmListDoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarDoctores list = new ListarDoctores();
				list.setModal(true);
				list.setVisible(true);
			}
		});
		mnDoctor.add(mntmListDoc);
		
		mnPaciente = new JMenu("Pacientes");
		menuBar.add(mnPaciente);
		
		mntmListarPaciente = new JMenuItem("Listar pacientes");
		mntmListarPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarPacientes list = new ListarPacientes();
				list.setModal(true);
				list.setVisible(true);
			}
		});
		mnPaciente.add(mntmListarPaciente);
		
		JMenu mnNewMenu_2 = new JMenu("");
		menuBar.add(mnNewMenu_2);
		
		mnCita = new JMenu("Citas");
		menuBar.add(mnCita);
		
		mntmProgCita = new JMenuItem("Programar cita");
		mntmProgCita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegCita reg = new RegCita(null);
				reg.setModal(true);
				reg.setVisible(true);
			}
		});
		
		mnCita.add(mntmProgCita);
		
		JMenuItem mntmListCita = new JMenuItem("Listar citas");
		mntmListCita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarCitas list = new ListarCitas();
				list.setModal(true);
				list.setVisible(true);
			}
		});
		mnCita.add(mntmListCita);
		
		mnConsulta = new JMenu("Consultas");
		menuBar.add(mnConsulta);
		
		JMenuItem mntmRegConsult = new JMenuItem("Registrar consultas");
		mntmRegConsult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HistorialConsulta hist = new HistorialConsulta(miDoc,null,null);
				hist.setModal(true);
				hist.setVisible(true);
			}
		});
		mnConsulta.add(mntmRegConsult);
		
		JMenuItem mntmListConsulta = new JMenuItem("Listar consultas");
		mntmListConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		mnConsulta.add(mntmListConsulta);
		
		mnEnfermedad = new JMenu("Enfermedades");
		menuBar.add(mnEnfermedad);
		
		mntmRegEnferm = new JMenuItem("Registrar enfermedades");
		mntmRegEnferm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegEnfermedad reg = new RegEnfermedad(null, miAdmin);
				reg.setModal(true);
				reg.setVisible(true);
			}
		});
		mnEnfermedad.add(mntmRegEnferm);
		
		JMenuItem mntmListEnferm = new JMenuItem("Listar enfermedades");
		mntmListEnferm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarEnfermedad list = new ListarEnfermedad();
				list.setModal(true);
				list.setVisible(true);
			}
		});
		mnEnfermedad.add(mntmListEnferm);
		
		mnVacuna = new JMenu("Vacunas");
		menuBar.add(mnVacuna);
		
		mntmRegVacu = new JMenuItem("Registrar vacuna");
		mntmRegVacu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegVacuna reg = new RegVacuna(null, miAdmin);
				reg.setModal(true);
				reg.setVisible(true);
			}
		});
		mnVacuna.add(mntmRegVacu);
		
		JMenuItem mntmListVacu = new JMenuItem("Listar vacuna");
		mntmListVacu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ListarVacunas list = new ListarVacunas();
				list.setModal(true);
				list.setVisible(true);
			}
		});
		mnVacuna.add(mntmListVacu);
		
		mnAdministracion = new JMenu("Administraci\u00F3n");
		mnAdministracion.setEnabled(false);
		
		menuBar.add(mnAdministracion);
		
		JMenuItem mntmRegUser = new JMenuItem("Registrar Usuario");
		mntmRegUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			RegUsuario reg = new RegUsuario(null);
			reg.setModal(true);
			reg.setVisible(true);
			}
		});
		mnAdministracion.add(mntmRegUser);
		
		JMenuItem mntmListUser = new JMenuItem("Listar Usuario");
		mnAdministracion.add(mntmListUser);
		mntmListUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarUsuarios lista = new ListarUsuarios();
				
				lista.setModal(true);
				lista.setVisible(true);
				
			
			}
		});
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Realizar respaldo");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				FileInputStream clinicaViene;
				FileOutputStream clinicaVa;
				ObjectInputStream clinicaRead;
				ObjectOutputStream clinicaWrite;
				try {
					clinicaViene = new FileInputStream ("empresa.dat");
					clinicaRead = new ObjectInputStream(clinicaViene);
					ClinicaSONS temp = (ClinicaSONS)clinicaRead.readObject();
					ClinicaSONS.setClinica(temp);
					clinicaViene.close();
					clinicaRead.close();
				} catch (FileNotFoundException exception) {
					try {
						clinicaVa = new  FileOutputStream("empresa.dat");
						clinicaWrite = new ObjectOutputStream(clinicaVa);
						Usuario aux = new Administrador("Elmaca","non");
						ClinicaSONS.getInstance().insertarUsuario(aux);
						clinicaWrite.writeObject(ClinicaSONS.getInstance());
						clinicaVa.close();
						clinicaWrite.close();
					} catch (FileNotFoundException e1) {
					} catch (IOException e1) {
						// TODO Auto-generated catch block
					}
				} catch (IOException exception) {
					
					
				} catch (ClassNotFoundException exception) {
					// TODO Auto-generated catch block
					exception.printStackTrace();
				}	
				
				
			}
		});
		
		mnAdministracion.add(mntmNewMenuItem_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		btnCerrarSesion = new JButton("Cerrar ses\u00F3n");
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClinicaSONS.setLoginUserAdmin(null);
				ClinicaSONS.setLoginUserDoc(null);
				ClinicaSONS.setLoginUserSecre(null);
				Login loginScreen = new Login();
				loginScreen.setVisible(true);
				dispose();
				
			}
		});
		contentPane.add(btnCerrarSesion, BorderLayout.SOUTH);
		
		detectarUsuarios();
	
	}

	private void detectarUsuarios() {
		
		Administrador admin = ClinicaSONS.getLoginUserAdmin();
		Secretario secre = ClinicaSONS.getLoginUserSecre();
		Doctor doc = ClinicaSONS.getLoginUserDoc();
		
		if (doc!=null||admin!=null||secre!=null) {
			
			if (admin!=null) {
				mnAdministracion.setEnabled(true);
				JOptionPane.showMessageDialog(null, "ALL HAIL ADMMMIN", "AHORA, TÚ....ERES ADMIN", JOptionPane.INFORMATION_MESSAGE);
				
			}if (doc!=null) {
				mnAdministracion.setEnabled(false);
				mntmRegEnferm.setEnabled(false);
				mntmProgCita.setEnabled(false);
				mntmRegVacu.setEnabled(false);
				mntmRegDoctor.setEnabled(false);
				JOptionPane.showMessageDialog(null, "Doctor " +ClinicaSONS.getLoginUserDoc().getNombre()+ " reconocido, bienvenido Doctor.", "USUARIO RESTRINGIDO", JOptionPane.PLAIN_MESSAGE);
				
			}if (secre!=null) {
				mnAdministracion.setEnabled(false);
				mnConsulta.setEnabled(false);
				mnDoctor.setEnabled(false);
				mnPaciente.setEnabled(false);
				mnVacuna.setEnabled(false);
				mnEnfermedad.setEnabled(false);
				JOptionPane.showMessageDialog(null, "Secretario/a reconocido", "USUARIO RESTRINGIDO", JOptionPane.WARNING_MESSAGE);
				
			}
			
		}			
		
		else {
			JOptionPane.showMessageDialog(null, "El sistema se deshabilitará, inicie sesión", "Error: usuario no existente", JOptionPane.ERROR_MESSAGE);
			btnCerrarSesion.setText("Inicar Sesion");
			mnAdministracion.setEnabled(false);
			mnConsulta.setEnabled(false);
			mnDoctor.setEnabled(false);
			mnPaciente.setEnabled(false);
			mnVacuna.setEnabled(false);
			mnEnfermedad.setEnabled(false);
			mnCita.setEnabled(false);
		}
	}

}
