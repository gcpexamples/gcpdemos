package com.example.departmentms.service;

import com.example.departmentms.dto.AddDepartmentRequest;
import com.example.departmentms.dto.DepartmentDetails;

public interface IDepartmentService {

    DepartmentDetails add(AddDepartmentRequest requestData);

    DepartmentDetails findDepartmentDetailsById(Long id);

    DepartmentDetails findTopDepartment();

}
