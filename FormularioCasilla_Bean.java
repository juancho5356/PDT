package com.servicios;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.exception.ServiciosException;

import model.Casilla;
import model.Formulario;
import model.FormularioCasilla;

/**
 * Session Bean implementation class FormularioCasilla_Bean
 */
@Stateless
public class FormularioCasilla_Bean implements FormularioCasilla_BeanRemote {

	@PersistenceContext
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public FormularioCasilla_Bean() {
    }
    
	public List<FormularioCasilla> findCasillas(long id) throws ServiciosException{
		
		try {
			Query query;
			String sql = "SELECT * FROM FORMULARIO_CASILLA WHERE ID_FORMULARIO LIKE :id";
			query = em.createNativeQuery(sql, FormularioCasilla.class).setParameter("id", id);
			return query.getResultList();
			
		}catch(Exception ex) {
	  		return null;
	  	}
	}
	
	public boolean delete(FormularioCasilla c) throws ServiciosException{
		
		try {
			c = em.find(FormularioCasilla.class, c.getCasilla());
			em.remove(c);
			em.flush();
			return true;
		}catch(Exception ex) {
   	  		return false;
   	  	}
	}
	
	public boolean insert(FormularioCasilla f) throws ServiciosException{
		try {
			f = em.find(FormularioCasilla.class, f.getIdFormularioCasilla());
			em.persist(f);
			em.flush();
			return true;
		}catch(Exception ex) {
   	  		return false;
   	  	}
	}
}
