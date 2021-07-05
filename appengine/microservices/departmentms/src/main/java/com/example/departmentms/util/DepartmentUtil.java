package com.example.departmentms.util;

import com.example.departmentms.dto.DepartmentDetails;
import com.example.departmentms.entities.Department;
import org.springframework.stereotype.Component;

@Component
public class DepartmentUtil {

    public DepartmentDetails toDetails(Department dept){
        DepartmentDetails details=new DepartmentDetails();
        details.setName(dept.getName());
        details.setId(dept.getId());
        details.setRating(dept.getRating());
        return details;
    }

}
