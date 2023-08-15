package com.example.UserList.controller;


import com.example.UserList.data.UserDAO;
import com.example.UserList.service.Validate;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/register")
public class Registration extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        request.setAttribute("firstName", firstName);
        request.setAttribute("lastName", lastName);
        request.setAttribute("login", login);
        request.setAttribute("password", password);
        Validate validate = new Validate();
        if(validate.validateData(firstName, lastName, login, password, request, response)){
            request.getRequestDispatcher("userRegister.jsp").forward(request, response);
        }
        UserDAO userDao = new UserDAO();
        userDao.create(firstName, lastName, login, password);
        request.getRequestDispatcher("logIn.jsp").forward(request, response);
    }

}
