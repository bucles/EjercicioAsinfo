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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Marco
 */
@Entity
@Table(name = "supervisorempleado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SupervisorEmpleado.findAll", query = "SELECT s FROM SupervisorEmpleado s")
    , @NamedQuery(name = "SupervisorEmpleado.findBySemId", query = "SELECT s FROM SupervisorEmpleado s WHERE s.semId = :semId")
    , @NamedQuery(name = "SupervisorEmpleado.findBySemFHR", query = "SELECT s FROM SupervisorEmpleado s WHERE s.semFHR = :semFHR")})
public class SupervisorEmpleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "semId")
    private Integer semId;
    @Column(name = "semFHR")
    @Temporal(TemporalType.TIMESTAMP)
    private Date semFHR;
    @JoinColumn(name = "empId", referencedColumnName = "empId")
    @ManyToOne
    private Empleado empId;
    @JoinColumn(name = "supId", referencedColumnName = "supId")
    @ManyToOne
    private Supervisor supId;

    public SupervisorEmpleado() {
    }

    public SupervisorEmpleado(Integer semId) {
        this.semId = semId;
    }

    public Integer getSemId() {
        return semId;
    }

    public void setSemId(Integer semId) {
        this.semId = semId;
    }

    public Date getSemFHR() {
        return semFHR;
    }

    public void setSemFHR(Date semFHR) {
        this.semFHR = semFHR;
    }

    public Empleado getEmpId() {
        return empId;
    }

    public void setEmpId(Empleado empId) {
        this.empId = empId;
    }

    public Supervisor getSupId() {
        return supId;
    }

    public void setSupId(Supervisor supId) {
        this.supId = supId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (semId != null ? semId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SupervisorEmpleado)) {
            return false;
        }
        SupervisorEmpleado other = (SupervisorEmpleado) object;
        if ((this.semId == null && other.semId != null) || (this.semId != null && !this.semId.equals(other.semId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.asinfo.modelo.Supervisorempleado[ semId=" + semId + " ]";
    }

}
