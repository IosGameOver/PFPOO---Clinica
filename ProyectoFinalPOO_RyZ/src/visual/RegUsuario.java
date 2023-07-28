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
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.event.ActionEvent;

public class RegUsuario extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtUsuario;
	private JTextField txtContrasena;
	private JComboBox cmbTipo;
	private Usuario	miUsuario;
	/**
	 * Launch the application.
	 */
	

	public static void main(String[] args) {
		try {
			RegUsuario dialog = new RegUsuario(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	/**
	 * Create the dialog.
	 */
	public RegUsuario(Usuario elusuario) { 
		miUsuario = elusuario;
		if (miUsuario==null) {
			setTitle("Registro de Usuario");
		}else {
			setTitle("Modificación de Usuario");
		}
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
			cmbTipo.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Administrador/a", "Secretario/a", "Doctor/a"}));
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
				
						if (miUsuario==null||miUsuario!=null) {
							
							if (miUsuario==null) {
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
										clean();
									}
								}
							
							}else if (miUsuario!=null) {
								miUsuario.setUserName(txtUsuario.getText());
								miUsuario.setPass(txtContrasena.getText());
								miUsuario.setTipo(cmbTipo.getSelectedItem().toString());
								ClinicaSONS.getInstance().modificarUsuario(miUsuario);
								dispose();
								
								ListarUsuarios.getInstance().llenarTabla("Todos");
							}
							
						}else{
						
								JOptionPane.showMessageDialog(null, "Es un doctor");
						}
						
					
				}});
				{
					JButton btnVerLista = new JButton("Ver lista");
					btnVerLista.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
						
						ListarUsuarios list = new ListarUsuarios();
						list.setModal(true);
						list.setVisible(true);
						dispose();
						
						
						}
					});
					buttonPane.add(btnVerLista);
				}
				okButton.setActionCommand("btnRegistrar");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
			
			
		}
		cargarUsuarios(); 
	}
	private void cargarUsuarios() {
		if (miUsuario!=null) {
			txtUsuario.setText(miUsuario.getUserName());
			txtContrasena.setText(miUsuario.getPass());
			if (miUsuario.getTipo()=="Administrador") {
				cmbTipo.setSelectedIndex(1);
			}if (miUsuario.getTipo()=="Secretario") {
				cmbTipo.setSelectedIndex(2);
			}else {
				cmbTipo.setSelectedIndex(3);
			}
		}
		
	}



	private void clean() {
		txtContrasena.setText("");
		txtUsuario.setText("");
		cmbTipo.setSelectedIndex(0);
	
	
	}
}

















































	






