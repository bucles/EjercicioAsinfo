/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asinfo.modelo;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Marco
 */
@Entity
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByUsuId", query = "SELECT u FROM Usuario u WHERE u.usuId = :usuId")
    , @NamedQuery(name = "Usuario.findByUsuUsuario", query = "SELECT u FROM Usuario u WHERE u.usuUsuario = :usuUsuario")
    , @NamedQuery(name = "Usuario.findByUsuPassword", query = "SELECT u FROM Usuario u WHERE u.usuPassword = :usuPassword")
    , @NamedQuery(name = "Usuario.findByUsuFHR", query = "SELECT u FROM Usuario u WHERE u.usuFHR = :usuFHR")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "usuId")
    private Integer usuId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "usuUsuario")
    private String usuUsuario;
    @Size(max = 50)
    @Column(name = "usuPassword")
    private String usuPassword;
    @Column(name = "usuFHR")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usuFHR;

    public Usuario() {
    }

    public Usuario(Integer usuId) {
        this.usuId = usuId;
    }

    public Usuario(Integer usuId, String usuUsuario) {
        this.usuId = usuId;
        this.usuUsuario = usuUsuario;
    }

    public Integer getUsuId() {
        return usuId;
    }

    public void setUsuId(Integer usuId) {
        this.usuId = usuId;
    }

    public String getUsuUsuario() {
        return usuUsuario;
    }

    public void setUsuUsuario(String usuUsuario) {
        this.usuUsuario = usuUsuario;
    }

    public String getUsuPassword() {
        return usuPassword;
    }

    public void setUsuPassword(String usuPassword) {
        this.usuPassword = usuPassword;
    }

    public Date getUsuFHR() {
        return usuFHR;
    }

    public void setUsuFHR(Date usuFHR) {
        this.usuFHR = usuFHR;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuId != null ? usuId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.usuId == null && other.usuId != null) || (this.usuId != null && !this.usuId.equals(other.usuId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.asinfo.modelo.Usuario[ usuId=" + usuId + " ]";
    }
    
}
