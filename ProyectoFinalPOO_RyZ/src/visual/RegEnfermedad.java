package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import logico.Administrador;
import logico.ClinicaSONS;
import logico.Enfermedad;
import logico.Vacuna;

import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegEnfermedad extends JDialog{

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtDescripcion;
	private JTextField txtSin1;
	private JTextField txtSin7;
	private JTextField txtSin4;
	private JTextField txtSin8;
	private JTextField txtSin5;
	private JTextField txtSin2;
	private JTextField txtSin9;
	private JTextField txtSin6;
	private JTextField txtSin3;
	private JButton btnRegistrar;
	private JButton btnCancelar;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	private JButton btnVerLista;
	private Enfermedad miEnfermedad = null;
	private Administrador miAdmin = null;
	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		try {
			RegEnfermedad dialog = new RegEnfermedad(null, null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * @param selected 
	 */
	public RegEnfermedad(Enfermedad enfermedad, Administrador admin) {
		miAdmin = admin;
		miEnfermedad = enfermedad;
		setResizable(false);
		if (miEnfermedad==null) {
			setTitle("Registro de Enfermedad");
		}else {
			setTitle("Modificación de Enfermedad");
		}
		
		setBounds(100, 100, 550, 410);
		setLocationRelativeTo(null);
		setResizable(false);
		initComponents();

	}

	private void initComponents() {
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblCdigo = new JLabel("C\u00F3digo:");
		lblCdigo.setBounds(17, 23, 56, 16);
		lblCdigo.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		contentPanel.add(lblCdigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		txtCodigo.setEditable(false);
		txtCodigo.setBounds(66, 20, 190, 22);
		txtCodigo.setText("E-"+ClinicaSONS.codEnf);
		contentPanel.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nombre: ");
		lblNewLabel.setBounds(273, 23, 56, 16);
		lblNewLabel.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		contentPanel.add(lblNewLabel);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		txtNombre.setColumns(10);
		txtNombre.setBounds(329, 20, 190, 22);
		contentPanel.add(txtNombre);
		
		JLabel lblNewLabel_1 = new JLabel("Descripci\u00F3n:");
		lblNewLabel_1.setBounds(17, 62, 94, 16);
		lblNewLabel_1.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		contentPanel.add(lblNewLabel_1);
		
		txtDescripcion = new JTextField();
		
		txtDescripcion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent tab) {
				txtSin1.setText("");
			}
			@Override
			public void keyReleased(KeyEvent e) {
				txtSin1.setText("");
			}
		});
		
		
		

			
			
		txtDescripcion.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		txtDescripcion.setBounds(17, 80, 502, 99);
		contentPanel.add(txtDescripcion);
		txtDescripcion.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("S\u00EDntomas:");
		lblNewLabel_2.setBounds(17, 192, 94, 16);
		lblNewLabel_2.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		contentPanel.add(lblNewLabel_2);
		
		
		
		
		
		
		
		txtSin1 = new JTextField();
	
	
		txtSin1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				txtSin2.setEditable(true);
				if(txtSin1.getText().trim().isEmpty()) {
		
					txtSin2.setEditable(false);
				}
			}
		});
	/*	if(txtSin1.getText().trim().isEmpty()) {
			txtSin2.setText("N/A");
			txtSin3.setText("N/A");
			txtSin4.setText("N/A");
			txtSin5.setText("N/A");
			txtSin6.setText("N/A");
			txtSin7.setText("N/A");
			txtSin8.setText("N/A");					
			txtSin2.setEditable(false);
		}*/

		txtSin1.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		txtSin1.setBounds(33, 215, 135, 22);
		contentPanel.add(txtSin1);
		txtSin1.setColumns(10);
		
		txtSin7 = new JTextField();
		txtSin7.setText("N/A");
		
		txtSin7.setEditable(false);
		txtSin7.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				txtSin8.setEditable(true);
				if(txtSin7.getText().trim().isEmpty()) {
					txtSin7.setText("-");
					txtSin8.setEditable(false);
				}
			}
		});
		txtSin7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtSin7.setText("");
			}
		});
		txtSin7.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		txtSin7.setColumns(10);
		txtSin7.setBounds(384, 215, 135, 22);
		contentPanel.add(txtSin7);
		
		txtSin4 = new JTextField();
		txtSin4.setText("N/A");
		
		txtSin4.setEditable(false);
		txtSin4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
			
				txtSin5.setEditable(true);
				if(txtSin4.getText().trim().isEmpty()) {
					txtSin4.setText("-");
					txtSin5.setEditable(false);
				}
			}
		});
		txtSin4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtSin4.setText("");
			}
		});
		txtSin4.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		txtSin4.setColumns(10);
		txtSin4.setBounds(208, 215, 135, 22);
		contentPanel.add(txtSin4);
		
		txtSin8 = new JTextField();
		txtSin8.setText("N/A");
		
		txtSin8.setEditable(false);
		txtSin8.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				txtSin9.setEditable(true);
				if(txtSin8.getText().trim().isEmpty()) {
					txtSin8.setText("-");
					txtSin9.setEditable(false);
					txtSin9.setText("-");
				}
			}
		});
		txtSin8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtSin8.setText("");
			}
		});
		txtSin8.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		txtSin8.setColumns(10);
		txtSin8.setBounds(384, 250, 135, 22);
		contentPanel.add(txtSin8);
		
		txtSin5 = new JTextField();
		txtSin5.setText("N/A");
	
		txtSin5.setEditable(false);
		txtSin5.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				txtSin6.setEditable(true);
				if(txtSin5.getText().trim().isEmpty()) {
					txtSin5.setText("-");
					txtSin6.setEditable(false);
				}
			}
		});
		txtSin5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtSin5.setText("");
			}
		});
		txtSin5.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		txtSin5.setColumns(10);
		txtSin5.setBounds(208, 250, 135, 22);
		contentPanel.add(txtSin5);
		
		txtSin2 = new JTextField();
		
		txtSin2.setText("N/A");
	
		txtSin2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtSin2.setText("");
			}
		});
		txtSin2.setEditable(false);
		txtSin2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
			
				txtSin3.setEditable(true);
				if(txtSin2.getText().trim().isEmpty()) {
					txtSin2.setText("-");
					txtSin3.setEditable(false);
				}
			}
		});
		txtSin2.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		txtSin2.setColumns(10);
		txtSin2.setBounds(33, 250, 135, 22);
		contentPanel.add(txtSin2);
		
		txtSin9 = new JTextField();
		txtSin9.setText("N/A");
		
			
		txtSin9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtSin9.setText("");
			}
		});
		
		
		txtSin9.setEditable(false);
		txtSin9.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		txtSin9.setColumns(10);
		txtSin9.setBounds(384, 285, 135, 22);
		contentPanel.add(txtSin9);
		
		txtSin6 = new JTextField();
		txtSin6.setText("N/A");
	
		txtSin6.setEditable(false);
		txtSin6.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				txtSin7.setEditable(true);
				if(txtSin6.getText().trim().isEmpty()) {
					txtSin6.setText("-");
					txtSin7.setEditable(false);
				}
			}
		});
		
		txtSin6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtSin6.setText("");
			}
		});
		txtSin6.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		txtSin6.setColumns(10);
		txtSin6.setBounds(208, 285, 135, 22);
		contentPanel.add(txtSin6);
		
		txtSin3 = new JTextField();
		txtSin3.setText("N/A");
		
		txtSin3.setEditable(false);
		txtSin3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				txtSin4.setEditable(true);
				if(txtSin3.getText().trim().isEmpty()) {
					txtSin3.setText("-");
					txtSin4.setEditable(false);
				}
			}
		});
		txtSin3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtSin3.setText("");
			}
		});
		txtSin3.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		txtSin3.setColumns(10);
		txtSin3.setBounds(33, 285, 135, 22);
		contentPanel.add(txtSin3);
		
		JLabel lblNewLabel_3 = new JLabel("1.");
		lblNewLabel_3.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(17, 218, 56, 16);
		contentPanel.add(lblNewLabel_3);
		
		label = new JLabel("2.");
		label.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		label.setBounds(17, 253, 56, 16);
		contentPanel.add(label);
		
		label_1 = new JLabel("3.");
		label_1.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		label_1.setBounds(17, 288, 56, 16);
		contentPanel.add(label_1);
		
		label_2 = new JLabel("4.");
		label_2.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		label_2.setBounds(192, 218, 18, 16);
		contentPanel.add(label_2);
		
		label_3 = new JLabel("5.");
		label_3.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		label_3.setBounds(192, 253, 56, 16);
		contentPanel.add(label_3);
		
		label_4 = new JLabel("6.");
		label_4.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		label_4.setBounds(192, 288, 56, 16);
		contentPanel.add(label_4);
		
		label_5 = new JLabel("7.");
		label_5.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		label_5.setBounds(366, 218, 18, 16);
		contentPanel.add(label_5);
		
		label_6 = new JLabel("8.");
		label_6.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		label_6.setBounds(366, 253, 56, 16);
		contentPanel.add(label_6);
		
		label_7 = new JLabel("9.");
		label_7.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		label_7.setBounds(366, 288, 56, 16);
		contentPanel.add(label_7);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnRegistrar = new JButton("Registrar");
				btnRegistrar.setFont(new Font("Sylfaen", Font.PLAIN, 14));
				btnRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (miEnfermedad==null) {
							
						Enfermedad enfermedad = null;
						String codigo = txtCodigo.getText();
						String nombre = txtNombre.getText();
						String descripcion = txtDescripcion.getText();
						String sin1 =txtSin1.getText();
						String sin2 =txtSin2.getText();
						String sin3 =txtSin3.getText();
						String sin4 =txtSin4.getText();
						String sin5 =txtSin5.getText();
						String sin6 =txtSin6.getText();
						String sin7 =txtSin7.getText();
						String sin8 =txtSin8.getText();
						String sin9 =txtSin9.getText();
						ArrayList <String> sintomas = new ArrayList<>(Arrays.asList(sin1,sin2,sin3,sin4,sin5,sin6,sin7,sin8,sin9));
						
						
					if (codigo.trim().isEmpty()||nombre.trim().isEmpty()||descripcion.trim().isEmpty()||(sin1.trim().isEmpty()&&sin2.trim().isEmpty()
						&&sin3.trim().isEmpty()&&sin4.trim().isEmpty()&&sin5.trim().isEmpty()&&sin6.trim().isEmpty()&&sin7.trim().isEmpty()
						&&sin8.trim().isEmpty()&&sin9.trim().isEmpty())) {
						
						JOptionPane.showMessageDialog(null, "CAMPO OBLIGATORIO VACIO", "Ha occurrido un error", JOptionPane.ERROR_MESSAGE);
						
						}else {
							enfermedad = new Enfermedad(codigo, nombre, descripcion);
							ClinicaSONS.getInstance().insertarEnfermedad(enfermedad);
							JOptionPane.showMessageDialog(null, "Enfermedad registrada satisfactoriamente", "Operación exitosa", JOptionPane.PLAIN_MESSAGE);
							for (int i = 0; i < sintomas.size(); i++) {
								if(!sintomas.get(i).trim().isEmpty()) {
									enfermedad.insertarSintomas(sintomas.get(i));
								}
							}
							
							
							for (String aux : enfermedad.getSintomas()) {
								System.out.println(aux);
							}
							clean();
						}		
			}else {
				miEnfermedad.setCodigo(txtCodigo.getText());
				miEnfermedad.setDescripcion(txtDescripcion.getText());
				miEnfermedad.setNombre(txtNombre.getText());
				miEnfermedad.setSintomas((ArrayList<String>) Arrays.asList(txtSin1.getText(),txtSin2.getText(),txtSin3.getText(),txtSin3.getText(),txtSin4.getText(),txtSin5.getText(),txtSin6.getText(),txtSin7.getText(),txtSin8.getText(),txtSin9.getText()));
				
				ClinicaSONS.getInstance().modificarEnfermedad(miEnfermedad);
				dispose();
				ListarEnfermedad.llenarTabla();
			
			}
					
					}

				});
				
				btnVerLista = new JButton("Ver lista");
				btnVerLista.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ListarEnfermedad list = new ListarEnfermedad();
						list.setModal(true);
						list.setVisible(true);
					}
				});
				btnVerLista.setFont(new Font("Sylfaen", Font.PLAIN, 14));
				btnVerLista.setActionCommand("OK");
				buttonPane.add(btnVerLista);
				btnRegistrar.setActionCommand("OK");
				buttonPane.add(btnRegistrar);
				getRootPane().setDefaultButton(btnRegistrar);
			}
			{
				btnCancelar = new JButton("Cancelar");
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
		cargarEnfermedades(); 
	}
	
	
	private void cargarEnfermedades() {
		if (miEnfermedad!=null) {
			txtCodigo.setText(miEnfermedad.getCodigo());
			txtDescripcion.setText(miEnfermedad.getDescripcion());
			txtNombre.setText(miEnfermedad.getNombre());
		
			if (!miEnfermedad.getSintomas().get(0).isEmpty()) {
				txtSin1.setText(miEnfermedad.getSintomas().get(0));
				}
			if (!miEnfermedad.getSintomas().get(1).isEmpty()) {
				txtSin2.setText(miEnfermedad.getSintomas().get(1));

				}
			if (!miEnfermedad.getSintomas().get(2).isEmpty()) {
				txtSin3.setText(miEnfermedad.getSintomas().get(2));
				}
			if (!miEnfermedad.getSintomas().get(3).isEmpty()) {
				txtSin4.setText(miEnfermedad.getSintomas().get(3));
				}
			if (!miEnfermedad.getSintomas().get(4).isEmpty()) {
				txtSin5.setText(miEnfermedad.getSintomas().get(4));
				}
			
			if (!miEnfermedad.getSintomas().get(5).isEmpty()) {
				txtSin6.setText(miEnfermedad.getSintomas().get(5));
				}
			if (!miEnfermedad.getSintomas().get(6).isEmpty()) {
				txtSin7.setText(miEnfermedad.getSintomas().get(6));
				}
			if (!miEnfermedad.getSintomas().get(7).isEmpty()) {
				txtSin8.setText(miEnfermedad.getSintomas().get(7));
				}
			if (!miEnfermedad.getSintomas().get(8).isEmpty()) {
				txtSin9.setText(miEnfermedad.getSintomas().get(8));
				}
						
		}
	}
	
	private void clean() {
		txtCodigo.setText("E-"+ClinicaSONS.codEnf);
		txtDescripcion.setText("");
		txtNombre.setText("");
		txtSin1.setText("N/A");
		txtSin2.setText("N/A");
		txtSin3.setText("N/A");
		txtSin4.setText("N/A");
		txtSin5.setText("N/A");
		txtSin6.setText("N/A");
		txtSin7.setText("N/A");
		txtSin8.setText("N/A");
		txtSin9.setText("N/A");
		txtSin2.setEditable(false);
		txtSin3.setEditable(false);
		txtSin4.setEditable(false);
		txtSin5.setEditable(false);
		txtSin6.setEditable(false);
		txtSin7.setEditable(false);
		txtSin8.setEditable(false);
		txtSin9.setEditable(false);
	}
}

