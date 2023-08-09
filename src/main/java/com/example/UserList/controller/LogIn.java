package com.example.UserList.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/logIn")
public class LogIn extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sql = "SELECT COUNT(*) FROM users WHERE username = ? AND password_hash = ?";
        req.getRequestDispatcher("userRegister.jsp");
    }
}
