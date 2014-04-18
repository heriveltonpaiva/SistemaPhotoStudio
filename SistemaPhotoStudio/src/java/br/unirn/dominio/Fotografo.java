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
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author HERIVELTON
 */
@Entity
@Table(name = "fotografo")
@NamedQueries({
    @NamedQuery(name = "Fotografo.findAll", query = "SELECT f FROM Fotografo f"),
    @NamedQuery(name = "Fotografo.findByIdFotografo", query = "SELECT f FROM Fotografo f WHERE f.fotografoPK.idFotografo = :idFotografo"),
    @NamedQuery(name = "Fotografo.findByIdUsuarioUsuario", query = "SELECT f FROM Fotografo f WHERE f.fotografoPK.idUsuarioUsuario = :idUsuarioUsuario")})
public class Fotografo implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FotografoPK fotografoPK;
    @OneToMany(mappedBy = "fotografo")
    private List<Fotografocliente> fotografoclienteList;
    @JoinColumn(name = "id_usuario_usuario", referencedColumnName = "id_usuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;
    @JoinColumns({
        @JoinColumn(name = "id_gestor_gestor", referencedColumnName = "id_gestor"),
        @JoinColumn(name = "id_usuario_usuario_gestor", referencedColumnName = "id_usuario_usuario")})
    @ManyToOne
    private Gestor gestor;
    @OneToMany(mappedBy = "fotografo")
    private List<Album> albumList;
    @OneToMany(mappedBy = "fotografo")
    private List<Venda> vendaList;

    public Fotografo() {
    }

    public Fotografo(FotografoPK fotografoPK) {
        this.fotografoPK = fotografoPK;
    }

    public Fotografo(int idFotografo, int idUsuarioUsuario) {
        this.fotografoPK = new FotografoPK(idFotografo, idUsuarioUsuario);
    }

    public FotografoPK getFotografoPK() {
        return fotografoPK;
    }

    public void setFotografoPK(FotografoPK fotografoPK) {
        this.fotografoPK = fotografoPK;
    }

    public List<Fotografocliente> getFotografoclienteList() {
        return fotografoclienteList;
    }

    public void setFotografoclienteList(List<Fotografocliente> fotografoclienteList) {
        this.fotografoclienteList = fotografoclienteList;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Gestor getGestor() {
        return gestor;
    }

    public void setGestor(Gestor gestor) {
        this.gestor = gestor;
    }

    public List<Album> getAlbumList() {
        return albumList;
    }

    public void setAlbumList(List<Album> albumList) {
        this.albumList = albumList;
    }

    public List<Venda> getVendaList() {
        return vendaList;
    }

    public void setVendaList(List<Venda> vendaList) {
        this.vendaList = vendaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fotografoPK != null ? fotografoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fotografo)) {
            return false;
        }
        Fotografo other = (Fotografo) object;
        if ((this.fotografoPK == null && other.fotografoPK != null) || (this.fotografoPK != null && !this.fotografoPK.equals(other.fotografoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.unirn.dominio.Fotografo[ fotografoPK=" + fotografoPK + " ]";
    }
    
}
