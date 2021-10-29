package com.servicios;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.exception.ServiciosException;

import model.EstacionesDeMedicion;
import model.Usuario;

/**
 * Session Bean implementation class EstacionDeMedida_Bean
 */
@Stateless
public class EstacionDeMedicion_Bean implements EstacionDeMedicion_BeanRemote {

	@PersistenceContext
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public EstacionDeMedicion_Bean() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public List<EstacionesDeMedicion> allEstaciones() {
		TypedQuery<EstacionesDeMedicion> query;
		query = em.createNamedQuery("EstacionesDeMedicion.findAll", EstacionesDeMedicion.class);
		return query.getResultList();
	}
    
    @Override
	public boolean insert(EstacionesDeMedicion es) throws ServiciosException {
    	try {
    		em.persist(es);
    		em.flush();
    		return true;
    	}catch(Exception e) {
    		return false;
    	}
	}

	@Override
	public List<EstacionesDeMedicion> xDepartamento(String departamento) {
		 TypedQuery<EstacionesDeMedicion> query = em.createQuery("SELECT e FROM EstacionesDeMedicion e WHERE e.departamento.nombre LIKE :departamento", EstacionesDeMedicion.class) 
				 .setParameter("departamento", departamento); 
				 return query.getResultList();
	}

	@Override
	public List<EstacionesDeMedicion> xNombre(String nombre) {
		TypedQuery<EstacionesDeMedicion> query = em.createQuery("SELECT e FROM EstacionesDeMedicion e WHERE e.nombre LIKE :nombre", EstacionesDeMedicion.class) 
				 .setParameter("nombre", nombre +"%"); 
				 return query.getResultList();
	}

}
