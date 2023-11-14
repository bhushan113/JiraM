package com.example.demo.jira.repo;

import com.example.demo.jira.entity.Sprint;
import com.example.demo.jira.entity.Task;
import com.example.demo.jira.enumeration.TaskStatus;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TaskRepo extends MongoRepository<Task, String> {
    List<Task> findByTaskStatus(TaskStatus taskStatus);
}
