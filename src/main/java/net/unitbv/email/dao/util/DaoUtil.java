package net.unitbv.email.dao.util;

import java.sql.Connection;
import java.sql.DriverManager;


public class DaoUtil {
    public static Connection getConnection() {
        String dbUrl = "jdbc:mysql://localhost/sidmail";
        String dbClass = "com.mysql.jdbc.Driver";
        String username = "root";
        String password = "root";

        try {
            Class.forName(dbClass);
            Connection connection = DriverManager.getConnection(dbUrl, username, password);
            return connection;
        } catch (Exception e) {
            throw new RuntimeException("Couldn't connect to database.", e);
        }
    }
}
