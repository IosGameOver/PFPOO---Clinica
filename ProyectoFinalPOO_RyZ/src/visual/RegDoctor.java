package visual;
import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JDayChooser;

import logico.ClinicaSONS;
import logico.Doctor;
import logico.Vacuna;

import java.awt.Font;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.event.ActionEvent;

public class RegDoctor extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtExequartur;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private JTextField TxtAlmaMater;
	private JTextField txtDireccion;
	private JDateChooser dtCalendario;
	private JComboBox cmbSexo;
	private JComboBox cmbEstCivil;
	private JComboBox cmbTipoSangre;
	private JTextField txtCodigo;
	private JTextField txtCedula;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegDoctor dialog = new RegDoctor();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegDoctor() {
		setTitle("Registro de Doctor");
		setBounds(100, 100, 700, 440);
		setResizable(false);
		setLocationRelativeTo(null);
		initComponents();
	}

	private void initComponents() {
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Exequatur:");
			lblNewLabel.setFont(new Font("Sylfaen", Font.PLAIN, 14));
			lblNewLabel.setBounds(17, 65, 77, 16);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Nombre:");
			lblNewLabel_1.setFont(new Font("Sylfaen", Font.PLAIN, 14));
			lblNewLabel_1.setBounds(371, 65, 56, 16);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Estado Civil:");
			lblNewLabel_2.setFont(new Font("Sylfaen", Font.PLAIN, 14));
			lblNewLabel_2.setBounds(18, 108, 76, 16);
			contentPanel.add(lblNewLabel_2);
		}
		{
			txtExequartur = new JTextField();
			txtExequartur.setBounds(95, 61, 234, 22);
			contentPanel.add(txtExequartur);
			txtExequartur.setColumns(10);
		}
		{
			txtNombre = new JTextField();
			txtNombre.setColumns(10);
			txtNombre.setBounds(447, 61, 230, 22);
			contentPanel.add(txtNombre);
		}
		{
			cmbEstCivil = new JComboBox();
			cmbEstCivil.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Soltero/a", "Casado/a", "Separado/a", "Divorciado/a", "Viudo/a", "Uni\u00F3n Libre"}));
			cmbEstCivil.setFont(new Font("Sylfaen", Font.PLAIN, 14));
			cmbEstCivil.setBounds(95, 105, 120, 22);
			contentPanel.add(cmbEstCivil);
		}
		{
			cmbTipoSangre = new JComboBox();
			cmbTipoSangre.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-"}));
			cmbTipoSangre.setBounds(557, 105, 120, 22);
			cmbTipoSangre.setFont(new Font("Sylfaen", Font.PLAIN, 14));
			contentPanel.add(cmbTipoSangre);
		}
		{
			JLabel lblTipoDeSangre = new JLabel("Tipo de Sangre:");
			lblTipoDeSangre.setFont(new Font("Sylfaen", Font.PLAIN, 14));
			lblTipoDeSangre.setBounds(462, 108, 93, 16);
			contentPanel.add(lblTipoDeSangre);
		}
		{
			cmbSexo = new JComboBox();
			cmbSexo.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "F", "M"}));
			cmbSexo.setBounds(297, 105, 120, 22);
			cmbSexo.setFont(new Font("Sylfaen", Font.PLAIN, 14));
			contentPanel.add(cmbSexo);
		}
		{
			JLabel lblSexo = new JLabel("Sexo:");
			lblSexo.setBounds(262, 108, 33, 16);
			lblSexo.setFont(new Font("Sylfaen", Font.PLAIN, 14));
			contentPanel.add(lblSexo);
		}
		
		JLabel lblTelfono = new JLabel("Tel\u00E9fono:");
		lblTelfono.setBounds(17, 150, 77, 16);
		lblTelfono.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		contentPanel.add(lblTelfono);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(95, 146, 234, 22);
		contentPanel.add(txtTelefono);
		
		JLabel lblEspecialidad = new JLabel("Especialidad:");
		lblEspecialidad.setBounds(371, 150, 77, 16);
		lblEspecialidad.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		contentPanel.add(lblEspecialidad);
		
		JComboBox cmbEspecialidad = new JComboBox();
		cmbEspecialidad.setModel(new DefaultComboBoxModel(new String[] {"                  <Seleccione>", "Anestesiolog\u00EDa", "Anatom\u00EDa Patol\u00F3gica", "Cardiolog\u00EDa Cl\u00EDnica", "Cardiolog\u00EDa Intervencionista", " Cirug\u00EDa Pedi\u00E1trica", "Cirug\u00EDa General", "Cirug\u00EDa Pl\u00E1stica y Reconstructiva", "Gastroenterolog\u00EDa", "Ginegolog\u00EDa y Obstetricia", "Dermatolog\u00EDa", "Endoscopia del Aparato Digestivo", "Hematolog\u00EDa", "Infectolog\u00EDa de Adulto", "Medicina Cr\u00EDtica", "Medicina de Rehabilitaci\u00F3n", "Nefrolog\u00EDa", "Neurolog\u00EDa de Adultos", "Neumolog\u00EDa", "Oftalmolog\u00EDa", "Otorrinolaringolog\u00EDa", "Ortopedia", "Patolog\u00EDa", "Pediatr\u00EDa", "Psiquiatr\u00EDa General", "Radiolog\u00EDa e Imagen", "Neumolog\u00EDa", "Hematolog\u00EDa", "Cirug\u00EDa Oncol\u00F3gica", "Oncolog\u00EDa M\u00E9dica", "Oncolog\u00EDa Pedi\u00E1trica", "Radio-Oncolog\u00EDa", "Urolog\u00EDa"}));
		cmbEspecialidad.setToolTipText("asd\r\nasdas\r\nasdasd\r\nasd");
		cmbEspecialidad.setBounds(447, 146, 230, 22);
		cmbEspecialidad.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		contentPanel.add(cmbEspecialidad);
		{
			JLabel lblNewLabel_3 = new JLabel("F. de Nac.:");
			lblNewLabel_3.setBounds(17, 193, 70, 16);
			lblNewLabel_3.setFont(new Font("Sylfaen", Font.PLAIN, 14));
			contentPanel.add(lblNewLabel_3);
		}
		
		dtCalendario = new JDateChooser();
		dtCalendario.setBounds(95, 190, 234, 22);
		contentPanel.add(dtCalendario);
		{
			JLabel lblNewLabel_4 = new JLabel("Alma Mater:");
			lblNewLabel_4.setBounds(371, 193, 77, 16);
			lblNewLabel_4.setFont(new Font("Sylfaen", Font.PLAIN, 14));
			contentPanel.add(lblNewLabel_4);
		}
		{
			TxtAlmaMater = new JTextField();
			TxtAlmaMater.setColumns(10);
			TxtAlmaMater.setBounds(447, 190, 230, 22);
			contentPanel.add(TxtAlmaMater);
		}
		
		JLabel lblNewLabel_5 = new JLabel("Direccion");
		lblNewLabel_5.setBounds(17, 230, 104, 16);
		lblNewLabel_5.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		contentPanel.add(lblNewLabel_5);
		{
			txtDireccion = new JTextField();
			txtDireccion.setColumns(10);
			txtDireccion.setBounds(17, 253, 660, 99);
			contentPanel.add(txtDireccion);
		}
		{
			txtCodigo = new JTextField();
			txtCodigo.setColumns(10);
			txtCodigo.setBounds(95, 17, 234, 22);
			contentPanel.add(txtCodigo);
		}
		{
			txtCedula = new JTextField();
			txtCedula.setColumns(10);
			txtCedula.setBounds(447, 17, 230, 22);
			contentPanel.add(txtCedula);
		}
		{
			JLabel lblCdigo = new JLabel("C\u00F3digo:");
			lblCdigo.setFont(new Font("Sylfaen", Font.PLAIN, 14));
			lblCdigo.setBounds(17, 20, 77, 16);
			contentPanel.add(lblCdigo);
		}
		{
			JLabel lblCdula = new JLabel("C\u00E9dula:");
			lblCdula.setFont(new Font("Sylfaen", Font.PLAIN, 14));
			lblCdula.setBounds(371, 20, 77, 16);
			contentPanel.add(lblCdula);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton BtnRegistrar = new JButton("Registrar");
				BtnRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					
						Doctor doctor = null;
						String codigo = txtCodigo.getText();
						String exequartur = txtExequartur.getText();
						String cedula = txtCedula.getText();			
						String nombre = txtNombre.getText();
						String telefono = txtTelefono.getText();
						String direccion = txtDireccion.getText();			
						String especialidad = cmbEspecialidad.getSelectedItem().toString();
						String sexo =cmbSexo.getSelectedItem().toString();					
						String estadoCvl = cmbEstCivil.getSelectedItem().toString();
						String tpSangre = cmbTipoSangre.getSelectedItem().toString();
						String universidad = TxtAlmaMater.getText();
						Date fechaNacimiento = dtCalendario.getDate();
					//	DateFormat fechaFormato=new SimpleDateFormat("dd/MM/yyyy");  
					//	String fechaVacia = fechaFormato.format(fechaNacimiento);
						
						if(especialidad.isEmpty()||sexo.isEmpty()||estadoCvl.isEmpty()||tpSangre.isEmpty()||universidad.isEmpty()||telefono.isEmpty()||cedula.isEmpty()||codigo.isEmpty()||nombre.isEmpty()||exequartur.isEmpty()||direccion.isEmpty()) {
							JOptionPane.showMessageDialog(null, "CAMPO OBLIGATORIO VACIO", "Ha occurrido un error", JOptionPane.ERROR_MESSAGE);
						}
						else {
							
							doctor = new Doctor(codigo, cedula, nombre, sexo, estadoCvl, telefono, fechaNacimiento, direccion, tpSangre, exequartur, universidad, especialidad);
							ClinicaSONS.getInstance().insertarDoctor(doctor);
							JOptionPane.showMessageDialog(null, "Doctor registrado satisfactoriamente", "Operación exitosa", JOptionPane.PLAIN_MESSAGE);
							clean();
												
						
						}
						
					
					}

					
				});
				{
					JButton btnListaAccess = new JButton("Lista");
					btnListaAccess.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							ListarDoctores listillaLaGordilla = new ListarDoctores();
							listillaLaGordilla.setModal(true);
							listillaLaGordilla.setLocationRelativeTo(null);
							listillaLaGordilla.setVisible(true);
						
						
						}
					});
					buttonPane.add(btnListaAccess);
				}
				
				BtnRegistrar.setActionCommand("OK");
				buttonPane.add(BtnRegistrar);
				getRootPane().setDefaultButton(BtnRegistrar);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					
					dispose();
					
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	private void clean() {
		txtCedula.setText("");
		txtCodigo.setText("");
		txtDireccion.setText("");
		txtExequartur.setText("");
		txtNombre.setText("");
		txtTelefono.setText("");
		TxtAlmaMater.setText("");
		cmbEstCivil.setSelectedIndex(0);
		cmbSexo.setSelectedIndex(0);
		cmbTipoSangre.setSelectedIndex(0);
	    dtCalendario.setDateFormatString("");
	}
	
	
}
