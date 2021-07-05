package com.example.empms.controllers;


import com.example.empms.dto.AddEmployeeRequest;
import com.example.empms.dto.AssignDepartmentRequest;
import com.example.empms.dto.DepartmentDetails;
import com.example.empms.dto.EmployeeDetails;
import com.example.empms.entities.Employee;
import com.example.empms.services.IEmployeeService;
import com.example.empms.util.EmployeeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("/employees")
@RestController
public class EmployeeController {

    private static  final Logger Log= LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private IEmployeeService service ;

    @Autowired
    private EmployeeUtil empUtil;


    private  DepartmentDetails cachedTopDepartment;


    public void setCachedTopDepartment(DepartmentDetails dept){
        this.cachedTopDepartment=dept;
    }

    public DepartmentDetails getCachedTopDepartment(){
        Log.info("***inside getCachedTopDepartment");
        return cachedTopDepartment;
    }

    @GetMapping("/byid/{id}")
    public EmployeeDetails fetchEmployeeById(@PathVariable Long id){
        return service.findEmployeeDetailsById(id);
    }

    @PostMapping("/add")
    public EmployeeDetails add(@RequestBody AddEmployeeRequest request){
        return service.add(request);
    }

    @PutMapping("/assign/dept")
    public EmployeeDetails assignDepartment(@RequestBody  AssignDepartmentRequest request){
       return  service.assignDepartment(request);
    }




}
