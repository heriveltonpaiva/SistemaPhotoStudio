package br.unirn.dao;

import br.unirn.dominio.Gestor;
import java.util.List;

public class GestorDao extends GenericDaoImpl<Gestor> implements GenericDao<Gestor>{

    public List<Gestor> findAll() {
        
        List<Gestor> gestores = null;
		 try {
		  gestores = getEntityManager().createNamedQuery("Gestor.findAll")
		   .getResultList();
		 } catch (Exception e) {
		  e.printStackTrace();
		 }
		 return  gestores;
   }

    public void adicionar(Gestor gestor){
    
        insert(gestor);
     
    }
}
