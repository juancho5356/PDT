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
		lblListaDeUsuarios.setBounds(38, 46, 275, 31);
		panel.add(lblListaDeUsuarios);
		
		JLabel lblNewLabel = new JLabel("Ingrese un ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(687, 591, 88, 21);
		panel.add(lblNewLabel);
		
		textFieldId = new JTextField();
		textFieldId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldId.setBounds(785, 592, 53, 19);
		panel.add(textFieldId);
		textFieldId.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 105, 921, 457);
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
		btnEliminar.setBounds(848, 591, 107, 21);
		panel.add(btnEliminar);
		
		DefaultTableModel modelo= new DefaultTableModel();
			
		Object[] columns = {"ID Usuario","Nombre","Apellido","Mail"};
		
		modelo.setColumnIdentifiers(columns);
		
		Object [] fila = new Object[columns.length];
		table.setModel(modelo);
		
		JButton btnNewButton = new JButton("Actualizar listado");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(34, 593, 152, 21);
		panel.add(btnNewButton);
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
	}
}
}