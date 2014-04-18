package br.unirn.service;

import br.unirn.dao.BairroDao;
import br.unirn.dao.CidadeDao;
import br.unirn.dao.ContatoDao;
import br.unirn.dao.EnderecoDao;
import br.unirn.dao.EstadoDao;
import br.unirn.dao.UsuarioDao;
import br.unirn.dominio.Bairro;
import br.unirn.dominio.Cidade;
import br.unirn.dominio.Contato;
import br.unirn.dominio.Endereco;
import br.unirn.dominio.Estado;
import br.unirn.dominio.Usuario;

public  class UsuarioService {

	
	private UsuarioDao usuarioDao;
	private EstadoDao estadoDao;
	private CidadeDao cidadeDao;
	private BairroDao bairroDao;
	private EnderecoDao enderecoDao;
	private ContatoDao contatoDao;
	
	public UsuarioService() {
	usuarioDao = new UsuarioDao();
	estadoDao = new EstadoDao();
	cidadeDao = new CidadeDao();
	enderecoDao = new EnderecoDao();
    contatoDao = new ContatoDao();
    bairroDao = new BairroDao();
	
	}
	

	
	public void adicionarUsuario(Usuario usuario, Endereco endereco, Bairro bairro, Cidade cidade, Estado estado, Contato contato){
		
		Contato novoContato = new Contato();
		Estado novoEstado = new Estado();
		Cidade novaCidade = new  Cidade();
		Bairro novoBairro = new Bairro();
		Endereco novoEndereco = new Endereco();
		Usuario novoUsuario = new Usuario();
		
		boolean estadoexiste = false;
		boolean cidadeexiste = false;
		boolean bairroexiste = false;
		boolean enderecoexiste = false;
		
		// VERIFICANDO SE O ESTADO JÁ EXISTE NO BANCO
		for (Estado e : estadoDao.findAllEstado()) {

			if (e.getDescricao().equals(estado.getDescricao())) {
				System.out.println("Estado já existe ! seu id é "
						+ e.getIdEstado());
				novaCidade.setIdEstadoEstado(e);
				estadoexiste = true;
				break;
			}
		}
		// SE O ESTADO NÃO EXISTE
		if (estadoexiste == false) {

			System.out.println("Novo Estado Criado");

			novoEstado.setDescricao(estado.getDescricao());
			novaCidade.setIdEstadoEstado(novoEstado);
			estadoDao.insert(novoEstado);
		}

		// VERIFICANDO SE A CIDADE JÁ EXISTE NO BANCO
		for (Cidade c : cidadeDao.findAllCidade()) {

			if (c.getDescricao().equals(cidade.getDescricao())) {
				System.out.println("Cidade já existe ! seu id é "
						+ c.getIdCidade());
				novoBairro.setIdCidadeCidade(c);
				cidadeexiste = true;
				break;
			}
		}
        //SE A CIDADE NÃO EXISTE
		if (cidadeexiste == false) {
			novaCidade.setDescricao(cidade.getDescricao());
			novoBairro.setIdCidadeCidade(novaCidade);
			cidadeDao.insert(novaCidade);

		}
		
				
		// VERIFICANDO SE O BAIRRO JÁ EXISTE NO BANCO
				for (Bairro b : bairroDao.findAllBairro()) {

					if (b.getDescricao().equals(bairro.getDescricao())) {
						System.out.println("Bairro já existe ! seu id é "
								+ b.getIdBairro());
						novoEndereco.setIdBairroBairro(b);
						bairroexiste = true;
						break;
					}
				}
		
				// SE O BAIRRO NÃO EXISTE
				if (bairroexiste == false) {
					novoBairro.setDescricao(bairro.getDescricao());
					novoEndereco.setIdBairroBairro(novoBairro);
					bairroDao.insert(novoBairro);
				}			
		
				// VERIFICANDO SE O ENDEREÇO JÁ EXISTE NO BANCO
				for (Endereco end : enderecoDao.findAllEndereco()) {

					if (end.getDescricao().equals(endereco.getDescricao())&&
							end.getCep().equals(endereco.getCep())&&
							end.getNumero().equals(endereco.getNumero())&&
				            end.getComplemento().equals(endereco.getComplemento())) {
						System.out.println("Endereço já existe ! seu id é "
								+ end.getIdEndereco());
						novoUsuario.setIdEnderecoEndereco(end);
						enderecoexiste = true;
						break;
					}
				}	
				
		// SE O ENDEREÇO NÃO EXISTIR		
		if(enderecoexiste==false){		
		novoEndereco.setDescricao(endereco.getDescricao());
		novoEndereco.setCep(endereco.getCep());
		novoEndereco.setComplemento(endereco.getComplemento());
		novoEndereco.setNumero(endereco.getNumero());
		novoUsuario.setIdEnderecoEndereco(novoEndereco);
		enderecoDao.insert(novoEndereco);
		}
		
		
	   //ADICIONANDO NOVO CONTATO	
		novoContato.setTelefone(contato.getTelefone());
		novoContato.setCelular(contato.getCelular());
		novoContato.setEmail(contato.getEmail());
	
		contatoDao.insert(novoContato);
		
		
		// ADICIONANDO USUÁRIO
		novoUsuario.setNome(usuario.getNome());
		novoUsuario.setCpf(usuario.getCpf());
		novoUsuario.setDataNascimento(usuario.getDataNascimento());
		novoUsuario.setLogin(usuario.getLogin());
		novoUsuario.setSenha(usuario.getSenha());
		novoUsuario.setIdContatoContato(novoContato);
	
		
		usuarioDao.insert(novoUsuario);
	
	}
	
	
	
}
