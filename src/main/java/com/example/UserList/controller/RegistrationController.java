package com.example.UserList.controller;


import com.example.UserList.service.DataGetAndSet;
import com.example.UserList.data.dao.UserDAO;
import com.example.UserList.service.ValidateService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/register")
public class RegistrationController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        DataGetAndSet dataGetAndSet = new DataGetAndSet();
        String[] data = dataGetAndSet.getAndSet(request);

        String firstName = data[0];
        String lastName = data[1];
        String login = data[2];
        String password = data[3];

        ValidateService validateService = new ValidateService();
        if (validateService.validateData(firstName, lastName, login, password, request)) {
            request.getRequestDispatcher("userRegister.jsp").forward(request, response);
            return;
        }
        UserDAO userDao = new UserDAO();
        userDao.create(firstName, lastName, login, password);
        request.getRequestDispatcher("logIn.jsp").forward(request, response);
    }

}
