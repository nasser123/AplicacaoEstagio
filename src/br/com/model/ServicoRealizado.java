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
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Producao
 */
@Entity
@Table(name = "servico_realizado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ServicoRealizado.findAll", query = "SELECT s FROM ServicoRealizado s"),
    @NamedQuery(name = "ServicoRealizado.findByIdservicoRealizado", query = "SELECT s FROM ServicoRealizado s WHERE s.idservicoRealizado = :idservicoRealizado"),
    @NamedQuery(name = "ServicoRealizado.findByIdordemServico", query = "SELECT s FROM ServicoRealizado s WHERE s.idordemServico = :idordemServico"),
    @NamedQuery(name = "ServicoRealizado.findByValor", query = "SELECT s FROM ServicoRealizado s WHERE s.valor = :valor")})
public class ServicoRealizado implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idservico_realizado")
    private Integer idservicoRealizado;
    @Lob
    @Column(name = "observacao")
    private String observacao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor")
    private BigDecimal valor;
    @JoinColumn(name = "idordem_servico", referencedColumnName = "idordem_servico")
    @ManyToOne(optional = true)
    private OrdemServico idordemServico;
    
//    @JoinColumn(name = "idordem_servico", referencedColumnName = "idordem_servico")
//    @ManyToOne(optional = false)
//    private Integer idordemServico;
    
    
    @JoinColumn(name = "idservico", referencedColumnName = "idservico")
    @ManyToOne(optional = false)
    private Servico idservico;
    @JoinColumn(name = "idsituacao_servico", referencedColumnName = "idsituacao_servico")
    @ManyToOne(optional = false)
    private SituacaoServico idsituacaoServico;

    public ServicoRealizado() {
    }

    public ServicoRealizado(Integer idservicoRealizado) {
        this.idservicoRealizado = idservicoRealizado;
    }

    public Integer getIdservicoRealizado() {
        return idservicoRealizado;
    }

    public void setIdservicoRealizado(Integer idservicoRealizado) {
        Integer oldIdservicoRealizado = this.idservicoRealizado;
        this.idservicoRealizado = idservicoRealizado;
        changeSupport.firePropertyChange("idservicoRealizado", oldIdservicoRealizado, idservicoRealizado);
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        String oldObservacao = this.observacao;
        this.observacao = observacao;
        changeSupport.firePropertyChange("observacao", oldObservacao, observacao);
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        BigDecimal oldValor = this.valor;
        this.valor = valor;
        changeSupport.firePropertyChange("valor", oldValor, valor);
    }

    public OrdemServico getIdordemServico() {
        return idordemServico;
    }

    public void setIdordemServico(OrdemServico idordemServico) {
        OrdemServico oldIdordemServico = this.idordemServico;
        this.idordemServico = idordemServico;
        changeSupport.firePropertyChange("idordemServico", oldIdordemServico, idordemServico);
    }

    public Servico getIdservico() {
        return idservico;
    }

    public void setIdservico(Servico idservico) {
        Servico oldIdservico = this.idservico;
        this.idservico = idservico;
        changeSupport.firePropertyChange("idservico", oldIdservico, idservico);
    }

    public SituacaoServico getIdsituacaoServico() {
        return idsituacaoServico;
    }

    public void setIdsituacaoServico(SituacaoServico idsituacaoServico) {
        SituacaoServico oldIdsituacaoServico = this.idsituacaoServico;
        this.idsituacaoServico = idsituacaoServico;
        changeSupport.firePropertyChange("idsituacaoServico", oldIdsituacaoServico, idsituacaoServico);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idservicoRealizado != null ? idservicoRealizado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ServicoRealizado)) {
            return false;
        }
        ServicoRealizado other = (ServicoRealizado) object;
        if ((this.idservicoRealizado == null && other.idservicoRealizado != null) || (this.idservicoRealizado != null && !this.idservicoRealizado.equals(other.idservicoRealizado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.model.ServicoRealizado[ idservicoRealizado=" + idservicoRealizado + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
