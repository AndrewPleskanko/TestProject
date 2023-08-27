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
    public void init(ServletConfig config) {
        userDao = new UserDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("userRegister.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter(FieldName.ACTION);
        if (FieldName.UPDATE.equals(action)) {
            int userId = Integer.parseInt(req.getParameter(FieldName.USER_ID));

            User user = userDao.getUser(userId);
            req.setAttribute(FieldName.USER, user);

            req.getRequestDispatcher("userUpdate.jsp").forward(req, resp);
        } else if (FieldName.DELETE.equals(action)) {
            String userId = req.getParameter(FieldName.USER_ID);

            userDao.delete(userId);

            resp.sendRedirect("/UserList_war/usersList");
        } else if (FieldName.SEARCH.equals(action)) {
            String searchText = req.getParameter(FieldName.SEARCH_TEXT);

            List<User> USER_LIST = userDao.searchUser(searchText);
            if (USER_LIST.isEmpty()) {
                req.setAttribute(FieldName.HINT, ErrorData.ERROR_USER_NOT_FOUND);
            }
            req.setAttribute(FieldName.USER_LIST, USER_LIST);

            req.getRequestDispatcher("usersList.jsp").forward(req, resp);
        }
    }
}
