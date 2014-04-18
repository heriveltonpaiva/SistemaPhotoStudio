package br.unirn.dao;

import br.unirn.dominio.Usuario;
import java.util.List;

public class UsuarioDao extends GenericDaoImpl<Usuario> implements GenericDao<Usuario>{

    public List<Usuario> findAll() {
		List<Usuario> usuarios = null;
		 try {
		  usuarios = getEntityManager().createNamedQuery("Usuario.findAll")
		   .getResultList();
		 } catch (Exception e) {
		  e.printStackTrace();
		 }
		 return  usuarios;
	}

  
}
