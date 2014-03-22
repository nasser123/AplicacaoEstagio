/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "subgrupo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subgrupo.findAll", query = "SELECT s FROM Subgrupo s"),
    @NamedQuery(name = "Subgrupo.findByIdsubgrupo", query = "SELECT s FROM Subgrupo s WHERE s.idsubgrupo = :idsubgrupo"),
    @NamedQuery(name = "Subgrupo.findByIdGrupo", query = "SELECT s FROM Subgrupo s WHERE s.idgrupo = :idgrupo"),
    @NamedQuery(name = "Subgrupo.findByDescricao", query = "SELECT s FROM Subgrupo s WHERE s.descricao = :descricao")})
public class Subgrupo implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idsubgrupo")
    private List<ListaAtributoSubgrupo> listaAtributoSubgrupoList;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idsubgrupo")
    private Integer idsubgrupo;
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idsubgrupo")
    private List<Produto> produtoList;
    @JoinColumn(name = "idgrupo", referencedColumnName = "idgrupo")
    @ManyToOne(optional = true)
    private Grupo idgrupo;

    public Subgrupo() {
    }

    public Subgrupo(Integer idsubgrupo) {
        this.idsubgrupo = idsubgrupo;
    }

    public Integer getIdsubgrupo() {
        return idsubgrupo;
    }

    public void setIdsubgrupo(Integer idsubgrupo) {
        Integer oldIdsubgrupo = this.idsubgrupo;
        this.idsubgrupo = idsubgrupo;
        changeSupport.firePropertyChange("idsubgrupo", oldIdsubgrupo, idsubgrupo);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        String oldDescricao = this.descricao;
        this.descricao = descricao;
        changeSupport.firePropertyChange("descricao", oldDescricao, descricao);
    }

    @XmlTransient
    public List<Produto> getProdutoList() {
        return produtoList;
    }

    public void setProdutoList(List<Produto> produtoList) {
        this.produtoList = produtoList;
    }

    public Grupo getIdgrupo() {
        return idgrupo;
    }

    public void setIdgrupo(Grupo idgrupo) {
        Grupo oldIdgrupo = this.idgrupo;
        this.idgrupo = idgrupo;
        changeSupport.firePropertyChange("idgrupo", oldIdgrupo, idgrupo);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsubgrupo != null ? idsubgrupo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subgrupo)) {
            return false;
        }
        Subgrupo other = (Subgrupo) object;
        if ((this.idsubgrupo == null && other.idsubgrupo != null) || (this.idsubgrupo != null && !this.idsubgrupo.equals(other.idsubgrupo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.model.Subgrupo[ idsubgrupo=" + idsubgrupo + " ]";
    }

    @XmlTransient
    public List<ListaAtributoSubgrupo> getListaAtributoSubgrupoList() {
        return listaAtributoSubgrupoList;
    }

    public void setListaAtributoSubgrupoList(List<ListaAtributoSubgrupo> listaAtributoSubgrupoList) {
        this.listaAtributoSubgrupoList = listaAtributoSubgrupoList;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
