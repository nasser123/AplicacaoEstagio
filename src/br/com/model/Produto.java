/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

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
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idproduto")
    private List<ListaAtributosProduto> listaAtributosProdutoList;
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
    @JoinColumn(name = "idsubgrupo", referencedColumnName = "idsubgrupo")
    @ManyToOne(optional = false)
    private Subgrupo idsubgrupo;
    @Column(name = "ncm")
    private Integer ncm;
    @Column(name = "estoque_minimo")
    private Integer estoqueMinimo;
    @Column(name = "custo_atual")
    private BigDecimal custoAtual;
   
    @JoinColumn(name = "idfabricante", referencedColumnName = "idfabricante")
    @ManyToOne(optional = false)
    private Fabricante idfabricante;
    

    public Produto() {
    }

    public Produto(Integer idproduto) {
        this.idproduto = idproduto;
    }

    public Produto(Integer idproduto, String descricao, Subgrupo idsubgrupo) {
        this.idproduto = idproduto;
        this.descricao = descricao;
        this.idsubgrupo = idsubgrupo;
    }

    public Integer getIdproduto() {
        return idproduto;
    }

    public void setIdproduto(Integer idproduto) {
        Integer oldIdproduto = this.idproduto;
        this.idproduto = idproduto;
        changeSupport.firePropertyChange("idproduto", oldIdproduto, idproduto);
    }


    public String getCodigobarras() {
        return codigobarras;
    }

    public void setCodigobarras(String codigobarras) {
        String oldCodigobarras = this.codigobarras;
        this.codigobarras = codigobarras;
        changeSupport.firePropertyChange("codigobarras", oldCodigobarras, codigobarras);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        String oldDescricao = this.descricao;
        this.descricao = descricao;
        changeSupport.firePropertyChange("descricao", oldDescricao, descricao);
    }

    public BigDecimal getPrecoVenda1() {
        return precoVenda1;
    }

    public void setPrecoVenda1(BigDecimal precoVenda1) {
        BigDecimal oldPrecoVenda1 = this.precoVenda1;
        this.precoVenda1 = precoVenda1;
        changeSupport.firePropertyChange("precoVenda1", oldPrecoVenda1, precoVenda1);
    }

    public BigDecimal getPrecoVenda2() {
        return precoVenda2;
    }

    public void setPrecoVenda2(BigDecimal precoVenda2) {
        BigDecimal oldPrecoVenda2 = this.precoVenda2;
        this.precoVenda2 = precoVenda2;
        changeSupport.firePropertyChange("precoVenda2", oldPrecoVenda2, precoVenda2);
    }

    public BigDecimal getPrecoVenda3() {
        return precoVenda3;
    }

    public void setPrecoVenda3(BigDecimal precoVenda3) {
        BigDecimal oldPrecoVenda3 = this.precoVenda3;
        this.precoVenda3 = precoVenda3;
        changeSupport.firePropertyChange("precoVenda3", oldPrecoVenda3, precoVenda3);
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        String oldObservacoes = this.observacoes;
        this.observacoes = observacoes;
        changeSupport.firePropertyChange("observacoes", oldObservacoes, observacoes);
    }

    public Integer getEntrada() {
        return entrada;
    }

    public void setEntrada(Integer entrada) {
        Integer oldEntrada = this.entrada;
        this.entrada = entrada;
        changeSupport.firePropertyChange("entrada", oldEntrada, entrada);
    }

    public Integer getSaida() {
        return saida;
    }

    public void setSaida(Integer saida) {
        Integer oldSaida = this.saida;
        this.saida = saida;
        changeSupport.firePropertyChange("saida", oldSaida, saida);
    }

    public Subgrupo getIdsubgrupo() {
        return idsubgrupo;
    }

    public void setIdsubgrupo(Subgrupo idsubgrupo) {
        Subgrupo oldIdsubgrupo = this.idsubgrupo;
        this.idsubgrupo = idsubgrupo;
        changeSupport.firePropertyChange("idsubgrupo", oldIdsubgrupo, idsubgrupo);
    }

    public Integer getNcm() {
        return ncm;
    }

    public void setNcm(Integer ncm) {
        Integer oldNcm = this.ncm;
        this.ncm = ncm;
        changeSupport.firePropertyChange("ncm", oldNcm, ncm);
    }

    public Integer getEstoqueMinimo() {
        return estoqueMinimo;
    }

    public void setEstoqueMinimo(Integer estoqueMinimo) {
        Integer oldEstoqueMinimo = this.estoqueMinimo;
        this.estoqueMinimo = estoqueMinimo;
        changeSupport.firePropertyChange("estoqueMinimo", oldEstoqueMinimo, estoqueMinimo);
    }

    public BigDecimal getCustoAtual() {
        return custoAtual;
    }

    public void setCustoAtual(BigDecimal custoAtual) {
        BigDecimal oldCustoAtual = this.custoAtual;
        this.custoAtual = custoAtual;
        changeSupport.firePropertyChange("custoAtual", oldCustoAtual, custoAtual);
    }

   

    public Fabricante getIdfabricante() {
        return idfabricante;
    }

    public void setIdfabricante(Fabricante idfabricante) {
        Fabricante oldIdfabricante = this.idfabricante;
        this.idfabricante = idfabricante;
        changeSupport.firePropertyChange("idfabricante", oldIdfabricante, idfabricante);
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
        int oldCodigo = this.codigo;
        this.codigo = codigo;
        changeSupport.firePropertyChange("codigo", oldCodigo, codigo);
    }

    @XmlTransient
    public List<ListaAtributosProduto> getListaAtributosProdutoList() {
        return listaAtributosProdutoList;
    }

    public void setListaAtributosProdutoList(List<ListaAtributosProduto> listaAtributosProdutoList) {
        this.listaAtributosProdutoList = listaAtributosProdutoList;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
    

    public int getEstoque() {
        return this.entrada - this.saida;
    }

//    public void setEstoque() {
//        this.estoque = this.entrada - this.saida;
//    }
    
}
