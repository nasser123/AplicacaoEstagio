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
 * @author Produção
 */
@Entity
@Table(name = "situacao_os")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SituacaoOs.findAll", query = "SELECT s FROM SituacaoOs s"),
    @NamedQuery(name = "SituacaoOs.findByIdsituacaoOs", query = "SELECT s FROM SituacaoOs s WHERE s.idsituacaoOs = :idsituacaoOs"),
    @NamedQuery(name = "SituacaoOs.findByDescricao", query = "SELECT s FROM SituacaoOs s WHERE s.descricao = :descricao")})
public class SituacaoOs implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idsituacao_os")
    private Integer idsituacaoOs;
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idsituacaoOs")
    private List<OrdemServico> ordemServicoList;

    public SituacaoOs() {
    }

    public SituacaoOs(Integer idsituacaoOs) {
        this.idsituacaoOs = idsituacaoOs;
    }

    public Integer getIdsituacaoOs() {
        return idsituacaoOs;
    }

    public void setIdsituacaoOs(Integer idsituacaoOs) {
        this.idsituacaoOs = idsituacaoOs;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public List<OrdemServico> getOrdemServicoList() {
        return ordemServicoList;
    }

    public void setOrdemServicoList(List<OrdemServico> ordemServicoList) {
        this.ordemServicoList = ordemServicoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsituacaoOs != null ? idsituacaoOs.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SituacaoOs)) {
            return false;
        }
        SituacaoOs other = (SituacaoOs) object;
        if ((this.idsituacaoOs == null && other.idsituacaoOs != null) || (this.idsituacaoOs != null && !this.idsituacaoOs.equals(other.idsituacaoOs))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.model.SituacaoOs[ idsituacaoOs=" + idsituacaoOs + " ]";
    }
    
}
