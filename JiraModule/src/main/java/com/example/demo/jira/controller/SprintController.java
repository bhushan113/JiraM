package com.example.demo.jira.controller;

import com.example.demo.jira.dto.AddTToSprintDto;
import com.example.demo.jira.dto.SprintDto;
import com.example.demo.jira.service.SprintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sprints")
public class SprintController {
    @Autowired
    private SprintService sprintService;
    @PostMapping("/")
    public SprintDto createSprint(@RequestBody SprintDto sprintDto){
       System.err.println("hgvchg");
        return sprintService.createSprint(sprintDto);
    }
    @GetMapping("/{sId}")
    public SprintDto getSprintById(@PathVariable String sId){
//       System.err.println("bnc");
        return sprintService.getSprintById(sId);
    }
    @PutMapping("/add/{sId}")
    public SprintDto addTToSprint(@PathVariable String sId,@RequestBody AddTToSprintDto addToSprintDto){
        return sprintService.addTToSprint(sId, addToSprintDto);
    }

    @PutMapping("/remove/{sId}")
    public SprintDto removeTFromSprint(@PathVariable String sId, @RequestBody AddTToSprintDto addTToSprintDto){
        return sprintService.removeTFromSprint(sId,addTToSprintDto);
    }
    @GetMapping
    public List<SprintDto> getAllSprints(){
        return sprintService.getAllSprints();
    }
}
