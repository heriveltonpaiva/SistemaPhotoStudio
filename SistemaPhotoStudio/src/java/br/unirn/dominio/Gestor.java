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
import javax.persistence.Table;

/**
 *
 * @author HERIVELTON
 */
@Entity
@Table(name = "gestor")
@NamedQueries({
    @NamedQuery(name = "Gestor.findAll", query = "SELECT g FROM Gestor g"),
    @NamedQuery(name = "Gestor.findByIdGestor", query = "SELECT g FROM Gestor g WHERE g.gestorPK.idGestor = :idGestor"),
    @NamedQuery(name = "Gestor.findByIdUsuarioUsuario", query = "SELECT g FROM Gestor g WHERE g.gestorPK.idUsuarioUsuario = :idUsuarioUsuario")})
public class Gestor implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GestorPK gestorPK;
    @JoinColumn(name = "id_usuario_usuario", referencedColumnName = "id_usuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;
    @OneToMany(mappedBy = "gestor")
    private List<Fotografo> fotografoList;

    public Gestor() {
    }

    public Gestor(GestorPK gestorPK) {
        this.gestorPK = gestorPK;
    }

    public Gestor(int idGestor, int idUsuarioUsuario) {
        this.gestorPK = new GestorPK(idGestor, idUsuarioUsuario);
    }

    public GestorPK getGestorPK() {
        return gestorPK;
    }

    public void setGestorPK(GestorPK gestorPK) {
        this.gestorPK = gestorPK;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Fotografo> getFotografoList() {
        return fotografoList;
    }

    public void setFotografoList(List<Fotografo> fotografoList) {
        this.fotografoList = fotografoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gestorPK != null ? gestorPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gestor)) {
            return false;
        }
        Gestor other = (Gestor) object;
        if ((this.gestorPK == null && other.gestorPK != null) || (this.gestorPK != null && !this.gestorPK.equals(other.gestorPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.unirn.dominio.Gestor[ gestorPK=" + gestorPK + " ]";
    }
    
}
