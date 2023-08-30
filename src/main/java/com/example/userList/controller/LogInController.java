package com.example.userList.controller;

import com.example.userList.data.dao.UserDAO;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import static com.example.userList.dataDefinition.ErrorData.ERROR_LOGIN_OR_PASS;
import static com.example.userList.dataDefinition.FieldName.*;

@WebServlet("/logIn")
public class LogInController extends HttpServlet {
    private UserDAO userDao;

    @Override
    public void init(ServletConfig config) {
        userDao = new UserDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter(LOGIN);
        String password = req.getParameter(PASSWORD);

        if (LOGIN_BUTTON.equals(req.getParameter(LOGIN_BUTTON))) {
            req.getRequestDispatcher("logIn.jsp").forward(req, resp);
        }

        if (!userDao.isUserExist(login, password)) {
            req.setAttribute(ERROR_LOGIN_OR_PASSWORD, ERROR_LOGIN_OR_PASS);
            req.getRequestDispatcher("logIn.jsp").forward(req, resp);
        }
        HttpSession session = req.getSession();
        session.setAttribute(LOGIN, login);

        req.getRequestDispatcher("/usersList").forward(req, resp);
    }
}
