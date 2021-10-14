package Vista.vista_desplegables;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.LinkedList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controlador.DAO_Administrador;
import Controlador.DAO_Aficionado;
import Controlador.DAO_Investigador;
import Controlador.DAO_Usuario;
import Modelo.Administrador;
import Modelo.Aficionado;
import Modelo.Investigador;
import Modelo.Usuario;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

public class Listado_Usuarios extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel panel;
	public static String Listado_Usuario;
	private JTextField textFieldId;
	private JTable table;
	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textRol;
	private JTextField textNombreMod;
	private JTextField textIdMod;
	private JTextField textApellidoMod;
	private JTextField textMailMod;

	
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
		
		JLabel lblListaDeUsuarios = new JLabel("Lista de Usuarios");
		lblListaDeUsuarios.setFont(new Font("Baskerville Old Face", Font.ITALIC, 27));
		lblListaDeUsuarios.setBounds(10, 10, 275, 31);
		panel.add(lblListaDeUsuarios);
		
		JLabel lblNewLabel = new JLabel("Ingrese un ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(364, 591, 88, 21);
		panel.add(lblNewLabel);
		
		textFieldId = new JTextField();
		textFieldId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldId.setBounds(462, 592, 53, 19);
		panel.add(textFieldId);
		textFieldId.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 169, 617, 393);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setSurrendersFocusOnKeystroke(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		
		lista();
	}
		
	public void lista() {
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEliminar.setBounds(525, 591, 107, 21);
		panel.add(btnEliminar);
		
		DefaultTableModel modelo= new DefaultTableModel();
			
		Object[] columns = {"ID Usuario","Nombre","Apellido","Mail"};
		
		modelo.setColumnIdentifiers(columns);
		
		Object [] fila = new Object[columns.length];
		table.setModel(modelo);
		
		JButton btnNewButton = new JButton("Actualizar listado");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(20, 591, 152, 21);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(20, 51, 81, 21);
		panel.add(lblNewLabel_1);
		
		textNombre = new JTextField();
		textNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textNombre.setBounds(140, 51, 204, 22);
		panel.add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Apellido");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(20, 85, 75, 19);
		panel.add(lblNewLabel_2);
		
		textApellido = new JTextField();
		textApellido.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textApellido.setBounds(140, 83, 204, 22);
		panel.add(textApellido);
		textApellido.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Rol de usuario");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(20, 116, 107, 17);
		panel.add(lblNewLabel_3);
		
		textRol = new JTextField();
		textRol.setBounds(140, 116, 204, 22);
		panel.add(textRol);
		textRol.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBuscar.setBounds(451, 109, 139, 31);
		panel.add(btnBuscar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(647, 0, 338, 658);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblListaDeUsuarios = new JLabel("Lista de Usuarios");
		lblListaDeUsuarios.setFont(new Font("Baskerville Old Face", Font.ITALIC, 27));
		lblListaDeUsuarios.setBounds(10, 10, 275, 31);
		panel_1.add(lblListaDeUsuarios);
		
		JLabel lblNewLabel_4 = new JLabel("Nombre");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(22, 156, 86, 17);
		panel_1.add(lblNewLabel_4);
		
		textNombreMod = new JTextField();
		textNombreMod.setBounds(94, 154, 218, 26);
		panel_1.add(textNombreMod);
		textNombreMod.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("ID");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(56, 93, 60, 17);
		panel_1.add(lblNewLabel_5);
		
		textIdMod = new JTextField();
		textIdMod.setColumns(10);
		textIdMod.setBounds(94, 91, 218, 26);
		panel_1.add(textIdMod);
		
		JLabel lblNewLabel_6 = new JLabel("Apellido");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(29, 221, 79, 17);
		panel_1.add(lblNewLabel_6);
		
		textApellidoMod = new JTextField();
		textApellidoMod.setColumns(10);
		textApellidoMod.setBounds(94, 219, 218, 26);
		panel_1.add(textApellidoMod);
		
		JLabel lblNewLabel_7 = new JLabel("Mail");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_7.setBounds(48, 288, 68, 17);
		panel_1.add(lblNewLabel_7);
		
		textMailMod = new JTextField();
		textMailMod.setColumns(10);
		textMailMod.setBounds(94, 286, 218, 26);
		panel_1.add(textMailMod);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLimpiar.setBounds(18, 368, 98, 31);
		panel_1.add(btnLimpiar);
		
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAceptar.setBounds(214, 368, 98, 31);
		panel_1.add(btnAceptar);
		
		JButton btnLimpiarFiltros = new JButton("Limpiar filtros");
		btnLimpiarFiltros.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLimpiarFiltros.setBounds(451, 53, 139, 31);
		panel.add(btnLimpiarFiltros);
		btnLimpiarFiltros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textNombre.setText("");
				textApellido.setText("");
				textRol.setText("");
			}
		});
		
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idST = textIdMod.getText();
				String nombre = textNombreMod.getText();
				String apellido = textApellidoMod.getText();
				String mail = textMailMod.getText();

				Usuario u = new Usuario();
				u.setNombre(nombre);
				u.setApellido(apellido);
				u.setMail(mail);

				if(DAO_Usuario.edit(u, idST)) {
					JOptionPane.showConfirmDialog(null, "¿Desea actualizar el usuario con los datos ingresados?");
					JOptionPane.showMessageDialog(null, "Usuario actualizado con éxito");
					lista();
				}else {
					JOptionPane.showMessageDialog(null, "No se ha podido actualizar el usuario");
				}
			}
		});
		
		LinkedList<Usuario> todosUsuarios = DAO_Usuario.findAll();
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lista();
			}
		});
			
		for (int i=0;i<todosUsuarios.size();i++){
	
			int id = todosUsuarios.get(i).getIdUsuario();
			String nombre=todosUsuarios.get(i).getNombre();
			String apellido=todosUsuarios.get(i).getApellido();
			String mail = todosUsuarios.get(i).getMail();
		
			fila[0] = id;
			fila[1] = nombre;
			fila[2] = apellido;
			fila[3] = mail;
			modelo.addRow(fila);
			
		
		
			
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!(textFieldId.getText().isEmpty())) {
					String idST = textFieldId.getText();
					int id = Integer.parseInt(idST);
					
					Administrador a = DAO_Administrador.findUsuarioID(id);
					Investigador i = DAO_Investigador.findUsuarioID(id);
					Aficionado af = DAO_Aficionado.findUsuarioID(id);
					
					if(DAO_Administrador.findUsuarioID(id) != null) {
						DAO_Administrador.delete(a);
					}
					else if(DAO_Investigador.findUsuarioID(id) != null) {
						DAO_Investigador.delete(i);
					}
					else if(DAO_Aficionado.findUsuarioID(id) != null) {
						DAO_Aficionado.delete(af);
					}
					
					Usuario u = DAO_Usuario.findUsuarioId(id);
					if(DAO_Usuario.delete(u)) {
						JOptionPane.showConfirmDialog(null, "¿Desea eliminar completamente el usuario seleccionado?");
						JOptionPane.showMessageDialog(null, "Usuario eliminado exitosamente");
						textFieldId.setText("");
						lista();
					}
					else {
						JOptionPane.showMessageDialog(null, "El registro que acaba de ingresar, no se encuentra en el sistema");
						textFieldId.setText("");
					}
				}
				/*else {
					JOptionPane.showMessageDialog(null, "Por favor ingrese un ID");
				}*/
		}
		});
		
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textIdMod.setText("");
				textNombreMod.setText("");
				textApellidoMod.setText("");
				textMailMod.setText("");
			}
		});
		}
	}
}