package visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logico.ClinicaSONS;
import logico.Consulta;
import logico.Doctor;
import logico.Paciente;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

public class IndicarAnalisis extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Dimension dim;
	private JTextField txtFecha;
	private static JTextField txtNombre;
	private static JTextField txtEdad;
	private JPanel panelIndi;
	private Paciente miPac = null;
	private Consulta miCons = null;
	private JTextField textField_1;
	private SimpleDateFormat df = null;
	private Doctor miDoc = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			IndicarAnalisis dialog = new IndicarAnalisis( null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Create the dialog.
	 */
	public IndicarAnalisis(Consulta cons) {
		df = new SimpleDateFormat("dd/MM/yyyy");
		this.miDoc = ClinicaSONS.getLoginUserDoc();
		this.miCons = cons;
		dim = getToolkit().getScreenSize();
		setSize(1100, 1015);
		setResizable(false);
		setLocationRelativeTo(null);
		if(miCons == null) {
			setTitle("Indicar análisis");
		}else{
			
			setTitle("Ver análisis indicados");
		}
		initComponents();
	}
	private void initComponents() {
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(12, 13, 1060, 113);
			contentPanel.add(panel);
			panel.setLayout(null);

			JLabel lblNewLabel = new JLabel("Cl\u00EDnica SONS");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("Sylfaen", Font.BOLD, 25));
			lblNewLabel.setBounds(381, 25, 298, 23);
			panel.add(lblNewLabel);

			JLabel lblNewLabel_1 = new JLabel("Autopista Duarte Km 1 1/2, Santiago de los Caballeros");
			lblNewLabel_1.setFont(new Font("Sylfaen", Font.PLAIN, 17));
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setBounds(314, 48, 431, 16);
			panel.add(lblNewLabel_1);
			{
				JLabel lblTelefono = new JLabel("Tel: 809-721-0430 / 809-954-6521 / 809-654-7584");
				lblTelefono.setHorizontalAlignment(SwingConstants.CENTER);
				lblTelefono.setFont(new Font("Sylfaen", Font.PLAIN, 21));
				lblTelefono.setBounds(282, 66, 495, 20);
				panel.add(lblTelefono);
			}
		}
		{
			JLabel label = new JLabel("Fecha:");
			label.setFont(new Font("Sylfaen", Font.PLAIN, 14));
			label.setBounds(12, 143, 56, 16);
			contentPanel.add(label);
		}
		{
			txtFecha = new JTextField();
			txtFecha.setBackground(Color.WHITE);
			txtFecha.setFont(new Font("Sylfaen", Font.PLAIN, 14));
			txtFecha.setEditable(false);
			txtFecha.setColumns(10);
			txtFecha.setBounds(54, 139, 250, 22);
			txtFecha.setText(df.format(new Date()));
			contentPanel.add(txtFecha);
		}
		{
			txtNombre = new JTextField();
			txtNombre.setBackground(Color.WHITE);
			txtNombre.setFont(new Font("Sylfaen", Font.PLAIN, 14));
			txtNombre.setEditable(false);
			txtNombre.setColumns(10);
			txtNombre.setBounds(441, 137, 250, 22);
			contentPanel.add(txtNombre);
		}
		{
			JLabel label = new JLabel("Nombre:");
			label.setFont(new Font("Sylfaen", Font.PLAIN, 14));
			label.setBounds(386, 141, 56, 16);
			contentPanel.add(label);
		}
		{
			txtEdad = new JTextField();
			txtEdad.setBackground(Color.WHITE);
			txtEdad.setFont(new Font("Sylfaen", Font.PLAIN, 14));
			txtEdad.setEditable(false);
			txtEdad.setColumns(10);

			
			txtEdad.setBounds(822, 137, 250, 22);
			contentPanel.add(txtEdad);
		}
		{
			JLabel label = new JLabel("Edad:");
			label.setFont(new Font("Sylfaen", Font.PLAIN, 14));
			label.setBounds(784, 141, 56, 16);
			contentPanel.add(label);
		}
		{
			panelIndi = new JPanel();
			panelIndi.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelIndi.setBounds(12, 172, 1060, 663);
			contentPanel.add(panelIndi);
			panelIndi.setLayout(null);
			JCheckBox chckbxNewCheckBox = new JCheckBox("HEMOGRAMA");
			chckbxNewCheckBox.setFont(new Font("Sylfaen", Font.PLAIN, 12));
			chckbxNewCheckBox.setBounds(21, 21, 113, 25);
			panelIndi.add(chckbxNewCheckBox);

			JCheckBox chckbxO = new JCheckBox("ORINA");
			chckbxO.setFont(new Font("Sylfaen", Font.PLAIN, 12));
			chckbxO.setBounds(21, 51, 113, 25);
			panelIndi.add(chckbxO);

			JCheckBox chckbxCoprolgicocoprolgico = new JCheckBox("COPROL\u00D3GICOCOPROL\u00D3GICO");
			chckbxCoprolgicocoprolgico.setFont(new Font("Sylfaen", Font.PLAIN, 12));
			chckbxCoprolgicocoprolgico.setBounds(21, 81, 210, 25);
			panelIndi.add(chckbxCoprolgicocoprolgico);

			JCheckBox chckbxVdrl = new JCheckBox("VDRL");
			chckbxVdrl.setFont(new Font("Sylfaen", Font.PLAIN, 12));
			chckbxVdrl.setBounds(21, 111, 113, 25);
			panelIndi.add(chckbxVdrl);
			{
				JCheckBox chckbxGlicema = new JCheckBox("GLICEMA");
				chckbxGlicema.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxGlicema.setBounds(21, 141, 113, 25);
				panelIndi.add(chckbxGlicema);
			}
			{
				JCheckBox chckbxBun = new JCheckBox("BUN");
				chckbxBun.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxBun.setBounds(21, 171, 113, 25);
				panelIndi.add(chckbxBun);
			}
			{
				JCheckBox chckbxCreatinina = new JCheckBox("CREATININA");
				chckbxCreatinina.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxCreatinina.setBounds(21, 201, 113, 25);
				panelIndi.add(chckbxCreatinina);
			}
			{
				JCheckBox chckbxColesterol = new JCheckBox("COLESTEROL");
				chckbxColesterol.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxColesterol.setBounds(21, 231, 113, 25);
				panelIndi.add(chckbxColesterol);
			}
			{
				JCheckBox chckbxTrigliceridos = new JCheckBox("TRIGLICERIDOS");
				chckbxTrigliceridos.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxTrigliceridos.setBounds(21, 261, 210, 25);
				panelIndi.add(chckbxTrigliceridos);
			}
			{
				JCheckBox chckbxHdlc = new JCheckBox("HDL-C");
				chckbxHdlc.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxHdlc.setBounds(21, 291, 113, 25);
				panelIndi.add(chckbxHdlc);
			}
			{
				JCheckBox chckbxProtenas = new JCheckBox("PROTE\u00CDNAS");
				chckbxProtenas.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxProtenas.setBounds(21, 321, 113, 25);
				panelIndi.add(chckbxProtenas);
			}
			{
				JCheckBox chckbxAlbumina = new JCheckBox("ALBUMINA");
				chckbxAlbumina.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxAlbumina.setBounds(21, 351, 113, 25);
				panelIndi.add(chckbxAlbumina);
			}
			{
				JCheckBox chckbxBilirrubinas = new JCheckBox("BILIRRUBINAS");
				chckbxBilirrubinas.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxBilirrubinas.setBounds(21, 381, 113, 25);
				panelIndi.add(chckbxBilirrubinas);
			}
			{
				JCheckBox chckbxLdh = new JCheckBox("LDH");
				chckbxLdh.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxLdh.setBounds(21, 411, 113, 25);
				panelIndi.add(chckbxLdh);
			}
			{
				JCheckBox chckbxFosfAlcalina = new JCheckBox("FOSF ALCALINA");
				chckbxFosfAlcalina.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxFosfAlcalina.setBounds(21, 441, 197, 25);
				panelIndi.add(chckbxFosfAlcalina);
			}
			{
				JCheckBox chckbxSgot = new JCheckBox("SGOT");
				chckbxSgot.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxSgot.setBounds(21, 471, 113, 25);
				panelIndi.add(chckbxSgot);
			}
			{
				JCheckBox chckbxSgpt = new JCheckBox("SGPT");
				chckbxSgpt.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxSgpt.setBounds(21, 501, 113, 25);
				panelIndi.add(chckbxSgpt);
			}
			{
				JCheckBox chckbxCk = new JCheckBox("CK");
				chckbxCk.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxCk.setBounds(21, 531, 113, 25);
				panelIndi.add(chckbxCk);
			}
			{
				JCheckBox chckbxCkmb = new JCheckBox("CK-MB");
				chckbxCkmb.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxCkmb.setBounds(21, 561, 113, 25);
				panelIndi.add(chckbxCkmb);
			}
			{
				JCheckBox chckbxSodio = new JCheckBox("SODIO");
				chckbxSodio.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxSodio.setBounds(21, 591, 113, 25);
				panelIndi.add(chckbxSodio);
			}
			{
				JCheckBox chckbxPotasio = new JCheckBox("POTASIO");
				chckbxPotasio.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxPotasio.setBounds(21, 621, 113, 25);
				panelIndi.add(chckbxPotasio);
			}
			{
				JCheckBox chckbxPpd = new JCheckBox("PPD");
				chckbxPpd.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxPpd.setBounds(244, 621, 113, 25);
				panelIndi.add(chckbxPpd);
			}
			{
				JCheckBox chckbxCuentaEosinofilos = new JCheckBox("CUENTA EOSINOFILOS");
				chckbxCuentaEosinofilos.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxCuentaEosinofilos.setBounds(244, 591, 113, 25);
				panelIndi.add(chckbxCuentaEosinofilos);
			}
			{
				JCheckBox chckbxReticulocitos = new JCheckBox("RETICULOCITOS");
				chckbxReticulocitos.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxReticulocitos.setBounds(244, 561, 113, 25);
				panelIndi.add(chckbxReticulocitos);
			}
			{
				JCheckBox chckbxFalcemia = new JCheckBox("FALCEMIA");
				chckbxFalcemia.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxFalcemia.setBounds(244, 531, 113, 25);
				panelIndi.add(chckbxFalcemia);
			}
			{
				JCheckBox chckbxEritrosedimentacin = new JCheckBox("ERITROSEDIMENTACI\u00D3N");
				chckbxEritrosedimentacin.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxEritrosedimentacin.setBounds(244, 501, 113, 25);
				panelIndi.add(chckbxEritrosedimentacin);
			}
			{
				JCheckBox chckbxGestatest = new JCheckBox("GESTATEST");
				chckbxGestatest.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxGestatest.setBounds(244, 471, 113, 25);
				panelIndi.add(chckbxGestatest);
			}
			{
				JCheckBox chckbxWidal = new JCheckBox("WIDAL");
				chckbxWidal.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxWidal.setBounds(244, 441, 113, 25);
				panelIndi.add(chckbxWidal);
			}
			{
				JCheckBox chckbxFreumatoide = new JCheckBox("FREUMATOIDE");
				chckbxFreumatoide.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxFreumatoide.setBounds(244, 411, 113, 25);
				panelIndi.add(chckbxFreumatoide);
			}
			{
				JCheckBox chckbxPcr = new JCheckBox("PCR");
				chckbxPcr.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxPcr.setBounds(244, 381, 113, 25);
				panelIndi.add(chckbxPcr);
			}
			{
				JCheckBox chckbxAso = new JCheckBox("ASO");
				chckbxAso.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxAso.setBounds(244, 351, 113, 25);
				panelIndi.add(chckbxAso);
			}
			{
				JCheckBox chckbxTipificacin = new JCheckBox("TIPIFICACI\u00D3N");
				chckbxTipificacin.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxTipificacin.setBounds(244, 321, 113, 25);
				panelIndi.add(chckbxTipificacin);
			}
			{
				JCheckBox chckbxAlcohol = new JCheckBox("ALCOHOL");
				chckbxAlcohol.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxAlcohol.setBounds(244, 291, 113, 25);
				panelIndi.add(chckbxAlcohol);
			}
			{
				JCheckBox chckbxColinesterasa = new JCheckBox("COLINESTERASA");
				chckbxColinesterasa.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxColinesterasa.setBounds(244, 261, 153, 25);
				panelIndi.add(chckbxColinesterasa);
			}
			{
				JCheckBox chckbxAmonio = new JCheckBox("AMONIO");
				chckbxAmonio.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxAmonio.setBounds(244, 231, 113, 25);
				panelIndi.add(chckbxAmonio);
			}
			{
				JCheckBox chckbxGlicogemoglobina = new JCheckBox("GLICOGEMOGLOBINA");
				chckbxGlicogemoglobina.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxGlicogemoglobina.setBounds(244, 201, 113, 25);
				panelIndi.add(chckbxGlicogemoglobina);
			}
			{
				JCheckBox chckbxcidorico = new JCheckBox("\u00C1CIDO \u00DARICO");
				chckbxcidorico.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxcidorico.setBounds(244, 171, 113, 25);
				panelIndi.add(chckbxcidorico);
			}
			{
				JCheckBox chckbxFsforo = new JCheckBox("F\u00D3SFORO");
				chckbxFsforo.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxFsforo.setBounds(244, 141, 113, 25);
				panelIndi.add(chckbxFsforo);
			}
			{
				JCheckBox chckbxCalcio = new JCheckBox("CALCIO");
				chckbxCalcio.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxCalcio.setBounds(244, 111, 113, 25);
				panelIndi.add(chckbxCalcio);
			}
			{
				JCheckBox chckbxLipasa = new JCheckBox("LIPASA");
				chckbxLipasa.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxLipasa.setBounds(244, 81, 113, 25);
				panelIndi.add(chckbxLipasa);
			}
			{
				JCheckBox chckbxAmilasa = new JCheckBox("AMILASA");
				chckbxAmilasa.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxAmilasa.setBounds(244, 51, 113, 25);
				panelIndi.add(chckbxAmilasa);
			}
			{
				JCheckBox chckbxCloro = new JCheckBox("CLORO");
				chckbxCloro.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxCloro.setBounds(244, 21, 113, 25);
				panelIndi.add(chckbxCloro);
			}
			{
				JCheckBox chckbxHiv = new JCheckBox("HIV");
				chckbxHiv.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxHiv.setBounds(467, 21, 113, 25);
				panelIndi.add(chckbxHiv);
			}
			{
				JCheckBox chckbxAntgenoAustraliano = new JCheckBox("ANT\u00CDGENO AUSTRALIANO");
				chckbxAntgenoAustraliano.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxAntgenoAustraliano.setBounds(467, 51, 185, 25);
				panelIndi.add(chckbxAntgenoAustraliano);
			}
			{
				JCheckBox chckbxHcv = new JCheckBox("HCV");
				chckbxHcv.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxHcv.setBounds(467, 81, 113, 25);
				panelIndi.add(chckbxHcv);
			}
			{
				JCheckBox chckbxHavIgm = new JCheckBox("HAV IGM ");
				chckbxHavIgm.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxHavIgm.setBounds(467, 111, 113, 25);
				panelIndi.add(chckbxHavIgm);
			}
			{
				JCheckBox chckbxMarcadoresDeHapatits = new JCheckBox("MARCADORES DE HEPATIT\u00CDS B");
				chckbxMarcadoresDeHapatits.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxMarcadoresDeHapatits.setBounds(467, 141, 220, 25);
				panelIndi.add(chckbxMarcadoresDeHapatits);
			}
			{
				JCheckBox chckbxPsa = new JCheckBox("PSA");
				chckbxPsa.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxPsa.setBounds(467, 171, 113, 25);
				panelIndi.add(chckbxPsa);
			}
			{
				JCheckBox chckbxPsaLibre = new JCheckBox("PSA LIBRE");
				chckbxPsaLibre.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxPsaLibre.setBounds(467, 201, 113, 25);
				panelIndi.add(chckbxPsaLibre);
			}
			{
				JCheckBox chckbxTsh = new JCheckBox("TSH");
				chckbxTsh.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxTsh.setBounds(467, 231, 113, 25);
				panelIndi.add(chckbxTsh);
			}
			{
				JCheckBox chckbxT = new JCheckBox("T3");
				chckbxT.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxT.setBounds(467, 261, 113, 25);
				panelIndi.add(chckbxT);
			}
			{
				JCheckBox chckbxT_1 = new JCheckBox("T4");
				chckbxT_1.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxT_1.setBounds(467, 291, 113, 25);
				panelIndi.add(chckbxT_1);
			}
			{
				JCheckBox chckbxTLibre = new JCheckBox("T4 LIBRE");
				chckbxTLibre.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxTLibre.setBounds(467, 321, 113, 25);
				panelIndi.add(chckbxTLibre);
			}
			{
				JCheckBox chckbxLh = new JCheckBox("LH");
				chckbxLh.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxLh.setBounds(467, 351, 113, 25);
				panelIndi.add(chckbxLh);
			}
			{
				JCheckBox chckbxFsh = new JCheckBox("FSH");
				chckbxFsh.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxFsh.setBounds(467, 381, 113, 25);
				panelIndi.add(chckbxFsh);
			}
			{
				JCheckBox chckbxEstradiol = new JCheckBox("ESTRADIOL");
				chckbxEstradiol.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxEstradiol.setBounds(467, 411, 113, 25);
				panelIndi.add(chckbxEstradiol);
			}
			{
				JCheckBox chckbxProgestorona = new JCheckBox("PROGESTORONA");
				chckbxProgestorona.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxProgestorona.setBounds(467, 441, 172, 25);
				panelIndi.add(chckbxProgestorona);
			}
			{
				JCheckBox chckbxTestoterona = new JCheckBox("TESTOTERONA");
				chckbxTestoterona.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxTestoterona.setBounds(467, 471, 172, 25);
				panelIndi.add(chckbxTestoterona);
			}
			{
				JCheckBox chckbxDheaso = new JCheckBox("DHEA-SO4");
				chckbxDheaso.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxDheaso.setBounds(467, 501, 113, 25);
				panelIndi.add(chckbxDheaso);
			}
			{
				JCheckBox chckbxProlactina = new JCheckBox("PROLACTINA");
				chckbxProlactina.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxProlactina.setBounds(467, 531, 113, 25);
				panelIndi.add(chckbxProlactina);
			}
			{
				JCheckBox chckbxEstrgenosTotales = new JCheckBox("ESTR\u00D3GENOS TOTALES");
				chckbxEstrgenosTotales.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxEstrgenosTotales.setBounds(467, 561, 185, 25);
				panelIndi.add(chckbxEstrgenosTotales);
			}
			{
				JCheckBox chckbxCea = new JCheckBox("CEA");
				chckbxCea.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxCea.setBounds(467, 591, 113, 25);
				panelIndi.add(chckbxCea);
			}
			{
				JCheckBox chckbxAfp = new JCheckBox("AFP");
				chckbxAfp.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxAfp.setBounds(467, 621, 113, 25);
				panelIndi.add(chckbxAfp);
			}
			{
				JCheckBox chckbxCelLe = new JCheckBox("CEL LE");
				chckbxCelLe.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxCelLe.setBounds(691, 621, 113, 25);
				panelIndi.add(chckbxCelLe);
			}
			{
				JCheckBox chckbxC_1 = new JCheckBox("C4");
				chckbxC_1.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxC_1.setBounds(691, 591, 113, 25);
				panelIndi.add(chckbxC_1);
			}
			{
				JCheckBox chckbxC = new JCheckBox("C3");
				chckbxC.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxC.setBounds(691, 561, 113, 25);
				panelIndi.add(chckbxC);
			}
			{
				JCheckBox chckbxIge = new JCheckBox("IGE");
				chckbxIge.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxIge.setBounds(691, 531, 113, 25);
				panelIndi.add(chckbxIge);
			}
			{
				JCheckBox chckbxIgm = new JCheckBox("IGM");
				chckbxIgm.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxIgm.setBounds(691, 471, 113, 25);
				panelIndi.add(chckbxIgm);
			}
			{
				JCheckBox chckbxIga = new JCheckBox("IGA");
				chckbxIga.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxIga.setBounds(691, 501, 113, 25);
				panelIndi.add(chckbxIga);
			}
			{
				JCheckBox chckbxIgg = new JCheckBox("IGG");
				chckbxIgg.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxIgg.setBounds(691, 441, 113, 25);
				panelIndi.add(chckbxIgg);
			}
			{
				JCheckBox chckbxElectrofosisProt = new JCheckBox("ELECTROFOSIS PROT");
				chckbxElectrofosisProt.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxElectrofosisProt.setBounds(691, 411, 172, 25);
				panelIndi.add(chckbxElectrofosisProt);
			}
			{
				JCheckBox chckbxElectoforesisHb = new JCheckBox("ELECTOFORESIS HB");
				chckbxElectoforesisHb.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxElectoforesisHb.setBounds(691, 381, 172, 25);
				panelIndi.add(chckbxElectoforesisHb);
			}
			{
				JCheckBox chckbxCmvIgg = new JCheckBox("CMV IGG");
				chckbxCmvIgg.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxCmvIgg.setBounds(691, 351, 113, 25);
				panelIndi.add(chckbxCmvIgg);
			}
			{
				JCheckBox chckbxCmvIgm = new JCheckBox("CMV IGM ");
				chckbxCmvIgm.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxCmvIgm.setBounds(691, 321, 113, 25);
				panelIndi.add(chckbxCmvIgm);
			}
			{
				JCheckBox chckbxHerpesgg = new JCheckBox("HERPES 1-21GG");
				chckbxHerpesgg.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxHerpesgg.setBounds(691, 291, 130, 25);
				panelIndi.add(chckbxHerpesgg);
			}
			{
				JCheckBox chckbxHerpesgm = new JCheckBox("HERPES 1-21GM");
				chckbxHerpesgm.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxHerpesgm.setBounds(691, 261, 142, 25);
				panelIndi.add(chckbxHerpesgm);
			}
			{
				JCheckBox chckbxRubellaIgg = new JCheckBox("RUBELLA IGG");
				chckbxRubellaIgg.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxRubellaIgg.setBounds(691, 231, 113, 25);
				panelIndi.add(chckbxRubellaIgg);
			}
			{
				JCheckBox chckbxRubellaIgm = new JCheckBox("RUBELLA IGM ");
				chckbxRubellaIgm.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxRubellaIgm.setBounds(691, 201, 113, 25);
				panelIndi.add(chckbxRubellaIgm);
			}
			{
				JCheckBox chckbxToxoIgg = new JCheckBox("TOXO IGG ");
				chckbxToxoIgg.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxToxoIgg.setBounds(691, 171, 113, 25);
				panelIndi.add(chckbxToxoIgg);
			}
			{
				JCheckBox chckbxToxoIgm = new JCheckBox("TOXO IGM");
				chckbxToxoIgm.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxToxoIgm.setBounds(691, 141, 113, 25);
				panelIndi.add(chckbxToxoIgm);
			}
			{
				JCheckBox chckbxCa_2 = new JCheckBox("CA 19-9");
				chckbxCa_2.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxCa_2.setBounds(691, 111, 113, 25);
				panelIndi.add(chckbxCa_2);
			}
			{
				JCheckBox chckbxCa_1 = new JCheckBox("CA 125");
				chckbxCa_1.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxCa_1.setBounds(691, 81, 113, 25);
				panelIndi.add(chckbxCa_1);
			}
			{
				JCheckBox chckbxCa = new JCheckBox("CA 15-3");
				chckbxCa.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxCa.setBounds(691, 51, 113, 25);
				panelIndi.add(chckbxCa);
			}
			{
				JCheckBox chckbxBhgc = new JCheckBox("BHGC");
				chckbxBhgc.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxBhgc.setBounds(691, 21, 113, 25);
				panelIndi.add(chckbxBhgc);
			}
			{
				JCheckBox chckbxAna = new JCheckBox("ANA");
				chckbxAna.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxAna.setBounds(913, 21, 113, 25);
				panelIndi.add(chckbxAna);
			}
			{
				JCheckBox chckbxTpha = new JCheckBox("TPHA");
				chckbxTpha.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxTpha.setBounds(913, 51, 113, 25);
				panelIndi.add(chckbxTpha);
			}
			{
				JCheckBox chckbxCoombsDir = new JCheckBox("COOMBS DIR");
				chckbxCoombsDir.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxCoombsDir.setBounds(913, 81, 113, 25);
				panelIndi.add(chckbxCoombsDir);
			}
			{
				JCheckBox chckbxCoombsInd = new JCheckBox("COOMBS IND");
				chckbxCoombsInd.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxCoombsInd.setBounds(913, 111, 113, 25);
				panelIndi.add(chckbxCoombsInd);
			}
			{
				JCheckBox chckbxTsangra = new JCheckBox("T.SANGR\u00CDA");
				chckbxTsangra.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxTsangra.setBounds(913, 141, 113, 25);
				panelIndi.add(chckbxTsangra);
			}
			{
				JCheckBox chckbxTcoagulacin = new JCheckBox("T.COAGULACI\u00D3N");
				chckbxTcoagulacin.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxTcoagulacin.setBounds(913, 171, 139, 25);
				panelIndi.add(chckbxTcoagulacin);
			}
			{
				JCheckBox chckbxTprotrombina = new JCheckBox("T.PROTROMBINA");
				chckbxTprotrombina.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxTprotrombina.setBounds(913, 201, 139, 25);
				panelIndi.add(chckbxTprotrombina);
			}
			{
				JCheckBox chckbxTtp = new JCheckBox("TTP");
				chckbxTtp.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxTtp.setBounds(913, 231, 113, 25);
				panelIndi.add(chckbxTtp);
			}
			{
				JCheckBox chckbxTt = new JCheckBox("T.T");
				chckbxTt.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxTt.setBounds(913, 261, 113, 25);
				panelIndi.add(chckbxTt);
			}
			{
				JCheckBox chckbxFibrongeno = new JCheckBox("FIBRON\u00D3GENO");
				chckbxFibrongeno.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxFibrongeno.setBounds(913, 291, 130, 25);
				panelIndi.add(chckbxFibrongeno);
			}
			{
				JCheckBox chckbxHierro = new JCheckBox("HIERRO");
				chckbxHierro.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxHierro.setBounds(913, 321, 113, 25);
				panelIndi.add(chckbxHierro);
			}
			{
				JCheckBox chckbxTibc = new JCheckBox("TIBC");
				chckbxTibc.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxTibc.setBounds(913, 351, 113, 25);
				panelIndi.add(chckbxTibc);
			}
			{
				JCheckBox chckbxFerritina = new JCheckBox("FERRITINA");
				chckbxFerritina.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxFerritina.setBounds(913, 381, 113, 25);
				panelIndi.add(chckbxFerritina);
			}
			{
				JCheckBox chckbxCardamacepina = new JCheckBox("CARDAMACEPINA");
				chckbxCardamacepina.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxCardamacepina.setBounds(913, 411, 130, 25);
				panelIndi.add(chckbxCardamacepina);
			}
			{
				JCheckBox chckbxFenobarbital = new JCheckBox("FENOBARBITAL");
				chckbxFenobarbital.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxFenobarbital.setBounds(913, 441, 121, 25);
				panelIndi.add(chckbxFenobarbital);
			}
			{
				JCheckBox chckbxEpanim = new JCheckBox("EPANIM");
				chckbxEpanim.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxEpanim.setBounds(913, 471, 113, 25);
				panelIndi.add(chckbxEpanim);
			}
			{
				JCheckBox chckbxDigoxina = new JCheckBox("DIGOXINA");
				chckbxDigoxina.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxDigoxina.setBounds(913, 501, 113, 25);
				panelIndi.add(chckbxDigoxina);
			}
			{
				JCheckBox chckbxClamidia = new JCheckBox("CLAMIDIA");
				chckbxClamidia.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxClamidia.setBounds(913, 531, 113, 25);
				panelIndi.add(chckbxClamidia);
			}
			{
				JCheckBox chckbxBaciloscopia = new JCheckBox("BACILOSCOPIA");
				chckbxBaciloscopia.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxBaciloscopia.setBounds(913, 561, 139, 25);
				panelIndi.add(chckbxBaciloscopia);
			}
			{
				JCheckBox chckbxBk = new JCheckBox("BK");
				chckbxBk.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxBk.setBounds(913, 591, 113, 25);
				panelIndi.add(chckbxBk);
			}
			{
				JCheckBox chckbxUrocultivo = new JCheckBox("UROCULTIVO");
				chckbxUrocultivo.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				chckbxUrocultivo.setBounds(913, 621, 113, 25);
				panelIndi.add(chckbxUrocultivo);
			}
			{
				JCheckBox checkBox = new JCheckBox("COOMBS DIR");
				checkBox.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				checkBox.setBounds(1167, -490, 113, 25);
				panelIndi.add(checkBox);
			}
			{
				JCheckBox checkBox = new JCheckBox("TPHA");
				checkBox.setFont(new Font("Sylfaen", Font.PLAIN, 12));
				checkBox.setBounds(1167, -520, 113, 25);
				panelIndi.add(checkBox);
			}
			for(int i = 0;i < panelIndi.getComponentCount();i++){
				JCheckBox check = (JCheckBox) panelIndi.getComponent(i);
				check.setFont(new Font("Sylfaen", Font.PLAIN, 14));
			}
		}
		{
			JLabel lblPruebasQueRequieren = new JLabel("Recomendaciones para la toma de Orina: Previo lavado genital \u00B7 Pruebas que requieren ayuna:  Glicemia, \u00FArea, Creatrina, \u00E1cido");
			lblPruebasQueRequieren.setFont(new Font("Sylfaen", Font.PLAIN, 14));
			lblPruebasQueRequieren.setBounds(12, 848, 727, 16);
			contentPanel.add(lblPruebasQueRequieren);
		}
		{
			JLabel lblricoSgotSgt = new JLabel("\u00FArico SGOT SGT, Colesterol, Triglicer\u00EDdos, Bilirubinas, Amilasa, Fosfatasas\u00B7Pruebas que prohiben ingerir grasas 12 horas antes");
			lblricoSgotSgt.setFont(new Font("Sylfaen", Font.PLAIN, 14));
			lblricoSgotSgt.setBounds(12, 868, 790, 16);
			contentPanel.add(lblricoSgotSgt);
		}
		{
			JLabel lblSuEjecucinColesterol = new JLabel("de su ejecuci\u00F3n: Colesterol, Triglicer\u00EDdos.");
			lblSuEjecucinColesterol.setFont(new Font("Sylfaen", Font.PLAIN, 14));
			lblSuEjecucinColesterol.setBounds(12, 888, 385, 16);
			contentPanel.add(lblSuEjecucinColesterol);
		}
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setBounds(784, 864, 288, 22);
		contentPanel.add(textField_1);
		if(miDoc != null) {
			textField_1.setText(miDoc.getNombre());
		}
		
		textField_1.setColumns(10);
		
		JLabel lblDoctor = new JLabel("Doctor");
		lblDoctor.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		lblDoctor.setBounds(909, 888, 39, 16);
		contentPanel.add(lblDoctor);


		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnRegistrar = new JButton("Registrar");
				if(miCons != null) {
					btnRegistrar.setVisible(false);
				}
				btnRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						for(int i = 0;i < panelIndi.getComponentCount();i++){
							JCheckBox check = (JCheckBox) panelIndi.getComponent(i);
							if(check.isSelected()){
								HistorialConsulta.guardarAnalisis(check.getLabel());
							}
						}
						JOptionPane.showMessageDialog(null, "Los analisis fueron agregados", "¡Operación exitosa!",JOptionPane.INFORMATION_MESSAGE);
						dispose();
					}
				
				});
				btnRegistrar.setBackground(Color.WHITE);
				btnRegistrar.setActionCommand("OK");
				buttonPane.add(btnRegistrar);
				getRootPane().setDefaultButton(btnRegistrar);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setBackground(Color.WHITE);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		cargarAnalisis();
	}
	
	public void cargarAnalisis() {
		if (miCons != null) {
			for(int i = 0;i < panelIndi.getComponentCount();i++){
				JCheckBox check = (JCheckBox) panelIndi.getComponent(i);
				for (String aux :miCons.getAnalisis()) {
					if(check.getLabel().equalsIgnoreCase(aux)) {
						check.setSelected(true);
					}
				}
				check.setEnabled(false);
			}
		}
	}
	
	public static void setNombre(String nom) {
		txtNombre.setText(nom);
	}
	
	public static void setEdad(Date fn) {
		int edad = ClinicaSONS.getInstance().calcularEdad(fn, new Date());
		txtEdad.setText(String.valueOf(edad)+" años");
	}
}
