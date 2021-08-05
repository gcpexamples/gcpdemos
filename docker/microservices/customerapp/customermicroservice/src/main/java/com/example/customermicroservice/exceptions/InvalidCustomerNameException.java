package com.example.customermicroservice.exceptions;

public class InvalidCustomerNameException extends RuntimeException{

    public InvalidCustomerNameException(String msg){
        super(msg);
    }

}
