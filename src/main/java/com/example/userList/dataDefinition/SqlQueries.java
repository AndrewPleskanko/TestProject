package com.example.userList.dataDefinition;

public interface SqlQueries {
    String GET_ALL_USERS = "SELECT * FROM users";
    String INSERT_USER = "INSERT INTO users (first_name, last_name, login, password) VALUES (?, ?, ?, ?)";
    String SEARCH_LOGIN_AND_PASSWORD = "SELECT COUNT(*) FROM users WHERE login = ? AND password = ?";
    String IS_EMAIL_EXIST = "SELECT COUNT(*) AS user_count FROM users WHERE login = ?";
    String DELETE = "DELETE FROM users WHERE id = ";
    String GET_USER = "SELECT * FROM users WHERE id = ";
    String UPDATE_USER = "UPDATE users SET first_name = ?, last_name = ?, login = ?, password = ? WHERE id = ? ";
    String SORT_USER = "SELECT * FROM users ORDER BY ";
    String SEARCH_USER = "SELECT * FROM users WHERE first_name LIKE ? OR last_name LIKE ? OR login LIKE ?";
}


