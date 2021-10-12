package databaseManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Ciudad;
import modelo.Investigador;
import modelo.Tipo_Rol;
import modelo.Usuario;

public class DAO_Investigador {

private static final String INSERT_INVESTIGADOR = "INSERT INTO investigadores (ID_INVESTIGADOR, DOCUMENTO, DOMICILIO, TELEFONO, ID_USUARIO, ID_CIUDAD) VALUES (SEQ_ID_INVESTIGADOR.nextval, ?,?,?,?,?)";
private static final String BUSCAR_INVESTIGADOR_ID= "SELECT * FROM investigadores WHERE ID_INVESTIGADOR = ?";
private static final String BUSCAR_INVESTIGADOR= "SELECT * FROM investigadores a INNER JOIN usuarios u ON a.id_usuario = u.id_usuario WHERE u.nombre_usuario= ? AND u.\"CONTRASEÑA\"= ?";
private static final String BUSCAR_INVESTIGADOR_CEDULA= "SELECT * FROM investigadores WHERE DOCUMENTO = ?";


	public static boolean insert(Investigador i) {
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(INSERT_INVESTIGADOR);
			
			statement.setLong(1, i.getDocumento());
			statement.setString(2, i.getDomicilio());
			statement.setLong(3, i.getTelefono());
			statement.setLong(4, i.getIdUsuario());
			statement.setLong(5, i.getCiudad().getIdCiudad());

			int Retorno = statement.executeUpdate();
			
			return Retorno > 0;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public static Investigador findInvestigador(String nombreUsuario, String contrasenia) {
		
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(BUSCAR_INVESTIGADOR);
			
			statement.setString(1, nombreUsuario);
			statement.setString(2, contrasenia);
			
			ResultSet resultado = statement.executeQuery();
			
			Investigador inv = null;
			
			while(resultado.next()) {
				inv = getInvestigadorFromResultSet(resultado);
			}
			return inv;
			
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}
	public static Investigador findInvestigadorID(int id ) {
		
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(BUSCAR_INVESTIGADOR_ID);
			
			statement.setLong(1, id);
			
			ResultSet resultado = statement.executeQuery();
			
			Investigador inv = null;
			
			while(resultado.next()) {
				inv = getInvestigadorFromResultSet(resultado);
			}
			return inv;
			
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}
	public static Investigador findInvestigadorCedula(int cedula) {
		
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(BUSCAR_INVESTIGADOR_CEDULA);
			
			statement.setLong(1, cedula);
			
			ResultSet resultado = statement.executeQuery();
			
			Investigador inv = null;
			
			while(resultado.next()) {
				inv = getInvestigadorFromResultSet(resultado);
			}
			return inv;
			
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}
	private static Investigador getInvestigadorFromResultSet(ResultSet resultado) throws SQLException {
		
		int id = resultado.getInt("ID_INVESTIGADOR");
		int doc = resultado.getInt("DOCUMENTO");
		String dom = resultado.getString("DOMICILIO");
		int t = resultado.getInt("TELEFONO");
		
		Ciudad c = DAO_Ciudad.findCiudad(resultado.getInt("ID_CIUDAD"));
		Usuario u = DAO_Usuario.findUsuarioId(resultado.getInt("ID_USUARIO"));
		
		Investigador inv = new Investigador(u.getIdUsuario(),u.getNombre(), u.getApellido(), u.getMail(), u.getNombreUsuario(), u.getContrasenia(), id, doc, dom, t, c);
		inv.setIdInvestigador(id);;
		inv.setTipo_rol(Tipo_Rol.INVESTIGADOR);
		
		return inv;
	}
}
