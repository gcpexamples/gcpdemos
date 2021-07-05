package com.example.departmentms.repository;


import com.example.departmentms.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IDepartmentRepository extends JpaRepository<Department, Long> {

    Department findFirstByOrderByRatingDesc();

}
