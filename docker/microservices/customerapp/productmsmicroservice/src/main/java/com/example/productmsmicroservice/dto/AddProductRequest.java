package com.example.productmsmicroservice.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class AddProductRequest {
    @Length(min=1, max=20)
    @NotBlank
    private String name;

    @Min(1)
    private int units;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    private double rating;


}
