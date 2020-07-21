package com.example.helloworld.service;

import com.example.helloworld.vo.User;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import org.springframework.stereotype.Component;



@Component
public class UserServiceBaseImpl  implements UserService{

    @Override
    public User readUser(int id) {

        return User.allUsers.get(id);
    }

    @Override
    public String   addUser(User user) {

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

    @Override
    public User updateSpecific(int id, JsonPatch patch) throws JsonPatchException {
        ObjectMapper objectMapper = new ObjectMapper();
        if(User.allUsers.containsKey(id)){
            User ref = User.allUsers.get(id);
            System.out.println(ref);
            JsonNode patchedUser = patch.apply(objectMapper.convertValue(ref, JsonNode.class));
            System.out.println(patchedUser);
            User finalUser = objectMapper.convertValue(patchedUser, User.class);
            System.out.print(finalUser);
            User.allUsers.put(id, finalUser);
            return finalUser;
        }
        else{
            return new User();
        }

    }
}
