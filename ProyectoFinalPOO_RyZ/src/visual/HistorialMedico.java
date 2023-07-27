package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import logico.ClinicaSONS;
import logico.Consulta;
import logico.Doctor;
import logico.Historial;
import logico.Paciente;
import logico.Persona;
import logico.Vacuna;

import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class HistorialMedico extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodPac;
	private JTextField txtCed;
	private JTextField txtTel;
	private JTextField txtAntPers;
	private JTextField txtAntFam;
	private JTextField txtAntFis;
	private JTable tablaConsultas;
	private DefaultTableModel modelConsulta;
	private DefaultTableModel modelVacuna;
	private Object[] rowConsulta = null;
	private Object[] rowVacuna = null;
	private JTextField txtCodHist;
	private JTable tablaVacunas;
	private JButton btnVerCon;
	private JButton btnVerVacuna;
	private JButton btnCancelar;
	private JComboBox cmbEstCivil;
	private JComboBox cmbSexo;
	private JTextField txtNombre;
	private JComboBox cmbTpSangre;
	private JSpinner spnCantHijos;
	private JComboBox cmbFuma;
	private JComboBox cmbAlcohol;
	private JComboBox cmbCafe;
	private JComboBox cmbDrogas;
	private JDateChooser dtNacimiento;
	private Paciente miPac = null;
	private JTextField txtDir;
	private JTextField txtCirugias;
	private JTextField txtAlergia;
	private JTextField txtTrauma;
	private JTextField txtTransf;
	private JComboBox cmbTieneAlergia;
	private JComboBox cmbTieneCir;
	private JComboBox cmbTieneTrau;
	private JComboBox cmbTieneTransf;
	private Doctor miDoc = null;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			HistorialMedico dialog = new HistorialMedico(null,null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * @param pac 
	 */
	public HistorialMedico(Doctor doc,Paciente pac) {
		this.miDoc  = doc;
		this.miPac = pac;
		setBounds(100, 100, 1090, 1030);
		setLocationRelativeTo(null);
		setResizable(false);
		initComponents();
	}

	private void initComponents() {
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informaci\u00F3n personal del paciente:", TitledBorder.LEADING, TitledBorder.TOP, new Font("Sylfaen", Font.PLAIN, 14), new Color(0, 0, 0)));
			panel.setBounds(12, 13, 1050, 415);
			contentPanel.add(panel);
			{
				JLabel lblCdPac = new JLabel("C\u00F3d. pac:");
				lblCdPac.setFont(new Font("Sylfaen", Font.PLAIN, 14));
				lblCdPac.setBounds(368, 23, 56, 16);
				panel.add(lblCdPac);
			}
			{
				txtCodPac = new JTextField();
				txtCodPac.setText("P-"+ClinicaSONS.codPac);
				txtCodPac.setFont(new Font("Sylfaen", Font.PLAIN, 14));
				txtCodPac.setEditable(false);
				txtCodPac.setColumns(10);
				txtCodPac.setBounds(436, 20, 254, 22);
				panel.add(txtCodPac);
			}
			{
				JLabel label = new JLabel("C\u00E9dula:");
				label.setFont(new Font("Sylfaen", Font.PLAIN, 14));
				label.setBounds(716, 23, 56, 16);
				panel.add(label);
			}
			{
				txtCed = new JTextField();
				txtCed.setFont(new Font("Sylfaen", Font.PLAIN, 14));
				txtCed.setColumns(10);
				txtCed.setBounds(784, 20, 254, 22);
				panel.add(txtCed);
			}
			{
				JLabel label = new JLabel("Nombre:");
				label.setFont(new Font("Sylfaen", Font.PLAIN, 14));
				label.setBounds(12, 51, 56, 16);
				panel.add(label);
			}
			{
				txtNombre = new JTextField();
				txtNombre.setFont(new Font("Sylfaen", Font.PLAIN, 14));
				txtNombre.setColumns(10);
				txtNombre.setBounds(83, 48, 254, 22);
				panel.add(txtNombre);
			}
			{
				txtTel = new JTextField();
				txtTel.setFont(new Font("Sylfaen", Font.PLAIN, 14));
				txtTel.setColumns(10);
				txtTel.setBounds(436, 48, 254, 22);
				panel.add(txtTel);
			}
			{
				JLabel lblTelefono = new JLabel("Telefono:");
				lblTelefono.setFont(new Font("Sylfaen", Font.PLAIN, 14));
				lblTelefono.setBounds(368, 51, 56, 16);
				panel.add(lblTelefono);
			}
			{
				dtNacimiento = new JDateChooser();
				dtNacimiento.setDateFormatString("d/MM/ yyyy");
				dtNacimiento.setBackground(Color.WHITE);
				dtNacimiento.setBounds(784, 48, 254, 22);
				panel.add(dtNacimiento);
			}
			{
				JLabel label = new JLabel("F. de Nac.:");
				label.setFont(new Font("Sylfaen", Font.PLAIN, 14));
				label.setBounds(716, 51, 71, 16);
				panel.add(label);
			}
			{
				JLabel label = new JLabel("Est. Civ.:");
				label.setFont(new Font("Sylfaen", Font.PLAIN, 14));
				label.setBounds(12, 80, 56, 16);
				panel.add(label);
			}
			{
				cmbEstCivil = new JComboBox();
				cmbEstCivil.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Soltero/a", "Casado/a", "Separado/a", "Divorciado/a", "Viudo/a", "Uni\u00F3n Libre"}));
				cmbEstCivil.setFont(new Font("Sylfaen", Font.PLAIN, 14));
				cmbEstCivil.setBackground(Color.WHITE);
				cmbEstCivil.setBounds(72, 76, 145, 22);
				panel.add(cmbEstCivil);
			}
			{
				JLabel label = new JLabel("Cant. Hijos:");
				label.setFont(new Font("Sylfaen", Font.PLAIN, 14));
				label.setBounds(821, 80, 71, 16);
				panel.add(label);
			}
			{
				cmbSexo = new JComboBox();
				cmbSexo.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Femenino", "Masculino"}));
				cmbSexo.setFont(new Font("Sylfaen", Font.PLAIN, 14));
				cmbSexo.setBackground(Color.WHITE);
				cmbSexo.setBounds(324, 76, 145, 22);
				panel.add(cmbSexo);
			}
			{
				JLabel label = new JLabel("Sexo:");
				label.setFont(new Font("Sylfaen", Font.PLAIN, 14));
				label.setBounds(285, 80, 56, 16);
				panel.add(label);
			}
			{
				cmbTpSangre = new JComboBox();
				cmbTpSangre.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-"}));
				cmbTpSangre.setFont(new Font("Sylfaen", Font.PLAIN, 14));
				cmbTpSangre.setBackground(Color.WHITE);
				cmbTpSangre.setBounds(618, 76, 145, 22);
				panel.add(cmbTpSangre);
			}
			{
				JLabel label = new JLabel("Tp. de Sangre.:");
				label.setFont(new Font("Sylfaen", Font.PLAIN, 14));
				label.setBounds(524, 80, 87, 16);
				panel.add(label);
			}
			{
				spnCantHijos = new JSpinner();
				spnCantHijos.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
				spnCantHijos.setFont(new Font("Sylfaen", Font.PLAIN, 14));
				spnCantHijos.setBackground(Color.WHITE);
				spnCantHijos.setBounds(893, 76, 145, 22);
				panel.add(spnCantHijos);
			}
			{
				JLabel lblNewLabel = new JLabel("Cod. hist.:");
				lblNewLabel.setBounds(12, 23, 109, 16);
				panel.add(lblNewLabel);
				lblNewLabel.setFont(new Font("Sylfaen", Font.PLAIN, 14));
			}
			{
				txtCodHist = new JTextField();
				txtCodHist.setBounds(83, 20, 254, 22);
				panel.add(txtCodHist);
				txtCodHist.setEditable(false);
				txtCodHist.setFont(new Font("Sylfaen", Font.PLAIN, 14));
				txtCodHist.setColumns(10);
				txtCodHist.setText("H-"+ClinicaSONS.codHist);
			}
			{
				txtDir = new JTextField();
				txtDir.setColumns(10);
				txtDir.setBounds(12, 124, 1026, 49);
				panel.add(txtDir);
			}
			{
				JLabel label = new JLabel("Direcci\u00F3n:");
				label.setFont(new Font("Sylfaen", Font.PLAIN, 14));
				label.setBounds(12, 107, 71, 16);
				panel.add(label);
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBounds(12, 183, 1026, 60);
				panel.add(panel_1);
				panel_1.setLayout(null);
				panel_1.setBorder(new TitledBorder(null, "H\u00E1bitos t\u00F3xicos:", TitledBorder.LEADING, TitledBorder.TOP, new Font("Sylfaen", Font.PLAIN, 14), null));
				{
					JLabel label = new JLabel("\u00BFFuma?:");
					label.setFont(new Font("Sylfaen", Font.PLAIN, 14));
					label.setBounds(12, 26, 56, 16);
					panel_1.add(label);
				}
				{
					cmbFuma = new JComboBox();
					cmbFuma.setBackground(Color.WHITE);
					cmbFuma.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Si", "No"}));
					cmbFuma.setFont(new Font("Sylfaen", Font.PLAIN, 14));
					cmbFuma.setBounds(63, 23, 125, 22);
					panel_1.add(cmbFuma);
				}
				{
					JLabel label = new JLabel("\u00BFConsume drogas?:");
					label.setFont(new Font("Sylfaen", Font.PLAIN, 14));
					label.setBounds(773, 26, 109, 16);
					panel_1.add(label);
				}
				{
					cmbDrogas = new JComboBox();
					cmbDrogas.setBackground(Color.WHITE);
					cmbDrogas.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Si", "No"}));
					cmbDrogas.setFont(new Font("Sylfaen", Font.PLAIN, 14));
					cmbDrogas.setBounds(889, 23, 125, 22);
					panel_1.add(cmbDrogas);
				}
				{
					JLabel label = new JLabel("\u00BFToma alcohol?:");
					label.setFont(new Font("Sylfaen", Font.PLAIN, 14));
					label.setBounds(239, 26, 95, 16);
					panel_1.add(label);
				}
				{
					cmbAlcohol = new JComboBox();
					cmbAlcohol.setBackground(Color.WHITE);
					cmbAlcohol.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Si", "No"}));
					cmbAlcohol.setFont(new Font("Sylfaen", Font.PLAIN, 14));
					cmbAlcohol.setBounds(334, 23, 125, 22);
					panel_1.add(cmbAlcohol);
				}
				{
					JLabel label = new JLabel("\u00BFToma caf\u00E9?:");
					label.setFont(new Font("Sylfaen", Font.PLAIN, 14));
					label.setBounds(514, 26, 81, 16);
					panel_1.add(label);
				}
				{
					cmbCafe = new JComboBox();
					cmbCafe.setBackground(Color.WHITE);
					cmbCafe.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Si", "No"}));
					cmbCafe.setFont(new Font("Sylfaen", Font.PLAIN, 14));
					cmbCafe.setBounds(594, 23, 125, 22);
					panel_1.add(cmbCafe);
				}
			}
			{
				JLabel label = new JLabel("\u00BFCirug\u00EDas?:");
				label.setFont(new Font("Sylfaen", Font.PLAIN, 14));
				label.setBounds(12, 259, 67, 16);
				panel.add(label);
			}
			{
				cmbTieneCir = new JComboBox();
				cmbTieneCir.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent e) {
						if(cmbTieneCir.getSelectedItem().toString().equalsIgnoreCase("Si")) {
							txtCirugias.setEditable(true);
						}else{
							txtCirugias.setEditable(false);
						}
					}
				});
				cmbTieneCir.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Si", "No"}));
				cmbTieneCir.setFont(new Font("Sylfaen", Font.PLAIN, 14));
				cmbTieneCir.setBackground(Color.WHITE);
				cmbTieneCir.setBounds(77, 256, 125, 22);
				panel.add(cmbTieneCir);
			}
			{
				JLabel label = new JLabel("\u00BFAlergias?:");
				label.setFont(new Font("Sylfaen", Font.PLAIN, 14));
				label.setBounds(263, 259, 95, 16);
				panel.add(label);
			}
			{
				cmbTieneAlergia = new JComboBox();
				cmbTieneAlergia.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent e) {
						if(cmbTieneAlergia.getSelectedItem().toString().equalsIgnoreCase("Si")) {
							txtAlergia.setEditable(true);
						}else{
							txtAlergia.setEditable(false);
						}
					}
				});
				cmbTieneAlergia.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Si", "No"}));
				cmbTieneAlergia.setFont(new Font("Sylfaen", Font.PLAIN, 14));
				cmbTieneAlergia.setBackground(Color.WHITE);
				cmbTieneAlergia.setBounds(332, 256, 125, 22);
				panel.add(cmbTieneAlergia);
			}
			{
				JLabel label = new JLabel("\u00BFTraumatismos?:");
				label.setFont(new Font("Sylfaen", Font.PLAIN, 14));
				label.setBounds(524, 259, 102, 16);
				panel.add(label);
			}
			{
				cmbTieneTrau = new JComboBox();
				cmbTieneTrau.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent e) {
						if(cmbTieneTrau.getSelectedItem().toString().equalsIgnoreCase("Si")) {
							txtTrauma.setEditable(true);
						}else{
							txtTrauma.setEditable(false);
						}
					}
				});
				cmbTieneTrau.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Si", "No"}));
				cmbTieneTrau.setFont(new Font("Sylfaen", Font.PLAIN, 14));
				cmbTieneTrau.setBackground(Color.WHITE);
				cmbTieneTrau.setBounds(627, 256, 125, 22);
				panel.add(cmbTieneTrau);
			}
			{
				JLabel label = new JLabel("\u00BFTransfusiones?:");
				label.setFont(new Font("Sylfaen", Font.PLAIN, 14));
				label.setBounds(817, 259, 109, 16);
				panel.add(label);
			}
			{
				cmbTieneTransf = new JComboBox();
				cmbTieneTransf.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent e) {
						if(cmbTieneTransf.getSelectedItem().toString().equalsIgnoreCase("Si")) {
							txtTransf.setEditable(true);
						}else{
							txtTransf.setEditable(false);
						}
					}
				});
				cmbTieneTransf.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Si", "No"}));
				cmbTieneTransf.setFont(new Font("Sylfaen", Font.PLAIN, 14));
				cmbTieneTransf.setBackground(Color.WHITE);
				cmbTieneTransf.setBounds(913, 256, 125, 22);
				panel.add(cmbTieneTransf);
			}
			{
				txtCirugias = new JTextField();
				txtCirugias.setEditable(false);
				txtCirugias.setBounds(12, 288, 190, 114);
				panel.add(txtCirugias);
				txtCirugias.setColumns(10);
			}
			{
				txtAlergia = new JTextField();
				txtAlergia.setEditable(false);
				txtAlergia.setColumns(10);
				txtAlergia.setBounds(263, 288, 194, 114);
				panel.add(txtAlergia);
			}
			{
				txtTrauma = new JTextField();
				txtTrauma.setEditable(false);
				txtTrauma.setColumns(10);
				txtTrauma.setBounds(524, 288, 228, 114);
				panel.add(txtTrauma);
			}
			{
				txtTransf = new JTextField();
				txtTransf.setEditable(false);
				txtTransf.setColumns(10);
				txtTransf.setBounds(817, 288, 221, 114);
				panel.add(txtTransf);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Antecedentes personales:", TitledBorder.LEADING, TitledBorder.TOP, new Font("Sylfaen", Font.PLAIN, 14), null));
			panel.setBounds(12, 431, 1050, 84);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				txtAntPers = new JTextField();
				txtAntPers.setFont(new Font("Sylfaen", Font.PLAIN, 14));
				txtAntPers.setBounds(10, 18, 1031, 53);
				panel.add(txtAntPers);
				txtAntPers.setColumns(10);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Antecedentes familiares:", TitledBorder.LEADING, TitledBorder.TOP, new Font("Sylfaen", Font.PLAIN, 14), null));
			panel.setBounds(12, 518, 1050, 84);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				txtAntFam = new JTextField();
				txtAntFam.setFont(new Font("Sylfaen", Font.PLAIN, 14));
				txtAntFam.setColumns(10);
				txtAntFam.setBounds(9, 18, 1031, 53);
				panel.add(txtAntFam);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Antecedentes fisiológicos:", TitledBorder.LEADING, TitledBorder.TOP, new Font("Sylfaen", Font.PLAIN, 14), null));
			panel.setBounds(12, 607, 1050, 84);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				txtAntFis = new JTextField();
				txtAntFis.setFont(new Font("Sylfaen", Font.PLAIN, 14));
				txtAntFis.setColumns(10);
				txtAntFis.setBounds(9, 18, 1031, 53);
				panel.add(txtAntFis);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Consultas importantes:", TitledBorder.LEADING, TitledBorder.TOP, new Font("Sylfaen", Font.PLAIN, 14), null));
			panel.setBounds(12, 694, 505, 232);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				scrollPane.setBounds(9, 20, 487, 171);
				panel.add(scrollPane);
				
				tablaConsultas = new JTable();
				modelConsulta = new DefaultTableModel();
				String[] headers = {"Código","Motivo de Consulta","Diagnóstico"};
				modelConsulta.setColumnIdentifiers(headers);
				tablaConsultas.setModel(modelConsulta);
				tablaConsultas.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);;
				TableColumnModel columnModel = tablaConsultas.getColumnModel();
				columnModel.getColumn(0).setPreferredWidth(60);
				columnModel.getColumn(1).setPreferredWidth(213);
				columnModel.getColumn(2).setPreferredWidth(213);
				tablaConsultas.setRowHeight(60);
				scrollPane.setViewportView(tablaConsultas);
			}
			{
				btnVerCon = new JButton("Ver consulta");
				btnVerCon.setEnabled(false);
				btnVerCon.setFont(new Font("Sylfaen", Font.PLAIN, 14));
				btnVerCon.setBackground(Color.WHITE);
				btnVerCon.setBounds(172, 197, 160, 25);
				panel.add(btnVerCon);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setBorder(new TitledBorder(null, "Vacunas:", TitledBorder.LEADING, TitledBorder.TOP, new Font("Sylfaen", Font.PLAIN, 14), null));
			panel.setBounds(557, 694, 505, 232);
			contentPanel.add(panel);
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				scrollPane.setBounds(9, 20, 487, 171);
				panel.add(scrollPane);
				{
					tablaVacunas = new JTable();
					modelVacuna = new DefaultTableModel();
					String[] headers = {"Código","Nombre","Descripción"};
					modelVacuna.setColumnIdentifiers(headers);
					tablaVacunas.setModel(modelVacuna);
					tablaConsultas.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);;
					TableColumnModel columnModel = tablaVacunas.getColumnModel();
					columnModel.getColumn(0).setPreferredWidth(60);
					columnModel.getColumn(1).setPreferredWidth(150);
					columnModel.getColumn(2).setPreferredWidth(250);
					tablaVacunas.setRowHeight(60);
					scrollPane.setViewportView(tablaVacunas);
				}
			}
			{
				btnVerVacuna = new JButton("Ver vacuna");
				btnVerVacuna.setEnabled(false);
				btnVerVacuna.setFont(new Font("Sylfaen", Font.PLAIN, 14));
				btnVerVacuna.setBackground(Color.WHITE);
				btnVerVacuna.setBounds(172, 197, 160, 25);
				panel.add(btnVerVacuna);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnRegistrar = new JButton("Registrar");
				btnRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String codHist = txtCodHist.getText();
						String codPac = txtCodPac.getText();
						String ced = txtCed.getText();
						String nom = txtNombre.getText();
						String tel = txtTel.getText();
						Date fNac = dtNacimiento.getDate();
						String estCiv = cmbEstCivil.getSelectedItem().toString();
						String sexo = cmbSexo.getSelectedItem().toString();
						String tpSangre = cmbTpSangre.getSelectedItem().toString();
						int cantHijos = (int) spnCantHijos.getValue();
						String dir = txtDir.getText();
						String fuma = cmbFuma.getSelectedItem().toString();
						String alc = cmbAlcohol.getSelectedItem().toString();
						String caf = cmbCafe.getSelectedItem().toString();
						String drog = cmbDrogas.getSelectedItem().toString();
						String antPer = txtAntPers.getText();
						String antFam = txtAntFam.getText();
						String antFis = txtAntFis.getText();
						String tieCir = cmbTieneCir.getSelectedItem().toString();
						String tieAle = cmbTieneAlergia.getSelectedItem().toString();
						String tieTrau = cmbTieneTrau.getSelectedItem().toString();
						String tieTrans = cmbTieneTransf.getSelectedItem().toString();
						String cir = txtCirugias.getText();
						String ale = txtAlergia.getText();
						String trau = txtTrauma.getText();
						String trans = txtTransf.getText();
						String codHis = txtCodHist.getText();
						
						if(ced.trim().isEmpty() || nom.trim().isEmpty() || tel.trim().isEmpty() || fNac == null || dir.trim().isEmpty() 
						|| antPer.trim().isEmpty() || antFam.trim().isEmpty() || antFis.trim().isEmpty()) {
							JOptionPane.showMessageDialog(null, "Complete los campos vacíos", "¡Error!",JOptionPane.ERROR_MESSAGE);
						}else if(cmbAlcohol.getSelectedItem().toString().equalsIgnoreCase("<Seleccione>") || cmbCafe.getSelectedItem().toString().equalsIgnoreCase("<Seleccione>")
								|| cmbDrogas.getSelectedItem().toString().equalsIgnoreCase("<Seleccione>") || cmbEstCivil.getSelectedItem().toString().equalsIgnoreCase("<Seleccione>")
								|| cmbFuma.getSelectedItem().toString().equalsIgnoreCase("<Seleccione>") || cmbSexo.getSelectedItem().toString().equalsIgnoreCase("<Seleccione>")
								|| cmbTpSangre.getSelectedItem().toString().equalsIgnoreCase("<Seleccione>") || cmbTieneAlergia.getSelectedItem().toString().equalsIgnoreCase("<Seleccione>")
								|| cmbTieneCir.getSelectedItem().toString().equalsIgnoreCase("<Seleccione>") || cmbTieneTransf.getSelectedItem().toString().equalsIgnoreCase("<Seleccione>")
								|| cmbTieneTrau.getSelectedItem().toString().equalsIgnoreCase("<Seleccione>")){
							JOptionPane.showMessageDialog(null, "Seleccione opciones válidas", "¡Error!",JOptionPane.ERROR_MESSAGE);
						}else if(txtCirugias.isEditable() && cir.trim().isEmpty()){
							JOptionPane.showMessageDialog(null, "Especifique las cirugías realizadas", "¡Error!",JOptionPane.ERROR_MESSAGE);
						}else if(txtAlergia.isEditable() && ale.trim().isEmpty()){
							JOptionPane.showMessageDialog(null, "Especifique las alergías del paciente", "¡Error!",JOptionPane.ERROR_MESSAGE);
						}else if(txtTrauma.isEditable() && trau.trim().isEmpty()){
							JOptionPane.showMessageDialog(null, "Especifique los traumatismos sufridos", "¡Error!",JOptionPane.ERROR_MESSAGE);
						}else if(txtTransf.isEditable() && trans.trim().isEmpty()){
							JOptionPane.showMessageDialog(null, "Especifique los transfusiones realizadas", "¡Error!",JOptionPane.ERROR_MESSAGE);
						}else{
							Historial miHist = new Historial(codHis);
							ClinicaSONS.getInstance().insertarHistorial(miHist);
							Paciente pac = new Paciente(codPac, ced, nom, sexo, estCiv, tel, fNac, dir, tpSangre, cantHijos, fuma, alc, caf, drog, tieAle, ale, tieCir, cir, tieTrans, trans, tieTrau, trau, antPer, antFam, miHist, antFis);
							ClinicaSONS.getInstance().insertarPersona(pac);
							miDoc.agregarPaciente(pac);
							JOptionPane.showMessageDialog(null, "Paciente agregado con éxito", "¡Operación exitosa!",JOptionPane.INFORMATION_MESSAGE);
							HistorialConsulta histC = new HistorialConsulta(miDoc,pac,null);
							histC.setModal(true);
							histC.setVisible(true);
							dispose();
						}
					}
				});
				btnRegistrar.setBackground(Color.WHITE);
				btnRegistrar.setFont(new Font("Sylfaen", Font.PLAIN, 14));
				btnRegistrar.setActionCommand("OK");
				buttonPane.add(btnRegistrar);
				getRootPane().setDefaultButton(btnRegistrar);
			}
			{
				btnCancelar = new JButton("Cancelar");
				btnCancelar.setBackground(Color.WHITE);
				btnCancelar.setFont(new Font("Sylfaen", Font.PLAIN, 14));
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
		cargarDatos();
		llenarTablaConsultas();
		llenarTablaVacunas();
	}
	
	public void llenarTablaConsultas() {
		modelConsulta.setRowCount(0);
		rowConsulta = new Object[modelConsulta.getColumnCount()];
		if(miPac != null) {
			for (Consulta aux : miPac.getMiHistorial().getmisDatosImportantes()) {
				rowConsulta[1] = aux.getCod();
				rowConsulta[2] = aux.getMotivo();
				rowConsulta[3] = aux.getDiagnostico();
				
				modelConsulta.addRow(rowConsulta);
			}
		}
	}
	
	public void llenarTablaVacunas() {
		modelVacuna.setRowCount(0);
		rowVacuna = new Object[modelVacuna.getColumnCount()];
		if(miPac != null) {
			for (Vacuna aux : miPac.getMisVacunas()) {
				rowVacuna[1] = aux.getCodigo();
				rowVacuna[2] = aux.getNombre();
				rowVacuna[3] = aux.getDescripcion();
				
				modelVacuna.addRow(rowVacuna);
			}
		}
	}
	
	public void cargarDatos() {
		if(miPac != null) {
			txtCodHist.setText(miPac.getMiHistorial().getNumRecord());
			txtCed.setText(miPac.getCedula());
			txtNombre.setText(miPac.getNombre());
			txtTel.setText(miPac.getTelefono());
			txtAntPers.setText(miPac.getAntecedentesPersonales());
			txtAntFam.setText(miPac.getAntecedentesFamiliares());
			txtAntFis.setText(miPac.getAntecedentesFisiologicos());
			txtDir.setText(miPac.getDireccion());
			cmbEstCivil.setSelectedItem(miPac.getEstadoCivil());
			cmbSexo.setSelectedItem(miPac.getSexo());
			cmbTpSangre.setSelectedItem(miPac.getTipoSangre());
			cmbFuma.setSelectedItem(miPac.getFuma());
			cmbAlcohol.setSelectedItem(miPac.getAlcohol());
			cmbCafe.setSelectedItem(miPac.getCafe());
			cmbDrogas.setSelectedItem(miPac.getDrogas());
			dtNacimiento.setDate(miPac.getFechaNacimiento());
		}
	}
}
