package com.example.bootfirestoredemo.dao;

import com.example.bootfirestoredemo.entities.Trainee;

public interface ITraineeDao {

    Trainee findTraineeById(String id) throws Exception;
}
