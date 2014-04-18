package br.unirn.dao;

import java.util.List;

import br.unirn.dominio.Bairro;
import br.unirn.dominio.Estado;

public class BairroDao extends GenericDaoImpl<Bairro> implements GenericDao<Bairro>{

	
	public List<Bairro> findAllBairro() {
		List<Bairro> bairros = null;
		 try {
		  bairros = getEntityManager().createNamedQuery("Bairro.findAll")
		   .getResultList();
		 } catch (Exception e) {
		  e.printStackTrace();
		 }
		 return  bairros;
	}
	
}
