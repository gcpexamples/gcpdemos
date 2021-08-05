package com.example.customermsrestdatajpa.service;

import com.example.customermsrestdatajpa.dto.CreateCustomerRequest;
import com.example.customermsrestdatajpa.dto.CustomerDetails;
import com.example.customermsrestdatajpa.dto.UpdateCustomerRequest;
import com.example.customermsrestdatajpa.entities.Customer;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Validated
public interface ICustomerService {

    CustomerDetails add(@NotNull @Valid CreateCustomerRequest request);

    CustomerDetails findCustomerDetailsById(@NotNull @Min(1) Long id);

    CustomerDetails update(@NotNull @Valid UpdateCustomerRequest request);

    void deleteById(@NotNull @Min(1) Long id);

    List<CustomerDetails> findAll();

    List<CustomerDetails> findCustomerDetailsByName(@NotBlank @Length(min = 1,max=20)String name);
}
