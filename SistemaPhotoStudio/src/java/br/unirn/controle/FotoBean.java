package br.unirn.controle;

import br.unirn.dao.FotoDao;
import br.unirn.dominio.Foto;
import br.unirn.service.FotoService;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

@ManagedBean
@SessionScoped

public class FotoBean {

    private Foto foto;
    private List<StreamedContent> listafotos;
    private UploadedFile file;  
   
    private StreamedContent imagem;
    public FotoBean(){
        foto = new Foto();
        listafotos = new ArrayList<StreamedContent>();
    }

    public List<StreamedContent> getListafotos() {
        return listafotos;
    }

    public void setListafotos(List<StreamedContent> listafotos) {
        this.listafotos = listafotos;
    }
    
    
 
    public UploadedFile getFile() {  
        return file;  
    }  
  
    public void setFile(UploadedFile file) {  
        this.file = file;  
    }  
      
    public void upload() {  
        
        if(file != null) {  
          
            foto.setArquivo(file.getContents());
            foto.setValor(new BigInteger("24"));
            foto.setDataUpload("19/04/2014");
            foto.setFotoNome(file.getFileName());
            foto.setDescricao("Testando");
            foto.setContenttype(file.getContentType());
            
            try {
                imagem = null;
            
                imagem= new DefaultStreamedContent(file.getInputstream());
                listafotos.add(imagem);
            } catch (IOException ex) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"", "Falha na Exibição da Imagem"+ex));  
            }
          
            FacesMessage msg = new FacesMessage("Foto Salva com Sucesso!");  
            FacesContext.getCurrentInstance().addMessage(null, msg);  
        }  
        
    }  
    public void matarSessao(){
    
    HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
     HttpSession session = request.getSession();
      session.invalidate();
    }
    
    public void adicionarArquivo(FileUploadEvent event) throws IOException {

           UploadedFile uploadedFile = event.getFile();
          
        try {
             foto.setArquivo(uploadedFile.getContents());
            foto.setValor(new BigInteger("24"));
            foto.setDataUpload("19/04/2014");
            foto.setFotoNome(uploadedFile.getFileName());
            foto.setDescricao("Testando");
            foto.setContenttype(uploadedFile.getContentType());
           
           // dao.adicionarFoto(foto);
          
                 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"", "Arquivo Salvo"));  
        } catch (Exception ex) {
            
                 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"", "Erro na Inserção da Imagem "+ex.getMessage()+""+ex));  
      
        }
           
             
    }
    
    
    /**
     * Esse METODO FUNCIONA !
     * @param event 
     */
    public void fileUploadAction(FileUploadEvent event) {
            
        try {
            
            UploadedFile uploadedFile = event.getFile();
            ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
            HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();

            FacesContext aFacesContext = FacesContext.getCurrentInstance();
            ServletContext context = (ServletContext) aFacesContext.getExternalContext().getContext();
            
            String realPath = context.getRealPath("/");

// Aqui cria o diretorio caso não exista 
            File file = new File(realPath + "/fotos/");
            file.mkdirs();
            
            byte[] arquivo =uploadedFile.getContents();
            if(foto==null){
             foto = new Foto();
            }
                 
            String caminho = realPath + "/fotos/" + uploadedFile.getFileName();
            foto.setArquivo(uploadedFile.getContents());
            foto.setValor(new BigInteger("24"));
            foto.setDataUpload("19/04/2014");
            foto.setFotoNome(uploadedFile.getFileName());
            foto.setDescricao("Testando");
            foto.setContenttype(uploadedFile.getContentType());
           
        //    dao.adicionarFoto(foto);
// esse trecho grava o arquivo no diretório 
            FileOutputStream fos = new FileOutputStream(caminho);
            fos.write(uploadedFile.getContents());
            fos.close();
   FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"", "Imagem Adicionada!"));  
         
        } catch (Exception ex) {
               FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"", "Erro na Inserção da Imagem "+ex.getMessage()+""+ex));  
         
        }
    }

 
   
    public Foto getFoto() {
        return foto;
    }

    public void setFoto(Foto foto) {
        this.foto = foto;
    }

 
    public StreamedContent getImagem() {
 return imagem;
 }
 
public void setImagem(StreamedContent imagem) {
 this.imagem = imagem;
 }
 
    
}
