package com.example.customermsrestdatajpa.exceptions;

public class CustomerNotFoundException extends RuntimeException{

    public CustomerNotFoundException(String msg){
        super(msg);
    }

}
