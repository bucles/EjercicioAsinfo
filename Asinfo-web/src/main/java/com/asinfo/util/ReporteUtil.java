/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asinfo.util;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.Map;
import javax.enterprise.context.Dependent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.sql.Connection;
import javax.annotation.PostConstruct;
import javax.naming.NamingException;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author Marco
 */
@Dependent
public class ReporteUtil implements Serializable {

    Connection connection;

    @PostConstruct
    public void iniciar() {

        //Usando patron Singleton para crear la conexion para Jasper        
        ConnectionJasper conJasper = ConnectionJasper.getInstance();
        connection = conJasper.getConnection();

    }

    public OutputStream generarReportePDF(String nombreArchivoJasper,
            Map<String, Object> params,
            String nombreArchivoPDF) throws JRException, IOException, NamingException, SQLException {
//        String dataSources = "java:/MySqlDS";
//        InitialContext initialContext = new InitialContext();
//        DataSource dataSource = (DataSource) initialContext.lookup(dataSources);

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
    }

}
