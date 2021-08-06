package com.example.customermsrestdatajpa.controllers;

import com.example.customermsrestdatajpa.dto.CreateCustomerRequest;
import com.example.customermsrestdatajpa.dto.CustomerDetails;
import com.example.customermsrestdatajpa.dto.UpdateCustomerRequest;
import com.example.customermsrestdatajpa.service.ICustomerService;
import com.example.customermsrestdatajpa.util.CustomerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/customers")
@RestController
public class CustomerRestController {

    @Autowired
    private ICustomerService service;

    @Autowired
    private CustomerUtil customerUtil;

    /**
     * /customers/byid/5
     */

    // @RequestMapping(method=RequestMethod.GET, path = "/byid/{id}")
    @GetMapping("/byid/{id}")
    public CustomerDetails fetchCustomerById( @PathVariable("id") Long id) {
        CustomerDetails response = service.findCustomerDetailsById(id);
        return response;
    }


    /*

    //Using ResponseEntity, Old way, might be useful when response headers have to be added in response

    @GetMapping("/byid/{id}")
    public ResponseEntity<CustomerDetails> fetchCustomerById(@PathVariable("id") Long id) {
        CustomerDetails result = service.findCustomerDetailsById(id);
        ResponseEntity<CustomerDetails>response=new ResponseEntity<>(result,HttpStatus.OK);
        return response;
    }
*/


    @GetMapping("/byname/{name}")
    public List<CustomerDetails>fetchByName(@PathVariable String name){
      List<CustomerDetails>response  =service.findCustomerDetailsByName(name);
      return response;
    }

    /**
     * /customers
     */
    @GetMapping
    public List<CustomerDetails> fetchAll() {
        List<CustomerDetails> response = service.findAll();
        return response;
    }

    /**
     * /customers/add
     */
   // @RequestMapping(method=RequestMethod.POST, path="/add")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/add")
    public CustomerDetails addCustomer(@RequestBody CreateCustomerRequest requestData) {
        CustomerDetails desired = service.add(requestData);
        return desired;
    }

    /**
     * /customers/update
     */
    @PutMapping("/update")
    public CustomerDetails updateCustomer(@RequestBody UpdateCustomerRequest requestData) {
        CustomerDetails response = service.update(requestData);
        return response;
    }


    @DeleteMapping("/delete/byid/{id}")
    public String deleteCustomer(@PathVariable Long id) {
        service.deleteById(id);
        return "deleted customer with id=" + id;
    }


}
