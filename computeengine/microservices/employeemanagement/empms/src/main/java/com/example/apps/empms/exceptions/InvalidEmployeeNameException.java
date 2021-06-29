package com.example.apps.empms.exceptions;

public class InvalidEmployeeNameException extends RuntimeException{

    public InvalidEmployeeNameException(String msg){
        super(msg);
    }

}
