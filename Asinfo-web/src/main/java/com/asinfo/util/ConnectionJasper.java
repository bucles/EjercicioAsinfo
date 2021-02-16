/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asinfo.util;

import java.sql.Connection;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 *
 * @author Marco
 */
public class ConnectionJasper {

    private static ConnectionJasper instance = null;
    private Connection connection;
    String dataSources = "java:/MySqlDS";

    public ConnectionJasper() {
        try {
            InitialContext initialContext = new InitialContext();
            DataSource dataSource = (DataSource) initialContext.lookup(dataSources);
            connection = dataSource.getConnection();
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }

    //Patron Singleton
    public static ConnectionJasper getInstance() {
        if (instance == null) {
            instance = new ConnectionJasper();
            System.out.println("Creada nueva instancia de conexion para Jasper");
        } else {
            System.out.println("Ya existe instancia de conexion para Jasper");
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

}
