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
public class ClientePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_cliente")
    private int idCliente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_usuario_usuario")
    private int idUsuarioUsuario;

    public ClientePK() {
    }

    public ClientePK(int idCliente, int idUsuarioUsuario) {
        this.idCliente = idCliente;
        this.idUsuarioUsuario = idUsuarioUsuario;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
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
        hash += (int) idCliente;
        hash += (int) idUsuarioUsuario;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClientePK)) {
            return false;
        }
        ClientePK other = (ClientePK) object;
        if (this.idCliente != other.idCliente) {
            return false;
        }
        if (this.idUsuarioUsuario != other.idUsuarioUsuario) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.unirn.dominio.ClientePK[ idCliente=" + idCliente + ", idUsuarioUsuario=" + idUsuarioUsuario + " ]";
    }
    
}
