package com.example.apps.projectsms.service;

import com.example.apps.projectsms.dto.CreateProjectRequest;
import com.example.apps.projectsms.dto.ProjectDetails;
import com.example.apps.projectsms.dto.UpdateProjectNameRequest;
import com.example.apps.projectsms.entities.Project;

public interface IProjectService {

    ProjectDetails add(CreateProjectRequest request);

    ProjectDetails updateProjectName(UpdateProjectNameRequest request);

    Project findProjectById(Long id);

    ProjectDetails findProjectDetailsById(Long id);

    ProjectDetails findBestProject();
}
