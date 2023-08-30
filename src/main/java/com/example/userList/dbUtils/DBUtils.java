package com.example.userList.dbUtils;

import com.example.userList.exception.NoConnectionException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import static com.example.userList.dataDefinition.ErrorData.*;

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
            logger.error(ERROR_LOADING_DATABASE_PROPERTIES, e);
        }

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            if (connection == null) {
                throw new NoConnectionException(ERROR_CONNECTION_DATABASE);
            }
        } catch (SQLException e) {
            logger.error(ERROR_CONNECTING_TO_DATABASE, e);
        } catch (NoConnectionException e) {
            logger.error(ERROR_CONNECTION_DATABASE, e);
        }

        return connection;
    }
}
