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
import javax.swing.ScrollPaneConstants;

public class RegCita extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
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
	private Cita miCita = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegCita dialog = new RegCita(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegCita(Cita cita) {
		this.miCita = cita;
		setBounds(100, 100, 560, 445);
		df = new SimpleDateFormat("dd/MM/yyyy");
		setLocationRelativeTo(null);
		setResizable(false);
		if(miCita == null) {
			setTitle("Programar Cita");
		}else {
			setTitle("Modificar Cita");
		}
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
			JLabel lblNewLabel_2 = new JLabel("Nombre:");
			lblNewLabel_2.setBounds(291, 25, 56, 16);
			lblNewLabel_2.setFont(new Font("Sylfaen", Font.PLAIN, 14));
			contentPanel.add(lblNewLabel_2);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Tel\u00E9fono:");
			lblNewLabel_3.setBounds(14, 71, 56, 16);
			lblNewLabel_3.setFont(new Font("Sylfaen", Font.PLAIN, 14));
			contentPanel.add(lblNewLabel_3);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("Fecha:");
			lblNewLabel_4.setBounds(291, 71, 56, 16);
			lblNewLabel_4.setFont(new Font("Sylfaen", Font.PLAIN, 14));
			contentPanel.add(lblNewLabel_4);
		}
		{
			JLabel lblNewLabel_5 = new JLabel("Hora:");
			lblNewLabel_5.setBounds(14, 117, 56, 16);
			lblNewLabel_5.setFont(new Font("Sylfaen", Font.PLAIN, 14));
			contentPanel.add(lblNewLabel_5);
		}
		{
			txtNombre = new JTextField();
			txtNombre.setFont(new Font("Sylfaen", Font.PLAIN, 14));
			txtNombre.setBounds(348, 22, 180, 22);
			contentPanel.add(txtNombre);
			txtNombre.setColumns(10);
		}
		{
			txtTel = new JTextField();
			txtTel.setFont(new Font("Sylfaen", Font.PLAIN, 14));
			txtTel.setColumns(10);
			txtTel.setBounds(77, 68, 180, 22);
			contentPanel.add(txtTel);
		}
		{
			JLabel lblDoctor = new JLabel("Doctor:");
			lblDoctor.setBounds(291, 117, 56, 16);
			lblDoctor.setFont(new Font("Sylfaen", Font.PLAIN, 14));
			contentPanel.add(lblDoctor);
		}

		cmbDoctor = new JComboBox<>();
		cmbDoctor.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>"}));
		for (Persona aux : ClinicaSONS.getInstance().getMisPersonas()) {
			if(aux instanceof Doctor) {
				cmbDoctor.addItem(aux);
			}
		}
		cmbDoctor.addItem(ClinicaSONS.getInstance().listaDoctores());
		cmbDoctor.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(!cmbDoctor.getSelectedItem().toString().equalsIgnoreCase("<Seleccione>")) {
					cmbHorario.setEnabled(true);
					panelTab.setBorder(new TitledBorder(null, "Citas del Dr."+cmbDoctor.getSelectedItem(), TitledBorder.LEADING, TitledBorder.TOP, null, null));
					llenarTabla(cmbDoctor.getSelectedItem().toString());
				}else {
					panelTab.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
					cmbHorario.setEnabled(false);
					llenarTabla("");
				}
			}
		});

		cmbDoctor.setBounds(348, 114, 180, 22);
		cmbDoctor.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		contentPanel.add(cmbDoctor);

		txtCod = new JTextField();
		txtCod.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		txtCod.setEditable(false);
		txtCod.setText("C-"+ClinicaSONS.codCita);
		txtCod.setColumns(10);
		txtCod.setBounds(77, 22, 180, 22);
		contentPanel.add(txtCod);

		dtFecha = new JDateChooser();
		dtFecha.setDateFormatString("d/MM/yyyy");
		dtFecha.setBounds(348, 68, 180, 22);
		((JTextField) this.dtFecha.getDateEditor()).setEditable(false);
		dtFecha.setMinSelectableDate(new Date());
		contentPanel.add(dtFecha);

		cmbHorario = new JComboBox();
		cmbHorario.setEditable(true);
		cmbHorario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		cmbHorario.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		cmbHorario.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "8:00", "9:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00"}));
		cmbHorario.setBounds(77, 114, 180, 22);
		contentPanel.add(cmbHorario);

		panelTab = new JPanel();
		panelTab.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelTab.setBounds(14, 160, 514, 188);
		contentPanel.add(panelTab);
		panelTab.setLayout(new BorderLayout(0, 0));
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			panelTab.add(scrollPane, BorderLayout.CENTER);

			table = new JTable();

			model = new DefaultTableModel();
			String[] headers = {"Código", "Nombre", "Teléfono", "Fecha","Horario"};
			model.setColumnIdentifiers(headers);
			table.setModel(model);
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			TableColumnModel columnModel = table.getColumnModel();
			columnModel.getColumn(0).setPreferredWidth(70);
			columnModel.getColumn(1).setPreferredWidth(140);
			columnModel.getColumn(2).setPreferredWidth(140);
			columnModel.getColumn(3).setPreferredWidth(80);
			columnModel.getColumn(4).setPreferredWidth(80);

			scrollPane.setViewportView(table);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnRegistrar = new JButton("Registrar");
				if(miCita != null) {
					btnRegistrar.setText("Modificar");
				}
				btnRegistrar.setFont(new Font("Sylfaen", Font.PLAIN, 14));
				btnRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Cita cita = null;
						String codigo = txtCod.getText();
						String nombre = txtNombre.getText();
						String telefono = txtTel.getText();
						String horario = cmbHorario.getSelectedItem().toString();
						String doctor = cmbDoctor.getSelectedItem().toString();
						Doctor doc = ClinicaSONS.getInstance().buscarDoctorPorNombre(doctor);
						Date fecha = dtFecha.getDate();

						if(miCita == null) {
						
							if ((codigo.trim().isEmpty()||nombre.trim().isEmpty()||telefono.trim().isEmpty()||horario.trim().isEmpty()||fecha.toString().trim().isEmpty())) {
								JOptionPane.showMessageDialog(null, "Favor completar los espacios vacios", "Ha occurrido un error", JOptionPane.ERROR_MESSAGE);
							}else {
								for (Cita aux : doc.getMisCitas()) {
									if(aux.getFechaReservada() == fecha && aux.getHorario().equalsIgnoreCase(horario)) {
										JOptionPane.showMessageDialog(null, "El doctor "+doc.getNombre()+" tiene una cita programada en esta misma fecha y a esta misma hora","Ha ocurrido un error",JOptionPane.ERROR_MESSAGE);
									}else {
										cita = new Cita(codigo, nombre, telefono, doc, fecha, horario);
										ClinicaSONS.getInstance().insertarCita(cita);
										doc.agregarCita(cita);
										JOptionPane.showMessageDialog(null, "Cita registrada satisfactoriamente", "Operación exitosa", JOptionPane.PLAIN_MESSAGE);
										clean();
									}
								}
							}
						}else {
							if ((codigo.trim().isEmpty()||nombre.trim().isEmpty()||telefono.trim().isEmpty()||horario.trim().isEmpty()||fecha.toString().trim().isEmpty())) {
								JOptionPane.showMessageDialog(null, "Favor completar los espacios vacios", "Ha occurrido un error", JOptionPane.ERROR_MESSAGE);
							}else {
								for (Cita aux : doc.getMisCitas()) {
									if(aux.getFechaReservada() == fecha && aux.getHorario().equalsIgnoreCase(horario)) {
										JOptionPane.showMessageDialog(null, "El doctor "+doc.getNombre()+" tiene una cita programada en esta misma fecha y a esta misma hora","Ha ocurrido un error",JOptionPane.ERROR_MESSAGE);
									}else {
										miCita.setCodigo(codigo);
										miCita.setNombrePersona(nombre);
										miCita.setTelefonoPersona(telefono);
										miCita.setFechaReservada(fecha);
										miCita.setHorario(horario);
										miCita.setDoctor(doc);
										ClinicaSONS.getInstance().modificarCita(miCita);
										dispose();
										JOptionPane.showMessageDialog(null, "La modificación fue realizada con éxito", "Operación exitosa", JOptionPane.INFORMATION_MESSAGE);
										ListarCitas.llenarTabla("Todos");
									}
								}
							}
						}

					}


				});
				btnRegistrar.setActionCommand("OK");
				buttonPane.add(btnRegistrar);
				getRootPane().setDefaultButton(btnRegistrar);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.setFont(new Font("Sylfaen", Font.PLAIN, 14));
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
		loadCita();
	}



	public static void llenarTabla(String nomDoctor){
		model.setRowCount(0);
		row = new Object[model.getColumnCount()];
		SimpleDateFormat fechaSimple = new SimpleDateFormat("dd-MM-yyyy");

		if(nomDoctor != "") {
			for (Cita aux : ClinicaSONS.getInstance().getMisCitas()) {
				if(aux.getDoctor().getNombre().equalsIgnoreCase(nomDoctor)) {
					row[0] = aux.getCodigo();
					row[1] = aux.getNombrePersona();
					row[2] = aux.getTelefonoPersona();
					row[3] = fechaSimple.format(aux.getFechaReservada());
					row[4] = aux.getHorario();
					model.addRow(row);
				}
			}
		}else {
			model.setRowCount(0);
		}
	}

	private void loadCita() {
		if(miCita != null) {
			txtCod.setText(miCita.getCodigo());
			txtNombre.setText(miCita.getNombrePersona());
			txtTel.setText(miCita.getTelefonoPersona());
			dtFecha.setDate(miCita.getFechaReservada());
			cmbDoctor.setSelectedItem(miCita.getDoctor().getNombre());
			cmbHorario.setSelectedItem(miCita.getHorario());
			llenarTabla(miCita.getDoctor().getNombre());
		}
	}
	private void clean() {
		txtCod.setText("C-"+ClinicaSONS.codCita);
		txtNombre.setText("");
		txtTel.setText("");
		dtFecha.setDate(null);
		cmbDoctor.setSelectedItem("<Seleccione>");
		cmbHorario.setSelectedItem("<Seleccione>");
	}



}
