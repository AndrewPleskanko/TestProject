package com.example.UserList.service;

import com.example.UserList.data.entity.User;
import com.example.UserList.dto.ResponseDto;


import java.util.List;

public class NavigationService {
    private static final int PAGE_SIZE = 10;

    public ResponseDto buttonLogic(List<User> userList, Integer page) {
        int totalUsers = userList.size();
        int PAGE_COUNT = (totalUsers + PAGE_SIZE - 1) / PAGE_SIZE;

        if (page != null) {
            int startIdx = (page - 1) * PAGE_SIZE;
            int endIdx = Math.min(startIdx + PAGE_SIZE, totalUsers);
            List<User> usersToDisplay = userList.subList(startIdx, endIdx);

            return new ResponseDto(page, PAGE_COUNT, usersToDisplay, 0);
        } else {
            return createFirstPageInfo(userList);
        }
    }

    private ResponseDto createFirstPageInfo(List<User> userList) {
        List<User> usersToDisplay = userList.subList(0, 9);

        return new ResponseDto(1, (userList.size() + PAGE_SIZE - 1) / PAGE_SIZE, usersToDisplay, 5);
    }
}
