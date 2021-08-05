package com.example.productmsmicroservice.service;

import com.example.productmsmicroservice.dto.AddProductRequest;
import com.example.productmsmicroservice.dto.ProductDetails;
import com.example.productmsmicroservice.entities.Product;
import com.example.productmsmicroservice.exceptions.ProductNotFoundException;
import com.example.productmsmicroservice.repositories.IProductRepository;
import com.example.productmsmicroservice.util.ProductUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Transactional
@Service
public class ProductServiceImpl implements IProductService{

    @Autowired
    private IProductRepository productRepo;

    @Autowired
    private ProductUtil productUtil;

    @Override
    public ProductDetails add(AddProductRequest requestData) {
        Product product=new Product();
        product.setName(requestData.getName());
        product.setUnits(requestData.getUnits());
        LocalDateTime now=LocalDateTime.now();
        product.setAddedDateTime(now);
        product=productRepo.save(product);
        ProductDetails desired=productUtil.toDetails(product);
        return desired;
    }

    public Product findById(Long id){
        Optional<Product> optional=productRepo.findById(id);
        if(!optional.isPresent()){
            throw new ProductNotFoundException("product not found for id="+id);
        }
        return optional.get();
    }

    @Override
    public ProductDetails findProductDetailsById(Long id) {
       Product product= findById(id);
       ProductDetails desired=productUtil.toDetails(product);
        return desired;
    }

    @Override
    public ProductDetails newestProduct() {
       Product product=  productRepo.findFirstByOrderByAddedDateTimeDesc();
        ProductDetails desired=productUtil.toDetails(product);
        return desired;
    }
}
