package br.unirn.dao;

import java.util.List;

import br.unirn.dominio.Estado;

public class EstadoDao extends GenericDaoImpl<Estado> {

	
	public List<Estado> findAllEstado() {
		List<Estado> estados = null;
		 try {
		  estados = getEntityManager().createNamedQuery("Estado.findAll")
		   .getResultList();
		 } catch (Exception e) {
		  e.printStackTrace();
		 }
		 return  estados;
	}
	

}
