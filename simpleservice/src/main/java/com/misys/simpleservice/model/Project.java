package com.misys.simpleservice.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Project {

	private long id;
	private String name;
	private List<Person> persons;	

	public Project() {
		
	}
	
	public Project(long id, String name, List<Person> persons) {
		this.id = id;
		this.name = name;
		this.persons = persons;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}
}
