package databaseManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import modelo.Departamento;

public class DAO_Departamento {
	
	private static final String ALL_DEPARTAMENTOS = "SELECT * FROM DEPARTAMENTOS ORDER BY 2";
	private static final String DEPARTAMENTO_NOMBRE = "SELECT * FROM DEPARTAMENTOS WHERE NOMBRE = ?"; 
	private static final String DEPARTAMENTO_ID = "SELECT * FROM DEPARTAMENTOS WHERE ID_DEPARTAMENTO = ?"; 
	
	
	public static Departamento findDepartamento(String nombre) {
		
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(DEPARTAMENTO_NOMBRE);
			
			statement.setString(1, nombre);
			
			ResultSet resultado = statement.executeQuery();
			
			Departamento d = null;
			
			while(resultado.next()) {
				d = getDepartamentoFromResultSet(resultado);
			}
			return d;
			
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}
	
	public static Departamento findDepartamentoID(int id) {
		
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(DEPARTAMENTO_ID);
			
			statement.setLong(1, id);
			
			ResultSet resultado = statement.executeQuery();
			
			Departamento d = null;
			
			while(resultado.next()) {
				d = getDepartamentoFromResultSet(resultado);
			}
			return d;
			
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}
	
	public static LinkedList<Departamento> allDepartamentos(){
		LinkedList<Departamento> departamentos = new LinkedList<>();
		
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(ALL_DEPARTAMENTOS);
			ResultSet resultado = statement.executeQuery();
			
			Departamento de = null;
			
			while(resultado.next()) {
				de = getDepartamentoFromResultSet(resultado);
				departamentos.add(de);
			}
			return departamentos;
			
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	private static Departamento getDepartamentoFromResultSet(ResultSet resultado) throws SQLException {
	
	int id = resultado.getInt("ID_DEPARTAMENTO");
	String n = resultado.getString("NOMBRE");
	
	Departamento d = new Departamento(id, n);
	
	return d;
}
	
	
}
