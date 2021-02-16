/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asinfo.interfaz;

import com.asinfo.util.ConnectionJasper;
import java.io.File;
import java.io.OutputStream;
import java.sql.Connection;
import java.util.Map;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author Marco
 */
public class ReporteTodosSupervisor implements IReporte {

    Connection connection;

    @Override
    public OutputStream generarReportePDF(String nombreArchivoJasper,
            Map<String, Object> params,
            String nombreArchivoPDF) {
        try {
            //Usando patron Singleton para crear la conexion para Jasper        
            ConnectionJasper conJasper = ConnectionJasper.getInstance();
            connection = conJasper.getConnection();

            //Generando PDF
            String jasperPath = "/reportes/" + nombreArchivoJasper + ".jasper";
            FacesContext fc = FacesContext.getCurrentInstance();
            ExternalContext ec = fc.getCurrentInstance().getExternalContext();
            String extension = "pdf";
            String contentType = "application/pdf";
            String relativeWebPath = ec.getRealPath(jasperPath);
            File file = new File(relativeWebPath);
            JasperPrint print = JasperFillManager.fillReport(file.getPath(), params, connection);
            OutputStream output = ec.getResponseOutputStream();
            ec.responseReset();
            ec.setResponseContentType(contentType);
            ec.setResponseContentLength(JasperExportManager.exportReportToPdf(print).length);
            ec.setResponseHeader("Content-Disposition", "attachment; filename=\"" + nombreArchivoPDF + "." + extension + "\"");
            JasperExportManager.exportReportToPdfStream(print, output);

            fc.responseComplete();
            return output;
        } catch (Exception e) {
            return null;
        }
    }

}
