package br.unirn.controle;


import br.unirn.dao.AlbumDao;
import br.unirn.dominio.Album;
import br.unirn.service.AlbumService;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIPanel;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped

public class AlbumBean {

	private Album album;
     //   private AlbumDao dao = new AlbumDao();
        private UIPanel panelform;
	public AlbumBean(){
		album = new Album();
		
	}     

  //  public List<Album> getLista() {
   //     return dao.findAll();
  //  }
        
        
        
	public Album getAlbum() {
		return album;
	}
	
	public void setAlbum(Album album) {
		this.album = album;
	}
	
	
	public void salvar(){
		
		AlbumService n = new AlbumService();
                 
		          try {
                n.adicionarAlbum(album);
                this.album = new Album();
               
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"","Registro Cadastrado com Sucesso!"));  
   
            } catch (Exception e) {
          
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"", "Erro na Inserção"+e.getMessage()));  
          this.album = new Album();
            }
		
            
	}
        
       
 

    
	
}
