package br.unirn.dao;

import java.awt.Event;
import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.unirn.dominio.Estado;



public  class GenericDaoImpl<T> implements GenericDao<T> {
	
    private EntityManagerFactory factory  = Persistence.createEntityManagerFactory("PhotoJPAPU");
	
	protected EntityManager em = factory.createEntityManager();
	
	public EntityManager getEntityManager() {
		return em;
	}
	
	
	@Override
	public void insert(Object entity) {
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();	
		em.close();
	}

	@Override
	public void update(Object entity) {
		// TODO Auto-generated method stub
		
	}

	public Object findByName(String name) {
		// TODO Auto-generated method stub
		return em.find(Object.class, name);
	}

	

	@Override
	public void delete(Object entity) {
		// TODO Auto-generated method stub
		
	}



}