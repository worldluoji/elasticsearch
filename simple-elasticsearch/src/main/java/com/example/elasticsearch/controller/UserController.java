package com.example.elasticsearch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.elasticsearch.model.User;
import com.example.elasticsearch.serivce.UserService;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public User addUser(User user) {
        return this.userService.addUser(user);
    }

    @DeleteMapping("/delete")
    public String deleteUser(Long id) {
        this.userService.deleteUserById(id);
        return "Delete user " + id + "success";
    }

    //@PutMapping("/update")
    @PostMapping("/update")
    public User updateUser(@RequestParam Long id, String name,Integer age) {
       return this.userService.updateUser(id, name, age);
    }

    @GetMapping("/get")
    public User getUser(Long id) {
        return this.userService.getUser(id);
    }

    @GetMapping("/getAll")
    public List<User> getAllUsers() {
        return this.userService.findAllUser();
    }

}
