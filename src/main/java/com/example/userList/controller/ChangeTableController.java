package com.example.userList.controller;

import com.example.userList.data.dao.UserDAO;
import com.example.userList.data.entity.User;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

import static com.example.userList.dataDefinition.ErrorData.ERROR_USER_NOT_FOUND;
import static com.example.userList.dataDefinition.FieldName.*;

@WebServlet("/change")
public class ChangeTableController extends HttpServlet {
    private UserDAO userDao;

    @Override
    public void init(ServletConfig config) {
        userDao = new UserDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("userRegister.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter(ACTION);
        if (UPDATE.equals(action)) {
            int userId = Integer.parseInt(req.getParameter(USER_ID));

            User user = userDao.getUser(userId);
            req.setAttribute(USER, user);

            req.getRequestDispatcher("userUpdate.jsp").forward(req, resp);
        } else if (DELETE.equals(action)) {
            String userId = req.getParameter(USER_ID);

            userDao.delete(userId);

            resp.sendRedirect("/UserList_war/usersList");
        } else if (SEARCH.equals(action)) {
            String searchText = req.getParameter(SEARCH_TEXT);

            List<User> users = userDao.searchUser(searchText);
            if (users.isEmpty()) {
                req.setAttribute(HINT, ERROR_USER_NOT_FOUND);
            }
            req.setAttribute(USER_LIST, users);

            req.getRequestDispatcher("usersList.jsp").forward(req, resp);
        }
    }
}
