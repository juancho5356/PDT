package com.servicios;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.exception.ServiciosException;

import model.Usuario;

/**
 * Session Bean implementation class Usuario_Bean
 */
@Stateless
public class Usuario_Bean implements Usuario_BeanRemote {

	@PersistenceContext
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public Usuario_Bean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Usuario findUsuarioMail(String mail) throws ServiciosException {
		try {
			TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.mail LIKE :mail", Usuario.class);
			query.setParameter("mail", mail);
			Usuario u = query.getSingleResult();
			return u;
		}catch(Exception e) {
			return null;
		}
		
	}

	@Override
	public boolean insert(Usuario us) throws ServiciosException {
		try {
    		em.persist(us);
    		em.flush();
    		return true;
    	}catch(Exception e) {
    		return false;
    	}
	}
	
	@Override
	public List<Usuario> allUsuarios() {
		TypedQuery<Usuario> query;
		query = em.createNamedQuery("Usuario.findAll", Usuario.class);
		return query.getResultList();
	}

	@Override
	public List<Usuario> findUsuarioNombre(String nombre) throws  ServiciosException{
		TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.nombre LIKE :nombre", Usuario.class) 
				 .setParameter("nombre", nombre + "%"); 
		return query.getResultList();
	}

	@Override
	public List<Usuario> findUsuarioApellido(String apellido) throws  ServiciosException{
		TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.apellido LIKE :apellido", Usuario.class) 
				 .setParameter("apellido", apellido + "%"); 
		return query.getResultList();
	}

	@Override
	public List<Usuario> findUsuarioNombreUsuario(String nombreUser) throws  ServiciosException{
		TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.nombreUsuario LIKE :nombreUser", Usuario.class) 
				 .setParameter("nombreUser", nombreUser + "%"); 
		return query.getResultList();
	}
	
	@Override
	public boolean delete(Usuario usuario) throws ServiciosException {
		try {
			usuario = em.find(Usuario.class, usuario.getIdUsuario());
			em.remove(usuario);
			em.flush();
			return true;
		}catch(Exception e) {
			return false;
		}
		
	}
	
	@Override
	public boolean edit(Usuario usuario) throws ServiciosException {
		try {
			em.merge(usuario);
			em.flush();
			return true;
		}catch(Exception e) {
    		return false;
		}
	}

	@Override
	public Usuario findId(long id) throws ServiciosException{
		try {
    		TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.idUsuario LIKE :id", Usuario.class);
			query.setParameter("id", id);
			Usuario u = query.getSingleResult();
    		return u;

    	}catch(Exception ex) {
    		ex.getMessage();
    		return null;
    	}
	}

}
