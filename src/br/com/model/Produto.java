/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Nasser
 */
@Entity
@Table(name = "produto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produto.findAll", query = "SELECT p FROM Produto p"),
    @NamedQuery(name = "Produto.findByIdproduto", query = "SELECT p FROM Produto p WHERE p.idproduto = :idproduto"),
    @NamedQuery(name = "Produto.findByCodigo", query = "SELECT p FROM Produto p WHERE p.codigo = :codigo"),
    @NamedQuery(name = "Produto.findByCodigobarras", query = "SELECT p FROM Produto p WHERE p.codigobarras = :codigobarras"),
    @NamedQuery(name = "Produto.findByDescricao", query = "SELECT p FROM Produto p WHERE p.descricao = :descricao"),
    @NamedQuery(name = "Produto.findByPrecoVenda1", query = "SELECT p FROM Produto p WHERE p.precoVenda1 = :precoVenda1"),
    @NamedQuery(name = "Produto.findByPrecoVenda2", query = "SELECT p FROM Produto p WHERE p.precoVenda2 = :precoVenda2"),
    @NamedQuery(name = "Produto.findByPrecoVenda3", query = "SELECT p FROM Produto p WHERE p.precoVenda3 = :precoVenda3"),
    @NamedQuery(name = "Produto.findByEntrada", query = "SELECT p FROM Produto p WHERE p.entrada = :entrada"),
    @NamedQuery(name = "Produto.findBySaida", query = "SELECT p FROM Produto p WHERE p.saida = :saida"),
    @NamedQuery(name = "Produto.findByIdsubgrupo", query = "SELECT p FROM Produto p WHERE p.idsubgrupo = :idsubgrupo"),
    @NamedQuery(name = "Produto.findByNcm", query = "SELECT p FROM Produto p WHERE p.ncm = :ncm"),
    @NamedQuery(name = "Produto.findByEstoqueMinimo", query = "SELECT p FROM Produto p WHERE p.estoqueMinimo = :estoqueMinimo"),
    @NamedQuery(name = "Produto.findByCustoAtual", query = "SELECT p FROM Produto p WHERE p.custoAtual = :custoAtual")})
public class Produto implements Serializable {
    @Basic(optional = false)
    @Column(name = "codigo")
    private int codigo;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idproduto")
    private Integer idproduto;
    @Column(name = "codigobarras")
    private String codigobarras;
    @Basic(optional = false)
    @Column(name = "descricao")
    private String descricao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "preco_venda1")
    private BigDecimal precoVenda1;
    @Column(name = "preco_venda2")
    private BigDecimal precoVenda2;
    @Column(name = "preco_venda3")
    private BigDecimal precoVenda3;
    @Lob
    @Column(name = "observacoes")
    private String observacoes;
    @Column(name = "entrada")
    private Integer entrada;
    @Column(name = "saida")
    private Integer saida;
    @Basic(optional = false)
    @Column(name = "idsubgrupo")
    private Grupo idsubgrupo;
    @Column(name = "ncm")
    private Integer ncm;
    @Column(name = "estoque_minimo")
    private Integer estoqueMinimo;
    @Column(name = "custo_atual")
    private BigDecimal custoAtual;
    @JoinColumn(name = "idgrupo", referencedColumnName = "idgrupo")
    @ManyToOne(optional = false)
    private Grupo idgrupo;
    @JoinColumn(name = "idfabricante", referencedColumnName = "idfabricante")
    @ManyToOne(optional = false)
    private Fabricante idfabricante;

    public Produto() {
    }

    public Produto(Integer idproduto) {
        this.idproduto = idproduto;
    }

    public Produto(Integer idproduto, String descricao, Grupo idsubgrupo) {
        this.idproduto = idproduto;
        this.descricao = descricao;
        this.idsubgrupo = idsubgrupo;
    }

    public Integer getIdproduto() {
        return idproduto;
    }

    public void setIdproduto(Integer idproduto) {
        this.idproduto = idproduto;
    }


    public String getCodigobarras() {
        return codigobarras;
    }

    public void setCodigobarras(String codigobarras) {
        this.codigobarras = codigobarras;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPrecoVenda1() {
        return precoVenda1;
    }

    public void setPrecoVenda1(BigDecimal precoVenda1) {
        this.precoVenda1 = precoVenda1;
    }

    public BigDecimal getPrecoVenda2() {
        return precoVenda2;
    }

    public void setPrecoVenda2(BigDecimal precoVenda2) {
        this.precoVenda2 = precoVenda2;
    }

    public BigDecimal getPrecoVenda3() {
        return precoVenda3;
    }

    public void setPrecoVenda3(BigDecimal precoVenda3) {
        this.precoVenda3 = precoVenda3;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Integer getEntrada() {
        return entrada;
    }

    public void setEntrada(Integer entrada) {
        this.entrada = entrada;
    }

    public Integer getSaida() {
        return saida;
    }

    public void setSaida(Integer saida) {
        this.saida = saida;
    }

    public Grupo getIdsubgrupo() {
        return idsubgrupo;
    }

    public void setIdsubgrupo(Grupo idsubgrupo) {
        this.idsubgrupo = idsubgrupo;
    }

    public Integer getNcm() {
        return ncm;
    }

    public void setNcm(Integer ncm) {
        this.ncm = ncm;
    }

    public Integer getEstoqueMinimo() {
        return estoqueMinimo;
    }

    public void setEstoqueMinimo(Integer estoqueMinimo) {
        this.estoqueMinimo = estoqueMinimo;
    }

    public BigDecimal getCustoAtual() {
        return custoAtual;
    }

    public void setCustoAtual(BigDecimal custoAtual) {
        this.custoAtual = custoAtual;
    }

    public Grupo getIdgrupo() {
        return idgrupo;
    }

    public void setIdgrupo(Grupo idgrupo) {
        this.idgrupo = idgrupo;
    }

    public Fabricante getIdfabricante() {
        return idfabricante;
    }

    public void setIdfabricante(Fabricante idfabricante) {
        this.idfabricante = idfabricante;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idproduto != null ? idproduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produto)) {
            return false;
        }
        Produto other = (Produto) object;
        if ((this.idproduto == null && other.idproduto != null) || (this.idproduto != null && !this.idproduto.equals(other.idproduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.model.Produto[ idproduto=" + idproduto + " ]";
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
}
