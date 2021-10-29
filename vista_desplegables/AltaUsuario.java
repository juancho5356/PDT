package vista_desplegables;

import javax.swing.JPanel;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.CardLayout;
import javax.swing.JTextField;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import java.awt.SystemColor;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JButton;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;

import model.*;
import javax.swing.SwingConstants;

import com.exception.ServiciosException;
import com.servicios.*;

import javax.swing.JSeparator;


public class AltaUsuario extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel panel;
	
	public static String Usuario;
	
	private JTextField textNombre;
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JTextField textApellido;
	private JLabel lblCorreoElectrnico;
	private JTextField textCorreo;
	private JLabel lblNombreDeUsuario;
	private JTextField textUsuario;
	private JLabel lblContrasea;
	private JPasswordField password;
	private JLabel lblNewLabel;
	private JLabel lblRolDeUsuario;
	private JComboBox<Object> comboBox;
	private JButton btnIngresar;
	private JTextField textCedula;
	private JLabel lblCedula;
	private JLabel lblCiudad;
	private JTextField textTelefono;
	private JLabel lblTelefono;
	private JComboBox<Object> comboBox_Ciudad;

	private JTextField textOcupacion;

	private JLabel lblOcupacion;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lbl1;
	private JLabel lbl2;
	private JLabel lbl3;
	private JLabel lblCamposObligatorios;
	private JTextField textDomicilio;
	private JLabel lblDomicilio;
	private JLabel lbl4;
	private JSeparator separator;
	private JButton btnLimpiar;
	private JLabel lblCampoCedula;
	private JLabel lblCampoTelefono;
	private JLabel lblCampoNombreUsuario;
	private JLabel lblCampoCorreo;
	private JLabel lblMaximo;
	private JLabel lblMinimo;
	private JLabel lblCaracteresUsuario;
	private JLabel lblCampoPassword;


	public boolean nombre;
	public boolean apellido;
	public boolean nombreUsuario;
	public boolean contrasenia;
	public boolean correo;
	
	public boolean ocupacion;
	
	public boolean cedula;
	public boolean domicilio;
	public boolean telefono;
	
	public boolean ciudad;
	public boolean rol;
	

	/**
	 * Create the panel.
	 */
	public AltaUsuario() {
		Usuario = "Usuario";
		
		setBounds(new Rectangle(0, 0, 985, 658));
		setLayout(new CardLayout(0, 0));
		
		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		add(panel, "name_25541786307800");
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("Alta de Usuario");
		lblNewLabel.setFont(new Font("Baskerville Old Face", Font.ITALIC, 27));
		lblNewLabel.setBounds(55, 87, 275, 31);
		panel.add(lblNewLabel);
		
		separator = new JSeparator();
		separator.setBounds(55, 116, 170, 2);
		panel.add(separator);
		
		textNombre = new JTextField();
		textNombre.setBounds(235, 156, 239, 25);
		panel.add(textNombre);
		textNombre.setColumns(10);
				
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
					textNombre.setBackground(new Color(240, 255, 240));
				}
				if(textNombre.getText().equals("")) {
					textNombre.setBackground(new Color(255, 228, 225));
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
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Baskerville Old Face", Font.PLAIN, 16));
		lblNombre.setBounds(55, 156, 170, 25);
		panel.add(lblNombre);
		
		lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Baskerville Old Face", Font.PLAIN, 16));
		lblApellido.setBounds(55, 209, 170, 25);
		panel.add(lblApellido);
		
		textApellido = new JTextField();
		textApellido.setColumns(10);
		textApellido.setBounds(235, 209, 239, 25);
		panel.add(textApellido);
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
					textApellido.setBackground(new Color(240, 255, 240));
					apellido = true;
				}
				habilitarBoton();
				
				if(textApellido.getText().equals("")) {
					textApellido.setBackground(new Color(255, 228, 225));
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
		
		lblCorreoElectrnico = new JLabel("Correo electr\u00F3nico");
		lblCorreoElectrnico.setFont(new Font("Baskerville Old Face", Font.PLAIN, 16));
		lblCorreoElectrnico.setBounds(55, 264, 170, 25);
		panel.add(lblCorreoElectrnico);
		
		textCorreo = new JTextField();
		textCorreo.setColumns(10);
		textCorreo.setBounds(235, 264, 239, 25);
		panel.add(textCorreo);
		textCorreo.addFocusListener(new FocusListener() {

			public void focusGained(FocusEvent e) {				
			}
			public void focusLost(FocusEvent e) {
				if(isEmail(textCorreo.getText())) {
					lblCampoCorreo.setForeground(Color.GRAY);
					textCorreo.setBackground(new Color(240, 255, 240));
					correo = true;
				}
				else {
					lblCampoCorreo.setForeground(Color.RED);
					textCorreo.setBackground(new Color(255, 228, 225));
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
					textCorreo.setBackground(new Color(240, 255, 240));

					correo = true;
				}
				else {
					lblCampoCorreo.setForeground(Color.RED);
					textCorreo.setBackground(new Color(255, 228, 225));

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
					textCorreo.setBackground(new Color(240, 255, 240));

					correo = true;
				}
				else {
					lblCampoCorreo.setForeground(Color.RED);
					textCorreo.setBackground(new Color(255, 228, 225));

					correo = false;
				}
				if(!(textCorreo.getText().equals(""))) {
					if(existeUsuario(textCorreo.getText())) {
						correo = false;
						JOptionPane.showMessageDialog(null, "El correo ingresado ya existe en el sistema!");
						textCorreo.setBackground(new Color(255, 228, 225));

					}
				}
				else {
					textCorreo.setBackground(new Color(255, 228, 225));

					correo = false;
				}
				habilitarBoton();
				
			}
			
		});
		
		lblNombreDeUsuario = new JLabel("Nombre de usuario");
		lblNombreDeUsuario.setFont(new Font("Baskerville Old Face", Font.PLAIN, 16));
		lblNombreDeUsuario.setBounds(55, 319, 170, 25);
		panel.add(lblNombreDeUsuario);
		
		textUsuario = new JTextField();
		textUsuario.setColumns(10);
		textUsuario.setBounds(235, 319, 239, 25);
		panel.add(textUsuario);
		textUsuario.addKeyListener(new KeyListener() {
			
			public void keyTyped(KeyEvent evt) {
				char validar = evt.getKeyChar();
				
				if(Character.isDigit(validar) || validar == KeyEvent.VK_SPACE) {
					evt.consume();
					
					JOptionPane.showMessageDialog(null, "Campo 'Nombre de Usuario' debe contener solo caracteres no numéricos");
					lblCampoNombreUsuario.setForeground(Color.RED);
										
					nombreUsuario = false;

				}
				else {
					lblCampoNombreUsuario.setForeground(Color.GRAY);
					
				}
				if(8 <= textUsuario.getText().length()) {
					lblCaracteresUsuario.setVisible(false);
					textUsuario.setBackground(new Color(240, 255, 240));
					
					nombreUsuario = true;
				}
				else {
					nombreUsuario = false;
				}
				
				if (textUsuario.getText().length() < 8){
					lblCaracteresUsuario.setVisible(true);
					textUsuario.setBackground(new Color(255, 228, 225));
					
					nombreUsuario = false;
				}
				if(textUsuario.getText().equals("")) {
					textUsuario.setBackground(new Color(255, 228, 225));
					
					nombreUsuario = false;
				}
				habilitarBoton();

			}

			public void keyPressed(KeyEvent e) {
				habilitarBoton();

			}
			public void keyReleased(KeyEvent e) {
				char validar = e.getKeyChar();
				
				if(Character.isDigit(validar) || validar == KeyEvent.VK_SPACE) {
					e.consume();
					
					JOptionPane.showMessageDialog(null, "Campo 'Nombre de Usuario' debe contener solo caracteres no numéricos");
					lblCampoNombreUsuario.setForeground(Color.RED);
					textUsuario.setBackground(new Color(255, 228, 225));
					
					nombreUsuario = false;

				}
				else {
					lblCampoNombreUsuario.setForeground(Color.GRAY);
				}
				habilitarBoton();

			}
		});
		lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("Baskerville Old Face", Font.PLAIN, 16));
		lblContrasea.setBounds(55, 385, 170, 25);
		panel.add(lblContrasea);
		
		password = new JPasswordField();
		password.setBounds(235, 385, 239, 25);
		panel.add(password);
		password.addFocusListener(new FocusListener() {

			public void focusGained(FocusEvent e) {				
			}

			public void focusLost(FocusEvent e) {
				if(String.valueOf(password.getPassword()).length() < 8) {
					lblMinimo.setText("Min. caracteres: 8");
					lblMinimo.setVisible(true);
					
					password.setBackground(new Color(255, 228, 225));
					contrasenia = false;
				}
				else if (String.valueOf(password.getPassword()).length() >= 8){
					
					if(isPassword(String.valueOf(password.getPassword()))) {
						lblCampoPassword.setForeground(Color.GRAY);
						password.setBackground(new Color(240, 255, 240));
						
						contrasenia = true;
					}
					else {
						lblCampoPassword.setForeground(Color.RED);
						password.setBackground(new Color(255, 228, 225));
						
						contrasenia = false;
					}
				}
				
				if(String.valueOf(password.getPassword()).equals("")) {
					password.setBackground(new Color(255, 228, 225));
					
					contrasenia = false;
				}
				habilitarBoton();

			}
		});
		password.addKeyListener(new KeyListener() {

			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				String s = String.valueOf(c);
				
				if(!soloLoN(s)) {
					lblMinimo.setVisible(false);

				}
				else {
					e.consume();
					JOptionPane.showMessageDialog(null, "La contraseña debe contener: letras y números");
					password.setBackground(new Color(255, 228, 225));
					
					contrasenia = false;
				}
				if(String.valueOf(password.getPassword()).length() < 8) {
					lblMinimo.setText("Min. caracteres: 8");
					lblMinimo.setVisible(true);
					
					password.setBackground(new Color(255, 228, 225));
					contrasenia = false;
				}
				else if (String.valueOf(password.getPassword()).length() >= 8){
					
					if(isPassword(String.valueOf(password.getPassword()))) {
						lblCampoPassword.setForeground(Color.GRAY);
						password.setBackground(new Color(240, 255, 240));
						
						contrasenia = true;
					}
					else {
						lblCampoPassword.setForeground(Color.RED);
						password.setBackground(new Color(255, 228, 225));
						
						contrasenia = false;
					}
				}
				
				if(String.valueOf(password.getPassword()).equals("")) {
					contrasenia = false;
					password.setBackground(new Color(255, 228, 225));
				}
				
				habilitarBoton();

			}

			@Override
			public void keyPressed(KeyEvent e) {
				habilitarBoton();

			}

			@Override
			public void keyReleased(KeyEvent e) {
				char c = e.getKeyChar();
				String s = String.valueOf(c);
				
				if(String.valueOf(password.getPassword()).length() < 8) {
					lblMinimo.setText("Min. caracteres: 8");
					lblMinimo.setVisible(true);
					
					password.setBackground(new Color(255, 228, 225));
					contrasenia = false;
				}
				else if (String.valueOf(password.getPassword()).length() >= 8){
					
					if(isPassword(String.valueOf(password.getPassword()))) {
						lblCampoPassword.setForeground(Color.GRAY);
						password.setBackground(new Color(240, 255, 240));
						
						contrasenia = true;
					}
					else {
						lblCampoPassword.setForeground(Color.RED);
						password.setBackground(new Color(255, 228, 225));
						
						contrasenia = false;
					}
				}
				
				
				if(String.valueOf(password.getPassword()).equals("")) {
					password.setBackground(new Color(255, 228, 225));
					
					contrasenia = false;
				}
				if(!soloLoN(s)) {
					lblMinimo.setVisible(false);

				}
				else {
					e.consume();
					JOptionPane.showMessageDialog(null, "La contraseña debe contener: letras y números");
					password.setBackground(new Color(255, 228, 225));
					
					contrasenia = false;
				}
				habilitarBoton();
			}
			
		});
		
		lblRolDeUsuario = new JLabel("Rol de Usuario");
		lblRolDeUsuario.setFont(new Font("Baskerville Old Face", Font.PLAIN, 16));
		lblRolDeUsuario.setBounds(55, 446, 170, 25);
		panel.add(lblRolDeUsuario);
		
		comboBox = new JComboBox<Object>();
		comboBox.setFont(new Font("Baskerville Old Face", Font.PLAIN, 14));
		comboBox.setBackground(SystemColor.control);
		comboBox.setBounds(235, 446, 239, 25);
		panel.add(comboBox);
		comboBox.addItemListener(new ItemListener() {

			public void itemStateChanged(ItemEvent e) {
				if(comboBox.getSelectedItem().equals("")) {
					comboBox.setBackground(new Color(255, 228, 225));
				}
				else {
					comboBox.setBackground(new Color(240, 255, 240));
				}
			}
			
		});
		comboBox.addItem("");
		
		LinkedList<String> allRoles = new LinkedList<>();
		allRoles.add(model.Tipo_Rol.AFICIONADO.name());
		allRoles.add(model.Tipo_Rol.ADMINISTRADOR.name());
		allRoles.add(model.Tipo_Rol.INVESTIGADOR.name());

		for (String s: allRoles){
			comboBox.addItem(s);
		} 
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnIngresar.setBackground(new Color(173, 216, 230));
		btnIngresar.setBounds(500, 523, 170, 49);
		panel.add(btnIngresar);
		
		habilitarBoton();
		
		btnIngresar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			
			if(textNombre.getText().equals("")||textApellido.getText().equals("")||textCorreo.getText().equals("")||textUsuario.getText().equals("")||String.valueOf(password.getPassword()).equals("")
					|| isEmail(textCorreo.getText()) == false || comboBox.getSelectedItem().equals("")) {
				JOptionPane.showMessageDialog(null, "Se deben completar todos los campos obligatorios correctamente");

			}else {
				Boolean permitido = false;
				
				String n = textNombre.getText();
				String a = textApellido.getText();
				String c = textCorreo.getText();
				String nu = textUsuario.getText();
				String con = String.valueOf(password.getPassword());
				
				////////////////////////////////////////////////////////////////
				
				Usuario in = new Usuario();
				in.setNombre(n);
				in.setApellido(a);
				in.setMail(c);
				in.setNombreUsuario(nu);
				in.setContraseña(con);
				
				if(comboBox.getSelectedItem().equals("ADMINISTRADOR") || comboBox.getSelectedItem().equals("INVESTIGADOR")) {
					
					if(textCedula.getText().equals("") || !(textCedula.getText().length() == 8) || isCedula() == false || textDomicilio.getText().equals("") || comboBox_Ciudad.getSelectedItem().equals("")
							|| textTelefono.getText().equals("")) {
						
						JOptionPane.showMessageDialog(null, "Se deben completar todos los campos obligatorios correctamente");
						permitido = false;
					}
					else {
						permitido = true;
					}
					
					if(permitido == true) {
						int ce = Integer.parseInt(textCedula.getText());
						int te = Integer.parseInt(textTelefono.getText());
						String dom = textDomicilio.getText();
						String ci = (String) comboBox_Ciudad.getSelectedItem();
						
						Ciudad ciudad = null;
						
						try {
							String dato3 = "PDT_EJB/Ciudad_Bean!com.servicios.Ciudad_BeanRemote";
							Ciudad_BeanRemote ciu = (Ciudad_BeanRemote) InitialContext.doLookup(dato3);
							ciudad = ciu.findCiudadNombre(ci);
							
						} catch(NamingException ex) {
							ex.getMessage();
						}
						
						if(comboBox.getSelectedItem().equals("INVESTIGADOR")) {	
							try {
								String dato = "PDT_EJB/Usuario_Bean!com.servicios.Usuario_BeanRemote";
								Usuario_BeanRemote us = (Usuario_BeanRemote) InitialContext.doLookup(dato);
								
								if(us.insert(in)) {
									in = us.findUsuarioMail(c);
									
									Investigador inves = new Investigador(in,ce,dom,te,ciudad,Tipo_Rol.INVESTIGADOR);
									
									try {
										String dato2 = "PDT_EJB/Investigador_Bean!com.servicios.Investigador_BeanRemote";
										Investigador_BeanRemote i = (Investigador_BeanRemote) InitialContext.doLookup(dato2);
										
										if(i.insert(inves)) {
											JOptionPane.showMessageDialog(null, "Investigador guardado exitosamente");
											limpiar();
										}
										else {
											JOptionPane.showMessageDialog(null, "No es posible añadir este Investigador");
										}
									} catch(NamingException | ServiciosException ex) {
										ex.getMessage();
									}		
								}
								else {
									JOptionPane.showMessageDialog(null, "No es posible añadir este registro");
								}
							}catch(Exception ex) {
								JOptionPane.showMessageDialog(null, "No es posible añadir este registro");
							}
						}
						else if(comboBox.getSelectedItem().equals("ADMINISTRADOR")) {	
							try {
								String dato = "PDT_EJB/Usuario_Bean!com.servicios.Usuario_BeanRemote";
								Usuario_BeanRemote us = (Usuario_BeanRemote) InitialContext.doLookup(dato);
								
								if(us.insert(in)) {
									in = us.findUsuarioMail(c);
									
									Administrador admin = new Administrador(in, ce,dom,te,Tipo_Rol.ADMINISTRADOR,ciudad);
									
									try {
										String dato2 = "PDT_EJB/Administrador_Bean!com.servicios.Administrador_BeanRemote";
										Administrador_BeanRemote ad = (Administrador_BeanRemote) InitialContext.doLookup(dato2);
										
										if(ad.insert(admin)) {
											JOptionPane.showMessageDialog(null, "Administrador guardado exitosamente");
											limpiar();
										}
										else {
											JOptionPane.showMessageDialog(null, "No es posible añadir este Investigador");
										}
									} catch(NamingException | ServiciosException ex) {
										ex.getMessage();
									}	
								}
								else {
									JOptionPane.showMessageDialog(null, "No es posible añadir este registro");
								}
							}catch(Exception ex) {
								JOptionPane.showMessageDialog(null, "No es posible añadir este registro");
							}
						}
					}
						
				}
				else if(comboBox.getSelectedItem().equals("AFICIONADO")) {
					
					if(textOcupacion.getText().equals("")) {
						
						JOptionPane.showMessageDialog(null, "Se deben completar todos los campos obligatorios");
						permitido = false;
					}
					else {
						permitido = true;
					}
					
					if(permitido = true) {
						String oc = textOcupacion.getText();
						
						try {
							String dato = "PDT_EJB/Usuario_Bean!com.servicios.Usuario_BeanRemote";
							Usuario_BeanRemote us = (Usuario_BeanRemote) InitialContext.doLookup(dato);
							
							if(us.insert(in)) {
								in = us.findUsuarioMail(c);
								
								Aficionado af = new Aficionado(in, oc, Tipo_Rol.AFICIONADO);
								
								try {
									String dato2 = "PDT_EJB/Aficionado_Bean!com.servicios.Aficionado_BeanRemote";
									Aficionado_BeanRemote afi = (Aficionado_BeanRemote) InitialContext.doLookup(dato2);
									
									if(afi.insert(af)) {
										JOptionPane.showMessageDialog(null, "Aficionado guardado exitosamente");
										limpiar();
									}
									else {
										JOptionPane.showMessageDialog(null, "No es posible añadir este Investigador");
									}
								} catch(NamingException | ServiciosException ex) {
									ex.getMessage();
								}	
							}
							else {
								JOptionPane.showMessageDialog(null, "No es posible añadir este registro");
							}
						}catch(Exception ex) {
							JOptionPane.showMessageDialog(null, "No es posible añadir este registro");
						}
					}
					
				}else {
					permitido = false;
				}
			}
			}
		});
		
		textOcupacion = new JTextField();
		textOcupacion.setColumns(10);
		textOcupacion.setBounds(710, 156, 239, 25);
		panel.add(textOcupacion);
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
					textOcupacion.setBackground(new Color(240, 255, 240));

					ocupacion = true;
				}
				if(textOcupacion.getText().equals("")) {
					textOcupacion.setBackground(new Color(255, 228, 225));

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

		lblOcupacion = new JLabel("Ocupación");
		lblOcupacion.setFont(new Font("Baskerville Old Face", Font.PLAIN, 16));
		lblOcupacion.setBounds(530, 156, 170, 25);
		panel.add(lblOcupacion);
		lblOcupacion.setVisible(false);
		
		
		//////////////////////////////////
		textCedula = new JTextField();
		textCedula.setColumns(10);
		textCedula.setBounds(710, 156, 239, 25);
		panel.add(textCedula);
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
					
					if(!isCedula()) {
						JOptionPane.showMessageDialog(null, "La Cédula ingresada es incorrecta");	
						textCedula.setBackground(new Color(255, 228, 225));

						cedula = false;
					}
					else {
						int ci = Integer.parseInt(textCedula.getText());
						if(existeInveAdmin(ci)) {
							cedula = false;
							JOptionPane.showMessageDialog(null, "La Cédula ingresada ya existe en el sistema!");
							textCedula.setBackground(new Color(255, 228, 225));

						}
						else {
							textCedula.setBackground(new Color(240, 255, 240));
							
							cedula = true;
						}
					}
				}
				
				else if (textCedula.getText().length() < 8){
					lblMaximo.setVisible(true);
					textCedula.setBackground(new Color(255, 228, 225));

					cedula = false;
				}
				
				if((textCedula.getText().equals(""))) {
					textCedula.setBackground(new Color(255, 228, 225));

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
					
					if(!isCedula()) {
						JOptionPane.showMessageDialog(null, "La Cédula ingresada es incorrecta");	
						textCedula.setBackground(new Color(255, 228, 225));

						cedula = false;
					}
					else {
						
						int ci = Integer.parseInt(textCedula.getText());
						if(existeInveAdmin(ci)) {
							cedula = false;
							JOptionPane.showMessageDialog(null, "La Cédula ingresada ya existe en el sistema!");
							textCedula.setBackground(new Color(255, 228, 225));
						}
						else {
							textCedula.setBackground(new Color(240, 255, 240));
							
							cedula = true;
						}
					}

				}
				else if (textCedula.getText().length() < 8){
					lblMaximo.setVisible(true);
					textCedula.setBackground(new Color(255, 228, 225));
					
					habilitarBoton();
					cedula = false;

				}
				
				if((textCedula.getText().equals(""))) {
					textCedula.setBackground(new Color(255, 228, 225));

					cedula = false;
				}
				habilitarBoton();

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

					cedula = false;
					habilitarBoton();
				}
				else if(textCedula.getText().length() == 8) {
					lblMaximo.setVisible(false);
					
					if(!isCedula()) {
						textCedula.setBackground(new Color(255, 228, 225));

						cedula = false;
					}
					else {
						textCedula.setBackground(new Color(240, 255, 240));

						cedula = true;
					}

				}
				if(!(textCedula.getText().equals(""))) {
					int ci = Integer.parseInt(textCedula.getText());
					if(existeInveAdmin(ci)) {
						cedula = false;
						textCedula.setBackground(new Color(255, 228, 225));

						textCedula.setText("");
					}
					else {
						textCedula.setBackground(new Color(240, 255, 240));

						cedula = true;
					}
				}
				else {
					textCedula.setBackground(new Color(255, 228, 225));

					cedula = false;
				}
				habilitarBoton();

			}			
		});
		
		lblCedula = new JLabel("C\u00E9dula");
		lblCedula.setFont(new Font("Baskerville Old Face", Font.PLAIN, 16));
		lblCedula.setBounds(530, 156, 170, 25);
		panel.add(lblCedula);
		lblCedula.setVisible(false);

		lblCiudad = new JLabel("Ciudad");
		lblCiudad.setFont(new Font("Baskerville Old Face", Font.PLAIN, 16));
		lblCiudad.setBounds(530, 209, 170, 25);
		panel.add(lblCiudad);
		lblCiudad.setVisible(false);

		textTelefono = new JTextField();
		textTelefono.setColumns(10);
		textTelefono.setBounds(710, 319, 239, 25);
		panel.add(textTelefono);
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
					textTelefono.setBackground(new Color(240, 255, 240));

					telefono = true;

				}
				if(textTelefono.getText().equals("")) {
					textTelefono.setBackground(new Color(255, 228, 225));

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
		lblTelefono = new JLabel("Tel\u00E9fono");
		lblTelefono.setFont(new Font("Baskerville Old Face", Font.PLAIN, 16));
		lblTelefono.setBounds(530, 319, 170, 25);
		panel.add(lblTelefono);
		lblTelefono.setVisible(false);
		

		comboBox_Ciudad = new JComboBox<Object>();
		comboBox_Ciudad.setBackground(SystemColor.menu);
		comboBox_Ciudad.setBounds(710, 211, 239, 23);
		comboBox_Ciudad.setFont(new Font("Baskerville Old Face", Font.PLAIN, 14));
		comboBox_Ciudad.setVisible(false);
		comboBox_Ciudad.addItem("");
		panel.add(comboBox_Ciudad);
		comboBox_Ciudad.addItemListener(new ItemListener() {

			public void itemStateChanged(ItemEvent e) {
				if(comboBox_Ciudad.getSelectedItem().equals("")) {
					comboBox_Ciudad.setBackground(new Color(255, 228, 225));

					ciudad = false;
				}
				else {
					comboBox_Ciudad.setBackground(new Color(240, 255, 240));
					ciudad = true;
				}
				habilitarBoton();

			}
			
		});
		
		lblNewLabel_1 = new JLabel("*");
		lblNewLabel_1.setBounds(30, 156, 15, 13);
		panel.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("*");
		lblNewLabel_2.setBounds(30, 209, 15, 13);
		panel.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("*");
		lblNewLabel_3.setBounds(30, 264, 15, 13);
		panel.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("*");
		lblNewLabel_4.setBounds(30, 319, 15, 13);
		panel.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("*");
		lblNewLabel_5.setBounds(30, 385, 15, 13);
		panel.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("*");
		lblNewLabel_6.setBounds(30, 446, 15, 13);
		panel.add(lblNewLabel_6);
		
		lbl1 = new JLabel("*");
		lbl1.setBounds(505, 156, 15, 13);
		panel.add(lbl1);
		lbl1.setVisible(false);
		
		lbl2 = new JLabel("*");
		lbl2.setBounds(505, 209, 15, 13);
		panel.add(lbl2);
		lbl2.setVisible(false);

		lbl3 = new JLabel("*");
		lbl3.setBounds(505, 319, 15, 13);
		panel.add(lbl3);
		lbl3.setVisible(false);
		
		lblCamposObligatorios = new JLabel("Campos obligatorios *");
		lblCamposObligatorios.setFont(new Font("Baskerville Old Face", Font.PLAIN, 12));
		lblCamposObligatorios.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCamposObligatorios.setForeground(Color.GRAY);
		lblCamposObligatorios.setBounds(312, 99, 162, 19);
		panel.add(lblCamposObligatorios);
		
		textDomicilio = new JTextField();
		textDomicilio.setColumns(10);
		textDomicilio.setBounds(710, 264, 239, 25);
		panel.add(textDomicilio);
		textDomicilio.setVisible(false);
		textDomicilio.addKeyListener(new KeyListener() {

			public void keyTyped(KeyEvent e) {
				char validar = e.getKeyChar();
				
				if(((Character.isAlphabetic(validar)) || (Character.isDigit(validar))) || validar == KeyEvent.VK_BACK_SPACE || validar == KeyEvent.VK_SPACE) {
					textDomicilio.setBackground(new Color(240, 255, 240));
					domicilio = true;
					
				}
				else {
					e.consume();
					JOptionPane.showMessageDialog(null, "El domicilio puede contener: letras y números");
					
					domicilio = false;
				}
				if(textDomicilio.getText().equals("")) {
					textDomicilio.setBackground(new Color(255, 228, 225));

					domicilio = false;
				}
				habilitarBoton();

			}

			@Override
			public void keyPressed(KeyEvent e) {
				habilitarBoton();

			}

			public void keyReleased(KeyEvent e) {
				char validar = e.getKeyChar();
				
				if(((Character.isAlphabetic(validar)) || (Character.isDigit(validar))) || validar == KeyEvent.VK_BACK_SPACE || validar == KeyEvent.VK_SPACE)  {
					textDomicilio.setBackground(new Color(240, 255, 240));

					domicilio = true;
				}
				else {
					e.consume();
					
					domicilio = false;
				}
				if(textDomicilio.getText().equals("")) {
					textDomicilio.setBackground(new Color(255, 228, 225));

					domicilio = false;
				}
				habilitarBoton();

			}
			
		});;
		
		lblDomicilio = new JLabel("Domicilio");
		lblDomicilio.setFont(new Font("Baskerville Old Face", Font.PLAIN, 16));
		lblDomicilio.setBounds(530, 264, 170, 25);
		panel.add(lblDomicilio);
		lblDomicilio.setVisible(false);

		lbl4 = new JLabel("*");
		lbl4.setBounds(505, 264, 15, 13);
		panel.add(lbl4);
		lbl4.setVisible(false);
		
		
		
		btnLimpiar = new JButton("Limpiar/Cancelar");
		btnLimpiar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLimpiar.setBackground(SystemColor.menu);
		btnLimpiar.setBounds(710, 523, 170, 49);
		panel.add(btnLimpiar);
		
		lblCampoCedula = new JLabel("C\u00E9dula sin puntos o guiones. Formato: 12345678");
		lblCampoCedula.setFont(new Font("Baskerville Old Face", Font.PLAIN, 12));
		lblCampoCedula.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCampoCedula.setForeground(Color.GRAY);
		lblCampoCedula.setBounds(674, 134, 275, 19);
		panel.add(lblCampoCedula);
		lblCampoCedula.setVisible(false);

		lblCampoTelefono = new JLabel("Tel\u00E9fono solo num\u00E9rico");
		lblCampoTelefono.setFont(new Font("Baskerville Old Face", Font.PLAIN, 12));
		lblCampoTelefono.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCampoTelefono.setForeground(Color.GRAY);
		lblCampoTelefono.setBounds(674, 299, 275, 19);
		panel.add(lblCampoTelefono);
		lblCampoTelefono.setVisible(false);
		
		lblCampoNombreUsuario = new JLabel("Usuario solo con caracteres no num\u00E9ricos");
		lblCampoNombreUsuario.setFont(new Font("Baskerville Old Face", Font.PLAIN, 12));
		lblCampoNombreUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCampoNombreUsuario.setForeground(Color.GRAY);
		lblCampoNombreUsuario.setBounds(199, 299, 275, 19);
		panel.add(lblCampoNombreUsuario);

		lblCampoCorreo = new JLabel("Debe contener @ y .com");
		lblCampoCorreo.setFont(new Font("Baskerville Old Face", Font.PLAIN, 12));
		lblCampoCorreo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCampoCorreo.setForeground(Color.GRAY);
		lblCampoCorreo.setBounds(199, 244, 275, 19);
		panel.add(lblCampoCorreo);
		
		lblMaximo = new JLabel("Caracteres obligatorios: 8");
		lblMaximo.setFont(new Font("Baskerville Old Face", Font.PLAIN, 11));
		lblMaximo.setForeground(Color.RED);
		lblMaximo.setBounds(710, 175, 129, 23);
		panel.add(lblMaximo);
		lblMaximo.setVisible(false);

		lblMinimo = new JLabel("Min. caracteres: 8");
		lblMinimo.setForeground(Color.RED);
		lblMinimo.setFont(new Font("Baskerville Old Face", Font.PLAIN, 11));
		lblMinimo.setBounds(235, 405, 101, 23);
		panel.add(lblMinimo);
		lblMinimo.setVisible(false);

		lblCaracteresUsuario = new JLabel("Min. caracteres: 8");
		lblCaracteresUsuario.setForeground(Color.RED);
		lblCaracteresUsuario.setFont(new Font("Baskerville Old Face", Font.PLAIN, 11));
		lblCaracteresUsuario.setBounds(235, 338, 136, 23);
		panel.add(lblCaracteresUsuario);
		lblCaracteresUsuario.setVisible(false);

		lblCampoPassword = new JLabel("Contrase\u00F1a debe contener n\u00FAmeros y letras");
		lblCampoPassword.setHorizontalAlignment(SwingConstants.TRAILING);
		lblCampoPassword.setForeground(Color.GRAY);
		lblCampoPassword.setFont(new Font("Baskerville Old Face", Font.PLAIN, 12));
		lblCampoPassword.setBounds(199, 354, 275, 42);
		panel.add(lblCampoPassword);


		btnLimpiar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				limpiar();
				habilitarBoton();
			}
		});

		List<Ciudad> allCiudades = new LinkedList<>();
		try {
			String dato3 = "PDT_EJB/Ciudad_Bean!com.servicios.Ciudad_BeanRemote";
			Ciudad_BeanRemote ciu = (Ciudad_BeanRemote) InitialContext.doLookup(dato3);
			allCiudades = ciu.allCiudades();
			
		} catch(NamingException ex) {
			ex.getMessage();
		}
		for(Ciudad c : allCiudades) {
			comboBox_Ciudad.addItem(c.getNombre());
		}
		comboBox.addItemListener(new ItemListener(){
			
			//Control de campos: aparecerán solo los que correspondan
			public void  itemStateChanged(ItemEvent e) {
				String a = (String) comboBox.getSelectedItem();
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

					rol = true;
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

					rol = true;

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

					rol = false;

				}
				habilitarBoton();

			}
		});
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
	public boolean soloLoN(String validar) {
		
		Pattern p = Pattern.compile("/^[a-z0-9]+$/gi");
		
		Matcher m = p.matcher(validar);
		
		if (m.find())
		{
		   return true;
		}else
		{
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
 	public void limpiar() {
		lblMaximo.setVisible(false);
		lblCaracteresUsuario.setVisible(false);
		lblMinimo.setVisible(false);
		lblCampoCorreo.setForeground(Color.GRAY);
		lblCampoTelefono.setForeground(Color.GRAY);
		lblCampoNombreUsuario.setForeground(Color.GRAY);
		lblCampoPassword.setForeground(Color.GRAY);

		textNombre.setText("");
		textApellido.setText("");
		textCorreo.setText("");
		textUsuario.setText("");
		password.setText("");
		
		textNombre.setBackground(Color.WHITE);
		textApellido.setBackground(Color.WHITE);
		textCorreo.setBackground(Color.WHITE);
		textUsuario.setBackground(Color.WHITE);
		password.setBackground(Color.WHITE);
		
			textDomicilio.setText("");
			textCedula.setText("");
			textTelefono.setText("");
			comboBox_Ciudad.setSelectedItem("");
		
			textOcupacion.setText("");
		
			textDomicilio.setBackground(Color.WHITE);
			textCedula.setBackground(Color.WHITE);
			textTelefono.setBackground(Color.WHITE);
			comboBox_Ciudad.setBackground(Color.WHITE);
			
			textOcupacion.setBackground(Color.WHITE);

		comboBox.setSelectedItem("");
	}
	public boolean isOcho() {
		if(textCedula.getText().length() < 8) {
			return true;
		}
		return false;
	}
	public static boolean isPassword(String password) {
		char [] cadena = password.toCharArray();
		boolean l = false;
		boolean n = false;
		
		for(int i = 0; i< cadena.length; i++) {
			if(Character.isDigit(cadena[i]))
				n = true;
			if(Character.isAlphabetic(cadena[i]))
				l = true;
		}
		if(l==true && n == true)
			return true;
		else {
			return false;
		}
	}
	public void habilitarBoton() {
		if(nombre && apellido && nombreUsuario && correo && contrasenia && rol) {
			String a = (String) comboBox.getSelectedItem();
			if(a.equals("ADMINISTRADOR") || a.equals("INVESTIGADOR")) {
				
				if(cedula && domicilio && telefono && ciudad) {
					btnIngresar.setEnabled(true);
				}
				else {
					btnIngresar.setEnabled(false);
				}
			}
			else if(a.equals("AFICIONADO")) {
				if(ocupacion) {
					btnIngresar.setEnabled(true);
				}
				else {
					btnIngresar.setEnabled(false);
				}
			}
			else {
				btnIngresar.setEnabled(false);
			}
		}
		else {
			btnIngresar.setEnabled(false);
		}
	}
	
	public boolean existeUsuario(String mail) {
		
		Usuario user = null;
		
		try {
			String dato = "PDT_EJB/Usuario_Bean!com.servicios.Usuario_BeanRemote";
			Usuario_BeanRemote us = (Usuario_BeanRemote) InitialContext.doLookup(dato);
			user = us.findUsuarioMail(mail);
		
		} catch(NamingException | ServiciosException ex) {
			ex.getMessage();
		}	
		
		if(user==null) {
			return false;
		}
		else {
			return true;
		}
	}
	public static boolean existeInveAdmin(int cedula) {
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
		
		if(admin != null || inve != null) {
			existe = true;
		}
		else {
			existe = false;
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
	
}
