package vista_desplegables;

import java.awt.EventQueue;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import com.exception.ServiciosException;
import com.servicios.Casilla_BeanRemote;
import com.servicios.FormularioCasilla_BeanRemote;
import com.servicios.Formulario_BeanRemote;

import model.Casilla;
import model.Formulario;
import model.FormularioCasilla;
import model.UnidadesDeMedida;

import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JButton;

public class Listado_Casillas implements MouseListener{

	private JFrame frame;
	private JTable table;
	private JTextField textNombre;
	private JTextField textUnidad;
	private JTextField textDescripcion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Listado_Casillas window = new Listado_Casillas();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Listado_Casillas() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBackground(Color.WHITE);
		frame.setBounds(100, 100, 1049, 639);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblListaDeCasillas = new JLabel("Lista de Casillas");
		lblListaDeCasillas.setFont(new Font("Baskerville Old Face", Font.ITALIC, 27));
		lblListaDeCasillas.setBounds(20, 10, 275, 31);
		frame.getContentPane().add(lblListaDeCasillas);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 51, 635, 541);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setSurrendersFocusOnKeystroke(true);
		table.addMouseListener(this);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 248, 255));
		panel.setBounds(659, 0, 376, 602);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblInformacinDe = new JLabel("Informaci\u00F3n de Casilla");
		lblInformacinDe.setBounds(10, 10, 302, 28);
		panel.add(lblInformacinDe);
		lblInformacinDe.setFont(new Font("Baskerville Old Face", Font.ITALIC, 27));
		
		JLabel lblNewLabel_1_1 = new JLabel("*");
		lblNewLabel_1_1.setBounds(10, 66, 15, 13);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Baskerville Old Face", Font.PLAIN, 15));
		lblNombre.setBounds(20, 66, 170, 25);
		panel.add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setEditable(false);
		textNombre.setColumns(10);
		textNombre.setBackground(SystemColor.inactiveCaptionBorder);
		textNombre.setBounds(153, 66, 214, 25);
		panel.add(textNombre);
		
		textUnidad = new JTextField();
		textUnidad.setEditable(false);
		textUnidad.setColumns(10);
		textUnidad.setBackground(SystemColor.inactiveCaptionBorder);
		textUnidad.setBounds(153, 119, 214, 25);
		panel.add(textUnidad);
		
		JLabel lblComentarios = new JLabel("Unidad de medida");
		lblComentarios.setFont(new Font("Baskerville Old Face", Font.PLAIN, 15));
		lblComentarios.setBounds(20, 119, 170, 25);
		panel.add(lblComentarios);
		
		JLabel lblNewLabel_2 = new JLabel("*");
		lblNewLabel_2.setBounds(10, 119, 15, 13);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("*");
		lblNewLabel_3.setBounds(10, 174, 15, 13);
		panel.add(lblNewLabel_3);
		
		JLabel lblFecha = new JLabel("Descripci\u00F3n");
		lblFecha.setFont(new Font("Baskerville Old Face", Font.PLAIN, 15));
		lblFecha.setBounds(20, 174, 170, 25);
		panel.add(lblFecha);
		
		textDescripcion = new JTextField();
		textDescripcion.setEditable(false);
		textDescripcion.setColumns(10);
		textDescripcion.setBackground(SystemColor.inactiveCaptionBorder);
		textDescripcion.setBounds(10, 209, 357, 25);
		panel.add(textDescripcion);
		
		table.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
				int filaSeleccionada;
				
				filaSeleccionada = table.getSelectedRow();
				if(filaSeleccionada == -1) {
					
				}else {
					textNombre.setText(table.getValueAt(filaSeleccionada, 1).toString());
					textUnidad.setText(table.getValueAt(filaSeleccionada, 3).toString());
					textDescripcion.setText(table.getValueAt(filaSeleccionada, 2).toString());
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		JButton btnEliminarCasilla = new JButton("Eliminar casilla");
		btnEliminarCasilla.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEliminarCasilla.setEnabled(true);
		btnEliminarCasilla.setBackground(new Color(173, 216, 230));
		btnEliminarCasilla.setBounds(34, 550, 318, 31);
		panel.add(btnEliminarCasilla);
		
		JButton btnAgregar = new JButton("Agregar casilla al formulario");
		btnAgregar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAgregar.setEnabled(true);
		btnAgregar.setBackground(new Color(173, 216, 230));
		btnAgregar.setBounds(34, 494, 318, 31);
		panel.add(btnAgregar);
		
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Listado_Formularios lista = new Listado_Formularios();
				int id = ;
				Formulario f = new Formulario();
				
				try {
					String dato = "PDT_EJB/Formulario_Bean!com.servicios.Formulario_BeanRemote";
					Formulario_BeanRemote form = (Formulario_BeanRemote) InitialContext.doLookup(dato);
					f = form.findFormularioId(id);
					if(f != null) {
						System.out.println("Formulario encontrado");
					}
					
				}catch(NamingException | ServiciosException ex) {
					ex.getMessage();
				}
				
				int filaSeleccionada;
				filaSeleccionada = table.getSelectedRow();
				
				Casilla c = new Casilla();
				try {
					String dato = "PDT_EJB/Casilla_Bean!com.servicios.Casilla_BeanRemote";
					Casilla_BeanRemote casi = (Casilla_BeanRemote) InitialContext.doLookup(dato);
					String nombre = table.getValueAt(filaSeleccionada, 1).toString();
					c = casi.findCasilla(nombre);
					
				}catch(NamingException | ServiciosException ex) {
					ex.getMessage();
				}
				
				FormularioCasilla formCasi = new FormularioCasilla();
				formCasi.setCasilla(c);
				formCasi.setFormulario(f);
				
				try {
					String dato = "PDT_EJB/FormularioCasilla_Bean!com.servicios.FormularioCasilla_BeanRemote";
					FormularioCasilla_BeanRemote casi = (FormularioCasilla_BeanRemote) InitialContext.doLookup(dato);
				
					if(formCasi != null && c != null && f != null) {
						int respuesta = JOptionPane.showConfirmDialog(null, "¿Seguro que desea agregar la casilla seleccionada?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
						if(respuesta == JOptionPane.YES_OPTION) {
							if(casi.insert(formCasi)) {
								JOptionPane.showMessageDialog(null, "Casilla agregada exitosamente");
								lista();
								limpiar();
							}
							else {
								JOptionPane.showMessageDialog(null, "No se ha podido agregar la casilla al formulario");
							}
						}
					}
					
				}catch(NamingException | ServiciosException ex) {
					ex.getMessage();
					JOptionPane.showMessageDialog(null, "No es posible agregar esta casilla");
				}
			}
		});
		
		btnEliminarCasilla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int filaSeleccionada;
				
				filaSeleccionada = table.getSelectedRow();
				
				Casilla c = new Casilla();
				String idST = table.getValueAt(filaSeleccionada, 0).toString();
				int id = Integer.parseInt(idST);
				c.setIdCasilla(id);
				c.setNombre(table.getValueAt(filaSeleccionada, 1).toString());
				c.setDescripcion(table.getValueAt(filaSeleccionada, 2).toString());
				UnidadesDeMedida u = new UnidadesDeMedida();
				u.setNombre(table.getValueAt(filaSeleccionada, 3).toString());
				c.setUnidadesDeMedida(u);
				
				FormularioCasilla f = new FormularioCasilla();
				f.setCasilla(c);
				
				try {
					String dato = "PDT_EJB/Casilla_Bean!com.servicios.Casilla_BeanRemote";
					Casilla_BeanRemote casi = (Casilla_BeanRemote) InitialContext.doLookup(dato);
				
					if(c != null) {
						int respuesta = JOptionPane.showConfirmDialog(null, "¿Seguro que desea eliminar la casilla seleccionada?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
						if(respuesta == JOptionPane.YES_OPTION) {
							casi.delete(c);
							JOptionPane.showMessageDialog(null, "Casilla eliminada correctamente");
							lista();
							limpiar();
						}
					}
				}catch(NamingException | ServiciosException ex) {
					ex.getMessage();
					JOptionPane.showMessageDialog(null, "No es posible eliminar esta casilla");
				}
			}
		});
		
		lista();
		limpiar();
	}
	
	
	public void lista(){
		
		DefaultTableModel modelo= new DefaultTableModel();
		
		Object[] columns = {"ID","Nombre","Descripción","Unidad de medida"};
		
		modelo.setColumnIdentifiers(columns);
		table.setModel(modelo);
		
		List<Casilla> casillas = new LinkedList<>();
		Object[] fila = new Object[columns.length];
		try {
			String dato = "PDT_EJB/Casilla_Bean!com.servicios.Casilla_BeanRemote";
			Casilla_BeanRemote casi = (Casilla_BeanRemote) InitialContext.doLookup(dato);
			
			casillas = casi.allCasillas();
		
		}catch(NamingException ex) {
			ex.getMessage();
		}
		
		for(Casilla c: casillas) {
			fila[0] = String.valueOf(c.getIdCasilla());
			fila[1] = c.getNombre();
			fila[2] = c.getDescripcion();
			fila[3] = c.getUnidadesDeMedida().getNombre();
			modelo.addRow(fila);
		}
	}
	
	public void limpiar() {
		textNombre.setText("");
		textUnidad.setText("");
		textDescripcion.setText("");
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	}