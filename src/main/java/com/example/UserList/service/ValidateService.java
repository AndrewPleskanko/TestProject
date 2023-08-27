package com.example.UserList.service;

import com.example.UserList.dataDefinition.ErrorData;
import jakarta.servlet.http.HttpServletRequest;

public class ValidateService {

    CheckCorrectDateServiceService checkCorrectDateService = new CheckCorrectDateServiceService();
    boolean isError = false;

    public boolean validateData(String firstName, String lastName, String login, String password, HttpServletRequest request) {

        if (!checkCorrectDateService.isMoreThree(firstName)) {
            request.setAttribute(ErrorData.ERROR_NAME, ErrorData.ERROR_FIRST_NAME_DESCRIPTION);
            isError = true;
        }
        if (!checkCorrectDateService.isMoreThree(lastName)) {
            request.setAttribute(ErrorData.ERROR_SURNAME, ErrorData.ERROR_LAST_NAME_DESCRIPTION);
            isError = true;
        }

        if (!checkCorrectDateService.isValidLogin(login)) {
            request.setAttribute(ErrorData.ERROR_LOGIN, ErrorData.ERROR_LOGIN_DESCRIPTION);
            isError = true;
        }

        if (!checkCorrectDateService.isMoreThree(password)) {
            request.setAttribute(ErrorData.ERROR_PASSWORD, ErrorData.ERROR_PASSWORD_DESCRIPTION);
            isError = true;
        }
        return isError;
    }

}
