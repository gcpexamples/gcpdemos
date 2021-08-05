package com.example.customermicroservice.util;

import com.example.customermicroservice.dto.CustomerDetails;
import com.example.customermicroservice.dto.ProductDetails;
import com.example.customermicroservice.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Component
public class CustomerUtil {

    @Value("${product.baseurl}")
    private String productBaseUrl;

    @Autowired
    private RestTemplate restTemplate;

    public CustomerDetails toDetails(Customer customer) {
        CustomerDetails desired = new CustomerDetails();
        desired.setId(customer.getId());
        desired.setName(customer.getName());
        if(customer.getProducts()!=null) {
            Set<Long>productsId=customer.getProducts();
            Set<ProductDetails>detailsSet=fetchManyProductDetails(productsId);
            desired.setProducts(detailsSet);
        }
        return desired;
    }

    public List<CustomerDetails> toDetailsList(Collection<Customer> customers) {
        //  return  customers.stream()
        //           .map(customer->toDetails(customer))
        //          .collect(Collectors.toList());
        List<CustomerDetails> desired = new ArrayList<>();
        for (Customer customer : customers) {
            CustomerDetails details = toDetails(customer);
            desired.add(details);
        }
        return desired;
    }

    public Set<ProductDetails>fetchManyProductDetails(Collection<Long>productsId){
        Set<ProductDetails>set=new HashSet<>();
        for (Long productId:productsId){
           ProductDetails details= fetchProductDetails(productId);
           set.add(details);
        }
        return set;
    }

    public ProductDetails fetchProductDetails(Long productId){
        String url=productBaseUrl+"/products/byid/"+productId;
        ProductDetails details=restTemplate.getForObject(url,ProductDetails.class);
       return details;
    }

    public ProductDetails fetchLatestProduct(){
        String url=productBaseUrl+"/products/latest";
        ProductDetails details=restTemplate.getForObject(url,ProductDetails.class);
        return details;
    }


}
