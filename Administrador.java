package Modelo;

public class Administrador extends Usuario{
	
	private int idAdministrador;
	private int documento;
	private String domicilio;
	private int telefono;
	private Ciudad ciudad;
	
	public Administrador() {
	}
 	
	public Administrador(int idUsuario, String nombre, String apellido, String mail, String nombreUsuario,
			String contrasenia, int idAdministrador, int documento, String domicilio, int telefono, Ciudad ciudad) {
		
		super(idUsuario, nombre, apellido, mail, nombreUsuario, contrasenia);
		
		this.idAdministrador = idAdministrador;
		this.documento = documento;
		this.domicilio = domicilio;
		this.telefono = telefono;
		this.ciudad = ciudad;
	}
	
	public Administrador(int idUsuario, String nombre, String apellido, String mail, String nombreUsuario,
			String contrasenia, int documento, String domicilio, int telefono,
			Ciudad ciudad) {
		
		super(idUsuario, nombre, apellido, mail, nombreUsuario, contrasenia);
		
		this.documento = documento;
		this.domicilio = domicilio;
		this.telefono = telefono;
		this.ciudad = ciudad;
	}

	public int getIdAdministrador() {
		return idAdministrador;
	}

	public void setIdAdministrador(int idAdministrador) {
		this.idAdministrador = idAdministrador;
	}

	public int getDocumento() {
		return documento;
	}

	public void setDocumento(int documento) {
		this.documento = documento;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}
	
}
