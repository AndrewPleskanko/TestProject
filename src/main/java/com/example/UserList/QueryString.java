package com.example.UserList;

public interface QueryString {
    String getAllUser = "INSERT INTO users (first_name, last_name, login, password) VALUES (?, ?, ?, ?)";
    String searchLoginAndPassword = "SELECT COUNT(*) FROM users WHERE login = ? AND password = ?";
    String isEmailExist = "SELECT COUNT(*) AS user_count FROM users WHERE login = ?";
}
