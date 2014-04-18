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
public class GestorPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_gestor")
    private int idGestor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_usuario_usuario")
    private int idUsuarioUsuario;

    public GestorPK() {
    }

    public GestorPK(int idGestor, int idUsuarioUsuario) {
        this.idGestor = idGestor;
        this.idUsuarioUsuario = idUsuarioUsuario;
    }

    public int getIdGestor() {
        return idGestor;
    }

    public void setIdGestor(int idGestor) {
        this.idGestor = idGestor;
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
        hash += (int) idGestor;
        hash += (int) idUsuarioUsuario;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GestorPK)) {
            return false;
        }
        GestorPK other = (GestorPK) object;
        if (this.idGestor != other.idGestor) {
            return false;
        }
        if (this.idUsuarioUsuario != other.idUsuarioUsuario) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.unirn.dominio.GestorPK[ idGestor=" + idGestor + ", idUsuarioUsuario=" + idUsuarioUsuario + " ]";
    }
    
}
