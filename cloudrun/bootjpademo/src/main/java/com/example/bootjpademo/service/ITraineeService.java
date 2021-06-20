package com.example.bootjpademo.service;

import com.example.bootjpademo.dto.CreateTraineeRequest;
import com.example.bootjpademo.dto.TraineeDetails;

public interface ITraineeService {

   TraineeDetails addTrainee(CreateTraineeRequest requestData);

   TraineeDetails findById(long id);

}
