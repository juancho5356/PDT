package Controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import Modelo.Usuario;


public class DAO_Usuario {	
	
	private static final String INSERT_USUARIO = "INSERT INTO Usuarios (ID_USUARIO, NOMBRE, APELLIDO, USUARIO, MAIL, CONTRASEÑA) VALUES (SEQ_ID_USUARIO.nextval, ?,?,?,?,?)";
	private static final String BUSCAR_USUARIO_ID= "SELECT * FROM USUARIOS WHERE ID_USUARIO = ?";
	private static final String BUSCAR_USUARIO_MAIL= "SELECT * FROM USUARIOS WHERE MAIL = ?";
	private static final String UPDATE_USUARIO = "UPDATE USUARIOS SET NOMBRE = ?, APELLIDO = ?, USUARI0 = ?, MAIL = ?, CONTRASEÑA = ? WHERE ID_USUARIO = ?";
	private static final String ALL_USUARIOS = "SELECT * FROM USUARIOS ORDER BY 1";
	private static final String DELETE_USUARIO = "DELETE FROM USUARIOS WHERE ID_USUARIO = ?";
	
	public static LinkedList<Usuario> findAll(){
		LinkedList<Usuario> usuarios = new LinkedList<>();
		
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(ALL_USUARIOS);
			
			ResultSet resultado = statement.executeQuery();
			
			while (resultado.next()) {
				Usuario usuario = getUsuarioFromResultSet(resultado);
				usuarios.add(usuario);
			}
			return usuarios;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static boolean delete(Usuario u) {
		try {
			
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(DELETE_USUARIO);
			
			statement.setInt(1, u.getIdUsuario());
			
			int Retorno = statement.executeUpdate();
			
			return Retorno > 0;
		
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean edit(Usuario u, String idUsuario) {
		
	try{
		PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(UPDATE_USUARIO);
		
		statement.setString(1, u.getNombre());
		statement.setString(2, u.getApellido());
		statement.setString(3, u.getNombreUsuario());
		statement.setString(4, u.getMail());
		statement.setString(5, u.getContrasenia());
		statement.setLong(6, u.getIdUsuario());
		
		int Retorno = statement.executeUpdate();
		
		return Retorno > 0;
	
	}catch (SQLException e) {
		e.printStackTrace();
		return false;
	}	 
}
	
	public static boolean insert(Usuario u) {
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(INSERT_USUARIO);
			
			statement.setString(1, u.getNombre());
			statement.setString(2, u.getApellido());
			statement.setString(3, u.getNombreUsuario());
			statement.setString(4, u.getMail());
			statement.setString(5, u.getContrasenia());

			int Retorno = statement.executeUpdate();
			
			return Retorno > 0;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static Usuario findUsuarioId(int id ) {
		
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(BUSCAR_USUARIO_ID);
			
			statement.setLong(1, id);
			
			ResultSet resultado = statement.executeQuery();
			
			Usuario user = null;
			
			while(resultado.next()) {
				user = getUsuarioFromResultSet(resultado);
			}
			return user;
			
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}
	public static Usuario findUsuarioMail(String mail) {
		
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(BUSCAR_USUARIO_MAIL);
			
			statement.setString(1, mail);
			
			ResultSet resultado = statement.executeQuery();
			
			Usuario user = null;
			
			while(resultado.next()) {
				user = getUsuarioFromResultSet(resultado);
			}
			return user;
			
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}
	private static Usuario getUsuarioFromResultSet(ResultSet resultado) throws SQLException {
		
		int id = resultado.getInt("ID_USUARIO");
		String n = resultado.getString("NOMBRE");
		String a = resultado.getString("APELLIDO");
		String nu = resultado.getString("USUARIO");
		String m = resultado.getString("MAIL");
		String c = resultado.getString("CONTRASEÑA");
		
		Usuario u = new Usuario(id, n, a, m, nu, c);
		
		return u;
	}
	
	
}
