package com.example.UserList;

public interface QueryString {
    String getAllUsers = "SELECT * FROM users";
    String insertUser = "INSERT INTO users (first_name, last_name, login, password) VALUES (?, ?, ?, ?)";
    String searchLoginAndPassword = "SELECT COUNT(*) FROM users WHERE login = ? AND password = ?";
    String isEmailExist = "SELECT COUNT(*) AS user_count FROM users WHERE login = ?";
    String delete = "DELETE FROM users WHERE id = ";
    String getUser = "SELECT * FROM users WHERE id = ";
    String updateUser = "UPDATE users SET first_name = ?, last_name = ?, login = ?, password = ? WHERE id = ? ";
    String sortUser = "SELECT * FROM users ORDER BY ";
    String searchUser = "SELECT * FROM users WHERE first_name LIKE ? OR last_name LIKE ? OR login LIKE ?";
}
