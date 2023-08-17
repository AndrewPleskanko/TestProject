package com.example.UserList.view;

import com.example.UserList.data.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class NavigationButton {
    public void buttonLogic(List<User> userList, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int count = (userList.size() + 9) / 10; // Розрахувати кількість сторінок

        if (req.getParameter("page") != null) {
            int page = Integer.parseInt(req.getParameter("page"));

            int pageSize = 10;
            int startIdx = (page - 1) * pageSize;

            int endIdx = Math.min(startIdx + pageSize, userList.size());
            if (startIdx > userList.size()) {
                req.getRequestDispatcher("errorLogin.jsp").forward(req, resp);
            }

            List<User> usersToDisplay = userList.subList(startIdx, endIdx);
            req.setAttribute("currentPage", page);

            req.setAttribute("pageCount", count);
            req.setAttribute("userList", usersToDisplay);
        } else {
            List<User> usersToDisplay = userList.subList(0, 9);
            req.setAttribute("userList", usersToDisplay);

            req.setAttribute("pageNum", 5);

            req.setAttribute("currentPage", 1); // Встановимо початкову сторінку як 1
            req.setAttribute("pageCount", count);
        }
    }
}
