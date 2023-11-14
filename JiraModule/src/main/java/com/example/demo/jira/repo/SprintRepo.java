package com.example.demo.jira.repo;

import com.example.demo.jira.entity.Sprint;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SprintRepo extends MongoRepository<Sprint, String> {}
