package br.unirn.controle;

import br.unirn.dao.GestorDao;
import br.unirn.dominio.Gestor;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@SessionScoped
@ManagedBean
public class GestorBean {

    private Gestor gestor;
    private GestorDao dao = new GestorDao();
    
    public GestorBean() {
    
    
    }
    
    public void salvar(){
       if(gestor == null){
       gestor = new Gestor();
       }
        try {
            dao.adicionar(gestor); 
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"","Registro Cadastrado com Sucesso!"));   
              
        } catch (Exception e) {
              FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"", "Erro na Inserção "+e.getMessage()));  
         
        }
       
        gestor = new Gestor();
    }

    public Gestor getGestor() {
        return gestor;
    }

    public void setGestor(Gestor gestor) {
        this.gestor = gestor;
    }

    public List<Gestor> getLista() {
        return dao.findAll();
    }
    
    
    
    
}
