package vista_desplegables;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Rectangle;

import javax.swing.JPanel;
import javax.swing.JLabel;

public class Listado_Usuarios extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel panel;
	public static String Listado_Usuario;
	private JLabel lblNewLabel;

	
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
		
		lblNewLabel = new JLabel("*Listado usuarios*");
		lblNewLabel.setBounds(72, 47, 152, 13);
		panel.add(lblNewLabel);
	}
}
