package databaseManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import modelo.Tipo_Input;
import modelo.Unidad_Medida;

public class DAO_Unidad_Tipo {
	
	public static final String UNIDADES_MEDIDA = "SELECT * FROM UNIDADES_DE_MEDIDA WHERE ID_UNIDAD = ?";
	public static final String ALL_UNIDADES = "SELECT * FROM UNIDADES_DE_MEDIDA ORDER BY 2";
	public static final String UNIDADES_MEDIDA_NOMBRE = "SELECT * FROM UNIDADES_DE_MEDIDA WHERE NOMBRE = ?";
	
	public static Unidad_Medida findUnidad(int id) {
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(UNIDADES_MEDIDA);
			
			statement.setLong(1, id);
			
			ResultSet resultado = statement.executeQuery();
			
			Unidad_Medida u = null;
			
			while(resultado.next()) {
				u = getUnidadFromResultSet(resultado);
			}
			return u;
			
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	public static Unidad_Medida findUnidad_Nombre(String nombre) {
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(UNIDADES_MEDIDA_NOMBRE);
			
			statement.setString(1, nombre);
			
			ResultSet resultado = statement.executeQuery();
			
			Unidad_Medida u = null;
			
			while(resultado.next()) {
				u = getUnidadFromResultSet(resultado);
			}
			return u;
			
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	public static LinkedList<Unidad_Medida> all_Unidades(){
		LinkedList<Unidad_Medida> unidades = new LinkedList<>();
		
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(ALL_UNIDADES);
						
			ResultSet resultado = statement.executeQuery();
			
			Unidad_Medida u = null;
			
			while(resultado.next()) {
				u = getUnidadFromResultSet(resultado);
				unidades.add(u);
			}
			return unidades;
			
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	private static Unidad_Medida getUnidadFromResultSet(ResultSet resultado) throws SQLException {
		
		int id = resultado.getInt("ID_UNIDAD");
		String n = resultado.getString("NOMBRE");
		String s = resultado.getString("SIMBOLO");
		
		Unidad_Medida un = new Unidad_Medida(id,n,s);
		
		return un;
	}
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	public static final String TIPO_INPUT= "SELECT * FROM TIPO_INPUT WHERE ID_TIPO_INPUT = ?";
	public static final String ALL_TIPO_INPUT = "SELECT * FROM TIPO_INPUT ORDER BY 2";
	public static final String TIPO_INPUT_TIPO = "SELECT * FROM TIPO_INPUT WHERE TIPO_DATO = ?";

	public static Tipo_Input findTipo(int id) {
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(TIPO_INPUT);
			
			statement.setLong(1, id);
			
			ResultSet resultado = statement.executeQuery();
			
			Tipo_Input t = null;
			
			while(resultado.next()) {
				t = getTipo_InputFromResultSet(resultado);
			}
			return t;
			
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Tipo_Input findTipo_Tipo(String tipo) {
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(TIPO_INPUT_TIPO);
			
			statement.setString(1, tipo);
			
			ResultSet resultado = statement.executeQuery();
			
			Tipo_Input t = null;
			
			while(resultado.next()) {
				t = getTipo_InputFromResultSet(resultado);
			}
			return t;
			
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	public static LinkedList<Tipo_Input> all_Tipos(){
		LinkedList<Tipo_Input> tipos = new LinkedList<>();
		
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(ALL_TIPO_INPUT);
						
			ResultSet resultado = statement.executeQuery();
			
			Tipo_Input t = null;
			
			while(resultado.next()) {
				t = getTipo_InputFromResultSet(resultado);
				tipos.add(t);
			}
			return tipos;
			
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	private static Tipo_Input getTipo_InputFromResultSet(ResultSet resultado) throws SQLException {
		
		int id = resultado.getInt("ID_TIPO_INPUT");
		String n = resultado.getString("NOMBRE");
		String s = resultado.getString("TIPO_DATO");
		
		Tipo_Input un = new Tipo_Input(id,n,s);
		
		return un;
	}
}
