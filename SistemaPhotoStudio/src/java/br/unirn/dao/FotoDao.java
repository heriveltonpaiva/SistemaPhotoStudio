package br.unirn.dao;

import br.unirn.dominio.Foto;

public class FotoDao extends GenericDaoImpl<Foto> implements GenericDao<Foto> {

    
    public void adicionarFoto(Foto foto){
    
        super.insert(foto);
    }
    
}
