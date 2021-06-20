package com.example.bootjpademo.repositories;

import com.example.bootjpademo.entities.Trainee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITraineeRepository extends JpaRepository<Trainee, Long> {
}
