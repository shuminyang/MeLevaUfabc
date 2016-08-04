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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

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
    @NamedQuery(name = "Carona.findByNLugares", query = "SELECT c FROM Carona c WHERE c.nLugares = :nLugares"),
    @NamedQuery(name = "Carona.findByLocalPartida", query = "SELECT c FROM Carona c WHERE c.localPartida = :localPartida"),
    @NamedQuery(name = "Carona.findByLocalChegada", query = "SELECT c FROM Carona c WHERE c.localChegada = :localChegada"),
    @NamedQuery(name = "Carona.findByDataHorario", query = "SELECT c FROM Carona c WHERE c.dataHorario = :dataHorario"),
    @NamedQuery(name = "Carona.findByCustos", query = "SELECT c FROM Carona c WHERE c.custos = :custos"),
    @NamedQuery(name = "Carona.findByHorarioChegada", query = "SELECT c FROM Carona c WHERE c.horarioChegada = :horarioChegada")})
public class Carona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Column(name = "N_LUGARES")
    private Integer nLugares;
    @Size(max = 255)
    @Column(name = "LOCAL_PARTIDA")
    private String localPartida;
    @Size(max = 255)
    @Column(name = "LOCAL_CHEGADA")
    private String localChegada;
    @Column(name = "DATA_HORARIO")
    @Temporal(TemporalType.DATE)
    private Date dataHorario;
    @Size(max = 255)
    @Column(name = "CUSTOS")
    private String custos;
    @Column(name = "HORARIO_CHEGADA")
    @Temporal(TemporalType.DATE)
    private Date horarioChegada;
    @OneToMany(mappedBy = "idCarona")
    private List<Usuario> usuarioList;

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

    public Integer getNLugares() {
        return nLugares;
    }

    public void setNLugares(Integer nLugares) {
        this.nLugares = nLugares;
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

    public Date getDataHorario() {
        return dataHorario;
    }

    public void setDataHorario(Date dataHorario) {
        this.dataHorario = dataHorario;
    }

    public String getCustos() {
        return custos;
    }

    public void setCustos(String custos) {
        this.custos = custos;
    }

    public Date getHorarioChegada() {
        return horarioChegada;
    }

    public void setHorarioChegada(Date horarioChegada) {
        this.horarioChegada = horarioChegada;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
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
