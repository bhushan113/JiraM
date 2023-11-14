package com.example.demo.jira.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection="task")
public class Task {
    @Id
    private String taskId;
    private String title;
    private String type;//story,feature,Bugs
    private String taskStatus;
    private User user;
    private List<String> subtasks;
}
