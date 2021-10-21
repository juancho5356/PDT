package Modelo;

public class Investigador extends Usuario{
	
	private int idInvestigador;
	private int documento;
	private String domicilio;
	private int telefono;
	private Ciudad ciudad;
	
	public Investigador() {
	}
	
	public Investigador(int idUsuario, String nombre, String apellido, String mail, String nombreUsuario,
			String contrasenia, int documento, String domicilio, int telefono,
			Ciudad ciudad) {
		
		super(idUsuario, nombre, apellido, mail, nombreUsuario, contrasenia);
		this.documento = documento;
		this.domicilio = domicilio;
		this.telefono = telefono;
		this.ciudad = ciudad;
	}

	public Investigador(int idUsuario, String nombre, String apellido, String mail, String nombreUsuario,
			String contrasenia, int id, int documento, String domicilio, int telefono,
			Ciudad ciudad) {
		
		super(idUsuario, nombre, apellido, mail, nombreUsuario, contrasenia);
		this.idInvestigador = id;
		this.documento = documento;
		this.domicilio = domicilio;
		this.telefono = telefono;
		this.ciudad = ciudad;
	}

	public int getIdInvestigador() {
		return idInvestigador;
	}

	public void setIdInvestigador(int idInvestigador) {
		this.idInvestigador = idInvestigador;
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
