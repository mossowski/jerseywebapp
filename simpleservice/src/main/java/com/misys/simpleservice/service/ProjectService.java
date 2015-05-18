package com.misys.simpleservice.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.misys.simpleservice.database.Database;
import com.misys.simpleservice.model.Person;
import com.misys.simpleservice.model.Project;

public class ProjectService implements ProjectServiceInterface {

private Map<Long, Project> projects = Database.getProjects();
	
	public ProjectService() {
		projects.put(1L, new Project(1, "Project 1", Collections.<Person>emptyList()));
		projects.put(2L, new Project(2, "Project 2", Collections.<Person>emptyList()));
		projects.put(3L, new Project(3, "Project 3", Collections.<Person>emptyList()));
	}
	
	public List<Project> getAllProjects() {
		return new ArrayList<Project>(projects.values());
	}
	
	public Project getProject(long id) {
		return projects.get(id);
	}
	
	public Project addProject(Project project) {
		project.setId(projects.size() + 1);
		projects.put(project.getId(), project);
		return project;
	}
	
	public Project updateProject(Project project) {
		if (project.getId() <= 0) {
			return null;
		}
		projects.put(project.getId(), project);
		return project;
	}
	
	public Project deleteProject(long id) {
		return projects.remove(id);
	}	
	
}
