package com.example.customermsrestdatajpa.controllers;

import com.example.customermsrestdatajpa.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataController {

    @Autowired
    private IService service;

    @GetMapping("/data/{entity}")
    public String tableData(@PathVariable("entity") String entity){
      return service.findAllRows(entity);
    }


}
