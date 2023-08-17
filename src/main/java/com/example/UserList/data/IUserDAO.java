package com.example.UserList.data;

import java.util.List;

public interface IUserDAO {
    List<User> read(String query);

    void create(String name, String surname, String login, String password);

    void delete(String queryOp);

    void update(String queryOp, String firstName, String lastName, String login, String password, int userId);

    boolean isUserExist(String login, String password);

    boolean isEmailExist(String email);
}
