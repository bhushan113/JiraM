package com.example.demo.jira.response;

import com.example.demo.jira.dto.TaskDto;
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
public class SprintDtoResponse implements Serializable {
    private String sprintId;
    private String sprintName;
    private List<TaskDto>  taskDtos;
}
