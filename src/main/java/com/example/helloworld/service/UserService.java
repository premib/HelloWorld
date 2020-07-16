package com.example.helloworld.service;

import com.example.helloworld.vo.User;

public interface UserService {

    public User readUser(int id);
    public String addUser(User user);
    public String deleteUser(int id);
    public User updateUser(int id, User user);

}
