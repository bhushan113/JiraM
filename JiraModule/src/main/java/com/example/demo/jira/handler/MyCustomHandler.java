package com.example.demo.jira.handler;

import com.example.demo.jira.exception.SprintNotFound;
import com.example.demo.jira.exception.TaskNotFound;
import com.example.demo.jira.exception.UserNotFound;
import com.example.demo.jira.response.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class MyCustomHandler {

    @ExceptionHandler({UserNotFound.class})
    public ResponseEntity<ErrorResponse> handleTaskNotFoundException(UserNotFound ex) {
        return ResponseEntity.ok(ErrorResponse.builder().error(true).message(ex.getMessage()).build());
    }

    @ExceptionHandler({TaskNotFound.class})
    public ResponseEntity<ErrorResponse> handleTaskNotFoundException(TaskNotFound ex) {
        return ResponseEntity.ok(ErrorResponse.builder().error(true).message(ex.getMessage()).build());
    }

    @ExceptionHandler({SprintNotFound.class})
    public ResponseEntity<ErrorResponse> handleTaskNotFoundException(SprintNotFound ex) {
        return ResponseEntity.ok(ErrorResponse.builder().error(true).message(ex.getMessage()).build());
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<ErrorResponse> handleGlobalException(Exception ex, WebRequest request) {
        return ResponseEntity.ok(ErrorResponse.builder().error(true).message(ex.getMessage()).build());
    }

}
