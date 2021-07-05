package com.example.empms.services;

import com.example.empms.dao.IEmployeeRepository;
import com.example.empms.dto.AssignDepartmentRequest;
import com.example.empms.dto.AddEmployeeRequest;
import com.example.empms.dto.DepartmentDetails;
import com.example.empms.dto.EmployeeDetails;
import com.example.empms.entities.Employee;
import com.example.empms.exceptions.EmployeeNotFoundException;
import com.example.empms.util.EmployeeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private IEmployeeRepository employeeRepo;

    @Autowired
    private EmployeeUtil employeeUtil;

    @Override
    public EmployeeDetails add(AddEmployeeRequest requestData) {
        Employee employee = new Employee();
        employee.setName(requestData.getName());
        employee = employeeRepo.save(employee);
        DepartmentDetails deptDetails = employeeUtil.fetchDepartment(employee.getDepartmentId());
        EmployeeDetails desired = employeeUtil.toDetails(employee, deptDetails);
        return desired;
    }

    public Employee findEmployeeById(Long id) {
        Optional<Employee> optional = employeeRepo.findById(id);
        if (!optional.isPresent()) {
            throw new EmployeeNotFoundException("employee not found for id=" + id);
        }
        return optional.get();

    }

    @Override
    public EmployeeDetails findEmployeeDetailsById(Long id) {
        Employee employee = findEmployeeById(id);
        DepartmentDetails deptDetails = employeeUtil.fetchDepartment(employee.getDepartmentId());
        EmployeeDetails desired = employeeUtil.toDetails(employee, deptDetails);
        return desired;
    }

    @Override
    public EmployeeDetails assignDepartment(AssignDepartmentRequest request) {
        Employee employee = findEmployeeById(request.getEmployeeId());
        employee.setDepartmentId(request.getDepartmentId());
        employeeRepo.save(employee);
        DepartmentDetails deptDetails = employeeUtil.fetchDepartment(employee.getDepartmentId());
        return employeeUtil.toDetails(employee, deptDetails);
    }

    @Override
    public List<EmployeeDetails> findEmployeesDetailsByDeptId(Long deptId) {
        List<Employee> list = employeeRepo.findByDepartmentId(deptId);
        DepartmentDetails deptDetails = employeeUtil.fetchDepartment(deptId);
        return employeeUtil.toDetails(list, deptDetails);
    }

    @Override
    public List<Employee> findEmployeesByDeptId(Long deptId) {
        List<Employee> list = employeeRepo.findByDepartmentId(deptId);
        return list;
    }

}
