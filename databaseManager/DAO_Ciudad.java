package Controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import Modelo.Ciudad;

public class DAO_Ciudad {
	
	private static final String ALL_CIUDADES = "SELECT * FROM CIUDADES ORDER BY 2"; 
	private static final String CIUDAD_ID = "SELECT * FROM CIUDADES WHERE ID_CIUDAD = ?"; 
	private static final String CIUDAD_NOMBRE = "SELECT * FROM CIUDADES WHERE NOMBRE = ?"; 

	public static Ciudad findCiudad(int id) {
		
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(CIUDAD_ID);
			
			statement.setLong(1, id);
			
			ResultSet resultado = statement.executeQuery();
			
			Ciudad c = null;
			
			while(resultado.next()) {
				c = getCiudadFromResultSet(resultado);
			}
			return c;
			
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	public static Ciudad findCiudadNombre(String nombre) {
		
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(CIUDAD_NOMBRE);
			
			statement.setString(1, nombre);
			
			ResultSet resultado = statement.executeQuery();
			
			Ciudad c = null;
			
			while(resultado.next()) {
				c = getCiudadFromResultSet(resultado);
			}
			return c;
			
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	public static LinkedList<Ciudad> allCiudades() {
		LinkedList<Ciudad> ciudades = new LinkedList<>();
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(ALL_CIUDADES);
			ResultSet resultado = statement.executeQuery();
			
			Ciudad c = null;
			
			while(resultado.next()) {
				c = getCiudadFromResultSet(resultado);
				ciudades.add(c);
			}
			return ciudades;
			
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	private static Ciudad getCiudadFromResultSet(ResultSet resultado) throws SQLException {
	
		int id = resultado.getInt("ID_CIUDAD");
		String n = resultado.getString("NOMBRE");
		
		Ciudad d = new Ciudad(id, n);
		
		return d;
	}
}
