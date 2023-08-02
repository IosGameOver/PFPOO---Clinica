package visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.*;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import logico.Administrador;
import logico.ClinicaSONS;
import logico.*;




import logico.Secretario;
import logico.Usuario;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;

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
	private JPanel panelReloj;
	private JPanel panel;
	private JMenu mnRespaldar;
	private DataInputStream EntradaSocket;
	private DataOutputStream SalidaSocket;
	static Socket sfd = null;
	private ChartPanel chartPanel;
	private ChartPanel chartPanelEnfer;
	private ChartPanel chartPanelDoc;
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
	public Principal() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				FileOutputStream clinica;
				ObjectOutputStream clinicaWrite;
				try {
					clinica = new FileOutputStream("clinica.dat");
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
		menuBar.setBackground(new Color(255, 255, 255));
		menuBar.setFont(new Font("Sylfaen", Font.BOLD, 15));
		setJMenuBar(menuBar);
		
		mnDoctor = new JMenu("Doctores");
		mnDoctor.setForeground(Color.BLACK);
		mnDoctor.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		menuBar.add(mnDoctor);
		
		mntmRegDoctor = new JMenuItem("Registrar doctor");
		mntmRegDoctor.setForeground(Color.BLACK);
		mntmRegDoctor.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		mntmRegDoctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegDoctor reg = new RegDoctor(null);
				reg.setModal(true);
				reg.setVisible(true);
			}
		});
		mnDoctor.add(mntmRegDoctor);
		
		mntmListDoc = new JMenuItem("Listar doctor");
		mntmListDoc.setForeground(Color.BLACK);
		mntmListDoc.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		mntmListDoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarDoctores list = new ListarDoctores();
				list.setModal(true);
				list.setVisible(true);
			}
		});
		mnDoctor.add(mntmListDoc);
		
		mnPaciente = new JMenu("Pacientes");
		mnPaciente.setForeground(Color.BLACK);
		mnPaciente.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		menuBar.add(mnPaciente);
		
		mntmListarPaciente = new JMenuItem("Listar pacientes");
		mntmListarPaciente.setForeground(Color.BLACK);
		mntmListarPaciente.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		mntmListarPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarPacientes list = new ListarPacientes();
				list.setModal(true);
				list.setVisible(true);
			}
		});
		mnPaciente.add(mntmListarPaciente);
		
		mnCita = new JMenu("Citas");
		mnCita.setForeground(Color.BLACK);
		mnCita.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		menuBar.add(mnCita);
		
		mntmProgCita = new JMenuItem("Programar cita");
		mntmProgCita.setForeground(Color.BLACK);
		mntmProgCita.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		mntmProgCita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegCita reg = new RegCita(null);
				reg.setModal(true);
				reg.setVisible(true);
			}
		});
		
		mnCita.add(mntmProgCita);
		
		JMenuItem mntmListCita = new JMenuItem("Listar citas");
		mntmListCita.setForeground(Color.BLACK);
		mntmListCita.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		mntmListCita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarCitas list = new ListarCitas();
				list.setModal(true);
				list.setVisible(true);
			}
		});
		mnCita.add(mntmListCita);
		
		mnConsulta = new JMenu("Consultas");
		mnConsulta.setForeground(Color.BLACK);
		mnConsulta.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		menuBar.add(mnConsulta);
		
		JMenuItem mntmRegConsult = new JMenuItem("Registrar consultas");
		mntmRegConsult.setForeground(Color.BLACK);
		mntmRegConsult.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		mntmRegConsult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HistorialConsulta hist = new HistorialConsulta(miDoc,null,null);
				hist.setModal(true);
				hist.setVisible(true);
			}
		});
		mnConsulta.add(mntmRegConsult);
		
		JMenuItem mntmListConsulta = new JMenuItem("Listar consultas");
		mntmListConsulta.setForeground(Color.BLACK);
		mntmListConsulta.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		mntmListConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		mnConsulta.add(mntmListConsulta);
		
		mnEnfermedad = new JMenu("Enfermedades");
		mnEnfermedad.setForeground(Color.BLACK);
		mnEnfermedad.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		menuBar.add(mnEnfermedad);
		
		mntmRegEnferm = new JMenuItem("Registrar enfermedades");
		mntmRegEnferm.setForeground(Color.BLACK);
		mntmRegEnferm.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		mntmRegEnferm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegEnfermedad reg = new RegEnfermedad(null, miAdmin);
				reg.setModal(true);
				reg.setVisible(true);
			}
		});
		mnEnfermedad.add(mntmRegEnferm);
		
		JMenuItem mntmListEnferm = new JMenuItem("Listar enfermedades");
		mntmListEnferm.setForeground(Color.BLACK);
		mntmListEnferm.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		mntmListEnferm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarEnfermedad list = new ListarEnfermedad();
				list.setModal(true);
				list.setVisible(true);
			}
		});
		mnEnfermedad.add(mntmListEnferm);
		
		mnVacuna = new JMenu("Vacunas");
		mnVacuna.setForeground(Color.BLACK);
		mnVacuna.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		menuBar.add(mnVacuna);
		
		mntmRegVacu = new JMenuItem("Registrar vacuna");
		mntmRegVacu.setForeground(Color.BLACK);
		mntmRegVacu.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		mntmRegVacu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegVacuna reg = new RegVacuna(null, miAdmin);
				reg.setModal(true);
				reg.setVisible(true);
			}
		});
		mnVacuna.add(mntmRegVacu);
		
		JMenuItem mntmListVacu = new JMenuItem("Listar vacuna");
		mntmListVacu.setForeground(Color.BLACK);
		mntmListVacu.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		mntmListVacu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ListarVacunas list = new ListarVacunas();
				list.setModal(true);
				list.setVisible(true);
			}
		});
		mnVacuna.add(mntmListVacu);
		
		mnAdministracion = new JMenu("Administraci\u00F3n");
		mnAdministracion.setForeground(Color.BLACK);
		mnAdministracion.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		mnAdministracion.setEnabled(false);
		
		menuBar.add(mnAdministracion);
		
		JMenuItem mntmRegUser = new JMenuItem("Registrar Usuario");
		mntmRegUser.setForeground(Color.BLACK);
		mntmRegUser.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		mntmRegUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			RegUsuario reg = new RegUsuario(null);
			reg.setModal(true);
			reg.setVisible(true);
			}
		});
		mnAdministracion.add(mntmRegUser);
		
		JMenuItem mntmListUser = new JMenuItem("Listar Usuario");
		mntmListUser.setForeground(Color.BLACK);
		mntmListUser.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		mnAdministracion.add(mntmListUser);
		
		mnRespaldar = new JMenu("Respaldar");
		mnRespaldar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					sfd = new Socket("localhost",8000);
					EntradaSocket = new DataInputStream(new FileInputStream (new File ("clinica.dat")));
					SalidaSocket = new DataOutputStream(sfd.getOutputStream());
					int unByte;
					
					try {
						while((unByte = EntradaSocket.read()) != -1) {
							SalidaSocket.write(unByte);
							SalidaSocket.flush();
						}
					} catch (IOException ioe) {
						System.out.println("Error: "+ioe);
					}
				} catch (UnknownHostException uhe) {
					System.out.println("No se puede acceder al servidor.");
					System.exit(1);
				}catch (IOException ioe) {
					System.out.println("Comunicación rechazada.");
					System.exit(1);
				}
			}
		});
		mnRespaldar.setForeground(Color.BLACK);
		mnRespaldar.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		menuBar.add(mnRespaldar);
		mntmListUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarUsuarios lista = new ListarUsuarios();
				
				lista.setModal(true);
				lista.setVisible(true);
				
			
			}
		});
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panelReloj = new JPanel();
		contentPane.add(panelReloj, BorderLayout.SOUTH);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		btnCerrarSesion = new JButton("Cerrar ses\u00F3n");
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
				Login loginScreen = new Login();
				loginScreen.setVisible(true);
				
			}
		});
		contentPane.add(btnCerrarSesion, BorderLayout.SOUTH);
		
		 // Fuente de Datos - Gráfica de vacunas por cantidad de personas
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (Persona aux : ClinicaSONS.getInstance().getMisPersonas()) {
			if (aux instanceof Paciente) {
				
				dataset.setValue(ClinicaSONS.getInstance().cantidadDePacientesPorVacuna("Covid-19"), "Covid-19" , "Covid-19");
				dataset.setValue(ClinicaSONS.getInstance().cantidadDePacientesPorVacuna("Viruela"), "Viruela" , "Viruela");
				dataset.setValue(ClinicaSONS.getInstance().cantidadDePacientesPorVacuna("Influeza"), "Influeza" , "Influeza");
				
			
			
			}
		}
        
         
        // Creando el Grafico
        JFreeChart chart = ChartFactory.createBarChart3D
        ("Cantidad de Vacunas por Pacientes","Vacunas", "Pacientes Vacunados", dataset, PlotOrientation.VERTICAL, true,true, false);
        chart.setBackgroundPaint(null);
        chart.getTitle().setPaint(Color.black); 
        CategoryPlot p = chart.getCategoryPlot(); 
        p.setRangeGridlinePaint(Color.red); 
        // Mostrar Grafico
        chartPanel = new ChartPanel(chart);
        panel.add(chartPanel);
        chartPanel.setVisible(false);
        
        
     // Fuente de Datos - Gráfica de cantidad de personas enfermas
        DefaultCategoryDataset dataEnfer = new DefaultCategoryDataset();
        for (Persona aux : ClinicaSONS.getInstance().getMisPersonas()) {
 			if (aux instanceof Paciente) {
 				
 				dataEnfer.setValue(ClinicaSONS.getInstance().cantidadDePacientesConEnfermedad("Resfriado"),("Resfriado común"),("Resfriado común"));
 				dataEnfer.setValue(ClinicaSONS.getInstance().cantidadDePacientesConEnfermedad("Influenza"),("Influenza (gripe)"),("Influenza"));
 				dataEnfer.setValue(ClinicaSONS.getInstance().cantidadDePacientesConEnfermedad("Sinusitis"),("Sinusitis (infección de los senos paranasales)"),("Sinusitis"));
 				dataEnfer.setValue(ClinicaSONS.getInstance().cantidadDePacientesConEnfermedad("Bronquitis aguda"),("Bronquitis aguda (resfriado de pecho)"),("Bronquitis aguda"));
 			
 			
 			}
 		}
        
        
        // Creando el Grafico
        JFreeChart chartEnfer = ChartFactory.createBarChart3D("Cantidad de Pacientes Enfermos","Enfermedades", "Pacientes Enfermedades", dataset, PlotOrientation.VERTICAL, true,true, false);
        chartEnfer.setBackgroundPaint(null);
        chartEnfer.getTitle().setPaint(Color.black); 
        CategoryPlot pEn = chartEnfer.getCategoryPlot(); 
        pEn.setRangeGridlinePaint(Color.blue); 
        // Mostrar Grafico
        chartPanelEnfer = new ChartPanel(chartEnfer);
        panel.add(chartPanelEnfer);
        chartPanelEnfer.setVisible(false);
         
        
        
	
		//Cantidad de doctores por especialidad.
        
        DefaultPieDataset dataDoc = new DefaultPieDataset();
        for (Persona aux : ClinicaSONS.getInstance().getMisPersonas()) {
			if (aux instanceof Doctor) {
				
				dataDoc.setValue("Oftalmología",ClinicaSONS.getInstance().cantidadDeDoctoresPorEspecialidad("Oftalmología"));
				dataDoc.setValue("Neumología",ClinicaSONS.getInstance().cantidadDeDoctoresPorEspecialidad("Neumología"));
				dataDoc.setValue("Urología",ClinicaSONS.getInstance().cantidadDeDoctoresPorEspecialidad("Urología"));
				dataDoc.setValue("Cardiología Clínica",ClinicaSONS.getInstance().cantidadDeDoctoresPorEspecialidad("Cardiología Clínica"));
				dataDoc.setValue("Pediatría",ClinicaSONS.getInstance().cantidadDeDoctoresPorEspecialidad("Pediatría"));
				dataDoc.setValue("Gastroenterología",ClinicaSONS.getInstance().cantidadDeDoctoresPorEspecialidad("Gastroenterología"));
								
			}
		} 
		
        //Creando el Grafico
        JFreeChart chartDoc = ChartFactory.createPieChart("Proporción de Doctores y su especialidades", dataDoc, true, true,false);
 
        // Crear el Panel del Grafico con ChartPanel
        chartDoc.setBackgroundPaint(null);
       
        
        chartPanelDoc = new ChartPanel(chartDoc);
        panel.add(chartPanelDoc);
        chartPanelDoc.setVisible(false);
        

	
		
		
		
		detectarUsuarios();
	
	}

	private void detectarUsuarios() {
		
		Usuario admin = ClinicaSONS.getLoginUserAdmin();
		Usuario secre = ClinicaSONS.getLoginUserSecre();
		Doctor doc = ClinicaSONS.getLoginUserDoc();
		
		if (doc!=null||admin!=null||secre!=null) {
			
			if (admin!=null) {
				mnAdministracion.setEnabled(true);
				chartPanel.setVisible(true);
				chartPanelDoc.setVisible(true);
				chartPanelEnfer.setVisible(true);
				JOptionPane.showMessageDialog(null, "Admin reconcido", "Sistema desbloqueado", JOptionPane.INFORMATION_MESSAGE);
				
			}else if (doc!=null) {
				mnAdministracion.setEnabled(false);
				mntmRegEnferm.setEnabled(false);
				mntmProgCita.setEnabled(false);
				mntmRegVacu.setEnabled(false);
				mntmRegDoctor.setEnabled(false);
				JOptionPane.showMessageDialog(null, "Usuario reconocido, bienvenido Doctor/a: " +doc.getNombre(), "USUARIO RESTRINGIDO", JOptionPane.PLAIN_MESSAGE);
			
				
			}else if (secre!=null) {
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
			mnRespaldar.setEnabled(false);
		}
	}

}
