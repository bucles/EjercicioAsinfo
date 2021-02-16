/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asinfo.interfaz;

import java.io.OutputStream;
import java.util.Map;

/**
 *
 * @author Marco
 */
public interface IReporte {

    OutputStream generarReportePDF(String nombreArchivoJasper,
            Map<String, Object> params,
            String nombreArchivoPDF);

}
