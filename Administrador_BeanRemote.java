package com.servicios;

import javax.ejb.Remote;

import com.exception.ServiciosException;

import model.Administrador;

@Remote
public interface Administrador_BeanRemote {

	public Administrador findAdministrador(String user, String contrasenia) throws ServiciosException;
	
	public Administrador findAdministradorCedula(long doc)  throws ServiciosException;

	boolean insert(Administrador ad) throws ServiciosException;

	boolean delete(Administrador ad) throws ServiciosException;

	boolean edit(Administrador ad) throws ServiciosException;

	Administrador findUsuario(long id) throws ServiciosException;
}
