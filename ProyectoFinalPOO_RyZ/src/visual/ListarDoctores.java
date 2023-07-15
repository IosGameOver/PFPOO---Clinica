package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import logico.ClinicaSONS;
import logico.Doctor;
import logico.Persona;
import logico.Vacuna;

import javax.swing.DefaultComboBoxModel;

public class ListarDoctores extends JDialog {

	private static DefaultTableModel model;
	private static Object[] row = null;
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JComboBox cmbEspec;

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
		setBounds(100, 100, 640, 370);
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
			panel.setBounds(12, 13, 610, 274);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblNewLabel = new JLabel("Especilidad:");
				lblNewLabel.setFont(new Font("Sylfaen", Font.PLAIN, 14));
				lblNewLabel.setBounds(17, 17, 77, 16);
				panel.add(lblNewLabel);
			}
			{
				cmbEspec = new JComboBox();
				cmbEspec.setModel(new DefaultComboBoxModel(new String[] {"<Seleccionar>"}));
				for (Persona aux : ClinicaSONS.getInstance().getMisPersonas()) {
					if(aux instanceof Doctor) {
						cmbEspec.addItem(((Doctor)aux).getEspecialidad());
					}
				}
				cmbEspec.setBounds(88, 13, 212, 22);
				panel.add(cmbEspec);
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBounds(17, 46, 576, 211);
				panel.add(panel_1);
				panel_1.setLayout(new BorderLayout(0, 0));
				{
					JScrollPane scrollPane = new JScrollPane();
					panel_1.add(scrollPane, BorderLayout.CENTER);
					{
						table = new JTable();
						model = new DefaultTableModel();
						String[] headers = {"Código","Cédula","Exequatur","Nombre", "Especialidad","Teléfono"};
						model.setColumnIdentifiers(headers);
						table.setModel(model);
						scrollPane.setViewportView(table);
					}
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
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
	
	public static void llenarTabla(){
		model.setRowCount(0);
		row = new Object[model.getColumnCount()];
		for (Persona aux : ClinicaSONS.getInstance().getMisPersonas()) {
			if(aux instanceof Doctor) {
				row[0] = aux.getCod();
				row[1] = aux.getCedula();
				row[2] = ((Doctor) aux).getExeQuartur();
				row[3] = aux.getNombre();
				row[4] = ((Doctor) aux).getEspecialidad();
				row[5] = aux.getTelefono();
			}
			
			model.addRow(row);
		}
	}

}
