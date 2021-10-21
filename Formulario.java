package Modelo;

import java.sql.Date;

public class Formulario {

	private int id;
	private Date fecha;
	private String ubicacion;
	private String nombreVariable;
	private String metodoMedicion;
	private String comentarios;
	private Administrador administrador;
	private Investigador investigador;
	private Aficionado aficionado;
	
	public Formulario(int id, Date fecha, String ubicacion, String nombreVariable, String metodoMedicion,
			String comentarios, Administrador administrador, Investigador investigador, Aficionado aficionado) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.ubicacion = ubicacion;
		this.nombreVariable = nombreVariable;
		this.metodoMedicion = metodoMedicion;
		this.comentarios = comentarios;
		this.administrador = administrador;
		this.investigador = investigador;
		this.aficionado = aficionado;
	}
	
	public Formulario(int id2, java.util.Date fecha2, String ubicacion2, String nombreVariable2, String metodoMedicion2, Administrador adm, Investigador inv, Aficionado afi) {
	}
	
	public Formulario() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getNombreVariable() {
		return nombreVariable;
	}

	public void setNombreVariable(String nombreVariable) {
		this.nombreVariable = nombreVariable;
	}

	public String getMetodoMedicion() {
		return metodoMedicion;
	}

	public void setMetodoMedicion(String metodoMedicion) {
		this.metodoMedicion = metodoMedicion;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public Administrador getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}

	public Investigador getInvestigador() {
		return investigador;
	}

	public void setInvestigador(Investigador investigador) {
		this.investigador = investigador;
	}

	public Aficionado getAficionado() {
		return aficionado;
	}

	public void setAficionado(Aficionado aficionado) {
		this.aficionado = aficionado;
	}
}
