package com.example.UserList.data.dao;

import com.example.UserList.data.entity.User;
import com.example.UserList.dataDefinition.ErrorData;
import com.example.UserList.dataDefinition.InfoData;
import com.example.UserList.dataDefinition.SqlQueries;
import com.example.UserList.dbUtils.DBUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IUserDAO {
    private static final Logger logger = LogManager.getLogger(UserDAO.class.getName());

    private final Connection connection = DBUtils.getConnect();

    @Override
    public List<User> getAllUser() {
        String query = SqlQueries.GET_ALL_USERS;
        logger.info(InfoData.GETTING_ALL_USERS);
        return executeUserQuery(query, null);
    }

    @Override
    public List<User> sortUser(String sortColumn, String sortOrder) {
        String query = SqlQueries.SORT_USER + sortColumn + " " + sortOrder;
        logger.info(InfoData.LOG_SORTING_USERS, sortColumn, sortOrder);
        return executeUserQuery(query, null);
    }

    @Override
    public User getUser(int id) {
        String query = SqlQueries.GET_USER + id;
        List<User> users = executeUserQuery(query, null);
        logger.info(InfoData.LOG_GETTING_USER, id);
        return users.isEmpty() ? null : users.get(0);
    }

    @Override
    public void create(String name, String surname, String login, String password) {
        String query = SqlQueries.INSERT_USER;
        logger.info(InfoData.LOG_CREATING_USER, name, surname, login);
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, name);
            statement.setString(2, surname);
            statement.setString(3, login);
            statement.setString(4, password);
            statement.executeUpdate();
            logger.info(InfoData.LOG_USER_CREATED_SUCCESSFULLY);
        } catch (SQLException e) {
            logger.error(ErrorData.LOG_ERROR_CREATING_USER, e);
        }
    }

    @Override
    public void delete(String id) {
        String query = SqlQueries.DELETE;
        logger.info(InfoData.LOG_DELETING_USER, id);
        try (PreparedStatement statement = connection.prepareStatement(query + id)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error(ErrorData.LOG_ERROR_DELETING_USER, e);
        }
    }

    @Override
    public void update(int userId, String firstName, String lastName, String login, String password) {
        String query = SqlQueries.UPDATE_USER;
        logger.info(InfoData.LOG_UPDATING_USER, userId);
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, login);
            statement.setString(4, password);
            statement.setInt(5, userId);
            statement.executeUpdate();
            logger.info(InfoData.LOG_USER_UPDATED_SUCCESSFULLY);
        } catch (SQLException e) {
            logger.error(ErrorData.LOG_ERROR_UPDATING_USER, e);
        }
    }

    @Override
    public boolean isUserExist(String login, String password) {
        String query = SqlQueries.SEARCH_LOGIN_AND_PASSWORD;

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, login);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            logger.error(ErrorData.LOG_ERROR_CHECKING_USER_EXISTENCE, e);
        }
        return false;
    }

    @Override
    public boolean isEmailExist(String email) {
        logger.info(InfoData.LOG_CHECKING_USER_EMAIL_EXISTENCE, email);
        String query = SqlQueries.IS_EMAIL_EXIST;
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int userCount = resultSet.getInt("user_count");
                return userCount >= 1;
            }
        } catch (SQLException e) {
            logger.error(ErrorData.LOG_ERROR_CHECKING_EMAIL_EXISTENCE, e);
        }
        return false;
    }

    @Override
    public List<User> searchUser(String data) {
        String query = SqlQueries.SEARCH_USER;
        logger.info(InfoData.LOG_SEARCHING_USERS, data);
        return executeUserQuery(query, data);
    }

    private List<User> executeUserQuery(String query, String data) {
        List<User> users = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            if (data != null) {
                for (int i = 0; i < 3; i++) {
                    statement.setString(i + 1, "%" + data + "%");
                }
            }
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String first_name = resultSet.getString("first_name");
                String last_name = resultSet.getString("last_name");
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");
                users.add(new User(id, first_name, last_name, login, password));
            }
        } catch (SQLException e) {
            logger.error(ErrorData.LOG_ERROR_CREATING_USER, e);
        }
        return users;
    }
}
