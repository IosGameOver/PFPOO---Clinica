package visual;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import logico.Cita;
import logico.ClinicaSONS;
import logico.Doctor;
import logico.Persona;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JComponent;

import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListarCitas extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPanel panelDoc;
	private JPanel panelSecretaria;
	private JTable tableSecre;
	private JTable tableDoc;
	private static DefaultTableModel model;
	private static Object[] row = null;
	private static DefaultTableModel modelDoc;
	private static Object[] rowDoc = null;
	private static Doctor miDoc = null;
	private JButton btnEliminar;
	private JButton btnModificar;
	private JButton btnCancelar;
	private Cita selected = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListarCitas dialog = new ListarCitas();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListarCitas() {
		miDoc = ClinicaSONS.getLoginUserDoc();
		setBounds(100, 100, 910, 455);
		setResizable(false);
		setLocationRelativeTo(null);
		initComponents();
	}

	private void initComponents() {
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		panelSecretaria = new JPanel();
		panelSecretaria.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelSecretaria.setBounds(12, 13, 870, 349);
		contentPanel.add(panelSecretaria);
		panelSecretaria.setLayout(null);
		
		panelDoc = new JPanel();
		panelDoc.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelDoc.setBounds(12, 13, 870, 349);
		contentPanel.add(panelDoc);
		panelDoc.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panelDoc.add(scrollPane_1, BorderLayout.CENTER);
		
		tableDoc = new JTable();
		tableDoc.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		modelDoc = new DefaultTableModel();
		String[] headers = {"Código","  Nombre  ","  Telefono  "," Fecha "," Hora ","  Doctor  "};
		modelDoc.setColumnIdentifiers(headers);
		tableDoc.setModel(modelDoc);
		scrollPane_1.setViewportView(tableDoc);
		
		if(miDoc == null) {
			panelSecretaria.setVisible(true);
			panelDoc.setVisible(false);
		}else {
			panelSecretaria.setVisible(false);
			panelDoc.setVisible(true);
		}
		
		JLabel lblNewLabel = new JLabel("Lista de doctores:");
		lblNewLabel.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		lblNewLabel.setBounds(12, 13, 102, 16);
		panelSecretaria.add(lblNewLabel);

		JComboBox cmbDoctor = new JComboBox();
		cmbDoctor.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String nomDoc = cmbDoctor.getSelectedItem().toString();
				llenarTabla(nomDoc);
			}
		});
		cmbDoctor.setModel(new DefaultComboBoxModel(new String[] {"Todos"}));
		cmbDoctor.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		for (Persona aux : ClinicaSONS.getInstance().getMisPersonas()) {
			if(aux instanceof Doctor) {
				cmbDoctor.addItem(aux.getNombre());
			}
		}
		cmbDoctor.setBounds(119, 10, 235, 22);
		panelSecretaria.add(cmbDoctor);

		JPanel panelTablaSec = new JPanel();
		panelTablaSec.setBounds(12, 42, 846, 295);
		panelSecretaria.add(panelTablaSec);
		panelTablaSec.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panelTablaSec.add(scrollPane, BorderLayout.CENTER);

		tableSecre = new JTable();
		tableSecre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = tableSecre.getSelectedRow();
				if(index >= 0){
					btnModificar.setEnabled(true);
					btnEliminar.setEnabled(true);
					selected = ClinicaSONS.getInstance().buscarCitaPorCodigo(tableSecre.getValueAt(index, 0).toString());
				}
			}
		});
		tableSecre.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		model = new DefaultTableModel();
		model.setColumnIdentifiers(headers);
		tableSecre.setModel(model);
		scrollPane.setViewportView(tableSecre);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnModificar = new JButton("Modificar");
				btnModificar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						RegCita reg = new RegCita(selected);
						reg.setModal(true);
						reg.setVisible(true);
						btnEliminar.setEnabled(false);
						btnModificar.setEnabled(false);
					}
				});
				btnModificar.setEnabled(false);
				btnModificar.setFont(new Font("Sylfaen", Font.PLAIN, 14));
				btnModificar.setActionCommand("OK");
				buttonPane.add(btnModificar);
				getRootPane().setDefaultButton(btnModificar);
			}
			{
				btnCancelar = new JButton("Cancelar");
				btnCancelar.setFont(new Font("Sylfaen", Font.PLAIN, 14));
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				
				btnEliminar = new JButton("Eliminar");
				btnEliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(selected != null){
							int option = JOptionPane.showConfirmDialog(null, "Está seguro(a) que desea eliminar el empleado con código: "+selected.getCodigo(),"Confirmación",JOptionPane.OK_CANCEL_OPTION);
							if(option == JOptionPane.OK_OPTION){
								ClinicaSONS.getInstance().eliminarCita(selected);
								btnEliminar.setEnabled(false);
								btnModificar.setEnabled(false);
								llenarTabla(cmbDoctor.getSelectedItem().toString());
							}
							
						}
					}
				});
				btnEliminar.setEnabled(false);
				btnEliminar.setFont(new Font("Sylfaen", Font.PLAIN, 14));
				buttonPane.add(btnEliminar);
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
			if(miDoc != null) {
				btnEliminar.setVisible(false);
				btnModificar.setVisible(false);
			}
		}

		llenarTabla("Todos");
		llenarTablaDoc();
		
	}

	public static void llenarTablaDoc() {
		modelDoc.setRowCount(0);
		rowDoc = new Object[modelDoc.getColumnCount()];
		if(miDoc != null) {
			for (Cita aux : miDoc.getMisCitas()) {
				rowDoc[0] = aux.getCodigo();
				rowDoc[1] = aux.getNombrePersona();
				rowDoc[2] = aux.getTelefonoPersona();
				rowDoc[3] = aux.getFechaReservada();
				rowDoc[4] = aux.getHorario();
				rowDoc[5] = aux.getDoctor();
				modelDoc.addRow(rowDoc);
			}
		}
	}

	public static void llenarTabla(String nomDoc) {
		model.setRowCount(0);
		row = new Object[model.getColumnCount()];
		if(nomDoc.equalsIgnoreCase("Todos")) {
			for (Cita aux : ClinicaSONS.getInstance().getMisCitas()) {
				row[0] = aux.getCodigo();
				row[1] = aux.getNombrePersona();
				row[2] = aux.getTelefonoPersona();
				row[3] = aux.getFechaReservada();
				row[4] = aux.getHorario();
				row[5] = aux.getDoctor();
				model.addRow(row);
			}
		}else{
			Doctor doc = ClinicaSONS.getInstance().buscarDoctorPorNombre(nomDoc);
			for (Cita aux : doc.getMisCitas()) {
				row[0] = aux.getCodigo();
				row[1] = aux.getNombrePersona();
				row[2] = aux.getTelefonoPersona();
				row[3] = aux.getFechaReservada();
				row[4] = aux.getHorario();
				row[5] = aux.getDoctor();
				model.addRow(row);
			}
		}
		
	}
}
