package com.misys.simpleservice.service;

import java.util.List;

import com.misys.simpleservice.model.Project;

public interface ProjectServiceInterface {

	List<Project> getAllProjects();

	Project getProject(long id);

	Project addProject(Project project);

	Project updateProject(Project project);

	Project deleteProject(long id);

}