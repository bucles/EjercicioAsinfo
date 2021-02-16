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
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Marco
 */
@Named(value = "empleadoControlador")
@ViewScoped
public class EmpleadoControlador implements Serializable {

    @EJB
    private SupervisorDao supervisorDao;
    @EJB
    private EmpleadoDao empleadoDao;
    @EJB
    private DepartamentoDao departamentoDao;
    @EJB
    private SupervisorEmpleadoDao supervisorEmpleadoDao;

    @Getter
    @Setter
    private Supervisor supervisor;
    @Getter
    @Setter
    private Empleado empleado;
    @Getter
    @Setter
    private int idDepartamento;

    @Getter
    @Setter
    private List<Supervisor> listSupervisor;
    @Getter
    @Setter
    private List<Empleado> listEmpleado;
    @Getter
    @Setter
    private List<Departamento> listDepartamento;

    public EmpleadoControlador() {
        supervisor = new Supervisor();
        empleado = new Empleado();
        listSupervisor = new ArrayList<>();
        listEmpleado = new ArrayList<>();
        listDepartamento = new ArrayList<>();
    }

    @PostConstruct
    public void iniciar() {
        obtenerEmpleados();
        listSupervisor = supervisorDao.listarTodoSupervisor();
        listDepartamento = departamentoDao.listarTodoDepartamento();
    }

    public void crearEmpleado() {
        FacesContext context = FacesContext.getCurrentInstance();
        Departamento dep = departamentoDao.find(new Departamento(), idDepartamento);
        supervisor = supervisorDao.find(new Supervisor(), supervisor.getSupId());
        empleado.setDepId(dep);
        empleado.setEmpFHR(Calendar.getInstance().getTime());
        empleadoDao.create(empleado);
        crearSupervisorEmpleado();
        context.addMessage(null, new FacesMessage("éxito", "Empleado creado"));
        obtenerEmpleados();
//        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "No se pudo crear", null);
//        context.addMessage(null, message);
    }

    public void crearSupervisorEmpleado() {
        SupervisorEmpleado supEmp = new SupervisorEmpleado();
        supEmp.setEmpId(empleado);
        supEmp.setSupId(supervisor);
        supEmp.setSemFHR(Calendar.getInstance().getTime());
        supervisorEmpleadoDao.create(supEmp);
    }

    public void prepararEmpleado() {
        empleado = new Empleado();
    }

    public String obtenerNombreSupervisor(int idEmpleado) {
        SupervisorEmpleado superVE = supervisorEmpleadoDao.obtenerSupervisorPorEmpleado(idEmpleado);
        String nombreSupervisor = "";
        if (superVE != null) {
            nombreSupervisor = superVE.getSupId().getSupNombre().trim()
                    + superVE.getSupId().getSupApellido().trim();
        }
        return nombreSupervisor;
    }

    public void obtenerEmpleados() {
        listEmpleado.clear();
        listEmpleado = empleadoDao.listarTodoEmpleado();
    }

    public void editarEmpleado() {
        FacesContext context = FacesContext.getCurrentInstance();
        empleadoDao.edit(empleado);
        context.addMessage(null, new FacesMessage("éxito", "Sueldo editado"));
        obtenerEmpleados();
    }

}
