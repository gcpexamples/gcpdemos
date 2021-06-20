package com.example.bootjpademo.controllers;

import com.example.bootjpademo.dto.CreateTraineeRequest;
import com.example.bootjpademo.dto.TraineeDetails;
import com.example.bootjpademo.service.ITraineeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/trainees")
@RestController
public class TraineeController {

    @Autowired
    private ITraineeService service;



    @PostMapping("/add")
    public TraineeDetails add(@RequestBody CreateTraineeRequest requestData) {
        TraineeDetails response = service.addTrainee(requestData);
        return response;
    }

    @GetMapping("/byid/{id}")
    public TraineeDetails getTrainee(@PathVariable long id){
       TraineeDetails details =service.findById(id);
        return details;
    }

}
