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
        DataGetAndSet dataGetAndSet = new DataGetAndSet();
        String[] data = dataGetAndSet.getAndSet(req);

        String firstName = data[0];
        String lastName = data[1];
        String login = data[2];
        String password = data[3];

        ArrayList<User> user = new ArrayList<>();
        user.add(0, new User(userId, firstName, lastName, login, password));
        req.setAttribute("userList", user);
        Validate validate = new Validate();
        if (validate.validateData(firstName, lastName, login, password, req, resp)) {
            req.getRequestDispatcher("/update").forward(req, resp);
        }
        String query = "UPDATE users SET first_name = ?, last_name = ?, login = ?, password = ? WHERE id = ?";
        UserDAO userDao = new UserDAO();
        userDao.update(query, firstName, lastName, login, password, userId);

        resp.sendRedirect("/UserList_war/usersList");
    }

}
