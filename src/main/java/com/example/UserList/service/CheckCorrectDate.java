package com.example.UserList.service;

public class CheckCorrectDate implements ICheckCorrectDate{

    @Override
    public boolean isValidLogin(String email) {
        return email.endsWith("@gmail.com");
    }

    @Override
    public boolean isMoreThree(String name) {
        return name.length() > 2;
    }
}
