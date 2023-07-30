package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import logico.Administrador;
import logico.ClinicaSONS;
import logico.Doctor;

import logico.Persona;
import logico.Secretario;
import logico.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListarUsuarios extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private DefaultTableModel model;
	private Object[] row;
	

	private Usuario selected = null;
//	private Doctor selected = null;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JScrollPane scrollPane;
	private static ListarUsuarios listasUsuarios = null;
	private Administrador miAdmin = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListarUsuarios dialog = new ListarUsuarios();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ListarUsuarios getInstance() {
		if(listasUsuarios == null)
			listasUsuarios = new ListarUsuarios();
		return listasUsuarios;
	}
	
	
	/**
	 * Create the dialog.
	 */
	public ListarUsuarios() {
		miAdmin = ClinicaSONS.getLoginUserAdmin();
		setBounds(100, 100, 600, 350);
		setTitle("Listado de usuarios");
		setLocationRelativeTo(null);
		setResizable(false);
		initComponents();
	}

	
	private void initComponents() {
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(12, 13, 558, 237);
		contentPanel.add(panel);
		panel.setLayout(null);

		JComboBox comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String tipo = comboBox.getSelectedItem().toString();
				llenarTabla(tipo);
			}
		});
		comboBox.setBounds(140, 13, 185, 22);
		panel.add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Todos", "Administrador/a", "Secretario/a", "Doctor/a"}));

		JLabel lblNewLabel = new JLabel("Tipo de usuario:");
		lblNewLabel.setBounds(12, 16, 137, 16);
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(12, 45, 534, 179);
		panel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		scrollPane = new JScrollPane();
		
		panel_1.add(scrollPane, BorderLayout.CENTER);


		table = new JTable();
		if(miAdmin != null) {
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
			int index = table.getSelectedRow();
			if (index >=0) {

				btnModificar.setEnabled(true);
				btnEliminar.setEnabled(true);
				selected = ClinicaSONS.getInstance().buscarUsuarioPorUser(table.getValueAt(index, 0).toString());
			}
		
			}
		});
		}
		model = new DefaultTableModel();
		String[] headers = {" Usuario ", " Contraseña ", " Tipo "};
		model.setColumnIdentifiers(headers);
		table.setModel(model);
		scrollPane.setViewportView(table);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnModificar = new JButton("Modificar");
				btnModificar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					if (selected!=null) {
						RegUsuario actualizar = new RegUsuario(selected);
						actualizar.setModal(true);
						actualizar.setVisible(true);
							
					}
					}
				});
				
				JButton btnVaciar = new JButton("Vaciar");
				btnVaciar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						model.getDataVector().removeAllElements();
						model.fireTableDataChanged(); 
						
					}
				});
				buttonPane.add(btnVaciar);
				btnModificar.setEnabled(false);
				btnModificar.setActionCommand("OK");
				buttonPane.add(btnModificar);
				getRootPane().setDefaultButton(btnModificar);
			}
			
			btnEliminar = new JButton("Eliminar");
			btnEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
					if (selected!=null) {
						int option = JOptionPane.showConfirmDialog(null, "¿Está seguro(a) de que desea eliminar al usuario:  " + selected.getUserName(), "Confirmación", JOptionPane.OK_CANCEL_OPTION);
						if (option == JOptionPane.OK_OPTION) {
							ClinicaSONS.getInstance().eliminarUsuario(selected);;

							btnModificar.setEnabled(false);
							btnEliminar.setEnabled(false);
							llenarTabla("Todos");
						}

					}
																								
				
				}
			});
			btnEliminar.setEnabled(false);
			buttonPane.add(btnEliminar);
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
		
	/*	Administrador adm = new Administrador("Elmaca","non");
		Secretario sec = new Secretario("Secre", "Secre");
		ClinicaSONS.getInstance().insertarUsuario(adm);
		ClinicaSONS.getInstance().insertarUsuario(sec); */
		
		llenarTabla("Todos");
		
		
	}

	
	public void llenarTabla(String tipo) {
		model.setRowCount(0);
		row = new Object[table.getColumnCount()];
		if(tipo.equalsIgnoreCase("Todos")) {
			for (Usuario  aux: ClinicaSONS.getInstance().getMisUsuarios()) {
				row[0] = aux.getUserName();
				row[1] = aux.getPass();
				if(aux.getTipo().equals("Administrador")) {
					row[2] = "Administrador";
				}else if(aux.getTipo().equals("Secretario")) {
					row[2] = "Secretario";
				}
					model.addRow(row);
			} 
		}else if(tipo.equalsIgnoreCase("Administrador/a")) {
			for (Usuario  aux: ClinicaSONS.getInstance().getMisUsuarios()) {
				if(aux instanceof Administrador) {
					row[0] = aux.getUserName();
					row[1] = aux.getPass();
					row[2] = "Administrador/a";
					model.addRow(row);
				}
			}
		}else if(tipo.equalsIgnoreCase("Secretario/a")) {
			for (Usuario  aux: ClinicaSONS.getInstance().getMisUsuarios()) {
				if(aux instanceof Administrador) {
					row[0] = aux.getUserName();
					row[1] = aux.getPass();
					row[2] = "Secretario/a";
					model.addRow(row);
				}
			}
		}
		
	}
	


}

