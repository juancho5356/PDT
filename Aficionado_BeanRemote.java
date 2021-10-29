package com.servicios;

import javax.ejb.Remote;

import com.exception.ServiciosException;

import model.Aficionado;

@Remote
public interface Aficionado_BeanRemote {

	public Aficionado findAficionado(String user, String contrasenia) throws ServiciosException;

	boolean insert(Aficionado af) throws ServiciosException;

	boolean edit(Aficionado aficionado) throws ServiciosException;

	boolean delete(Aficionado aficionado) throws ServiciosException;

	Aficionado findUsuario(long id) throws ServiciosException;
}
