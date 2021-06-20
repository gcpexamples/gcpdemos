package com.example.bootjpademo.service;

import com.example.bootjpademo.dto.CreateTraineeRequest;
import com.example.bootjpademo.dto.TraineeDetails;
import com.example.bootjpademo.entities.Trainee;
import com.example.bootjpademo.repositories.ITraineeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TraineeServiceImpl implements ITraineeService{

    @Autowired
    private ITraineeRepository repository;

    @Override
    public TraineeDetails addTrainee(CreateTraineeRequest request) {
        Trainee trainee=new Trainee();
        trainee.setName(request.getName());
        trainee=repository.save(trainee);
        TraineeDetails details=toDetails(trainee);
       return  details;
    }

    @Override
    public TraineeDetails findById(long id){
       Optional<Trainee>optional =repository.findById(id);
       if(!optional.isPresent()){

       }
       Trainee trainee= optional.get();
       TraineeDetails details=toDetails(trainee);
       return details;
    }

    public TraineeDetails toDetails(Trainee trainee){
        TraineeDetails details=new TraineeDetails();
        details.setId(trainee.getId());
        details.setName(trainee.getName());
        return details;
    }

}
