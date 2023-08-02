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
import logico.Consulta;
import logico.Doctor;
import logico.Paciente;
import logico.Persona;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.text.SimpleDateFormat;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListarConsultas extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable tableGen;
	private DefaultTableModel model;
	private Object[] row = null;
	private DefaultTableModel modelDoc;
	private Object[] rowDoc = null;
	private SimpleDateFormat df;
	private Doctor miDoc = null;
	private JTable tableDoc;
	private JPanel panelDoc;
	private JPanel panelGen;
	private Consulta selected = null;
	private JButton btnVer;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListarConsultas dialog = new ListarConsultas();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListarConsultas() {
		miDoc = ClinicaSONS.getLoginUserDoc();
		df = new SimpleDateFormat("dd/MM/yyyy");
		setBounds(100, 100, 780, 400);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			panelDoc = new JPanel();
			panelDoc.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelDoc.setBounds(12, 13, 728, 277);
			contentPanel.add(panelDoc);
			panelDoc.setLayout(new BorderLayout(0, 0));

			JScrollPane scrollPane_1 = new JScrollPane();
			panelDoc.add(scrollPane_1, BorderLayout.CENTER);

			tableDoc = new JTable();
			tableDoc.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int index = tableDoc.getSelectedRow();
					if(index >= 0){
						btnVer.setEnabled(true);
						selected = ClinicaSONS.getInstance().buscarConsultaByCod((tableDoc.getValueAt(index, 0).toString()));
					}
				}
			});
			tableDoc.setFont(new Font("Sylfaen", Font.PLAIN, 14));
			modelDoc = new DefaultTableModel();
			String[] headers = {" Código "," Paciente ","  Fecha  ","  Doctor  "};
			modelDoc.setColumnIdentifiers(headers);
			tableDoc.setModel(modelDoc);
			scrollPane_1.setViewportView(tableDoc);

			panelGen = new JPanel();
			panelGen.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelGen.setBounds(12, 13, 728, 277);
			contentPanel.add(panelGen);
			panelGen.setLayout(null);
			{
				JLabel lblNewLabel = new JLabel("Lista de doctores:");
				lblNewLabel.setFont(new Font("Sylfaen", Font.PLAIN, 14));
				lblNewLabel.setBounds(12, 13, 111, 16);
				panelGen.add(lblNewLabel);
			}

			
			JComboBox comboBox = new JComboBox();
			comboBox.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					String doc = comboBox.getSelectedItem().toString();
					llenarTablaGen(doc);
				}
			});
			comboBox.setFont(new Font("Sylfaen", Font.PLAIN, 14));
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"Todos"}));
			for (Persona aux : ClinicaSONS.getInstance().getMisPersonas()) {
				if(aux instanceof Doctor) {
					comboBox.addItem(aux.getNombre());
				}
			}
			comboBox.setBounds(120, 10, 192, 22);
			panelGen.add(comboBox);

			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_1.setBounds(12, 42, 704, 222);
			panelGen.add(panel_1);
			panel_1.setLayout(new BorderLayout(0, 0));

			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			panel_1.add(scrollPane, BorderLayout.CENTER);

			tableGen = new JTable();
			tableGen.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int index = tableGen.getSelectedRow();
					if(index >= 0){
						btnVer.setEnabled(true);
						selected = ClinicaSONS.getInstance().buscarConsultaByCod((tableGen.getValueAt(index, 0).toString()));
					}
				}
			});
			model = new DefaultTableModel();
			model.setColumnIdentifiers(headers);
			tableGen.setModel(model);
			tableGen.setFont(new Font("Sylfaen", Font.PLAIN, 14));
			scrollPane.setViewportView(tableGen);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnVer = new JButton("Ver");
				btnVer.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						HistorialConsulta hist = new HistorialConsulta(null, null, selected);
						hist.setModal(true);
						hist.setVisible(true);
					}
				});
				btnVer.setEnabled(false);
				btnVer.setActionCommand("OK");
				buttonPane.add(btnVer);
				getRootPane().setDefaultButton(btnVer);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		if(miDoc != null) {
			panelGen.setVisible(false);
			panelDoc.setVisible(true);
			llenarTablaDoc();
		}else {
			panelGen.setVisible(true);
			panelDoc.setVisible(false);
			llenarTablaGen("Todos");
		}
	}

	public void llenarTablaGen(String nom) {
		model.setRowCount(0);
		row = new Object[model.getColumnCount()];
		if(nom.equalsIgnoreCase("Todos")) {
			for (Consulta aux : ClinicaSONS.getInstance().getMisConsultas()) {
				Paciente pac = ClinicaSONS.getInstance().buscarPacienteByCedula(aux.getCedPac());
				row[0] = aux.getCod();
				row[1] = df.format(aux.getFecha());
				
				model.addRow(row);
			}
		}else {
			Doctor doc = ClinicaSONS.getInstance().buscarDoctorPorNombre(nom);
			for (Consulta aux : doc.getMisConsultas()) {
				row[0] = aux.getCod();
				row[1] = df.format(aux.getFecha());
				model.addRow(row);
			}
		}
	}
	
	public void llenarTabla() {
		modelDoc.setRowCount(0);
		rowDoc = new Object[modelDoc.getColumnCount()];
		if(miDoc != null) {
			for (Consulta aux : miDoc.getMisConsultas()) {
				rowDoc[0] = aux.getCod();
				rowDoc[1] = df.format(aux.getFecha());
	 			modelDoc.addRow(rowDoc);
			}
		}else {
			for (Consulta aux : ClinicaSONS.getInstance().getMisConsultas()) {
				rowDoc[0] = aux.getCod();
				rowDoc[1] = df.format(aux.getFecha());
	 			modelDoc.addRow(rowDoc);
			}
		}
		
	}

	public void llenarTablaDoc() {
		modelDoc.setRowCount(0);
		rowDoc = new Object[modelDoc.getColumnCount()];
		for (Consulta aux : miDoc.getMisConsultas()) {
			rowDoc[0] = aux.getCod();
			rowDoc[1] = df.format(aux.getFecha());
 			modelDoc.addRow(rowDoc);
		}
	}
}
