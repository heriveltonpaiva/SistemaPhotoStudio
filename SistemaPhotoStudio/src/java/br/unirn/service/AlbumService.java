package br.unirn.service;

import br.unirn.dao.AlbumDao;
import br.unirn.dao.FotografoDao;
import br.unirn.dominio.Album;


public class AlbumService {

	private AlbumDao albumDao;
        
	
	
	public AlbumService() {
		albumDao = new AlbumDao();
		
	}
	
	
	public void adicionarAlbum(Album album){
		
		Album novoAlbum = new Album();
			
		novoAlbum.setDescricao(album.getDescricao());
		novoAlbum.setData(album.getData());
		novoAlbum.setObs(album.getObs());
		
		albumDao.insert(novoAlbum);
		
		
	}
	
	
}
