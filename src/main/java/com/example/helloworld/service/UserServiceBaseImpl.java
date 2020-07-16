package com.example.helloworld.service;

import com.example.helloworld.vo.User;
import org.springframework.stereotype.Component;

@Component
public class UserServiceBaseImpl  implements UserService{

    @Override
    public User readUser(int id) {

        return User.allUsers.get(id);
    }

    @Override
    public String addUser(User user) {

        if(User.allUsers.containsKey(user.getId())){
            return "NO";
        }
        else{
            User.allUsers.put(user.getId(), user);
            return "YES";
        }
    }

    @Override
    public String deleteUser(int id) {

        if(User.allUsers.containsKey(id)){
            User.allUsers.remove(id);
            System.out.println(User.allUsers);
            return "YES";
        }
        return "NO";
    }

    @Override
    public User updateUser(int id, User user) {

        if(User.allUsers.containsKey(id)){
            User.allUsers.put(id, user);
            return User.allUsers.get(id);
        }

        return null;
    }
}
