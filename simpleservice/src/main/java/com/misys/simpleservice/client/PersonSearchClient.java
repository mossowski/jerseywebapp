package com.misys.simpleservice.client;


import java.net.URI;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import com.misys.simpleservice.model.Person;

public class PersonSearchClient {

	private Client client;
	
	public PersonSearchClient() {
		client = ClientBuilder.newClient();
	}
	
	public List<Person> search(String param, List<String> searchValues) {
		URI uri = UriBuilder.fromUri("http://localhost:8080/simpleservice/webapi/")
				.path("search/persons")
				.queryParam(param, searchValues)
				.build();
		
		WebTarget target = client.target(uri);
		
		List<Person> response = target.request(MediaType.APPLICATION_JSON).get(new GenericType<List<Person>> () {});
	
		System.out.println(response);
		
		return response;
	}
	
}
