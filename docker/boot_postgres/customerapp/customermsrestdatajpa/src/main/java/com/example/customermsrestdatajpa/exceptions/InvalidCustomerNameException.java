package com.example.customermsrestdatajpa.exceptions;

public class InvalidCustomerNameException extends RuntimeException{

    public InvalidCustomerNameException(String msg){
        super(msg);
    }

}
