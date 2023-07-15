package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JDateChooser;
import java.awt.Font;
import javax.swing.border.TitledBorder;

public class RegDoctor extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JDateChooser dateChooser;
	private JComboBox cmbSexo;
	private JComboBox cmbEstCivil;
	private JComboBox cmbTipoSangre;
	private JTextField textField_5;
	private JTextField textField_6;

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
			textField = new JTextField();
			textField.setBounds(95, 61, 234, 22);
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		{
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(447, 61, 230, 22);
			contentPanel.add(textField_1);
		}
		{
			cmbEstCivil = new JComboBox();
			cmbEstCivil.setModel(new DefaultComboBoxModel(new String[] {"<Seleccionar>", "Soltero/a", "Casado/a", "Separado/a", "Divorciado/a", "Viudo/a", "Uni\u00F3n Libre"}));
			cmbEstCivil.setFont(new Font("Sylfaen", Font.PLAIN, 14));
			cmbEstCivil.setBounds(95, 105, 120, 22);
			contentPanel.add(cmbEstCivil);
		}
		{
			cmbTipoSangre = new JComboBox();
			cmbTipoSangre.setModel(new DefaultComboBoxModel(new String[] {"<Seleccionar>", "A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-"}));
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
			cmbSexo.setModel(new DefaultComboBoxModel(new String[] {"<Seleccionar>", "F", "M"}));
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
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(95, 146, 234, 22);
		contentPanel.add(textField_2);
		
		JLabel lblEspecialidad = new JLabel("Especialidad:");
		lblEspecialidad.setBounds(371, 150, 77, 16);
		lblEspecialidad.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		contentPanel.add(lblEspecialidad);
		
		JComboBox cmbEspecialidad = new JComboBox();
		cmbEspecialidad.setBounds(447, 146, 230, 22);
		cmbEspecialidad.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		contentPanel.add(cmbEspecialidad);
		{
			JLabel lblNewLabel_3 = new JLabel("F. de Nac.:");
			lblNewLabel_3.setBounds(17, 193, 70, 16);
			lblNewLabel_3.setFont(new Font("Sylfaen", Font.PLAIN, 14));
			contentPanel.add(lblNewLabel_3);
		}
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(95, 190, 234, 22);
		contentPanel.add(dateChooser);
		{
			JLabel lblNewLabel_4 = new JLabel("Alma Mater:");
			lblNewLabel_4.setBounds(371, 193, 77, 16);
			lblNewLabel_4.setFont(new Font("Sylfaen", Font.PLAIN, 14));
			contentPanel.add(lblNewLabel_4);
		}
		{
			textField_3 = new JTextField();
			textField_3.setColumns(10);
			textField_3.setBounds(447, 190, 230, 22);
			contentPanel.add(textField_3);
		}
		
		JLabel lblNewLabel_5 = new JLabel("Descripci\u00F3n:");
		lblNewLabel_5.setBounds(17, 230, 104, 16);
		lblNewLabel_5.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		contentPanel.add(lblNewLabel_5);
		{
			textField_4 = new JTextField();
			textField_4.setColumns(10);
			textField_4.setBounds(17, 253, 660, 99);
			contentPanel.add(textField_4);
		}
		{
			textField_5 = new JTextField();
			textField_5.setEditable(false);
			textField_5.setColumns(10);
			textField_5.setBounds(95, 17, 234, 22);
			contentPanel.add(textField_5);
		}
		{
			textField_6 = new JTextField();
			textField_6.setColumns(10);
			textField_6.setBounds(447, 17, 230, 22);
			contentPanel.add(textField_6);
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
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
