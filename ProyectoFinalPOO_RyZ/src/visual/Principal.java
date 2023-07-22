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
		
		JMenu mnNewMenu = new JMenu("Doctores");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Registrar doctor");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegDoctor reg = new RegDoctor();
				reg.setModal(true);
				reg.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Listar doctor");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarDoctores list = new ListarDoctores();
				list.setModal(true);
				list.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_1 = new JMenu("Pacientes");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Listar pacientes");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_2 = new JMenu("");
		menuBar.add(mnNewMenu_2);
		
		JMenu mnNewMenu_3 = new JMenu("Citas");
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Programar cita");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegCita reg = new RegCita();
				reg.setModal(true);
				reg.setVisible(true);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Listar citas");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_4);
		
		JMenu mnNewMenu_4 = new JMenu("Consultas");
		menuBar.add(mnNewMenu_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Registrar consultas");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HistorialConsulta hist = new HistorialConsulta(null);
				hist.setModal(true);
				hist.setVisible(true);
			}
		});
		mnNewMenu_4.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Listar consultas");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnNewMenu_4.add(mntmNewMenuItem_6);
		
		JMenu mnNewMenu_5 = new JMenu("Enfermedades");
		menuBar.add(mnNewMenu_5);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Registrar enfermedades");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegEnfermedad reg = new RegEnfermedad();
				reg.setModal(true);
				reg.setVisible(true);
			}
		});
		mnNewMenu_5.add(mntmNewMenuItem_7);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Listar enfermedades");
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarEnfermedad list = new ListarEnfermedad();
				list.setModal(true);
				list.setVisible(true);
			}
		});
		mnNewMenu_5.add(mntmNewMenuItem_8);
		
		JMenu mnNewMenu_6 = new JMenu("Vacunas");
		menuBar.add(mnNewMenu_6);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("Registrar vacuna");
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegVacuna reg = new RegVacuna();
				reg.setModal(true);
				reg.setVisible(true);
			}
		});
		mnNewMenu_6.add(mntmNewMenuItem_9);
		
		JMenuItem mntmNewMenuItem_10 = new JMenuItem("Listar vacuna");
		mntmNewMenuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarVacunas list = new ListarVacunas();
				list.setModal(true);
				list.setVisible(true);
			}
		});
		mnNewMenu_6.add(mntmNewMenuItem_10);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
