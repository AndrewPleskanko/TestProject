package com.example.UserList.changeData;

import jakarta.servlet.http.HttpServletRequest;

public class DataGetAndSet {
    public String[] getAndSet(HttpServletRequest req) {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        req.setAttribute("firstName", firstName);
        req.setAttribute("lastName", lastName);
        req.setAttribute("login", login);
        req.setAttribute("password", password);
        String[] data = new String[]{firstName, lastName, login, password};
        return data;

    }
}
