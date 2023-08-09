package com.example.UserList.data;

import com.example.UserList.dbUtils.DBUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    public static List<User> read(String query) {
        List<User> users = new ArrayList<>();
        try (Connection connection = DBUtils.getConnect()) {
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(query)) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String first_name = resultSet.getString("first_name");
                    String last_name = resultSet.getString("last_name");
                    String login = resultSet.getString("login");
                    String password = resultSet.getString("password");

                    users.add(new User(id, first_name, last_name, login, password));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public static void create(String name, String surname, String login, String password) {
        try (Connection connection = DBUtils.getConnect()) {
            String sql = "INSERT INTO users (first_name, last_name, login, password) VALUES (?, ?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, surname);
            statement.setString(3, login);
            statement.setString(4, password);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void update(String queryOp, String firstName, String lastName, String login, String password, int userId) {
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

    public static void delete(String queryOp) {
        try (Connection connection = DBUtils.getConnect();
             PreparedStatement statement = connection.prepareStatement(queryOp)) {

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

