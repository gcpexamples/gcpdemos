package com.example.demo.repositories;

import com.example.demo.entities.Trainee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITraineeRepository extends JpaRepository<Trainee, Long> {
}
