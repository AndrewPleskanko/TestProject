package com.example.UserList.dto;

import com.example.UserList.data.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ResponseDto {
    private int currentPage;
    private int page_count;
    private List<User> userList;
    private int pageNum;

}
