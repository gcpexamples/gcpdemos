package com.example.departmentms.service;

import com.example.departmentms.dto.AddDepartmentRequest;
import com.example.departmentms.dto.DepartmentDetails;
import com.example.departmentms.entities.Department;
import com.example.departmentms.excepltions.DepartmentNotFoundException;
import com.example.departmentms.repository.IDepartmentRepository;
import com.example.departmentms.util.DepartmentUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentServiceImpl implements IDepartmentService{

    @Autowired
    private IDepartmentRepository deptRepo;

    @Autowired
    private DepartmentUtil deptUtil;

    @Override
    public DepartmentDetails add(AddDepartmentRequest requestData) {
        Department dept=new Department();
        dept.setName(requestData.getName());
        dept.setRating(requestData.getRating());
        dept=deptRepo.save(dept);
        return deptUtil.toDetails(dept);

    }

    public Department findDepartmentById(Long id){
       Optional<Department> optional=  deptRepo.findById(id);
       if(!optional.isPresent()){
           throw  new DepartmentNotFoundException("department not found for id="+id);
       }
       return optional.get();
    }

    @Override
    public DepartmentDetails findDepartmentDetailsById(Long id) {
        Department dept=findDepartmentById(id);
        DepartmentDetails desired=deptUtil.toDetails(dept);
        return desired;
    }

    @Override
    public DepartmentDetails findTopDepartment(){
      Department dept  =deptRepo.findFirstByOrderByRatingDesc();
      return  deptUtil.toDetails(dept);
    }

}
