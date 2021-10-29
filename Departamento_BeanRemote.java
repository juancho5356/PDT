package com.servicios;

import java.util.List;

import javax.ejb.Remote;

import com.exception.ServiciosException;

import model.Departamento;

@Remote
public interface Departamento_BeanRemote {

	List<Departamento> allDepartamentos();

	Departamento findDepartamento(String departamento) throws ServiciosException;

	
}
