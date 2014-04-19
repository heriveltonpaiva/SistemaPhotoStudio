package br.unirn.service;

import br.unirn.dao.FotoDao;
import br.unirn.dominio.Foto;

public class FotoService {

	FotoDao dao;

    public FotoService() {
         dao = new FotoDao();
    }
        
       
    public void adicionar(Foto foto){
    
        dao.insert(foto);
    }
	
}
