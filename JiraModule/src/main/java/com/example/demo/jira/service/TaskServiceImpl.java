package com.example.demo.jira.service;

import com.example.demo.jira.dto.AddUToTaskDto;
import com.example.demo.jira.dto.TaskDto;
import com.example.demo.jira.dto.UpdateStatusDto;
import com.example.demo.jira.entity.Task;
import com.example.demo.jira.entity.User;
import com.example.demo.jira.enumeration.TaskStatus;
import com.example.demo.jira.repo.TaskRepo;
import com.example.demo.jira.repo.UserRepo;
import com.example.demo.jira.util.ModelCopy1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepo taskRepo;
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelCopy1 modelCopy1;

    @Override
    public TaskDto createTask(TaskDto task) {
        Task task1 = modelCopy1.dtoToEntity(task);
        Task save = taskRepo.save(task1);
        return modelCopy1.entityToDto(save);
    }

    @Override
    public TaskDto addUToTask(String taskId, AddUToTaskDto addUToTaskDto) {
        Task task = taskRepo.findById(taskId).get();
        String user = addUToTaskDto.getUser();
        User user1 = userRepo.findById(user).get();
        task.setUser(user1);
        return modelCopy1.entityToDto(task);

    }

    @Override
    public TaskDto updateStatus(String tId, UpdateStatusDto updateStatusDto) {
        Task task = taskRepo.findById(tId).get();
        String tStatus = updateStatusDto.getTaskStatus();
        task.setTaskStatus(tStatus);
        taskRepo.save(task);
        return modelCopy1.entityToDto(task);
    }

    @Override
    public List<TaskDto> getTaskByStatus(TaskStatus taskStatus) {
        List<Task> byTaskStatus = taskRepo.findByTaskStatus(taskStatus);
        List<TaskDto> collect = byTaskStatus.stream().map(t -> modelCopy1.entityToDto(t)).collect(Collectors.toList());
        return collect;
    }

    @Override
    public List<TaskDto> getDelayedTask() {
        List<Task> byTaskStatus1 = taskRepo.findByTaskStatus(TaskStatus.TO_DO);
        byTaskStatus1.addAll(taskRepo.findByTaskStatus(TaskStatus.DEV_IN_PROGRESS));
        List<TaskDto> collect = byTaskStatus1.stream().map(t -> modelCopy1.entityToDto(t)).collect(Collectors.toList());
        return collect;
    }

    @Override
    public TaskDto getTaskById(String tId) {
        Task task = taskRepo.findById(tId).get();
        return modelCopy1.entityToDto(task);
    }

    @Override
    public List<TaskDto> getAllTasks() {
        return taskRepo.findAll().stream().map(t -> modelCopy1.entityToDto(t)).collect(Collectors.toList());

    }
}
