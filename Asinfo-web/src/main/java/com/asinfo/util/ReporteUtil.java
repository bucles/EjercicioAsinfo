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
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
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

    public void imprimirReporteEnPDF(String nombreArchivoJasper, String nombreArchivoPDF, Map<String, Object> parametros) throws JRException, IOException, NamingException, SQLException {

        String dataSources = "java:/MySqlDS";

        String jasperPath = "/reportes/" + nombreArchivoJasper + ".jasper";
        InitialContext initialContext = new InitialContext();
        DataSource dataSource = (DataSource) initialContext.lookup(dataSources);
        Connection connection = dataSource.getConnection();
        this.generarReporteEnPDF(parametros, jasperPath, nombreArchivoPDF, connection);
    }

    public OutputStream generarReporteEnPDF(Map<String, Object> params, String jasperPath, String nombreArchivoPDF, Connection connection) throws JRException, IOException, NamingException, SQLException {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getCurrentInstance().getExternalContext();
        String extension = "pdf";
        String contentType = "application/pdf";
        String relativeWebPath = ec.getRealPath(jasperPath);
        File file = new File(relativeWebPath);
        JasperPrint print = JasperFillManager.fillReport(file.getPath(), params, connection);
        OutputStream output = ec.getResponseOutputStream();
        ec.responseReset(); // Some JSF component library or some Filter might have set some headers in the buffer beforehand. We want to get rid of them, else it may collide.
        ec.setResponseContentType(contentType); 
        ec.setResponseContentLength(JasperExportManager.exportReportToPdf(print).length); // Set it with the file size. This header is optional. It will work if it's omitted, but the download progress will be unknown.
        ec.setResponseHeader("Content-Disposition", "attachment; filename=\"" + nombreArchivoPDF + "." + extension + "\""); // The Save As popup magic is done here. You can give it any file name you want, this only won't work in MSIE, it will use current request URL as file name instead.
        JasperExportManager.exportReportToPdfStream(print, output);

        fc.responseComplete();
        return output;
    }

}
