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
import logico.Usuario;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class ListarUsuarios extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private DefaultTableModel model;
	private Object[] row;

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

	/**
	 * Create the dialog.
	 */
	public ListarUsuarios() {
		setBounds(100, 100, 600, 350);
		setTitle("Listado de usuarios");
		setLocationRelativeTo(null);
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
		comboBox.setBounds(112, 13, 185, 22);
		panel.add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Todos", "Administrador/a", "Secretario/a"}));

		JLabel lblNewLabel = new JLabel("Tipo de usuario:");
		lblNewLabel.setBounds(12, 16, 110, 16);
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(12, 45, 534, 179);
		panel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
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
				JButton btnModificar = new JButton("Modificar");
				btnModificar.setEnabled(false);
				btnModificar.setActionCommand("OK");
				buttonPane.add(btnModificar);
				getRootPane().setDefaultButton(btnModificar);
			}
			
			JButton btnEliminar = new JButton("Eliminar");
			btnEliminar.setEnabled(false);
			buttonPane.add(btnEliminar);
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		llenarTabla("Todos");
	}

	public void llenarTabla(String tipo) {
		model.setRowCount(0);
		row = new Object[table.getColumnCount()];
		if(tipo.equalsIgnoreCase("Todos")) {
			for (Usuario  aux: ClinicaSONS.getInstance().getMisUsuarios()) {
				row[0] = aux.getUserName();
				row[1] = aux.getPass();
				if(aux.getNvlAutoridad() == 1) {
					row[2] = "Administrador";
				}else if(aux.getNvlAutoridad() == 10) {
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
