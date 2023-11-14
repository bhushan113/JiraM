package com.example.demo.jira.exception;

public class SprintNotFound extends RuntimeException{
    public SprintNotFound(String msg){
        super(msg);
    }
}
