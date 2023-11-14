package com.example.demo.jira.entity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.security.cert.CertPathBuilder;
import java.time.LocalDate;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collation="sprint")

public class Sprint {
    @Id
    private String sprintId;
    private String sprintName;
    private List<String> taskIds;
    private LocalDate startDate;
    private LocalDate endDate;
}
