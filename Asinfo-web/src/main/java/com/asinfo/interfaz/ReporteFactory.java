/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asinfo.interfaz;

/**
 *
 * @author Marco
 */
public class ReporteFactory {

    public IReporte crearReporte(String tipo) {
        if (tipo == null || tipo.isEmpty()) {
            return null;
        }
        if ("AllSupervisor".equals(tipo)) {
            return new ReporteTodosSupervisor();
        } else if ("BySupervisor".equals(tipo)) {
            return new ReportePorSupervisor();
        }
        return null;
    }

}
