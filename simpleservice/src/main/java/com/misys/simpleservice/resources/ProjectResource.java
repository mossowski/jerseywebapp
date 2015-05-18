package com.misys.simpleservice.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.misys.simpleservice.model.Person;
import com.misys.simpleservice.model.Project;
import com.misys.simpleservice.service.ProjectService;

@Path("/projects")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProjectResource {

	ProjectService projectService = new ProjectService();
	
	@GET
	public List<Project> getProjects() {
		return projectService.getAllProjects();
	}
	
	@GET
	@Path("/{projectId}")
	public Project getProject(@PathParam("projectId") long projectId) {
		return projectService.getProject(projectId);
	}
	
	@GET
	@Path("/{projectId}/persons")
	public List<Person> getProjectPersons(@PathParam("projectId") long projectId) {
		return projectService.getProject(projectId).getPersons();
	}
	
	@POST
	public Project addProject(Project project) {
		return projectService.addProject(project);
	}
	
	@PUT
	@Path("/{projectId}")
	public Project updateProject(@PathParam("projectId") long projectId, Project project) {
		project.setId(projectId);
		return projectService.updateProject(project);
	}
	
	@DELETE
	@Path("/{projectId}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteProject(@PathParam("projectId") long projectId) {
		projectService.deleteProject(projectId);
	}
}
