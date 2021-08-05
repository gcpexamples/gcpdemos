package com.example.productmsmicroservice.controllers;

import com.example.productmsmicroservice.dto.AddProductRequest;
import com.example.productmsmicroservice.dto.ProductDetails;
import com.example.productmsmicroservice.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/products")
@RestController
public class ProductController {

    @Autowired
    private IProductService productService;

    @PostMapping("/add")
    public ProductDetails add(@RequestBody AddProductRequest request) {
        ProductDetails response = productService.add(request);
        return response;
    }

    @GetMapping("/byid/{id}")
    public ProductDetails fetchProductById(@PathVariable Long id) {
        ProductDetails response = productService.findProductDetailsById(id);
        return response;
    }


    @GetMapping("/latest")
    public ProductDetails fetchTopProduct() {
        return productService.newestProduct();
    }


}
