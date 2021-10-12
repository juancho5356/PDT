package modelo;

public class Estacion_Medicion {
	
	private int id;
	private String nombre;
	private String latitud;
	private String longitud;
	private String calidad_aire;
	private String humedad_relativa;
	private Investigador investigador;
	private Departamento departamento;
	
	public Estacion_Medicion() {
	}
	
	public Estacion_Medicion(int id, String nombre, String latitud, String longitud, String calidad_aire,
			String humedad_relativa, Investigador investigador, Departamento departamento) {
		this.id = id;
		this.nombre = nombre;
		this.latitud = latitud;
		this.longitud = longitud;
		this.calidad_aire = calidad_aire;
		this.humedad_relativa = humedad_relativa;
		this.investigador = investigador;
		this.departamento = departamento;
	}
	public Estacion_Medicion(String nombre, String latitud, String longitud, String calidad_aire,
			String humedad_relativa, Investigador investigador, Departamento departamento) {
		this.nombre = nombre;
		this.latitud = latitud;
		this.longitud = longitud;
		this.calidad_aire = calidad_aire;
		this.humedad_relativa = humedad_relativa;
		this.investigador = investigador;
		this.departamento = departamento;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getLatitud() {
		return latitud;
	}
	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}
	public String getLongitud() {
		return longitud;
	}
	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}
	public String getCalidad_aire() {
		return calidad_aire;
	}
	public void setCalidad_aire(String calidad_aire) {
		this.calidad_aire = calidad_aire;
	}
	public String getHumedad_relativa() {
		return humedad_relativa;
	}
	public void setHumedad_relativa(String humedad_relativa) {
		this.humedad_relativa = humedad_relativa;
	}
	public Investigador getInvestigador() {
		return investigador;
	}
	public void setInvestigador(Investigador investigador) {
		this.investigador = investigador;
	}
	public Departamento getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	
	
}
