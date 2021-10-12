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

public class Principal extends JFrame implements MouseListener, MouseMotionListener{

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
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	int xMouse, yMouse; 

	String u = AltaUsuario.Usuario;
	String lu = Listado_Usuarios.Listado_Usuario;
	
	String f = AltaFormulario.Alta_Formulario;
	String lf = Listado_Formularios.Listado_Formularios;
	
	String es = AltaEstacion.Alta_Estacion;
	String le = Listado_Estaciones.Listado_Estaciones;
	
	String c = AltaCasilla.Alta_Casilla;
	
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
		btnCrearUsuario.setHorizontalAlignment(SwingConstants.LEADING);
		btnCrearUsuario.setForeground(new Color(192, 192, 192));
		btnCrearUsuario.setFont(new Font("Baskerville Old Face", Font.PLAIN, 14));
		btnCrearUsuario.setBackground(new Color(128, 128, 128));
		btnCrearUsuario.setBounds(0, 134, 349, 32);
		sidePane.add(btnCrearUsuario);

		AltaUsuario creaUsuario = new AltaUsuario();
		Listado_Estaciones listadoEsta = new Listado_Estaciones();
		Listado_Usuarios listadoUsuario = new Listado_Usuarios();
		AltaFormulario creaForm = new AltaFormulario();
		Listado_Formularios listadoform = new Listado_Formularios();
		AltaCasilla creaCasilla = new AltaCasilla();


		btnCrearUsuario.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				if(u==null) { 
					if(!creaUsuario.isVisible() || !creaUsuario.isValid()) {
						principal.add(creaUsuario);
						creaUsuario.setVisible(true);	
					}
				}
				if(listadoEsta.isVisible()) {
					principal.remove(listadoEsta);
					listadoEsta.setVisible(false);
					le=null;
				}
				if(listadoUsuario.isVisible()) {
					principal.remove(listadoUsuario);
					listadoUsuario.setVisible(false);
					lu=null;
				}
				if(creaForm.isVisible()) {
					principal.remove(creaForm);
					creaForm.setVisible(false);
					f=null;
				}
				if(listadoform.isVisible()) {
					principal.remove(listadoform);
					listadoform.setVisible(false);
					lf=null;
				}
				if(creaCasilla.isVisible()) {
					principal.remove(creaCasilla);
					creaCasilla.setVisible(false);
					c=null;
				}
			}

		});
		
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
		btnListarUsuarios.setHorizontalAlignment(SwingConstants.LEADING);
		btnListarUsuarios.setForeground(Color.LIGHT_GRAY);
		btnListarUsuarios.setFont(new Font("Baskerville Old Face", Font.PLAIN, 14));
		btnListarUsuarios.setBackground(Color.GRAY);
		btnListarUsuarios.setBounds(0, 167, 349, 32);
		sidePane.add(btnListarUsuarios);
		btnListarUsuarios.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if(lu==null) {
					if(!listadoUsuario.isVisible() || !listadoUsuario.isValid()) {
						principal.add(listadoUsuario);
						listadoUsuario.setVisible(true);
					}
					
				}
				if(listadoEsta.isVisible()) {
					principal.remove(listadoEsta);
					listadoEsta.setVisible(false);
					le=null;
				}
				if(creaUsuario.isVisible()) {
					principal.remove(creaUsuario);
					creaUsuario.setVisible(false);
					u=null;
				}
				if(creaForm.isVisible()) {
					principal.remove(creaForm);
					creaForm.setVisible(false);
					f=null;
				}
				if(listadoform.isVisible()) {
					principal.remove(listadoform);
					listadoform.setVisible(false);
					lf=null;
				}
				if(creaCasilla.isVisible()) {
					principal.remove(creaCasilla);
					creaCasilla.setVisible(false);
					c=null;
				}
			}
			
		});
		
		lblGestionDeFormularios = new JLabel("Gestion de Formularios");
		lblGestionDeFormularios.setForeground(Color.WHITE);
		lblGestionDeFormularios.setFont(new Font("Baskerville Old Face", Font.PLAIN, 18));
		lblGestionDeFormularios.setBounds(10, 208, 297, 46);
		sidePane.add(lblGestionDeFormularios);
		
		btnCrearNuevoFormulario = new JButton("Crear nuevo Formulario");
		btnCrearNuevoFormulario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCrearNuevoFormulario.setHorizontalAlignment(SwingConstants.LEADING);
		btnCrearNuevoFormulario.setForeground(Color.LIGHT_GRAY);
		btnCrearNuevoFormulario.setFont(new Font("Baskerville Old Face", Font.PLAIN, 14));
		btnCrearNuevoFormulario.setBackground(Color.GRAY);
		btnCrearNuevoFormulario.setBounds(0, 251, 349, 32);
		sidePane.add(btnCrearNuevoFormulario);
		btnCrearNuevoFormulario.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				if(f==null) {
					if(!creaForm.isVisible() || !creaForm.isValid()) {
						principal.add(creaForm);
						creaForm.setVisible(true);
					}
					
				}
				if(listadoEsta.isVisible()) {
					principal.remove(listadoEsta);
					listadoEsta.setVisible(false);
					le=null;
				}
				if(creaUsuario.isVisible()) {
					principal.remove(creaUsuario);
					creaUsuario.setVisible(false);
					u=null;
				}
				if(listadoUsuario.isVisible()) {
					principal.remove(listadoUsuario);
					listadoUsuario.setVisible(false);
					lu=null;
				}
				if(listadoform.isVisible()) {
					principal.remove(listadoform);
					listadoform.setVisible(false);
					lf=null;
				}
				if(creaCasilla.isVisible()) {
					principal.remove(creaCasilla);
					creaCasilla.setVisible(false);
					c=null;
				}
			}
			
		});
		
		btnListarFormularios = new JButton("Listar Formularios");
		btnListarFormularios.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnListarFormularios.setHorizontalAlignment(SwingConstants.LEADING);
		btnListarFormularios.setForeground(Color.LIGHT_GRAY);
		btnListarFormularios.setFont(new Font("Baskerville Old Face", Font.PLAIN, 14));
		btnListarFormularios.setBackground(Color.GRAY);
		btnListarFormularios.setBounds(0, 284, 349, 32);
		sidePane.add(btnListarFormularios);
		btnListarFormularios.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if(lf==null) {
					if(!listadoform.isVisible() || !listadoform.isValid()) {
						principal.add(listadoform);
						listadoform.setVisible(true);
					}
					
				}

				if(listadoEsta.isVisible()) {
					principal.remove(listadoEsta);
					listadoEsta.setVisible(false);
					le=null;
				}
				if(creaUsuario.isVisible()) {
					principal.remove(creaUsuario);
					creaUsuario.setVisible(false);
					u=null;
				}
				if(listadoUsuario.isVisible()) {
					principal.remove(listadoUsuario);
					listadoUsuario.setVisible(false);
					lu=null;
				}
				if(creaForm.isVisible()) {
					principal.remove(creaForm);
					creaForm.setVisible(false);
					f=null;
				}
				if(creaCasilla.isVisible()) {
					principal.remove(creaCasilla);
					creaCasilla.setVisible(false);
					c=null;
				}
			}
			
		});
		
		lblGestinDeEstaciones = new JLabel("Gesti\u00F3n de Estaciones de Medici\u00F3n");
		lblGestinDeEstaciones.setForeground(Color.WHITE);
		lblGestinDeEstaciones.setFont(new Font("Baskerville Old Face", Font.PLAIN, 18));
		lblGestinDeEstaciones.setBounds(10, 359, 297, 46);
		sidePane.add(lblGestinDeEstaciones);
		
		btnListarEstaciones = new JButton("Listar Estaciones");
		btnListarEstaciones.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnListarEstaciones.setHorizontalAlignment(SwingConstants.LEADING);
		btnListarEstaciones.setForeground(Color.LIGHT_GRAY);
		btnListarEstaciones.setFont(new Font("Baskerville Old Face", Font.PLAIN, 14));
		btnListarEstaciones.setBackground(Color.GRAY);
		btnListarEstaciones.setBounds(0, 404, 349, 32);
		sidePane.add(btnListarEstaciones);

		btnListarEstaciones.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				if(le==null) {
					if(!listadoEsta.isVisible() || !listadoEsta.isValid()) {
						principal.add(listadoEsta);
						listadoEsta.setVisible(true);
					}

					
				}
				if(creaUsuario.isVisible()) {
					principal.remove(creaUsuario);
					creaUsuario.setVisible(false);
					u=null;
				}
				if(listadoUsuario.isVisible()) {
					principal.remove(listadoUsuario);
					listadoUsuario.setVisible(false);
					lu=null;
				}
				if(creaForm.isVisible()) {
					principal.remove(creaForm);
					creaForm.setVisible(false);
					f=null;
				}
				if(creaCasilla.isVisible()) {
					principal.remove(creaCasilla);
					creaCasilla.setVisible(false);
					c=null;
				}
				if(listadoform.isVisible()) {
					principal.remove(listadoform);
					listadoform.setVisible(false);
					lf=null;
				}
				
			}
			
		});
		
		btnCrearNuevaCasilla = new JButton("Crear nueva Casilla");
		btnCrearNuevaCasilla.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCrearNuevaCasilla.setHorizontalAlignment(SwingConstants.LEADING);
		btnCrearNuevaCasilla.setForeground(Color.LIGHT_GRAY);
		btnCrearNuevaCasilla.setFont(new Font("Baskerville Old Face", Font.PLAIN, 14));
		btnCrearNuevaCasilla.setBackground(Color.GRAY);
		btnCrearNuevaCasilla.setBounds(0, 317, 349, 32);
		sidePane.add(btnCrearNuevaCasilla);
		btnCrearNuevaCasilla.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if(c==null) {
					if(!creaCasilla.isVisible() || !creaCasilla.isValid()) {
						principal.add(creaCasilla);
						creaCasilla.setVisible(true);
					}
					
				}
				if(creaUsuario.isVisible()) {
					principal.remove(creaUsuario);
					creaUsuario.setVisible(false);
					u=null;
				}
				if(listadoUsuario.isVisible()) {
					principal.remove(listadoUsuario);
					listadoUsuario.setVisible(false);
					lu=null;
				}
				if(creaForm.isVisible()) {
					principal.remove(creaForm);
					creaForm.setVisible(false);
					f=null;
				}
				if(listadoEsta.isVisible()) {
					principal.remove(listadoEsta);
					listadoEsta.setVisible(false);
					le=null;
				}
				if(listadoform.isVisible()) {
					principal.remove(listadoform);
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
		barra.setBackground(new Color(176, 196, 222));
		panel.add(barra);
		
		principal = new JDesktopPane();
		principal.setBackground(new Color(255, 255, 255));
		principal.setBounds(350, 67, 985, 658);
		panel.add(principal);
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
