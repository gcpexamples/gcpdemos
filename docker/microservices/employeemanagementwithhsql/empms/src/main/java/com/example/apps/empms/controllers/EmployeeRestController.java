package com.example.apps.empms.controllers;

import com.example.apps.empms.dto.*;
import com.example.apps.empms.entities.Employee;
import com.example.apps.empms.service.IEmployeeService;
import com.example.apps.empms.util.EmployeeUtil;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@Api("employees")
@Validated
@RequestMapping("/employees")
@RestController
public class EmployeeRestController {
    private static final Logger Log = LoggerFactory.getLogger(EmployeeRestController.class);

    @Autowired
    private EmployeeUtil employeeUtil;

    @Autowired
    private IEmployeeService service;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${projectms.baseUrl}")
    private String baseProjectUrl;


    private ProjectDetails cachedTopProject;

    /**
     * effective uri  /employees/add
     **/
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/add")
    public EmployeeDetails addEmployee(@RequestBody @Valid CreateEmployeeRequest requestData) {
        Employee created = service.add(requestData.getName(), requestData.getSalary());
        ProjectDetails project = null;// at start project is not assigned
        EmployeeDetails response = employeeUtil.toDetails(created, project);
        return response;
    }

    @GetMapping("/byid/{id}")
    public EmployeeDetails getEmployee(@Min(1) @PathVariable("id") int id) {
        Employee employee = service.findById(id);
        Long projectId = employee.getProjectId();
        ProjectDetails project = null;
        if (projectId != null && projectId != 0) {
            project = fetchProjectDetails(projectId);
        }
        EmployeeDetails response = employeeUtil.toDetails(employee, project);
        return response;
    }


    @PutMapping("/update/salary")
    public EmployeeDetails update(@RequestBody @Valid UpdateSalaryRequest requestData) {
        Employee employee = service.changeSalary(requestData.getId(), requestData.getSalary());
        Long projectId = employee.getProjectId();
        ProjectDetails project = null;
        if (projectId != null && projectId != 0) {
            project = fetchProjectDetails(projectId);
        }
        EmployeeDetails response = employeeUtil.toDetails(employee, project);
        return response;
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@Min(1) @PathVariable("id") int empId) {
        service.deleteById(empId);
        return "employee deleted";

    }


    @PutMapping("/project/add")
    public EmployeeDetails addToProject(@RequestBody AddToProjectRequest request) {
        Log.info("****inside addToProject");
        long projectId = request.getProjectId();
        Log.info("****inside addToProject , poject id fetched=" + projectId);
        Employee employee = service.addToProject(request.getEmpId(), projectId);
        Log.info("****inside addtoproject, before fetching project details");
        ProjectDetails project = fetchProjectDetails(projectId);
        EmployeeDetails response = employeeUtil.toDetails(employee, project);
        return response;
    }


    public ProjectDetails fetchProjectDetails(long projectId) {
        Log.info("****insdie fetch project details");
        String url = baseProjectUrl + "/byid/" + projectId;
        Log.error("******inside fetchProjectDetails(*), url=" + url);
        ProjectDetails project = restTemplate.getForObject(url, ProjectDetails.class);
        Log.error("*** project fetched=" + project);
        return project;
    }


}
