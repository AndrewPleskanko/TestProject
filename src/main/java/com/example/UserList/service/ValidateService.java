package com.example.UserList.service;

import com.example.UserList.dataDefinition.ErrorData;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class ValidateService {

    CheckCorrectDateServiceService checkCorrectDateService = new CheckCorrectDateServiceService();
    boolean isError = false;

    public boolean validateData(String firstName, String lastName, String login, String password, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (!checkCorrectDateService.isMoreThree(firstName)) {
            request.setAttribute("errorName", ErrorData.ERROR_FIRST_NAME_DESCRIPTION);
            isError = true;
        }
        if (!checkCorrectDateService.isMoreThree(lastName)) {
            request.setAttribute("errorSurname",  ErrorData.ERROR_LAST_NAME_DESCRIPTION);
            isError = true;
        }

        if (!checkCorrectDateService.isValidLogin(login)) {
            request.setAttribute("errorLogin", ErrorData.ERROR_LOGIN_DESCRIPTION);
            isError = true;
        }

        if (!checkCorrectDateService.isMoreThree(password)) {
            request.setAttribute("errorPassword", ErrorData.ERROR_PASSWORD_DESCRIPTION);
            isError = true;
        }
        return isError;
    }

}
