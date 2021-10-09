package Modelo;

import java.util.LinkedList;

public class Aficionado extends Usuario{

	private String ocupacion;
	private String direcicon;
	private String celular;
	private LinkedList<String> listaTareas;
	
	public Aficionado() {
	}

	public Aficionado(String ocupacion, String direcicon, String celular, LinkedList<String> listaTareas) {
		super();
		this.ocupacion = ocupacion;
		this.direcicon = direcicon;
		this.celular = celular;
		this.listaTareas = listaTareas;
	}


	public String getDirecicon() {
		return direcicon;
	}

	public void setDirecicon(String direcicon) {
		this.direcicon = direcicon;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public LinkedList<String> getListaTareas() {
		return listaTareas;
	}

	public void setListaTareas(LinkedList<String> listaTareas) {
		this.listaTareas = listaTareas;
	}

	public String getOcupacion() {
		return ocupacion;
	}

	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}
}
