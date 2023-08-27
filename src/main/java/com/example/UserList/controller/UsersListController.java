package com.example.UserList.controller;

import com.example.UserList.data.dao.IUserDAO;
import com.example.UserList.data.dao.UserDAO;
import com.example.UserList.data.entity.User;
import com.example.UserList.dataDefinition.FieldName;
import com.example.UserList.dto.ResponseDto;
import com.example.UserList.service.NavigationService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet("/usersList")
public class UsersListController extends HttpServlet {
    IUserDAO userDao;
    NavigationService navigationService;

    @Override
    public void init() {
        userDao = new UserDAO();
        navigationService = new NavigationService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sortColumn = req.getParameter(FieldName.sortColumn);
        String sortOrder = req.getParameter(FieldName.sortOrder);
        String pageParam = req.getParameter(FieldName.page);
        Integer page = null;
        if (pageParam != null) {
            page = Integer.valueOf(pageParam);
        }

        boolean isSortOrderAscending = sortColumn != null && sortOrder != null && sortOrder.equals("ASC");

        HttpSession session = req.getSession();
        session.setAttribute(FieldName.isSortOrderAscending, isSortOrderAscending);

        List<User> userList;

        if (sortColumn != null && sortOrder != null) {
            userList = userDao.sortUser(sortColumn, sortOrder);
        } else {
            userList = userDao.getAllUser();
        }

        ResponseDto responseDto = navigationService.buttonLogic(userList, page);

        req.setAttribute(FieldName.currentPage, responseDto.getCurrentPage());
        req.setAttribute(FieldName.pageCount, responseDto.getPageCount());
        req.setAttribute(FieldName.userList, responseDto.getUserList());

        req.getRequestDispatcher("usersList.jsp").forward(req, resp);
    }

}
