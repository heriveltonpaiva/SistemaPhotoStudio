package br.unirn.dao;

import java.util.List;

import br.unirn.dominio.Endereco;
import br.unirn.dominio.Estado;

public class EnderecoDao extends GenericDaoImpl<Endereco> implements GenericDao<Endereco>{

	public List<Endereco> findAllEndereco() {
		List<Endereco> enderecos = null;
		 try {
		  enderecos = getEntityManager().createNamedQuery("Endereco.findAll")
		   .getResultList();
		 } catch (Exception e) {
		  e.printStackTrace();
		 }
		 return  enderecos;
	}
	
	
}
