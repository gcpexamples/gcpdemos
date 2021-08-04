package com.example.apps.projectsms.service;

import com.example.apps.projectsms.dao.IProjectRepository;
import com.example.apps.projectsms.dto.CreateProjectRequest;
import com.example.apps.projectsms.dto.ProjectDetails;
import com.example.apps.projectsms.dto.UpdateProjectNameRequest;
import com.example.apps.projectsms.entities.Project;
import com.example.apps.projectsms.exceptions.ProjectNotFoundException;
import com.example.apps.projectsms.util.ProjectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Service
public class ProjectServiceImpl implements IProjectService{

    @Autowired
    private IProjectRepository repository;

    @Autowired
    private ProjectUtil projectUtil;

    @Override
    public ProjectDetails add(CreateProjectRequest request) {
        Project project = new Project(request.getName());
        project.setCost(request.getCost());
        Project saved= repository.save(project);
        ProjectDetails details= projectUtil.toProjectDetails(project);
        return details;
    }

    @Override
    public ProjectDetails findProjectDetailsById(Long id){
       Project project= findProjectById(id);
       ProjectDetails details= projectUtil.toProjectDetails(project);
       return details;
    }

    @Override
    public Project findProjectById(Long id){
       Optional<Project> optional= repository.findById(id);
        if(!optional.isPresent()){
            throw new ProjectNotFoundException("proejct not found for id="+id);
        }
        return optional.get();
    }

    @Override
    public ProjectDetails updateProjectName(UpdateProjectNameRequest request) {
        Project project = findProjectById(request.getId());
        project.setName(request.getName());
        Project saved=repository.save(project);
        ProjectDetails details= projectUtil.toProjectDetails(project);
        return details;
    }

    @Override
    public ProjectDetails findBestProject(){
       Project project= repository.findFirstByOrderByCostDesc();
       ProjectDetails desired=projectUtil.toProjectDetails(project);
       return desired;
    }
}
