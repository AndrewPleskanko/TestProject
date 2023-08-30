package com.example.userList.dto;

import jakarta.servlet.http.HttpServletRequest;
import lombok.Data;

import static com.example.userList.dataDefinition.FieldName.*;

@Data
public class UserDto {
    private String firstName;
    private String lastName;
    private String login;
    private String password;

    public UserDto(HttpServletRequest request) {
        this.firstName = request.getParameter(FIRST_NAME);
        this.lastName = request.getParameter(LAST_NAME);
        this.login = request.getParameter(LOGIN);
        this.password = request.getParameter(PASSWORD);

        request.setAttribute(FIRST_NAME, firstName);
        request.setAttribute(LAST_NAME, lastName);
        request.setAttribute(LOGIN, login);
        request.setAttribute(PASSWORD, password);
    }
}
