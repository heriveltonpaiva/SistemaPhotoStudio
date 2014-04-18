package br.unirn.service;

import br.unirn.dao.AlbumDao;
import br.unirn.dao.UsuarioDao;
import br.unirn.dominio.Album;
import br.unirn.dominio.Fotografo;
import br.unirn.dominio.Usuario;

public class AlbumService {

	protected AlbumDao albumDao;
    protected UsuarioDao fotografoDao;
	
	
	public AlbumService() {
		albumDao = new AlbumDao();
		fotografoDao = new UsuarioDao();
	}
	
	
	public void adicionarAlbum(Album album){
		
		Album novoAlbum = new Album();
		Usuario novoUsuario = new Usuario();
		
		
		novoAlbum.setDescricao(album.getDescricao());
		novoAlbum.setData(album.getData());
		novoAlbum.setObs(album.getObs());
		
		albumDao.insert(novoAlbum);
		
		
	}
	
	
}
