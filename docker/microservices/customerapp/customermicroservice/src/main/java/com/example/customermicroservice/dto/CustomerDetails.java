package com.example.customermicroservice.dto;

import java.util.Set;

public class CustomerDetails {

    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private Set<ProductDetails> products;

    public Set<ProductDetails> getProducts() {
        return products;
    }

    public void setProducts(Set<ProductDetails> products) {
        this.products = products;
    }
}
