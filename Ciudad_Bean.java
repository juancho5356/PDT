package com.servicios;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import model.Ciudad;

/**
 * Session Bean implementation class Ciudad_Bean
 */
@Stateless
public class Ciudad_Bean implements Ciudad_BeanRemote {

	@PersistenceContext
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public Ciudad_Bean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Ciudad> allCiudades() {
		TypedQuery<Ciudad> query;
		query = em.createNamedQuery("Ciudad.findAll", Ciudad.class);
		return query.getResultList();
	}

	@Override
	public Ciudad findCiudadNombre(String ciudad) {
		TypedQuery<Ciudad> query = em.createQuery("SELECT c FROM Ciudad c WHERE c.nombre LIKE :ciudad", Ciudad.class);
		query.setParameter("ciudad", ciudad);
		Ciudad c = query.getSingleResult();
	return c;
	}

}
