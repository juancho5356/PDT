package vista_desplegables;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Rectangle;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class AltaEstacion extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel panel;

	private JLabel lblNewLabel;
	public static String Alta_Estacion;

	
	/**
	 * Create the panel.
	 */
	public AltaEstacion() {
		Alta_Estacion = "Alta_Estacion";

		
		setBounds(new Rectangle(0, 0, 985, 658));
		setLayout(new CardLayout(0, 0));
		
		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		add(panel, "name_25541786307800");
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("*Alta Estacion*");
		lblNewLabel.setBounds(72, 47, 152, 13);
		panel.add(lblNewLabel);
	}

}
