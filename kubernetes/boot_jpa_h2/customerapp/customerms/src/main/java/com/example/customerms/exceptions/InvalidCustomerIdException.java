package com.example.customerms.exceptions;

public class InvalidCustomerIdException extends RuntimeException{
    public InvalidCustomerIdException(String msg) {
        super(msg);
    }
}
