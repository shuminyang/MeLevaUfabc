/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.progweb.meleva.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author shu
 */
@Entity
@Table(name = "INFO_USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InfoUsuario.findAll", query = "SELECT i FROM InfoUsuario i"),
    @NamedQuery(name = "InfoUsuario.findById", query = "SELECT i FROM InfoUsuario i WHERE i.id = :id"),
    @NamedQuery(name = "InfoUsuario.findByNome", query = "SELECT i FROM InfoUsuario i WHERE i.nome = :nome"),
    @NamedQuery(name = "InfoUsuario.findByCpf", query = "SELECT i FROM InfoUsuario i WHERE i.cpf = :cpf"),
    @NamedQuery(name = "InfoUsuario.findByEndereco", query = "SELECT i FROM InfoUsuario i WHERE i.endereco = :endereco"),
    @NamedQuery(name = "InfoUsuario.findByEmail", query = "SELECT i FROM InfoUsuario i WHERE i.email = :email"),
    @NamedQuery(name = "InfoUsuario.findByDataNascimento", query = "SELECT i FROM InfoUsuario i WHERE i.dataNascimento = :dataNascimento"),
    @NamedQuery(name = "InfoUsuario.findByDataInclusao", query = "SELECT i FROM InfoUsuario i WHERE i.dataInclusao = :dataInclusao")})
public class InfoUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 255)
    @Column(name = "NOME")
    private String nome;
    @Size(max = 255)
    @Column(name = "CPF")
    private String cpf;
    @Size(max = 255)
    @Column(name = "ENDERECO")
    private String endereco;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "DATA_NASCIMENTO")
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    @Column(name = "DATA_INCLUSAO")
    @Temporal(TemporalType.DATE)
    private Date dataInclusao;
    @JoinColumn(name = "ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Usuario usuario;

    public InfoUsuario() {
    }

    public InfoUsuario(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Date getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(Date dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
        if (!(object instanceof InfoUsuario)) {
            return false;
        }
        InfoUsuario other = (InfoUsuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.progweb.meleva.entidades.InfoUsuario[ id=" + id + " ]";
    }
    
}
