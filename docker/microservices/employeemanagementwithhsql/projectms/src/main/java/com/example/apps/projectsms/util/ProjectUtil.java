package com.example.apps.projectsms.util;

import com.example.apps.projectsms.dto.ProjectDetails;
import com.example.apps.projectsms.entities.Project;
import org.springframework.stereotype.Component;

@Component
public class ProjectUtil {


    public ProjectDetails toProjectDetails(Project project){
        ProjectDetails details=new ProjectDetails();
        details.setId(project.getId());
        details.setName(project.getName());
        return details;
    }

}
