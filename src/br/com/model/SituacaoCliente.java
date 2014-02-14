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
@Table(name = "situacao_cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SituacaoCliente.findAll", query = "SELECT s FROM SituacaoCliente s"),
    @NamedQuery(name = "SituacaoCliente.findByIdsituacaoCliente", query = "SELECT s FROM SituacaoCliente s WHERE s.idsituacaoCliente = :idsituacaoCliente"),
    @NamedQuery(name = "SituacaoCliente.findByDescricao", query = "SELECT s FROM SituacaoCliente s WHERE s.descricao = :descricao")})
public class SituacaoCliente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idsituacao_cliente")
    private Integer idsituacaoCliente;
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idsituacaoCliente")
    private List<Cliente> clienteList;

    public SituacaoCliente() {
    }

    public SituacaoCliente(Integer idsituacaoCliente) {
        this.idsituacaoCliente = idsituacaoCliente;
    }

    public Integer getIdsituacaoCliente() {
        return idsituacaoCliente;
    }

    public void setIdsituacaoCliente(Integer idsituacaoCliente) {
        this.idsituacaoCliente = idsituacaoCliente;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public List<Cliente> getClienteList() {
        return clienteList;
    }

    public void setClienteList(List<Cliente> clienteList) {
        this.clienteList = clienteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsituacaoCliente != null ? idsituacaoCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SituacaoCliente)) {
            return false;
        }
        SituacaoCliente other = (SituacaoCliente) object;
        if ((this.idsituacaoCliente == null && other.idsituacaoCliente != null) || (this.idsituacaoCliente != null && !this.idsituacaoCliente.equals(other.idsituacaoCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.model.SituacaoCliente[ idsituacaoCliente=" + idsituacaoCliente + " ]";
    }
    
}
