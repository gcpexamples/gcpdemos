package com.example.empms.util;

import com.example.empms.dto.DepartmentDetails;
import com.example.empms.dto.EmployeeDetails;
import com.example.empms.entities.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployeeUtil {

    private static final Logger Log= LoggerFactory.getLogger(EmployeeUtil.class);

    @Autowired
    private RestTemplate restTemplate;

    @Value("${department.baseUrl}")
    private  String departmentBaseUrl;


    public EmployeeDetails toDetails(Employee employee,DepartmentDetails details) {
        EmployeeDetails desired = new EmployeeDetails();
        desired.setId(employee.getId());
        desired.setName(employee.getName());
        desired.setDepartmentId(employee.getDepartmentId());
        if(details!=null) {
            desired.setDeptName(details.getName());
        }
        return desired;
    }

    public List<EmployeeDetails> toDetails(Collection<Employee>employees, DepartmentDetails dept){
     return    employees.stream().
                map(emp->toDetails(emp,dept))
                        .collect(Collectors.toList());

    }

    public DepartmentDetails fetchDepartment(Long deptId) {
        if(deptId==null || deptId<=0){
            return null;
        }
        String url = departmentBaseUrl+"/departments/byid/"+deptId;
        DepartmentDetails details=restTemplate.getForObject(url, DepartmentDetails.class);
        return details;
    }

    public DepartmentDetails fetchTopDepartment(){
        String url = departmentBaseUrl+"/departments/top";
        DepartmentDetails dept=restTemplate.getForObject(url, DepartmentDetails.class);
        return dept;

    }



}
