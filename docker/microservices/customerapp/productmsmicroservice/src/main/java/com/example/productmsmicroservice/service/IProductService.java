package com.example.productmsmicroservice.service;

import com.example.productmsmicroservice.dto.AddProductRequest;
import com.example.productmsmicroservice.dto.ProductDetails;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Validated
public interface IProductService {

    ProductDetails add(@NotNull @Valid AddProductRequest requestData);

    ProductDetails findProductDetailsById(@NotNull @Min(1) Long id);

    ProductDetails newestProduct();

}
