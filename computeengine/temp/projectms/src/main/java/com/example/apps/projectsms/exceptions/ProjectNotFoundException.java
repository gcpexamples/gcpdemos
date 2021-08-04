package com.example.apps.projectsms.exceptions;

public class ProjectNotFoundException extends RuntimeException{

    public ProjectNotFoundException(String msg){
        super(msg);
    }
}
