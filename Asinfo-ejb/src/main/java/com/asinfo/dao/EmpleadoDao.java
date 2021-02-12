/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asinfo.dao;

import com.asinfo.generico.Generico;
import com.asinfo.modelo.Empleado;
import java.io.Serializable;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author Marco
 */
@LocalBean
@Stateless
public class EmpleadoDao extends Generico<Empleado> implements Serializable {

}
