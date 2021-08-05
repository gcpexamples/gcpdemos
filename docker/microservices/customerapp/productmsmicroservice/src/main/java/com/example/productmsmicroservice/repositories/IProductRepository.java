package com.example.productmsmicroservice.repositories;

import com.example.productmsmicroservice.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IProductRepository extends JpaRepository<Product, Long> {

   //@Query("from Product order by addedDateTime limit 1")
    Product findFirstByOrderByAddedDateTimeDesc();
}
