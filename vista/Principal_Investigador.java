package Vista.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Vista.vista_desplegables.*;

import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JDesktopPane;
import javax.swing.SwingConstants;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.sql.SQLException;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;


public class Principal_Investigador extends JFrame implements MouseListener, MouseMotionListener {
	

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private JPanel sidePane;
	private JPanel barra;
	private JLabel lblUser;
	private JButton btnCerrarSesion;
	private JSeparator separator;
	private JLabel lblLinea;
	private JLabel lblGestionDeFormularios;
	private JButton btnCrearNuevoFormulario;
	private JButton btnListarFormularios;
	private JLabel lblGestinDeEstaciones;
	private JButton btnCrearNuevaEstacion;
	private JButton btnListarEstaciones;
	private JButton btnCrearNuevaCasilla;
	public  JLabel lblNombreUser;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal_Investigador frame = new Principal_Investigador();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	int xMouse, yMouse; 

	String f = AltaFormulario.Alta_Formulario;
	String lf = Listado_Formularios.Listado_Formularios;
	
	String es = AltaEstacion.Alta_Estacion;
	String le = Listado_Estaciones.Listado_Estaciones;
	
	String c = AltaCasilla.Alta_Casilla;
	
	public static JDesktopPane principal_investigador;
	/**
	 * Create the frame.
	 */
	public Principal_Investigador() {
		
		Listado_Estaciones listadoEsta = new Listado_Estaciones();
		AltaFormulario creaForm = new AltaFormulario();
		Listado_Formularios listadoform = new Listado_Formularios();
		AltaCasilla creaCasilla = new AltaCasilla();
		AltaEstacion creaEstacion = new AltaEstacion();
		
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1345, 735);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panel = new JPanel();
		panel.setBackground(SystemColor.window);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		sidePane = new JPanel();
		sidePane.setBounds(0, 0, 349, 725);
		sidePane.setBackground(Color.DARK_GRAY);
		panel.add(sidePane);
		sidePane.setLayout(null);
		
		lblUser = new JLabel("");
		lblUser.setIcon(new ImageIcon(Principal.class.getResource("/Vista/image/user.png")));
		lblUser.setBounds(20, 0, 52, 68);
		sidePane.add(lblUser);
		
		btnCerrarSesion = new JButton("Cerrar Sesi\u00F3n");
		btnCerrarSesion.addMouseListener(this);
		btnCerrarSesion.setBorder(null);
		btnCerrarSesion.setForeground(Color.WHITE);
		btnCerrarSesion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCerrarSesion.setBackground(Color.DARK_GRAY);
		btnCerrarSesion.setBounds(231, 30, 95, 32);
		sidePane.add(btnCerrarSesion);
		
		separator = new JSeparator();
		separator.setForeground(Color.WHITE);
		separator.setBounds(10, 66, 329, 2);
		sidePane.add(separator);
		
		lblLinea = new JLabel("En l\u00EDnea");
		lblLinea.setForeground(new Color(0, 255, 127));
		lblLinea.setBounds(77, 24, 87, 46);
		sidePane.add(lblLinea);
		
		lblGestionDeFormularios = new JLabel("Gestion de Formularios");
		lblGestionDeFormularios.setForeground(Color.WHITE);
		lblGestionDeFormularios.setFont(new Font("Baskerville Old Face", Font.PLAIN, 18));
		lblGestionDeFormularios.setBounds(10, 90, 297, 46);
		sidePane.add(lblGestionDeFormularios);
		
		btnCrearNuevoFormulario = new JButton("Crear nuevo Formulario");
		btnCrearNuevoFormulario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCrearNuevoFormulario.setHorizontalAlignment(SwingConstants.LEADING);
		btnCrearNuevoFormulario.setForeground(Color.LIGHT_GRAY);
		btnCrearNuevoFormulario.setFont(new Font("Baskerville Old Face", Font.PLAIN, 14));
		btnCrearNuevoFormulario.setBackground(Color.GRAY);
		btnCrearNuevoFormulario.setBounds(0, 133, 349, 32);
		sidePane.add(btnCrearNuevoFormulario);
		btnCrearNuevoFormulario.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if(f==null) {
					if(!creaForm.isVisible() || !creaForm.isValid()) {
						principal_investigador.add(creaForm);
						creaForm.setVisible(true);
					}
				}
				if(creaEstacion.isVisible()) {
					principal_investigador.remove(creaEstacion);
					creaEstacion.setVisible(false);
					es=null;
				}
				
				if(creaCasilla.isVisible()) {
					principal_investigador.remove(creaCasilla);
					creaCasilla.setVisible(false);
					c=null;
				}
				if(listadoEsta.isVisible()) {
					principal_investigador.remove(listadoEsta);
					listadoEsta.setVisible(false);
					le=null;
				}
				if(listadoform.isVisible()) {
					principal_investigador.remove(listadoform);
					listadoform.setVisible(false);
					lf=null;
				}
			}
			
		});
		
		btnListarFormularios = new JButton("Listar Formularios");
		btnListarFormularios.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnListarFormularios.setHorizontalAlignment(SwingConstants.LEADING);
		btnListarFormularios.setForeground(Color.LIGHT_GRAY);
		btnListarFormularios.setFont(new Font("Baskerville Old Face", Font.PLAIN, 14));
		btnListarFormularios.setBackground(Color.GRAY);
		btnListarFormularios.setBounds(0, 166, 349, 32);
		sidePane.add(btnListarFormularios);
		btnListarFormularios.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if(lf==null) {
					if(!listadoform.isVisible() || !listadoform.isValid()) {
						principal_investigador.add(listadoform);
						listadoform.setVisible(true);
					}
				}
				if(creaEstacion.isVisible()) {
					principal_investigador.remove(creaEstacion);
					creaEstacion.setVisible(false);
					es=null;
				}
				
				if(creaCasilla.isVisible()) {
					principal_investigador.remove(creaCasilla);
					creaCasilla.setVisible(false);
					c=null;
				}
				if(listadoEsta.isVisible()) {
					principal_investigador.remove(listadoEsta);
					listadoEsta.setVisible(false);
					le=null;
				}
				if(creaForm.isVisible()) {
					principal_investigador.remove(creaForm);
					creaForm.setVisible(false);
					f=null;
				}
			}
			
		});
		
		lblGestinDeEstaciones = new JLabel("Gesti\u00F3n de Estaciones de Medici\u00F3n");
		lblGestinDeEstaciones.setForeground(Color.WHITE);
		lblGestinDeEstaciones.setFont(new Font("Baskerville Old Face", Font.PLAIN, 18));
		lblGestinDeEstaciones.setBounds(10, 241, 297, 46);
		sidePane.add(lblGestinDeEstaciones);
		
		btnCrearNuevaEstacion = new JButton("Crear nueva Estaci\u00F3n");
		btnCrearNuevaEstacion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCrearNuevaEstacion.setHorizontalAlignment(SwingConstants.LEADING);
		btnCrearNuevaEstacion.setForeground(Color.LIGHT_GRAY);
		btnCrearNuevaEstacion.setFont(new Font("Baskerville Old Face", Font.PLAIN, 14));
		btnCrearNuevaEstacion.setBackground(Color.GRAY);
		btnCrearNuevaEstacion.setBounds(0, 286, 349, 32);
		sidePane.add(btnCrearNuevaEstacion);
		btnCrearNuevaEstacion.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if(es==null) {
					if(!creaEstacion.isVisible() || !creaEstacion.isValid()) {
						principal_investigador.add(creaEstacion);
						creaEstacion.setVisible(true);
					}
				}
				if(listadoform.isVisible()) {
					principal_investigador.remove(listadoform);
					listadoform.setVisible(false);
					le=null;
				}
				
				if(creaCasilla.isVisible()) {
					principal_investigador.remove(creaCasilla);
					creaCasilla.setVisible(false);
					c=null;
				}
				if(listadoEsta.isVisible()) {
					principal_investigador.remove(listadoEsta);
					listadoEsta.setVisible(false);
					le=null;
				}
				if(creaForm.isVisible()) {
					principal_investigador.remove(creaForm);
					creaForm.setVisible(false);
					f=null;
				}
			}
			
		});
		
		btnListarEstaciones = new JButton("Listar Estaciones");
		btnListarEstaciones.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnListarEstaciones.setHorizontalAlignment(SwingConstants.LEADING);
		btnListarEstaciones.setForeground(Color.LIGHT_GRAY);
		btnListarEstaciones.setFont(new Font("Baskerville Old Face", Font.PLAIN, 14));
		btnListarEstaciones.setBackground(Color.GRAY);
		btnListarEstaciones.setBounds(0, 319, 349, 32);
		sidePane.add(btnListarEstaciones);
		btnListarEstaciones.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if(le==null) {
					if(!listadoEsta.isVisible() || !listadoEsta.isValid()) {
						principal_investigador.add(listadoEsta);
						listadoEsta.setVisible(true);
					}
				}
				if(listadoform.isVisible()) {
					principal_investigador.remove(listadoform);
					listadoform.setVisible(false);
					lf=null;
				}
				
				if(creaCasilla.isVisible()) {
					principal_investigador.remove(creaCasilla);
					creaCasilla.setVisible(false);
					c=null;
				}
				if(creaEstacion.isVisible()) {
					principal_investigador.remove(creaEstacion);
					creaEstacion.setVisible(false);
					es=null;
				}
				if(creaForm.isVisible()) {
					principal_investigador.remove(creaForm);
					creaForm.setVisible(false);
					f=null;
				}
			}
			
		});
		
		btnCrearNuevaCasilla = new JButton("Crear nueva Casilla");
		btnCrearNuevaCasilla.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCrearNuevaCasilla.setHorizontalAlignment(SwingConstants.LEADING);
		btnCrearNuevaCasilla.setForeground(Color.LIGHT_GRAY);
		btnCrearNuevaCasilla.setFont(new Font("Baskerville Old Face", Font.PLAIN, 14));
		btnCrearNuevaCasilla.setBackground(Color.GRAY);
		btnCrearNuevaCasilla.setBounds(0, 199, 349, 32);
		sidePane.add(btnCrearNuevaCasilla);
		btnCrearNuevaCasilla.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if(c==null) {
					if(!creaCasilla.isVisible() || !creaCasilla.isValid()) {
						principal_investigador.add(creaCasilla);
						creaCasilla.setVisible(true);
					}
				}
				if(creaEstacion.isVisible()) {
					principal_investigador.remove(creaEstacion);
					creaEstacion.setVisible(false);
					es=null;
				}
				
				if(creaForm.isVisible()) {
					principal_investigador.remove(creaForm);
					creaForm.setVisible(false);
					f=null;
				}
				if(listadoEsta.isVisible()) {
					principal_investigador.remove(listadoEsta);
					listadoEsta.setVisible(false);
					le=null;
				}
				if(listadoform.isVisible()) {
					principal_investigador.remove(listadoform);
					listadoform.setVisible(false);
					lf=null;
				}
			}
			
		});
		
		lblNombreUser = new JLabel("");
		lblNombreUser.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombreUser.setForeground(SystemColor.inactiveCaption);
		lblNombreUser.setBounds(77, 10, 230, 32);
		sidePane.add(lblNombreUser);
		
		barra = new JPanel();
		barra.setBounds(0, 0, 1335, 68);
		barra.addMouseMotionListener(this);
		barra.addMouseListener(this);
		barra.setBorder(null);
		barra.setBackground(new Color(255, 222, 173));
		panel.add(barra);
		
		principal_investigador = new JDesktopPane();
		principal_investigador.setBackground(new Color(255, 255, 255));
		principal_investigador.setBounds(350, 67, 985, 658);
		panel.add(principal_investigador);
	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == btnCerrarSesion) {
			try {
				mouseClickedBtnCerrarSesion(e);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
	protected void mouseClickedBtnCerrarSesion(MouseEvent e) throws SQLException {
		int respuesta = JOptionPane.showConfirmDialog(this, "¿ Realmente quieres cerrar sesión ?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if(respuesta == JOptionPane.YES_OPTION) {
			
			LogIn ventana = new LogIn();
			ventana.setVisible(true);
			dispose();
		}
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
		if (e.getSource() == barra) {
			mousePressedBarra(e);
		}
	}
	protected void mousePressedBarra(MouseEvent e) {
		xMouse = e.getX();
		yMouse = e.getY();
	}
	public void mouseDragged(MouseEvent e) {
		if (e.getSource() == barra) {
			mouseDraggedBarra(e);
		}
	}
	public void mouseMoved(MouseEvent e) {
	}
	protected void mouseDraggedBarra(MouseEvent e) {
		int x = e.getXOnScreen();
		int y = e.getYOnScreen();
		this.setLocation(x - xMouse, y - yMouse);
	}
	
	

}
