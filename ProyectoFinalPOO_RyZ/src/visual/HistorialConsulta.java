package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import logico.ClinicaSONS;
import logico.Consulta;
import logico.Doctor;
import logico.Enfermedad;
import logico.Historial;
import logico.Paciente;
import logico.Persona;
import logico.Vacuna;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;

public class HistorialConsulta extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static JTextField txtCod;
	private static JTextField txtCed;
	private static JTextField txtNombre;
	private static JTextField txtTelef;
	private static JDateChooser dtNacimiento;
	private static JComboBox cmbTpSangre;
	private static JComboBox cmbSexo;
	private static JComboBox cmbEstCiv;
	private static JSpinner spnCantHijos;
	private JTextField txtMotivo;
	private JTextField txtTA;
	private JTextField txtPeso;
	private JTextField txtFC;
	private JTextField txtFR;
	private JTextField txtTemp;
	private JTextField txtDiag;
	private JTextField txtIndic;
	private SimpleDateFormat df;
	private static JTextField txtDir;
	private JTextField txtCodConsulta;
	private static Paciente miPac = null;
	private Doctor miDoc = null;
	private Consulta miCons = null;
	public static ArrayList<String> analisis;
	public static ArrayList<Vacuna> vacuna;
	public static JButton btnBuscar;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			HistorialConsulta dialog = new HistorialConsulta(null, null,null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * @param pac 
	 * @param cons 
	 */
	public HistorialConsulta(Doctor doc, Paciente pac, Consulta cons) {
		this.miCons = cons;
		miPac = pac;
		this.miDoc = ClinicaSONS.getLoginUserDoc();
		analisis = new ArrayList<>();
		vacuna = new ArrayList<>();
		setBounds(100, 100, 910, 970);
		setResizable(false);
		setLocationRelativeTo(null);
		if(miCons == null) {
			setTitle("Registrar consulta");
		}else {
			setTitle("Ver consulta");
		}
		df = new SimpleDateFormat("dd/MM/yyyy");
		initComponents();
	}

	private void initComponents() {
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informaci\u00F3n del paciente:", TitledBorder.LEADING, TitledBorder.TOP, new Font("Sylfaen", Font.PLAIN, 14), new Color(0, 0, 0)));
		panel_2.setBounds(12, 44, 870, 218);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel = new JLabel("C\u00F3d. pac:");
		lblNewLabel.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		lblNewLabel.setBounds(12, 31, 56, 16);
		panel_2.add(lblNewLabel);

		txtCod = new JTextField();
		txtCod.setEditable(false);
		txtCod.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		txtCod.setBounds(69, 27, 205, 22);
		panel_2.add(txtCod);
		txtCod.setColumns(10);

		JLabel lblCdula = new JLabel("C\u00E9dula:");
		lblCdula.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		lblCdula.setBounds(299, 28, 56, 16);
		panel_2.add(lblCdula);

		txtCed = new JTextField();
		txtCed.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		txtCed.setColumns(10);
		txtCed.setBounds(347, 27, 205, 22);
		panel_2.add(txtCed);

		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnBuscar.getText().equalsIgnoreCase("Buscar")) {
					if(txtCed.getText().trim().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Ingrese una c�dula v�lida","Ha ocurrido un error",JOptionPane.ERROR_MESSAGE);
					}else {
						Paciente pac = ClinicaSONS.getInstance().buscarPacienteByCedula(txtCed.getText());
						if(pac != null) {
							txtCed.setEnabled(false);
							dtNacimiento.setEnabled(false);
							cmbTpSangre.setEnabled(false);
							txtNombre.setText(pac.getNombre());
							txtTelef.setText(pac.getTelefono());
							dtNacimiento.setDate(pac.getFechaNacimiento());
							cmbTpSangre.setSelectedItem(pac.getTipoSangre());
							cmbSexo.setSelectedItem(pac.getSexo());
							cmbEstCiv.setSelectedItem(pac.getEstadoCivil());
							spnCantHijos.setValue(pac.getCantHijos());
							txtDir.setText(pac.getDireccion());
							btnBuscar.setText("Ver historial medico");
							miPac = pac;
							
						}else {
							JOptionPane.showMessageDialog(null, "El paciente no est� registrado", "Ha ocurrido un error", JOptionPane.ERROR_MESSAGE);
							HistorialMedico hist = new HistorialMedico(null);
							/*HistorialMedico.setDatos(txtCed.getText(), txtNombre.getText(), txtTelef.getText(), dtNacimiento.getDate(), 
									cmbTpSangre.getSelectedItem().toString(), cmbSexo.getSelectedItem().toString(), cmbEstCiv.getSelectedItem().toString(), 
									(int)spnCantHijos.getValue(),txtDir.getText());*/
							hist.setModal(true);
							hist.setVisible(true);
						}
					}
				}else {
					Paciente pac = ClinicaSONS.getInstance().buscarPacienteByCedula(txtCed.getText());
					HistorialMedico hist = new HistorialMedico(pac);
					hist.setModal(true);
					hist.setVisible(true);
				}
			}
		});
		btnBuscar.setForeground(Color.BLACK);
		btnBuscar.setBackground(Color.WHITE);
		btnBuscar.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		btnBuscar.setBounds(585, 27, 273, 22);
		panel_2.add(btnBuscar);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		lblNombre.setBounds(12, 60, 56, 16);
		panel_2.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		txtNombre.setColumns(10);
		txtNombre.setBounds(69, 56, 205, 22);
		panel_2.add(txtNombre);

		txtTelef = new JTextField();
		txtTelef.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		txtTelef.setColumns(10);
		txtTelef.setBounds(347, 57, 205, 22);
		panel_2.add(txtTelef);

		JLabel lblTelef = new JLabel("Telef:");
		lblTelef.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		lblTelef.setBounds(299, 61, 56, 16);
		panel_2.add(lblTelef);

		dtNacimiento = new JDateChooser();
		dtNacimiento.setDateFormatString("d/MM/yyyy");
		dtNacimiento.setBackground(Color.WHITE);
		dtNacimiento.setBounds(653, 56, 205, 22);
		dtNacimiento.setMaxSelectableDate(new Date());
		JTextFieldDateEditor edit = (JTextFieldDateEditor) dtNacimiento.getDateEditor();
		edit.setEditable(false);
		panel_2.add(dtNacimiento);

		JLabel lblFDeNac = new JLabel("F. de Nac.:");
		lblFDeNac.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		lblFDeNac.setBounds(585, 62, 71, 16);
		panel_2.add(lblFDeNac);

		JLabel lblEstCivil = new JLabel("Est. Civ.:");
		lblEstCivil.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		lblEstCivil.setBounds(12, 89, 56, 16);
		panel_2.add(lblEstCivil);

		cmbEstCiv = new JComboBox();
		cmbEstCiv.setBackground(Color.WHITE);
		cmbEstCiv.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Soltero/a", "Casado/a", "Separado/a", "Divorciado/a", "Viudo/a", "Uni\u00F3n Libre"}));
		cmbEstCiv.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		cmbEstCiv.setBounds(69, 85, 110, 22);
		panel_2.add(cmbEstCiv);

		JLabel lblCantHijos = new JLabel("Cant. Hijos:");
		lblCantHijos.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		lblCantHijos.setBounds(676, 89, 71, 16);
		panel_2.add(lblCantHijos);

		cmbSexo = new JComboBox();
		cmbSexo.setBackground(Color.WHITE);
		cmbSexo.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Femenino", "Masculino"}));
		cmbSexo.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		cmbSexo.setBounds(270, 85, 110, 22);
		panel_2.add(cmbSexo);

		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		lblSexo.setBounds(231, 89, 56, 16);
		panel_2.add(lblSexo);

		cmbTpSangre = new JComboBox();
		cmbTpSangre.setBackground(Color.WHITE);
		cmbTpSangre.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-"}));
		cmbTpSangre.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		cmbTpSangre.setBounds(515, 85, 110, 22);
		panel_2.add(cmbTpSangre);

		JLabel lblTpDeSangre = new JLabel("Tp. de Sangre.:");
		lblTpDeSangre.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		lblTpDeSangre.setBounds(421, 89, 87, 16);
		panel_2.add(lblTpDeSangre);

		spnCantHijos = new JSpinner();
		spnCantHijos.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		spnCantHijos.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spnCantHijos.setBackground(Color.WHITE);
		spnCantHijos.setBounds(748, 85, 110, 22);
		panel_2.add(spnCantHijos);

		JLabel lblDirecci = new JLabel("Direcci\u00F3n:");
		lblDirecci.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		lblDirecci.setBounds(12, 116, 71, 16);
		panel_2.add(lblDirecci);

		txtDir = new JTextField();
		txtDir.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		txtDir.setBounds(12, 133, 846, 72);
		panel_2.add(txtDir);
		txtDir.setColumns(10);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Motivo de Consulta:", TitledBorder.LEADING, TitledBorder.TOP, new Font("Sylfaen", Font.PLAIN, 14), new Color(0, 0, 0)));
		panel_3.setBounds(12, 275, 870, 140);
		panel.add(panel_3);
		panel_3.setLayout(null);

		txtMotivo = new JTextField();
		txtMotivo.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		txtMotivo.setBounds(12, 19, 846, 108);
		panel_3.add(txtMotivo);
		txtMotivo.setColumns(10);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "Evaluaci\u00F3n:", TitledBorder.LEADING, TitledBorder.TOP, new Font("Sylfaen", Font.PLAIN, 14), null));
		panel_4.setBounds(12, 428, 870, 74);
		panel.add(panel_4);
		panel_4.setLayout(null);

		JLabel lblTa = new JLabel("TA:");
		lblTa.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		lblTa.setBounds(12, 33, 56, 16);
		panel_4.add(lblTa);

		txtTA = new JTextField();
		txtTA.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		txtTA.setBounds(38, 29, 100, 22);
		panel_4.add(txtTA);
		txtTA.setColumns(10);

		txtPeso = new JTextField();
		txtPeso.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		txtPeso.setColumns(10);
		txtPeso.setBounds(758, 29, 100, 22);
		panel_4.add(txtPeso);

		txtFC = new JTextField();
		txtFC.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		txtFC.setColumns(10);
		txtFC.setBounds(210, 29, 100, 22);
		panel_4.add(txtFC);

		JLabel lblFc = new JLabel("FC:");
		lblFc.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		lblFc.setBounds(184, 31, 56, 16);
		panel_4.add(lblFc);

		txtFR = new JTextField();
		txtFR.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		txtFR.setColumns(10);
		txtFR.setBounds(377, 29, 100, 22);
		panel_4.add(txtFR);

		JLabel lblFr = new JLabel("FR:");
		lblFr.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		lblFr.setBounds(351, 31, 56, 16);
		panel_4.add(lblFr);

		txtTemp = new JTextField();
		txtTemp.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		txtTemp.setColumns(10);
		txtTemp.setBounds(574, 29, 100, 22);
		panel_4.add(txtTemp);

		JLabel lblPeso = new JLabel("PESO:");
		lblPeso.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		lblPeso.setBounds(715, 33, 56, 16);
		panel_4.add(lblPeso);

		JLabel lblTemp = new JLabel("TEMP:");
		lblTemp.setBounds(524, 33, 56, 16);
		panel_4.add(lblTemp);
		lblTemp.setFont(new Font("Sylfaen", Font.PLAIN, 14));

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(null, "Diagn\u00F3stico:", TitledBorder.LEADING, TitledBorder.TOP, new Font("Sylfaen", Font.PLAIN, 14), null));
		panel_5.setBounds(12, 543, 870, 140);
		panel.add(panel_5);
		panel_5.setLayout(null);

		txtDiag = new JTextField();
		txtDiag.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		txtDiag.setBounds(12, 18, 846, 109);
		panel_5.add(txtDiag);
		txtDiag.setColumns(10);

		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(null, "Indicaciones:", TitledBorder.LEADING, TitledBorder.TOP, new Font("Sylfaen", Font.PLAIN, 14), null));
		panel_6.setBounds(12, 696, 870, 140);
		panel.add(panel_6);
		panel_6.setLayout(null);

		txtIndic = new JTextField();
		txtIndic.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		txtIndic.setBounds(12, 18, 846, 109);
		txtIndic.setColumns(10);
		panel_6.add(txtIndic);

		JButton btnVerEnfer = new JButton("Ver lista de enfermedades");
		btnVerEnfer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarEnfermedad list = new ListarEnfermedad();
				list.setModal(true);
				list.setVisible(true);
			}
		});
		btnVerEnfer.setBackground(Color.WHITE);
		btnVerEnfer.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		btnVerEnfer.setBounds(109, 512, 300, 25);
		panel.add(btnVerEnfer);

		JLabel lblNewLabel_1 = new JLabel("Enfermedades:");
		lblNewLabel_1.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(458, 515, 87, 16);
		panel.add(lblNewLabel_1);

		JComboBox cmbEnferm = new JComboBox();
		cmbEnferm.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>"}));
		cmbEnferm.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		cmbEnferm.setBackground(Color.WHITE);
		cmbEnferm.setBounds(550, 512, 208, 22);
		panel.add(cmbEnferm);
		for (Enfermedad aux : ClinicaSONS.getInstance().getMisEnfermedades()) {
			cmbEnferm.addItem(aux);
		}

		JButton btnIndAnalisis = new JButton("Indicar an\u00E1lisis");
		if(miCons != null) {
			btnIndAnalisis.setText("Ver an�lisis");
		}
		if(miCons != null && miCons.getAnalisis().size() == 0) {
			btnIndAnalisis.setEnabled(false);
		}
		btnIndAnalisis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IndicarAnalisis ind = new IndicarAnalisis(miCons);
				IndicarAnalisis.setNombre(txtNombre.getText());
				IndicarAnalisis.setEdad(dtNacimiento.getDate());
				ind.setModal(true);
				ind.setVisible(true);
			}
		});
		btnIndAnalisis.setBackground(Color.WHITE);
		btnIndAnalisis.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		btnIndAnalisis.setBounds(148, 845, 230, 25);
		panel.add(btnIndAnalisis);

		JButton btnIndicarVacunas = new JButton("Indicar vacunas");
		if(miCons != null) {
			btnIndicarVacunas.setText("Ver vacunas");
		}
		btnIndicarVacunas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				IndicarVacunas ind = new IndicarVacunas(null);
				ind.setModal(true);
				ind.setVisible(true);

			}
		});
		btnIndicarVacunas.setBackground(Color.WHITE);
		btnIndicarVacunas.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		btnIndicarVacunas.setBounds(526, 845, 230, 25);
		panel.add(btnIndicarVacunas);

		JLabel lblNewLabel_2 = new JLabel("C\u00F3digo de consulta:");
		lblNewLabel_2.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(632, 18, 116, 16);
		panel.add(lblNewLabel_2);

		txtCodConsulta = new JTextField();
		txtCodConsulta.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		txtCodConsulta.setEditable(false);
		txtCodConsulta.setBounds(749, 15, 133, 22);
		panel.add(txtCodConsulta);
		txtCodConsulta.setColumns(10);
		codigos();

		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setAlignment(FlowLayout.TRAILING);
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(panel_1, BorderLayout.SOUTH);

		JButton btnRegistrar = new JButton("Registrar");
		if(miCons != null) {
			btnRegistrar.setVisible(false);
			for(int i = 0;i < panel.getComponentCount();i++){
				panel.getComponent(i).setEnabled(false);
			}
		}
		btnRegistrar.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		btnRegistrar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					if(miCons == null) {
						String codConsulta = txtCodConsulta.getText();
						String codPac = txtCod.getText();
						String cedula = txtCed.getText();
						String nombre = txtNombre.getText();
						String telefono = txtTelef.getText();
						Date fechaNacimiento = dtNacimiento.getDate();
						String estadoCivil = cmbEstCiv.getSelectedItem().toString();
						String sexo = cmbSexo.getSelectedItem().toString();
						String tipoSangre = cmbTpSangre.getSelectedItem().toString();
						int cantHijos = (int) spnCantHijos.getValue();
						String direccion = txtDir.getText();
						String motivo = txtMotivo.getText();
						float ta = Float.valueOf(txtTA.getText());
						float fr = Float.valueOf(txtFR.getText());
						float fc = Float.valueOf(txtFC.getText());
						float temp = Float.valueOf(txtTemp.getText());
						float peso = Float.valueOf(txtPeso.getText());
						String diagnostico = txtDiag.getText();
						String indic = txtIndic.getText();


						if(cedula.trim().isEmpty()||nombre.trim().isEmpty()||telefono.trim().isEmpty()||fechaNacimiento == null||estadoCivil.trim().isEmpty()
								||sexo.trim().isEmpty()||tipoSangre.trim().isEmpty()||direccion.trim().isEmpty()||diagnostico.trim().isEmpty()||indic.trim().isEmpty()) {
							JOptionPane.showMessageDialog(null, "Favor llenar los espacios vac�os.", "Ha ocurrido un error",JOptionPane.ERROR_MESSAGE);;
						}else if(miPac == null){
							JOptionPane.showMessageDialog(null, "El paciente no ha sido registrado correctamente, favor de llenar los datos correspondientes a su historial m�dico.");
							HistorialMedico hist = new HistorialMedico(null);
							/*HistorialMedico.setDatos(txtCed.getText(), txtNombre.getText(), txtTelef.getText(), dtNacimiento.getDate(), 
									cmbTpSangre.getSelectedItem().toString(), cmbSexo.getSelectedItem().toString(), cmbEstCiv.getSelectedItem().toString(), 
									(int)spnCantHijos.getValue(),txtDir.getText());*/
							hist.setModal(true);
							hist.setVisible(true);
						}else {
							Date fecha = new Date();
							Consulta cons = new Consulta(codConsulta, motivo, ta, fc, fr, temp, peso, diagnostico,indic,fecha);
							if(analisis.size() > 0) {
								for (String aux : analisis) {
									cons.insertarAnalisis(aux);
								}
							}
							if(vacuna.size() > 0) {
								for (Vacuna aux : vacuna) {
									miPac.insertarVacuna(aux);
								}
							}
							ClinicaSONS.getInstance().insertarConsulta(cons);
							cons.setCedPac(miPac.getCedula());

							if(ClinicaSONS.getInstance().buscarPacientePorCodigo(miPac.getCod()) == null) {
								ClinicaSONS.getInstance().insertarPersona(miPac);
							}
							if(cmbEnferm.getSelectedItem().toString().equalsIgnoreCase("<Seleccione>")) {
								int option = JOptionPane.showConfirmDialog(null, "�Desea agregar esta consulta al historial m�dico del paciente?");
								if(option == JOptionPane.YES_OPTION) {
									miPac.getMiHistorial().insertarConsulta(cons);
									JOptionPane.showMessageDialog(null, "La consulta ha sido agregada con �xito", "Operaci�n exitosa", JOptionPane.INFORMATION_MESSAGE);
								}else{
									JOptionPane.showMessageDialog(null, "La consulta ha sido agregada con �xito", "Operaci�n exitosa", JOptionPane.INFORMATION_MESSAGE);
								}
							}
							if(miDoc != null) {
								miDoc.agregarConsulta(cons);
								cons.setNomDoctor(miDoc.getNombre());
							}
							
							
							if(cmbEnferm.getSelectedItem() != "<Seleccione>") {
								Enfermedad enf = ClinicaSONS.getInstance().buscarEnfermedadByNombre(cmbEnferm.getSelectedItem().toString());
								cons.setEnfermedad(enf);
								miPac.getMiHistorial().insertarConsulta(cons);
							}
							clean();
							System.out.println(cons.getCedPac());
						}
					}else {
						Paciente pac = ClinicaSONS.getInstance().buscarPacientePorCodigo(miCons.getCedPac());
						txtCodConsulta.setText(miCons.getCod());
						txtCod.setText(pac.getCod());
						txtCed.setText(pac.getCedula());
						txtNombre.setText(pac.getNombre());
						txtTelef.setText(pac.getTelefono());
						dtNacimiento.setDate(pac.getFechaNacimiento());
						cmbEstCiv.setSelectedItem(pac.getEstadoCivil());
						cmbSexo.setSelectedItem(pac.getSexo());
						cmbTpSangre.setSelectedItem(pac.getTipoSangre());
						spnCantHijos.setValue(pac.getCantHijos());
						txtDir.setText(pac.getDireccion());
						txtMotivo.setText(miCons.getMotivo());
						txtTA.setText(String.valueOf(miCons.getTa()));
						txtFR.setText(String.valueOf(miCons.getFr()));
						txtFC.setText(String.valueOf(miCons.getFc()));
						txtTemp.setText(String.valueOf(miCons.getTemp()));
						txtPeso.setText(String.valueOf(miCons.getPeso()));
						txtDiag.setText(String.valueOf(miCons.getDiagnostico()));
						txtIndic.setText(String.valueOf(miCons.getIndicaciones()));
					}
				} catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(null, "Los datos de la evaluaci�n deben ser num�ricos.", "Ha ocurrido un error",JOptionPane.ERROR_MESSAGE);
				}
			}	
		});
		panel_1.add(btnRegistrar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		panel_1.add(btnCancelar);

		cargarPaciente(miPac);
		cargarConsulta(miPac);
	}

	public void clean() {
		codigos();
		txtCed.setText("");
		txtCed.setEditable(true);
		txtNombre.setText("");
		txtTelef.setText("");
		txtDir.setText("");
		dtNacimiento.setDate(null);
		cmbTpSangre.setSelectedItem("<Seleccione>");
		cmbSexo.setSelectedItem("<Seleccione>");
		cmbEstCiv.setSelectedItem("<Seleccione>");
		spnCantHijos.setValue(0);
		txtMotivo.setText("");
		txtTA.setText("");
		txtFC.setText("");
		txtFR.setText("");
		txtTemp.setText("");
		txtPeso.setText("");
		txtDiag.setText("");
		txtIndic.setText("");
		btnBuscar.setText("Buscar");
	}

	public void codigos() {
		int cont = 1;
		int cant = 1;
		for (Persona aux : ClinicaSONS.getInstance().getMisPersonas()) {
			if(aux instanceof Paciente) {
				cont++;
			}
		}
		txtCod.setText("P-"+cont);

		for (Consulta aux2 : ClinicaSONS.getInstance().getMisConsultas()) {
			cant++;
		}
		txtCodConsulta.setText("C-"+cont);

	}

	public static void cargarPaciente(Paciente pac) {
		if(pac != null) {
			txtCed.setText(pac.getCedula());
			txtCed.setEditable(false);
			txtCod.setText(pac.getCod());
			txtNombre.setText(pac.getNombre());
			txtTelef.setText(pac.getTelefono());
			txtDir.setText(pac.getDireccion());
			dtNacimiento.setDate(pac.getFechaNacimiento());
			cmbTpSangre.setSelectedItem(pac.getTipoSangre());
			cmbSexo.setSelectedItem(pac.getSexo());
			cmbEstCiv.setSelectedItem(pac.getEstadoCivil());
			spnCantHijos.setValue(pac.getCantHijos());
		}
	}

	public void cargarConsulta(Paciente pac) {
		if(miCons != null) {
			cargarPaciente(pac);
			txtCodConsulta.setText(miCons.getCod());
			txtMotivo.setText(miCons.getMotivo());
			txtTA.setText(String.valueOf(miCons.getTa()));
			txtFC.setText(String.valueOf(miCons.getFc()));
			txtFR.setText(String.valueOf(miCons.getFr()));
			txtTemp.setText(String.valueOf(miCons.getTemp()));
			txtPeso.setText(String.valueOf(miCons.getPeso()));
			txtDiag.setText(miCons.getDiagnostico());
			txtIndic.setText(miCons.getIndicaciones());
			cmbTpSangre.setEditable(false);
		}
	}

	public static void guardarAnalisis(String check) {
		analisis.add(check);
	}

	public static void guardarVacuna(Vacuna vacun) {
		vacuna.add(vacun);
	}

	public static void setPaciente(Paciente pac) {
		miPac = pac;
	}
}
