package com.company.proemployee;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectionFactory {
    private static Connection connection = null;

    private ConnectionFactory() {

    }

    public static Connection getConnection() {
        if (connection == null) {
            ResourceBundle bundle = ResourceBundle.getBundle("com/company/proemployee/dbConfig");
            String url = bundle.getString("url");
            String username = bundle.getString("username");
            String password = bundle.getString("password");
            //System.out.println(password);
            try {

                connection = DriverManager.getConnection(url,username,password);
                System.out.println(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
 /*class Output{
    Connection obj1= ConnectionFactory.getConnection();
    Connection obj2=ConnectionFactory.getConnection();
    Connection obj3 = ConnectionFactory.getConnection();
    Connection obj4 =ConnectionFactory.getConnection();
 }*/