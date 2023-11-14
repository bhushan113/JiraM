package com.example.demo.jira.controller;

import com.example.demo.jira.dto.AddUToTaskDto;
import com.example.demo.jira.dto.TaskDto;
import com.example.demo.jira.dto.UpdateStatusDto;
import com.example.demo.jira.enumeration.TaskStatus;
import com.example.demo.jira.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;
    @PostMapping
    public TaskDto createTask(@RequestBody TaskDto taskDto){
        return taskService.createTask(taskDto);
    }
    @PutMapping("/{tId}")
    public TaskDto updateStatus(@PathVariable String tId, @RequestBody UpdateStatusDto updateStatusDto){
        return taskService.updateStatus(tId,updateStatusDto);
    }
    @GetMapping("/{taskStatus}")
    public List<TaskDto> getTaskByStatus(@PathVariable TaskStatus taskStatus){
        return taskService.getTaskByStatus(taskStatus);
    }
    @GetMapping("/delayed")
    public List<TaskDto> getDelayedTask(){
        return taskService.getDelayedTask();
    }
    @GetMapping("/{tId}")
    public TaskDto getTaskById(@PathVariable String tId){
        return taskService.getTaskById(tId);
    }
    @PutMapping("/add/{tId}")
    public TaskDto addUToTask(@PathVariable String tId, @RequestBody AddUToTaskDto addUToTaskDto){
        return taskService.addUToTask(tId,addUToTaskDto);
    }
    @GetMapping
    public List<TaskDto> getAllTasks() {
        return taskService.getAllTasks();
    }
}
