package visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class Principal extends JFrame {

	private JPanel contentPane;
	private Dimension dim;

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
	 */
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		initComponents();
	}

	private void initComponents() {
		setBounds(-10, 0, 450, 300);
		dim = getToolkit().getScreenSize();
        setSize(dim.width+20,dim.height-35);
        setResizable(false);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnDoctor = new JMenu("Doctores");
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
		
		JMenu mnPaciente = new JMenu("Pacientes");
		menuBar.add(mnPaciente);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Listar pacientes");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnPaciente.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_2 = new JMenu("");
		menuBar.add(mnNewMenu_2);
		
		JMenu mnNewMenu_3 = new JMenu("Citas");
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmProgCita = new JMenuItem("Programar cita");
		mntmProgCita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegCita reg = new RegCita();
				reg.setModal(true);
				reg.setVisible(true);
			}
		});
		
		mnNewMenu_3.add(mntmProgCita);
		
		JMenuItem mntmListCita = new JMenuItem("Listar citas");
		mntmListCita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		mnNewMenu_3.add(mntmListCita);
		
		JMenu mnConsulta = new JMenu("Consultas");
		menuBar.add(mnConsulta);
		
		JMenuItem mntmRegConsult = new JMenuItem("Registrar consultas");
		mntmRegConsult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HistorialConsulta hist = new HistorialConsulta(null);
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
		
		JMenu mnEnfermedad = new JMenu("Enfermedades");
		menuBar.add(mnEnfermedad);
		
		JMenuItem mntmRegEnferm = new JMenuItem("Registrar enfermedades");
		mntmRegEnferm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegEnfermedad reg = new RegEnfermedad(null);
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
		
		JMenu mnVacuna = new JMenu("Vacunas");
		menuBar.add(mnVacuna);
		
		JMenuItem mntmRegVacu = new JMenuItem("Registrar vacuna");
		mntmRegVacu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegVacuna reg = new RegVacuna(null);
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
