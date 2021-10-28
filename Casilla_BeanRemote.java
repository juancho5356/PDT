package com.servicios;

import java.util.List;

import javax.ejb.Remote;

import com.exception.ServiciosException;

import model.*;

@Remote
public interface Casilla_BeanRemote {

	boolean delete(Casilla c) throws ServiciosException;

	boolean insert(Casilla c) throws ServiciosException;

	boolean edit(Casilla c) throws ServiciosException;
	
	Casilla findCasilla(String nombre) throws ServiciosException;

	List<Casilla> allCasillas();
}
