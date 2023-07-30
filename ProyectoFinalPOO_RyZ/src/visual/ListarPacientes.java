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

import logico.ClinicaSONS;
import logico.Doctor;
import logico.Paciente;
import logico.Vacuna;
import logico.Persona;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.util.Date;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListarPacientes extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable tableDoc;
	private Doctor miDoc = null;
	private DefaultTableModel model;
	private Object[] row = null;
	private JButton btnEliminar;
	private JButton btnHistorialVacuna;
	private JButton btnVerHistorialMed;
	private Paciente selected = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListarPacientes dialog = new ListarPacientes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListarPacientes() {
		miDoc = ClinicaSONS.getLoginUserDoc();
		setBounds(100, 100, 860, 410);
		setResizable(false);
		setLocationRelativeTo(null);
		initComponets();
	}

	private void initComponets() {
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(12, 13, 820, 299);
		contentPanel.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		{
			tableDoc = new JTable();
			
			tableDoc.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int index = tableDoc.getSelectedRow();
					if(index >= 0){
						btnEliminar.setEnabled(true);
						btnHistorialVacuna.setEnabled(true);
						btnVerHistorialMed.setEnabled(true);
						selected = ClinicaSONS.getInstance().buscarPacientePorCodigo(tableDoc.getValueAt(index, 0).toString());
					}
				}
			});
			tableDoc.setFont(new Font("Sylfaen", Font.PLAIN, 14));
			model = new DefaultTableModel();
			String[] headers = {" C�digo ","  Cedula  ","  Nombre  ","  Telefono  ","  Sexo  ","  Edad  "};
			model.setColumnIdentifiers(headers);
			tableDoc.setModel(model);
			scrollPane.setViewportView(tableDoc);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnVerHistorialMed = new JButton("Ver historial m\u00E9dico");
				btnVerHistorialMed.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						HistorialMedico hist = new HistorialMedico(null, selected);
						hist.setEnabled(false);
						hist.setVisible(false);
						btnEliminar.setEnabled(false);
						btnHistorialVacuna.setEnabled(false);
						btnVerHistorialMed.setEnabled(false);
					}
				});
				btnVerHistorialMed.setEnabled(false);
				btnVerHistorialMed.setFont(new Font("Sylfaen", Font.PLAIN, 14));
				buttonPane.add(btnVerHistorialMed);
			}
			{
				btnHistorialVacuna = new JButton("Ver historial de Vacunaci\u00F3n");
				btnHistorialVacuna.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						IndicarVacunas ind = new IndicarVacunas(selected, null);
						ind.setModal(true);
						ind.setVisible(true);
						btnEliminar.setEnabled(false);
						btnHistorialVacuna.setEnabled(false);
						btnVerHistorialMed.setEnabled(false);
					}
				});
				btnHistorialVacuna.setEnabled(false);
				btnHistorialVacuna.setFont(new Font("Sylfaen", Font.PLAIN, 14));
				buttonPane.add(btnHistorialVacuna);
			}
			{
				btnEliminar = new JButton("Eliminar");
				btnEliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int option = JOptionPane.showConfirmDialog(null, "Est� seguro(a) que desea eliminar el paciente con c�digo: "+selected.getCod(),"Confirmaci�n",JOptionPane.OK_CANCEL_OPTION);
						if(option == JOptionPane.OK_OPTION){
							ClinicaSONS.getInstance().getInstance().eliminarPaciente(selected);
							btnEliminar.setEnabled(false);
							btnHistorialVacuna.setEnabled(false);
							btnVerHistorialMed.setEnabled(false);
							llenarTabla();
						}
						
					}
				});
				btnEliminar.setEnabled(false);
				btnEliminar.setFont(new Font("Sylfaen", Font.PLAIN, 14));
				btnEliminar.setActionCommand("Registrar");
				buttonPane.add(btnEliminar);
				getRootPane().setDefaultButton(btnEliminar);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.setFont(new Font("Sylfaen", Font.PLAIN, 14));
				btnCancelar.setActionCommand("Cancelar");
				buttonPane.add(btnCancelar);
			}
		}
		llenarTabla();
	}
	
	public void llenarTabla() {
		model.setRowCount(0);
		row = new Object[model.getColumnCount()];
		if(miDoc != null) {
			for (Paciente aux : miDoc.getMisPacientes()) {
					row[0] = aux.getCod();
					row[1] = aux.getCedula();
					row[2] = aux.getNombre();
					row[3] = aux.getTelefono();
					row[4] = aux.getSexo();
					row[5] = ClinicaSONS.getInstance().calcularEdad(aux.getFechaNacimiento(), new Date());
					
					model.addRow(row);
			}
		}else {
			for (Persona aux : ClinicaSONS.getInstance().getMisPersonas()) {
				if(aux instanceof Paciente) {
					row[0] = aux.getCod();
					row[1] = aux.getCedula();
					row[2] = aux.getNombre();
					row[3] = aux.getTelefono();
					row[4] = aux.getSexo();
					row[5] = ClinicaSONS.getInstance().calcularEdad(aux.getFechaNacimiento(), new Date());
					
					model.addRow(row);
				}
			}
		}
		
	}
	
}
