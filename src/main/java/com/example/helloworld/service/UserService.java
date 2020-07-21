package com.example.helloworld.service;

import com.example.helloworld.vo.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;


public interface UserService {

    public User readUser(int id);
    public String addUser(User user);
    public String deleteUser(int id);
    public User updateUser(int id, User user);
    public User updateSpecific(int id, JsonPatch patch) throws JsonPatchException;

}
