package visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.Administrador;
import logico.Doctor;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
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

		/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal(null,null);
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
	public Principal(Doctor doc, Administrador admin) {
		this.miAdmin = admin;
		this.miDoc = doc;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		initComponents();
	}

	private void initComponents() {
		setBounds(-10, 0, 450, 300);
		dim = getToolkit().getScreenSize();
        setSize(dim.width+20,dim.height-40);
        setResizable(false);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnDoctor = new JMenu("Doctores");
		menuBar.add(mnDoctor);
		
		JMenuItem mntmRegDoctor = new JMenuItem("Registrar doctor");
		mntmRegDoctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegDoctor reg = new RegDoctor(null);
				reg.setModal(true);
				reg.setVisible(true);
			}
		});
		mnDoctor.add(mntmRegDoctor);
		
		JMenuItem mntmListDoc = new JMenuItem("Listar doctor");
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
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Listar pacientes");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarPacientes list = new ListarPacientes(miDoc);
				list.setModal(true);
				list.setVisible(true);
			}
		});
		mnPaciente.add(mntmNewMenuItem_2);
		
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
				ListarCitas list = new ListarCitas(miDoc);
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
				ListarEnfermedad list = new ListarEnfermedad(miAdmin);
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
				ListarVacunas list = new ListarVacunas(miAdmin);
				list.setModal(true);
				list.setVisible(true);
			}
		});
		mnVacuna.add(mntmListVacu);
		
		mnAdministracion = new JMenu("Administraci\u00F3n");
		menuBar.add(mnAdministracion);
		
		JMenuItem mntmRegUser = new JMenuItem("Registrar Usuario");
		mnAdministracion.add(mntmRegUser);
		
		JMenuItem mntmListUser = new JMenuItem("Listar Usuario");
		mnAdministracion.add(mntmListUser);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("New menu item");
		mnAdministracion.add(mntmNewMenuItem_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JButton btnCerrarSes = new JButton("Cerrar ses\u00F3n");
		btnCerrarSes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Login loginScreen = new Login();
				loginScreen.setVisible(true);
				dispose();
				
			}
		});
		contentPane.add(btnCerrarSes, BorderLayout.SOUTH);
	}

}
