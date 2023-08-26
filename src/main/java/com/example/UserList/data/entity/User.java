package com.example.UserList.data.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class User {
    int id;
    String first_name;
    String last_name;
    String login;
    String password;

}