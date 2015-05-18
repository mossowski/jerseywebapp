package com.misys.simpleservice.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.misys.simpleservice.model.Person;
import com.misys.simpleservice.service.PersonService;

@Path("search/persons")
public class PersonSearchResource {

	private PersonService personService = new PersonService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchForPersons(@QueryParam(value = "name") List<String> name) {
		System.out.println(name);
		
		List<Person> persons = personService.findByName(name);
		
		if (persons == null || persons.size() <= 0) {
			return Response.status(Status.NOT_FOUND).build();
		}
		
		return Response.ok().entity(new GenericEntity<List<Person>>(persons) {}).build();
	}
}
