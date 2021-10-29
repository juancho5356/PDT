package com.servicios;

import java.util.List;

import javax.ejb.Remote;

import com.exception.ServiciosException;

import model.*;

@Remote
public interface Unidad_Tipo_BeanRemote {

	public List<TipoInput> allTipos();
	
	public TipoInput findTipoId(long id)throws ServiciosException;
	
	public TipoInput findTipoNombre(String nombre)throws ServiciosException;
	
	///////////////////////////////////////////////////////////////
	
	public List<UnidadesDeMedida> allUnidades();
	
	public UnidadesDeMedida findUnidadId(long id)throws ServiciosException;
	
	public UnidadesDeMedida findUnidadNombre(String nombre)throws ServiciosException;

	
}
