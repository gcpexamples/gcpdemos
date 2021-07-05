package com.example.empms.services;

import com.example.empms.dto.AssignDepartmentRequest;
import com.example.empms.dto.AddEmployeeRequest;
import com.example.empms.dto.EmployeeDetails;
import com.example.empms.entities.Employee;

import java.util.List;

public interface IEmployeeService {

     EmployeeDetails add(AddEmployeeRequest requestData);

     EmployeeDetails findEmployeeDetailsById(Long id);

     EmployeeDetails assignDepartment(AssignDepartmentRequest request);

     List<EmployeeDetails> findEmployeesDetailsByDeptId(Long deptId);

     List<Employee> findEmployeesByDeptId(Long deptId);
}
