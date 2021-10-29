package com.servicios;

import javax.ejb.Remote;

import com.exception.ServiciosException;

import model.Investigador;

@Remote
public interface Investigador_BeanRemote {

	Investigador findInvestigadorCedula(long doc) throws ServiciosException;

	Investigador findInvestigador(String user, String contrasenia) throws ServiciosException;

	boolean insert(Investigador in) throws ServiciosException;

	boolean edit(Investigador investigador) throws ServiciosException;

	boolean delete(Investigador investigador) throws ServiciosException;

	Investigador findUsuario(long id) throws ServiciosException;

}
