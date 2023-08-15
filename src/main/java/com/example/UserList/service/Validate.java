package com.example.UserList.service;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class Validate {

    CheckCorrectDate checkCorrectDate = new CheckCorrectDate();
    boolean isError = false;

    public boolean validateData(String firstName, String lastName, String login, String password, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (!checkCorrectDate.isMoreThree(firstName)) {
            request.setAttribute("errorName", "Invalid firstName format. Name must be at least 3 characters long");
            isError = true;
        }
        if (!checkCorrectDate.isMoreThree(lastName)) {
            request.setAttribute("errorSurname", "Invalid lastName format. Surname must be at least 3 characters long");
            isError = true;
        }
        if (!checkCorrectDate.isValidLogin(login)) {
            request.setAttribute("errorLogin", "Please enter a valid Gmail address!");
            isError = true;
        }
        if (!checkCorrectDate.isMoreThree(password)) {
            request.setAttribute("errorPassword", "Invalid login format. Password must be at least 3 characters long");
            isError = true;
        }
        return isError;
    }

}
