package com.kodilla.jdbc;

import java.sql.*;
import java.util.Properties;

public class DbManager {
    private Connection conn;
    private static DbManager dbManagerInstance;

    private DbManager() throws SQLException {
        Properties connectionProps = new Properties();
        connectionProps.put("user", "kodilla_user");
        connectionProps.put("password", "kodilla_pass");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kodilla_course" +
                                           "?serverTimezone=Europe/Warsaw&useSSL=False",
                                           connectionProps);
    }

    public static DbManager getInstance() throws SQLException {
        if (dbManagerInstance == null) {
            synchronized(DbManager.class) {
                if (dbManagerInstance == null) {
                    dbManagerInstance = new DbManager();
                }
            }
        }
        return dbManagerInstance;
    }

    public Connection getConnection() {
        return conn;
    }
}