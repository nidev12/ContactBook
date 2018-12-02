/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.contactbook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 *
 * @author NITESH
 */

public class DBConnection {

    public Connection getDBConnection() {
        Connection con = null;
        try {
            //DB connection
            String driverName = "com.mysql.jdbc.Driver";
            String dbName = "contactDB";
            String userName = "root";
            String password = "AAVeqv30908";
            String url = "jdbc:mysql://node41435-env-9350929.cloud.cms500.com/contactDB?verifyServerCertificate=false&&useSSL=false";
            Class.forName(driverName);
            con = DriverManager.getConnection(url, userName, password);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }

}
