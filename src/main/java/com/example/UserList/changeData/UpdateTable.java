package com.example.UserList.changeData;

import com.example.UserList.data.UserDAO;
import com.example.UserList.data.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/update")
public class UpdateTable extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userId = Integer.parseInt(req.getParameter("userId"));
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        ArrayList<User> user = new ArrayList<User>();
        user.add(0, new User(userId, firstName, lastName, login, password));
        req.setAttribute("userList", user);

        if (!isMoreThree(firstName)) {
            req.setAttribute("errorName", "Invalid login format. Name must be at least 3 characters long");
            req.getRequestDispatcher("userUpdate.jsp").forward(req, resp);
            return;
        }
        if (!isMoreThree(lastName)) {
            req.setAttribute("errorSurname", "Invalid login format. Surname must be at least 3 characters long");
            req.getRequestDispatcher("userUpdate.jsp").forward(req, resp);
            return;
        }
        if (!isValidLogin(login)) {
            req.setAttribute("errorLogin", "Please enter a valid Gmail address!");
            req.getRequestDispatcher("userUpdate.jsp").forward(req, resp);
            return;
        }
        if (!isMoreThree(password)) {
            req.setAttribute("errorPassword", "Invalid login format. Password must be at least 3 characters long");
            req.getRequestDispatcher("userUpdate.jsp").forward(req, resp);
            return;
        }
        String query = "UPDATE users SET first_name = ?, last_name = ?, login = ?, password = ? WHERE id = ?";
        UserDAO.update(query, firstName, lastName, login, password, userId);

        resp.sendRedirect("/demo3_war_exploded/usersList");
    }

    private boolean isValidLogin(String email) {
        return email.toLowerCase().endsWith("@gmail.com");
    }

    private boolean isMoreThree(String name) {
        return name.length() > 2;
    }
}
