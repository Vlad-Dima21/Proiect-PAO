package com.proiect.services.io;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionManager {
    private static ConnectionManager INSTANCE = null;
    private final String url = "jdbc:mysql://localhost:3306/proiectpao";
    private final String user = "root";
    private final String pass = "parola123";
    private Connection connection;

    public static ConnectionManager getInstance() throws SQLException, ClassNotFoundException {
        if (INSTANCE == null) {
            INSTANCE = new ConnectionManager();
        }
        return INSTANCE;
    }

    private ConnectionManager() throws ClassNotFoundException, SQLException {
//        Class.forName("com.mysql.jdbc.Driver");
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(url, user, pass);
    }

    public void close() throws SQLException {
        connection.close();
    }

    public PreparedStatement prepareStatement(String statement) throws SQLException {
        if (connection.isClosed()) {
            connection = DriverManager.getConnection(url, user, pass);
        }
        return connection.prepareStatement(statement);
    }
}
