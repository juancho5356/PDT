package com.servicios;

import java.util.List;

import javax.ejb.Remote;

import com.exception.ServiciosException;

import model.Casilla;
import model.FormularioCasilla;

@Remote
public interface FormularioCasilla_BeanRemote {

	public List<FormularioCasilla> findCasillas(long id) throws ServiciosException;
	
	public boolean delete(FormularioCasilla c) throws ServiciosException;
	
	public boolean insert(FormularioCasilla f) throws ServiciosException;
}
