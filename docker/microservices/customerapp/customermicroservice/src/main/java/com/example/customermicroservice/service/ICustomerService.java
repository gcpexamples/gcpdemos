package com.example.customermicroservice.service;

import com.example.customermicroservice.dto.CreateCustomerRequest;
import com.example.customermicroservice.dto.CustomerDetails;
import com.example.customermicroservice.dto.UpdateCustomerRequest;
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

    CustomerDetails buyProduct(@NotNull @Min(1)Long customerId,@NotNull @Min(1) Long productId);

}
