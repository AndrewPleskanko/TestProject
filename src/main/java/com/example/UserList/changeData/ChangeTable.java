package com.example.UserList.changeData;

import com.example.UserList.data.UserDAO;
import com.example.UserList.data.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/change")
public class ChangeTable extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("userRegister.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if ("update".equals(action)) {
            int userId = Integer.parseInt(req.getParameter("userId"));
            UserDAO userDao = new UserDAO();
            User user = userDao.getUser(userId);
            req.setAttribute("user", user);

            req.getRequestDispatcher("userUpdate.jsp").forward(req, resp);
        } else if ("delete".equals(action)) {
            String userId = req.getParameter("userId");

            UserDAO userDao = new UserDAO();
            userDao.delete(userId);

            resp.sendRedirect("/UserList_war/usersList");
        } else if ("search".equals(action)) {
            String searchText = req.getParameter("searchText");

            UserDAO userDao = new UserDAO();
            List<User> userList = userDao.searchUser(searchText);
            if (userList.isEmpty()) {
                req.setAttribute("hint", "User not found. Try write something else");
            }
            req.setAttribute("userList", userList);

            req.getRequestDispatcher("usersList.jsp").forward(req, resp);
        }
    }
}
