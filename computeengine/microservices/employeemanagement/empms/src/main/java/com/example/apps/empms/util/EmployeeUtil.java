package com.example.apps.empms.util;

import com.example.apps.empms.dto.EmployeeDetails;
import com.example.apps.empms.dto.ProjectDetails;
import com.example.apps.empms.entities.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class EmployeeUtil {

    public EmployeeDetails toDetails(Employee employee, ProjectDetails project){
        EmployeeDetails details=new EmployeeDetails();
        details.setId(employee.getId());
        details.setName(employee.getName());
        details.setSalary(employee.getSalary());
        details.setProjectId(employee.getProjectId());
        if(project!=null) {
            details.setProjectName(project.getName());
        }
        return details;
    }


    public List<EmployeeDetails> toDetailsList(Collection<Employee> employees, ProjectDetails project){
      /*
      same job using stream api
        List<EmployeeDetails>des= employees.stream()
               .map(emp->toDetails(emp,project))
               .collect(Collectors.toList());
       */

        List<EmployeeDetails>desired=new ArrayList<>();
        for(Employee  employee:employees){
          EmployeeDetails details  =toDetails(employee,project);
           desired.add(details);
        }
        return desired;

    }


}
