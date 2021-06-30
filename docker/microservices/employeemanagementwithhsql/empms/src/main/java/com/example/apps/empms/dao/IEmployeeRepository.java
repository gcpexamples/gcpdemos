package com.example.apps.empms.dao;

import com.example.apps.empms.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IEmployeeRepository extends JpaRepository<Employee,Integer> {
    List<Employee>findByName(String name);

    List<Employee>findByNameAndSalary(String name, double salary);

    List<Employee>findByProjectId(long projectId);

}
