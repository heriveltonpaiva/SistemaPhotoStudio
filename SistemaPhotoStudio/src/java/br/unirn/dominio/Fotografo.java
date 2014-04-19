/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.unirn.dominio;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author HERIVELTON
 */
@Entity
@Table(name = "fotografo")
@NamedQueries({
    @NamedQuery(name = "Fotografo.findAll", query = "SELECT f FROM Fotografo f"),
    @NamedQuery(name = "Fotografo.findByIdFotografo", query = "SELECT f FROM Fotografo f WHERE f.idFotografo = :idFotografo"),
    @NamedQuery(name = "Fotografo.findByNome", query = "SELECT f FROM Fotografo f WHERE f.nome = :nome"),
    @NamedQuery(name = "Fotografo.findByCpfFotografo", query = "SELECT f FROM Fotografo f WHERE f.cpfFotografo = :cpfFotografo"),
    @NamedQuery(name = "Fotografo.findByLogin", query = "SELECT f FROM Fotografo f WHERE f.login = :login"),
    @NamedQuery(name = "Fotografo.findBySenha", query = "SELECT f FROM Fotografo f WHERE f.senha = :senha"),
    @NamedQuery(name = "Fotografo.findByDataNascimento", query = "SELECT f FROM Fotografo f WHERE f.dataNascimento = :dataNascimento")})
public class Fotografo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_fotografo")
    private Integer idFotografo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nome")
    
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100 )
    @Column(name = "cpf_fotografo")
    private String cpfFotografo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "login")
    private String login;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "senha")
    private String senha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_nascimento")
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    @OneToMany(mappedBy = "idFotografoFotografo")
    private List<Fotografocliente> fotografoclienteList;
    @JoinColumn(name = "id_gestor_gestor", referencedColumnName = "id_gestor")
    @ManyToOne
    private Gestor idGestorGestor;
    @JoinColumn(name = "id_endereco_endereco", referencedColumnName = "id_endereco")
    @ManyToOne
    private Endereco idEnderecoEndereco;
    @JoinColumn(name = "id_contato_contato", referencedColumnName = "id_contato")
    @ManyToOne
    private Contato idContatoContato;
    @OneToMany(mappedBy = "idFotografoFotografo")
    private List<Album> albumList;
    @OneToMany(mappedBy = "idFotografoFotografo")
    private List<Venda> vendaList;

    public Fotografo() {
    }

    public Fotografo(Integer idFotografo) {
        this.idFotografo = idFotografo;
    }

    public Fotografo(Integer idFotografo, String nome, String cpfFotografo, String login, String senha, Date dataNascimento) {
        this.idFotografo = idFotografo;
        this.nome = nome;
        this.cpfFotografo = cpfFotografo;
        this.login = login;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
    }

    public Integer getIdFotografo() {
        return idFotografo;
    }

    public void setIdFotografo(Integer idFotografo) {
        this.idFotografo = idFotografo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpfFotografo() {
        return cpfFotografo;
    }

    public void setCpfFotografo(String cpfFotografo) {
        this.cpfFotografo = cpfFotografo;
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

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public List<Fotografocliente> getFotografoclienteList() {
        return fotografoclienteList;
    }

    public void setFotografoclienteList(List<Fotografocliente> fotografoclienteList) {
        this.fotografoclienteList = fotografoclienteList;
    }

    public Gestor getIdGestorGestor() {
        return idGestorGestor;
    }

    public void setIdGestorGestor(Gestor idGestorGestor) {
        this.idGestorGestor = idGestorGestor;
    }

    public Endereco getIdEnderecoEndereco() {
        return idEnderecoEndereco;
    }

    public void setIdEnderecoEndereco(Endereco idEnderecoEndereco) {
        this.idEnderecoEndereco = idEnderecoEndereco;
    }

    public Contato getIdContatoContato() {
        return idContatoContato;
    }

    public void setIdContatoContato(Contato idContatoContato) {
        this.idContatoContato = idContatoContato;
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
        hash += (idFotografo != null ? idFotografo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fotografo)) {
            return false;
        }
        Fotografo other = (Fotografo) object;
        if ((this.idFotografo == null && other.idFotografo != null) || (this.idFotografo != null && !this.idFotografo.equals(other.idFotografo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.unirn.dominio.Fotografo[ idFotografo=" + idFotografo + " ]";
    }
    
}
