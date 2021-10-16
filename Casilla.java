package cosasSueltas;

public class Casilla {
	String id_casilla;
	String description;
	String parametros ;
	int id_unidad;
	int id_tipo_input;
	
	

	public Casilla(String id_casilla, String description, String parametros, int id_unidad, int id_tipo_input) {
		super();
		this.id_casilla = id_casilla;
		this.description = description;
		this.parametros = parametros;
		this.id_unidad = id_unidad;
		this.id_tipo_input = id_tipo_input;
	}
	public String getId_casilla() {
		return id_casilla;
	}
	public void setId_casilla(String id_casilla) {
		this.id_casilla = id_casilla;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getParametros() {
		return parametros;
	}
	public void setParametros(String parametros) {
		this.parametros = parametros;
	}
	public int getId_unidad() {
		return id_unidad;
	}
	public void setId_unidad(int id_unidad) {
		this.id_unidad = id_unidad;
	}
	public int getId_tipo_input() {
		return id_tipo_input;
	}
	public void setId_tipo_input(int id_tipo_input) {
		this.id_tipo_input = id_tipo_input;
	}
	@Override
	public String toString() {
		return "Casilla [id_casilla=" + id_casilla + ", description=" + description + ", parametros=" + parametros
				+ ", id_unidad=" + id_unidad + ", id_tipo_input=" + id_tipo_input + "]";
	}
	
}
