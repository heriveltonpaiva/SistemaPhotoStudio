/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.unirn.dominio;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author HERIVELTON
 */
@Entity
@Table(name = "carrinho")
@NamedQueries({
    @NamedQuery(name = "Carrinho.findAll", query = "SELECT c FROM Carrinho c"),
    @NamedQuery(name = "Carrinho.findByIdCarrinho", query = "SELECT c FROM Carrinho c WHERE c.idCarrinho = :idCarrinho"),
    @NamedQuery(name = "Carrinho.findByDescricao", query = "SELECT c FROM Carrinho c WHERE c.descricao = :descricao"),
    @NamedQuery(name = "Carrinho.findByQuantidade", query = "SELECT c FROM Carrinho c WHERE c.quantidade = :quantidade"),
    @NamedQuery(name = "Carrinho.findByTamanho", query = "SELECT c FROM Carrinho c WHERE c.tamanho = :tamanho"),
    @NamedQuery(name = "Carrinho.findByValorVenda", query = "SELECT c FROM Carrinho c WHERE c.valorVenda = :valorVenda")})
public class Carrinho implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_carrinho")
    private Integer idCarrinho;
    @Size(max = 100)
    @Column(name = "descricao")
    private String descricao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantidade")
    private int quantidade;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "tamanho")
    private String tamanho;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_venda")
    private BigInteger valorVenda;
    @JoinColumn(name = "id_cliente_cliente", referencedColumnName = "id_cliente")
    @OneToOne
    private Cliente idClienteCliente;

    public Carrinho() {
    }

    public Carrinho(Integer idCarrinho) {
        this.idCarrinho = idCarrinho;
    }

    public Carrinho(Integer idCarrinho, int quantidade, String tamanho, BigInteger valorVenda) {
        this.idCarrinho = idCarrinho;
        this.quantidade = quantidade;
        this.tamanho = tamanho;
        this.valorVenda = valorVenda;
    }

    public Integer getIdCarrinho() {
        return idCarrinho;
    }

    public void setIdCarrinho(Integer idCarrinho) {
        this.idCarrinho = idCarrinho;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public BigInteger getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(BigInteger valorVenda) {
        this.valorVenda = valorVenda;
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
        hash += (idCarrinho != null ? idCarrinho.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Carrinho)) {
            return false;
        }
        Carrinho other = (Carrinho) object;
        if ((this.idCarrinho == null && other.idCarrinho != null) || (this.idCarrinho != null && !this.idCarrinho.equals(other.idCarrinho))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.unirn.dominio.Carrinho[ idCarrinho=" + idCarrinho + " ]";
    }
    
}
