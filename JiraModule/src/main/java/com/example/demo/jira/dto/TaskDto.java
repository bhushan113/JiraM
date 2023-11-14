package com.example.demo.jira.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskDto implements Serializable {
    private String taskId;
    private String title;
    private String type;//story,feature,Bugs
    private String status;
    private List<String> subtasks;
}
