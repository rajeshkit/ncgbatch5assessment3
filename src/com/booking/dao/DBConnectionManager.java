package com.booking.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionManager {
    public static Connection establishConnection() {
        String database = "jdbc:mysql://127.0.0.1:3306/movieBooking";
        String username = "root";
        String password = "root@123";
        try {
            Connection conn = DriverManager.getConnection(database,username,password);
            return conn;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
