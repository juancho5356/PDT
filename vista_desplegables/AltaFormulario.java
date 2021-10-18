package Vista.vista_desplegables;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Rectangle;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JTextField;

public class AltaFormulario extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel panel;
	public static String Alta_Formulario;
	private JTextField textNombre;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	
	/**
	 * Create the panel.
	 */
	public AltaFormulario() {
		Alta_Formulario = "Alta_Formulario";

		
		setBounds(new Rectangle(0, 0, 985, 658));
		setLayout(new CardLayout(0, 0));
		
		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		add(panel, "name_25541786307800");
		panel.setLayout(null);
		
		JLabel lblAltaDeFormulario = new JLabel("Alta de Formulario");
		lblAltaDeFormulario.setFont(new Font("Baskerville Old Face", Font.ITALIC, 27));
		lblAltaDeFormulario.setBounds(59, 44, 275, 31);
		panel.add(lblAltaDeFormulario);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Baskerville Old Face", Font.PLAIN, 16));
		lblNombre.setBounds(59, 133, 170, 25);
		panel.add(lblNombre);
		
		JLabel lblNewLabel_1 = new JLabel("*");
		lblNewLabel_1.setBounds(35, 133, 15, 13);
		panel.add(lblNewLabel_1);
		
		textNombre = new JTextField();
		textNombre.setColumns(10);
		textNombre.setBounds(218, 133, 239, 25);
		panel.add(textNombre);
		
		JLabel lblNewLabel_1_1 = new JLabel("*");
		lblNewLabel_1_1.setBounds(35, 188, 15, 13);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setFont(new Font("Baskerville Old Face", Font.PLAIN, 16));
		lblFecha.setBounds(59, 188, 170, 25);
		panel.add(lblFecha);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(218, 188, 239, 25);
		panel.add(textField);
		
		JLabel lblHora = new JLabel("Hora");
		lblHora.setFont(new Font("Baskerville Old Face", Font.PLAIN, 16));
		lblHora.setBounds(59, 244, 170, 25);
		panel.add(lblHora);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("*");
		lblNewLabel_1_1_1.setBounds(35, 244, 15, 13);
		panel.add(lblNewLabel_1_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(218, 244, 239, 25);
		panel.add(textField_1);
		
		JLabel lblUbicacin = new JLabel("Ubicaci\u00F3n");
		lblUbicacin.setFont(new Font("Baskerville Old Face", Font.PLAIN, 16));
		lblUbicacin.setBounds(59, 300, 170, 25);
		panel.add(lblUbicacin);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("*");
		lblNewLabel_1_1_1_1.setBounds(35, 300, 15, 13);
		panel.add(lblNewLabel_1_1_1_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(218, 300, 239, 25);
		panel.add(textField_2);
		
		JLabel lblCasillas = new JLabel("Casillas");
		lblCasillas.setFont(new Font("Baskerville Old Face", Font.PLAIN, 16));
		lblCasillas.setBounds(59, 359, 170, 25);
		panel.add(lblCasillas);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("*");
		lblNewLabel_1_1_1_1_1.setBounds(35, 359, 15, 13);
		panel.add(lblNewLabel_1_1_1_1_1);
	}
}
