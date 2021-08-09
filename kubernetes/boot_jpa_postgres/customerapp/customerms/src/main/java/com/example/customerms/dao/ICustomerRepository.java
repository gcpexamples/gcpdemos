package com.example.customerms.dao;

import com.example.customerms.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICustomerRepository extends JpaRepository<Customer,Long>{

    List<Customer>findByName(String name);
    //if name is unique
    //Customer findCustomerByName(String name);
}
