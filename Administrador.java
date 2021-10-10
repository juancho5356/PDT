package Modelo;

public class Administrador extends Usuario{

	private String idAdministrador;
	private String documento;
	private String domicilio;
	private String telefono;

	public Administrador() {
	}

	
	public Administrador(String idAdministrador, String documento, String domicilio, String telefono) {
		super();
		this.idAdministrador = idAdministrador;
		this.documento = documento;
		this.domicilio = domicilio;
		this.telefono = telefono;
	}


	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getIdAdministrador() {
		return idAdministrador;
	}

	public void setIdAdministrador(String idAdministrador) {
		this.idAdministrador = idAdministrador;
	}
}