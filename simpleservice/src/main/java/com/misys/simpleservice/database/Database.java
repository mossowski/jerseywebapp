package com.misys.simpleservice.database;

import java.util.HashMap;
import java.util.Map;

import com.misys.simpleservice.model.Person;
import com.misys.simpleservice.model.Project;

public class Database {

	private static Map<Long, Person> persons = new HashMap<>();
	private static Map<Long, Project> projects = new HashMap<>();
	
	public static Map<Long, Person> getPersons() {
		return persons;
	}
	public static Map<Long, Project> getProjects() {
		return projects;
	}
}
