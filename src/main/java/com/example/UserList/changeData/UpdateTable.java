package com.example.UserList.changeData;

import com.example.UserList.data.UserDAO;
import com.example.UserList.data.User;
import com.example.UserList.service.Validate;
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

        req.setAttribute("firstName", firstName);
        req.setAttribute("lastName", lastName);
        req.setAttribute("login", login);
        req.setAttribute("password", password);

        ArrayList<User> user = new ArrayList<User>();
        user.add(0, new User(userId, firstName, lastName, login, password));
        req.setAttribute("userList", user);
        Validate validate = new Validate();
        if(validate.validateData(firstName, lastName, login, password, req, resp)){
            req.getRequestDispatcher("/update").forward(req, resp);
        }
        String query = "UPDATE users SET first_name = ?, last_name = ?, login = ?, password = ? WHERE id = ?";
        UserDAO userDao = new UserDAO();
        userDao.update(query, firstName, lastName, login, password, userId);

        resp.sendRedirect("/UserList_war/usersList");
    }

    private boolean isValidLogin(String email) {
        return email.toLowerCase().endsWith("@gmail.com");
    }

    private boolean isMoreThree(String name) {
        return name.length() > 2;
    }
}
