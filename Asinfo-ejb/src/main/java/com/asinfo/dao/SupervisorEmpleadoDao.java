/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asinfo.dao;

import com.asinfo.generico.Generico;
import com.asinfo.modelo.SupervisorEmpleado;
import java.io.Serializable;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Marco
 */
@LocalBean
@Stateless
public class SupervisorEmpleadoDao extends Generico<SupervisorEmpleado> implements Serializable {

    public SupervisorEmpleado obtenerSupervisorPorEmpleado(int idEmpleado) {
        Query q;
        q = getEntityManager().createQuery("SELECT s FROM SupervisorEmpleado s"
                + " WHERE s.empId.empId =:idEmpleado");
        q.setParameter("idEmpleado", idEmpleado);
        q.setMaxResults(1);
        try {
            return (SupervisorEmpleado) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }

    }

    public List<SupervisorEmpleado> listarPorSupervisor(int idSupervisor) {
        Query q;
        q = getEntityManager().createQuery("SELECT s FROM SupervisorEmpleado s"
                + " WHERE s.supId.supId =:idSupervisor");
        q.setParameter("idSupervisor", idSupervisor);

        try {
            return q.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    public List<SupervisorEmpleado> listarTodo() {
        Query q;
        q = getEntityManager().createQuery("SELECT s FROM SupervisorEmpleado s");
        try {
            return q.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

}
