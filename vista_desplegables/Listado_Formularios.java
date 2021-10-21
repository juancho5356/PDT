package Vista.vista_desplegables;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import Controlador.DAO_Formulario;
import Controlador.DAO_Usuario;
import Modelo.Formulario;
import Modelo.Tipo;
import Modelo.Usuario;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class Listado_Formularios extends JPanel implements MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel panel;
	public static String Listado_Formularios;
	private JTextField textFiltro;
	private JTable table;
	private JTextField textIdEliminar;

	
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
		scrollPane.setBounds(30, 152, 920, 419);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setSurrendersFocusOnKeystroke(true);
		table.addMouseListener(this);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		
		JButton btnActualizar = new JButton("Actualizar listado");
		btnActualizar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnActualizar.setBounds(30, 594, 152, 21);
		panel.add(btnActualizar);
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lista();
			}
		});
		
		JLabel lblNewLabel = new JLabel("Ingrese un ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(682, 594, 88, 21);
		panel.add(lblNewLabel);
		
		textIdEliminar = new JTextField();
		textIdEliminar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textIdEliminar.setColumns(10);
		textIdEliminar.setBounds(780, 595, 53, 19);
		panel.add(textIdEliminar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEliminar.setBounds(843, 594, 107, 21);
		panel.add(btnEliminar);
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idST = textIdEliminar.getText();
				int id = Integer.parseInt(idST);
				
				DAO_Formulario.delete(id);
				
				if(DAO_Formulario.delete(id)) {
					int respuesta = JOptionPane.showConfirmDialog(null, "¿Seguro que desea eliminar el formulario seleccionado?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if(respuesta == JOptionPane.YES_OPTION) {
						JOptionPane.showMessageDialog(null, "Formulario eliminado correctamente");
						limpiar();
						lista();
					}
					
				}else {
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
		comboBoxFiltro.addItem("");
		comboBoxFiltro.addItem("Nombre variable");
		comboBoxFiltro.addItem("Fecha");
		comboBoxFiltro.addItem("Ubicacion");
		
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
					Object[] columns = {"ID","Fecha","Ubicación","Nombre variable", "Método medición", "Usuario"};
					
					model.setColumnIdentifiers(columns);
					
					Object [] fila = new Object[columns.length];
					table.setModel(model);
					
					List<Formulario> formularios = new LinkedList<>();
					
					if(comboBoxFiltro.getSelectedItem().equals("Nombre variable")) {
						if(!textFiltro.getText().isEmpty()) {
							String nombreVariable = textFiltro.getText();
							
							formularios = DAO_Formulario.findFormularioNombreVariable(nombreVariable);
							
							for(Formulario f: formularios) {
								fila[0] = f.getId();
								fila[1] = f.getFecha();
								fila[2] = f.getUbicacion();
								fila[3] = f.getNombreVariable();
								fila[4] = f.getMetodoMedicion();
								if(f.getAdministrador() != null) {
									fila[5] = f.getAdministrador().getNombreUsuario();
								}
								if(f.getInvestigador() != null) {
									fila[5] = f.getInvestigador().getNombreUsuario();
								}
								if(f.getAficionado() != null) {
									fila[5] = f.getAficionado().getNombreUsuario();
								}
								else {
									JOptionPane.showMessageDialog(null, "No existen resultados compatibles");
								}
							}
						}
						else {
							JOptionPane.showMessageDialog(null, "Por favor, escriba un Nombre");
						}
					}
					else if(comboBoxFiltro.getSelectedItem().equals("Fecha")) {
						if(!textFiltro.getText().isEmpty()) {
							String fecha = textFiltro.getText();
							
							formularios = DAO_Formulario.findFormularioFecha(fecha);
							if(formularios.size() != 0) {
								
								for(Formulario f: formularios) {
									fila[0] = f.getId();
									fila[1] = f.getFecha();
									fila[2] = f.getUbicacion();
									fila[3] = f.getNombreVariable();
									fila[4] = f.getMetodoMedicion();
									if(f.getAdministrador() != null) {
										fila[5] = f.getAdministrador().getNombreUsuario();
									}
									if(f.getInvestigador() != null) {
										fila[5] = f.getInvestigador().getNombreUsuario();
									}
									if(f.getAficionado() != null) {
										fila[5] = f.getAficionado().getNombreUsuario();
									}
									else {
										JOptionPane.showMessageDialog(null, "No existen resultados compatibles");
									}
								}
							}
							else {
								JOptionPane.showMessageDialog(null, "No existen resultados compatibles");
							}
						}
						else {
							JOptionPane.showMessageDialog(null, "Por favor, escriba un Apellido");
						}
					}
					else if(comboBoxFiltro.getSelectedItem().equals("Ubicacion")) {
						if(!textFiltro.getText().isEmpty()) {
							String ubicacion = textFiltro.getText();
							
							formularios = DAO_Formulario.findFormularioUbicacion(ubicacion);
							if(formularios.size() != 0) {
								for(Formulario f: formularios) {
									fila[0] = f.getId();
									fila[1] = f.getFecha();
									fila[2] = f.getUbicacion();
									fila[3] = f.getNombreVariable();
									fila[4] = f.getMetodoMedicion();
									if(f.getAdministrador() != null) {
										fila[5] = f.getAdministrador().getNombreUsuario();
									}
									if(f.getInvestigador() != null) {
										fila[5] = f.getInvestigador().getNombreUsuario();
									}
									if(f.getAficionado() != null) {
										fila[5] = f.getAficionado().getNombreUsuario();
									}
							}
							}
							else {
								JOptionPane.showMessageDialog(null, "No existen resultados compatibles");
							}
						}
						else {
							JOptionPane.showMessageDialog(null, "Por favor, escriba un Nombre de Usuario");
						}
					}
				}
			}
		});
		
		lista();
	}
		
		public void lista() {
			
			DefaultTableModel modelo= new DefaultTableModel();
			
			Object[] columns = {"ID","Fecha","Ubicación","Nombre variable", "Método medición", "Usuario"};
			
			modelo.setColumnIdentifiers(columns);
			table.setModel(modelo);
			
			List<Formulario> formularios = new LinkedList<>();
			Object[] fila = new Object[columns.length];
			formularios = DAO_Formulario.findAll();
			
			for(Formulario f: formularios) {
				fila[0] = f.getId();
				fila[1] = f.getFecha();
				fila[2] = f.getUbicacion();
				fila[3] = f.getNombreVariable();
				fila[4] = f.getMetodoMedicion();
				if(f.getAdministrador() != null) {
					fila[5] = f.getAdministrador().getNombreUsuario();
				}
				if(f.getInvestigador() != null) {
					fila[5] = f.getInvestigador().getNombreUsuario();
				}
				if(f.getAficionado() != null) {
					fila[5] = f.getAficionado().getNombreUsuario();
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
