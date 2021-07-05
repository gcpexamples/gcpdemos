package com.example.empms.exceptions;

public class EmployeeNotFoundException extends RuntimeException{

    public EmployeeNotFoundException(){
    }


    public EmployeeNotFoundException(String msg){
      super(msg);
    }
}
