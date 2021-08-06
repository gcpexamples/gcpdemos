package com.example.customermsrestdatajpa.util;

import com.example.customermsrestdatajpa.dto.CustomerDetails;
import com.example.customermsrestdatajpa.entities.Customer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class CustomerUtil {

    public CustomerDetails toDetails(Customer customer) {
        CustomerDetails desired = new CustomerDetails();
        desired.setId(customer.getId());
        desired.setName(customer.getName());
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

}
