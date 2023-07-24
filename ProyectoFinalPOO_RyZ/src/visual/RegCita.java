package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.JComboBox;
import javax.crypto.Cipher;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import com.toedter.calendar.JDayChooser;

import logico.Cita;
import logico.ClinicaSONS;
import logico.Doctor;
import logico.Persona;
import logico.Vacuna;

import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class RegCita extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtCedula;
	private JTextField txtTel;
	private JTextField txtCod;
	private SimpleDateFormat df = null;
	private JComboBox cmbDoctor;
	
	private JComboBox cmbHorario;
	private JDateChooser dtFecha;
	private JPanel panelTab;
	private JTable table;
	private static DefaultTableModel model;
	private static Object[] row = null;
	private Doctor[] doctores = {};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegCita dialog = new RegCita();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegCita() {
		setBounds(100, 100, 560, 490);
		df = new SimpleDateFormat("dd/MM/yyyy");
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Programar Cita");
		initComponents();
	}

	private void initComponents() {
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("C\u00F3digo:");
			lblNewLabel.setBounds(14, 25, 56, 16);
			lblNewLabel.setFont(new Font("Sylfaen", Font.PLAIN, 14));
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("C\u00E9dula:");
			lblNewLabel_1.setBounds(14, 73, 56, 16);
			lblNewLabel_1.setFont(new Font("Sylfaen", Font.PLAIN, 14));
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Nombre:");
			lblNewLabel_2.setBounds(14, 121, 56, 16);
			lblNewLabel_2.setFont(new Font("Sylfaen", Font.PLAIN, 14));
			contentPanel.add(lblNewLabel_2);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Tel\u00E9fono:");
			lblNewLabel_3.setBounds(285, 73, 56, 16);
			lblNewLabel_3.setFont(new Font("Sylfaen", Font.PLAIN, 14));
			contentPanel.add(lblNewLabel_3);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("Fecha:");
			lblNewLabel_4.setBounds(285, 121, 56, 16);
			lblNewLabel_4.setFont(new Font("Sylfaen", Font.PLAIN, 14));
			contentPanel.add(lblNewLabel_4);
		}
		{
			JLabel lblNewLabel_5 = new JLabel("Hora:");
			lblNewLabel_5.setBounds(14, 168, 56, 16);
			lblNewLabel_5.setFont(new Font("Sylfaen", Font.PLAIN, 14));
			contentPanel.add(lblNewLabel_5);
		}
		{
			txtNombre = new JTextField();
			txtNombre.setBounds(71, 118, 180, 22);
			contentPanel.add(txtNombre);
			txtNombre.setColumns(10);
		}
		{
			txtCedula = new JTextField();
			txtCedula.setColumns(10);
			txtCedula.setBounds(71, 70, 180, 22);
			contentPanel.add(txtCedula);
		}
		{
			txtTel = new JTextField();
			txtTel.setColumns(10);
			txtTel.setBounds(348, 70, 180, 22);
			contentPanel.add(txtTel);
		}
		{
			JLabel lblDoctor = new JLabel("Doctor:");
			lblDoctor.setBounds(285, 168, 56, 16);
			lblDoctor.setFont(new Font("Sylfaen", Font.PLAIN, 14));
			contentPanel.add(lblDoctor);
		}
		
		cmbDoctor = new JComboBox<>();
		cmbDoctor.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>"}));
		cmbDoctor.addItem(ClinicaSONS.getInstance().listaDoctores());
	 	cmbDoctor.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(!cmbDoctor.getSelectedItem().toString().equalsIgnoreCase("<Seleccione>")) {
					panelTab.setBorder(new TitledBorder(null, "Citas del Dr."+cmbDoctor.getSelectedItem(), TitledBorder.LEADING, TitledBorder.TOP, null, null));
				}else {
					panelTab.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				}
			}
		});
	
		cmbDoctor.setBounds(348, 166, 180, 22);
		cmbDoctor.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		contentPanel.add(cmbDoctor);
		
		txtCod = new JTextField();
		txtCod.setEditable(false);
		txtCod.setText("C-"+ClinicaSONS.codCita);
		txtCod.setColumns(10);
		txtCod.setBounds(71, 22, 180, 22);
		contentPanel.add(txtCod);
		
		dtFecha = new JDateChooser();
		dtFecha.setDateFormatString("d/MM/yyyy");
		dtFecha.setBounds(348, 118, 180, 22);
		
		contentPanel.add(dtFecha);
		
		cmbHorario = new JComboBox();
		cmbHorario.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		cmbHorario.setModel(new DefaultComboBoxModel(new String[] {"<Seleccionar>", "8:00", "9:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00"}));
		cmbHorario.setBounds(71, 166, 180, 22);
		contentPanel.add(cmbHorario);
		
		panelTab = new JPanel();
		panelTab.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelTab.setBounds(14, 209, 514, 188);
		contentPanel.add(panelTab);
		panelTab.setLayout(new BorderLayout(0, 0));
		{
			JScrollPane scrollPane = new JScrollPane();
			panelTab.add(scrollPane, BorderLayout.CENTER);
			
			table = new JTable();
			
			model = new DefaultTableModel();
			String[] headers = {"Código", "Nombre", "Teléfono", "Fecha","Horario", "Doctor"};
			model.setColumnIdentifiers(headers);
			table.setModel(model);
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			TableColumnModel columnModel = table.getColumnModel();
			columnModel.getColumn(0).setPreferredWidth(70);
			columnModel.getColumn(1).setPreferredWidth(130);
			columnModel.getColumn(2).setPreferredWidth(80);
			columnModel.getColumn(3).setPreferredWidth(80);
			columnModel.getColumn(4).setPreferredWidth(80);
			columnModel.getColumn(5).setPreferredWidth(150);
			
			scrollPane.setViewportView(table);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnRegistrar = new JButton("Registrar");
				btnRegistrar.setFont(new Font("Sylfaen", Font.PLAIN, 14));
				btnRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Cita cita = null;
						String codigo = txtCod.getText();
						String cedula = txtCedula.getText();
						String nombre = txtNombre.getText();
						String telefono = txtTel.getText();
						String horario = cmbHorario.getSelectedItem().toString();
					
						Date fecha = dtFecha.getDate();
												
					//	String doctor = cmbDoctor.getClass();
					//	Class<? extends Object> doctor = cmbDoctor.getSelectedItem().getClass();
												
						
						if ((codigo.trim().isEmpty()||cedula.trim().isEmpty()||nombre.trim().isEmpty()||telefono.trim().isEmpty()||horario.trim().isEmpty()||fecha.toString().trim().isEmpty())) {
							JOptionPane.showMessageDialog(null, "CAMPO OBLIGATORIO VACIO", "Ha occurrido un error", JOptionPane.ERROR_MESSAGE);
						}
						else {
							cita = new Cita(codigo, nombre, telefono, null, fecha, horario);
									 
							ClinicaSONS.getInstance().insertarCita(cita);
							JOptionPane.showMessageDialog(null, "Cita registrada satisfactoriamente", "Operación exitosa", JOptionPane.PLAIN_MESSAGE);
							clean();
							llenarTabla();
						}
								
					}

					
				});
				btnRegistrar.setActionCommand("OK");
				buttonPane.add(btnRegistrar);
				getRootPane().setDefaultButton(btnRegistrar);
			}
			{
				JButton cancelButton = new JButton("Cancel");
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
		
	}
	
	

	public static void llenarTabla(){
		model.setRowCount(0);
		row = new Object[model.getColumnCount()];
		SimpleDateFormat fechaSimple = new SimpleDateFormat("dd-MM-yyyy");

		for (Cita aux : ClinicaSONS.getInstance().getMisCitas()) {
			row[0] = aux.getCodigo();
			row[1] = aux.getNombrePersona();
			row[2] = aux.getTelefonoPersona();
			row[3] = fechaSimple.format(aux.getFechaReservada());
			row[4] = aux.getHorario();
			row[5] = aux.getDoctor();
			model.addRow(row);
		}
	}
	
	private void clean() {
			
		txtCod.setText("C-"+ClinicaSONS.codCita);
		txtCedula.setText("");
		txtNombre.setText("");
		txtTel.setText("");
		dtFecha.setDate(null);
		
		
		
		
	}
	

	
}
