package com.example.UserList.controller;


import com.example.UserList.data.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/register")
public class Registration extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if (!isMoreThree(firstName)) {
            request.setAttribute("errorName", "Invalid login format. Name must be at least 3 characters long");
            request.getRequestDispatcher("userRegister.jsp").forward(request, response);
            return;
        }
        if (!isMoreThree(lastName)) {
            request.setAttribute("errorSurname", "Invalid login format. Surname must be at least 3 characters long");
            request.getRequestDispatcher("userRegister.jsp").forward(request, response);
            return;
        }
        if (!isValidLogin(login)) {
            request.setAttribute("errorLogin", "Please enter a valid Gmail address!");
            request.getRequestDispatcher("userRegister.jsp").forward(request, response);
            return;
        }
        if (!isMoreThree(password)) {
            request.setAttribute("errorPassword", "Invalid login format. Password must be at least 3 characters long");
            request.getRequestDispatcher("userRegister.jsp").forward(request, response);
            return;
        }

        UserDAO.create(firstName, lastName, login, password);
        request.getRequestDispatcher("logIn.jsp");
    }

    private boolean isValidLogin(String email) {
        return email.toLowerCase().endsWith("@gmail.com");
    }

    private boolean isMoreThree(String name) {
        return name.length() > 2;
    }
}
