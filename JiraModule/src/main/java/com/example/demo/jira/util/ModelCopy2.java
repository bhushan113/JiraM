package com.example.demo.jira.util;

import com.example.demo.jira.dto.UserDto;
import com.example.demo.jira.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ModelCopy2 {
    @Autowired
    private  ModelMapper modelMapper;
    public  User dtoToEntity(UserDto userDto){
        return modelMapper.map(userDto, User.class);
    }
    public  UserDto entityToDto(User user) {
        return modelMapper.map(user, UserDto.class);
    }
}
