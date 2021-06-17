package com.example.bootfirestoredemo.controller;

import com.example.bootfirestoredemo.entities.Trainee;
import com.example.bootfirestoredemo.service.ITraineeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/trainees")
@RestController
public class TraineeController {

    @Autowired
    private ITraineeService traineeService;

    @GetMapping("/byid/{id}")
    public Trainee getTrainee(@PathVariable String id) throws Exception{
      return traineeService.findTraineeById(id);
    }

}
