package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import logico.Administrador;
import logico.ClinicaSONS;
import logico.Enfermedad;
import logico.Vacuna;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListarEnfermedad extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static DefaultTableModel model;
	private static Object[] row = null;
	private Enfermedad selected = null;
	private JButton btnModificar;
	private JButton btnEliminar;
	private Administrador miAdmin = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListarEnfermedad dialog = new ListarEnfermedad();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListarEnfermedad() {
		miAdmin = ClinicaSONS.getLoginUserAdmin();
		setTitle("Listado de Enfermedades bajo vigilancia");
		setBounds(100, 100, 860, 370);
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
			panel.setBorder(null);
			panel.setBounds(12, 13, 813, 262);
			contentPanel.add(panel);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				panel.add(scrollPane, BorderLayout.CENTER);
				{
					table = new JTable();
					if(miAdmin != null) {
						table.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {

								int index = table.getSelectedRow();
								if (index >=0) {

									btnModificar.setEnabled(true);
									btnEliminar.setEnabled(true);
									selected = ClinicaSONS.getInstance().buscarEnfermedadPorCodigo(table.getValueAt(index, 0).toString());

								}
							}
						});
					}
					model = new DefaultTableModel();
					String[] headers = {"Código", "Nombre", "Descripción","Síntomas"};
					model.setColumnIdentifiers(headers);
					table.setModel(model);
					table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
					table.getTableHeader().setReorderingAllowed(false);
					TableColumnModel columnModel = table.getColumnModel();
					columnModel.getColumn(0).setPreferredWidth(80);
					columnModel.getColumn(1).setPreferredWidth(180);
					columnModel.getColumn(2).setPreferredWidth(300);
					columnModel.getColumn(3).setPreferredWidth(250);
					scrollPane.setViewportView(table);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			FlowLayout fl_buttonPane = new FlowLayout(FlowLayout.RIGHT);
			buttonPane.setLayout(fl_buttonPane);
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnModificar = new JButton("Modificar");
				btnModificar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						RegEnfermedad actualizar = new RegEnfermedad(selected,null);
						actualizar.setModal(true);
						actualizar.setVisible(true);
					}
				});
				btnModificar.setEnabled(false);
				buttonPane.add(btnModificar);
			}
			{
				btnEliminar = new JButton("Eliminar");
				btnEliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (selected!=null) {
							int option = JOptionPane.showConfirmDialog(null, "¿Está seguro(a) de que desea eliminar la Enfermedad:  " + selected.getCodigo(), "Confirmación", JOptionPane.OK_CANCEL_OPTION);
							if (option == JOptionPane.OK_OPTION) {
								ClinicaSONS.getInstance().eliminarEnfermedad(selected);

								btnModificar.setEnabled(false);
								btnEliminar.setEnabled(false);
								llenarTabla();
							}

						}



					}
				});
				btnEliminar.setEnabled(false);
				btnEliminar.setActionCommand("OK");
				buttonPane.add(btnEliminar);
				getRootPane().setDefaultButton(btnEliminar);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						dispose();

					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
			if(miAdmin == null) {
				btnEliminar.setVisible(false);
				btnModificar.setVisible(false);
			}
		}
		llenarTabla();
	}

	public static void llenarTabla() {
		model.setRowCount(0);
		row = new Object[model.getColumnCount()];
		for (Enfermedad aux : ClinicaSONS.getInstance().getMisEnfermedades()) {
			row[0] = aux.getCodigo();
			row[1] = aux.getNombre();
			row[2] = aux.getDescripcion();
			row[3] = aux.getSintomas().get(0)+", ";
			for (int i = 1; i < aux.getSintomas().size(); i++) {
				if(i < aux.getSintomas().size()-1) {
					row[3] += aux.getSintomas().get(i)+", ";
				}else {
					row[3] += aux.getSintomas().get(i)+".";
				}
			}
			model.addRow(row);
		}
	}
}


