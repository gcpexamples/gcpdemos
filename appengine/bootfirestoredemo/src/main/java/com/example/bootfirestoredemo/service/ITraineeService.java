package com.example.bootfirestoredemo.service;

import com.example.bootfirestoredemo.entities.Trainee;
import org.springframework.stereotype.Service;

@Service
public interface ITraineeService {

    Trainee findTraineeById(String id) throws Exception;
}
