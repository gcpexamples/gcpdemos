package com.example.customerms.exceptions;

public class InvalidCustomerNameException extends RuntimeException{

    public InvalidCustomerNameException(String msg){
        super(msg);
    }

}
