package com.example.demo.jira.repo;
import com.example.demo.jira.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepo extends MongoRepository<User, String> {
}

