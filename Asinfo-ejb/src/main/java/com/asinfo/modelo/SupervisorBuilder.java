/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asinfo.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Marco
 */
public class SupervisorBuilder implements Serializable{

    private String supNombre;
    private String supApellido;
    private Long supSueldo;
    private Date supFechaNac;
    private Date supFHR;
    private List<SupervisorEmpleado> supervisorempleadoList;

    public SupervisorBuilder() {

    }

    public SupervisorBuilder supNombre(String supNombre, String supApellido) {
        this.supNombre = supNombre;
        this.supApellido = supApellido;
        return this;
    }

    public SupervisorBuilder supSueldo(Long supSueldo) {
        this.supSueldo = supSueldo;
        return this;
    }

    public SupervisorBuilder supFechaNac(Date supFechaNac) {
        this.supFechaNac = supFechaNac;
        return this;
    }

    public SupervisorBuilder supFHR(Date supFHR) {
        this.supFHR = supFHR;
        return this;
    }

    public SupervisorBuilder supervisorempleadoList(List<SupervisorEmpleado> supervisorempleadoList) {
        this.supervisorempleadoList = supervisorempleadoList;
        return this;
    }

    public Supervisor build() {
        return new Supervisor(this);
    }

    //Getters
    public String getSupNombre() {
        return supNombre;
    }

    public String getSupApellido() {
        return supApellido;
    }

    public Long getSupSueldo() {
        return supSueldo;
    }

    public Date getSupFechaNac() {
        return supFechaNac;
    }

    public Date getSupFHR() {
        return supFHR;
    }

    public List<SupervisorEmpleado> getSupervisorempleadoList() {
        return supervisorempleadoList;
    }
}
