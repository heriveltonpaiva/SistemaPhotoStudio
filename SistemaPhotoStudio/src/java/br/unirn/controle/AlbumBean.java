package br.unirn.controle;


import br.unirn.dao.AlbumDao;
import br.unirn.dominio.Album;
import br.unirn.service.AlbumService;
import java.awt.event.ActionEvent;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped

public class AlbumBean {

	private Album album;
        private AlbumDao dao = new AlbumDao();
        private List<Album> lista = dao.findAll();
	public AlbumBean(){
		album = new Album();
		
	}     

    public List<Album> getLista() {
        return lista;
    }
        
        
        
	public Album getAlbum() {
		return album;
	}
	
	public void setAlbum(Album album) {
		this.album = album;
	}
	
	
	public void salvar(){
		
		
		
		AlbumService n = new AlbumService();
		
		n.adicionarAlbum(album);
                this.album = new Album();
	}
	
         public void addInfo(ActionEvent actionEvent) {  
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Registro Cadastrado com Sucesso!",""));  
    } 
	
}
