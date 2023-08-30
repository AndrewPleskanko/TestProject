package com.example.userList.controller;

import com.example.userList.data.dao.UserDAO;
import com.example.userList.data.entity.User;
import com.example.userList.dto.ButtonInfoDto;
import com.example.userList.service.UserPageService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import static com.example.userList.dataDefinition.FieldName.*;

@WebServlet("/usersList")
public class UsersListController extends HttpServlet {
    private UserDAO userDao;
    private UserPageService navigationService;

    @Override
    public void init() {
        userDao = new UserDAO();
        navigationService = new UserPageService();
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
        String sortColumn = req.getParameter(SORT_COLUMN);
        String sortOrder = req.getParameter(SORT_ORDER);
        String pageParam = req.getParameter(PAGE);
        Integer page = null;
        if (pageParam != null) {
            page = Integer.valueOf(pageParam);
        }

        boolean isSortOrderAscending = sortColumn != null && sortOrder != null && sortOrder.equals(ASC);

        HttpSession session = req.getSession();
        session.setAttribute(IS_SORT_ORDER_ASCENDING, isSortOrderAscending);

        List<User> userList;

        if (sortColumn != null && sortOrder != null) {
            userList = userDao.sortUser(sortColumn, sortOrder);
        } else {
            userList = userDao.getAllUser();
        }

        ButtonInfoDto responseDto = navigationService.getCurrentPage(userList, page);

        req.setAttribute(CURRENT_PAGE, responseDto.getCurrentPage());
        req.setAttribute(PAGE_COUNT, responseDto.getPageCount());
        req.setAttribute(USER_LIST, responseDto.getUserList());

        req.getRequestDispatcher("usersList.jsp").forward(req, resp);
    }

}
