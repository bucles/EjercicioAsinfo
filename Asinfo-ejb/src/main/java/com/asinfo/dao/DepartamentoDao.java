/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asinfo.dao;

import com.asinfo.generico.Generico;
import com.asinfo.modelo.Departamento;
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
public class DepartamentoDao extends Generico<Departamento> implements Serializable {

    public List<Departamento> listarTodoDepartamento() {
        Query q;
        q = getEntityManager().createQuery("SELECT d FROM Departamento d");
        return q.getResultList();
    }
}
