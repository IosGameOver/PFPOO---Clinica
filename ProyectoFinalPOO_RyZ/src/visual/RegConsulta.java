package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.Color;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;

public class RegConsulta extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField txtFe;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegConsulta dialog = new RegConsulta();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegConsulta() {
		setBounds(100, 100, 1062, 1030);
		setLocationRelativeTo(null);
		setResizable(false);
		initComponents();
	}

	private void initComponents() {
		JPanel btnPanel = new JPanel();
		getContentPane().add(btnPanel, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Registrar");
		btnPanel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Informaci\u00F3n del Paciente", 0, 0, new Font("Sylfaen", Font.PLAIN, 12), null));
		panel.setBounds(17, 17, 1010, 391);
		panel_1.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("C\u00F3digo:");
		lblNewLabel.setFont(new Font("Sylfaen", Font.PLAIN, 12));
		lblNewLabel.setBounds(12, 32, 56, 16);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(71, 28, 250, 19);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(399, 28, 250, 19);
		panel.add(textField_2);
		
		JLabel lblNombre = new JLabel("C\u00E9dula:");
		lblNombre.setFont(new Font("Sylfaen", Font.PLAIN, 12));
		lblNombre.setBounds(349, 32, 56, 16);
		panel.add(lblNombre);
		
		JLabel label = new JLabel("Nombre:");
		label.setFont(new Font("Sylfaen", Font.PLAIN, 12));
		label.setBounds(12, 60, 56, 16);
		panel.add(label);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(71, 56, 250, 19);
		panel.add(textField_1);
		
		JLabel lblTelef = new JLabel("Telef.:");
		lblTelef.setFont(new Font("Sylfaen", Font.PLAIN, 12));
		lblTelef.setBounds(349, 60, 56, 16);
		panel.add(lblTelef);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(399, 56, 250, 19);
		panel.add(textField_3);
		
		JLabel lblFDeNac = new JLabel("F. de Nac.:");
		lblFDeNac.setFont(new Font("Sylfaen", Font.PLAIN, 12));
		lblFDeNac.setBounds(682, 60, 64, 16);
		panel.add(lblFDeNac);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(748, 56, 250, 19);
		panel.add(dateChooser);
		
		JButton btnNewButton_2 = new JButton("Buscar");
		btnNewButton_2.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		btnNewButton_2.setBounds(682, 27, 316, 19);
		panel.add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("Tp.Sangre:");
		lblNewLabel_1.setFont(new Font("Sylfaen", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(497, 87, 64, 16);
		panel.add(lblNewLabel_1);
		
		JLabel lblEstCivil = new JLabel("Est. Civ.:");
		lblEstCivil.setFont(new Font("Sylfaen", Font.PLAIN, 12));
		lblEstCivil.setBounds(12, 87, 56, 16);
		panel.add(lblEstCivil);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setFont(new Font("Sylfaen", Font.PLAIN, 12));
		lblSexo.setBounds(262, 87, 30, 16);
		panel.add(lblSexo);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"<Seleccionar>", "Soltero/a", "Casado/a", "Separado/a", "Divorciado/a", "Viudo/a", "Uni\u00F3n Libre"}));
		comboBox.setBounds(71, 84, 170, 19);
		panel.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"<Seleccionar>", "Femenino", "Masculino"}));
		comboBox_1.setBounds(296, 84, 170, 19);
		panel.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"<Seleccionar>", "A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-"}));
		comboBox_2.setBounds(565, 84, 170, 19);
		panel.add(comboBox_2);
		
		JLabel lblCantHijos = new JLabel("Cant. hijos:");
		lblCantHijos.setFont(new Font("Sylfaen", Font.PLAIN, 12));
		lblCantHijos.setBounds(758, 87, 65, 16);
		panel.add(lblCantHijos);
		
		JSpinner spinner = new JSpinner();
		spinner.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		spinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner.setBounds(828, 84, 170, 19);
		panel.add(spinner);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(12, 112, 986, 56);
		panel_2.setBorder(new TitledBorder(null, "Hábitos tóxicos", 0, 0, new Font("Sylfaen", Font.PLAIN, 12), null));
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("\u00BFFuma?:");
		lblNewLabel_2.setFont(new Font("Sylfaen", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(12, 24, 56, 16);
		panel_2.add(lblNewLabel_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"<Seleccionar>", "Si", "No"}));
		comboBox_3.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		comboBox_3.setBounds(60, 22, 130, 19);
		panel_2.add(comboBox_3);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"<Seleccionar>", "Si", "No"}));
		comboBox_4.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		comboBox_4.setBounds(844, 22, 130, 19);
		panel_2.add(comboBox_4);
		
		JLabel lblconsumeDrogas = new JLabel("\u00BFConsume drogas?:");
		lblconsumeDrogas.setBounds(745, 24, 100, 16);
		panel_2.add(lblconsumeDrogas);
		lblconsumeDrogas.setFont(new Font("Sylfaen", Font.PLAIN, 12));
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"<Seleccionar>", "Si", "No"}));
		comboBox_5.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		comboBox_5.setBounds(570, 22, 130, 19);
		panel_2.add(comboBox_5);
		
		JComboBox comboBox_6 = new JComboBox();
		comboBox_6.setModel(new DefaultComboBoxModel(new String[] {"<Seleccionar>", "Si", "No"}));
		comboBox_6.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		comboBox_6.setBounds(314, 22, 130, 19);
		panel_2.add(comboBox_6);
		
		JLabel lblalcohol = new JLabel("\u00BFToma alcohol?:");
		lblalcohol.setBounds(232, 24, 82, 16);
		panel_2.add(lblalcohol);
		lblalcohol.setFont(new Font("Sylfaen", Font.PLAIN, 12));
		
		JLabel lblcaf = new JLabel("\u00BFToma caf\u00E9?:");
		lblcaf.setBounds(499, 24, 70, 16);
		panel_2.add(lblcaf);
		lblcaf.setFont(new Font("Sylfaen", Font.PLAIN, 12));
		
		JLabel lblNewLabel_3 = new JLabel("\u00BFCirug\u00EDas?:");
		lblNewLabel_3.setFont(new Font("Sylfaen", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(12, 183, 64, 16);
		panel.add(lblNewLabel_3);
		
		JComboBox comboBox_7 = new JComboBox();
		comboBox_7.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		comboBox_7.setBounds(71, 181, 130, 19);
		panel.add(comboBox_7);
		
		JLabel lblalergias = new JLabel("\u00BFAlergias?:");
		lblalergias.setFont(new Font("Sylfaen", Font.PLAIN, 12));
		lblalergias.setBounds(258, 183, 64, 16);
		panel.add(lblalergias);
		
		JLabel lbltraumatismo = new JLabel("\u00BFTraumatismo?:");
		lbltraumatismo.setFont(new Font("Sylfaen", Font.PLAIN, 12));
		lbltraumatismo.setBounds(506, 183, 80, 16);
		panel.add(lbltraumatismo);
		
		JLabel lbltransfusiones = new JLabel("\u00BFTransfusiones?:");
		lbltransfusiones.setFont(new Font("Sylfaen", Font.PLAIN, 12));
		lbltransfusiones.setBounds(778, 183, 85, 16);
		panel.add(lbltransfusiones);
		
		JComboBox comboBox_8 = new JComboBox();
		comboBox_8.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		comboBox_8.setBounds(320, 181, 130, 19);
		panel.add(comboBox_8);
		
		JComboBox comboBox_9 = new JComboBox();
		comboBox_9.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		comboBox_9.setBounds(588, 181, 130, 19);
		panel.add(comboBox_9);
		
		JComboBox comboBox_10 = new JComboBox();
		comboBox_10.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		comboBox_10.setBounds(868, 181, 130, 19);
		panel.add(comboBox_10);
		
		txtFe = new JTextField();
		txtFe.setHorizontalAlignment(SwingConstants.LEFT);
		txtFe.setFont(new Font("Sylfaen", Font.PLAIN, 12));
		txtFe.setBounds(12, 212, 189, 65);
		panel.add(txtFe);
		txtFe.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Sylfaen", Font.PLAIN, 12));
		textField_5.setColumns(10);
		textField_5.setBounds(258, 212, 192, 65);
		panel.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Sylfaen", Font.PLAIN, 12));
		textField_6.setColumns(10);
		textField_6.setBounds(506, 212, 212, 65);
		panel.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Sylfaen", Font.PLAIN, 12));
		textField_7.setColumns(10);
		textField_7.setBounds(778, 212, 220, 65);
		panel.add(textField_7);
		
		JLabel lblNewLabel_4 = new JLabel("Antecendentes personales y familiares:");
		lblNewLabel_4.setFont(new Font("Sylfaen", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(12, 290, 269, 16);
		panel.add(lblNewLabel_4);
		
		textField_8 = new JTextField();
		textField_8.setFont(new Font("Sylfaen", Font.PLAIN, 12));
		textField_8.setBounds(12, 305, 986, 70);
		panel.add(textField_8);
		textField_8.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Motivo de consulta:", TitledBorder.LEADING, TitledBorder.TOP, new Font("Sylfaen", Font.PLAIN, 12), null));
		panel_3.setBounds(17, 419, 1010, 120);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Evaluaci\u00F3n:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_4.setBounds(17, 552, 1010, 100);
		panel_1.add(panel_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Diagn\u00F3stico:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_5.setBounds(17, 665, 1010, 108);
		panel_1.add(panel_5);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Indicaciones:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_6.setBounds(17, 788, 1010, 138);
		panel_1.add(panel_6);
	}
}
