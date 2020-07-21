package com.example.helloworld;

import com.example.helloworld.service.UserService;
import com.example.helloworld.vo.User;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/world")
public class HelloWorldController {

    @Autowired
    UserService service;

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello World!";
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") int id) {
        User user = new User();
        user.setFirstName("Ganesh");
        user.setLastName("Jayaraman");
        user.setEmail("ganesh@example.com");
        User.allUsers.put(1, user);
        return service.readUser(id);

    }

    @PostMapping("/user")
    public String addUser(@RequestBody User user){
        System.out.println(user);
        return service.addUser(user);
    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable("id") int id){
        System.out.println(id+" delete");
        return service.deleteUser(id);
    }

    @PutMapping("/user")
    public User updateUser(@RequestBody User user){

        return service.updateUser(user.getId(), user);
    }

    @PatchMapping(path="/user/{id}", consumes =  "application/json")
    public User updateUserContent(@PathVariable("id") String id, @RequestBody JsonPatch patch) throws JsonPatchException {
        System.out.println(id+" "+patch);
        return service.updateSpecific(Integer.parseInt(id), patch);
    }
}
