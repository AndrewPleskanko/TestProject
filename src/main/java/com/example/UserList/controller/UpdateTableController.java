package com.example.UserList.controller;


import com.example.UserList.dataDefinition.FieldName;
import com.example.UserList.service.DataGetAndSet;
import com.example.UserList.data.dao.UserDAO;
import com.example.UserList.data.entity.User;
import com.example.UserList.service.ValidateService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/update")
public class UpdateTableController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userId = Integer.parseInt(req.getParameter(FieldName.USER_ID));
        DataGetAndSet dataGetAndSet = new DataGetAndSet();
        String[] data = dataGetAndSet.getAndSet(req);

        String firstName = data[0];
        String lastName = data[1];
        String login = data[2];
        String password = data[3];

        ArrayList<User> user = new ArrayList<>();
        user.add(0, new User(userId, firstName, lastName, login, password));
        req.setAttribute(FieldName.USER_LIST, user);
        ValidateService validateService = new ValidateService();
        if (validateService.validateData(firstName, lastName, login, password, req)) {
            req.getRequestDispatcher("/update").forward(req, resp);
        }
        UserDAO userDao = new UserDAO();
        userDao.update(userId, firstName, lastName, login, password);
        req.getRequestDispatcher("/usersList").forward(req, resp);

    }

}
