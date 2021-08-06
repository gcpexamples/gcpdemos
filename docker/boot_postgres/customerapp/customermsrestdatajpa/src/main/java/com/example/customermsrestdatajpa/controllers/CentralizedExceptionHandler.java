package com.example.customermsrestdatajpa.controllers;

import com.example.customermsrestdatajpa.exceptions.CustomerNotFoundException;
import com.example.customermsrestdatajpa.exceptions.InvalidCustomerNameException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CentralizedExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(CustomerNotFoundException.class)
    public String handleCustomerNotFound(CustomerNotFoundException e) {
        return e.getMessage();
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidCustomerNameException.class)
    public String handleInvalidCustomerNameException(InvalidCustomerNameException e){
        return e.getMessage();
    }

}
