package com.servicios;

import javax.ejb.Stateless;
import javax.persistence.*;

import com.exception.ServiciosException;

import model.Administrador;

/**
 * Session Bean implementation class Administrador_BeanRemote
 */
@Stateless
public class Administrador_Bean implements Administrador_BeanRemote {

    /**
     * Default constructor. 
     */
	@PersistenceContext
	private EntityManager em;
	
    public Administrador_Bean() {
        // TODO Auto-generated constructor stub
    }

    @Override
	public Administrador findAdministrador(String user, String contrasenia) throws ServiciosException{
    	
    	try {
    		TypedQuery<Administrador> query = em.createQuery("SELECT a FROM Administrador a WHERE a.usuario.nombreUsuario LIKE :user AND a.usuario.contraseña LIKE :contrasenia", Administrador.class);
			query.setParameter("user", user);
			query.setParameter("contrasenia", contrasenia);
			Administrador a = query.getSingleResult();
    		return a;

    	}catch(Exception ex) {
    		ex.getMessage();
    		return null;
    	}
		
	}
    @Override 
    public Administrador findUsuario (long id) throws ServiciosException{
    	try {
    		TypedQuery<Administrador> query = em.createQuery("SELECT a FROM Administrador a WHERE a.usuario.idUsuario LIKE :id", Administrador.class);
			query.setParameter("id", id);
			Administrador a = query.getSingleResult();
			return a;
    	
	    }catch(Exception ex) {
	  		return null;
	  	}
    }

    @Override
	public Administrador findAdministradorCedula(long doc)  throws ServiciosException{
    	try {
    		TypedQuery<Administrador> query = em.createQuery("SELECT a FROM Administrador a WHERE a.documento LIKE :doc", Administrador.class);
			query.setParameter("doc", doc);
			Administrador a = query.getSingleResult();
			return a;
    	
	    }catch(Exception ex) {
	  		return null;
	  	}
		
	}
    
    @Override
	public boolean insert(Administrador ad) throws ServiciosException {
    	try {
    		em.persist(ad);
    		em.flush();
    		return true;
    	}catch(Exception e) {
    		return false;
    	}
	}
    
    @Override
	public boolean delete(Administrador ad) throws ServiciosException {
		try {
			ad = em.find(Administrador.class, ad.getIdAdministrador());
			em.remove(ad);
			em.flush();
			return true;
		}catch(Exception e) {
    		return false;
		}
		
	}
	
	@Override
	public boolean edit(Administrador ad) throws ServiciosException {
		try {
			em.merge(ad);
			em.flush();
			return true;
		}catch(Exception e) {
    		return false;
		}
	}
}
