package com.example.userList.data.dao;

import com.example.userList.data.entity.User;

import java.util.List;

public interface IUserDAO {
    List<User> getAllUser();

    List<User> sortUser(String sortColumn, String sortOrder);

    User getUser(int id);

    void create(String name, String surname, String login, String password);

    void delete(String id);

    void update(int userId, String firstName, String lastName, String login, String password);

    boolean isUserExist(String login, String password);

    boolean isEmailExist(String email);

    List<User> searchUser(String data);
}
