package org.example.session01.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    private static final String URL = "jdbc:mariadb://localhost:3306/login";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    private Connection connection;

    public ConnectDB() throws SQLException {
        connection = DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public Connection getConnection() {
        return connection;
    }
}
