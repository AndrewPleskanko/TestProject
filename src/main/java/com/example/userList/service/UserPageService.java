package com.example.userList.service;

import com.example.userList.data.entity.User;
import com.example.userList.dto.ButtonInfoDto;

import java.util.List;

public class UserPageService {
    private static final int PAGE_SIZE = 10;

    public ButtonInfoDto getCurrentPage(List<User> userList, Integer page) {
        int totalUsers = userList.size();
        int PAGE_COUNT = (totalUsers + PAGE_SIZE - 1) / PAGE_SIZE;

        if (page != null) {
            int startIdx = (page - 1) * PAGE_SIZE;
            int endIdx = Math.min(startIdx + PAGE_SIZE, totalUsers);
            List<User> usersToDisplay = userList.subList(startIdx, endIdx);

            return new ButtonInfoDto(page, PAGE_COUNT, usersToDisplay);
        } else {
            return getFirstPage(userList);
        }
    }

    private ButtonInfoDto getFirstPage(List<User> userList) {
        List<User> usersToDisplay = userList.subList(0, 9);

        return new ButtonInfoDto(1, (userList.size() + PAGE_SIZE - 1) / PAGE_SIZE, usersToDisplay);
    }
}
