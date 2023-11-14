package com.example.demo.jira.util;

import com.example.demo.jira.dto.SprintDto;
import com.example.demo.jira.dto.TaskDto;
import com.example.demo.jira.entity.Sprint;
import com.example.demo.jira.entity.Task;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ModelCopy {
    @Autowired
    private ModelMapper modelMapper;
    public  Sprint dtoToEntity(SprintDto sprintDto){
        return modelMapper.map(sprintDto, Sprint.class);
    }
    public  SprintDto entityToDto(Sprint sprint) {
        return modelMapper.map(sprint, SprintDto.class);
    }

}
