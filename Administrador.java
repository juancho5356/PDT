package Modelo;

import java.util.LinkedList;

public class Administrador extends Usuario{

	private String documento;
	private String instituto;
	private String domicilio;
	private String telefono;
	private LinkedList<String> listaTareas;

	public Administrador() {
	}

	public Administrador(String documento, String instituto, String domicilio, String telefono,
			LinkedList<String> listaTareas) {
		super();
		this.documento = documento;
		this.instituto = instituto;
		this.domicilio = domicilio;
		this.telefono = telefono;
		this.listaTareas = listaTareas;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getInstituto() {
		return instituto;
	}

	public void setInstituto(String instituto) {
		this.instituto = instituto;
	}

	public LinkedList<String> getListaTareas() {
		return listaTareas;
	}

	public void setListaTareas(LinkedList<String> listaTareas) {
		this.listaTareas = listaTareas;
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
}