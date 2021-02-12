/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asinfo.dao;

import com.asinfo.generico.Generico;
import com.asinfo.modelo.Supervisor;
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
public class SupervisorDao extends Generico<Supervisor> implements Serializable {

    public List<Supervisor> listarTodoSupervisor() {
        Query q;
        q = getEntityManager().createQuery("SELECT s FROM Supervisor s");
        return q.getResultList();
    }

}
