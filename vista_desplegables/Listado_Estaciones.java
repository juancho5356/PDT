package Vista.vista_desplegables;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import Controlador.*;
import Modelo.*;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ItemEvent;
import java.awt.SystemColor;
import javax.swing.SwingConstants;

public class Listado_Estaciones extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel panel;

	private JLabel lblNewLabel;
	public static String Listado_Estaciones;
	private JScrollPane scrollPane;
	private JSeparator separator;
	private JTable table;
	private JLabel lblFiltro;
	private JRadioButton rdbtnNombre;
	private JRadioButton rdbtnDepartamento;
	private JTextField textField;
	private JButton btnIr;
	private ButtonGroup bgRadios;
	private JComboBox<Object> comboBox_Departamento;
	private JButton btnLimpiar;
	private JPanel panel_1;
	private JLabel lblInformacinDeEstacin;
	private JTextField textNombre;
	private JTextField textLatitud;
	private JTextField textLongitud;
	private JLabel lblLongitud;
	private JLabel lblLatitud;
	private JLabel lblNombre;
	private JLabel lblHumedadRelativa;
	private JTextField textHumedad;
	private JTextField textCalidad;
	private JLabel lblCalidadDeAire;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblSeleccioneUnRegistro;
	private JLabel lblInvestigadorCreador;
	private JTextField textInvestigador;
	private JLabel lblDepartamento;
	private JLabel lblNewLabel_6;
	private JTextField textDepartamento;
	private JLabel lblNewLabel_7;
	
	/**
	 * Create the panel.
	 */
	public Listado_Estaciones() {
		Listado_Estaciones = "Listado_Estaciones";

		
		setBounds(new Rectangle(0, 0, 985, 658));
		setLayout(new CardLayout(0, 0));
		
		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		add(panel, "name_25541786307800");
		panel.setLayout(null);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBackground(SystemColor.menu);
		btnLimpiar.setBounds(533, 63, 94, 25);
		panel.add(btnLimpiar);
		btnLimpiar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				comboBox_Departamento.setSelectedItem("");
			}
			
		});
		
		lblNewLabel = new JLabel("Listado de Estaciones");
		lblNewLabel.setFont(new Font("Baskerville Old Face", Font.ITALIC, 27));
		lblNewLabel.setBounds(10, 10, 275, 31);
		panel.add(lblNewLabel);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 169, 607, 468);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				limpiar();
				
				int filaSeleccionada;
				
				filaSeleccionada = table.getSelectedRow();
				if(filaSeleccionada == -1) {
					
				}else {
					textNombre.setText(table.getValueAt(filaSeleccionada, 0).toString());
					textLatitud.setText(table.getValueAt(filaSeleccionada, 1).toString());
					textLongitud.setText(table.getValueAt(filaSeleccionada, 2).toString());
					textCalidad.setText(table.getValueAt(filaSeleccionada, 3).toString());
					textHumedad.setText(table.getValueAt(filaSeleccionada, 4).toString());
					textDepartamento.setText(table.getValueAt(filaSeleccionada, 5).toString());
					textInvestigador.setText(table.getValueAt(filaSeleccionada, 6).toString());
				}

			}

			@Override
			public void mousePressed(MouseEvent e) {	
			}

			@Override
			public void mouseReleased(MouseEvent e) {				
			}

			@Override
			public void mouseEntered(MouseEvent e) {				
			}

			@Override
			public void mouseExited(MouseEvent e) {				
			}
			
		});
		
		separator = new JSeparator();
		separator.setBounds(10, 38, 235, 2);
		panel.add(separator);
		
		lblFiltro = new JLabel("Filtrar por:");
		lblFiltro.setFont(new Font("Baskerville Old Face", Font.PLAIN, 16));
		lblFiltro.setBounds(20, 63, 170, 25);
		panel.add(lblFiltro);
		
		rdbtnNombre = new JRadioButton("Nombre de Estaci\u00F3n");
		rdbtnNombre.setBackground(new Color(255, 255, 255));
		rdbtnNombre.setFont(new Font("Baskerville Old Face", Font.PLAIN, 16));
		rdbtnNombre.setBounds(126, 65, 197, 21);
		panel.add(rdbtnNombre);
		rdbtnNombre.addItemListener(new ItemListener() {
			
			public void itemStateChanged(ItemEvent e) {
				comboBox_Departamento.setVisible(false);
				textField.setVisible(true);
			}
			
		});
		
		rdbtnDepartamento = new JRadioButton("Departamento");
		rdbtnDepartamento.setBackground(new Color(255, 255, 255));
		rdbtnDepartamento.setFont(new Font("Baskerville Old Face", Font.PLAIN, 16));
		rdbtnDepartamento.setBounds(325, 65, 197, 21);
		panel.add(rdbtnDepartamento);
		rdbtnDepartamento.addItemListener(new ItemListener() {
			
			public void itemStateChanged(ItemEvent e) {
				comboBox_Departamento.setVisible(true);
				textField.setVisible(false);
			}
			
		});
		
		bgRadios = new ButtonGroup();
		bgRadios.add(rdbtnDepartamento);
		bgRadios.add(rdbtnNombre);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(20, 109, 443, 25);
		panel.add(textField);
		textField.setVisible(false);
		
		btnIr = new JButton("Ir");
		btnIr.setBackground(new Color(176, 224, 230));
		btnIr.setBounds(533, 109, 94, 25);
		panel.add(btnIr);
		
		comboBox_Departamento = new JComboBox<Object>();
		comboBox_Departamento.setBackground(SystemColor.menu);
		comboBox_Departamento.setBounds(20, 109, 443, 25);
		comboBox_Departamento.addItem("");
		panel.add(comboBox_Departamento);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(240, 248, 255));
		panel_1.setLayout(null);
		panel_1.setBounds(647, 0, 338, 658);
		panel.add(panel_1);
		
		lblInformacinDeEstacin = new JLabel("Informaci\u00F3n de Estaci\u00F3n");
		lblInformacinDeEstacin.setHorizontalAlignment(SwingConstants.CENTER);
		lblInformacinDeEstacin.setFont(new Font("Baskerville Old Face", Font.ITALIC, 27));
		lblInformacinDeEstacin.setBounds(0, 60, 338, 31);
		panel_1.add(lblInformacinDeEstacin);
		
		textNombre = new JTextField();
		textNombre.setBackground(SystemColor.inactiveCaptionBorder);
		textNombre.setEditable(false);
		textNombre.setColumns(10);
		textNombre.setBounds(143, 118, 185, 25);
		panel_1.add(textNombre);
		
		textLatitud = new JTextField();
		textLatitud.setBackground(SystemColor.inactiveCaptionBorder);
		textLatitud.setEditable(false);
		textLatitud.setColumns(10);
		textLatitud.setBounds(143, 171, 185, 25);
		panel_1.add(textLatitud);
		
		textLongitud = new JTextField();
		textLongitud.setBackground(SystemColor.inactiveCaptionBorder);
		textLongitud.setEditable(false);
		textLongitud.setColumns(10);
		textLongitud.setBounds(143, 226, 185, 25);
		panel_1.add(textLongitud);
		
		lblLongitud = new JLabel("Longitud");
		lblLongitud.setFont(new Font("Baskerville Old Face", Font.PLAIN, 15));
		lblLongitud.setBounds(10, 226, 170, 25);
		panel_1.add(lblLongitud);
		
		lblLatitud = new JLabel("Latitud");
		lblLatitud.setFont(new Font("Baskerville Old Face", Font.PLAIN, 15));
		lblLatitud.setBounds(10, 171, 170, 25);
		panel_1.add(lblLatitud);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Baskerville Old Face", Font.PLAIN, 15));
		lblNombre.setBounds(10, 118, 170, 25);
		panel_1.add(lblNombre);
		
		lblHumedadRelativa = new JLabel("Humedad Relativa");
		lblHumedadRelativa.setFont(new Font("Baskerville Old Face", Font.PLAIN, 15));
		lblHumedadRelativa.setBounds(10, 333, 170, 25);
		panel_1.add(lblHumedadRelativa);
		
		textHumedad = new JTextField();
		textHumedad.setBackground(SystemColor.inactiveCaptionBorder);
		textHumedad.setEditable(false);
		textHumedad.setColumns(10);
		textHumedad.setBounds(143, 333, 185, 25);
		panel_1.add(textHumedad);
		
		textCalidad = new JTextField();
		textCalidad.setBackground(SystemColor.inactiveCaptionBorder);
		textCalidad.setEditable(false);
		textCalidad.setColumns(10);
		textCalidad.setBounds(143, 278, 185, 25);
		panel_1.add(textCalidad);
		
		lblCalidadDeAire = new JLabel("Calidad de Aire");
		lblCalidadDeAire.setFont(new Font("Baskerville Old Face", Font.PLAIN, 15));
		lblCalidadDeAire.setBounds(10, 278, 170, 25);
		panel_1.add(lblCalidadDeAire);
		
		lblNewLabel_1 = new JLabel("*");
		lblNewLabel_1.setBounds(0, 118, 15, 13);
		panel_1.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("*");
		lblNewLabel_2.setBounds(0, 171, 15, 13);
		panel_1.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("*");
		lblNewLabel_3.setBounds(0, 226, 15, 13);
		panel_1.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("*");
		lblNewLabel_4.setBounds(0, 278, 15, 13);
		panel_1.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("*");
		lblNewLabel_5.setBounds(0, 333, 15, 13);
		panel_1.add(lblNewLabel_5);
		
		lblInvestigadorCreador = new JLabel("Investigador creador de la Estaci\u00F3n: ");
		lblInvestigadorCreador.setFont(new Font("Baskerville Old Face", Font.PLAIN, 15));
		lblInvestigadorCreador.setBounds(10, 444, 289, 25);
		panel_1.add(lblInvestigadorCreador);
		
		textInvestigador = new JTextField();
		textInvestigador.setEditable(false);
		textInvestigador.setFont(new Font("Baskerville Old Face", Font.PLAIN, 14));
		textInvestigador.setBackground(SystemColor.menu);
		textInvestigador.setColumns(10);
		textInvestigador.setBounds(10, 472, 211, 25);
		panel_1.add(textInvestigador);
		
		lblDepartamento = new JLabel("Departamento");
		lblDepartamento.setFont(new Font("Baskerville Old Face", Font.PLAIN, 15));
		lblDepartamento.setBounds(10, 387, 170, 25);
		panel_1.add(lblDepartamento);
		
		lblNewLabel_6 = new JLabel("*");
		lblNewLabel_6.setBounds(0, 387, 15, 13);
		panel_1.add(lblNewLabel_6);
		
		textDepartamento = new JTextField();
		textDepartamento.setBackground(SystemColor.inactiveCaptionBorder);
		textDepartamento.setEditable(false);
		textDepartamento.setColumns(10);
		textDepartamento.setBounds(143, 387, 185, 25);
		panel_1.add(textDepartamento);
		
		lblNewLabel_7 = new JLabel("*");
		lblNewLabel_7.setBounds(0, 444, 15, 13);
		panel_1.add(lblNewLabel_7);
		
		lblSeleccioneUnRegistro = new JLabel("Seleccione un registro para poder ver sus datos con mayor claridad");
		lblSeleccioneUnRegistro.setFont(new Font("Arial", Font.PLAIN, 10));
		lblSeleccioneUnRegistro.setBounds(153, 144, 474, 25);
		panel.add(lblSeleccioneUnRegistro);
		lblSeleccioneUnRegistro.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSeleccioneUnRegistro.setForeground(Color.DARK_GRAY);
		lblSeleccioneUnRegistro.setVisible(false);
		
		LinkedList<Departamento> departamentos = DAO_Departamento.allDepartamentos();
		
		for(Departamento d: departamentos) {
			comboBox_Departamento.addItem(d.getNombre());
		}
		
		comboBox_Departamento.setVisible(false);
		
		btnIr.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if(textField.isVisible() == true || comboBox_Departamento.isVisible() == true) {
					DefaultTableModel model = new DefaultTableModel() {
						/**
						 * 
						 */
						private static final long serialVersionUID = 1L;

						public boolean isCellEditable(int row, int column) {
							return false;
						}
					};
					limpiar();

					Object[] columns = {"Nombre", "Latitud", "Longitud", "Calidad de Aire", "Humedad Relativa", "Departamento", "Investigador"};
					
					model.setColumnIdentifiers(columns);
					
					Object [] fila = new Object[columns.length];
					table.setModel(model);
					
					LinkedList<Estacion_Medicion> estaciones = new LinkedList<>();
					
					if(rdbtnDepartamento.isSelected()) {
						if(!(comboBox_Departamento.getSelectedItem().equals(""))) {
							String departamento = (String) comboBox_Departamento.getSelectedItem();
						
							estaciones = DAO_Estacion_Medicion.xDepartamento(departamento);
							if(estaciones.size() != 0) {
								lblSeleccioneUnRegistro.setVisible(true);
								listar(estaciones, fila,  model);
							}
							else {
								JOptionPane.showMessageDialog(null, "No existen resultados compatibles");
								lblSeleccioneUnRegistro.setVisible(false);

							}
							
						}
						else {
							JOptionPane.showMessageDialog(null, "Por favor ingrese un Departamento para poder buscar");
						}
					}
					else if(rdbtnNombre.isSelected()) {
						if(!(textField.getText().isEmpty())) {
							String nombre = textField.getText();
						
							estaciones = DAO_Estacion_Medicion.xNombre(nombre);
							if(estaciones.size() != 0) {
								lblSeleccioneUnRegistro.setVisible(true);
								listar(estaciones, fila,  model);
							}
							else {
								JOptionPane.showMessageDialog(null, "No existen resultados compatibles");
								lblSeleccioneUnRegistro.setVisible(false);

							}
						}
						else {
							JOptionPane.showMessageDialog(null, "Por favor ingrese un Nombre de Estación para poder buscar");
						}
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Por favor, eliga un filtro para comenzar");
				}
			}
			
		});
	}
	public void limpiar() {
		textNombre.setText("");
		textLatitud.setText("");
		textLongitud.setText("");
		textCalidad.setText("");
		textHumedad.setText("");
		textDepartamento.setText("");
		textInvestigador.setText("");
	}
	public void listar(LinkedList<Estacion_Medicion> estaciones, Object [] fila, DefaultTableModel model) {
		for (Estacion_Medicion e: estaciones){
			
			String n = e.getNombre();
			String la = e.getLatitud();
			String lo = e.getLongitud();
			String ca = e.getCalidad_aire();
			String hu = e.getHumedad_relativa();
			
			Departamento departamento = e.getDepartamento();
			String d = departamento.getNombre();
			
			Investigador investigador = e.getInvestigador();
			String i = investigador.getNombre() + " " + investigador.getApellido();
			
			fila[0] = n;
			fila[1] = la;
			fila[2] = lo;
			fila[3] = ca;
			fila[4] = hu;
			fila[5] = d;
			fila[6] = i;

			model.addRow(fila); 
			
		}
	}
}
