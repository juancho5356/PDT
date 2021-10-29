package com.servicios;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.exception.ServiciosException;

import model.Investigador;

/**
 * Session Bean implementation class Investigador_Bean
 */
@Stateless
public class Investigador_Bean implements Investigador_BeanRemote {

    /**
     * Default constructor. 
     */
	@PersistenceContext
	private EntityManager em;
	
    public Investigador_Bean() {
        // TODO Auto-generated constructor stub
    }
    
	@Override
  	public Investigador findInvestigador(String user, String contrasenia) throws ServiciosException{
      	
      	try {
      		TypedQuery<Investigador> query = em.createQuery("SELECT i FROM Investigador i WHERE i.usuario.nombreUsuario LIKE :user AND i.usuario.contraseña LIKE :contrasenia", Investigador.class);
  			query.setParameter("user", user);
  			query.setParameter("contrasenia", contrasenia);
  			Investigador i = query.getSingleResult();
      		return i;

      	}catch(Exception ex) {
      		return null;
      	}
  		
  	}

	@Override
  	public Investigador findInvestigadorCedula(long doc)  throws ServiciosException{
		try {
	  		TypedQuery<Investigador> query = em.createQuery("SELECT i FROM Investigador i WHERE i.documento LIKE :doc", Investigador.class);
	  			query.setParameter("doc", doc);
	  			Investigador i = query.getSingleResult();
	  		return i;
	  		
		}catch(Exception ex) {
      		return null;
      	}
  	}
	
	@Override
	public boolean insert(Investigador in) throws ServiciosException {
    	try {
    		em.persist(in);
    		em.flush();
    		return true;
    	}catch(Exception e) {
    		return false;
    	}
	}
	
	@Override
	public boolean delete(Investigador investigador) throws ServiciosException {
		try {
			investigador = em.find(Investigador.class, investigador.getIdInvestigador());
			em.remove(investigador);
			em.flush();
			return true;
		}catch(Exception e) {
			return false;
		}
		
	}
	
	@Override
	public boolean edit(Investigador investigador) throws ServiciosException {
		try {
			em.merge(investigador);
			em.flush();
			return true;
		}catch(Exception e) {
    		return false;
		}
	}
	
	@Override 
    public Investigador findUsuario (long id) throws ServiciosException{
    	try {
    		TypedQuery<Investigador> query = em.createQuery("SELECT i FROM Investigador i WHERE i.usuario.idUsuario LIKE :id", Investigador.class);
			query.setParameter("id", id);
			Investigador i = query.getSingleResult();
			return i;
    	
	    }catch(Exception ex) {
	  		return null;
	  	}
    }

}
