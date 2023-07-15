package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
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
	private JComboBox comboBox;
	private JDateChooser dateChooser;
	private JPanel panelTab;
	private JTable table;

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
		
		cmbDoctor = new JComboBox();
		cmbDoctor.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(!cmbDoctor.getSelectedItem().toString().equalsIgnoreCase("<Seleccionar>")) {
					panelTab.setBorder(new TitledBorder(null, "Citas del Dr."+cmbDoctor.getSelectedItem(), TitledBorder.LEADING, TitledBorder.TOP, null, null));
				}else {
					panelTab.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				}
			}
		});
		cmbDoctor.setModel(new DefaultComboBoxModel(new String[] {"<Seleccionar>", "Pepe"}));
		cmbDoctor.setBounds(348, 166, 180, 22);
		cmbDoctor.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		contentPanel.add(cmbDoctor);
		
		txtCod = new JTextField();
		txtCod.setEditable(false);
		txtCod.setColumns(10);
		txtCod.setBounds(71, 22, 180, 22);
		contentPanel.add(txtCod);
		
		dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("d/MM/yyyy");
		dateChooser.setBounds(348, 118, 180, 22);
		
		contentPanel.add(dateChooser);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"<Seleccionar>", "8:00", "9:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00"}));
		comboBox.setBounds(71, 166, 180, 22);
		contentPanel.add(comboBox);
		
		panelTab = new JPanel();
		panelTab.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelTab.setBounds(14, 209, 514, 188);
		contentPanel.add(panelTab);
		panelTab.setLayout(new BorderLayout(0, 0));
		{
			JScrollPane scrollPane = new JScrollPane();
			panelTab.add(scrollPane, BorderLayout.CENTER);
			
			table = new JTable();
			scrollPane.setViewportView(table);
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
}
