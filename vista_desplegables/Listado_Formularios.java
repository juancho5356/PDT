package Vista.vista_desplegables;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class Listado_Formularios extends JPanel implements MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel panel;
	public static String Listado_Formularios;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	private JTextField textIdEliminar;

	
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
		
		JLabel lblListaDeFormularios = new JLabel("Lista de Formularios");
		lblListaDeFormularios.setFont(new Font("Baskerville Old Face", Font.ITALIC, 27));
		lblListaDeFormularios.setBounds(10, 10, 275, 31);
		panel.add(lblListaDeFormularios);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(53, 68, 81, 21);
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setColumns(10);
		textField.setBounds(144, 67, 204, 22);
		panel.add(textField);
		
		JLabel lblNewLabel_1_1 = new JLabel("Lugar");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(53, 111, 81, 21);
		panel.add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_1.setColumns(10);
		textField_1.setBounds(144, 112, 204, 22);
		panel.add(textField_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 152, 920, 419);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setSurrendersFocusOnKeystroke(true);
		table.addMouseListener(this);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Actualizar listado");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(30, 594, 152, 21);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Ingrese un ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(682, 594, 88, 21);
		panel.add(lblNewLabel);
		
		textIdEliminar = new JTextField();
		textIdEliminar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textIdEliminar.setColumns(10);
		textIdEliminar.setBounds(780, 595, 53, 19);
		panel.add(textIdEliminar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEliminar.setBounds(843, 594, 107, 21);
		panel.add(btnEliminar);
		
		JButton btnLimpiarFiltros = new JButton("Limpiar filtros");
		btnLimpiarFiltros.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLimpiarFiltros.setBounds(469, 63, 139, 31);
		panel.add(btnLimpiarFiltros);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBuscar.setBounds(469, 106, 139, 31);
		panel.add(btnBuscar);
		
		lista();
	}
		
		public void lista() {
			
			DefaultTableModel modelo= new DefaultTableModel();
			
			Object[] columns = {"ID","Nombre","Fecha","Hora","Ubicación","Usuario"};
			
			modelo.setColumnIdentifiers(columns);
			table.setModel(modelo);
		}


	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == table) {
			mouseClickedTable(e);
		}
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	
	public void mouseClickedTable(MouseEvent e) {
		limpiar();
		
		int filaSeleccionada;
		
		
		filaSeleccionada = table.getSelectedRow();
		if(filaSeleccionada == -1) {
			
		}else {
			textIdEliminar.setText(table.getValueAt(filaSeleccionada, 0).toString());
		}
	}
	
	public void limpiar() {
		textIdEliminar.setText("");
	}
}
