package br.unirn.service;

import br.unirn.dominio.Bairro;
import br.unirn.dominio.Cidade;
import br.unirn.dominio.Contato;
import br.unirn.dominio.Endereco;
import br.unirn.dominio.Estado;
import br.unirn.dominio.Usuario;

public class FotografoService extends UsuarioService{
	
	@Override
	public void adicionarUsuario(Usuario usuario, Endereco endereco,
			Bairro bairro, Cidade cidade, Estado estado, Contato contato) {
		// TODO Auto-generated method stub
		super.adicionarUsuario(usuario, endereco, bairro, cidade, estado, contato);
	}

}
