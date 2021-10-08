package vista_desplegables;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Rectangle;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Listado_Formularios extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel panel;

	private JLabel lblNewLabel;
	public static String Listado_Formularios;

	
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
		
		lblNewLabel = new JLabel("*Listado formularios*");
		lblNewLabel.setBounds(72, 47, 152, 13);
		panel.add(lblNewLabel);
	}

}
