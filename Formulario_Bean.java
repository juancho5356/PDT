package com.servicios;

import java.util.LinkedList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.exception.ServiciosException;

import model.Formulario;

/**
 * Session Bean implementation class Formulario_Bean
 */
@Stateless
public class Formulario_Bean implements Formulario_BeanRemote {

    /**
     * Default constructor. 
     */
	
	@PersistenceContext
	private EntityManager em;
    public Formulario_Bean() {
        // TODO Auto-generated constructor stub
    }

    @Override
	public boolean delete(Formulario form) throws ServiciosException {
		try {
			form = em.find(Formulario.class, form.getIdFormulario());
			em.remove(form);
			em.flush();
			return true;
		}catch(Exception e) {
    		return false;
		}
		
	}
    
	@Override
   	public Formulario findFormularioId(long id)  throws ServiciosException{
       	try {
       		TypedQuery<Formulario> query = em.createQuery("SELECT f FROM Formulario f WHERE f.idFormulario LIKE :id", Formulario.class);
   			query.setParameter("id", id);
   			Formulario f = query.getSingleResult();
   			return f;
       	
   	    }catch(Exception ex) {
   	  		return null;
   	  	}
   		
   	}
	
	public List<Formulario> findFormularioNombre(String nombre)  throws ServiciosException{
		List<Formulario> formularios = new LinkedList<>();
		
    	try {
    		TypedQuery<Formulario> query = em.createQuery("SELECT f FROM Formulario f WHERE f.nombre LIKE :nombre", Formulario.class);
			query.setParameter("nombre", nombre);
			formularios = query.getResultList();
			return formularios;
    	
	    }catch(Exception ex) {
	  		return null;
	  	}
		
	}
	
	public List<Formulario> findFormularioFecha(String fecha)  throws ServiciosException{
		List<Formulario> formularios = new LinkedList<>();
		
    	try {
    		TypedQuery<Formulario> query = em.createQuery("SELECT f FROM Formulario f WHERE f.fechaHora LIKE :fecha", Formulario.class);
			query.setParameter("fecha", fecha);
			formularios = query.getResultList();
			return formularios;
    	
	    }catch(Exception ex) {
	  		return null;
	  	}
		
	}
	
	public List<Formulario> findAll() throws ServiciosException{
		
		try {
			TypedQuery<Formulario> query;
			query = em.createNamedQuery("Formulario.findAll", Formulario.class);
			return query.getResultList();
			
		}catch(Exception ex) {
	  		return null;
	  	}
	}
}
