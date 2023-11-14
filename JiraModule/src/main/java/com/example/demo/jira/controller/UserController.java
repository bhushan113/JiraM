package com.example.demo.jira.controller;


import com.example.demo.jira.dto.UserDto;
import com.example.demo.jira.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public UserDto createUser(@RequestBody UserDto userDto) {
       System.err.println("check");
        return userService.createUser(userDto);
    }
    @GetMapping("/{userId}")
    public UserDto getUById(@PathVariable String userId){
        return userService.getUById(userId);
    }
    @GetMapping
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }
}
