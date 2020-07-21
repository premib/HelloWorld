package com.example.helloworld.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Data
@ToString
@NoArgsConstructor
public class User {

    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private List<String> roles = new ArrayList<>();
    public static Map<Integer, User> allUsers = new HashMap<>();


}
