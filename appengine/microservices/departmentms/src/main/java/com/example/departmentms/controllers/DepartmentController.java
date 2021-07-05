package com.example.departmentms.controllers;

import com.example.departmentms.dto.AddDepartmentRequest;
import com.example.departmentms.dto.DepartmentDetails;
import com.example.departmentms.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RequestMapping("departments")
@RestController
public class DepartmentController {

    @Autowired
    private IDepartmentService service;

    @GetMapping("/byid/{id}")
    public DepartmentDetails  fetchDepartmentById(@PathVariable Long id){
       return  service.findDepartmentDetailsById(id);
    }

    @PostMapping("/add")
    public DepartmentDetails add(@RequestBody AddDepartmentRequest request){
        return service.add(request);
    }

    @GetMapping("/top")
    public DepartmentDetails fetchTopDepartment(){
        return service.findTopDepartment();
    }


}
