/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asinfo.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
 * @author Marco
 */
@Entity
@Table(name = "departamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Departamento.findAll", query = "SELECT d FROM Departamento d")
    , @NamedQuery(name = "Departamento.findByDepId", query = "SELECT d FROM Departamento d WHERE d.depId = :depId")
    , @NamedQuery(name = "Departamento.findByDepNombre", query = "SELECT d FROM Departamento d WHERE d.depNombre = :depNombre")
    , @NamedQuery(name = "Departamento.findByDepDetalle", query = "SELECT d FROM Departamento d WHERE d.depDetalle = :depDetalle")
    , @NamedQuery(name = "Departamento.findByDepFHR", query = "SELECT d FROM Departamento d WHERE d.depFHR = :depFHR")})
public class Departamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "depId")
    private Integer depId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "depNombre")
    private String depNombre;
    @Size(max = 45)
    @Column(name = "depDetalle")
    private String depDetalle;
    @Column(name = "depFHR")
    @Temporal(TemporalType.TIMESTAMP)
    private Date depFHR;
    @OneToMany(mappedBy = "depId")
    private List<Empleado> empleadoList;

    public Departamento() {
    }

    public Departamento(Integer depId) {
        this.depId = depId;
    }

    public Departamento(Integer depId, String depNombre) {
        this.depId = depId;
        this.depNombre = depNombre;
    }

    public Integer getDepId() {
        return depId;
    }

    public void setDepId(Integer depId) {
        this.depId = depId;
    }

    public String getDepNombre() {
        return depNombre;
    }

    public void setDepNombre(String depNombre) {
        this.depNombre = depNombre;
    }

    public String getDepDetalle() {
        return depDetalle;
    }

    public void setDepDetalle(String depDetalle) {
        this.depDetalle = depDetalle;
    }

    public Date getDepFHR() {
        return depFHR;
    }

    public void setDepFHR(Date depFHR) {
        this.depFHR = depFHR;
    }

    @XmlTransient
    public List<Empleado> getEmpleadoList() {
        return empleadoList;
    }

    public void setEmpleadoList(List<Empleado> empleadoList) {
        this.empleadoList = empleadoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (depId != null ? depId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Departamento)) {
            return false;
        }
        Departamento other = (Departamento) object;
        if ((this.depId == null && other.depId != null) || (this.depId != null && !this.depId.equals(other.depId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.asinfo.modelo.Departamento[ depId=" + depId + " ]";
    }

    
}
