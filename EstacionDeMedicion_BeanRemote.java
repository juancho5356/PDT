package com.servicios;

import java.util.*;

import javax.ejb.Remote;

import com.exception.ServiciosException;

import model.EstacionesDeMedicion;
import model.Usuario;

@Remote
public interface EstacionDeMedicion_BeanRemote {

	boolean insert(EstacionesDeMedicion es) throws ServiciosException;

	List<EstacionesDeMedicion> xDepartamento(String departamento);

	List<EstacionesDeMedicion> xNombre(String nombre);

	List<EstacionesDeMedicion> allEstaciones();

	
}
