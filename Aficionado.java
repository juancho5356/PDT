package Modelo;

public class Aficionado extends Usuario{

	private int idAficionado;
	private String ocupacion;
	
	
	public Aficionado(int idUsuario, String nombre, String apellido, String mail, String nombreUsuario,
			String contrasenia, int idAficionado, String ocupacion) {
		
		super(idUsuario,nombre, apellido, mail, nombreUsuario, contrasenia);
		
		this.idAficionado = idAficionado;
		this.ocupacion = ocupacion;
	}
	public Aficionado(int idUsuario, String nombre, String apellido, String mail, String nombreUsuario,
			String contrasenia, String ocupacion) {
		
		super(idUsuario,nombre, apellido, mail, nombreUsuario, contrasenia);

		this.ocupacion = ocupacion;
	}
	
	public Aficionado() {
	}

	public int getIdAficionado() {
		return idAficionado;
	}

	public void setIdAficionado(int idAficionado) {
		this.idAficionado = idAficionado;
	}

	public String getOcupacion() {
		return ocupacion;
	}

	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}
	
	
	
}
