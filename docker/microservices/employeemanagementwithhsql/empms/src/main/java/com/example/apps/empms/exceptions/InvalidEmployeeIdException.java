package com.example.apps.empms.exceptions;

public class InvalidEmployeeIdException extends RuntimeException{

    public InvalidEmployeeIdException(String msg){
        super(msg);
    }
}
