package com.example.bootfirestoredemo.service;

import com.example.bootfirestoredemo.entities.Trainee;
import com.example.bootfirestoredemo.dao.ITraineeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TraineeServiceImpl implements ITraineeService{

    @Autowired
    private ITraineeDao traineeDao;

    @Override
    public Trainee findTraineeById(String id) throws Exception {
        return traineeDao.findTraineeById(id);
    }
}
