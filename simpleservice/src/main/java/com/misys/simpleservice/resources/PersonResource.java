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
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.misys.simpleservice.model.Person;
import com.misys.simpleservice.model.Project;
import com.misys.simpleservice.service.PersonService;


@Path("/persons")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PersonResource {

	PersonService personService = new PersonService();
	
	@GET
	public List<Person> getPersons() {
		return personService.getAllPersons();
	}
	
	/*@GET
	@Path("/{personId}")
	public Person getPerson(@PathParam("personId") long personId) {
		System.out.println("Getting person ID : " + personId);
		
		return personService.getPerson(personId);
	}*/
	
	@GET
	@Path("/{personId}")
	public Response getPerson(@PathParam("personId") long personId) {
		System.out.println("Getting person ID : " + personId);
		
		Person person = personService.getPerson(personId);
		
		if (person == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		
		return Response.ok().entity(person).build();
	}
	
	@GET
	@Path("/{personId}/projects")
	public List <Project> getPersonProjects(@PathParam("personId") long personId) {
		return personService.getPerson(personId).getProjects();
	}
	
	@POST
	public Person addPerson(Person person) {
		return personService.addPerson(person);
	}
	
	/*@PUT
	@Path("/{personId}")
	public Person updatePerson(@PathParam("personId") long personId, Person person) {
		person.setId(personId);
		return personService.updatePerson(person);
	}*/
	
	@PUT
	@Path("/{personId}")
	public Response updatePerson(@PathParam("personId") long personId) {
		System.out.println("Getting person update ID : " + personId);
		
		Person person = personService.getPerson(personId);
		
		if (person == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		
		personService.updatePerson(person);
		
		return Response.ok().entity(person).build();
	}
	
	
	/*@DELETE
	@Path("/{personId}")
	public void deletePerson(@PathParam("personId") long personId) {
		personService.deletePerson(personId);
	}*/
	
	@DELETE
	@Path("/{personId}")
	public Response deletePerson(@PathParam("personId") long personId) {
		personService.deletePerson(personId);
		
		return Response.ok().build();
	}
}
