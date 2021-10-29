package vista_desplegables;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.servicios.Departamento_BeanRemote;
import com.servicios.EstacionDeMedicion_BeanRemote;
import com.servicios.Investigador_BeanRemote;
import com.exception.*;

import model.Departamento;
import model.EstacionesDeMedicion;
import model.Investigador;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import vista.LogIn;

import javax.swing.JSeparator;

public class AltaEstacion extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel panel;
	public static String Alta_Estacion;

	private JLabel lblNewLabel;
	private JLabel lblNombre;
	private JTextField textNombre;
	private JLabel lblLatitud;
	private JTextField textLatitud;
	private JLabel lblLongitud;
	private JTextField textLongitud;
	private JLabel lblCalidadDeAire;
	private JTextField textCalidad;
	private JLabel lblHumedadRelativa;
	private JTextField textHumedad;
	private JTextField textUser;
	public JLabel lblUsuario;
	private JLabel lblDepartamento;
	private JComboBox<Object> comboBox_Departamento;
	public JLabel lblUser;
	private JButton btnIngresar;
	private JSeparator separator;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JButton btnLimpiar;
	

	
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
		
		lblUser = new JLabel("");
		lblUser.setBackground(Color.WHITE);
		lblUser.setBounds(710, 158, 239, 23);
		panel.add(lblUser);
		
		lblNewLabel = new JLabel("Alta de Estación");
		lblNewLabel.setFont(new Font("Baskerville Old Face", Font.ITALIC, 27));
		lblNewLabel.setBounds(55, 87, 275, 31);
		panel.add(lblNewLabel);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Baskerville Old Face", Font.PLAIN, 16));
		lblNombre.setBounds(55, 156, 170, 25);
		panel.add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setBounds(235, 156, 239, 25);
		panel.add(textNombre);
		textNombre.setColumns(10);
		
		lblLatitud = new JLabel("Latitud");
		lblLatitud.setFont(new Font("Baskerville Old Face", Font.PLAIN, 16));
		lblLatitud.setBounds(55, 209, 170, 25);
		panel.add(lblLatitud);
		
		textLatitud = new JTextField();
		textLatitud.setColumns(10);
		textLatitud.setBounds(235, 209, 239, 25);
		panel.add(textLatitud);
		
		lblLongitud = new JLabel("Longitud");
		lblLongitud.setFont(new Font("Baskerville Old Face", Font.PLAIN, 16));
		lblLongitud.setBounds(55, 264, 170, 25);
		panel.add(lblLongitud);
		
		textLongitud = new JTextField();
		textLongitud.setColumns(10);
		textLongitud.setBounds(235, 264, 239, 25);
		panel.add(textLongitud);
		
		lblCalidadDeAire = new JLabel("Calidad de Aire");
		lblCalidadDeAire.setFont(new Font("Baskerville Old Face", Font.PLAIN, 16));
		lblCalidadDeAire.setBounds(55, 319, 170, 25);
		panel.add(lblCalidadDeAire);
		
		textCalidad = new JTextField();
		textCalidad.setColumns(10);
		textCalidad.setBounds(235, 319, 239, 25);
		panel.add(textCalidad);
		
		lblHumedadRelativa = new JLabel("Humedad Relativa");
		lblHumedadRelativa.setFont(new Font("Baskerville Old Face", Font.PLAIN, 16));
		lblHumedadRelativa.setBounds(55, 379, 170, 25);
		panel.add(lblHumedadRelativa);
		
		textHumedad = new JTextField();
		textHumedad.setColumns(10);
		textHumedad.setBounds(235, 379, 239, 25);
		panel.add(textHumedad);
		
		textUser = new JTextField();
		textUser.setEditable(false);
		textUser.setBackground(SystemColor.inactiveCaptionBorder);
		textUser.setColumns(10);
		textUser.setBounds(710, 156, 239, 25);
		panel.add(textUser);
		Investigador inves = null;
		
		try {
			String dato2 = "PDT_EJB/Investigador_Bean!com.servicios.Investigador_BeanRemote";
			Investigador_BeanRemote i = (Investigador_BeanRemote) InitialContext.doLookup(dato2);
			
			inves = i.findInvestigador(LogIn.textUsuario.getText(), String.valueOf(LogIn.password.getPassword()));
			
			if(inves != null)
				textUser.setText(inves.getUsuario().getNombre()+" "+ inves.getUsuario().getApellido());
			
		} catch(NamingException | ServiciosException ex) {
			ex.getMessage();
		}
		
		
		
		lblUsuario = new JLabel("Investigador");
		lblUsuario.setFont(new Font("Baskerville Old Face", Font.PLAIN, 16));
		lblUsuario.setBounds(528, 156, 170, 25);
		panel.add(lblUsuario);
		
		lblDepartamento = new JLabel("Departamento");
		lblDepartamento.setFont(new Font("Baskerville Old Face", Font.PLAIN, 16));
		lblDepartamento.setBounds(55, 446, 170, 25);
		panel.add(lblDepartamento);
		
		comboBox_Departamento = new JComboBox<Object>();
		comboBox_Departamento.setFont(new Font("Baskerville Old Face", Font.PLAIN, 14));
		comboBox_Departamento.setBackground(SystemColor.menu);
		comboBox_Departamento.setBounds(235, 447, 239, 23);
		panel.add(comboBox_Departamento);
		comboBox_Departamento.addItem("");
		
		List<Departamento> departamentos = new LinkedList<>();
		
		try {
			String dato3 = "PDT_EJB/Departamento_Bean!com.servicios.Departamento_BeanRemote";
			Departamento_BeanRemote de = (Departamento_BeanRemote) InitialContext.doLookup(dato3);
			departamentos = de.allDepartamentos();
			
		} catch(NamingException ex) {
			ex.getMessage();
		}
		
		for(Departamento d: departamentos) {
			comboBox_Departamento.addItem(d.getNombre());
		}
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnIngresar.setBackground(new Color(173, 216, 230));
		btnIngresar.setBounds(500, 523, 170, 49);
		panel.add(btnIngresar);
		
		separator = new JSeparator();
		separator.setBounds(55, 116, 178, 2);
		panel.add(separator);
		
		lblNewLabel_1 = new JLabel("*");
		lblNewLabel_1.setBounds(29, 156, 15, 13);
		panel.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("*");
		lblNewLabel_2.setBounds(29, 209, 15, 13);
		panel.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("*");
		lblNewLabel_3.setBounds(30, 264, 15, 13);
		panel.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("*");
		lblNewLabel_4.setBounds(29, 319, 15, 13);
		panel.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("*");
		lblNewLabel_5.setBounds(29, 379, 15, 13);
		panel.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("*");
		lblNewLabel_6.setBounds(29, 446, 15, 13);
		panel.add(lblNewLabel_6);
		
		btnLimpiar = new JButton("Limpiar/Cancelar");
		btnLimpiar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLimpiar.setBackground(SystemColor.menu);
		btnLimpiar.setBounds(710, 523, 170, 49);
		panel.add(btnLimpiar);
		btnLimpiar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				limpiar();
			}
			
		});
		
		
		btnIngresar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if(!(textNombre.getText().isEmpty() || textLatitud.getText().isEmpty() || textLongitud.getText().isEmpty() || textCalidad.getText().isEmpty() || textHumedad.getText().isEmpty() || comboBox_Departamento.getSelectedItem().equals(""))) {
					
					String n = textNombre.getText();
					String la = textLatitud.getText();
					String lo = textLongitud.getText();
					String ca = textCalidad.getText();
					String hu = textHumedad.getText();
					
					String d = (String) comboBox_Departamento.getSelectedItem();
					Departamento depa = null;
					try {
						String dato3 = "PDT_EJB/Departamento_Bean!com.servicios.Departamento_BeanRemote";
						Departamento_BeanRemote de = (Departamento_BeanRemote) InitialContext.doLookup(dato3);
						depa = de.findDepartamento(d);
						
					} catch(NamingException | ServiciosException ex) {
						ex.getMessage();
					}
					
					Investigador investigador = null;
					
					try {
						String dato2 = "PDT_EJB/Investigador_Bean!com.servicios.Investigador_BeanRemote";
						Investigador_BeanRemote i = (Investigador_BeanRemote) InitialContext.doLookup(dato2);
						
						investigador = i.findInvestigador(LogIn.textUsuario.getText(), String.valueOf(LogIn.password.getPassword()));

					} catch(NamingException | ServiciosException ex) {
						ex.getMessage();
					}
					
					if(investigador != null) {
						EstacionesDeMedicion estacion = new EstacionesDeMedicion(n,la,lo,ca,hu,investigador,depa);
						
						try {
							String dato3 = "PDT_EJB/EstacionDeMedicion_Bean!com.servicios.EstacionDeMedicion_BeanRemote";
							EstacionDeMedicion_BeanRemote ciu = (EstacionDeMedicion_BeanRemote) InitialContext.doLookup(dato3);

							if(ciu.insert(estacion)) {
								JOptionPane.showMessageDialog(null, "Estacion de Medicion ingresada al sistema");
								limpiar();
							}
							else {
								JOptionPane.showMessageDialog(null, "No es posible añadir esta Estación de Medicion al Sistema");
							}
							
						} catch(NamingException | ServiciosException ex) {
							ex.getMessage();
						}
						
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "No es posible añadir el registro, campos obligatorios sin rellenar");
				}
			}
		});
	}



	public void limpiar() {
		textNombre.setText("");
		textLatitud.setText("");
		textLongitud.setText("");
		textHumedad.setText("");
		textCalidad.setText("");
		comboBox_Departamento.setSelectedItem("");
	}
}
