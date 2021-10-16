package vista_desplegables;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import databaseManager.*;
import modelo.*;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.SystemColor;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;

public class Listado_Usuarios extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel panel;
	public static String Listado_Usuario;
	private JTable table;
	private JSeparator separator;
	private JLabel lblFiltro;
	private JButton btnLimpiar_1;
	private JButton btnIr;
	private JTextField textFiltro;
	private JComboBox<Object> comboBox;
	private JComboBox<Object> comboBox_Rol;
	private JLabel lblInformacionUsuario;
	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textCorreo;
	private JLabel lblCorreo;
	private JLabel lblApellido;
	private JLabel lblNombre;
	private JComboBox<Object> comboBox_Rol2;
	private JLabel lblRolDeUsuario;
	private JTextField textTelefono;
	private JTextField textDomicilio;
	private JLabel lblDomicilio;
	private JLabel lblCedula;
	private JLabel lblTelefono;
	private JComboBox<Object> comboBox_Ciudad;
	private JLabel lblCiudad;
	private JTextField textOcupacion;
	private JLabel lblOcupacion;
	private JButton btnActualizarUsuario;
	private JButton btnEliminarUsuario;
	private JLabel lblSeleccione;

	public boolean nombre;
	public boolean apellido;
	public boolean nombreUsuario;
	public boolean correo;
	
	public boolean ocupacion;
	
	public boolean cedula;
	public boolean domicilio;
	public boolean telefono;
	
	public boolean ciudad;
	public boolean rol;
	private JLabel lblCampoCorreo;
	private JLabel lblCampoCedula;
	private JLabel lblCampoTelefono;
	private JLabel lblMaximo;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lbl1;
	private JLabel lbl2;
	private JLabel lbl4;
	private JLabel lbl3;
	private JTextField textCedula;
	
	/**
	 * Create the panel.
	 */
	public Listado_Usuarios() {
		Listado_Usuario = "Listado_Usuario";

		
		setBounds(new Rectangle(0, 0, 985, 658));
		setLayout(new CardLayout(0, 0));
		
		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		add(panel, "name_25541786307800");
		panel.setLayout(null);
		
		JLabel lblListaDeUsuarios = new JLabel("Listado de Usuarios");
		lblListaDeUsuarios.setFont(new Font("Baskerville Old Face", Font.ITALIC, 27));
		lblListaDeUsuarios.setBounds(10, 10, 275, 31);
		panel.add(lblListaDeUsuarios);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 169, 607, 468);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setSurrendersFocusOnKeystroke(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		listarTodo();
		
		table.addMouseListener(new MouseListener() {

			public void mouseClicked(MouseEvent e) {
				limpiar();
				
				int filaSeleccionada;
				
				filaSeleccionada = table.getSelectedRow();
				if(filaSeleccionada == -1) {
					elsee();
				}else {
					textNombre.setText(table.getValueAt(filaSeleccionada, 0).toString());
					textApellido.setText(table.getValueAt(filaSeleccionada, 1).toString());
					textCorreo.setText(table.getValueAt(filaSeleccionada, 2).toString());
					
					String tipo_usuario = table.getValueAt(filaSeleccionada, 4).toString();
					String correo = table.getValueAt(filaSeleccionada, 2).toString();
					
					Usuario user = DAO_Usuario.findUsuarioMail(correo);
					
					Investigador inv = DAO_Investigador.findInvestigador(user.getNombreUsuario(), user.getContrasenia());
					Administrador adm = DAO_Administrador.findAdministrador(user.getNombreUsuario(), user.getContrasenia());
					Aficionado afi = DAO_Aficionado.findAficionado(user.getNombreUsuario(), user.getContrasenia());

					if(inv != null) {
						inve_admin();
						
						
						textCedula.setText(String.valueOf(inv.getDocumento()));
						comboBox_Ciudad.setSelectedItem(inv.getCiudad().getNombre());
						comboBox_Rol2.setSelectedItem("INVESTIGADOR");
						textDomicilio.setText(inv.getDomicilio());
						textTelefono.setText(String.valueOf(inv.getTelefono()));
						
						comboBox_Rol.addItemListener(new ItemListener() {

							public void itemStateChanged(ItemEvent e) {
								// TODO Auto-generated method stub
							}
							
						});

					}else if(adm != null) {
						inve_admin();

						textCedula.setText(String.valueOf(adm.getDocumento()));
						comboBox_Ciudad.setSelectedItem(adm.getCiudad().getNombre());
						comboBox_Rol2.setSelectedItem("ADMINISTRADOR");
						textDomicilio.setText(adm.getDomicilio());
						textTelefono.setText(String.valueOf(adm.getTelefono()));
						
					}else if(afi != null) {
						aficionado();
												
						textOcupacion.setText(afi.getOcupacion());
						comboBox_Rol2.setSelectedItem("AFICIONADO");

					}
					
					btnEliminarUsuario.addMouseListener(new MouseListener() {

						@Override
						public void mouseClicked(MouseEvent e) {
							int respuesta = JOptionPane.showConfirmDialog(null, "¿ Realmente quieres eliminar a este usuario ? Una vez hecho, no hay vuelta atrás", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
							if(respuesta == JOptionPane.YES_OPTION) {
								if(tipo_usuario.equals("ADMINISTRADOR")) {
									if(DAO_Administrador.delete(adm)) {
										if(DAO_Usuario.delete(user)) {
											JOptionPane.showMessageDialog(null, "Usuario Administrador eliminado del sistema");
											limpiar();
											listarTodo();
										}
									}else {
										JOptionPane.showMessageDialog(null, "No es posible eliminar este usuario");
									}
								}
								else if(tipo_usuario.equals("INVESTIGADOR")) {
									if(DAO_Investigador.delete(inv)) {
										if(DAO_Usuario.delete(user)) {
											JOptionPane.showMessageDialog(null, "Usuario Investigador eliminado del sistema");
											limpiar();
											listarTodo();

										}
										
									}else {
										JOptionPane.showMessageDialog(null, "No es posible eliminar este usuario");
									}
								}
								else if(tipo_usuario.equals("AFICIONADO")) {
									if(DAO_Aficionado.delete(afi)) {
										if(DAO_Usuario.delete(user)) {
											JOptionPane.showMessageDialog(null, "Usuario Aficionado eliminado del sistema");
											limpiar();
											listarTodo();

										}
									}else {
										JOptionPane.showMessageDialog(null, "No es posible eliminar este usuario");
									}
								}
							}
						}

						@Override
						public void mousePressed(MouseEvent e) {
							// TODO Auto-generated method stub
							
						}

						@Override
						public void mouseReleased(MouseEvent e) {
							// TODO Auto-generated method stub
							
						}

						@Override
						public void mouseEntered(MouseEvent e) {
							// TODO Auto-generated method stub
							
						}

						@Override
						public void mouseExited(MouseEvent e) {
							// TODO Auto-generated method stub
							
						}
						
						
					});
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
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(240, 248, 255));
		panel_1.setBounds(647, 0, 338, 658);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		lblInformacionUsuario = new JLabel("Informaci\u00F3n de Usuario");
		lblInformacionUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblInformacionUsuario.setFont(new Font("Baskerville Old Face", Font.ITALIC, 27));
		lblInformacionUsuario.setBounds(0, 60, 338, 31);
		panel_1.add(lblInformacionUsuario);
		
		textNombre = new JTextField();
		textNombre.setColumns(10);
		textNombre.setBounds(124, 118, 204, 25);
		panel_1.add(textNombre);
		textNombre.addKeyListener(new KeyListener() {

			public void keyTyped(KeyEvent e) {
				char validar = e.getKeyChar();
				
				if(!(isLetra(validar, e))) { 
					e.consume();
					
					JOptionPane.showMessageDialog(null, "Campo 'Nombre' debe contener solo letras");
					nombre = false;
				}
				else {
					nombre = true;
				}
				if(textNombre.getText().equals("")) {
					nombre= false;
				}
				habilitarBoton();

			}

			public void keyPressed(KeyEvent e) {
				habilitarBoton();

			}

			public void keyReleased(KeyEvent e) {
				habilitarBoton();
	
			}
			
		});
		
		textApellido = new JTextField();
		textApellido.setColumns(10);
		textApellido.setBounds(124, 171, 204, 25);
		panel_1.add(textApellido);
		textApellido.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				char validar = e.getKeyChar();

				if(!(isLetra(validar, e))) {
					e.consume();
					
					JOptionPane.showMessageDialog(null, "Campo 'Apellido' debe contener solo letras");
					apellido = false;
				}
				else {
					apellido = true;
				}
				habilitarBoton();
				
				if(textApellido.getText().equals("")) {
					apellido = false;
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				habilitarBoton();
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				habilitarBoton();
				
			}
			
		});
		textCorreo = new JTextField();
		textCorreo.setColumns(10);
		textCorreo.setBounds(124, 226, 204, 25);
		panel_1.add(textCorreo);
		textCorreo.addFocusListener(new FocusListener() {

			public void focusGained(FocusEvent e) {				
			}
			public void focusLost(FocusEvent e) {
				if(isEmail(textCorreo.getText())) {
					lblCampoCorreo.setForeground(Color.GRAY);
					correo = true;
				}
				else {
					lblCampoCorreo.setForeground(Color.RED);
					correo = false;
				}
				
				
				habilitarBoton();

			}
			
		});
		textCorreo.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				if(isEmail(textCorreo.getText())) {
					lblCampoCorreo.setForeground(Color.GRAY);
					correo = true;
				}
				else {
					lblCampoCorreo.setForeground(Color.RED);
					correo = false;
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				
				habilitarBoton();

			}

			@Override
			public void keyReleased(KeyEvent e) {
				if(isEmail(textCorreo.getText())) {
					lblCampoCorreo.setForeground(Color.GRAY);
					correo = true;
				}
				else {
					lblCampoCorreo.setForeground(Color.RED);
					correo = false;
				}
				
				habilitarBoton();
				
			}
			
		});
		
		lblCorreo = new JLabel("Correo");
		lblCorreo.setFont(new Font("Baskerville Old Face", Font.PLAIN, 16));
		lblCorreo.setBounds(10, 226, 170, 25);
		panel_1.add(lblCorreo);
		
		lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Baskerville Old Face", Font.PLAIN, 16));
		lblApellido.setBounds(10, 171, 170, 25);
		panel_1.add(lblApellido);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Baskerville Old Face", Font.PLAIN, 16));
		lblNombre.setBounds(10, 118, 170, 25);
		panel_1.add(lblNombre);
		
		comboBox_Rol2 = new JComboBox<Object>();
		comboBox_Rol2.setFont(new Font("Baskerville Old Face", Font.PLAIN, 14));
		comboBox_Rol2.setBackground(SystemColor.menu);
		comboBox_Rol2.setBounds(124, 282, 204, 25);
		panel_1.add(comboBox_Rol2);
		
		LinkedList<String> allRoles = new LinkedList<>();
		allRoles.add(modelo.Tipo_Rol.AFICIONADO.name());
		allRoles.add(modelo.Tipo_Rol.ADMINISTRADOR.name());
		allRoles.add(modelo.Tipo_Rol.INVESTIGADOR.name());

		for (String s: allRoles){
			comboBox_Rol2.addItem(s);
		} 
		
		lblRolDeUsuario = new JLabel("Rol de Usuario");
		lblRolDeUsuario.setFont(new Font("Baskerville Old Face", Font.PLAIN, 16));
		lblRolDeUsuario.setBounds(10, 282, 170, 25);
		panel_1.add(lblRolDeUsuario);
		
		textTelefono = new JTextField();
		textTelefono.setColumns(10);
		textTelefono.setBounds(124, 510, 204, 25);
		panel_1.add(textTelefono);
		textTelefono.setVisible(false);
		textTelefono.addKeyListener(new KeyListener() {
			
			public void keyTyped(KeyEvent evt) {
				char validar = evt.getKeyChar();
				
				if(isNumero(validar, evt) == false) {
					evt.consume();
					
					JOptionPane.showMessageDialog(null, "Teléfono debe contener solo números");
					lblCampoTelefono.setForeground(Color.RED);

					telefono = false;
				}
				else {
					lblCampoTelefono.setForeground(Color.GRAY);
					
					telefono = true;

				}
				if(textTelefono.getText().equals("")) {
					telefono = false;
				}
				habilitarBoton();

			}

			public void keyPressed(KeyEvent e) {
				habilitarBoton();

			}
			public void keyReleased(KeyEvent e) {
				habilitarBoton();

			}
		});
		
		textDomicilio = new JTextField();
		textDomicilio.setColumns(10);
		textDomicilio.setBounds(124, 455, 204, 25);
		panel_1.add(textDomicilio);
		textDomicilio.setVisible(false);
		
		textDomicilio.addKeyListener(new KeyListener() {

			public void keyTyped(KeyEvent e) {
				char validar = e.getKeyChar();
				
				if(((Character.isAlphabetic(validar)) || (Character.isDigit(validar))) || validar == KeyEvent.VK_BACK_SPACE || validar == KeyEvent.VK_SPACE) {
					
					domicilio = true;
				}
				else {
					e.consume();
					JOptionPane.showMessageDialog(null, "El domicilio puede contener: letras y números");
					
					domicilio = false;
				}
				if(textDomicilio.getText().equals("")) {
					domicilio = false;
				}
				habilitarBoton();

			}

			@Override
			public void keyPressed(KeyEvent e) {
				habilitarBoton();

			}

			public void keyReleased(KeyEvent e) {
				habilitarBoton();

			}
			
		});
		
		lblDomicilio = new JLabel("Domicilio");
		lblDomicilio.setFont(new Font("Baskerville Old Face", Font.PLAIN, 16));
		lblDomicilio.setBounds(10, 455, 170, 25);
		panel_1.add(lblDomicilio);
		lblDomicilio.setVisible(false);
		
		lblCedula = new JLabel("C\u00E9dula");
		lblCedula.setFont(new Font("Baskerville Old Face", Font.PLAIN, 16));
		lblCedula.setBounds(10, 347, 170, 25);
		panel_1.add(lblCedula);
		lblCedula.setVisible(false);
		
		lblTelefono = new JLabel("Tel\u00E9fono");
		lblTelefono.setFont(new Font("Baskerville Old Face", Font.PLAIN, 16));
		lblTelefono.setBounds(10, 510, 170, 25);
		panel_1.add(lblTelefono);
		lblTelefono.setVisible(false);
		
		comboBox_Ciudad = new JComboBox<Object>();
		comboBox_Ciudad.setFont(new Font("Baskerville Old Face", Font.PLAIN, 14));
		comboBox_Ciudad.setBackground(SystemColor.menu);
		comboBox_Ciudad.setBounds(124, 400, 204, 25);
		panel_1.add(comboBox_Ciudad);
		comboBox_Ciudad.addItem("");
		
		LinkedList<Ciudad> allCiudades = DAO_Ciudad.allCiudades();
		for(Ciudad c : allCiudades) {
			comboBox_Ciudad.addItem(c.getNombre());
		}
		comboBox_Ciudad.setVisible(false);
		
		lblCiudad = new JLabel("Ciudad");
		lblCiudad.setFont(new Font("Baskerville Old Face", Font.PLAIN, 16));
		lblCiudad.setBounds(10, 400, 170, 25);
		panel_1.add(lblCiudad);
		lblCiudad.setVisible(false);
		
		textOcupacion = new JTextField();
		textOcupacion.setColumns(10);
		textOcupacion.setBounds(124, 347, 204, 25);
		panel_1.add(textOcupacion);
		textOcupacion.setVisible(false);
		textOcupacion.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				char validar = e.getKeyChar();
				
				if(isLetra(validar, e) == false) {
					e.consume();
					
					JOptionPane.showMessageDialog(null, "La ocupación debe contener solo letras");
					
					ocupacion = false;

				}
				else {
					ocupacion = true;
				}
				if(textOcupacion.getText().equals("")) {
					ocupacion = false;
				}
				habilitarBoton();

			}

			@Override
			public void keyPressed(KeyEvent e) {
				habilitarBoton();
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				habilitarBoton();
				
			}
			
		});;
		
		lblOcupacion = new JLabel("Ocupaci\u00F3n");
		lblOcupacion.setFont(new Font("Baskerville Old Face", Font.PLAIN, 16));
		lblOcupacion.setBounds(10, 347, 170, 25);
		panel_1.add(lblOcupacion);
		lblOcupacion.setVisible(false);
		
		btnActualizarUsuario = new JButton("Actualizar Usuario");
		btnActualizarUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnActualizarUsuario.setBackground(new Color(173, 216, 230));
		btnActualizarUsuario.setBounds(10, 563, 318, 31);
		panel_1.add(btnActualizarUsuario);
		btnActualizarUsuario.setEnabled(false);;
		btnActualizarUsuario.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		btnEliminarUsuario = new JButton("Eliminar Usuario");
		btnEliminarUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEliminarUsuario.setBackground(SystemColor.menu);
		btnEliminarUsuario.setBounds(10, 606, 318, 31);
		panel_1.add(btnEliminarUsuario);
		
		
		lblCampoCorreo = new JLabel("Debe contener @ y .com");
		lblCampoCorreo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCampoCorreo.setForeground(Color.GRAY);
		lblCampoCorreo.setFont(new Font("Baskerville Old Face", Font.PLAIN, 12));
		lblCampoCorreo.setBounds(53, 210, 275, 19);
		panel_1.add(lblCampoCorreo);

		lblCampoCedula = new JLabel("C\u00E9dula sin puntos o guiones. Formato: 12345678");
		lblCampoCedula.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCampoCedula.setForeground(Color.GRAY);
		lblCampoCedula.setFont(new Font("Baskerville Old Face", Font.PLAIN, 12));
		lblCampoCedula.setBounds(53, 331, 275, 19);
		panel_1.add(lblCampoCedula);
		lblCampoCedula.setVisible(false);

		lblCampoTelefono = new JLabel("Tel\u00E9fono solo num\u00E9rico");
		lblCampoTelefono.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCampoTelefono.setForeground(Color.GRAY);
		lblCampoTelefono.setFont(new Font("Baskerville Old Face", Font.PLAIN, 12));
		lblCampoTelefono.setBounds(53, 494, 275, 19);
		panel_1.add(lblCampoTelefono);
		lblCampoTelefono.setVisible(false);
		
		lblMaximo = new JLabel("Caracteres obligatorios: 8");
		lblMaximo.setHorizontalAlignment(SwingConstants.LEFT);
		lblMaximo.setForeground(new Color(255, 0, 0));
		lblMaximo.setFont(new Font("Baskerville Old Face", Font.PLAIN, 12));
		lblMaximo.setBounds(124, 367, 129, 23);
		panel_1.add(lblMaximo);
		lblMaximo.setVisible(false);

		lblNewLabel = new JLabel("*");
		lblNewLabel.setBounds(0, 118, 15, 13);
		panel_1.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("*");
		lblNewLabel_1.setBounds(0, 171, 15, 13);
		panel_1.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("*");
		lblNewLabel_2.setBounds(0, 226, 15, 13);
		panel_1.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("*");
		lblNewLabel_3.setBounds(0, 282, 15, 13);
		panel_1.add(lblNewLabel_3);
		
		lbl1 = new JLabel("*");
		lbl1.setBounds(0, 347, 15, 13);
		panel_1.add(lbl1);
		lbl1.setVisible(false);
		
		lbl2 = new JLabel("*");
		lbl2.setBounds(0, 400, 15, 13);
		panel_1.add(lbl2);
		lbl2.setVisible(false);

		lbl4 = new JLabel("*");
		lbl4.setBounds(0, 455, 15, 13);
		panel_1.add(lbl4);
		lbl4.setVisible(false);

		lbl3 = new JLabel("*");
		lbl3.setBounds(0, 510, 15, 13);
		panel_1.add(lbl3);
		lbl3.setVisible(false);

		textCedula = new JTextField();
		textCedula.setColumns(10);
		textCedula.setBounds(124, 347, 204, 25);
		panel_1.add(textCedula);
		textCedula.setVisible(false);
		textCedula.addKeyListener(new KeyListener() {
			
			public void keyTyped(KeyEvent evt) {
				char validar = evt.getKeyChar();
				
				if(isNumero(validar, evt) == false) {
					evt.consume();
					
					JOptionPane.showMessageDialog(null, "Cédula debe contener solo números");
					
					cedula = false;

				}
					
				if(8 <= textCedula.getText().length()) {
					lblMaximo.setVisible(true);
					evt.consume();
					
					cedula = true;

				}
				
				if (textCedula.getText().length() < 8){
					lblMaximo.setVisible(true);
					
					cedula = false;

				}
				
				if(!(textCedula.getText().equals(""))) {
					
					cedula = true;	
				}
				else {
					cedula = false;
				}
				
				habilitarBoton();

			}

			public void keyPressed(KeyEvent e) {
				habilitarBoton();

			}
			public void keyReleased(KeyEvent e) {
				if(textCedula.getText().length() == 8) {
					lblMaximo.setVisible(false);
					e.consume();
					
					cedula = true;

				}
				habilitarBoton();

			}
		});
		
		separator = new JSeparator();
		separator.setBounds(10, 39, 214, 2);
		panel.add(separator);
		
		lblFiltro = new JLabel("Filtrar por:");
		lblFiltro.setFont(new Font("Baskerville Old Face", Font.PLAIN, 16));
		lblFiltro.setBounds(20, 63, 170, 25);
		panel.add(lblFiltro);
		
		btnLimpiar_1 = new JButton("Limpiar");
		btnLimpiar_1.setBackground(SystemColor.menu);
		btnLimpiar_1.setBounds(533, 63, 94, 25);
		panel.add(btnLimpiar_1);
		btnLimpiar_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = new DefaultTableModel();
				if(comboBox.getSelectedItem().equals("") || comboBox.getSelectedItem().equals("Nombre") || comboBox.getSelectedItem().equals("Apellido") || comboBox.getSelectedItem().equals("Nombre de Usuario")) {
					textFiltro.setText("");
				}
				else {
					comboBox_Rol.setSelectedItem("");
				}
				comboBox.setSelectedItem("");
				model.setNumRows(0);
			}
			
		});
		
		btnIr = new JButton("Ir");
		btnIr.setBackground(new Color(176, 224, 230));
		btnIr.setBounds(533, 109, 94, 25);
		panel.add(btnIr);
		
		btnIr.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if(textFiltro.isVisible() == true || comboBox_Rol.isVisible() == true) {
					
					DefaultTableModel model = new DefaultTableModel() {
						/**
						 * 
						 */
						private static final long serialVersionUID = 1L;

						public boolean isCellEditable(int row, int column) {
							return false;
						}
					};
					Object[] columns = {"Nombre", "Apellido", "E-mail", "Nombre de Usuario", "Rol de Usuario"};
					
					model.setColumnIdentifiers(columns);
					
					Object [] fila = new Object[columns.length];
					table.setModel(model);
					
					LinkedList<Usuario> usuarios = new LinkedList<>();
					
					if(comboBox.getSelectedItem().equals("Nombre")) {
						if(!textFiltro.getText().isEmpty()) {
							String n = textFiltro.getText();
							
							usuarios = DAO_Usuario.findUsuarioNombre(n);
							if(usuarios.size() != 0) {
								listarUsuario(usuarios, fila,  model, null);
							}
							else {
								JOptionPane.showMessageDialog(null, "No existen resultados compatibles");
							}
						}
						else {
							JOptionPane.showMessageDialog(null, "Por favor, escriba un Nombre");
						}
					}
					else if(comboBox.getSelectedItem().equals("Apellido")) {
						if(!textFiltro.getText().isEmpty()) {
							String n = textFiltro.getText();
							
							usuarios = DAO_Usuario.findUsuarioApellido(n);
							if(usuarios.size() != 0) {
								listarUsuario(usuarios, fila,  model, null);
							}
							else {
								JOptionPane.showMessageDialog(null, "No existen resultados compatibles");
							}
						}
						else {
							JOptionPane.showMessageDialog(null, "Por favor, escriba un Apellido");
						}
					}
					else if(comboBox.getSelectedItem().equals("Nombre de Usuario")) {
						if(!textFiltro.getText().isEmpty()) {
							String n = textFiltro.getText();
							
							usuarios = DAO_Usuario.findUsuarioNombreUsuario(n);
							if(usuarios.size() != 0) {
								listarUsuario(usuarios, fila,  model, null);
							}
							else {
								JOptionPane.showMessageDialog(null, "No existen resultados compatibles");
							}
						}
						else {
							JOptionPane.showMessageDialog(null, "Por favor, escriba un Nombre de Usuario");
						}
					}
					
					else if(comboBox.getSelectedItem().equals("Rol de Usuario")) {
						if(comboBox_Rol.getSelectedItem().equals("")) {
							JOptionPane.showMessageDialog(null, "Por favor, eliga un rol de usuario");
						}
						else {
							usuarios = DAO_Usuario.findAll();
							
							if(comboBox_Rol.getSelectedItem().equals("ADMINISTRADOR")) {
								listarUsuario(usuarios, fila,  model, Tipo_Rol.ADMINISTRADOR);
							}
							else if (comboBox_Rol.getSelectedItem().equals("INVESTIGADOR")) {
								listarUsuario(usuarios, fila,  model,  Tipo_Rol.INVESTIGADOR);
							}
							else if(comboBox_Rol.getSelectedItem().equals("AFICIONADO")) {
								listarUsuario(usuarios, fila,  model,  Tipo_Rol.AFICIONADO);
							}
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Por favor, eliga un filtro para comenzar");
					}
				}
			}
		});
		
		textFiltro = new JTextField();
		textFiltro.setBounds(20, 109, 443, 25);
		panel.add(textFiltro);
		textFiltro.setColumns(10);
		
		comboBox = new JComboBox<Object>();
		comboBox.setFont(new Font("Baskerville Old Face", Font.PLAIN, 16));
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(137, 63, 326, 25);
		panel.add(comboBox);
		comboBox.addItem("");
		comboBox.addItem("Nombre");
		comboBox.addItem("Apellido");
		comboBox.addItem("Nombre de Usuario");
		comboBox.addItem("Rol de Usuario");

		comboBox.addItemListener(new ItemListener() {

			public void itemStateChanged(ItemEvent e) {		
				if(comboBox.getSelectedItem().equals("") || comboBox.getSelectedItem().equals("Nombre") || comboBox.getSelectedItem().equals("Apellido") || comboBox.getSelectedItem().equals("Nombre de Usuario")) {
					textFiltro.setVisible(true);
					comboBox_Rol.setVisible(false);
				}
				else {
					comboBox_Rol.setVisible(true);
					textFiltro.setVisible(false);
				}
			}
			
		});
		
		comboBox_Rol = new JComboBox<Object>();
		comboBox_Rol.setFont(new Font("Baskerville Old Face", Font.PLAIN, 16));
		comboBox_Rol.setBackground(Color.WHITE);
		comboBox_Rol.setBounds(20, 109, 443, 25);
		panel.add(comboBox_Rol);
		comboBox_Rol.addItem("");
		
		for (String s: allRoles){
			comboBox_Rol.addItem(s);
		} 
		
		lblSeleccione = new JLabel("Seleccione un registro para realizar alguna modificaci\u00F3n, eliminacion o para ver los datos completos del mismo");
		lblSeleccione.setHorizontalAlignment(SwingConstants.TRAILING);
		lblSeleccione.setFont(new Font("Arial", Font.PLAIN, 10));
		lblSeleccione.setForeground(Color.DARK_GRAY);
		lblSeleccione.setBounds(20, 144, 607, 25);
		panel.add(lblSeleccione);
	}
	
	public void limpiar() {
		textNombre.setText("");
		textApellido.setText("");
		textCorreo.setText("");
		
		if(comboBox_Rol2.getSelectedItem().equals("ADMINISTRADOR") || comboBox_Rol2.getSelectedItem().equals("INVESTIGADOR")) {
			textDomicilio.setText("");
			textCedula.setText("");
			textTelefono.setText("");
			comboBox_Ciudad.setSelectedItem("");
		}
		else if(comboBox_Rol2.getSelectedItem().equals("AFICIONADO") ) {
			textOcupacion.setText("");
		}
	}

	public void habilitarBoton() {
		// TODO Auto-generated method stub
		
	}

	public void listarUsuario(LinkedList<Usuario> usuarios, Object[] fila, DefaultTableModel model, Tipo_Rol tipo) {
		for (Usuario u: usuarios){
			
			String n = u.getNombre();
			String a = u.getApellido();
			String e = u.getMail();
			String nu = u.getNombreUsuario();
			
			Investigador inve = DAO_Investigador.findInvestigador(u.getNombreUsuario(), u.getContrasenia());
			
			Administrador admin = DAO_Administrador.findAdministrador(u.getNombreUsuario(), u.getContrasenia());

			Aficionado afic = DAO_Aficionado.findAficionado(u.getNombreUsuario(), u.getContrasenia());

			String r = "";
			
			if(tipo == null) {
				if(inve != null) {
				r = inve.getTipo_rol().toString();
				}
				else if (admin != null) {
					r = admin.getTipo_rol().toString();
	
				}
				else if (afic != null) {
					r = afic.getTipo_rol().toString();
					
				}
				
				fila[0] = n;
				fila[1] = a;
				fila[2] = e;
				fila[3] = nu;
				fila[4] = r;
				model.addRow(fila); 
			}
			else if(tipo.toString().equals("ADMINISTRADOR")) {
				if (admin != null) {
					fila[0] = n;
					fila[1] = a;
					fila[2] = e;
					fila[3] = nu;
					fila[4] = admin.getTipo_rol().toString();
					model.addRow(fila); 
				}	
			}
			else if(tipo.toString().equals("INVESTIGADOR")) {
				if (inve != null) {
					fila[0] = n;
					fila[1] = a;
					fila[2] = e;
					fila[3] = nu;
					fila[4] = inve.getTipo_rol().toString();
					model.addRow(fila); 
				}	
			}
			else if(tipo.toString().equals("AFICIONADO")) {
				if (afic != null) {
					fila[0] = n;
					fila[1] = a;
					fila[2] = e;
					fila[3] = nu;
					fila[4] = afic.getTipo_rol().toString();
					model.addRow(fila); 
				}	
			}
		}
	}
	public boolean isEmail(String correo) {
		
		Pattern pat = Pattern.compile( "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*\\.com(\\W|$)");
		
		Matcher mat = pat.matcher(correo.toLowerCase());

		if(mat.find()) {
			return true;
		}else {
			return false;
		}
	}
	public static boolean isNumero(char validar, KeyEvent evt) {
		if((validar<'0' || '9'<validar) && validar != KeyEvent.VK_BACK_SPACE) {
			evt.consume();
			
			return false;
		}
		return true;
	}
	
	public static boolean isLetra(char validar, KeyEvent evt) {
		if(!(Character.isAlphabetic(validar)) && validar != KeyEvent.VK_BACK_SPACE && validar != KeyEvent.VK_SPACE) {
			evt.consume();
			return false;
		}
		return true;
	}
	public boolean existeUsuario(String mail) {
		
		Usuario user = DAO_Usuario.findUsuarioMail(mail);
		if(user==null) {
			return false;
		}
		else {
			return true;
		}
	}
	public void aficionado() {
		textCedula.setVisible(false);
		lblCedula.setVisible(false);
		lblCiudad.setVisible(false);
		comboBox_Ciudad.setVisible(false);
		textTelefono.setVisible(false);
		lblTelefono.setVisible(false);
		textOcupacion.setVisible(true);
		lblOcupacion.setVisible(true);
		textDomicilio.setVisible(false);
		lblDomicilio.setVisible(false);
		
		lbl1.setVisible(true);
		lbl2.setVisible(false);
		lbl3.setVisible(false);
		lbl4.setVisible(false);

		lblCampoCedula.setVisible(false);
		lblCampoTelefono.setVisible(false);
		lblMaximo.setVisible(false);
		
		rol = true;
	}
	public void inve_admin(){
		textCedula.setVisible(true);
		lblCedula.setVisible(true);
		lblCiudad.setVisible(true);
		comboBox_Ciudad.setVisible(true);
		textTelefono.setVisible(true);
		lblTelefono.setVisible(true);
		textOcupacion.setVisible(false);
		lblOcupacion.setVisible(false);
		textDomicilio.setVisible(true);
		lblDomicilio.setVisible(true);

		
		lbl1.setVisible(true);
		lbl2.setVisible(true);
		lbl3.setVisible(true);
		lbl4.setVisible(true);
		
		lblCampoCedula.setVisible(true);
		lblCampoTelefono.setVisible(true);

		rol = true;
	}
	public void elsee() {
		textCedula.setVisible(false);
		lblCedula.setVisible(false);
		lblCiudad.setVisible(false);
		comboBox_Ciudad.setVisible(false);
		textTelefono.setVisible(false);
		lblTelefono.setVisible(false);
		textOcupacion.setVisible(false);
		lblOcupacion.setVisible(false);
		textDomicilio.setVisible(false);
		lblDomicilio.setVisible(false);
		
		lbl1.setVisible(false);
		lbl2.setVisible(false);
		lbl3.setVisible(false);
		lbl4.setVisible(false);
		
		lblCampoCedula.setVisible(false);
		lblCampoTelefono.setVisible(false);
		lblMaximo.setVisible(false);

		rol = false;
	}
	
	public void listarTodo(){
		
		DefaultTableModel model = new DefaultTableModel();
		Object[] columns = {"Nombre", "Apellido", "E-mail", "Nombre de Usuario", "Rol de Usuario"};
		
		model.setColumnIdentifiers(columns);
		
		Object [] fila = new Object[columns.length];
		table.setModel(model);
		
		LinkedList<Usuario> usuarios = DAO_Usuario.findAll();
		
		for (Usuario u: usuarios){
			
			String n = u.getNombre();
			String a = u.getApellido();
			String e = u.getMail();
			String nu = u.getNombreUsuario();
			
			Investigador inve = DAO_Investigador.findInvestigador(u.getNombreUsuario(), u.getContrasenia());
			
			Administrador admin = DAO_Administrador.findAdministrador(u.getNombreUsuario(), u.getContrasenia());

			Aficionado afic = DAO_Aficionado.findAficionado(u.getNombreUsuario(), u.getContrasenia());

			String r = "";
			
		
			if(inve != null) {
				r = inve.getTipo_rol().toString();
			}
			else if (admin != null) {
				r = admin.getTipo_rol().toString();

			}
			else if (afic != null) {
				r = afic.getTipo_rol().toString();
				
			}
			
			fila[0] = n;
			fila[1] = a;
			fila[2] = e;
			fila[3] = nu;
			fila[4] = r;
			model.addRow(fila); 
			
	
		}
	}
}
