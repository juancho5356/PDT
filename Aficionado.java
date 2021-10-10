package Modelo;

public class Aficionado extends Usuario{

	private String idAficionado;
	private String ocupacion;
	
	public Aficionado() {
	}

	public Aficionado(String idAficionado, String ocupacion) {
		super();
		this.idAficionado = idAficionado;
		this.ocupacion = ocupacion;
	}

	public String getOcupacion() {
		return ocupacion;
	}

	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}

	public String getIdAficionado() {
		return idAficionado;
	}

	public void setIdAficionado(String idAficionado) {
		this.idAficionado = idAficionado;
	}
}
