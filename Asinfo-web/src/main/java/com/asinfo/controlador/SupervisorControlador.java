/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asinfo.controlador;

import com.asinfo.dao.SupervisorDao;
import com.asinfo.modelo.Supervisor;
import java.io.Serializable;
import java.util.ArrayList;
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
@Named(value = "supervisorControlador")
@ViewScoped
public class SupervisorControlador implements Serializable {

    @EJB
    private SupervisorDao supervisorDao;

    @Getter
    @Setter
    private Supervisor supervisor;

    @Getter
    @Setter
    private List<Supervisor> listSupervisor;

    public SupervisorControlador() {
        supervisor = new Supervisor();
        listSupervisor = new ArrayList<>();
    }

    @PostConstruct
    public void iniciar() {
        listSupervisor = supervisorDao.listarTodoSupervisor();
    }

    public void crearSupervisor() {
        FacesContext context = FacesContext.getCurrentInstance();
        supervisorDao.create(supervisor);
        context.addMessage(null, new FacesMessage("éxito", "Supervisor creado"));
        listSupervisor = supervisorDao.listarTodoSupervisor();
//        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "No se pudo crear", null);
//        context.addMessage(null, message);
    }

    public void prepararSupervisor() {
        supervisor = new Supervisor();
    }
}
