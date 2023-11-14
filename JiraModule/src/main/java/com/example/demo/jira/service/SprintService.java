package com.example.demo.jira.service;

import com.example.demo.jira.dto.AddTToSprintDto;
import com.example.demo.jira.dto.SprintDto;


import java.util.List;

public interface SprintService {
    SprintDto createSprint(SprintDto sprintDto);
    List<SprintDto> getAllSprints();
    SprintDto getSprintById(String sId);

    SprintDto removeTFromSprint(String sId, AddTToSprintDto addTToSprintDto);

    SprintDto addTToSprint(String sId, AddTToSprintDto addTToSprintDto);
}
