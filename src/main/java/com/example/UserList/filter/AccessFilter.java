package com.example.UserList.filter;

import com.example.UserList.dataDefinition.FieldName;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter({"/usersList", "/change", "/update"})
public class AccessFilter implements Filter {
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;

        HttpSession session = httpRequest.getSession();
        String login = (String) session.getAttribute(FieldName.LOGIN);

        if (login == null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/UserList_war/userRegister.jsp");
            dispatcher.forward(request, response);
        } else {
            chain.doFilter(request, response);
        }

    }
}
