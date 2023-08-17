package com.example.UserList.service;

import com.example.UserList.data.UserDAO;

public class CheckCorrectDate implements ICheckCorrectDate {

    @Override
    public boolean isValidLogin(String email) {
        return email.endsWith("@gmail.com");
    }

    @Override
    public boolean isMoreThree(String name) {
        return name.length() > 2;
    }

    @Override
    public boolean isEmailExist(String email) {
        UserDAO userDao = new UserDAO();
        return userDao.isEmailExist(email);
    }
}
