package com.example.departmentms.excepltions;

public class DepartmentNotFoundException extends RuntimeException{

    public DepartmentNotFoundException() {
    }

    public DepartmentNotFoundException(String msg) {
        super(msg);
    }

}
