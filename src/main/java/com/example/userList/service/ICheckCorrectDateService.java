package com.example.userList.service;

public interface ICheckCorrectDateService {
    boolean isValidLogin(String email);

    boolean isMoreThree(String name);

    boolean isEmailExist(String email);
}
