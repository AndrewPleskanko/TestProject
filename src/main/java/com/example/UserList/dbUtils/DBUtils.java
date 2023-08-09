package com.example.UserList.dbUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtils {
    public static Connection getConnect() {
        String dbUrl = null;
        String dbUsername = "";
        String dbPassword = "";
        FileInputStream fileInputStream;
        Properties properties = new Properties();
        try {
            Class.forName("org.postgresql.Driver");
            fileInputStream = new FileInputStream("C:\\Users\\legen\\Desktop\\demo3\\src\\main\\resources\\config.properties");
            properties.load(fileInputStream);
            dbUrl = properties.getProperty("db_host");
            dbUsername = properties.getProperty("db_username");
            dbPassword = properties.getProperty("db_password");

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }
}
