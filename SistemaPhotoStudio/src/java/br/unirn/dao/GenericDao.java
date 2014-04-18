package br.unirn.dao;

import java.io.Serializable;
import java.util.List;

import br.unirn.dominio.Estado;

public interface GenericDao<T> {
	public void insert(Object entity);

	public void update(T entity);

	public Object findByName(String nome);

	public void delete(T entity);

	

	

}