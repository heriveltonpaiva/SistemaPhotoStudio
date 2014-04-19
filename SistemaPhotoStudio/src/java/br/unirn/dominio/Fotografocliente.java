/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.unirn.dominio;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author HERIVELTON
 */
@Entity
@Table(name = "fotografocliente")
@NamedQueries({
    @NamedQuery(name = "Fotografocliente.findAll", query = "SELECT f FROM Fotografocliente f"),
    @NamedQuery(name = "Fotografocliente.findByIdFotografocliente", query = "SELECT f FROM Fotografocliente f WHERE f.idFotografocliente = :idFotografocliente")})
public class Fotografocliente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_fotografocliente")
    private Integer idFotografocliente;
    @JoinColumn(name = "id_fotografo_fotografo", referencedColumnName = "id_fotografo")
    @ManyToOne
    private Fotografo idFotografoFotografo;
    @JoinColumn(name = "id_cliente_cliente", referencedColumnName = "id_cliente")
    @ManyToOne
    private Cliente idClienteCliente;

    public Fotografocliente() {
    }

    public Fotografocliente(Integer idFotografocliente) {
        this.idFotografocliente = idFotografocliente;
    }

    public Integer getIdFotografocliente() {
        return idFotografocliente;
    }

    public void setIdFotografocliente(Integer idFotografocliente) {
        this.idFotografocliente = idFotografocliente;
    }

    public Fotografo getIdFotografoFotografo() {
        return idFotografoFotografo;
    }

    public void setIdFotografoFotografo(Fotografo idFotografoFotografo) {
        this.idFotografoFotografo = idFotografoFotografo;
    }

    public Cliente getIdClienteCliente() {
        return idClienteCliente;
    }

    public void setIdClienteCliente(Cliente idClienteCliente) {
        this.idClienteCliente = idClienteCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFotografocliente != null ? idFotografocliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fotografocliente)) {
            return false;
        }
        Fotografocliente other = (Fotografocliente) object;
        if ((this.idFotografocliente == null && other.idFotografocliente != null) || (this.idFotografocliente != null && !this.idFotografocliente.equals(other.idFotografocliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.unirn.dominio.Fotografocliente[ idFotografocliente=" + idFotografocliente + " ]";
    }
    
}
