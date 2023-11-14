package com.example.demo.jira.exception;

public class UserNotFound extends RuntimeException{
    public UserNotFound(String msg){
        super(msg);
    }
}
