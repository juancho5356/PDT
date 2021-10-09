package Modelo;

public class Usuario {

	private String idUsuario;
	private String nombre;
	private String apellido;
	private String mail;
	private String nombreUsuario;
	private String contrase�a;
	private Tipo tipoUsuario;
	
	public Usuario() {
	}

	public Usuario(String idUsuario, String nombre, String apellido, String mail, String nombreUsuario,
			String contrase�a, Tipo tipoUsuario) {
		super();
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.mail = mail;
		this.nombreUsuario = nombreUsuario;
		this.contrase�a = contrase�a;
		this.tipoUsuario = tipoUsuario;
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
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

	public String getContrase�a() {
		return contrase�a;
	}

	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}

	public Tipo getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(Tipo tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
}
