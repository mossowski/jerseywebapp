package com.misys.simpleservice.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Person {

	private long id;
	private String name;
	private List<Project> projects;
	
	public Person() {
		
	}

	public Person(long id, String name, List<Project> projects) {
		this.id = id;
		this.name = name;
		this.projects = projects;
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
	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List <Project> projects) {
		this.projects = projects;
	}
}
