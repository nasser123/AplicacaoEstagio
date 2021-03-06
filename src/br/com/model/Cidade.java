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
@Table(name = "cidade")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cidade.findAll", query = "SELECT c FROM Cidade c"),
    @NamedQuery(name = "Cidade.findByIdcidade", query = "SELECT c FROM Cidade c WHERE c.idcidade = :idcidade"),
    @NamedQuery(name = "Cidade.findByNome", query = "SELECT c FROM Cidade c WHERE c.nome = :nome")})
public class Cidade implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcidade")
    private List<Cliente> clienteList;
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcidade")
    private List<Fornecedor> fornecedorList;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idcidade")
    private Integer idcidade;
    @Column(name = "nome")
    private String nome;
    @JoinColumn(name = "idestado", referencedColumnName = "idestado")
    @ManyToOne(optional = false)
    private Estado idestado;
    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "idcidade")
   // private List<Cliente> clienteList;

    public Cidade() {
    }

    public Cidade(Integer idcidade) {
        this.idcidade = idcidade;
    }

    public Integer getIdcidade() {
        return idcidade;
    }

    public void setIdcidade(Integer idcidade) {
        Integer oldIdcidade = this.idcidade;
        this.idcidade = idcidade;
        changeSupport.firePropertyChange("idcidade", oldIdcidade, idcidade);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        String oldNome = this.nome;
        this.nome = nome;
        changeSupport.firePropertyChange("nome", oldNome, nome);
    }

    public Estado getIdestado() {
        return idestado;
    }

    public void setIdestado(Estado idestado) {
        Estado oldIdestado = this.idestado;
        this.idestado = idestado;
        changeSupport.firePropertyChange("idestado", oldIdestado, idestado);
    }

//    @XmlTransient
//    public List<Cliente> getClienteList() {
//        return clienteList;
//    }
//
//    public void setClienteList(List<Cliente> clienteList) {
//        this.clienteList = clienteList;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcidade != null ? idcidade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cidade)) {
            return false;
        }
        Cidade other = (Cidade) object;
        if ((this.idcidade == null && other.idcidade != null) || (this.idcidade != null && !this.idcidade.equals(other.idcidade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.model.Cidade[ idcidade=" + idcidade + " ]";
    }

    @XmlTransient
    public List<Fornecedor> getFornecedorList() {
        return fornecedorList;
    }

    public void setFornecedorList(List<Fornecedor> fornecedorList) {
        this.fornecedorList = fornecedorList;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

    @XmlTransient
    public List<Cliente> getClienteList() {
        return clienteList;
    }

    public void setClienteList(List<Cliente> clienteList) {
        this.clienteList = clienteList;
    }
    
}
