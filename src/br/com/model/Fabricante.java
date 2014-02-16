/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Nasser
 */
@Entity
@Table(name = "fabricante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fabricante.findAll", query = "SELECT f FROM Fabricante f"),
    @NamedQuery(name = "Fabricante.findByIdfabricante", query = "SELECT f FROM Fabricante f WHERE f.idfabricante = :idfabricante"),
    @NamedQuery(name = "Fabricante.findByDescricao", query = "SELECT f FROM Fabricante f WHERE f.descricao = :descricao")})
public class Fabricante implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idfabricante")
    private Integer idfabricante;
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idfabricante")
    private List<Produto> produtoList;

    public Fabricante() {
    }

    public Fabricante(Integer idfabricante) {
        this.idfabricante = idfabricante;
    }

    public Integer getIdfabricante() {
        return idfabricante;
    }

    public void setIdfabricante(Integer idfabricante) {
        this.idfabricante = idfabricante;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public List<Produto> getProdutoList() {
        return produtoList;
    }

    public void setProdutoList(List<Produto> produtoList) {
        this.produtoList = produtoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfabricante != null ? idfabricante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fabricante)) {
            return false;
        }
        Fabricante other = (Fabricante) object;
        if ((this.idfabricante == null && other.idfabricante != null) || (this.idfabricante != null && !this.idfabricante.equals(other.idfabricante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.model.Fabricante[ idfabricante=" + idfabricante + " ]";
    }
    
}
