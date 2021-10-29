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
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.exception.*;
import com.servicios.Administrador_BeanRemote;
import com.servicios.Aficionado_BeanRemote;
import com.servicios.Ciudad_BeanRemote;
import com.servicios.Investigador_BeanRemote;
import com.servicios.Usuario_BeanRemote;

import model.*;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.naming.InitialContext;
import javax.naming.NamingException;
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
	String estado;
	private JTextField textId;
	
	private JSeparator separator_1;

	public Listado_Usuarios() {
		Listado_Usuario = "Listado_Usuario";

		
		setBounds(new Rectangle(0, 0, 985, 658));
		setLayout(new CardLayout(0, 0));
		
		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		add(panel, "name_25541786307800");
		panel.setLayout(null);
		
		separator = new JSeparator();
		separator.setBounds(10, 39, 214, 2);
		panel.add(separator);
		
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
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(240, 248, 255));
		panel_1.setBounds(647, 0, 338, 658);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		separator_1 = new JSeparator();
		separator_1.setBounds(10, 89, 318, 2);
		panel_1.add(separator_1);
		
		lblInformacionUsuario = new JLabel("Informaci\u00F3n de Usuario");
		lblInformacionUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblInformacionUsuario.setFont(new Font("Baskerville Old Face", Font.BOLD | Font.ITALIC, 20));
		lblInformacionUsuario.setBounds(0, 60, 338, 31);
		panel_1.add(lblInformacionUsuario);
		
		DefaultTableModel modelo = new DefaultTableModel();
		
		Object[] columns = {"Nombre", "Apellido", "E-mail", "Nombre de Usuario", "Rol de Usuario"};
		
		modelo.setColumnIdentifiers(columns);
		
		Object [] fila = new Object[columns.length];
		table.setModel(modelo);
		
		List<Usuario> usuarios = new LinkedList<>();
		
		Tipo_Rol tipo = null;
		
		try {
			String dato = "PDT_EJB/Usuario_Bean!com.servicios.Usuario_BeanRemote";
			Usuario_BeanRemote us = (Usuario_BeanRemote) InitialContext.doLookup(dato);
			
			usuarios = us.allUsuarios();
			listarUsuario(usuarios, fila, modelo, tipo);
			
		}catch (NamingException e) {
			e.printStackTrace();
		}
		
		//new Color(240, 255, 240)
		
		textNombre = new JTextField();
		textNombre.setBackground(Color.WHITE);
		textNombre.setColumns(10);
		textNombre.setBounds(124, 118, 204, 25);
		panel_1.add(textNombre);
		textNombre.addKeyListener(new KeyListener() {

			public void keyTyped(KeyEvent e) {
				char validar = e.getKeyChar();
				
				if(!(isLetra(validar, e))) { 
					e.consume();
					
					JOptionPane.showMessageDialog(null, "Campo 'Nombre' debe contener solo letras");
					
				}
				else {
					textNombre.setBackground(new Color(240, 255, 240));
				}
				if(textNombre.getText().equals("")) {
					textNombre.setBackground(new Color(255, 228, 225));
				}
			}

			public void keyPressed(KeyEvent e) {

			}

			public void keyReleased(KeyEvent e) {
	
			}
			
		});
		// new Color(255, 228, 225)
		
		textApellido = new JTextField();
		textApellido.setBackground(Color.WHITE);
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
				}
				else {
					textApellido.setBackground(new Color(240, 255, 240));
				}
				
				if(textApellido.getText().equals("")) {
					textApellido.setBackground(new Color(255, 228, 225));
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				
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
					
					textCorreo.setBackground(new Color(240, 255, 240));
				}
				else {
					lblCampoCorreo.setForeground(Color.RED);
					
					textCorreo.setBackground(new Color(255, 228, 225));
				}
			}
			
		});
		textCorreo.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				if(isEmail(textCorreo.getText())) {
					lblCampoCorreo.setForeground(Color.GRAY);
					
					textCorreo.setBackground(new Color(240, 255, 240));
				}
				else {
					lblCampoCorreo.setForeground(Color.RED);
					
					textCorreo.setBackground(new Color(255, 228, 225));
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if(isEmail(textCorreo.getText())) {
					lblCampoCorreo.setForeground(Color.GRAY);
					textCorreo.setBackground(new Color(240, 255, 240));
				}
				else {
					lblCampoCorreo.setForeground(Color.RED);
					textCorreo.setBackground(new Color(255, 228, 225));
				}
				
				if(!(textCorreo.getText().equals(""))) {
					if(existeUsuario(textCorreo.getText(), Long.parseLong(textId.getText()))) {
						JOptionPane.showMessageDialog(null, "El correo ingresado ya existe en el sistema!");
						
						textCorreo.setBackground(new Color(255, 228, 225));
					}
				}
				else {
					textCorreo.setBackground(new Color(240, 255, 240));
				}
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
		allRoles.add(model.Tipo_Rol.AFICIONADO.name());
		allRoles.add(model.Tipo_Rol.ADMINISTRADOR.name());
		allRoles.add(model.Tipo_Rol.INVESTIGADOR.name());

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
					
				}
				else {
					lblCampoTelefono.setForeground(Color.GRAY);
					
					textTelefono.setBackground(new Color(240, 255, 240));

				}
				if(textTelefono.getText().equals("")) {
					textTelefono.setBackground(new Color(255, 228, 225));
				}

			}

			public void keyPressed(KeyEvent e) {

			}
			public void keyReleased(KeyEvent e) {
				char validar = e.getKeyChar();
				
				if(isNumero(validar, e) == false) {
					e.consume();
					
					JOptionPane.showMessageDialog(null, "Teléfono debe contener solo números");
					lblCampoTelefono.setForeground(Color.RED);

				}
				else {
					lblCampoTelefono.setForeground(Color.GRAY);
					
					textTelefono.setBackground(new Color(240, 255, 240));

				}
				if(textTelefono.getText().equals("")) {
					textTelefono.setBackground(new Color(255, 228, 225));
				}
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
					
					textDomicilio.setBackground(new Color(240, 255, 240));
				}
				else {
					e.consume();
					JOptionPane.showMessageDialog(null, "El domicilio puede contener: letras y números");
					
				}
				if(textDomicilio.getText().equals("")) {
					textDomicilio.setBackground(new Color(255, 228, 225));
				}

			}

			@Override
			public void keyPressed(KeyEvent e) {

			}

			public void keyReleased(KeyEvent e) {

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
					

				}
				else {
					textOcupacion.setBackground(new Color(240, 255, 240));
				}
				if(textOcupacion.getText().equals("")) {
					textOcupacion.setBackground(new Color(255, 228, 225));
				}

			}

			@Override
			public void keyPressed(KeyEvent e) {
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				
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
				if(textNombre.getText().contentEquals("") || textApellido.getText().equals("") || textCorreo.getText().equals("")
						|| isEmail(textCorreo.getText()) == false || comboBox_Rol2.getSelectedItem().equals("")) {
					JOptionPane.showMessageDialog(null, "Se deben completar todos los campos obligatorios");
				}
				else {
					Boolean permitido = false;
					
					String n = textNombre.getText();
					String a = textApellido.getText();
					String m = textCorreo.getText();
					
					String r = (String) comboBox_Rol2.getSelectedItem();
					
					if(r.equals("ADMINISTRADOR") || r.equals("INVESTIGADOR")) {
						if(textCedula.getText().equals("") || isCedula() == false || textDomicilio.getText().equals("") || comboBox_Ciudad.getSelectedItem().equals("")
								|| textTelefono.getText().equals("")) {
							
							JOptionPane.showMessageDialog(null, "Se deben completar todos los campos obligatorios");
							permitido = false;
						}
						else {
							permitido = true;
						}
					}
					else if(r.equals("AFICIONADO")) {
						if(textOcupacion.getText().equals("")) {
							
							JOptionPane.showMessageDialog(null, "Se deben completar todos los campos obligatorios");
							permitido = false;
						}
						else {
							permitido = true;
						}
					}else {
						permitido = false;
					}
					try {
						
						if (permitido == true) {
							int respuesta = JOptionPane.showConfirmDialog(null, "¿ Realmente quieres modificar a este usuario ?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
							
							if(respuesta == JOptionPane.YES_OPTION) {
								
								///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
								
								String dato = "PDT_EJB/Usuario_Bean!com.servicios.Usuario_BeanRemote";
								Usuario_BeanRemote us = (Usuario_BeanRemote) InitialContext.doLookup(dato);
							
								String dato1 = "PDT_EJB/Administrador_Bean!com.servicios.Administrador_BeanRemote";
								Administrador_BeanRemote ad = (Administrador_BeanRemote) InitialContext.doLookup(dato1);
								
								String dato2 = "PDT_EJB/Investigador_Bean!com.servicios.Investigador_BeanRemote";
								Investigador_BeanRemote i = (Investigador_BeanRemote) InitialContext.doLookup(dato2);
								
								String dato3 = "PDT_EJB/Aficionado_Bean!com.servicios.Aficionado_BeanRemote";
								Aficionado_BeanRemote af = (Aficionado_BeanRemote) InitialContext.doLookup(dato3);
								
								///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
								
								
								
								Usuario user = us.findId(Long.parseLong(textId.getText()));
								
								Administrador admin = ad.findUsuario(user.getIdUsuario());
								Investigador inves = i.findUsuario(user.getIdUsuario());
								Aficionado afic = af.findUsuario(user.getIdUsuario());
								
								user.setNombre(n);
								user.setApellido(a);
								user.setMail(m);
								
								if(admin != null) {
									String dato5 = "PDT_EJB/Ciudad_Bean!com.servicios.Ciudad_BeanRemote";
									Ciudad_BeanRemote ciu = (Ciudad_BeanRemote) InitialContext.doLookup(dato5);
									Ciudad ciudad = ciu.findCiudadNombre((String) comboBox_Ciudad.getSelectedItem());
									
									if(r.equals("ADMINISTRADOR")) {
										
										admin.setDocumento(Integer.parseInt(textCedula.getText()));
										admin.setDomicilio(textDomicilio.getText());
										admin.setCiudade(ciudad);
										admin.setTelefono(Integer.parseInt(textTelefono.getText()));
										
										if(ad.edit(admin) && us.edit(user)) {
											JOptionPane.showMessageDialog(null, "Usuario modificado correctamente");
											limpiar();
											elsee();
											habilitar(false);
											filtro(true);
										}else {
											JOptionPane.showMessageDialog(null, "No es posible modificar este usuario");
										}
										
									}else if(r.equals("INVESTIGADOR")){
										
										Investigador nuevoIn = new Investigador();
										
										nuevoIn.setDocumento(Integer.parseInt(textCedula.getText()));
										nuevoIn.setDomicilio(textDomicilio.getText());
										nuevoIn.setCiudade(ciudad);
										nuevoIn.setTelefono(Integer.parseInt(textTelefono.getText()));
										
										if(ad.delete(admin)) {
											nuevoIn.setUsuario(user);
											
											if(us.edit(user) && i.insert(nuevoIn)) {
												JOptionPane.showMessageDialog(null, "Usuario modificado correctamente");
												limpiar();
												elsee();
												habilitar(false);
												filtro(true);
											}	
										}else {
											JOptionPane.showMessageDialog(null, "No es posible modificar este usuario");
										}
									}
									
									else if(r.equals("AFICIONADO")){
										
										Aficionado nuevoAf = new Aficionado();
										
										nuevoAf.setOcupacion(textOcupacion.getText());
										
										if(ad.delete(admin)) {
											nuevoAf.setUsuario(user);
											
											if(us.edit(user) && af.insert(nuevoAf)) {
												JOptionPane.showMessageDialog(null, "Usuario modificado correctamente");
												limpiar();
												elsee();
												habilitar(false);
												filtro(true);
											}
										}else {
											JOptionPane.showMessageDialog(null, "No es posible modificar este usuario");
										}
									}
								}
								////////////////////////////////////////////
								
								else if(inves != null) {
									String dato5 = "PDT_EJB/Ciudad_Bean!com.servicios.Ciudad_BeanRemote";
									Ciudad_BeanRemote ciu = (Ciudad_BeanRemote) InitialContext.doLookup(dato5);
									Ciudad ciudad = ciu.findCiudadNombre((String) comboBox_Ciudad.getSelectedItem());
									
									if(r.equals("INVESTIGADOR")) {
										
										inves.setDocumento(Integer.parseInt(textCedula.getText()));
										inves.setDomicilio(textDomicilio.getText());
										inves.setCiudade(ciudad);
										inves.setTelefono(Integer.parseInt(textTelefono.getText()));
										
										if(i.edit(inves) && us.edit(user)) {
											JOptionPane.showMessageDialog(null, "Usuario modificado correctamente");
											limpiar();
											elsee();
											habilitar(false);
											filtro(true);
										}else {
											JOptionPane.showMessageDialog(null, "No es posible modificar este usuario");
										}
									}
									else if(r.equals("AFICIONADO")){
										
										Aficionado nuevoAf = new Aficionado();
										
										nuevoAf.setOcupacion(textOcupacion.getText());
										
										if(i.delete(inves)) {
											nuevoAf.setUsuario(user);
											
											if(us.edit(user) && af.insert(nuevoAf)) {
												JOptionPane.showMessageDialog(null, "Usuario modificado correctamente");
												limpiar();
												elsee();
												habilitar(false);
												filtro(true);
											}else {
												JOptionPane.showMessageDialog(null, "No es posible modificar este usuario");
											}
										}
									}
									else if(r.equals("ADMINISTRADOR")){
										
										Administrador nuevoAd = new Administrador();
										
										nuevoAd.setDocumento(Integer.parseInt(textCedula.getText()));
										nuevoAd.setDomicilio(textDomicilio.getText());
										nuevoAd.setCiudade(ciudad);
										nuevoAd.setTelefono(Integer.parseInt(textTelefono.getText()));
										
										if(i.delete(inves)) {
											nuevoAd.setUsuario(user);
											
											if(us.edit(user) && ad.insert(nuevoAd)) {
												JOptionPane.showMessageDialog(null, "Usuario modificado correctamente");
												limpiar();
												elsee();
												habilitar(false);
												filtro(true);
											}	
										}else {
											JOptionPane.showMessageDialog(null, "No es posible modificar este usuario");
										}
									}
								}
								////////////////////////////////////////////

								else if(afic != null) {
									if(r.equals("AFICIONADO")) {
										
										afic.setOcupacion(textOcupacion.getText());
										
										if(af.edit(afic) && us.edit(user)) {
											JOptionPane.showMessageDialog(null, "Usuario modificado correctamente");
											limpiar();
											elsee();
											habilitar(false);
											filtro(true);
										}else {
											JOptionPane.showMessageDialog(null, "No es posible modificar este usuario");
										}
									}
									else if(r.equals("ADMINISTRADOR")){
										String dato5 = "PDT_EJB/Ciudad_Bean!com.servicios.Ciudad_BeanRemote";
										Ciudad_BeanRemote ciu = (Ciudad_BeanRemote) InitialContext.doLookup(dato5);
										Ciudad ciudad = ciu.findCiudadNombre((String) comboBox_Ciudad.getSelectedItem());
										
										Administrador nuevoAd = new Administrador();
										
										nuevoAd.setDocumento(Integer.parseInt(textCedula.getText()));
										nuevoAd.setDomicilio(textDomicilio.getText());
										nuevoAd.setCiudade(ciudad);
										nuevoAd.setTelefono(Integer.parseInt(textTelefono.getText()));
										
										if(af.delete(afic)) {
											nuevoAd.setUsuario(user);
											
											if(us.edit(user) && ad.insert(nuevoAd)) {
												JOptionPane.showMessageDialog(null, "Usuario modificado correctamente");
												limpiar();
												elsee();
												habilitar(false);
												filtro(true);
											}	
										}else {
											JOptionPane.showMessageDialog(null, "No es posible modificar este usuario");
										}
									}
									else if(r.equals("INVESTIGADOR")){
										String dato5 = "PDT_EJB/Ciudad_Bean!com.servicios.Ciudad_BeanRemote";
										Ciudad_BeanRemote ciu = (Ciudad_BeanRemote) InitialContext.doLookup(dato5);
										Ciudad ciudad = ciu.findCiudadNombre((String) comboBox_Ciudad.getSelectedItem());
										
										Investigador nuevoIn = new Investigador();
										
										nuevoIn.setDocumento(Integer.parseInt(textCedula.getText()));
										nuevoIn.setDomicilio(textDomicilio.getText());
										nuevoIn.setCiudade(ciudad);
										nuevoIn.setTelefono(Integer.parseInt(textTelefono.getText()));
										
										if(af.delete(afic)) {
											nuevoIn.setUsuario(user);
											
											if(us.edit(user) && i.insert(nuevoIn)) {
												JOptionPane.showMessageDialog(null, "Usuario modificado correctamente");
												limpiar();
												elsee();
												habilitar(false);
												filtro(true);
											}	
										}else {
											JOptionPane.showMessageDialog(null, "No es posible modificar este usuario");
										}
									}
								}
								
								filtro(true);
								
							}
						}
						
					} catch (NamingException | ServiciosException e1) {
						JOptionPane.showMessageDialog(null, "lo rompiste we");

						e1.printStackTrace();
					}
					
				}
			}
			
		});
		comboBox_Ciudad = new JComboBox<Object>();
		comboBox_Ciudad.setFont(new Font("Baskerville Old Face", Font.PLAIN, 14));
		comboBox_Ciudad.setBackground(SystemColor.menu);
		comboBox_Ciudad.setBounds(124, 400, 204, 25);
		panel_1.add(comboBox_Ciudad);
		comboBox_Ciudad.addItemListener(new ItemListener() {

			public void itemStateChanged(ItemEvent e) {
				if(comboBox_Ciudad.getSelectedItem().equals("")) {
					comboBox_Ciudad.setBackground(new Color(255, 228, 225));
				}
				else {
					comboBox_Ciudad.setBackground(new Color(240, 255, 240));
				}
			}
			
		});
		comboBox_Ciudad.addItem("");
		
		List<Ciudad> allCiudades = new LinkedList<>();
		try {
			String dato3 = "PDT_EJB/Ciudad_Bean!com.servicios.Ciudad_BeanRemote";
			Ciudad_BeanRemote de = (Ciudad_BeanRemote) InitialContext.doLookup(dato3);
			allCiudades = de.allCiudades();
			
		} catch(NamingException ex) {
			ex.getMessage();
		}
		for(Ciudad c : allCiudades) {
			comboBox_Ciudad.addItem(c.getNombre());
		}
		comboBox_Ciudad.setVisible(false);
		
		
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
					
				}
					
				if(8 <= textCedula.getText().length()) {
					lblMaximo.setVisible(true);
					
					evt.consume();
					
					if(!isCedula()) {
						JOptionPane.showMessageDialog(null, "La Cédula ingresada es incorrecta");
						
						textCedula.setBackground(new Color(255, 228, 225));
					}
					else {
						int ci = Integer.parseInt(textCedula.getText());
						
						if(existeInveAdmin(ci, Long.parseLong(textId.getText()))) {

							JOptionPane.showMessageDialog(null, "La Cédula ingresada ya existe en el sistema!");							
							textCedula.setBackground(new Color(255, 228, 225));
						}
						else{
							textCedula.setBackground(new Color(240, 255, 240));
						}
					}
				}
				
				else if (textCedula.getText().length() < 8){
					lblMaximo.setVisible(true);
					
					textCedula.setBackground(new Color(255, 228, 225));
				}
				
				if((textCedula.getText().equals(""))) {
					textCedula.setBackground(new Color(255, 228, 225));
				}
			}

			public void keyPressed(KeyEvent e) {

			}
			public void keyReleased(KeyEvent e) {
				if (textCedula.getText().length() < 8){
					lblMaximo.setVisible(true);
					textCedula.setBackground(new Color(255, 228, 225));
					
				}
				
				else if(textCedula.getText().length() == 8) {
					lblMaximo.setVisible(true);
					e.consume();
					
					if(!isCedula()) {
						JOptionPane.showMessageDialog(null, "La Cédula ingresada es incorrecta");
						textCedula.setBackground(new Color(255, 228, 225));
					}
					else {
						
						int ci = Integer.parseInt(textCedula.getText());
						
						if(existeInveAdmin(ci, Long.parseLong(textId.getText()))) {
							JOptionPane.showMessageDialog(null, "La Cédula ingresada ya existe en el sistema!");
							textCedula.setBackground(new Color(255, 228, 225));
							
						}
						else{
							textCedula.setBackground(new Color(240, 255, 240));
							lblMaximo.setVisible(false);
						}
					}
				}
			}
		});
		textCedula.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (textCedula.getText().length() < 8){
					lblMaximo.setVisible(true);
					textCedula.setBackground(new Color(255, 228, 225));

				}
				else if(textCedula.getText().length() == 8) {
					lblMaximo.setVisible(false);
					
					if(!isCedula()) {
						textCedula.setBackground(new Color(255, 228, 225));

					}
					else {
						textCedula.setBackground(new Color(240, 255, 240));

					}

				}
				if(!(textCedula.getText().equals(""))) {
					int ci = Integer.parseInt(textCedula.getText());
					if(existeInveAdmin(ci, Long.parseLong(textId.getText()))) {							
						JOptionPane.showMessageDialog(null, "La Cédula ingresada ya existe en el sistema!");

						textCedula.setBackground(new Color(255, 228, 225));

					}
					else {
						textCedula.setBackground(new Color(240, 255, 240));

					}
				}
				else {
					textCedula.setBackground(new Color(255, 228, 225));

				}
			}			
		});
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
					DefaultTableModel modelo = new DefaultTableModel();
					
					Object[] columns = {"Nombre", "Apellido", "E-mail", "Nombre de Usuario", "Rol de Usuario"};
					
					modelo.setColumnIdentifiers(columns);
					
					Object [] fila = new Object[columns.length];
					table.setModel(modelo);
					
					List<Usuario> usuarios = new LinkedList<>();
					
					Tipo_Rol tipo = null;
					
					try {
						String dato = "PDT_EJB/Usuario_Bean!com.servicios.Usuario_BeanRemote";
						Usuario_BeanRemote us = (Usuario_BeanRemote) InitialContext.doLookup(dato);
						
						usuarios = us.allUsuarios();
						listarUsuario(usuarios, fila, modelo, tipo);
						
					}catch (NamingException x) {
						x.printStackTrace();
					}
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
					filtro(false);
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
		
		comboBox_Rol2.addItemListener(new ItemListener(){
			
			//Control de campos: aparecerán solo los que correspondan
			public void  itemStateChanged(ItemEvent e) {
				String a = (String) comboBox_Rol2.getSelectedItem();
				if(a.equals("ADMINISTRADOR") || a.equals("INVESTIGADOR")) {
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

				}
				else if(a.equals("AFICIONADO")){
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


				}
				else {
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


				}

			}
		});
		
		lblSeleccione = new JLabel("Seleccione un registro para realizar alguna modificaci\u00F3n, eliminacion o para ver los datos completos del mismo");
		lblSeleccione.setHorizontalAlignment(SwingConstants.TRAILING);
		lblSeleccione.setFont(new Font("Arial", Font.PLAIN, 10));
		lblSeleccione.setForeground(Color.DARK_GRAY);
		lblSeleccione.setBounds(20, 144, 607, 25);
		panel.add(lblSeleccione);
		

		btnEliminarUsuario = new JButton("Eliminar Usuario");
		btnEliminarUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEliminarUsuario.setBackground(SystemColor.menu);
		btnEliminarUsuario.setBounds(10, 606, 318, 31);
		panel_1.add(btnEliminarUsuario);
		btnEliminarUsuario.setEnabled(false);
		
		textId = new JTextField();
		textId.setFont(new Font("Tahoma", Font.PLAIN, 7));
		textId.setForeground(new Color(240, 248, 255));
		textId.setBorder(null);
		textId.setBackground(new Color(240, 248, 255));
		textId.setEditable(false);
		textId.setBounds(10, 95, 96, 13);
		panel_1.add(textId);
		textId.setColumns(10);
		btnEliminarUsuario.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e){
				int respuesta = JOptionPane.showConfirmDialog(null, "¿ Realmente quieres eliminar a este usuario ? Una vez hecho, no hay vuelta atrás", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				
				if(respuesta == JOptionPane.YES_OPTION) {	
					try {
						String dato = "PDT_EJB/Usuario_Bean!com.servicios.Usuario_BeanRemote";
						Usuario_BeanRemote us = (Usuario_BeanRemote) InitialContext.doLookup(dato);
					
						String dato1 = "PDT_EJB/Administrador_Bean!com.servicios.Administrador_BeanRemote";
						Administrador_BeanRemote ad = (Administrador_BeanRemote) InitialContext.doLookup(dato1);
						
						String dato2 = "PDT_EJB/Investigador_Bean!com.servicios.Investigador_BeanRemote";
						Investigador_BeanRemote i = (Investigador_BeanRemote) InitialContext.doLookup(dato2);
						
						String dato3 = "PDT_EJB/Aficionado_Bean!com.servicios.Aficionado_BeanRemote";
						Aficionado_BeanRemote af = (Aficionado_BeanRemote) InitialContext.doLookup(dato3);
						
						
						Usuario user = us.findId(Long.parseLong(textId.getText()));
						
						Administrador admin = ad.findUsuario(user.getIdUsuario());
						Investigador inves = i.findUsuario(user.getIdUsuario());
						Aficionado afic = af.findUsuario(user.getIdUsuario());
						
						
					    
						if(admin != null) {
							if(ad.delete(admin) && us.delete(user)) {
								JOptionPane.showMessageDialog(null, "Usuario eliminado correctamente)");
								limpiar();
								habilitar(false);
								
							}else {
								JOptionPane.showMessageDialog(null, "No es posible eliminar este usuario");
							}
						}
						else if(inves != null) {
							if(i.delete(inves) && us.delete(user)) {
								JOptionPane.showMessageDialog(null, "Usuario eliminado correctamente)");
								limpiar();
								habilitar(false);
								
							}else {
								JOptionPane.showMessageDialog(null, "No es posible eliminar este usuario");
							}
						}
						else if(afic != null) {
							if(af.delete(afic) && us.delete(user)) {
								JOptionPane.showMessageDialog(null, "Usuario eliminado correctamente)");
								limpiar();
								habilitar(false);
								
							}else {
								JOptionPane.showMessageDialog(null, "No es posible eliminar este usuario");
							}
						}
						
						filtro(true);
						
					} catch (NamingException | ServiciosException e1) {
						e1.printStackTrace();
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
		

		table.addMouseListener(new MouseListener() {

			public void mouseClicked(MouseEvent e) {
				limpiar();
				
				int filaSeleccionada;
				
				filaSeleccionada = table.getSelectedRow();
				if(filaSeleccionada == -1) {
					elsee();
					btnEliminarUsuario.setEnabled(false);
					habilitar(false);
					
				}else {
					habilitar(true);
					btnEliminarUsuario.setEnabled(true);

					textNombre.setText(table.getValueAt(filaSeleccionada, 0).toString());
					textApellido.setText(table.getValueAt(filaSeleccionada, 1).toString());
					textCorreo.setText(table.getValueAt(filaSeleccionada, 2).toString());
					
					String correo = table.getValueAt(filaSeleccionada, 2).toString();
					
					Usuario u = null;
					try {
						String dato = "PDT_EJB/Usuario_Bean!com.servicios.Usuario_BeanRemote";
						Usuario_BeanRemote us = (Usuario_BeanRemote) InitialContext.doLookup(dato);
						
						u = us.findUsuarioMail(correo); 
						
						textId.setText(String.valueOf(u.getIdUsuario()));
						
					} catch(NamingException | ServiciosException ex) {
						ex.getMessage();
					}
					
					
					////////////
					
					Investigador inves = new Investigador();
					
					try {
						String dato2 = "PDT_EJB/Investigador_Bean!com.servicios.Investigador_BeanRemote";
						Investigador_BeanRemote in = (Investigador_BeanRemote) InitialContext.doLookup(dato2);
						
						inves = in.findInvestigador(u.getNombreUsuario(), u.getContraseña());

					} catch(NamingException | ServiciosException ex) {
						ex.getMessage();
					}
					///////////
					
					Aficionado afic = new Aficionado();
					
					try {
						String dato3 = "PDT_EJB/Aficionado_Bean!com.servicios.Aficionado_BeanRemote";
						Aficionado_BeanRemote af = (Aficionado_BeanRemote) InitialContext.doLookup(dato3);
						
						afic = af.findAficionado(u.getNombreUsuario(), u.getContraseña());
						 
					} catch(NamingException | ServiciosException ex) {
						ex.getMessage();
					}
					
					Administrador admins = new Administrador();
					
					try {
						String dato4 = "PDT_EJB/Administrador_Bean!com.servicios.Administrador_BeanRemote";
						Administrador_BeanRemote ad = (Administrador_BeanRemote) InitialContext.doLookup(dato4);
						
						admins = ad.findAdministrador(u.getNombreUsuario(), u.getContraseña()); 
						
						
					} catch(NamingException | ServiciosException ex) {
						ex.getMessage();
					}
					 
					if(admins != null) {
						inve_admin();
						
						textCedula.setText(String.valueOf(admins.getDocumento()));
						comboBox_Ciudad.setSelectedItem(admins.getCiudade().getNombre());
						comboBox_Rol2.setSelectedItem("ADMINISTRADOR");
						textDomicilio.setText(admins.getDomicilio());
						textTelefono.setText(String.valueOf(admins.getTelefono()));
						
					}else if(inves != null) {
						inve_admin();
						
						textCedula.setText(String.valueOf(inves.getDocumento()));
						comboBox_Ciudad.setSelectedItem(inves.getCiudade().getNombre());
						comboBox_Rol2.setSelectedItem("INVESTIGADOR");
						textDomicilio.setText(inves.getDomicilio());
						textTelefono.setText(String.valueOf(inves.getTelefono()));

					}else if(afic != null) {
						aficionado();
												
						textOcupacion.setText(afic.getOcupacion());
						comboBox_Rol2.setSelectedItem("AFICIONADO");

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
		
		habilitar(false);
	}
	
	public void limpiar() {
		textNombre.setText("");
		textApellido.setText("");
		textCorreo.setText("");
		
		textNombre.setBackground(Color.WHITE);
		textApellido.setBackground(Color.WHITE);
		textCorreo.setBackground(Color.WHITE);
		
			textDomicilio.setText("");
			textCedula.setText("");
			textTelefono.setText("");
			comboBox_Ciudad.setSelectedItem("");
			
			textDomicilio.setBackground(Color.WHITE);
			textCedula.setBackground(Color.WHITE);
			textTelefono.setBackground(Color.WHITE);
			comboBox_Ciudad.setBackground(Color.WHITE);
		
			textOcupacion.setText("");
			
			textOcupacion.setBackground(Color.WHITE);
		
	}
	public void habilitar(boolean t) {
		if(t == true) {
			textNombre.setEnabled(true);
			textApellido.setEnabled(true);
			textCorreo.setEnabled(true);
			
			btnEliminarUsuario.setEnabled(true);
			btnActualizarUsuario.setEnabled(true);
			
			comboBox_Rol2.setEnabled(true);
			
			if(comboBox_Rol2.getSelectedItem().equals("ADMINISTRADOR") || comboBox_Rol2.getSelectedItem().equals("INVESTIGADOR")) {
				textDomicilio.setEnabled(true);
				textCedula.setEnabled(true);
				textTelefono.setEnabled(true);
				comboBox_Ciudad.setEnabled(true);
			}
			else if(comboBox_Rol2.getSelectedItem().equals("AFICIONADO") ) {
				textOcupacion.setEnabled(true);
			}
		}
		else {
			textNombre.setEnabled(false);
			textApellido.setEnabled(false);
			textCorreo.setEnabled(false);
			
			btnEliminarUsuario.setEnabled(false);
			btnActualizarUsuario.setEnabled(false);

			comboBox_Rol2.setEnabled(false);
						
			if(comboBox_Rol2.getSelectedItem().equals("ADMINISTRADOR") || comboBox_Rol2.getSelectedItem().equals("INVESTIGADOR")) {
				textDomicilio.setEnabled(false);
				textCedula.setEnabled(false);
				textTelefono.setEnabled(false);
				comboBox_Ciudad.setEnabled(false);
			}
			else if(comboBox_Rol2.getSelectedItem().equals("AFICIONADO") ) {
				textOcupacion.setEnabled(false);
			}
		}
		
	}

	

	public void listarUsuario(List<Usuario> usuarios, Object[] fila, DefaultTableModel model, Tipo_Rol tipo) {
		for (Usuario u: usuarios){
			
			String n = u.getNombre();
			String a = u.getApellido();
			String e = u.getMail();
			String nu = u.getNombreUsuario();
			
			Administrador admin = null;
			
			try {
				String dato = "PDT_EJB/Administrador_Bean!com.servicios.Administrador_BeanRemote";
				Administrador_BeanRemote ad = (Administrador_BeanRemote) InitialContext.doLookup(dato);
				
				admin = ad.findAdministrador(u.getNombreUsuario(), u.getContraseña()); 
				
				
			} catch(NamingException | ServiciosException ex) {
				ex.getMessage();
			}
			////////////
			
			Investigador inves = null;
			
			try {
				String dato2 = "PDT_EJB/Investigador_Bean!com.servicios.Investigador_BeanRemote";
				Investigador_BeanRemote in = (Investigador_BeanRemote) InitialContext.doLookup(dato2);
				
				inves = in.findInvestigador(u.getNombreUsuario(), u.getContraseña());

			} catch(NamingException | ServiciosException ex) {
				ex.getMessage();
			}
			///////////
			
			Aficionado afic = null;
			
			try {
				String dato3 = "PDT_EJB/Aficionado_Bean!com.servicios.Aficionado_BeanRemote";
				Aficionado_BeanRemote af = (Aficionado_BeanRemote) InitialContext.doLookup(dato3);
				
				afic = af.findAficionado(u.getNombreUsuario(), u.getContraseña());
				 
			} catch(NamingException | ServiciosException ex) {
				ex.getMessage();
			}
			
			String r = "";
			
			if(tipo == null) {
				if(inves != null) {
					r = Tipo_Rol.INVESTIGADOR.toString();
				}
				else if (admin != null) {
					r = Tipo_Rol.ADMINISTRADOR.toString();	
				}
				else if (afic != null) {
					r = Tipo_Rol.AFICIONADO.toString();					
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
					fila[4] = Tipo_Rol.ADMINISTRADOR.toString();
					model.addRow(fila); 
				}	
			}
			else if(tipo.toString().equals("INVESTIGADOR")) {
				if (inves != null) {
					fila[0] = n;
					fila[1] = a;
					fila[2] = e;
					fila[3] = nu;
					fila[4] = Tipo_Rol.INVESTIGADOR.toString();
					model.addRow(fila); 
				}	
			}
			else if(tipo.toString().equals("AFICIONADO")) {
				if (afic != null) {
					fila[0] = n;
					fila[1] = a;
					fila[2] = e;
					fila[3] = nu;
					fila[4] = Tipo_Rol.AFICIONADO.toString();
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
	public boolean existeUsuario(String mail, long id) {
		

		Usuario user = null;
		
		try {
			String dato3 = "PDT_EJB/Usuario_Bean!com.servicios.Usuario_BeanRemote";
			Usuario_BeanRemote af = (Usuario_BeanRemote) InitialContext.doLookup(dato3);
			
			user = af.findUsuarioMail(mail);
			 
		} catch(NamingException | ServiciosException ex) {
			ex.getMessage();
		}
		
		if(user==null) {
			return false;
		}
		else if(user.getIdUsuario() == id) {
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

	}

	public static boolean existeInveAdmin(int cedula, long id) {
		
		boolean existe = false;
		
		Administrador admin = null;
		
		try {
			String dato = "PDT_EJB/Administrador_Bean!com.servicios.Administrador_BeanRemote";
			Administrador_BeanRemote ad = (Administrador_BeanRemote) InitialContext.doLookup(dato);
			admin = ad.findAdministradorCedula(cedula);

		} catch(NamingException | ServiciosException ex) {
			ex.getMessage();
		}
		
		Investigador inve = null;
		
		try {
			String dato2 = "PDT_EJB/Investigador_Bean!com.servicios.Investigador_BeanRemote";
			Investigador_BeanRemote in = (Investigador_BeanRemote) InitialContext.doLookup(dato2);
			inve = in.findInvestigadorCedula(cedula);

		} catch(NamingException | ServiciosException ex) {
			ex.getMessage();
		}
		
		if(admin != null) {
			if(admin.getUsuario().getIdUsuario() == id){
				existe = false;
			}
			else {
				existe = true;
			}
			
		}
		else if (inve != null){
			if(inve.getUsuario().getIdUsuario() == id) {
				existe = false;
			}
			else {
				existe = true;
			}
		}	
		return existe;
	}
	public boolean isCedula() {
		
		int correcto=0;
		String ced=textCedula.getText().trim();
				
		int cedula[]; // Vector donde van a estar los digitos de la cedula
		int factor[] = {8,1,2,3,4,7,6,0};// factor a multiplicar
		
		cedula = new int[8];
		
		int suma=0;
		
		
		for(int i=0;i<ced.length();i++){
			if(ced.charAt(i) == '0' || ced.charAt(i)== '1' || ced.charAt(i)=='2' 
               || ced.charAt(i)== '3' || ced.charAt(i) == '4' || ced.charAt(i)== '5' || ced.charAt(i)=='6' 
              || ced.charAt(i) == '7' || ced.charAt(i)== '8' || ced.charAt(i)=='9'){
				correcto++;
				cedula[i]=Integer.parseInt("" +ced.charAt(i));
				 
				suma = suma + (cedula[i]*factor[i]);
				
			}
		}
		
		if (correcto!=8){
			return false;
			
		} else {
			// Caso de ingreso correcto 
			
			int resto=suma%10;
			if (resto == cedula[7]) {
				return true;
			} else {
				return false;
			}
		}
	}
	public void filtro(Boolean tod) {
			
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
			
			List<Usuario> usuarios = new LinkedList<>();
			
			String dato3 = "PDT_EJB/Usuario_Bean!com.servicios.Usuario_BeanRemote";

			if(comboBox.getSelectedItem().equals("Nombre")) {

				if(!textFiltro.getText().isEmpty()) {
					String n = textFiltro.getText();
					
					try {
						Usuario_BeanRemote us = (Usuario_BeanRemote) InitialContext.doLookup(dato3);
						
						usuarios = us.findUsuarioNombre(n);
						estado = "Nombre";
						
					} catch(NamingException | ServiciosException ex) {
						ex.getMessage();
					}
					
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
					String a = textFiltro.getText();
					
					try {
						Usuario_BeanRemote us = (Usuario_BeanRemote) InitialContext.doLookup(dato3);
						
						usuarios = us.findUsuarioApellido(a);
						estado = "Apellido";
						 
					} catch(NamingException | ServiciosException ex) {
						ex.getMessage();
					}
					
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
					String u = textFiltro.getText();
					
					try {
						Usuario_BeanRemote us = (Usuario_BeanRemote) InitialContext.doLookup(dato3);
						
						usuarios = us.findUsuarioNombreUsuario(u);
						estado = "Nombre Usuario";
						
					} catch(NamingException | ServiciosException ex) {
						ex.getMessage();
					}
					
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
					try {
						Usuario_BeanRemote us = (Usuario_BeanRemote) InitialContext.doLookup(dato3);
						
						usuarios = us.allUsuarios();
						estado = "Rol";
						
					} catch(NamingException ex) {
						ex.getMessage();
					}
					
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
				if(tod == false)
					JOptionPane.showMessageDialog(null, "Por favor, eliga un filtro para comenzar");
				
				else {
					Usuario_BeanRemote us;
					
					try {
						us = (Usuario_BeanRemote) InitialContext.doLookup(dato3);
						usuarios = us.allUsuarios();
						
						listarUsuario(usuarios, fila,  model, null);
						
					} catch (NamingException e) {
						e.printStackTrace();
					}
				}
			}
	}
}

	