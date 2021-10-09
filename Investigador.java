package Modelo;

import java.time.LocalDate;
import java.util.LinkedList;

public class Investigador extends Usuario{

	private String documento;
	private String domicilio;
	private String telefono;
	private String contrato;
	private String profesion;
	private LocalDate vtoContrato;
	private LinkedList<String> listaTareas;
	
	public Investigador() {
	}

	public Investigador(String documento, String domicilio, String telefono, String contrato, String profesion,
			LocalDate vtoContrato, LinkedList<String> listaTareas) {
		super();
		this.documento = documento;
		this.domicilio = domicilio;
		this.telefono = telefono;
		this.contrato = contrato;
		this.profesion = profesion;
		this.vtoContrato = vtoContrato;
		this.listaTareas = listaTareas;
	}


	public String getContrato() {
		return contrato;
	}

	public void setContrato(String contrato) {
		this.contrato = contrato;
	}

	public String getProfesion() {
		return profesion;
	}

	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}

	public LocalDate getVtoContrato() {
		return vtoContrato;
	}

	public void setVtoContrato(LocalDate vtoContrato) {
		this.vtoContrato = vtoContrato;
	}

	public LinkedList<String> getListaTareas() {
		return listaTareas;
	}

	public void setListaTareas(LinkedList<String> listaTareas) {
		this.listaTareas = listaTareas;
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
}
