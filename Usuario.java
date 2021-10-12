package modelo;

public class Usuario {
	
	private int idUsuario;
	private String nombre;
	private String apellido;
	private String mail;
	private String nombreUsuario;
	private String contrasenia;
	private Tipo_Rol tipo_rol;
	
	public Usuario() {
	}
	
	public Usuario(int id, String nombre, String apellido, String mail, String nombreUsuario,
			String contrasenia) {
		this.idUsuario = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.mail = mail;
		this.nombreUsuario = nombreUsuario;
		this.contrasenia = contrasenia;
	}


	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public Tipo_Rol getTipo_rol() {
		return tipo_rol;
	}

	public void setTipo_rol(Tipo_Rol tipo_rol) {
		this.tipo_rol = tipo_rol;
	}
	
	
}
