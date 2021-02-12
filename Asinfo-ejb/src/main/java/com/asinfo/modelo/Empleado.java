/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asinfo.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
@Table(name = "empleado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e")
    , @NamedQuery(name = "Empleado.findByEmpId", query = "SELECT e FROM Empleado e WHERE e.empId = :empId")
    , @NamedQuery(name = "Empleado.findByEmpNombre", query = "SELECT e FROM Empleado e WHERE e.empNombre = :empNombre")
    , @NamedQuery(name = "Empleado.findByEmpApellido", query = "SELECT e FROM Empleado e WHERE e.empApellido = :empApellido")
    , @NamedQuery(name = "Empleado.findByEmpfechaNac", query = "SELECT e FROM Empleado e WHERE e.empfechaNac = :empfechaNac")
    , @NamedQuery(name = "Empleado.findByEmpSueldo", query = "SELECT e FROM Empleado e WHERE e.empSueldo = :empSueldo")
    , @NamedQuery(name = "Empleado.findByEmpFHR", query = "SELECT e FROM Empleado e WHERE e.empFHR = :empFHR")})
public class Empleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "empId")
    private Integer empId;
    @Size(max = 100)
    @Column(name = "empNombre")
    private String empNombre;
    @Size(max = 100)
    @Column(name = "empApellido")
    private String empApellido;
    @Column(name = "empfechaNac")
    @Temporal(TemporalType.TIMESTAMP)
    private Date empfechaNac;
    @Column(name = "empSueldo")
    private Long empSueldo;
    @Column(name = "empFHR")
    @Temporal(TemporalType.TIMESTAMP)
    private Date empFHR;
    @JoinColumn(name = "depId", referencedColumnName = "depId")
    @ManyToOne
    private Departamento depId;
    @OneToMany(mappedBy = "empId")
    private List<SupervisorEmpleado> supervisorempleadoList;

    public Empleado() {
    }

    public Empleado(Integer empId) {
        this.empId = empId;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpNombre() {
        return empNombre;
    }

    public void setEmpNombre(String empNombre) {
        this.empNombre = empNombre;
    }

    public String getEmpApellido() {
        return empApellido;
    }

    public void setEmpApellido(String empApellido) {
        this.empApellido = empApellido;
    }

    public Date getEmpfechaNac() {
        return empfechaNac;
    }

    public void setEmpfechaNac(Date empfechaNac) {
        this.empfechaNac = empfechaNac;
    }

    public Long getEmpSueldo() {
        return empSueldo;
    }

    public void setEmpSueldo(Long empSueldo) {
        this.empSueldo = empSueldo;
    }

    public Date getEmpFHR() {
        return empFHR;
    }

    public void setEmpFHR(Date empFHR) {
        this.empFHR = empFHR;
    }

    public Departamento getDepId() {
        return depId;
    }

    public void setDepId(Departamento depId) {
        this.depId = depId;
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
        hash += (empId != null ? empId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.empId == null && other.empId != null) || (this.empId != null && !this.empId.equals(other.empId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.asinfo.modelo.Empleado[ empId=" + empId + " ]";
    }
    
}
