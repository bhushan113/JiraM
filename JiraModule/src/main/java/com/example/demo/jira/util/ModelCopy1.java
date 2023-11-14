package com.example.demo.jira.util;

import com.example.demo.jira.dto.TaskDto;
import com.example.demo.jira.entity.Task;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ModelCopy1 {
    @Autowired
    private ModelMapper modelMapper;
    public Task dtoToEntity(TaskDto taskDto){
        return modelMapper.map(taskDto, Task.class);
    }
    public TaskDto entityToDto(Task task) {
        return modelMapper.map(task, TaskDto.class);
    }
}
