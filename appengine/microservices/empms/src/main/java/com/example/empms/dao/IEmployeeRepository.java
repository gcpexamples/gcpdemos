package com.example.empms.dao;

import com.example.empms.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IEmployeeRepository extends JpaRepository<Employee,Long> {

    List<Employee> findByDepartmentId(Long deptId);


}
