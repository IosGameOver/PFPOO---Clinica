package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.Administrador;
import logico.ClinicaSONS;
import logico.Secretario;
import logico.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegUsuario extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtUsuario;
	private JTextField txtContrasena;
	private JComboBox cmbTipo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegUsuario dialog = new RegUsuario();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegUsuario() {
		setBounds(100, 100, 472, 283);
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
			JLabel lblNewLabel = new JLabel("Usuario:");
			lblNewLabel.setBounds(12, 31, 56, 16);
			contentPanel.add(lblNewLabel);
		}
		{
			txtUsuario = new JTextField();
			txtUsuario.setBounds(89, 28, 202, 22);
			contentPanel.add(txtUsuario);
			txtUsuario.setColumns(10);
		}
		{
			txtContrasena = new JTextField();
			txtContrasena.setBounds(89, 63, 202, 22);
			contentPanel.add(txtContrasena);
			txtContrasena.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Contrase\u00F1a:");
			lblNewLabel_1.setBounds(12, 66, 76, 16);
			contentPanel.add(lblNewLabel_1);
		}
		{
			cmbTipo = new JComboBox();
			cmbTipo.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Administrador/a", "Secretario/a"}));
			cmbTipo.setBounds(89, 108, 202, 22);
			contentPanel.add(cmbTipo);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Tipo:");
			lblNewLabel_2.setBounds(12, 111, 56, 16);
			contentPanel.add(lblNewLabel_2);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Usuario usuario = null;
						String user = txtUsuario.getText();
						String contrasena = txtContrasena.getText();
						String tipo = cmbTipo.getSelectedItem().toString();
						if(user.trim().isEmpty() || contrasena.trim().isEmpty()) {
							JOptionPane.showMessageDialog(null, "Complete los campos vacíos", "¡Error!",JOptionPane.ERROR_MESSAGE);
						}else if(tipo.equalsIgnoreCase("<Seleccione>")) {
							JOptionPane.showMessageDialog(null, "Seleccione un tipo de usuario valido", "¡Error!",JOptionPane.ERROR_MESSAGE);
						}else {
							if(tipo.equalsIgnoreCase("Administrador")) {
								usuario = new Administrador(user, contrasena);
								ClinicaSONS.getInstance().insertarUsuario(usuario);
							}else {
								usuario = new Secretario(user, contrasena);
								ClinicaSONS.getInstance().insertarUsuario(usuario);
							}
						}
					}
				});
				okButton.setActionCommand("btnRegistrar");
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
