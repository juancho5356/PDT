package vista_desplegables;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class Mostrar_Estacion extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mostrar_Estacion frame = new Mostrar_Estacion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Mostrar_Estacion() {
		setBounds(100, 100, 450, 300);

	}

}
