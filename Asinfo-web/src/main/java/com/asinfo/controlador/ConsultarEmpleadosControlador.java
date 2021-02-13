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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Marco
 */
@Named(value = "consultarEmpleadosControlador")
@ViewScoped
public class ConsultarEmpleadosControlador implements Serializable {

    @EJB
    private SupervisorEmpleadoDao supervisorEmpleadoDao;
    @EJB
    private SupervisorDao supervisorDao;

    @Getter
    @Setter
    private int idSupervisor;

    @Getter
    @Setter
    private List<Supervisor> listSupervisor;
    @Getter
    @Setter
    private List<SupervisorEmpleado> listSupEmpleado;

    public ConsultarEmpleadosControlador() {
        listSupervisor = new ArrayList<>();
        listSupEmpleado = new ArrayList<>();
        idSupervisor = 0;
    }

    @PostConstruct
    public void iniciar() {
        listSupervisor = supervisorDao.listarTodoSupervisor();
        buscar();
    }

    public void buscar() {
        listSupEmpleado.clear();
        switch (idSupervisor) {
            case 0:
                listSupEmpleado = supervisorEmpleadoDao.listarTodo();
                break;
            default:
                listSupEmpleado = supervisorEmpleadoDao.listarPorSupervisor(idSupervisor);
                break;
        }
    }

}
