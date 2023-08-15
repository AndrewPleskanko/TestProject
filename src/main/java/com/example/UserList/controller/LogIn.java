package com.example.UserList.controller;

import com.example.UserList.data.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/logIn")
public class LogIn extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        UserDAO userDao = new UserDAO();
        userDao.isUserExist(login, password);

        if (!userDao.isUserExist(login, password)) {
            req.setAttribute("errorLoginOrPassword", "Incorrect login or password");
            req.getRequestDispatcher("logIn.jsp").forward(req, resp);
        }
        HttpSession session = req.getSession();
        session.setAttribute("login", login);
        req.getRequestDispatcher("/fil/usersList").forward(req, resp);
    }
}
