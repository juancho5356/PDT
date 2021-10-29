package vista_desplegables;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import com.exception.ServiciosException;
import com.servicios.FormularioCasilla_BeanRemote;
import com.servicios.Formulario_BeanRemote;

import model.Casilla;
import model.Formulario;
import model.FormularioCasilla;
import vista_desplegables.Listado_Casillas;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import java.awt.SystemColor;

public class Listado_Formularios extends JPanel implements MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel panel;
	public static String Listado_Formularios;
	private JTextField textFiltro;
	private JTable table;
	private JTable table2;
	JTextField textIdEliminar;
	private JTextField textNombre;
	private JTextField textComentarios;
	private JTextField textFecha;
	private JTextField textUsuario;

	
	/**
	 * Create the panel.
	 */
	public Listado_Formularios() {
		Listado_Formularios = "Listado_Formularios";
		
		setBounds(new Rectangle(0, 0, 985, 658));
		setLayout(new CardLayout(0, 0));
		
		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		add(panel, "name_25541786307800");
		panel.setLayout(null);
		
		JLabel lblListaDeFormularios = new JLabel("Lista de Formularios");
		lblListaDeFormularios.setFont(new Font("Baskerville Old Face", Font.ITALIC, 27));
		lblListaDeFormularios.setBounds(10, 10, 275, 31);
		panel.add(lblListaDeFormularios);
		
		JLabel lblNewLabel_1 = new JLabel("Filtrar por:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 68, 81, 21);
		panel.add(lblNewLabel_1);
		
		textFiltro = new JTextField();
		textFiltro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFiltro.setColumns(10);
		textFiltro.setBounds(30, 110, 376, 22);
		panel.add(textFiltro);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 152, 578, 454);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setSurrendersFocusOnKeystroke(true);
		table.addMouseListener(this);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		
		lista();
		
		JButton btnActualizar = new JButton("Actualizar listado");
		btnActualizar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnActualizar.setBounds(30, 627, 152, 21);
		panel.add(btnActualizar);
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lista();
			}
		});
		
		JLabel lblNewLabel = new JLabel("Ingrese un ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(340, 627, 88, 21);
		panel.add(lblNewLabel);
		
		textIdEliminar = new JTextField();
		textIdEliminar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textIdEliminar.setColumns(10);
		textIdEliminar.setBounds(438, 628, 53, 19);
		panel.add(textIdEliminar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEliminar.setBounds(501, 627, 107, 21);
		panel.add(btnEliminar);
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = 0;
				
				if(!(textIdEliminar.getText().isEmpty())) {
					String idST = textIdEliminar.getText();
					id = Integer.parseInt(idST);
				}
				else {
					JOptionPane.showMessageDialog(null, "Por favor, seleccione un formulario de la lista para eliminar");
				}
				
				Formulario formulario = null;
				
				try {
					String dato = "PDT_EJB/Formulario_Bean!com.servicios.Formulario_BeanRemote";
					Formulario_BeanRemote form = (Formulario_BeanRemote) InitialContext.doLookup(dato);
					
					formulario = form.findFormularioId(id);
					
					if(formulario != null) {
						int respuesta = JOptionPane.showConfirmDialog(null, "¿Seguro que desea eliminar el formulario seleccionado?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
						if(respuesta == JOptionPane.YES_OPTION) {
							form.delete(formulario);
							JOptionPane.showMessageDialog(null, "Formulario eliminado correctamente");
							limpiar();
							lista();
						}
					}
					
				}catch(NamingException | ServiciosException ex) {
					ex.getMessage();
					JOptionPane.showMessageDialog(null, "No es posible eliminar este formulario");
				}
			}
		});
		
		JButton btnLimpiarFiltros = new JButton("Limpiar filtros");
		btnLimpiarFiltros.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLimpiarFiltros.setBounds(469, 63, 139, 31);
		panel.add(btnLimpiarFiltros);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBuscar.setBounds(469, 106, 139, 31);
		panel.add(btnBuscar);
		
		JComboBox<String> comboBoxFiltro = new JComboBox<String>();
		comboBoxFiltro.setBounds(101, 70, 305, 21);
		panel.add(comboBoxFiltro);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(240, 248, 255));
		panel_1.setBounds(618, 0, 367, 658);
		panel.add(panel_1);
		
		JLabel lblInformacinDeFormulario = new JLabel("Informaci\u00F3n de Formulario");
		lblInformacinDeFormulario.setHorizontalAlignment(SwingConstants.CENTER);
		lblInformacinDeFormulario.setFont(new Font("Baskerville Old Face", Font.ITALIC, 27));
		lblInformacinDeFormulario.setBounds(0, 60, 338, 31);
		panel_1.add(lblInformacinDeFormulario);
		
		textNombre = new JTextField();
		textNombre.setEditable(false);
		textNombre.setColumns(10);
		textNombre.setBackground(SystemColor.inactiveCaptionBorder);
		textNombre.setBounds(143, 118, 214, 25);
		panel_1.add(textNombre);
		
		textComentarios = new JTextField();
		textComentarios.setEditable(false);
		textComentarios.setColumns(10);
		textComentarios.setBackground(SystemColor.inactiveCaptionBorder);
		textComentarios.setBounds(143, 171, 214, 25);
		panel_1.add(textComentarios);
		
		textFecha = new JTextField();
		textFecha.setEditable(false);
		textFecha.setColumns(10);
		textFecha.setBackground(SystemColor.inactiveCaptionBorder);
		textFecha.setBounds(143, 226, 214, 25);
		panel_1.add(textFecha);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setFont(new Font("Baskerville Old Face", Font.PLAIN, 15));
		lblFecha.setBounds(10, 226, 170, 25);
		panel_1.add(lblFecha);
		
		JLabel lblComentarios = new JLabel("Comentarios");
		lblComentarios.setFont(new Font("Baskerville Old Face", Font.PLAIN, 15));
		lblComentarios.setBounds(10, 171, 170, 25);
		panel_1.add(lblComentarios);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Baskerville Old Face", Font.PLAIN, 15));
		lblNombre.setBounds(10, 118, 170, 25);
		panel_1.add(lblNombre);
		
		textUsuario = new JTextField();
		textUsuario.setEditable(false);
		textUsuario.setColumns(10);
		textUsuario.setBackground(SystemColor.inactiveCaptionBorder);
		textUsuario.setBounds(143, 278, 214, 25);
		panel_1.add(textUsuario);
		
		JLabel lblUsuarioCreador = new JLabel("Usuario creador");
		lblUsuarioCreador.setFont(new Font("Baskerville Old Face", Font.PLAIN, 15));
		lblUsuarioCreador.setBounds(10, 278, 170, 25);
		panel_1.add(lblUsuarioCreador);
		
		JLabel lblNewLabel_1_1 = new JLabel("*");
		lblNewLabel_1_1.setBounds(0, 118, 15, 13);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("*");
		lblNewLabel_2.setBounds(0, 171, 15, 13);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("*");
		lblNewLabel_3.setBounds(0, 226, 15, 13);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("*");
		lblNewLabel_4.setBounds(0, 278, 15, 13);
		panel_1.add(lblNewLabel_4);
		
		JButton btnModificarFormulario = new JButton("Modificar formulario");
		btnModificarFormulario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnModificarFormulario.setEnabled(false);
		btnModificarFormulario.setBackground(new Color(173, 216, 230));
		btnModificarFormulario.setBounds(28, 617, 318, 31);
		panel_1.add(btnModificarFormulario);
		
		JLabel lblCasillas = new JLabel("Casillas");
		lblCasillas.setFont(new Font("Baskerville Old Face", Font.PLAIN, 15));
		lblCasillas.setBounds(10, 324, 170, 25);
		panel_1.add(lblCasillas);
		
		JLabel lblNewLabel_4_1 = new JLabel("*");
		lblNewLabel_4_1.setBounds(0, 324, 15, 13);
		panel_1.add(lblNewLabel_4_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(13, 359, 344, 248);
		panel_1.add(scrollPane_1);
		
		comboBoxFiltro.addItem("");
		comboBoxFiltro.addItem("Nombre");
		comboBoxFiltro.addItem("Fecha");
		
		table2 = new JTable();
		table2.setSurrendersFocusOnKeystroke(true);
		table2.addMouseListener(this);
		table2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_1.setViewportView(table2);
		
		
		JButton btnNewButton = new JButton("Asignar casillas");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(190, 324, 167, 23);
		panel_1.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Listado_Casillas.main(null);
			}
		});
	
		
		table.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				limpiar();
				
				int filaSeleccionada;
				
				filaSeleccionada = table.getSelectedRow();
				if(filaSeleccionada == -1) {
					
				}else {
					textNombre.setText(table.getValueAt(filaSeleccionada, 2).toString());
					textComentarios.setText(table.getValueAt(filaSeleccionada, 3).toString());
					textFecha.setText(table.getValueAt(filaSeleccionada, 1).toString());
					textUsuario.setText(table.getValueAt(filaSeleccionada, 4).toString());
					textIdEliminar.setText(table.getValueAt(filaSeleccionada, 0).toString());

					DefaultTableModel modelo= new DefaultTableModel();
				
					Object[] columns = {"Nombre","Descripción","Unidad de medida"};
				
					modelo.setColumnIdentifiers(columns);
					table2.setModel(modelo);
				
					List<FormularioCasilla> casillas = new LinkedList<>();
					Object[] fila = new Object[columns.length];
					try {
						String dato = "PDT_EJB/FormularioCasilla_Bean!com.servicios.FormularioCasilla_BeanRemote";
						FormularioCasilla_BeanRemote formCasi = (FormularioCasilla_BeanRemote) InitialContext.doLookup(dato);
						String idST = table.getValueAt(filaSeleccionada, 0).toString();
						long id = Long.parseLong(idST);
						
						casillas = formCasi.findCasillas(id);
						
						if(casillas != null) {
							for(FormularioCasilla c: casillas) {
								fila[0] = c.getCasilla().getNombre();
								fila[1] = c.getCasilla().getDescripcion();
								fila[2] = c.getCasilla().getUnidadesDeMedida();
								modelo.addRow(fila);
							}
						}
						
					}catch(NamingException | ServiciosException ex) {
						ex.getMessage();
					}
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
		
		btnLimpiarFiltros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				textFiltro.setText("");
				comboBoxFiltro.setSelectedItem("");
				lista();
			}
		});
		
		btnBuscar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if(textFiltro.isVisible() == true || comboBoxFiltro.isVisible() == true) {
					
					DefaultTableModel model = new DefaultTableModel() {
						/**
						 * 
						 */
						private static final long serialVersionUID = 1L;

						public boolean isCellEditable(int row, int column) {
							return false;
						}
					};
					Object[] columns = {"ID","Fecha","Nombre","Comentarios","Usuario"};
					
					model.setColumnIdentifiers(columns);
					
					Object [] fila = new Object[columns.length];
					table.setModel(model);
					
					List<Formulario> formularios = new LinkedList<>();
					
					if(comboBoxFiltro.getSelectedItem().equals("Nombre")) {
						if(!textFiltro.getText().isEmpty()) {
							String nombre = textFiltro.getText();
							
							try {
								String dato = "PDT_EJB/Formulario_Bean!com.servicios.Formulario_BeanRemote";
								Formulario_BeanRemote form = (Formulario_BeanRemote) InitialContext.doLookup(dato);
								
								formularios = form.findFormularioNombre(nombre);
								
							}catch(NamingException | ServiciosException ex) {
								ex.getMessage();
							}
							
							if(formularios.size() != 0) {
							
								for(Formulario f: formularios) {
									fila[0] = String.valueOf(f.getIdFormulario());
									fila[1] = String.valueOf(f.getFechaHora());
									fila[2] = f.getNombre();
									fila[3] = f.getComentarios();
									if(f.getAdministradore() != null) {
										fila[4] = f.getAdministradore().getUsuario();
									}
									if(f.getInvestigadore() != null) {
										fila[4] = f.getInvestigadore().getUsuario();
									}
									if(f.getAficionado() != null) {
										fila[4] = f.getAficionado().getUsuario();
									}
									model.addRow(fila);
								}
							}
								else {
									JOptionPane.showMessageDialog(null, "No existen resultados compatibles");
								}
						}
						else {
							JOptionPane.showMessageDialog(null, "Por favor, escriba un Nombre");
						}
					}
					else if(comboBoxFiltro.getSelectedItem().equals("Fecha")) {
						if(!textFiltro.getText().isEmpty()) {
							String fecha = textFiltro.getText();
							
							try {
								String dato = "PDT_EJB/Formulario_Bean!com.servicios.Formulario_BeanRemote";
								Formulario_BeanRemote form = (Formulario_BeanRemote) InitialContext.doLookup(dato);
								
								formularios = form.findFormularioFecha(fecha);
								
							}catch(NamingException | ServiciosException ex) {
								ex.getMessage();
							}
							
							if(formularios.size() != 0) {
								
								for(Formulario f: formularios) {
									fila[0] = String.valueOf(f.getIdFormulario());
									fila[1] = String.valueOf(f.getFechaHora());
									fila[2] = f.getNombre();
									fila[3] = f.getComentarios();
									if(f.getAdministradore() != null) {
										fila[4] = f.getAdministradore().getUsuario();
									}
									if(f.getInvestigadore() != null) {
										fila[4] = f.getInvestigadore().getUsuario();
									}
									if(f.getAficionado() != null) {
										fila[4] = f.getAficionado().getUsuario();
									}
									model.addRow(fila);
								}
							}
							else {
								JOptionPane.showMessageDialog(null, "No existen resultados compatibles");
							}
						}
						else {
							JOptionPane.showMessageDialog(null, "Por favor, escriba una fecha");
						}
					}
		
		lista();
				}
			}
		});
	}
		
		public void lista() {
			
			DefaultTableModel modelo= new DefaultTableModel();
			
			Object[] columns = {"ID","Fecha","Nombre","Comentarios","Usuario"};
			
			modelo.setColumnIdentifiers(columns);
			table.setModel(modelo);
			
			List<Formulario> formularios = new LinkedList<>();
			Object[] fila = new Object[columns.length];
			try {
				String dato = "PDT_EJB/Formulario_Bean!com.servicios.Formulario_BeanRemote";
				Formulario_BeanRemote form = (Formulario_BeanRemote) InitialContext.doLookup(dato);
				
				formularios = form.findAll();
			
			}catch(NamingException | ServiciosException ex) {
				ex.getMessage();
			}
			
			for(Formulario f: formularios) {
				fila[0] = String.valueOf(f.getIdFormulario());
				fila[1] = String.valueOf(f.getFechaHora());
				fila[2] = f.getNombre();
				fila[3] = f.getComentarios();
				if(f.getAdministradore() != null) {
					fila[4] = f.getAdministradore().getUsuario().getNombreUsuario();
				}
				if(f.getInvestigadore() != null) {
					fila[4] = f.getInvestigadore().getUsuario().getNombreUsuario();
				}
				if(f.getAficionado() != null) {
					fila[4] = f.getAficionado().getUsuario().getNombreUsuario();
				}
				modelo.addRow(fila);
			}
		}


	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == table) {
			mouseClickedTable(e);
		}
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	
	public void mouseClickedTable(MouseEvent e) {
		limpiar();
		
		int filaSeleccionada;
		
		
		filaSeleccionada = table.getSelectedRow();
		if(filaSeleccionada == -1) {
			
		}else {
			textIdEliminar.setText(table.getValueAt(filaSeleccionada, 0).toString());
		}
	}
	
	
	public void limpiar() {
		textIdEliminar.setText("");
	}
}
