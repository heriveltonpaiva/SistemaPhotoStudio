package br.unirn.controle;




import br.unirn.dao.FotografoDao;
import br.unirn.dominio.Bairro;
import br.unirn.dominio.Cidade;
import br.unirn.dominio.Contato;
import br.unirn.dominio.Endereco;
import br.unirn.dominio.Estado;
import br.unirn.dominio.Fotografo;
import br.unirn.service.FotografoService;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class FotografoBean {

	private Estado estado;
	private Cidade cidade;
	private Bairro bairro;
	private Endereco endereco;
	private Contato contato;
	private Fotografo fotografo;
	private FotografoService fotografoService;
	private FotografoDao dao = new FotografoDao();
	
	public FotografoBean() {
	   
	}

    public List<Fotografo> getLista() {
       
        return dao.findAll();
    }

	
	public void salvar(){
          
	   if(fotografoService==null){
        fotografoService = new FotografoService();
        }
	   fotografoService.adicionarUsuario(fotografo, endereco,bairro,cidade,estado,contato);
          this.fotografo = new  Fotografo();
	}
	

	
	
	public Fotografo getFotografo() {
		if(fotografo==null){
			fotografo = new Fotografo();
		}
		return fotografo;
	}
	
	public Endereco getEndereco() {
		
		if(endereco==null){
			endereco = new Endereco();
		}
		
		return endereco;
	}
	
	public Bairro getBairro() {
		if(bairro==null){
			
			bairro = new Bairro();
		}
		return bairro;
	}
	
	public Cidade getCidade() {
		if (cidade == null) {

			cidade = new Cidade();
		}
		return cidade;
	}
	
    public Estado getEstado() {
    	if(estado==null){
    		
    		estado = new Estado();
    	}
    	
		return estado;
	}
    
    public Contato getContato() {
	if(contato==null){
		
		contato = new Contato();
	}
    	
    	return contato;
	}
	
	
	
	
	
}
