package com.example.apps.projectsms.dao;

import com.example.apps.projectsms.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProjectRepository extends JpaRepository<Project,Long> {

    Project findFirstByOrderByCostDesc();


}
