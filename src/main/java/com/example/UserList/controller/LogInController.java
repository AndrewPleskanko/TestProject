package com.example.UserList.controller;

import com.example.UserList.data.dao.UserDAO;
import com.example.UserList.dataDefinition.FieldName;
import com.example.UserList.dataDefinition.ErrorData;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Objects;

@WebServlet("/logIn")
public class LogInController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter(FieldName.LOGIN);
        String password = req.getParameter(FieldName.PASSWORD);


        if(Objects.equals(req.getParameter("logIN"), "logIN")){
            req.getRequestDispatcher("logIn.jsp").forward(req, resp);
        }
        UserDAO userDao = new UserDAO();
        if (!userDao.isUserExist(login, password)) {
            req.setAttribute(FieldName.ERROR_LOGIN_OR_PASSWORD, ErrorData.ERROR_LOGIN_OR_PASS);
            req.getRequestDispatcher("logIn.jsp").forward(req, resp);
        }
        HttpSession session = req.getSession();
        session.setAttribute(FieldName.LOGIN, login);

        req.getRequestDispatcher("/usersList").forward(req, resp);
    }
}
