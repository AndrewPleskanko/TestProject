package com.example.UserList.dbUtils;

import com.example.UserList.dataDefinition.ErrorData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtils {
    private static final Logger logger = LogManager.getLogger(DBUtils.class.getName());

    public static Connection getConnect() {

        String dbUrl = null;
        String dbUsername = "";
        String dbPassword = "";
        FileInputStream fileInputStream;
        Properties properties = new Properties();
        try {
            Class.forName("org.postgresql.Driver");
            fileInputStream = new FileInputStream("C:\\Users\\legen\\Desktop\\UserList\\src\\main\\resources\\config.properties");
            properties.load(fileInputStream);
            dbUrl = properties.getProperty("db_host");
            dbUsername = properties.getProperty("db_username");
            dbPassword = properties.getProperty("db_password");

        } catch (IOException | ClassNotFoundException e) {
            logger.error(ErrorData.ERROR_LOADING_DATABASE_PROPERTIES, e);
        }

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        } catch (SQLException e) {
            logger.error(ErrorData.ERROR_CONNECTING_TO_DATABASE, e);
        }

        return connection;
    }
}
