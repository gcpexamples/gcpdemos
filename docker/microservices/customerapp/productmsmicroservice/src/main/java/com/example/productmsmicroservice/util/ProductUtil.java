package com.example.productmsmicroservice.util;

import com.example.productmsmicroservice.dto.ProductDetails;
import com.example.productmsmicroservice.entities.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductUtil {

    public ProductDetails toDetails(Product product){
        ProductDetails desired=new ProductDetails();
        desired.setId(product.getId());
        desired.setName(product.getName());
        return desired;
    }


}
