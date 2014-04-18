package br.unirn.dao;

import java.util.List;

import br.unirn.dominio.Cidade;
import br.unirn.dominio.Estado;

public class CidadeDao extends GenericDaoImpl<Cidade> implements GenericDao<Cidade> {

	
	
	public List<Cidade> findAllCidade() {
		List<Cidade> cidades = null;
		 try {
		 cidades = getEntityManager().createNamedQuery("Cidade.findAll")
		   .getResultList();
		 } catch (Exception e) {
		  e.printStackTrace();
		 }
		 return  cidades;
	}
	
}
