package com.example.UserList.controller;

import com.example.UserList.QueryString;
import com.example.UserList.view.NavigationButton;
import com.example.UserList.data.UserDAO;
import com.example.UserList.data.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet("/usersList")
public class UsersList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserDAO userDao = new UserDAO();
        String getAllUsers = QueryString.getAllUsers;
        List<User> userList = userDao.getAllUser(getAllUsers);
        NavigationButton navigationButton = new NavigationButton();
        navigationButton.buttonLogic(userList, req, resp);
        req.getRequestDispatcher("usersList.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String sortColumn = req.getParameter("sortColumn");
        String sortOrder = req.getParameter("sortOrder");
        String sortUser = QueryString.sortUser;

        boolean sortOrderAscending = sortColumn != null && sortOrder != null && sortOrder.equals("ASC");

        HttpSession session = req.getSession();
        session.setAttribute("sortOrderAscending", sortOrderAscending);

        UserDAO userDao = new UserDAO();
        List<User> userList = userDao.getAllUser(sortColumn + " " + sortOrder );
        req.setAttribute("userList", userList);
        NavigationButton navigationButton = new NavigationButton();
        navigationButton.buttonLogic(userList, req, resp);
        req.getRequestDispatcher("usersList.jsp").forward(req, resp);
    }
}
