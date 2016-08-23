/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.progweb.meleva.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author shu
 */
@Entity
@Table(name = "CARONA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Carona.findAll", query = "SELECT c FROM Carona c"),
    @NamedQuery(name = "Carona.findById", query = "SELECT c FROM Carona c WHERE c.id = :id"),
    @NamedQuery(name = "Carona.findByLocalPartida", query = "SELECT c FROM Carona c WHERE c.localPartida = :localPartida"),
    @NamedQuery(name = "Carona.findByLocalChegada", query = "SELECT c FROM Carona c WHERE c.localChegada = :localChegada"),
    @NamedQuery(name = "Carona.findByNLugares", query = "SELECT c FROM Carona c WHERE c.nLugares = :nLugares"),
    @NamedQuery(name = "Carona.findByDataHorario", query = "SELECT c FROM Carona c WHERE c.dataHorario = :dataHorario"),
    @NamedQuery(name = "Carona.findByHorarioChegada", query = "SELECT c FROM Carona c WHERE c.horarioChegada = :horarioChegada"),
    @NamedQuery(name = "Carona.findByCusto", query = "SELECT c FROM Carona c WHERE c.custo = :custo"),
    @NamedQuery(name = "Carona.findByAtivo", query = "SELECT c FROM Carona c WHERE c.ativo = :ativo")})
public class Carona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")    
    private Integer id;
    @Size(max = 255)
    @Column(name = "LOCAL_PARTIDA")
    private String localPartida;
    @Size(max = 255)
    @Column(name = "LOCAL_CHEGADA")
    private String localChegada;
    @Column(name = "N_LUGARES")
    private Integer nLugares;
    @Column(name = "DATA_HORARIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHorario;
    @Column(name = "HORARIO_CHEGADA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horarioChegada;
    @Size(max = 255)
    @Column(name = "CUSTO")
    private String custo;
    @Column(name = "ATIVO")
    private Boolean ativo;
    @JoinColumn(name = "ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Motorista motorista;
    @OneToMany(mappedBy = "idCarona", fetch = FetchType.EAGER)
    private List<Passageiro> passageiroList;

    public Carona() {
    }

    public Carona(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLocalPartida() {
        return localPartida;
    }

    public void setLocalPartida(String localPartida) {
        this.localPartida = localPartida;
    }

    public String getLocalChegada() {
        return localChegada;
    }

    public void setLocalChegada(String localChegada) {
        this.localChegada = localChegada;
    }

    public Integer getNLugares() {
        return nLugares;
    }

    public void setNLugares(Integer nLugares) {
        this.nLugares = nLugares;
    }

    public Date getDataHorario() {
        return dataHorario;
    }

    public void setDataHorario(Date dataHorario) {
        this.dataHorario = dataHorario;
    }

    public Date getHorarioChegada() {
        return horarioChegada;
    }

    public void setHorarioChegada(Date horarioChegada) {
        this.horarioChegada = horarioChegada;
    }

    public String getCusto() {
        return custo;
    }

    public void setCusto(String custo) {
        this.custo = custo;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }

    @XmlTransient
    @JsonIgnore
    public List<Passageiro> getPassageiroList() {
        return passageiroList;
    }

    public void setPassageiroList(List<Passageiro> passageiroList) {
        this.passageiroList = passageiroList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Carona)) {
            return false;
        }
        Carona other = (Carona) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.progweb.meleva.entidades.Carona[ id=" + id + " ]";
    }

}
