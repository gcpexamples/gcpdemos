package com.example.apps.empms.controllers;

import com.example.apps.empms.exceptions.EmployeeNotFoundException;
import com.example.apps.empms.exceptions.InvalidEmployeeIdException;
import com.example.apps.empms.exceptions.InvalidEmployeeNameException;
import com.example.apps.empms.exceptions.InvalidSalaryException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * centralized exception handler
 */
@RestControllerAdvice
public class CentralizedExceptionHandler {

    /**
     *
     *
     * handles  EmployeeNotFoundException
     *
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(EmployeeNotFoundException.class)
    public String handleEmployeeNotFound(EmployeeNotFoundException e) {
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidEmployeeIdException.class)
    public String handleInvalidId(InvalidEmployeeIdException e){
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidEmployeeNameException.class)
    public String handleInvalidName(InvalidEmployeeNameException e){
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidSalaryException.class)
    public String handleInvalidSalary(InvalidSalaryException e){
        return e.getMessage();
    }


}
