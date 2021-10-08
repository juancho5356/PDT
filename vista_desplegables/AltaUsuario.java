package vista_desplegables;

import javax.swing.JPanel;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.CardLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import java.awt.SystemColor;
import java.util.*;
import javax.swing.JButton;

public class AltaUsuario extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel panel;
	
	public static String Usuario;
	
	private JTextField textField;
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JTextField textField_1;
	private JLabel lblCorreoElectrnico;
	private JTextField textField_2;
	private JLabel lblNombreDeUsuario;
	private JTextField textField_3;
	private JLabel lblContrasea;
	private JPasswordField passwordField;
	private JLabel lblNewLabel;
	private JLabel lblRolDeUsuario;
	private JComboBox<Object> comboBox;
	private JPanel extra;
	private JTextField textField_4;
	private JLabel lblCedula;
	private JLabel lblCiudad;
	private JTextField textField_5;
	private JTextField textField_6;
	private JLabel lblTelefono;
	private JButton btnIngresar;


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
		
		textField = new JTextField();
		textField.setBounds(235, 156, 239, 25);
		panel.add(textField);
		textField.setColumns(10);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Baskerville Old Face", Font.PLAIN, 16));
		lblNombre.setBounds(55, 156, 170, 25);
		panel.add(lblNombre);
		
		lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Baskerville Old Face", Font.PLAIN, 16));
		lblApellido.setBounds(55, 209, 170, 25);
		panel.add(lblApellido);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(235, 209, 239, 25);
		panel.add(textField_1);
		
		lblCorreoElectrnico = new JLabel("Correo electr\u00F3nico");
		lblCorreoElectrnico.setFont(new Font("Baskerville Old Face", Font.PLAIN, 16));
		lblCorreoElectrnico.setBounds(55, 264, 170, 25);
		panel.add(lblCorreoElectrnico);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(235, 264, 239, 25);
		panel.add(textField_2);
		
		lblNombreDeUsuario = new JLabel("Nombre de usuario");
		lblNombreDeUsuario.setFont(new Font("Baskerville Old Face", Font.PLAIN, 16));
		lblNombreDeUsuario.setBounds(55, 319, 170, 25);
		panel.add(lblNombreDeUsuario);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(235, 319, 239, 25);
		panel.add(textField_3);
		
		lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("Baskerville Old Face", Font.PLAIN, 16));
		lblContrasea.setBounds(55, 379, 170, 25);
		panel.add(lblContrasea);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(235, 379, 239, 25);
		panel.add(passwordField);
		
		lblNewLabel = new JLabel("Alta de usuario");
		lblNewLabel.setFont(new Font("Baskerville Old Face", Font.ITALIC, 27));
		lblNewLabel.setBounds(55, 87, 275, 31);
		panel.add(lblNewLabel);
		
		lblRolDeUsuario = new JLabel("Rol de Usuario");
		lblRolDeUsuario.setFont(new Font("Baskerville Old Face", Font.PLAIN, 16));
		lblRolDeUsuario.setBounds(55, 446, 170, 25);
		panel.add(lblRolDeUsuario);
		
		comboBox = new JComboBox<Object>();
		comboBox.setFont(new Font("Baskerville Old Face", Font.PLAIN, 14));
		comboBox.setBackground(SystemColor.control);
		comboBox.setBounds(235, 446, 239, 25);
		panel.add(comboBox);
		
		LinkedList<String> allRoles = new LinkedList<>();
		allRoles.add(modelo.Tipo_Rol.AFICIONADO.name());
		allRoles.add(modelo.Tipo_Rol.ADMINISTRADOR.name());
		allRoles.add(modelo.Tipo_Rol.INVESTIGADOR.name());

		for (String s: allRoles){
			comboBox.addItem(s);
		} 
		
		extra = new JPanel();
		extra.setBorder(null);
		extra.setBackground(Color.WHITE);
		extra.setBounds(500, 108, 475, 363);
		panel.add(extra);
		extra.setLayout(null);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(190, 47, 239, 25);
		extra.add(textField_4);
		
		lblCedula = new JLabel("C\u00E9dula");
		lblCedula.setFont(new Font("Baskerville Old Face", Font.PLAIN, 16));
		lblCedula.setBounds(10, 47, 170, 25);
		extra.add(lblCedula);
		
		lblCiudad = new JLabel("Ciudad");
		lblCiudad.setFont(new Font("Baskerville Old Face", Font.PLAIN, 16));
		lblCiudad.setBounds(10, 100, 170, 25);
		extra.add(lblCiudad);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(190, 100, 239, 25);
		extra.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(190, 155, 239, 25);
		extra.add(textField_6);
		
		lblTelefono = new JLabel("Tel\u00E9fono");
		lblTelefono.setFont(new Font("Baskerville Old Face", Font.PLAIN, 16));
		lblTelefono.setBounds(10, 155, 170, 25);
		extra.add(lblTelefono);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.setBackground(SystemColor.menu);
		btnIngresar.setBounds(500, 523, 170, 49);
		panel.add(btnIngresar);
		
		
		
		
		
		
	}
}
