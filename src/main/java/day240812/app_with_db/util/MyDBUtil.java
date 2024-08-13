package day240812.app_with_db.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MyDBUtil {
    private static Connection connection;

    public synchronized static Connection getConnection() {
        if (connection != null) {
            return connection;
        }

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo01", "root", "123456");
            System.out.println("Connected to database");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}

