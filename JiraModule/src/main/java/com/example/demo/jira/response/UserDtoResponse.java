package com.example.demo.jira.response;

import com.example.demo.jira.dto.TaskDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDtoResponse {
    private String uId;
    private String uName;
    private String emailId;
    private List<TaskDto> taskDTOS;
}
