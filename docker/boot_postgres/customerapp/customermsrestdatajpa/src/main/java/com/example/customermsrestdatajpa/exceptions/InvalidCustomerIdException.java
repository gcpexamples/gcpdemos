package com.example.customermsrestdatajpa.exceptions;

public class InvalidCustomerIdException extends RuntimeException{
    public InvalidCustomerIdException(String msg) {
        super(msg);
    }
}
