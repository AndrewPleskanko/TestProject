package com.example.userList.service;

import com.example.userList.data.dao.UserDAO;
import jakarta.servlet.http.HttpServletRequest;

import static com.example.userList.dataDefinition.ErrorData.*;

public class ValidateService implements ICheckCorrectDateService {
    boolean isError = false;

    public boolean validateData(String firstName, String lastName, String login, String password, HttpServletRequest request) {

        if (!isMoreThree(firstName)) {
            request.setAttribute(ERROR_NAME, ERROR_FIRST_NAME_DESCRIPTION);
            isError = true;
        }
        if (!isMoreThree(lastName)) {
            request.setAttribute(ERROR_SURNAME, ERROR_LAST_NAME_DESCRIPTION);
            isError = true;
        }

        if (!isValidLogin(login)) {
            request.setAttribute(ERROR_LOGIN, ERROR_LOGIN_DESCRIPTION);
            isError = true;
        }

        if (!isMoreThree(password)) {
            request.setAttribute(ERROR_PASSWORD, ERROR_PASSWORD_DESCRIPTION);
            isError = true;
        }
        return isError;
    }

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
