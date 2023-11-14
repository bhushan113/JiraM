package com.example.demo.jira.service;

import com.example.demo.jira.dto.UserDto;
import com.example.demo.jira.entity.User;
import com.example.demo.jira.exception.UserNotFound;
import com.example.demo.jira.repo.UserRepo;
import com.example.demo.jira.util.ModelCopy2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelCopy2 modelCopy2;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = modelCopy2.dtoToEntity(userDto);
        User save = userRepo.save(user);
        return modelCopy2.entityToDto(save);
    }
    @Override
    public UserDto getUById(String uId){
        return userRepo.findById(uId).map(u->modelCopy2.entityToDto(u)).orElseThrow(()->new UserNotFound("User is not found: "+uId));
    }
       @Override
       public List<UserDto> getAllUsers(){
           List<User> all = userRepo.findAll();
           List<UserDto> collect = all.stream().map(u -> modelCopy2.entityToDto(u)).collect(Collectors.toList());
           return collect;
        
        }
}


