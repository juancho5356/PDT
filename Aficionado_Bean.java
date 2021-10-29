package com.servicios;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.exception.ServiciosException;

import model.Aficionado;

/**
 * Session Bean implementation class Aficionado_Bean
 */
@Stateless
public class Aficionado_Bean implements Aficionado_BeanRemote {

    /**
     * Default constructor. 
     */
	@PersistenceContext
	private EntityManager em;
	
    public Aficionado_Bean() {
        // TODO Auto-generated constructor stub
    }

    public Aficionado findAficionado(String user, String contrasenia) throws ServiciosException{
    	
    	try {
    		TypedQuery<Aficionado> query = em.createQuery("SELECT a FROM Aficionado a WHERE a.usuario.nombreUsuario LIKE :user AND a.usuario.contraseña LIKE :contrasenia", Aficionado.class);
			query.setParameter("user", user);
			query.setParameter("contrasenia", contrasenia);
			Aficionado a = query.getSingleResult();
    		return a;

    	}catch(Exception ex) {
    		ex.getMessage();
    		return null;
    	}
		
	}
    
    @Override 
    public Aficionado findUsuario (long id) throws ServiciosException{
    	try {
    		TypedQuery<Aficionado> query = em.createQuery("SELECT a FROM Aficionado a WHERE a.usuario.idUsuario LIKE :id", Aficionado.class);
			query.setParameter("id", id);
			Aficionado a = query.getSingleResult();
			return a;
    	
	    }catch(Exception ex) {
	  		return null;
	  	}
    }
    
	@Override
	public boolean insert(Aficionado af) throws ServiciosException {
    	try {
    		em.persist(af);
    		em.flush();
    		return true;
    	}catch(Exception e) {
    		return false;
    	}
	}
	
	@Override
	public boolean delete(Aficionado aficionado) throws ServiciosException {
		try {
			aficionado = em.find(Aficionado.class, aficionado.getIdAficionado());
			em.remove(aficionado);
			em.flush();
			return true;
		}catch(Exception e) {
    		return false;
		}
		
	}
	
	@Override
	public boolean edit(Aficionado aficionado) throws ServiciosException {
		try {
			em.merge(aficionado);
			em.flush();
			return true;
		}catch(Exception e) {
    		return false;
		}
	}
}
