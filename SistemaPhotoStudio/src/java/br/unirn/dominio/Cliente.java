/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.unirn.dominio;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author HERIVELTON
 */
@Entity
@Table(name = "cliente")
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
    @NamedQuery(name = "Cliente.findByIdCliente", query = "SELECT c FROM Cliente c WHERE c.clientePK.idCliente = :idCliente"),
    @NamedQuery(name = "Cliente.findByIdUsuarioUsuario", query = "SELECT c FROM Cliente c WHERE c.clientePK.idUsuarioUsuario = :idUsuarioUsuario")})
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ClientePK clientePK;
    @OneToMany(mappedBy = "cliente")
    private List<Fotografocliente> fotografoclienteList;
    @OneToOne(mappedBy = "cliente")
    private Carrinho carrinho;
    @JoinColumn(name = "id_usuario_usuario", referencedColumnName = "id_usuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;

    public Cliente() {
    }

    public Cliente(ClientePK clientePK) {
        this.clientePK = clientePK;
    }

    public Cliente(int idCliente, int idUsuarioUsuario) {
        this.clientePK = new ClientePK(idCliente, idUsuarioUsuario);
    }

    public ClientePK getClientePK() {
        return clientePK;
    }

    public void setClientePK(ClientePK clientePK) {
        this.clientePK = clientePK;
    }

    public List<Fotografocliente> getFotografoclienteList() {
        return fotografoclienteList;
    }

    public void setFotografoclienteList(List<Fotografocliente> fotografoclienteList) {
        this.fotografoclienteList = fotografoclienteList;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clientePK != null ? clientePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.clientePK == null && other.clientePK != null) || (this.clientePK != null && !this.clientePK.equals(other.clientePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.unirn.dominio.Cliente[ clientePK=" + clientePK + " ]";
    }
    
}
