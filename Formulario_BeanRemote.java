package com.servicios;

import java.util.List;

import javax.ejb.Remote;

import com.exception.ServiciosException;

import model.Formulario;

@Remote
public interface Formulario_BeanRemote {

	boolean delete(Formulario form) throws ServiciosException;

	Formulario findFormularioId(long id) throws ServiciosException;

	List<Formulario> findFormularioNombre(String nombre)  throws ServiciosException;
	
	List<Formulario> findFormularioFecha(String fecha)  throws ServiciosException;
	
	List<Formulario> findAll() throws ServiciosException;
}
