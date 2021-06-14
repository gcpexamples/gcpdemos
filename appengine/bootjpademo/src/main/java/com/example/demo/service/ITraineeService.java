package com.example.demo.service;

import com.example.demo.dto.CreateTraineeRequest;
import com.example.demo.dto.TraineeDetails;
import com.example.demo.entities.Trainee;

public interface ITraineeService {

   TraineeDetails addTrainee(CreateTraineeRequest requestData);

   TraineeDetails findById(long id);

}
