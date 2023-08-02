package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import logico.Administrador;
import logico.ClinicaSONS;
import logico.Doctor;
import logico.Persona;
import logico.Vacuna;

import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ScrollPaneConstants;
import java.awt.Color;

public class ListarDoctores extends JDialog {

	private static DefaultTableModel model;
	private static Object[] row = null;
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static JComboBox cmbEspec;
	private Doctor selected = null;
	private JButton btnEliminar;
	private JButton btnModificar;
	private Administrador miAdmin = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListarDoctores dialog = new ListarDoctores();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListarDoctores() {
		miAdmin = ClinicaSONS.getLoginUserAdmin();
		setBounds(100, 100, 910, 385);
		setLocationRelativeTo(null);
		setResizable(false);
		initComponents();
	}

	private void initComponents() {
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(0, 0, 904, 308);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblNewLabel = new JLabel("Especilidad:");
				lblNewLabel.setFont(new Font("Sylfaen", Font.PLAIN, 14));
				lblNewLabel.setBounds(15, 17, 77, 16);
				panel.add(lblNewLabel);
			}
			{
				cmbEspec = new JComboBox();
				cmbEspec.setFont(new Font("Sylfaen", Font.PLAIN, 14));
				cmbEspec.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent e) {
						String especialidad = cmbEspec.getSelectedItem().toString();
						if(cmbEspec.getSelectedItem().toString().equalsIgnoreCase("Todas")){
							llenarDoctores();
						}else {
							llenarByEspecialidad(especialidad);
						}
					}
				});
				cmbEspec.setModel(new DefaultComboBoxModel(new String[] {"Todas"}));
				for (Persona aux : ClinicaSONS.getInstance().getMisPersonas()) {
					if(aux instanceof Doctor) {
						cmbEspec.addItem(((Doctor)aux).getEspecialidad());
					}
				}
				cmbEspec.setBounds(95, 14, 212, 22);
				panel.add(cmbEspec);
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBounds(15, 50, 865, 230);
				panel.add(panel_1);
				panel_1.setLayout(new BorderLayout(0, 0));
				{
					JScrollPane scrollPane = new JScrollPane();
					panel_1.add(scrollPane, BorderLayout.CENTER);
					{
						table = new JTable();
						table.setFont(new Font("Sylfaen", Font.PLAIN, 14));
						if(miAdmin != null) {
							table.addMouseListener(new MouseAdapter() {
								@Override
								public void mouseClicked(MouseEvent e) {

									int index = table.getSelectedRow();
									if (index >=0) {

										btnModificar.setEnabled(true);
										btnEliminar.setEnabled(true);
										selected = ClinicaSONS.getInstance().buscarDoctorPorCodigo(table.getValueAt(index, 0).toString());
									}
								}
							});
						}
						model = new DefaultTableModel();
						String[] headers = {"Código","Cédula","Exequatur","Nombre", "Especialidad","Teléfono","Usuario","Contraseña"};
						model.setColumnIdentifiers(headers);
						table.setModel(model);
						TableColumnModel columnModel = table.getColumnModel();
						table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
						columnModel.getColumn(0).setPreferredWidth(50);
						columnModel.getColumn(1).setPreferredWidth(120);
						columnModel.getColumn(2).setPreferredWidth(100);
						columnModel.getColumn(3).setPreferredWidth(120);
						columnModel.getColumn(4).setPreferredWidth(130);
						columnModel.getColumn(5).setPreferredWidth(100);
						columnModel.getColumn(6).setPreferredWidth(100);
						columnModel.getColumn(7).setPreferredWidth(168);
						
						
						scrollPane.setViewportView(table);
					}
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnModificar = new JButton("Modificar");
				btnModificar.setBackground(Color.WHITE);
				btnModificar.setFont(new Font("Sylfaen", Font.PLAIN, 14));
				btnModificar.setEnabled(false);
				btnModificar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						RegDoctor actualizar = new RegDoctor(selected);
						actualizar.setModal(true);
						actualizar.setVisible(true);
						btnModificar.setEnabled(false);
						btnEliminar.setEnabled(false);
						cmbEspec.setSelectedItem("Todas");
					}
				});
				buttonPane.add(btnModificar);
			}
			{
				btnEliminar = new JButton("Eliminar");
				btnEliminar.setBackground(Color.WHITE);
				btnEliminar.setFont(new Font("Sylfaen", Font.PLAIN, 14));
				btnEliminar.setEnabled(false);
				btnEliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (selected!=null) {
							int option = JOptionPane.showConfirmDialog(null, "¿Está seguro(a) de que desea eliminar al Dr(a): " + selected.getNombre()+"?", "Confirmación", JOptionPane.OK_CANCEL_OPTION);
							if (option == JOptionPane.OK_OPTION) {
								ClinicaSONS.getInstance().eliminarDoctor(selected);
								btnModificar.setEnabled(false);
								btnEliminar.setEnabled(false);
								llenarDoctores();
							}

						}



					}





				});
				btnEliminar.setActionCommand("OK");
				buttonPane.add(btnEliminar);
				getRootPane().setDefaultButton(btnEliminar);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setBackground(Color.WHITE);
				cancelButton.setFont(new Font("Sylfaen", Font.PLAIN, 14));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		llenarDoctores();
	}

	public static void llenarDoctores(){
		model.setRowCount(0);
		row = new Object[model.getColumnCount()];
		cmbEspec.setModel(new DefaultComboBoxModel(new String[] {"Todas"}));
		for (Persona aux : ClinicaSONS.getInstance().getMisPersonas()) {
			if(aux instanceof Doctor) {
				cmbEspec.addItem(((Doctor) aux).getEspecialidad().toString());
			}
		}
		for (Persona aux : ClinicaSONS.getInstance().getMisPersonas()) {
			if(aux instanceof Doctor) {
				row[0] = aux.getCod();
				row[1] = aux.getCedula();
				row[2] = ((Doctor) aux).getExeQuartur();
				row[3] = aux.getNombre();
				row[4] = ((Doctor) aux).getEspecialidad();
				row[5] = aux.getTelefono();
				row[6] = ((Doctor) aux).getUsuario();
				row[7] = ((Doctor) aux).getContrasena();
				model.addRow(row);
			}
		}
	}
	
	public void llenarByEspecialidad(String especialidad) {
		model.setRowCount(0);
		row = new Object[model.getColumnCount()];

		for (Persona aux : ClinicaSONS.getInstance().getMisPersonas()) {
			if(aux instanceof Doctor) {
				if(((Doctor) aux).getEspecialidad().equalsIgnoreCase(especialidad)) {
					row[0] = aux.getCod();
					row[1] = aux.getCedula();
					row[2] = ((Doctor) aux).getExeQuartur();
					row[3] = aux.getNombre();
					row[4] = ((Doctor) aux).getEspecialidad();
					row[5] = aux.getTelefono();
					row[6] = ((Doctor) aux).getUsuario();
					row[7] = ((Doctor) aux).getContrasena();
					
					model.addRow(row);
				}
			}
		}
	}

}
