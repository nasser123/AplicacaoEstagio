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
 * @author Producao
 */
@Entity
@Table(name = "servico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Servico.findAll", query = "SELECT s FROM Servico s"),
    @NamedQuery(name = "Servico.findByIdservico", query = "SELECT s FROM Servico s WHERE s.idservico = :idservico"),
    @NamedQuery(name = "Servico.findByDescricao", query = "SELECT s FROM Servico s WHERE s.descricao = :descricao")})
public class Servico implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idservico")
    private List<ServicoRealizado> servicoRealizadoList;
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idservico")
    private Integer idservico;
    @Column(name = "descricao")
    private String descricao;
    
    

    public Servico() {
    }

    public Servico(Integer idservico) {
        this.idservico = idservico;
    }

    public Integer getIdservico() {
        return idservico;
    }

    public void setIdservico(Integer idservico) {
        Integer oldIdservico = this.idservico;
        this.idservico = idservico;
        changeSupport.firePropertyChange("idservico", oldIdservico, idservico);
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
    public List<ServicoRealizado> getServicoRealizadoList() {
        return servicoRealizadoList;
    }

    public void setServicoRealizadoList(List<ServicoRealizado> servicoRealizadoList) {
        this.servicoRealizadoList = servicoRealizadoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idservico != null ? idservico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Servico)) {
            return false;
        }
        Servico other = (Servico) object;
        if ((this.idservico == null && other.idservico != null) || (this.idservico != null && !this.idservico.equals(other.idservico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.model.Servico[ idservico=" + idservico + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

   
    
}
