package com.example.apps.empms.service;

import com.example.apps.empms.entities.Employee;

import java.util.List;

public interface IEmployeeService {

    Employee add(String name, double salary);

    Employee changeSalary(int empId, double newSalary);

    Employee findById(int empId);

    List<Employee> findAll();

    List<Employee> findEmployeesByName(String name);

    List<Employee> findEmployeesByNameAndSalary(String name, double salary);

    void deleteById(int id);

    Employee addToProject(Integer empId, Long projectId);

    List<Employee>findEmployeesByProject(long projectId);
}
