/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asinfo.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Marco
 */
@Entity
@Table(name = "supervisor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Supervisor.findAll", query = "SELECT s FROM Supervisor s")
    , @NamedQuery(name = "Supervisor.findBySupId", query = "SELECT s FROM Supervisor s WHERE s.supId = :supId")
    , @NamedQuery(name = "Supervisor.findBySupNombre", query = "SELECT s FROM Supervisor s WHERE s.supNombre = :supNombre")
    , @NamedQuery(name = "Supervisor.findBySupApellido", query = "SELECT s FROM Supervisor s WHERE s.supApellido = :supApellido")
    , @NamedQuery(name = "Supervisor.findBySupSueldo", query = "SELECT s FROM Supervisor s WHERE s.supSueldo = :supSueldo")
    , @NamedQuery(name = "Supervisor.findBySupFechaNac", query = "SELECT s FROM Supervisor s WHERE s.supFechaNac = :supFechaNac")
    , @NamedQuery(name = "Supervisor.findBySupFHR", query = "SELECT s FROM Supervisor s WHERE s.supFHR = :supFHR")})
public class Supervisor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "supId")
    private Integer supId;
    @Size(max = 100)
    @Column(name = "supNombre")
    private String supNombre;
    @Size(max = 100)
    @Column(name = "supApellido")
    private String supApellido;
    @Column(name = "supSueldo")
    private BigDecimal supSueldo;
    @Column(name = "supFechaNac")
    @Temporal(TemporalType.TIMESTAMP)
    private Date supFechaNac;
    @Column(name = "supFHR")
    @Temporal(TemporalType.TIMESTAMP)
    private Date supFHR;
    @OneToMany(mappedBy = "supId")
    private List<SupervisorEmpleado> supervisorempleadoList;

    //Patron Builder
    Supervisor(SupervisorBuilder builder) {
        this.supNombre = builder.getSupNombre();
        this.supApellido = builder.getSupApellido();
        this.supFechaNac = builder.getSupFechaNac();
        this.supSueldo = builder.getSupSueldo();
        this.supFHR = builder.getSupFHR();
        this.supervisorempleadoList = builder.getSupervisorempleadoList();
    }

    public Supervisor() {
    }

    public Supervisor(Integer supId) {
        this.supId = supId;
    }

    public Integer getSupId() {
        return supId;
    }

    public void setSupId(Integer supId) {
        this.supId = supId;
    }

    public String getSupNombre() {
        return supNombre;
    }

    public void setSupNombre(String supNombre) {
        this.supNombre = supNombre;
    }

    public String getSupApellido() {
        return supApellido;
    }

    public void setSupApellido(String supApellido) {
        this.supApellido = supApellido;
    }

    public BigDecimal getSupSueldo() {
        return supSueldo;
    }

    public void setSupSueldo(BigDecimal supSueldo) {
        this.supSueldo = supSueldo;
    }

    public Date getSupFechaNac() {
        return supFechaNac;
    }

    public void setSupFechaNac(Date supFechaNac) {
        this.supFechaNac = supFechaNac;
    }

    public Date getSupFHR() {
        return supFHR;
    }

    public void setSupFHR(Date supFHR) {
        this.supFHR = supFHR;
    }

    @XmlTransient
    public List<SupervisorEmpleado> getSupervisorempleadoList() {
        return supervisorempleadoList;
    }

    public void setSupervisorempleadoList(List<SupervisorEmpleado> supervisorempleadoList) {
        this.supervisorempleadoList = supervisorempleadoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (supId != null ? supId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Supervisor)) {
            return false;
        }
        Supervisor other = (Supervisor) object;
        if ((this.supId == null && other.supId != null) || (this.supId != null && !this.supId.equals(other.supId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.asinfo.modelo.Supervisor[ supId=" + supId + " ]";
    }

}
