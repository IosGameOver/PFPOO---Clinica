package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import logico.ClinicaSONS;
import logico.Enfermedad;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegEnfermedad extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCod;
	private JTextField txtNombre;
	private JTextField txtDescripcion;
	private JTextField txtSin1;
	private JTextField txtSin7;
	private JTextField txtSin4;
	private JTextField txtSin8;
	private JTextField txtSin5;
	private JTextField txtSin2;
	private JTextField txtSin9;
	private JTextField txtSin6;
	private JTextField txtSin3;
	private JButton btnRegistrar;
	private JButton btnCancelar;
	private String row = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegEnfermedad dialog = new RegEnfermedad();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegEnfermedad() {
		setBounds(100, 100, 550, 410);
		setLocationRelativeTo(null);
		setResizable(false);
		initComponents();

	}

	private void initComponents() {
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblCdigo = new JLabel("C\u00F3digo:");
		lblCdigo.setBounds(17, 23, 56, 16);
		lblCdigo.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		contentPanel.add(lblCdigo);
		
		txtCod = new JTextField();
		txtCod.setBounds(66, 20, 190, 22);
		contentPanel.add(txtCod);
		txtCod.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nombre: ");
		lblNewLabel.setBounds(273, 23, 56, 16);
		lblNewLabel.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		contentPanel.add(lblNewLabel);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(329, 20, 190, 22);
		contentPanel.add(txtNombre);
		
		JLabel lblNewLabel_1 = new JLabel("Descripci\u00F3n:");
		lblNewLabel_1.setBounds(17, 67, 94, 16);
		lblNewLabel_1.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		contentPanel.add(lblNewLabel_1);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setBounds(17, 91, 502, 80);
		contentPanel.add(txtDescripcion);
		txtDescripcion.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("S\u00EDntomas:");
		lblNewLabel_2.setBounds(17, 192, 94, 16);
		lblNewLabel_2.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		contentPanel.add(lblNewLabel_2);
		
		txtSin1 = new JTextField();
		txtSin1.setBounds(17, 215, 151, 22);
		contentPanel.add(txtSin1);
		txtSin1.setColumns(10);
		
		txtSin7 = new JTextField();
		txtSin7.setColumns(10);
		txtSin7.setBounds(368, 215, 151, 22);
		contentPanel.add(txtSin7);
		
		txtSin4 = new JTextField();
		txtSin4.setColumns(10);
		txtSin4.setBounds(194, 215, 151, 22);
		contentPanel.add(txtSin4);
		
		txtSin8 = new JTextField();
		txtSin8.setColumns(10);
		txtSin8.setBounds(368, 250, 151, 22);
		contentPanel.add(txtSin8);
		
		txtSin5 = new JTextField();
		txtSin5.setColumns(10);
		txtSin5.setBounds(194, 250, 151, 22);
		contentPanel.add(txtSin5);
		
		txtSin2 = new JTextField();
		txtSin2.setColumns(10);
		txtSin2.setBounds(17, 250, 151, 22);
		contentPanel.add(txtSin2);
		
		txtSin9 = new JTextField();
		txtSin9.setColumns(10);
		txtSin9.setBounds(368, 285, 151, 22);
		contentPanel.add(txtSin9);
		
		txtSin6 = new JTextField();
		txtSin6.setColumns(10);
		txtSin6.setBounds(194, 285, 151, 22);
		contentPanel.add(txtSin6);
		
		txtSin3 = new JTextField();
		txtSin3.setColumns(10);
		txtSin3.setBounds(17, 285, 151, 22);
		contentPanel.add(txtSin3);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnRegistrar = new JButton("Registrar");
				btnRegistrar.setActionCommand("OK");
				buttonPane.add(btnRegistrar);
				getRootPane().setDefaultButton(btnRegistrar);
			}
			{
				btnCancelar = new JButton("Cancelar");
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
	}
}


