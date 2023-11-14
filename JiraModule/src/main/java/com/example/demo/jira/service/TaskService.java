package com.example.demo.jira.service;

import com.example.demo.jira.dto.AddUToTaskDto;
import com.example.demo.jira.dto.TaskDto;
import com.example.demo.jira.dto.UpdateStatusDto;
import com.example.demo.jira.enumeration.TaskStatus;

import java.util.List;

public interface TaskService {
    TaskDto createTask(TaskDto taskDto);
    TaskDto updateStatus(String id, UpdateStatusDto updateStatusDto);
    List<TaskDto> getTaskByStatus(TaskStatus taskStatus);

    List<TaskDto> getDelayedTask();

    TaskDto getTaskById(String sId);

    TaskDto addUToTask(String taskId, AddUToTaskDto addUserToTaskDto);

    List<TaskDto> getAllTasks();
}
