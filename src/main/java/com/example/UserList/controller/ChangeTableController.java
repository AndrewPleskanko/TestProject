package com.example.UserList.controller;

import com.example.UserList.data.dao.UserDAO;
import com.example.UserList.data.entity.User;
import com.example.UserList.dataDefinition.DataName;
import com.example.UserList.dataDefinition.ErrorData;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/change")
public class ChangeTableController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("userRegister.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (DataName.update.equals(action)) {
            int userId = Integer.parseInt(req.getParameter("userId"));
            UserDAO userDao = new UserDAO();
            User user = userDao.getUser(userId);
            req.setAttribute("user", user);

            req.getRequestDispatcher("userUpdate.jsp").forward(req, resp);
        } else if (DataName.delete.equals(action)) {
            String userId = req.getParameter("userId");

            UserDAO userDao = new UserDAO();
            userDao.delete(userId);

            resp.sendRedirect("/UserList_war/usersList");
        } else if (DataName.search.equals(action)) {
            String searchText = req.getParameter("searchText");

            UserDAO userDao = new UserDAO();
            List<User> userList = userDao.searchUser(searchText);
            if (userList.isEmpty()) {
                req.setAttribute(DataName.hint, ErrorData.ERROR_USER_NOT_FOUND);
            }
            req.setAttribute(DataName.userList, userList);

            req.getRequestDispatcher("usersList.jsp").forward(req, resp);
        }
    }
}
