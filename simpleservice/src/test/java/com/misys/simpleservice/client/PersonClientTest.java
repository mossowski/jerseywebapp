package com.misys.simpleservice.client;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import com.misys.simpleservice.model.Person;
import com.misys.simpleservice.model.Project;

public class PersonClientTest {
	
	
	@Test
	public void testSearch() {
		
		PersonSearchClient client = new PersonSearchClient();
		
		String param = "name";
		List<String> searchValues = new ArrayList<String>();
		searchValues.add("Mietek");
		
		List<Person> persons = client.search(param, searchValues);
		
		System.out.println(persons);
		
		assertNotNull(persons);
	}
	
	@Test
	public void testDelete() {
		
		PersonClient client = new PersonClient();
		
		client.delete(1);
	}

	@Test
	public void testPut() {
		
		PersonClient client = new PersonClient();
		
		Person person = new Person(9, "Leszek", Collections.<Project>emptyList());
		
		System.out.println(person);
		
		person = client.update(person);
		
		assertNotNull(person);
	}
	
	@Test
	public void testCreate() {
		
		PersonClient client = new PersonClient();
		
		Person person = new Person(5,"Mieciu", Collections.<Project>emptyList());
		
		System.out.println(person);
		
		person = client.create(person);
		
		assertNotNull(person);
	}
	
	@Test
	public void testGet() {
		
		PersonClient client = new PersonClient();
		
		Person person = client.get(1);
		
		System.out.println(person);
		
		assertNotNull(person);
	}
	
	@Test
	public void testGetList() {
		PersonClient client = new PersonClient();
		
		List<Person> persons = client.get();
		
		System.out.println(persons);
		
		assertNotNull(persons);
	}
	
	@Test(expected=RuntimeException.class)
	public void testGetWithBadRequest() {
		PersonClient client = new PersonClient();
		
		client.get(6);
	}

}
