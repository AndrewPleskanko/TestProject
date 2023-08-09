package com.example.UserList.controller;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter("/*")
public class AccessFilter implements Filter {
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        HttpSession session = httpRequest.getSession();
        String username = (String) session.getAttribute("username");

        // Перевіряємо, чи користувач зареєстрований
        if (username == null) {

            // Користувач не зареєстрований, перенаправляємо його на сторінку реєстрації
           httpResponse.sendRedirect("/demo3_war_exploded/userWelcome.jsp");
        } else {
            // Користувач зареєстрований, дозволяємо доступ до контенту
            chain.doFilter(request, response);
        }

    }
}
