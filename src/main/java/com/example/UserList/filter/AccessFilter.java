package com.example.UserList.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter("/fil/*")
public class AccessFilter implements Filter {
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        HttpSession session = httpRequest.getSession();
        String login = (String) session.getAttribute("login");

        // Перевіряємо, чи користувач зареєстрований
        if (login == null) {

            // Користувач не зареєстрований, перенаправляємо його на сторінку реєстрації
           httpResponse.sendRedirect("/UserList_war/userRegister.jsp");
        } else {
            // Користувач зареєстрований, дозволяємо доступ до контенту
            chain.doFilter(request, response);
        }

    }
}
