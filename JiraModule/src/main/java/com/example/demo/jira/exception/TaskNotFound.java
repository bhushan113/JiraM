package com.example.demo.jira.exception;

public class TaskNotFound extends RuntimeException{
    public TaskNotFound(String msg){
        super(msg);
    }
}
