package com.example.UserList.service;

import com.example.UserList.dataDefinition.FieldName;
import jakarta.servlet.http.HttpServletRequest;

public class DataGetAndSet {
    public String[] getAndSet(HttpServletRequest req) {
        String firstName = req.getParameter(FieldName.FIRST_NAME);
        String lastName = req.getParameter(FieldName.LAST_NAME);
        String login = req.getParameter(FieldName.LOGIN);
        String password = req.getParameter(FieldName.PASSWORD);

        req.setAttribute(FieldName.FIRST_NAME, firstName);
        req.setAttribute(FieldName.LAST_NAME, lastName);
        req.setAttribute(FieldName.LOGIN, login);
        req.setAttribute(FieldName.PASSWORD, password);
        return new String[]{firstName, lastName, login, password};

    }

}
