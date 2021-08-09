package com.example.customermsrestdatajpa.service;

import com.example.customermsrestdatajpa.dao.ICustomerRepository;
import com.example.customermsrestdatajpa.dto.CreateCustomerRequest;
import com.example.customermsrestdatajpa.dto.CustomerDetails;
import com.example.customermsrestdatajpa.dto.UpdateCustomerRequest;
import com.example.customermsrestdatajpa.entities.Customer;
import com.example.customermsrestdatajpa.exceptions.CustomerNotFoundException;
import com.example.customermsrestdatajpa.exceptions.InvalidCustomerIdException;
import com.example.customermsrestdatajpa.exceptions.InvalidCustomerNameException;
import com.example.customermsrestdatajpa.util.CustomerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Transactional
@Service
public class CustomerServiceImpl implements ICustomerService {
   private static final Logger Log= LoggerFactory.getLogger(CustomerServiceImpl.class);

    @Autowired
    private ICustomerRepository customerRepo;

    @Autowired
    private CustomerUtil customerUtil;

   
    @Override
    public CustomerDetails add(CreateCustomerRequest request) {
        validate(request);
        Customer customer = newCustomer();
        customer.setName(request.getName());
        LocalDate today=currentDate();
        customer.setCreatedDate(today);
        customer = customerRepo.save(customer);
        CustomerDetails desired = customerUtil.toDetails(customer);
        return desired;
    }

    public LocalDate currentDate(){
        return LocalDate.now();
    }

    public Customer newCustomer(){
        return new Customer();
    }

    public void validate(CreateCustomerRequest request){
        if(request.getName()==null ||request.getName().isEmpty() || request.getName().length()>20){
            throw new InvalidCustomerNameException("invalid customer name");
        }
    }

    public Customer findById(Long id) {
        Log.debug("inside findbyid="+id);
        Optional<Customer> optional =customerRepo.findById(id);
        if(!optional.isPresent()){
            throw new CustomerNotFoundException("customer not found for id="+id);
        }
        Customer customer= optional.get();
        return customer;
    }

    @Override
    public CustomerDetails findCustomerDetailsById(Long id) {
        Customer customer = findById(id);
        CustomerDetails desired = customerUtil.toDetails(customer);
        return desired;
    }



    @Override
    public CustomerDetails update(UpdateCustomerRequest request) {
        Customer customer = findById(request.getId());
        customer.setName(request.getName());
        customer = customerRepo.save(customer);
        CustomerDetails response = customerUtil.toDetails(customer);
        return response;
    }

    @Override
    public void deleteById(Long id) {
        customerRepo.deleteById(id);
    }

    @Override
    public List<CustomerDetails> findAll() {
        List<Customer> list = customerRepo.findAll();
        List<CustomerDetails>desired=customerUtil.toDetailsList(list);
        return desired;
    }

    @Override
    public List<CustomerDetails> findCustomerDetailsByName(String name) {
       List<Customer>customers= customerRepo.findByName(name);
       List<CustomerDetails>desired=customerUtil.toDetailsList(customers);
        return desired;
    }
}
