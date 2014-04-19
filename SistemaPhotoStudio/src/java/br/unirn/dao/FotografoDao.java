package br.unirn.dao;

import br.unirn.dominio.Fotografo;
import java.util.List;

public class FotografoDao extends GenericDaoImpl<Fotografo> implements GenericDao<Fotografo>{

    
    
     public void insert(Fotografo fotografo){
        super.insert(fotografo);
     }

    public List<Fotografo> findAll() {
        
        List<Fotografo> fotografos = null;
		 try {
		  fotografos = getEntityManager().createNamedQuery("Fotografo.findAll")
		   .getResultList();
		 } catch (Exception e) {
		  e.printStackTrace();
		 }
		 return  fotografos;
    }
}
