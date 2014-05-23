/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Producao
 */
@Entity
@Table(name = "ordem_servico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdemServico.findAll", query = "SELECT o FROM OrdemServico o"),
    @NamedQuery(name = "OrdemServico.findByIdordemServico", query = "SELECT o FROM OrdemServico o WHERE o.idordemServico = :idordemServico"),
    @NamedQuery(name = "OrdemServico.findByDataAbertura", query = "SELECT o FROM OrdemServico o WHERE o.dataAbertura = :dataAbertura"),
    @NamedQuery(name = "OrdemServico.findByDataTermino", query = "SELECT o FROM OrdemServico o WHERE o.dataTermino = :dataTermino"),
    @NamedQuery(name = "OrdemServico.findByProcessador", query = "SELECT o FROM OrdemServico o WHERE o.processador = :processador"),
    @NamedQuery(name = "OrdemServico.findByPlacaMae", query = "SELECT o FROM OrdemServico o WHERE o.placaMae = :placaMae"),
    @NamedQuery(name = "OrdemServico.findByMemoria", query = "SELECT o FROM OrdemServico o WHERE o.memoria = :memoria"),
    @NamedQuery(name = "OrdemServico.findByFonte", query = "SELECT o FROM OrdemServico o WHERE o.fonte = :fonte"),
    @NamedQuery(name = "OrdemServico.findByDiscoRigido", query = "SELECT o FROM OrdemServico o WHERE o.discoRigido = :discoRigido"),
    @NamedQuery(name = "OrdemServico.findByMarca", query = "SELECT o FROM OrdemServico o WHERE o.marca = :marca")})
public class OrdemServico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idordem_servico")
    private Integer idordemServico;
    @Lob
    @Column(name = "efeito_cliente")
    private String efeitoCliente;
    @Lob
    @Column(name = "feedback")
    private String feedback;
    @Column(name = "data_abertura")
    @Temporal(TemporalType.DATE)
    private Date dataAbertura;
    @Column(name = "data_termino")
    @Temporal(TemporalType.DATE)
    private Date dataTermino;
    @Lob
    @Column(name = "observacao")
    private String observacao;
    @Column(name = "processador")
    private String processador;
    @Column(name = "placa_mae")
    private String placaMae;
    @Column(name = "memoria")
    private String memoria;
    @Column(name = "fonte")
    private String fonte;
    @Column(name = "disco_rigido")
    private String discoRigido;
    @Column(name = "marca")
    private String marca;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idordemServico")
    private List<ServicoRealizado> servicoRealizadoList;
    @JoinColumn(name = "idcliente", referencedColumnName = "idcliente")
    @ManyToOne
    private Cliente idcliente;
    @JoinColumn(name = "idequipamento", referencedColumnName = "idequipamento")
    @ManyToOne(optional = false)
    private Equipamento idequipamento;
    @JoinColumn(name = "idsituacao_os", referencedColumnName = "idsituacao_os")
    @ManyToOne(optional = false)
    private SituacaoOs idsituacaoOs;

    public OrdemServico() {
    }

    public OrdemServico(Integer idordemServico) {
        this.idordemServico = idordemServico;
    }

    public Integer getIdordemServico() {
        return idordemServico;
    }

    public void setIdordemServico(Integer idordemServico) {
        this.idordemServico = idordemServico;
    }

    public String getEfeitoCliente() {
        return efeitoCliente;
    }

    public void setEfeitoCliente(String efeitoCliente) {
        this.efeitoCliente = efeitoCliente;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public Date getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(Date dataTermino) {
        this.dataTermino = dataTermino;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getProcessador() {
        return processador;
    }

    public void setProcessador(String processador) {
        this.processador = processador;
    }

    public String getPlacaMae() {
        return placaMae;
    }

    public void setPlacaMae(String placaMae) {
        this.placaMae = placaMae;
    }

    public String getMemoria() {
        return memoria;
    }

    public void setMemoria(String memoria) {
        this.memoria = memoria;
    }

    public String getFonte() {
        return fonte;
    }

    public void setFonte(String fonte) {
        this.fonte = fonte;
    }

    public String getDiscoRigido() {
        return discoRigido;
    }

    public void setDiscoRigido(String discoRigido) {
        this.discoRigido = discoRigido;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @XmlTransient
    public List<ServicoRealizado> getServicoRealizadoList() {
        return servicoRealizadoList;
    }

    public void setServicoRealizadoList(List<ServicoRealizado> servicoRealizadoList) {
        this.servicoRealizadoList = servicoRealizadoList;
    }

    public Cliente getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Cliente idcliente) {
        this.idcliente = idcliente;
    }

    public Equipamento getIdequipamento() {
        return idequipamento;
    }

    public void setIdequipamento(Equipamento idequipamento) {
        this.idequipamento = idequipamento;
    }

    public SituacaoOs getIdsituacaoOs() {
        return idsituacaoOs;
    }

    public void setIdsituacaoOs(SituacaoOs idsituacaoOs) {
        this.idsituacaoOs = idsituacaoOs;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idordemServico != null ? idordemServico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdemServico)) {
            return false;
        }
        OrdemServico other = (OrdemServico) object;
        if ((this.idordemServico == null && other.idordemServico != null) || (this.idordemServico != null && !this.idordemServico.equals(other.idordemServico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.model.OrdemServico[ idordemServico=" + idordemServico + " ]";
    }
    
}
