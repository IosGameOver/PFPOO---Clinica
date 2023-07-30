package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import logico.Administrador;
import logico.ClinicaSONS;
import logico.Vacuna;

import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListarVacunas extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static DefaultTableModel model;
	private static Object[] row = null;
	private Vacuna selected = null;
	private JButton btnEliminar;
	private JButton btnModificar;
	private Administrador miAdmin = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListarVacunas dialog = new ListarVacunas();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	/**
	 * Create the dialog.
	 */
	public ListarVacunas() {
		setTitle("Lista de Vacunas");
		miAdmin = ClinicaSONS.getLoginUserAdmin();
		setBounds(100, 100, 710, 370);
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
			panel.setBounds(12, 13, 668, 257);
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
									selected = ClinicaSONS.getInstance().buscarVacunaPorCodigo(table.getValueAt(index, 0).toString());

								}

							}
						});
					}
					model = new DefaultTableModel();
					String[] headers = {"Código", "Nombre", "Laboratorio","Descripción"};
					model.setColumnIdentifiers(headers);
					table.setModel(model);
					table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
					TableColumnModel columnModel = table.getColumnModel();
					columnModel.getColumn(0).setPreferredWidth(80);
					columnModel.getColumn(1).setPreferredWidth(150);
					columnModel.getColumn(2).setPreferredWidth(150);
					columnModel.getColumn(3).setPreferredWidth(286);
					scrollPane.setViewportView(table);
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
				btnModificar.setEnabled(false);
				btnModificar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						RegVacuna actualizar = new RegVacuna(selected,miAdmin);
						actualizar.setModal(true);
						actualizar.setVisible(true);
					}
				});
				buttonPane.add(btnModificar);
			}
			{
				btnEliminar = new JButton("Eliminar");
				btnEliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (selected!=null) {
							int option = JOptionPane.showConfirmDialog(null, "¿Está seguro(a) de que desea eliminar la Vacuna:  " + selected.getCodigo(), "Confirmación", JOptionPane.OK_CANCEL_OPTION);
							if (option == JOptionPane.OK_OPTION) {
								ClinicaSONS.getInstance().eliminarVacuna(selected);
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

				if(miAdmin != null) {
					btnEliminar.setVisible(false);
					btnModificar.setVisible(false);
				}
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
		}
		llenarTabla();
	}


	public static void llenarTabla(){
		model.setRowCount(0);
		row = new Object[model.getColumnCount()];
		for (Vacuna aux : ClinicaSONS.getInstance().getMisVacunas()) {
			row[0] = aux.getCodigo();
			row[1] = aux.getNombre();
			row[2] = aux.getLaboratorio();
			row[3] = aux.getDescripcion();

			model.addRow(row);
		}
	}
}
