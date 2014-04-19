/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.unirn.dominio;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author HERIVELTON
 */
@Entity
@Table(name = "gestor")
@NamedQueries({
    @NamedQuery(name = "Gestor.findAll", query = "SELECT g FROM Gestor g"),
    @NamedQuery(name = "Gestor.findByIdGestor", query = "SELECT g FROM Gestor g WHERE g.idGestor = :idGestor"),
    @NamedQuery(name = "Gestor.findByLogin", query = "SELECT g FROM Gestor g WHERE g.login = :login"),
    @NamedQuery(name = "Gestor.findBySenha", query = "SELECT g FROM Gestor g WHERE g.senha = :senha")})
public class Gestor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_gestor")
    private Integer idGestor;
    @Size(max = 2147483647)
    @Column(name = "login")
    private String login;
    @Size(max = 2147483647)
    @Column(name = "senha")
    private String senha;
    @OneToMany(mappedBy = "idGestorGestor")
    private List<Fotografo> fotografoList;

    public Gestor() {
    }

    public Gestor(Integer idGestor) {
        this.idGestor = idGestor;
    }

    public Integer getIdGestor() {
        return idGestor;
    }

    public void setIdGestor(Integer idGestor) {
        this.idGestor = idGestor;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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
        hash += (idGestor != null ? idGestor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gestor)) {
            return false;
        }
        Gestor other = (Gestor) object;
        if ((this.idGestor == null && other.idGestor != null) || (this.idGestor != null && !this.idGestor.equals(other.idGestor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.unirn.dominio.Gestor[ idGestor=" + idGestor + " ]";
    }
    
}
