package com.example.apps.empms.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class UpdateSalaryRequest {

    @Min(1)
    private int id;

    @Max(400000)
    @Min(15000)
    private double salary;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
