package com.example.UserList.controller;

import com.example.UserList.data.dao.UserDAO;
import com.example.UserList.data.entity.User;
import com.example.UserList.dataDefinition.FieldName;
import com.example.UserList.dataDefinition.ErrorData;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/change")
public class ChangeTableController extends HttpServlet {
    UserDAO userDao;
    @Override
    public void init(ServletConfig config) throws ServletException {
        userDao = new UserDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("userRegister.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter(FieldName.action);
        if (FieldName.update.equals(action)) {
            int userId = Integer.parseInt(req.getParameter(FieldName.userId));

            User user = userDao.getUser(userId);
            req.setAttribute(FieldName.user, user);

            req.getRequestDispatcher("userUpdate.jsp").forward(req, resp);
        } else if (FieldName.delete.equals(action)) {
            String userId = req.getParameter(FieldName.userId);

            userDao.delete(userId);

            resp.sendRedirect("/UserList_war/usersList");
        } else if (FieldName.search.equals(action)) {
            String searchText = req.getParameter(FieldName.searchText);

            List<User> userList = userDao.searchUser(searchText);
            if (userList.isEmpty()) {
                req.setAttribute(FieldName.hint, ErrorData.ERROR_USER_NOT_FOUND);
            }
            req.setAttribute(FieldName.userList, userList);

            req.getRequestDispatcher("usersList.jsp").forward(req, resp);
        }
    }
}
