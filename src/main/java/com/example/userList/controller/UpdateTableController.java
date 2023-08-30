package com.example.userList.controller;


import com.example.userList.data.dao.UserDAO;
import com.example.userList.data.entity.User;
import com.example.userList.dto.UserDto;
import com.example.userList.service.ValidateService;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.example.userList.dataDefinition.FieldName.USER_ID;
import static com.example.userList.dataDefinition.FieldName.USER_LIST;

@WebServlet("/update")
public class UpdateTableController extends HttpServlet {

    private UserDAO userDao;

    @Override
    public void init(ServletConfig config) {
        userDao = new UserDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userId = Integer.parseInt(req.getParameter(USER_ID));
        UserDto userDto = new UserDto(req);

        List<User> user = new ArrayList<>();
        user.add(0, new User(userId, userDto.getFirstName(), userDto.getLastName(), userDto.getLogin(), userDto.getPassword()));
        req.setAttribute(USER_LIST, user);

        ValidateService validateService = new ValidateService();
        if (validateService.validateData(userDto.getFirstName(), userDto.getLastName(), userDto.getLogin(), userDto.getPassword(), req)) {
            req.getRequestDispatcher("/update");
            return;
        }
        userDao.update(userId, userDto.getFirstName(), userDto.getLastName(), userDto.getLogin(), userDto.getPassword());
        req.getRequestDispatcher("/usersList").forward(req, resp);
    }

}
