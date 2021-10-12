package databaseManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.*;

public class DAO_Administrador {
	private static final String INSERT_ADMINISTRADOR = "INSERT INTO administradores (ID_administrador, DOCUMENTO, DOMICILIO, TELEFONO, ID_USUARIO, ID_CIUDAD) VALUES (SEQ_ID_ADMINISTRADOR.nextval, ?,?,?,?,?)";
	private static final String BUSCAR_ADMINISTRADOR= "SELECT * FROM administradores a INNER JOIN usuarios u ON a.id_usuario = u.id_usuario WHERE u.nombre_usuario= ? AND u.\"CONTRASEÑA\"= ?";
	private static final String BUSCAR_ADMINISTRADOR_ID= "SELECT * FROM administradores WHERE ID_ADMINISTRADOR = ?";
	private static final String BUSCAR_ADMINISTRADOR_CEDULA= "SELECT * FROM administradores WHERE DOCUMENTO = ?";

		public static boolean insert(Administrador a) {
			try {
				PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(INSERT_ADMINISTRADOR);
				
				statement.setLong(1, a.getDocumento());
				statement.setString(2, a.getDomicilio());
				statement.setLong(3, a.getTelefono());
				statement.setLong(4, a.getIdUsuario());
				statement.setLong(5, a.getCiudad().getIdCiudad());

				int Retorno = statement.executeUpdate();
				
				return Retorno > 0;
				
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
		public static Administrador findAdministrador(String nombreUsuario, String contrasenia) {
			
			try {
				PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(BUSCAR_ADMINISTRADOR);
				
				statement.setString(1, nombreUsuario);
				statement.setString(2, contrasenia);
				
				ResultSet resultado = statement.executeQuery();
				
				Administrador ad = null;
				
				while(resultado.next()) {
					ad = getAdministradorFromResultSet(resultado);
				}
				return ad;
				
			}catch (SQLException e) {
				e.printStackTrace();
				return null;
			}

		}
		public static Administrador findAdministradorCedula(int cedula) {
			
			try {
				PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(BUSCAR_ADMINISTRADOR_CEDULA);
				
				statement.setLong(1, cedula);
				
				ResultSet resultado = statement.executeQuery();
				
				Administrador ad = null;
				
				while(resultado.next()) {
					ad = getAdministradorFromResultSet(resultado);
				}
				return ad;
				
			}catch (SQLException e) {
				e.printStackTrace();
				return null;
			}

		}
		public static Administrador findAdministradorID(int id ) {
			
			try {
				PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(BUSCAR_ADMINISTRADOR_ID);
				
				statement.setLong(1, id);
				
				ResultSet resultado = statement.executeQuery();
				
				Administrador ad = null;
				
				while(resultado.next()) {
					ad = getAdministradorFromResultSet(resultado);
				}
				return ad;
				
			}catch (SQLException e) {
				e.printStackTrace();
				return null;
			}

		}
		private static Administrador getAdministradorFromResultSet(ResultSet resultado) throws SQLException {
			
			int id = resultado.getInt("ID_ADMINISTRADOR");
			int doc = resultado.getInt("DOCUMENTO");
			String dom = resultado.getString("DOMICILIO");
			int t = resultado.getInt("TELEFONO");
			
			Ciudad c = DAO_Ciudad.findCiudad(resultado.getInt("ID_CIUDAD"));
			Usuario u = DAO_Usuario.findUsuarioId(resultado.getInt("ID_USUARIO"));
			
			Administrador admin = new Administrador(u.getIdUsuario(),u.getNombre(), u.getApellido(), u.getMail(), u.getNombreUsuario(), u.getContrasenia(), id, doc, dom, t, c);
			admin.setIdAdministrador(id);;
			admin.setTipo_rol(Tipo_Rol.ADMINISTRADOR);
			
			return admin;
		}
}
