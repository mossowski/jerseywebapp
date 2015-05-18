package com.misys.simpleservice.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.misys.simpleservice.model.Person;

public class PersonClient {

	private Client client;
	
	public PersonClient () {
		client = ClientBuilder.newClient();
	}
	
	public Person get(long id) {
		
		WebTarget target = client.target("http://localhost:8080/simpleservice/webapi/");
		
		Response response = target.path("persons/" + id).request(MediaType.APPLICATION_JSON).get(Response.class);
		
		//DEBUG String response = target.path("persons/" + id).request(MediaType.APPLICATION_JSON).get(String.class);
		
		if (response.getStatus() != 200) {
			throw new RuntimeException(response.getStatus() + " : there was an error on the server.");
		}
		
		return response.readEntity(Person.class);
	}
	
	public List<Person> get() {
		
		WebTarget target = client.target("http://localhost:8080/simpleservice/webapi/");
		
		List<Person> response = target.path("persons").request(MediaType.APPLICATION_JSON).get(new GenericType<List<Person>>(){});
		
		return response;
	}

	public Person create(Person person) {
		
		WebTarget target = client.target("http://localhost:8080/simpleservice/webapi/");
		
		Response response = target.path("persons")
				.request(MediaType.APPLICATION_JSON)
				.post(Entity.entity(person, MediaType.APPLICATION_JSON));
		
		//DEBUG String response = target.path("persons/" + id).request(MediaType.APPLICATION_JSON).get(String.class);
		
		if (response.getStatus() != 200) {
			throw new RuntimeException(response.getStatus() + " : there was an error on the server.");
		}
		
		return response.readEntity(Person.class);
	}

	public Person update(Person person) {
		
		WebTarget target = client.target("http://localhost:8080/simpleservice/webapi/");
		
		Response response = target.path("persons/" + person.getId())
				.request(MediaType.APPLICATION_JSON)
				.put(Entity.entity(person, MediaType.APPLICATION_JSON));
		
		if (response.getStatus() != 200) {
			throw new RuntimeException(response.getStatus() + " : there was an error on the server.");
		}
		
		return response.readEntity(Person.class);
	}

	public void delete(long personId) {
		
		WebTarget target = client.target("http://localhost:8080/simpleservice/webapi/");
		
		Response response = target.path("persons/" + personId)
				.request(MediaType.APPLICATION_JSON)
				.delete();
		
		if (response.getStatus() != 200) {
			throw new RuntimeException(response.getStatus() + " : there was an error on the server.");
		}
	}
	
}
