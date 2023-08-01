package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import logico.ClinicaSONS;
import logico.Consulta;
import logico.Paciente;
import logico.Vacuna;

import java.awt.Font;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class IndicarVacunas extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Paciente miPac = null;
	private JTable table;
	private DefaultTableModel model;
	private Object[] row = null;
	private SimpleDateFormat df;
	private Consulta miCons = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			IndicarVacunas dialog = new IndicarVacunas(null,null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * @param miCons 
	 */
	public IndicarVacunas(Paciente pac, Consulta miCons) {
		this.miCons = miCons;
		this.miPac = pac;
		df = new SimpleDateFormat("dd/MM/yyyy");
		setBounds(100, 100, 775, 360);
		setResizable(false);
		setLocationRelativeTo(null);
		initComponents();
	}

	private void initComponents() {
		if(miPac != null && miCons == null) {
			setTitle("Historial de vacunación de "+miPac.getNombre());
		}
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Vacunas del paciente "+miPac.getNombre(), TitledBorder.LEADING, TitledBorder.TOP, new Font("Sylfaen", Font.PLAIN, 14), null));
			panel.setBounds(12, 13, 736, 257);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				if(miPac != null && miCons == null) {
					panel_1.setBounds(12, 23, 713, 221);
				}else {
					panel_1.setBounds(12, 77, 713, 167);
				}
				panel.add(panel_1);
				panel_1.setLayout(new BorderLayout(0, 0));
				{
					JScrollPane scrollPane = new JScrollPane();
					scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
					panel_1.add(scrollPane, BorderLayout.CENTER);
					
					table = new JTable();
					table.setBackground(Color.WHITE);
					table.setFont(new Font("Sylfaen", Font.PLAIN, 14));
					model = new DefaultTableModel();
					String headers[] = {"Código","nombre","Laboratorio","Fecha"};
					model.setColumnIdentifiers(headers);
					table.setModel(model);
					scrollPane.setViewportView(table);
				}
			}
			
			JComboBox cmbVacunas = new JComboBox();
			cmbVacunas.setBackground(Color.WHITE);
			cmbVacunas.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>"}));
			for (Vacuna aux : ClinicaSONS.getInstance().getMisVacunas()) {
				for (Vacuna vac : miPac.getMisVacunas()) {
					if(!aux.getCodigo().equalsIgnoreCase(vac.getCodigo())) {
						cmbVacunas.addItem(aux);
					}
				}
			}
			cmbVacunas.setFont(new Font("Sylfaen", Font.PLAIN, 14));
			cmbVacunas.setBounds(63, 33, 237, 22);
			panel.add(cmbVacunas);
			
			JLabel lblNewLabel = new JLabel("Vacuna:");
			lblNewLabel.setFont(new Font("Sylfaen", Font.PLAIN, 14));
			lblNewLabel.setBounds(12, 36, 56, 16);
			panel.add(lblNewLabel);
			
			JButton btnIndicar = new JButton("Indicar vacuna");
			
			btnIndicar.setBackground(Color.WHITE);
			btnIndicar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(cmbVacunas.getSelectedItem().toString().equalsIgnoreCase("<Seleccione>")) {
						JOptionPane.showMessageDialog(null, "Seleccione una vacuna válida", "Ha ocurrido un error",JOptionPane.ERROR_MESSAGE);
					}else{
						Vacuna vacuna = ClinicaSONS.getInstance().buscarVacunaPorNombre(cmbVacunas.getSelectedItem().toString());
						miPac.insertarVacuna(vacuna);
						llenarTabla();
					}
				}
			});
			btnIndicar.setFont(new Font("Sylfaen", Font.PLAIN, 14));
			btnIndicar.setBounds(312, 32, 143, 25);
			panel.add(btnIndicar);
			
			if(miPac != null && miCons == null) {
				btnIndicar.setVisible(false);
				cmbVacunas.setVisible(false);
				lblNewLabel.setVisible(false);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnCancelar = new JButton("Cerrar");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnCancelar.setBackground(Color.WHITE);
				btnCancelar.setFont(new Font("Sylfaen", Font.PLAIN, 14));
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
		llenarTabla();
	}
	
	public void llenarTabla() {
		model.setRowCount(0);
		row = new Object[model.getColumnCount()];
		for (Vacuna aux : miPac.getMisVacunas()) {
			row[1] = aux.getCodigo();
			row[2] = aux.getNombre();
			row[3] = aux.getLaboratorio();
			row[4] = df.format(new Date());
			model.addRow(row);
		}
	}
}
