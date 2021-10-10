package Modelo;

public class Investigador extends Usuario{

	private String idInvestigador;
	private String documento;
	private String domicilio;
	private String telefono;
	
	public Investigador() {
	}

	public Investigador(String idInvestigador, String documento, String domicilio, String telefono) {
		super();
		this.idInvestigador = idInvestigador;
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

	public String getIdInvestigador() {
		return idInvestigador;
	}

	public void setIdInvestigador(String idInvestigador) {
		this.idInvestigador = idInvestigador;
	}
}
