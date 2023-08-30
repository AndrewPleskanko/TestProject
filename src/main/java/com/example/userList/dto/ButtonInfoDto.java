package com.example.userList.dto;

import com.example.userList.data.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ButtonInfoDto {
    private int currentPage;
    private int pageCount;
    private List<User> userList;

}
