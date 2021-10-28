package com.servicios;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.exception.ServiciosException;

import model.Casilla;

/**
 * Session Bean implementation class Casilla_Bean
 */
@Stateless
public class Casilla_Bean implements Casilla_BeanRemote {

    /**
     * Default constructor. 
     */
	@PersistenceContext
	private EntityManager em;
	
    public Casilla_Bean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public boolean delete(Casilla c) throws ServiciosException {
		try {
			c = em.find(Casilla.class, c.getIdCasilla());
			em.remove(c);
			em.flush();
			return true;
		}catch(Exception e) {
			return false;
		}
	}

	@Override
	public boolean insert(Casilla c) throws ServiciosException {
		try {
    		em.persist(c);
    		em.flush();
    		return true;
    	}catch(Exception e) {
    		return false;
    	}
	}

	@Override
	public boolean edit(Casilla c) throws ServiciosException {
		try {
			em.merge(c);
			em.flush();
			return true;
		}catch(Exception e) {
    		return false;
		}
	}

	@Override
	public Casilla findCasilla(String nombre) throws ServiciosException {
		try {
    		TypedQuery<Casilla> query = em.createQuery("SELECT c FROM Casilla c WHERE c.nombre LIKE :nombre", Casilla.class);
			query.setParameter("nombre", nombre);
			Casilla c = query.getSingleResult();
			return c;
    	
	    }catch(Exception ex) {
	  		return null;
	  	}
	}

	@Override
	public List<Casilla> allCasillas() {
		TypedQuery<Casilla> query;
		query= em.createNamedQuery("Casilla.findAll", Casilla.class);
		
		return query.getResultList();
	}
    
    

}
