/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.unirn.dominio;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author HERIVELTON
 */
@Embeddable
public class FotografoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_fotografo")
    private int idFotografo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_usuario_usuario")
    private int idUsuarioUsuario;

    public FotografoPK() {
    }

    public FotografoPK(int idFotografo, int idUsuarioUsuario) {
        this.idFotografo = idFotografo;
        this.idUsuarioUsuario = idUsuarioUsuario;
    }

    public int getIdFotografo() {
        return idFotografo;
    }

    public void setIdFotografo(int idFotografo) {
        this.idFotografo = idFotografo;
    }

    public int getIdUsuarioUsuario() {
        return idUsuarioUsuario;
    }

    public void setIdUsuarioUsuario(int idUsuarioUsuario) {
        this.idUsuarioUsuario = idUsuarioUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idFotografo;
        hash += (int) idUsuarioUsuario;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FotografoPK)) {
            return false;
        }
        FotografoPK other = (FotografoPK) object;
        if (this.idFotografo != other.idFotografo) {
            return false;
        }
        if (this.idUsuarioUsuario != other.idUsuarioUsuario) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.unirn.dominio.FotografoPK[ idFotografo=" + idFotografo + ", idUsuarioUsuario=" + idUsuarioUsuario + " ]";
    }
    
}
