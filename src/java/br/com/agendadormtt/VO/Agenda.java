/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.agendadormtt.VO;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mlopes
 */
@Entity
@Table(name = "agenda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Agenda.findAll", query = "SELECT a FROM Agenda a"),
    @NamedQuery(name = "Agenda.findByAgendaId", query = "SELECT a FROM Agenda a WHERE a.agendaId = :agendaId"),
    @NamedQuery(name = "Agenda.findByAgendaData", query = "SELECT a FROM Agenda a WHERE a.agendaData = :agendaData"),
    @NamedQuery(name = "Agenda.findByAgendaHora", query = "SELECT a FROM Agenda a WHERE a.agendaHora = :agendaHora"),
    @NamedQuery(name = "Agenda.findByAgendaProjetoId", query = "SELECT a FROM Agenda a WHERE a.agendaProjetoId = :agendaProjetoId"),
    @NamedQuery(name = "Agenda.findByAgendaCidade", query = "SELECT a FROM Agenda a WHERE a.agendaCidade = :agendaCidade"),
    @NamedQuery(name = "Agenda.findByAgendaUf", query = "SELECT a FROM Agenda a WHERE a.agendaUf = :agendaUf"),
    @NamedQuery(name = "Agenda.findByAgendaClienteFinal", query = "SELECT a FROM Agenda a WHERE a.agendaClienteFinal = :agendaClienteFinal"),
    @NamedQuery(name = "Agenda.findByAgendaSolicitante", query = "SELECT a FROM Agenda a WHERE a.agendaSolicitante = :agendaSolicitante"),
    @NamedQuery(name = "Agenda.findByAgendaDescricaoAtividade", query = "SELECT a FROM Agenda a WHERE a.agendaDescricaoAtividade = :agendaDescricaoAtividade")})
public class Agenda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "agenda_id")
    private Integer agendaId;
    @Basic(optional = false)
    @Column(name = "agenda_data")
    @Temporal(TemporalType.DATE)
    private Date agendaData;
    @Basic(optional = false)
    @Column(name = "agenda_hora")
    @Temporal(TemporalType.TIME)
    private Date agendaHora;
    @Basic(optional = false)
    @Column(name = "agenda_projeto_id")
    private String agendaProjetoId;
    @Basic(optional = false)
    @Column(name = "agenda_cidade")
    private String agendaCidade;
    @Basic(optional = false)
    @Column(name = "agenda_uf")
    private String agendaUf;
    @Basic(optional = false)
    @Column(name = "agenda_cliente_final")
    private String agendaClienteFinal;
    @Basic(optional = false)
    @Column(name = "agenda_solicitante")
    private String agendaSolicitante;
    @Basic(optional = false)
    @Column(name = "agenda_descricao_atividade")
    private String agendaDescricaoAtividade;

    public Agenda() {
    }

    public Agenda(Integer agendaId) {
        this.agendaId = agendaId;
    }

    public Agenda(Integer agendaId, Date agendaData, Date agendaHora, String agendaProjetoId, String agendaCidade, String agendaUf, String agendaClienteFinal, String agendaSolicitante, String agendaDescricaoAtividade) {
        this.agendaId = agendaId;
        this.agendaData = agendaData;
        this.agendaHora = agendaHora;
        this.agendaProjetoId = agendaProjetoId;
        this.agendaCidade = agendaCidade;
        this.agendaUf = agendaUf;
        this.agendaClienteFinal = agendaClienteFinal;
        this.agendaSolicitante = agendaSolicitante;
        this.agendaDescricaoAtividade = agendaDescricaoAtividade;
    }

    public Integer getAgendaId() {
        return agendaId;
    }

    public void setAgendaId(Integer agendaId) {
        this.agendaId = agendaId;
    }

    public Date getAgendaData() {
        return agendaData;
    }

    public void setAgendaData(Date agendaData) {
        this.agendaData = agendaData;
    }

    public Date getAgendaHora() {
        return agendaHora;
    }

    public void setAgendaHora(Date agendaHora) {
        this.agendaHora = agendaHora;
    }

    public String getAgendaProjetoId() {
        return agendaProjetoId;
    }

    public void setAgendaProjetoId(String agendaProjetoId) {
        this.agendaProjetoId = agendaProjetoId;
    }

    public String getAgendaCidade() {
        return agendaCidade;
    }

    public void setAgendaCidade(String agendaCidade) {
        this.agendaCidade = agendaCidade;
    }

    public String getAgendaUf() {
        return agendaUf;
    }

    public void setAgendaUf(String agendaUf) {
        this.agendaUf = agendaUf;
    }

    public String getAgendaClienteFinal() {
        return agendaClienteFinal;
    }

    public void setAgendaClienteFinal(String agendaClienteFinal) {
        this.agendaClienteFinal = agendaClienteFinal;
    }

    public String getAgendaSolicitante() {
        return agendaSolicitante;
    }

    public void setAgendaSolicitante(String agendaSolicitante) {
        this.agendaSolicitante = agendaSolicitante;
    }

    public String getAgendaDescricaoAtividade() {
        return agendaDescricaoAtividade;
    }

    public void setAgendaDescricaoAtividade(String agendaDescricaoAtividade) {
        this.agendaDescricaoAtividade = agendaDescricaoAtividade;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (agendaId != null ? agendaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Agenda)) {
            return false;
        }
        Agenda other = (Agenda) object;
        if ((this.agendaId == null && other.agendaId != null) || (this.agendaId != null && !this.agendaId.equals(other.agendaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.agendadormtt.VO.Agenda[ agendaId=" + agendaId + " ]";
    }
    
}
