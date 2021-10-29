package com.servicios;

import java.util.List;

import javax.ejb.Remote;

import com.exception.ServiciosException;

import model.Usuario;

@Remote
public interface Usuario_BeanRemote {

	public Usuario findUsuarioMail(String mail) throws ServiciosException;

	public boolean insert(Usuario us) throws ServiciosException;

	public List<Usuario> allUsuarios();
	
	public List<Usuario> findUsuarioNombre(String nombre) throws  ServiciosException;
	
	public List<Usuario> findUsuarioApellido(String apellido) throws  ServiciosException;
	
	public List<Usuario> findUsuarioNombreUsuario(String nombreUser) throws  ServiciosException;

	public boolean delete(Usuario usuario) throws ServiciosException;

	public boolean edit(Usuario usuario) throws ServiciosException;

	public Usuario findId(long id) throws ServiciosException;


}
