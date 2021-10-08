package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import vista_desplegables.*;

import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JDesktopPane;
import javax.swing.SwingConstants;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;

public class Principal extends JFrame implements MouseListener, MouseMotionListener, ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private JPanel sidePane;
	private JPanel barra;
	private JButton btnCrearUsuario;
	private JLabel lblGestionUsuarios;
	private JLabel lblUser;
	private JButton btnCerrarSesion;
	private JSeparator separator;
	private JLabel lblLinea;
	private JButton btnListarUsuarios;
	private JLabel lblGestionDeFormularios;
	private JButton btnCrearNuevoFormulario;
	private JButton btnListarFormularios;
	private JLabel lblGestinDeEstaciones;
	private JButton btnCrearNuevaEstacion;
	private JButton btnListarEstaciones;
	private JButton btnCrearNuevaCasilla;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	int xMouse, yMouse; 
	
	public static JDesktopPane principal;
	/**
	 * Create the frame.
	 */
	public Principal() {
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
		
		btnCrearUsuario = new JButton("Crear nuevo Usuario");
		btnCrearUsuario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCrearUsuario.addActionListener(this);
		btnCrearUsuario.setHorizontalAlignment(SwingConstants.LEADING);
		btnCrearUsuario.setForeground(new Color(192, 192, 192));
		btnCrearUsuario.setFont(new Font("Baskerville Old Face", Font.PLAIN, 14));
		btnCrearUsuario.setBackground(new Color(128, 128, 128));
		btnCrearUsuario.setBounds(0, 134, 349, 32);
		sidePane.add(btnCrearUsuario);
		
		lblGestionUsuarios = new JLabel("Gestion de Usuarios");
		lblGestionUsuarios.setFont(new Font("Baskerville Old Face", Font.PLAIN, 18));
		lblGestionUsuarios.setForeground(new Color(255, 255, 255));
		lblGestionUsuarios.setBounds(10, 89, 297, 46);
		sidePane.add(lblGestionUsuarios);
		
		lblUser = new JLabel("");
		lblUser.setIcon(new ImageIcon(Principal.class.getResource("/image/user.png")));
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
		
		btnListarUsuarios = new JButton("Listar Usuarios");
		btnListarUsuarios.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnListarUsuarios.addActionListener(this);
		btnListarUsuarios.setHorizontalAlignment(SwingConstants.LEADING);
		btnListarUsuarios.setForeground(Color.LIGHT_GRAY);
		btnListarUsuarios.setFont(new Font("Baskerville Old Face", Font.PLAIN, 14));
		btnListarUsuarios.setBackground(Color.GRAY);
		btnListarUsuarios.setBounds(0, 167, 349, 32);
		sidePane.add(btnListarUsuarios);
		
		lblGestionDeFormularios = new JLabel("Gestion de Formularios");
		lblGestionDeFormularios.setForeground(Color.WHITE);
		lblGestionDeFormularios.setFont(new Font("Baskerville Old Face", Font.PLAIN, 18));
		lblGestionDeFormularios.setBounds(10, 208, 297, 46);
		sidePane.add(lblGestionDeFormularios);
		
		btnCrearNuevoFormulario = new JButton("Crear nuevo Formulario");
		btnCrearNuevoFormulario.addActionListener(this);
		btnCrearNuevoFormulario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCrearNuevoFormulario.setHorizontalAlignment(SwingConstants.LEADING);
		btnCrearNuevoFormulario.setForeground(Color.LIGHT_GRAY);
		btnCrearNuevoFormulario.setFont(new Font("Baskerville Old Face", Font.PLAIN, 14));
		btnCrearNuevoFormulario.setBackground(Color.GRAY);
		btnCrearNuevoFormulario.setBounds(0, 251, 349, 32);
		sidePane.add(btnCrearNuevoFormulario);
		
		btnListarFormularios = new JButton("Listar Formularios");
		btnListarFormularios.addActionListener(this);
		btnListarFormularios.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnListarFormularios.setHorizontalAlignment(SwingConstants.LEADING);
		btnListarFormularios.setForeground(Color.LIGHT_GRAY);
		btnListarFormularios.setFont(new Font("Baskerville Old Face", Font.PLAIN, 14));
		btnListarFormularios.setBackground(Color.GRAY);
		btnListarFormularios.setBounds(0, 284, 349, 32);
		sidePane.add(btnListarFormularios);
		
		lblGestinDeEstaciones = new JLabel("Gesti\u00F3n de Estaciones de Medici\u00F3n");
		lblGestinDeEstaciones.setForeground(Color.WHITE);
		lblGestinDeEstaciones.setFont(new Font("Baskerville Old Face", Font.PLAIN, 18));
		lblGestinDeEstaciones.setBounds(10, 359, 297, 46);
		sidePane.add(lblGestinDeEstaciones);
		
		btnCrearNuevaEstacion = new JButton("Crear nueva Estaci\u00F3n");
		btnCrearNuevaEstacion.addActionListener(this);
		btnCrearNuevaEstacion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCrearNuevaEstacion.setHorizontalAlignment(SwingConstants.LEADING);
		btnCrearNuevaEstacion.setForeground(Color.LIGHT_GRAY);
		btnCrearNuevaEstacion.setFont(new Font("Baskerville Old Face", Font.PLAIN, 14));
		btnCrearNuevaEstacion.setBackground(Color.GRAY);
		btnCrearNuevaEstacion.setBounds(0, 404, 349, 32);
		sidePane.add(btnCrearNuevaEstacion);
		
		btnListarEstaciones = new JButton("Listar Estaciones");
		btnListarEstaciones.addActionListener(this);
		btnListarEstaciones.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnListarEstaciones.setHorizontalAlignment(SwingConstants.LEADING);
		btnListarEstaciones.setForeground(Color.LIGHT_GRAY);
		btnListarEstaciones.setFont(new Font("Baskerville Old Face", Font.PLAIN, 14));
		btnListarEstaciones.setBackground(Color.GRAY);
		btnListarEstaciones.setBounds(0, 437, 349, 32);
		sidePane.add(btnListarEstaciones);
		
		btnCrearNuevaCasilla = new JButton("Crear nueva Casilla");
		btnCrearNuevaCasilla.addActionListener(this);
		btnCrearNuevaCasilla.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCrearNuevaCasilla.setHorizontalAlignment(SwingConstants.LEADING);
		btnCrearNuevaCasilla.setForeground(Color.LIGHT_GRAY);
		btnCrearNuevaCasilla.setFont(new Font("Baskerville Old Face", Font.PLAIN, 14));
		btnCrearNuevaCasilla.setBackground(Color.GRAY);
		btnCrearNuevaCasilla.setBounds(0, 317, 349, 32);
		sidePane.add(btnCrearNuevaCasilla);
		
		barra = new JPanel();
		barra.setBounds(0, 0, 1335, 68);
		barra.addMouseMotionListener(this);
		barra.addMouseListener(this);
		barra.setBorder(null);
		barra.setBackground(new Color(176, 196, 222));
		panel.add(barra);
		
		principal = new JDesktopPane();
		principal.setBackground(new Color(255, 255, 255));
		principal.setBounds(350, 67, 985, 658);
		panel.add(principal);
	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == btnCerrarSesion) {
			mouseClickedBtnCerrarSesion(e);
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
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCrearNuevaCasilla) {
			actionPerformedBtnCrearNuevaCasilla(e);
		}
		if (e.getSource() == btnListarEstaciones) {
			actionPerformedBtnListarEstaciones(e);
		}
		
		if (e.getSource() == btnListarFormularios) {
			actionPerformedBtnListarFormularios(e);
		}
		if (e.getSource() == btnCrearNuevoFormulario) {
			actionPerformedBtnCrearNuevoFormulario(e);
		}
		if (e.getSource() == btnListarUsuarios) {
			actionPerformedBtnListarUsuarios(e);
		}
		if (e.getSource() == btnCrearUsuario) {
			actionPerformedBtnCrearUsuario(e);
		}
		
		if (e.getSource() == btnCrearNuevaEstacion) {
			actionPerformedBtnCrearNuevaEstacion(e);
		}
	}
	
	String u = AltaUsuario.Usuario;
	String l = Listado_Usuarios.Listado_Usuario;
	
	String f = AltaFormulario.Alta_Formulario;
	String lf = Listado_Formularios.Listado_Formularios;
	
	String es = AltaEstacion.Alta_Estacion;
	String le = Listado_Estaciones.Listado_Estaciones;
	
	String c = AltaCasilla.Alta_Casilla;
	
	
	private void actionPerformedBtnCrearNuevaEstacion(ActionEvent e) {
		
		if(es==null) {
			AltaEstacion creaEstacion = new AltaEstacion();
			principal.add(creaEstacion);
			creaEstacion.setVisible(true);
		}
	}
	protected void actionPerformedBtnCrearUsuario(ActionEvent e) {
		
		if(u==null) {
			AltaUsuario creaUsuario = new AltaUsuario();
			principal.add(creaUsuario);
			creaUsuario.setVisible(true);
		}
		
	}
	protected void mouseClickedBtnCerrarSesion(MouseEvent e) {
		System.exit(0);
	}
	
	protected void actionPerformedBtnListarUsuarios(ActionEvent e) {
		
		if(l==null) {
			Listado_Usuarios listadoUsuario = new Listado_Usuarios();
			principal.add(listadoUsuario);
			listadoUsuario.setVisible(true);
		}
	}
	protected void actionPerformedBtnCrearNuevoFormulario(ActionEvent e) {
		
		if(f==null) {
			AltaFormulario creaForm = new AltaFormulario();
			principal.add(creaForm);
			creaForm.setVisible(true);
		}
	}
	protected void actionPerformedBtnListarFormularios(ActionEvent e) {
		
		if(lf==null) {
			Listado_Formularios listadoform = new Listado_Formularios();
			principal.add(listadoform);
			listadoform.setVisible(true);
		}
	}
	protected void actionPerformedBtnListarEstaciones(ActionEvent e) {
		
		if(le==null) {
			Listado_Estaciones listadoEsta = new Listado_Estaciones();
			principal.add(listadoEsta);
			listadoEsta.setVisible(true);
		}
	}
	protected void actionPerformedBtnCrearNuevaCasilla(ActionEvent e) {
		
		if(c==null) {
			AltaCasilla creaCasilla = new AltaCasilla();
			principal.add(creaCasilla);
			creaCasilla.setVisible(true);
		}
	}
}
