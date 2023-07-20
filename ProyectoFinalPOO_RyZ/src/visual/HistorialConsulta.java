package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class HistorialConsulta extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private SimpleDateFormat df;
	private JDateChooser dateChooser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			HistorialConsulta dialog = new HistorialConsulta();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public HistorialConsulta() {
		setBounds(100, 100, 910, 870);
		setResizable(false);
		setLocationRelativeTo(null);
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
		panel_2.setBounds(12, 13, 870, 125);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("C\u00F3digo:");
		lblNewLabel.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		lblNewLabel.setBounds(12, 31, 56, 16);
		panel_2.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		textField.setBounds(69, 27, 205, 22);
		panel_2.add(textField);
		textField.setColumns(10);
		
		JLabel lblCdula = new JLabel("C\u00E9dula:");
		lblCdula.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		lblCdula.setBounds(299, 28, 56, 16);
		panel_2.add(lblCdula);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		textField_1.setColumns(10);
		textField_1.setBounds(347, 27, 205, 22);
		panel_2.add(textField_1);
		
		JButton btnNewButton_1 = new JButton("Buscar");
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		btnNewButton_1.setBounds(585, 27, 273, 22);
		panel_2.add(btnNewButton_1);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		lblNombre.setBounds(12, 60, 56, 16);
		panel_2.add(lblNombre);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		textField_2.setColumns(10);
		textField_2.setBounds(69, 56, 205, 22);
		panel_2.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		textField_3.setColumns(10);
		textField_3.setBounds(347, 57, 205, 22);
		panel_2.add(textField_3);
		
		JLabel lblTelef = new JLabel("Telef:");
		lblTelef.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		lblTelef.setBounds(299, 61, 56, 16);
		panel_2.add(lblTelef);
		
		dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("d/MM/ yyyy");
		dateChooser.setBackground(Color.WHITE);
		dateChooser.setBounds(653, 56, 205, 22);
		panel_2.add(dateChooser);
		
		JLabel lblFDeNac = new JLabel("F. de Nac.:");
		lblFDeNac.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		lblFDeNac.setBounds(585, 62, 71, 16);
		panel_2.add(lblFDeNac);
		
		JLabel lblEstCivil = new JLabel("Est. Civ.:");
		lblEstCivil.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		lblEstCivil.setBounds(12, 89, 56, 16);
		panel_2.add(lblEstCivil);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Soltero/a", "Casado/a", "Separado/a", "Divorciado/a", "Viudo/a", "Uni\u00F3n Libre"}));
		comboBox.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		comboBox.setBounds(69, 85, 110, 22);
		panel_2.add(comboBox);
		
		JLabel lblCantHijos = new JLabel("Cant. Hijos:");
		lblCantHijos.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		lblCantHijos.setBounds(676, 89, 71, 16);
		panel_2.add(lblCantHijos);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBackground(Color.WHITE);
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Femenino", "Masculino"}));
		comboBox_2.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		comboBox_2.setBounds(270, 85, 110, 22);
		panel_2.add(comboBox_2);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		lblSexo.setBounds(231, 89, 56, 16);
		panel_2.add(lblSexo);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBackground(Color.WHITE);
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-"}));
		comboBox_3.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		comboBox_3.setBounds(515, 85, 110, 22);
		panel_2.add(comboBox_3);
		
		JLabel lblTpDeSangre = new JLabel("Tp. de Sangre.:");
		lblTpDeSangre.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		lblTpDeSangre.setBounds(421, 89, 87, 16);
		panel_2.add(lblTpDeSangre);
		
		JSpinner spinner = new JSpinner();
		spinner.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		spinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner.setBackground(Color.WHITE);
		spinner.setBounds(748, 85, 110, 22);
		panel_2.add(spinner);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Motivo de Consulta:", TitledBorder.LEADING, TitledBorder.TOP, new Font("Sylfaen", Font.PLAIN, 14), new Color(0, 0, 0)));
		panel_3.setBounds(12, 151, 870, 140);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		textField_4.setBounds(12, 19, 846, 108);
		panel_3.add(textField_4);
		textField_4.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "Evaluaci\u00F3n:", TitledBorder.LEADING, TitledBorder.TOP, new Font("Sylfaen", Font.PLAIN, 14), null));
		panel_4.setBounds(12, 304, 870, 74);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblTa = new JLabel("TA:");
		lblTa.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		lblTa.setBounds(12, 33, 56, 16);
		panel_4.add(lblTa);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		textField_5.setBounds(38, 29, 100, 22);
		panel_4.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(758, 29, 100, 22);
		panel_4.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		textField_7.setColumns(10);
		textField_7.setBounds(210, 29, 100, 22);
		panel_4.add(textField_7);
		
		JLabel lblFc = new JLabel("FC:");
		lblFc.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		lblFc.setBounds(184, 31, 56, 16);
		panel_4.add(lblFc);
		
		textField_8 = new JTextField();
		textField_8.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		textField_8.setColumns(10);
		textField_8.setBounds(377, 29, 100, 22);
		panel_4.add(textField_8);
		
		JLabel lblFr = new JLabel("FR:");
		lblFr.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		lblFr.setBounds(351, 31, 56, 16);
		panel_4.add(lblFr);
		
		textField_9 = new JTextField();
		textField_9.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		textField_9.setColumns(10);
		textField_9.setBounds(574, 29, 100, 22);
		panel_4.add(textField_9);
		
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
		panel_5.setBounds(12, 436, 870, 140);
		panel.add(panel_5);
		panel_5.setLayout(null);
		
		textField_10 = new JTextField();
		textField_10.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		textField_10.setBounds(12, 18, 846, 109);
		panel_5.add(textField_10);
		textField_10.setColumns(10);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(null, "Indicaciones:", TitledBorder.LEADING, TitledBorder.TOP, new Font("Sylfaen", Font.PLAIN, 14), null));
		panel_6.setBounds(12, 589, 870, 140);
		panel.add(panel_6);
		panel_6.setLayout(null);
		
		textField_11 = new JTextField();
		textField_11.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		textField_11.setBounds(12, 18, 846, 109);
		textField_11.setColumns(10);
		panel_6.add(textField_11);
		
		JButton btnNewButton = new JButton("Ver lista de enfermedades");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		btnNewButton.setBounds(109, 391, 300, 25);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Enfermedades:");
		lblNewLabel_1.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(458, 397, 87, 16);
		panel.add(lblNewLabel_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		comboBox_1.setBackground(Color.WHITE);
		comboBox_1.setBounds(550, 394, 208, 22);
		panel.add(comboBox_1);
		
		JButton btnNewButton_2 = new JButton("Indicar an\u00E1lisis");
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		btnNewButton_2.setBounds(53, 743, 230, 25);
		panel.add(btnNewButton_2);
		
		JButton btnIndicarVacunas = new JButton("Indicar vacunas");
		btnIndicarVacunas.setBackground(Color.WHITE);
		btnIndicarVacunas.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		btnIndicarVacunas.setBounds(336, 742, 230, 25);
		panel.add(btnIndicarVacunas);
		
		JButton btnIndicar = new JButton("Imprimir Receta");
		btnIndicar.setBackground(Color.WHITE);
		btnIndicar.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		btnIndicar.setBounds(619, 742, 230, 25);
		panel.add(btnIndicar);
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setAlignment(FlowLayout.TRAILING);
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(panel_1, BorderLayout.SOUTH);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date fecha = dateChooser.getDate(); 
				System.out.println(df.format(dateChooser.getDate()));
			}
		});
		panel_1.add(btnRegistrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		panel_1.add(btnCancelar);
	}
}
