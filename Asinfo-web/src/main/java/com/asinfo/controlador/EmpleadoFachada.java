/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asinfo.controlador;

import com.asinfo.dao.DepartamentoDao;
import com.asinfo.dao.EmpleadoDao;
import com.asinfo.dao.SupervisorDao;
import com.asinfo.dao.SupervisorEmpleadoDao;
import com.asinfo.modelo.Departamento;
import com.asinfo.modelo.Empleado;
import com.asinfo.modelo.Supervisor;
import com.asinfo.modelo.SupervisorEmpleado;
import java.io.Serializable;
import java.util.Calendar;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Marco
 */
public class EmpleadoFachada {

    
    @Getter
    @Setter
    private Empleado empleadoNuevo;

    @Getter
    @Setter
    private Supervisor supervisor;


    public EmpleadoFachada(Supervisor supervisor, Empleado empleado) {
        empleadoNuevo = new Empleado();
    }

   

    @PostConstruct
    public void iniciar() {
        try {
            empleadoNuevo.setEmpFHR(Calendar.getInstance().getTime());
            
        } catch (Exception e) {
            System.err.println(e);
        }
    }

   

    public Empleado getNuevoEmpleado() {
        return empleadoNuevo;
    }

}
