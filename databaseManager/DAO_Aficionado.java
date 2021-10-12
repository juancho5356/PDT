package databaseManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.*;

public class DAO_Aficionado {

	private static final String INSERT_AFICIONADO = "INSERT INTO aficionados (ID_aficionado, Ocupacion, ID_USUARIO) VALUES (SEQ_ID_AFICIONADO.nextval,?,?)";
	private static final String BUSCAR_AFICIONADO= "SELECT * FROM aficionados a INNER JOIN usuarios u ON a.id_usuario = u.id_usuario WHERE u.nombre_usuario= ? AND u.\"CONTRASEÑA\"= ?";
	private static final String BUSCAR_AFICIONADO_ID= "SELECT * FROM aficionados WHERE ID_AFICIONADO = ?";

		public static boolean insert(Aficionado a) {
			try {
				PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(INSERT_AFICIONADO);
				
				statement.setString(1, a.getOcupacion());
				statement.setLong(2, a.getIdUsuario());

				int Retorno = statement.executeUpdate();
				
				return Retorno > 0;
				
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
		public static Aficionado findAficionado(String nombreUsuario, String contrasenia) {
			
			try {
				PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(BUSCAR_AFICIONADO);
				
				statement.setString(1, nombreUsuario);
				statement.setString(2, contrasenia);
				
				ResultSet resultado = statement.executeQuery();
				
				Aficionado af = null;
				
				while(resultado.next()) {
					af = getAficionadoFromResultSet(resultado);
				}
				return af;
				
			}catch (SQLException e) {
				e.printStackTrace();
				return null;
			}

		}
		public static Aficionado findAficionadoID(int id ) {
			
			try {
				PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(BUSCAR_AFICIONADO_ID);
				
				statement.setLong(1, id);
				
				ResultSet resultado = statement.executeQuery();
				
				Aficionado af = null;
				
				while(resultado.next()) {
					af = getAficionadoFromResultSet(resultado);
				}
				return af;
				
			}catch (SQLException e) {
				e.printStackTrace();
				return null;
			}

		}
		private static Aficionado getAficionadoFromResultSet(ResultSet resultado) throws SQLException {
			
			int id = resultado.getInt("ID_AFICIONADO");
			String oc = resultado.getString("OCUPACION");
			
			Usuario u = DAO_Usuario.findUsuarioId(resultado.getInt("ID_USUARIO"));
			
			Aficionado afi = new Aficionado(u.getIdUsuario(),u.getNombre(), u.getApellido(), u.getMail(), u.getNombreUsuario(), u.getContrasenia(), oc);
			afi.setIdAficionado(id);
			afi.setTipo_rol(Tipo_Rol.AFICIONADO);
			
			return afi;
		}
}
