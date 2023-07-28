package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.TextComponent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import org.omg.PortableInterceptor.SUCCESSFUL;

import logico.Administrador;
import logico.ClinicaSONS;
import logico.Vacuna;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegVacuna extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtLab;
	private JTextField txtDescripcion;
	private JTextField txtCodigo;
	private Vacuna miVacuna;
	private Administrador miAdmin = null;
	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		try {
			RegVacuna dialog = new RegVacuna();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	*/
	/**
	 * Create the dialog.
	 */
	public RegVacuna(Vacuna vacuna,Administrador admin) {
		this.miAdmin = admin;
		miVacuna = vacuna;
		setResizable(false);
		if (miVacuna==null) {
			setTitle("Registro de Vacuna");
		}else {
			setTitle("Modificación de Vacuna");
		}
		
		setBounds(100, 100, 550, 336);
		setLocationRelativeTo(null);
		setResizable(false);
		initComponents();
	}

	private void initComponents() {
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("C\u00F3digo:");
		lblNewLabel.setBounds(17, 22, 56, 16);
		lblNewLabel.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		contentPanel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setBounds(17, 68, 56, 16);
		lblNewLabel_1.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		contentPanel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Laboratorio:");
		lblNewLabel_2.setBounds(269, 68, 98, 16);
		lblNewLabel_2.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		contentPanel.add(lblNewLabel_2);

		txtNombre = new JTextField();
		txtNombre.setBounds(72, 65, 175, 22);
		contentPanel.add(txtNombre);
		txtNombre.setColumns(10);

		txtLab = new JTextField();
		txtLab.setColumns(10);
		txtLab.setBounds(344, 65, 175, 22);
		contentPanel.add(txtLab);

		JLabel lblNewLabel_3 = new JLabel("Descripci\u00F3n:");
		lblNewLabel_3.setBounds(17, 110, 83, 16);
		lblNewLabel_3.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		contentPanel.add(lblNewLabel_3);

		txtDescripcion = new JTextField();
		txtDescripcion.setBounds(17, 131, 502, 110);
		contentPanel.add(txtDescripcion);
		txtDescripcion.setColumns(10);

		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setText("V-"+ClinicaSONS.codVac);
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(72, 19, 175, 22);
		contentPanel.add(txtCodigo);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnRegistrar = new JButton("Registrar");
				if (miVacuna!=null) {
					btnRegistrar.setText("Modificar");
				}
				btnRegistrar.setFont(new Font("Sylfaen", Font.PLAIN, 14));
				btnRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (miVacuna==null) {
										
						Vacuna vacuna = null;

						String codigo = txtCodigo.getText();
						String nombre = txtNombre.getText();
						String laboratorio = txtLab.getText();
						String descripcion = txtDescripcion.getText();

						if ((codigo.trim().isEmpty()||nombre.trim().isEmpty()||laboratorio.trim().isEmpty()||descripcion.trim().isEmpty())) {
							JOptionPane.showMessageDialog(null, "CAMPO OBLIGATORIO VACIO", "Ha occurrido un error", JOptionPane.ERROR_MESSAGE);
						}
						else {
							vacuna = new Vacuna(codigo, nombre, laboratorio, descripcion);

							ClinicaSONS.getInstance().insertarVacuna(vacuna);
							JOptionPane.showMessageDialog(null, "Vacuna registrada satisfactoriamente", "Operación exitosa", JOptionPane.PLAIN_MESSAGE);
							clean();}
					}else {
						miVacuna.setCodigo(txtCodigo.getText());
						miVacuna.setDescripcion(txtDescripcion.getText());
						miVacuna.setLaboratorio(txtLab.getText());
						miVacuna.setNombre(txtNombre.getText());
						ClinicaSONS.getInstance().modificarVacuna(miVacuna);
						dispose();
						ListarVacunas.llenarTabla();
					
					}

					}


				});
				
				JButton btnVerLista = new JButton("Ver lista");
				btnVerLista.setFont(new Font("Sylfaen", Font.PLAIN, 14));
				btnVerLista.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					
						ListarVacunas list = new ListarVacunas();
						list.setModal(true);
						list.setVisible(true);
					
					}
				});
				buttonPane.add(btnVerLista);
				
				
				btnRegistrar.setActionCommand("OK");
				buttonPane.add(btnRegistrar);
				getRootPane().setDefaultButton(btnRegistrar);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.setFont(new Font("Sylfaen", Font.PLAIN, 14));
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
			
			
		}
		
		cargarVacunas(); 
	}

	private void cargarVacunas() {
		if (miVacuna!=null) {
			txtCodigo.setText(miVacuna.getCodigo());
			txtDescripcion.setText(miVacuna.getDescripcion());
			txtLab.setText(miVacuna.getLaboratorio());
			txtNombre.setText(miVacuna.getNombre());	
		}
	}

	private void clean() {
		txtCodigo.setText("V-"+ClinicaSONS.codVac);
		txtDescripcion.setText("");
		txtLab.setText("");
		txtNombre.setText("");

	}



}
