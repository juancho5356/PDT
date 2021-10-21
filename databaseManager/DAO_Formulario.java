package Controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import Modelo.Administrador;
import Modelo.Aficionado;
import Modelo.Formulario;
import Modelo.Investigador;
import Modelo.Usuario;

public class DAO_Formulario {

	private static final String ALL_FORMULARIOS = "SELECT * FROM FORMULARIOS ORDER BY 1";
	private static final String DELETE_FORMULARIO = "DELETE FROM FORMULARIOS WHERE ID_FORMULARIO = ?";
	private static final String BUSCAR_FORMULARIO_NOMBRE_VARIABLE = "SELECT * FROM FORMULARIOS WHERE NOMBRE_VARIABLE = ?";
	private static final String BUSCAR_FORMULARIO_FECHA = "SELECT * FROM FORMULARIOS WHERE FECHA = ?";
	private static final String BUSCAR_FORMULARIO_UBICACION = "SELECT * FROM FORMULARIOS WHERE UBICACION = ?";
	
	public static List<Formulario> findFormularioUbicacion(String ubicacion){
		List<Formulario> formularios = new LinkedList<>();
		
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(BUSCAR_FORMULARIO_UBICACION);
			
			statement.setString(1, ubicacion);
			
			ResultSet resultado = statement.executeQuery();
			
			Formulario formulario = null;
			
			while(resultado.next()) {
				formulario = getFormularioFromResultSet(resultado);
				formularios.add(formulario);
			}
			return formularios;
			
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static List<Formulario> findFormularioFecha(String fecha){
		List<Formulario> formularios = new LinkedList<>();
		
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(BUSCAR_FORMULARIO_FECHA);
			
			statement.setString(1, fecha);
			
			ResultSet resultado = statement.executeQuery();
			
			Formulario formulario = null;
			
			while(resultado.next()) {
				formulario = getFormularioFromResultSet(resultado);
				formularios.add(formulario);
			}
			return formularios;
			
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static List<Formulario> findFormularioNombreVariable(String nombreVariable) {
		List<Formulario> formularios = new LinkedList<>();
		
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(BUSCAR_FORMULARIO_NOMBRE_VARIABLE);
			
			statement.setString(1, nombreVariable);
			
			ResultSet resultado = statement.executeQuery();
			
			Formulario formulario = null;
			
			while(resultado.next()) {
				formulario = getFormularioFromResultSet(resultado);
				formularios.add(formulario);
			}
			return formularios;
			
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}
	
	public static boolean delete(int id) {
		try {
			
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(DELETE_FORMULARIO);
			
			statement.setInt(1, id);
			
			int Retorno = statement.executeUpdate();
			
			return Retorno > 0;
		
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static LinkedList<Formulario> findAll(){
		LinkedList<Formulario> formularios = new LinkedList<>();
		
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(ALL_FORMULARIOS);
			ResultSet resultado = statement.executeQuery();
			
			while (resultado.next()) {
				Formulario formulario = getFormularioFromResultSet(resultado);
				formularios.add(formulario);
			}
			return formularios;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private static Formulario getFormularioFromResultSet(ResultSet resultado) throws SQLException {
		
		int id = resultado.getInt("ID_FORMULARIO");
		Date fecha = resultado.getDate("FECHA");
		String ubicacion = resultado.getString("UBICACION");
		String nombreVariable = resultado.getString("NOMBRE_VARIABLE");
		String metodoMedicion = resultado.getString("METODO_MEDICION");
		int idAdm = resultado.getInt("ID_ADMINISTRADOR");
		int idInv = resultado.getInt("ID_INVESTIGADOR");
		int idAfi = resultado.getInt("ID_AFICIONADO");
		
		Administrador adm = new Administrador();
		adm.setIdAdministrador(idAdm);
		
		Investigador inv = new Investigador();
		inv.setIdInvestigador(idInv);
		
		Aficionado afi = new Aficionado();
		afi.setIdAficionado(idAfi);
		
		Formulario f = new Formulario(id, fecha, ubicacion, nombreVariable, metodoMedicion, adm, inv, afi);
		
		return f;
	}
}
