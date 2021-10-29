package com.servicios;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.exception.ServiciosException;

import model.Departamento;


/**
 * Session Bean implementation class Departamento_Bean
 */
@Stateless
public class Departamento_Bean implements Departamento_BeanRemote {

	@PersistenceContext
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public Departamento_Bean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Departamento> allDepartamentos() {
		TypedQuery<Departamento> query;
		query = em.createNamedQuery("Departamento.findAll", Departamento.class);
		return query.getResultList();
	}

	@Override
	public Departamento findDepartamento(String departamento) throws ServiciosException {
		try {
    		TypedQuery<Departamento> query = em.createQuery("SELECT d FROM Departamento d WHERE d.nombre LIKE :departamento", Departamento.class);
			query.setParameter("departamento", departamento);
			Departamento d = query.getSingleResult();
    		return d;

    	}catch(Exception ex) {
    		ex.getMessage();
    		return null;
    	}
	}
}
