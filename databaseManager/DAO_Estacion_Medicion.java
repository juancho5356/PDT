package Controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import Modelo.*;

public class DAO_Estacion_Medicion {
	
	private static final String INSERT_ESTACION = "INSERT INTO Estaciones_De_Medicion (ID_ESTACION, NOMBRE, LATITUD, LONGITUD, CALIDAD_AIRE, HUMEDAD_RELATIVA, ID_INVESTIGADOR, ID_DEPARTAMENTO) VALUES (SEQ_ID_ESTACION_DE_MEDICION.nextval,?,?,?,?,?,?,?)"; 
	
	private static final String NOMBRE_ESTACION = "SELECT * FROM Estaciones_De_Medicion WHERE NOMBRE LIKE ? ORDER BY 2"; 
	private static final String DEPARTAMENTO_ESTACION = "SELECT * FROM Estaciones_De_Medicion WHERE ID_DEPARTAMENTO = ?"; 

	public static boolean insert(Estacion_Medicion es) {
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(INSERT_ESTACION);
			
			statement.setString(1, es.getNombre());
			statement.setString(2, es.getLatitud());
			statement.setString(3, es.getLongitud());
			statement.setString(4, es.getCalidad_aire());
			statement.setString(5, es.getHumedad_relativa());
			statement.setLong(6, es.getInvestigador().getIdInvestigador());
			statement.setLong(7, es.getDepartamento().getIdDepartamento());
			
			
			int Retorno = statement.executeUpdate();			
			return Retorno > 0;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static LinkedList<Estacion_Medicion> xDepartamento(String departamento){
		LinkedList<Estacion_Medicion> estaciones = new LinkedList<>();
		
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(DEPARTAMENTO_ESTACION);
			Departamento d = DAO_Departamento.findDepartamento(departamento);
			
			statement.setLong(1, d.getIdDepartamento());
			ResultSet resultado = statement.executeQuery();
			
			Estacion_Medicion em = null;
			
			while(resultado.next()) {
				em = getEstacionFromResultSet(resultado);
				estaciones.add(em);
			}
			return estaciones;
			
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	public static LinkedList<Estacion_Medicion> xNombre(String nombre){
		LinkedList<Estacion_Medicion> estaciones = new LinkedList<>();
		
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(NOMBRE_ESTACION);
			statement.setString(1, nombre+ "%");
			ResultSet resultado = statement.executeQuery();
			
			Estacion_Medicion em = null;
			
			while(resultado.next()) {
				em = getEstacionFromResultSet(resultado);
				estaciones.add(em);
			}
			return estaciones;
			
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private static Estacion_Medicion getEstacionFromResultSet(ResultSet resultado) throws SQLException{
		
		int id = resultado.getInt("ID_ESTACION");
		String n = resultado.getString("NOMBRE");
		String la = resultado.getString("LATITUD");
		String lo = resultado.getString("LONGITUD");
		String ca = resultado.getString("CALIDAD_AIRE");
		String hr = resultado.getString("HUMEDAD_RELATIVA");
		
		Investigador inv = DAO_Investigador.findInvestigadorID(resultado.getInt("ID_INVESTIGADOR"));
		Departamento d = DAO_Departamento.findDepartamentoID(resultado.getInt("ID_DEPARTAMENTO"));
		
		Estacion_Medicion est = new Estacion_Medicion(id, n, la, lo, ca, hr, inv, d);
		
		return est;	
	}
	

	
}
