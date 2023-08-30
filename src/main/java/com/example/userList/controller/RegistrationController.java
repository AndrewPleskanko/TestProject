package com.example.userList.controller;


import com.example.userList.dto.UserDto;
import com.example.userList.data.dao.UserDAO;
import com.example.userList.service.ValidateService;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/register")
public class RegistrationController extends HttpServlet {

    private UserDAO userDao;

    @Override
    public void init(ServletConfig config) {
        userDao = new UserDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UserDto userDto = new UserDto(request);

        ValidateService validateService = new ValidateService();
        if (validateService.validateData(userDto.getFirstName(), userDto.getLastName(), userDto.getLogin(), userDto.getPassword(), request)) {
            request.getRequestDispatcher("userRegister.jsp").forward(request, response);
            return;
        }

        userDao.create(userDto.getFirstName(), userDto.getLastName(), userDto.getLogin(), userDto.getPassword());
        request.getRequestDispatcher("logIn.jsp").forward(request, response);
    }

}
