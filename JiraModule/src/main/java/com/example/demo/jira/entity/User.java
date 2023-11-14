package com.example.demo.jira.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.security.cert.CertPathBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection="user")
public class User {
    @Id
    private String userId;
    private String userName;
    private String emailId;
}
