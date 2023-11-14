package com.example.demo.jira.service;

import com.example.demo.jira.dto.AddTToSprintDto;
import com.example.demo.jira.dto.SprintDto;
import com.example.demo.jira.entity.Sprint;
import com.example.demo.jira.entity.Task;
import com.example.demo.jira.repo.SprintRepo;
import com.example.demo.jira.repo.TaskRepo;
import com.example.demo.jira.util.ModelCopy;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service

public class SprintServiceImpl implements SprintService {
    @Autowired
    private SprintRepo sprintRepo;
    @Autowired
    private TaskServiceImpl taskService;
    @Autowired
    private TaskRepo taskRepo;

    @Autowired
    private ModelCopy modelCopy;

    @Override
    public SprintDto createSprint(SprintDto sprintDto) {
        System.err.println(sprintDto);
        Sprint sprint = modelCopy.dtoToEntity(sprintDto);
        Sprint save = sprintRepo.save(sprint);
        return modelCopy.entityToDto(save);
    }

    public List<SprintDto> getAllSprints() {
        return sprintRepo.findAll().stream().map(t -> modelCopy.entityToDto(t)).collect(Collectors.toList());
    }

    @Override
    public SprintDto getSprintById(String sId) {
        Sprint sprint = sprintRepo.findById(sId).get();
        return modelCopy.entityToDto(sprint);
    }

    @Override
    public SprintDto addTToSprint(String sId, AddTToSprintDto addTToSprintDto) {
        Sprint sprint = sprintRepo.findById(sId).get();
        String tasks = addTToSprintDto.getTasks();
        Task task = taskRepo.findById(tasks).get();
        if (sprint.getTaskIds() == null) {
            sprint.setTaskIds(List.of(task.getTaskId()));
        } else {
            sprint.getTaskIds().add(task.getTaskId());
        }
        sprintRepo.save(sprint);
        return modelCopy.entityToDto(sprint);
    }

    @Override
    public SprintDto removeTFromSprint(String sId, AddTToSprintDto addTToSprintDto) {
        Sprint sprint = sprintRepo.findById(sId).get();
        String tasks = addTToSprintDto.getTasks();
        Task task = taskRepo.findById(tasks).get();
        sprint.getTaskIds().remove(task);
        return modelCopy.entityToDto(sprint);
    }
}



