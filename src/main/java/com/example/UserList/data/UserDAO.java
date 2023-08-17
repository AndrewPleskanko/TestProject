package com.example.UserList.data;

import com.example.UserList.QueryString;
import com.example.UserList.dbUtils.DBUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IUserDAO {
    @Override
    public List<User> read(String query) {
        List<User> users = new ArrayList<>();
        try (Connection connection = DBUtils.getConnect();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String first_name = resultSet.getString("first_name");
                String last_name = resultSet.getString("last_name");
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");

                users.add(new User(id, first_name, last_name, login, password));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public void create(String name, String surname, String login, String password) {
        try (Connection connection = DBUtils.getConnect()) {
            String query = QueryString.getAllUser;

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, name);
            statement.setString(2, surname);
            statement.setString(3, login);
            statement.setString(4, password);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String queryOp) {
        try (Connection connection = DBUtils.getConnect();
             PreparedStatement statement = connection.prepareStatement(queryOp)) {

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void update(String queryOp, String firstName, String lastName, String login, String password, int userId) {
        try (Connection connection = DBUtils.getConnect();
             PreparedStatement statement = connection.prepareStatement(queryOp)) {
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, login);
            statement.setString(4, password);
            statement.setInt(5, userId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean isUserExist(String login, String password) {
        String query = QueryString.searchLoginAndPassword;
        boolean userExists = false;

        try (Connection connection = DBUtils.getConnect();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, login);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                userExists = count > 0;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userExists;

    }

    @Override
    public boolean isEmailExist(String email) {
        boolean userExists = false;
        String query = QueryString.isEmailExist;

        try (Connection connection = DBUtils.getConnect();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, email); // Встановити значення параметру

            ResultSet resultSet = statement.executeQuery();

            int userCount = 0;
            if (resultSet.next()) {
                userCount = resultSet.getInt("user_count");

                if (userCount >= 1) {
                    userExists = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userExists;
    }

}

