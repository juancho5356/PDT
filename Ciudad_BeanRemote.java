package com.servicios;

import java.util.*;

import javax.ejb.Remote;

import model.Ciudad;

@Remote
public interface Ciudad_BeanRemote {

	public List<Ciudad> allCiudades();

	public Ciudad findCiudadNombre(String ciudad);

}
