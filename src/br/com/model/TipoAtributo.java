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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "tipo_atributo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoAtributo.findAll", query = "SELECT t FROM TipoAtributo t"),
    @NamedQuery(name = "TipoAtributo.findByIdtipoAtributo", query = "SELECT t FROM TipoAtributo t WHERE t.idtipoAtributo = :idtipoAtributo"),
    @NamedQuery(name = "TipoAtributo.findByDescricao", query = "SELECT t FROM TipoAtributo t WHERE t.descricao = :descricao")})
public class TipoAtributo implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtipo_atributo")
    private Integer idtipoAtributo;
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtipoAtributo")
    private List<Atributos> atributosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtipoAtributo")
    private List<ListaAtributoSubgrupo> listaAtributoSubgrupoList;

    public TipoAtributo() {
    }

    public TipoAtributo(Integer idtipoAtributo) {
        this.idtipoAtributo = idtipoAtributo;
    }

    public Integer getIdtipoAtributo() {
        return idtipoAtributo;
    }

    public void setIdtipoAtributo(Integer idtipoAtributo) {
        Integer oldIdtipoAtributo = this.idtipoAtributo;
        this.idtipoAtributo = idtipoAtributo;
        changeSupport.firePropertyChange("idtipoAtributo", oldIdtipoAtributo, idtipoAtributo);
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
    public List<Atributos> getAtributosList() {
        return atributosList;
    }

    public void setAtributosList(List<Atributos> atributosList) {
        this.atributosList = atributosList;
    }

    @XmlTransient
    public List<ListaAtributoSubgrupo> getListaAtributoSubgrupoList() {
        return listaAtributoSubgrupoList;
    }

    public void setListaAtributoSubgrupoList(List<ListaAtributoSubgrupo> listaAtributoSubgrupoList) {
        this.listaAtributoSubgrupoList = listaAtributoSubgrupoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipoAtributo != null ? idtipoAtributo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoAtributo)) {
            return false;
        }
        TipoAtributo other = (TipoAtributo) object;
        if ((this.idtipoAtributo == null && other.idtipoAtributo != null) || (this.idtipoAtributo != null && !this.idtipoAtributo.equals(other.idtipoAtributo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.model.TipoAtributo[ idtipoAtributo=" + idtipoAtributo + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
