package com.servicios;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.exception.ServiciosException;

import model.TipoInput;
import model.UnidadesDeMedida;

/**
 * Session Bean implementation class Unidad_Tipo_Bean
 */
@Stateless
public class Unidad_Tipo_Bean implements Unidad_Tipo_BeanRemote {

	@PersistenceContext
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public Unidad_Tipo_Bean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<TipoInput> allTipos() {
		TypedQuery<TipoInput> query;
		query = em.createNamedQuery("TipoInput.findAll", TipoInput.class);
		return query.getResultList();
	}

	@Override
	public TipoInput findTipoId(long id) throws ServiciosException{
		try {
    		TypedQuery<TipoInput> query = em.createQuery("SELECT t FROM TipoInput t WHERE t.idTipoInput LIKE :id", TipoInput.class);
			query.setParameter("id", id);
			TipoInput t = query.getSingleResult();
    		return t;

    	}catch(Exception ex) {
    		ex.getMessage();
    		return null;
    	}
	}

	@Override
	public TipoInput findTipoNombre(String nombre) throws ServiciosException{
		try {
    		TypedQuery<TipoInput> query = em.createQuery("SELECT t FROM TipoInput t WHERE t.nombre LIKE :nombre", TipoInput.class);
			query.setParameter("nombre", nombre);
			TipoInput t = query.getSingleResult();
    		return t;

    	}catch(Exception ex) {
    		ex.getMessage();
    		return null;
    	}
	}
	
////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public List<UnidadesDeMedida> allUnidades() {
		TypedQuery<UnidadesDeMedida> query;
		query = em.createNamedQuery("UnidadesDeMedida.findAll", UnidadesDeMedida.class);
		return query.getResultList();
	}

	@Override
	public UnidadesDeMedida findUnidadId(long id) throws ServiciosException{
		try {
    		TypedQuery<UnidadesDeMedida> query = em.createQuery("SELECT u FROM UnidadesDeMedida u WHERE u.idUnidad LIKE :id", UnidadesDeMedida.class);
			query.setParameter("id", id);
			UnidadesDeMedida u = query.getSingleResult();
    		return u;

    	}catch(Exception ex) {
    		ex.getMessage();
    		return null;
    	}
	}

	@Override
	public UnidadesDeMedida findUnidadNombre(String nombre) throws ServiciosException{
		try {
    		TypedQuery<UnidadesDeMedida> query = em.createQuery("SELECT u FROM UnidadesDeMedida u WHERE u.nombre LIKE :nombre", UnidadesDeMedida.class);
			query.setParameter("nombre", nombre);
			UnidadesDeMedida u = query.getSingleResult();
    		return u;

    	}catch(Exception ex) {
    		ex.getMessage();
    		return null;
    	}
	}
    
    

}
