package vista_desplegables;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import model.*;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.*;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JComboBox;
import javax.swing.JTextPane;
import com.servicios.*;

public class AltaCasilla extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel panel;
	private JLabel lblNewLabel;
	private JSeparator separator;
	private JLabel lblNombre;
	public static String Alta_Casilla;
	private JTextField textNombre;
	private JLabel lblNewLabel_1;
	private JLabel lblUnidad;
	private JLabel lblTipoDato;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblDescripcion;
	private JTextArea textDescripcion;
	private JScrollPane scrollPane;
	private JButton btnLimpiar;
	private JButton btnIngresar;
	private JComboBox<Object> comboBox_Unidad;
	private JComboBox<Object> comboBox_Tipo;
	private JTextPane txtpnDd;
	private JLabel lblNota;
	private JPanel panel_1;

	
	/**
	 * Create the panel.
	 */
	public AltaCasilla() {
		Alta_Casilla = "Alta_Casilla";

		
		setBounds(new Rectangle(0, 0, 985, 658));
		setLayout(new CardLayout(0, 0));
		
		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		add(panel, "name_25541786307800");
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("Alta de Casilla");
		lblNewLabel.setBounds(55, 60, 275, 31);
		lblNewLabel.setFont(new Font("Baskerville Old Face", Font.ITALIC, 27));
		panel.add(lblNewLabel);
		
		separator = new JSeparator();
		separator.setBounds(55, 89, 159, 2);
		panel.add(separator);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(55, 156, 170, 25);
		lblNombre.setFont(new Font("Baskerville Old Face", Font.PLAIN, 16));
		panel.add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setBounds(235, 156, 239, 25);
		textNombre.setColumns(10);
		panel.add(textNombre);
		
		lblNewLabel_1 = new JLabel("*");
		lblNewLabel_1.setBounds(30, 156, 15, 13);
		panel.add(lblNewLabel_1);
		
		lblUnidad = new JLabel("Unidad de medida");
		lblUnidad.setBounds(55, 209, 170, 25);
		lblUnidad.setFont(new Font("Baskerville Old Face", Font.PLAIN, 16));
		panel.add(lblUnidad);
		
		lblTipoDato = new JLabel("Tipo de Dato");
		lblTipoDato.setBounds(55, 264, 170, 25);
		lblTipoDato.setFont(new Font("Baskerville Old Face", Font.PLAIN, 16));
		panel.add(lblTipoDato);
		
		lblNewLabel_3 = new JLabel("*");
		lblNewLabel_3.setBounds(30, 209, 15, 13);
		panel.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("*");
		lblNewLabel_4.setBounds(30, 264, 15, 13);
		panel.add(lblNewLabel_4);
		
		lblDescripcion = new JLabel("Descripci\u00F3n");
		lblDescripcion.setBounds(55, 330, 170, 25);
		lblDescripcion.setFont(new Font("Baskerville Old Face", Font.PLAIN, 16));
		panel.add(lblDescripcion);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(55, 365, 419, 160);
		panel.add(scrollPane);
		
		textDescripcion = new JTextArea();
		textDescripcion.setForeground(Color.DARK_GRAY);
		textDescripcion.setFont(new Font("Arial", Font.PLAIN, 14));
		textDescripcion.setLineWrap(true);
		scrollPane.setViewportView(textDescripcion);
		
		btnLimpiar = new JButton("Limpiar/Cancelar");
		btnLimpiar.setBounds(710, 523, 170, 49);
		btnLimpiar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLimpiar.setBackground(SystemColor.menu);
		panel.add(btnLimpiar);
		btnLimpiar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				limpiar();
			}
		});
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.setBounds(500, 523, 170, 49);
		btnIngresar.setFont(new Font("Tahoma", Font.PLAIN, 14)); 
		btnIngresar.setBackground(new Color(173, 216, 230));
		panel.add(btnIngresar);
		btnIngresar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if(!(textNombre.getText().equals("") || comboBox_Unidad.getSelectedItem().equals(""))){
					
					String n = textNombre.getText();
					String p = "";
					String d =  "";
					
					if(!textDescripcion.getText().isEmpty()) {
						 d = textDescripcion.getText();
					}
					
					String u = buscaPa((String) comboBox_Unidad.getSelectedItem());
					String t = buscaRe((String) comboBox_Tipo.getSelectedItem());
					
					System.out.println(u);
					System.out.println(t);
					try {	
						UnidadesDeMedida uni = new UnidadesDeMedida();
						TipoInput tipo =new TipoInput();
						
						String dato3 = "PDT_EJB/Unidad_Tipo_Bean!com.servicios.Unidad_Tipo_BeanRemote";
						Unidad_Tipo_BeanRemote ar = (Unidad_Tipo_BeanRemote) InitialContext.doLookup(dato3);
						uni = ar.findUnidadNombre(u);
						tipo = ar.findTipoNombre(t);	
						
						//////////////
						
						Casilla c = new Casilla(n, d, p, tipo, uni);
						
						String dato = "PDT_EJB/Casilla_Bean!com.servicios.Casilla_BeanRemote";
						Casilla_BeanRemote ca = (Casilla_BeanRemote) InitialContext.doLookup(dato);
						
						if(ca.insert(c)) {
							JOptionPane.showMessageDialog(null, "Casilla ingresada al sistema");
							limpiar();
						}
						
					}catch(Exception ex) {
						JOptionPane.showMessageDialog(null, "No es posible añadir la casilla");
						ex.printStackTrace();
					}
					
				}
				else {
					JOptionPane.showMessageDialog(null, "No es posible añadir la casilla, campos obligatorios sin rellenar");
				}
			}
		});
		comboBox_Unidad = new JComboBox<Object>();
		comboBox_Unidad.setBounds(235, 209, 239, 25);
		comboBox_Unidad.setFont(new Font("Baskerville Old Face", Font.PLAIN, 13));
		comboBox_Unidad.setBackground(SystemColor.menu);
		panel.add(comboBox_Unidad);
		comboBox_Unidad.addItem("");
		
		comboBox_Tipo = new JComboBox<Object>();
		comboBox_Tipo.setBounds(235, 264, 239, 25);
		comboBox_Tipo.setFont(new Font("Baskerville Old Face", Font.PLAIN, 13));
		comboBox_Tipo.setBackground(SystemColor.menu);
		panel.add(comboBox_Tipo);
		
		comboBox_Tipo.addItem("");
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(250, 235, 215));
		panel_1.setBounds(567, 156, 382, 208);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		txtpnDd = new JTextPane();
		txtpnDd.setForeground(new Color(160, 82, 45));
		txtpnDd.setBounds(10, 38, 363, 142);
		panel_1.add(txtpnDd);
		txtpnDd.setEditable(false);
		txtpnDd.setText("\r\nPrimero se debe seleccionar una \"Unidad de Medida\", para que despu\u00E9s se puedan desplegar los correspondientes \"Tipo de Dato\".\r\n\r\nEn caso de que la Casilla a crear, no sea para una unidad de medida espec\u00EDfica, se tiene la opci\u00F3n de N/A (No aplicable) y de la mano tipos de dato como: Texto, Si/No, Fecha, etc. \r\n  \r\n\r\n");
		txtpnDd.setBackground(new Color(255, 250, 240));
		txtpnDd.setBorder(null);
		txtpnDd.setFont(new Font("Baskerville Old Face", Font.PLAIN, 14));
		
		lblNota = new JLabel("Nota:");
		lblNota.setBounds(10, 10, 170, 25);
		panel_1.add(lblNota);
		lblNota.setForeground(new Color(233, 150, 122));
		lblNota.setFont(new Font("Baskerville Old Face", Font.PLAIN, 18));
		
		List<UnidadesDeMedida> unidades = new LinkedList<>();
		try {
			String dato3 = "PDT_EJB/Unidad_Tipo_Bean!com.servicios.Unidad_Tipo_BeanRemote";
			Unidad_Tipo_BeanRemote un = (Unidad_Tipo_BeanRemote) InitialContext.doLookup(dato3);
			unidades = un.allUnidades();
			
		} catch(NamingException ex) {
			System.out.println("error: " + ex.getMessage());
		}
		
		
		
		for(UnidadesDeMedida u : unidades) {
			comboBox_Unidad.addItem(u.getSimbolo() + " ("+ u.getNombre()+ ")");
		}
		
		comboBox_Unidad.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				List<TipoInput> tipos = new LinkedList<>();
				
				try {
					String dato3 = "PDT_EJB/Unidad_Tipo_Bean!com.servicios.Unidad_Tipo_BeanRemote";
					Unidad_Tipo_BeanRemote ti = (Unidad_Tipo_BeanRemote) InitialContext.doLookup(dato3);
					tipos = ti.allTipos();
					
				} catch(NamingException ex) {
					System.out.println("error: " + ex.getMessage());
				}
				
				if(!comboBox_Unidad.getSelectedItem().equals("N/A (No aplicable)") && !comboBox_Unidad.getSelectedItem().equals("")) {
					comboBox_Tipo.removeAllItems(); 
					
					
					for(TipoInput t : tipos) {
						if(!(t.getNombre().equals("Fecha") || t.getNombre().equals("Hora") || t.getNombre().equals("Fecha/Hora") || t.getNombre().equals("Si/No") || t.getNombre().equals("Texto"))){
							String tipo = t.getNombre() + " [" + t.getTipoDato() + "]";
							comboBox_Tipo.addItem(tipo);
						}		
					}
				
				}else if(comboBox_Unidad.getSelectedItem().equals("")) {
					comboBox_Tipo.removeAllItems();
				
				}else {
					comboBox_Tipo.removeAllItems();
					for(TipoInput t : tipos) {
						if(t.getNombre().equals("Fecha") || t.getNombre().equals("Hora") || t.getNombre().equals("Fecha/Hora") || t.getNombre().equals("Si/No") || t.getNombre().equals("Texto")){
							String tipo = t.getNombre() + " [" + t.getTipoDato() + "]";
							comboBox_Tipo.addItem(tipo);
						}
						
					}
				}
			}
			
		});
	}
	public void limpiar() {
		textNombre.setText("");
		textDescripcion.setText("");
		comboBox_Unidad.setSelectedIndex(0);
		
		
	}
	public static String buscaPa(String palabra) {
		
		String resultado = null;
		
		Pattern regex = Pattern.compile("\\((.*?)\\)");
		Matcher frase = regex.matcher(palabra);
		
		while (frase.find()) {
			resultado = frase.group(1);   
		}
		return resultado;
	}
	public static String buscaRe(String palabra) {
		
		String resultado = null;
		
		Pattern regex = Pattern.compile("\\[(.*?)\\]");
		Matcher frase = regex.matcher(palabra);
		
		while (frase.find()) {
			resultado = frase.group(1);   
		}
		return resultado;
	}
	
	
}

