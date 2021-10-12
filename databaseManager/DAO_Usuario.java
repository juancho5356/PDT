package databaseManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Usuario;


public class DAO_Usuario {	
	
	private static final String INSERT_USUARIO = "INSERT INTO Usuarios (ID_USUARIO, NOMBRE, APELLIDO, NOMBRE_USUARIO, MAIL, CONTRASEÑA) VALUES (SEQ_ID_USUARIO.nextval, ?,?,?,?,?)";
	private static final String BUSCAR_USUARIO_ID= "SELECT * FROM USUARIOS WHERE ID_USUARIO = ?";
	private static final String BUSCAR_USUARIO_MAIL= "SELECT * FROM USUARIOS WHERE MAIL = ?";
	
	
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
		String nu = resultado.getString("NOMBRE_USUARIO");
		String m = resultado.getString("MAIL");
		String c = resultado.getString("CONTRASEÑA");
		
		Usuario u = new Usuario(id, n, a, m, nu, c);
		
		return u;
	}
	
	
}
