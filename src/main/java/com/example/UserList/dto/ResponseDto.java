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
    private int pageCount;
    private List<User> userList;
    private int pageNum;

}
