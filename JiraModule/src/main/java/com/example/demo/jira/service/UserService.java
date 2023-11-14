package com.example.demo.jira.service;

import com.example.demo.jira.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto getUById(String uId);
    List<UserDto> getAllUsers();
}
