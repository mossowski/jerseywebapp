package com.misys.simpleservice.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.misys.simpleservice.database.Database;
import com.misys.simpleservice.model.Person;
import com.misys.simpleservice.model.Project;

public class PersonService implements PersonServiceInterface {

	private Map<Long, Person> persons = Database.getPersons();
	
	public PersonService() {
		persons.put(1L, new Person(1, "Mietek", Collections.<Project>emptyList()));
		persons.put(2L, new Person(2, "Wiesiek", Collections.<Project>emptyList()));
	}
	
	public List<Person> getAllPersons() {
		/*Person p1 = new Person(1L,"Mietek");
		Person p2 = new Person(2L,"Wiesiek");
		
		List<Person> persons = new ArrayList<Person>();
		persons.add(p1);
		persons.add(p2);*/
		
		return new ArrayList<Person>(persons.values());
	}
	
	public Person getPerson(long id) {
		// insert to db
		return persons.get(id);
	}
	
	public Person addPerson(Person person) {
		// insert to db
		person.setId(persons.size() + 1);
		persons.put(person.getId(), person);
		return person;
	}
	
	public Person updatePerson(Person person) {
		// insert to db
		if (person.getId() <= 0) {
			return null;
		}
		persons.put(person.getId(), person);
		return person;
	}
	
	public void deletePerson(long id) {
		// insert to db
		persons.remove(id);
	}

	public List<Person> findByName(List<String> name) {
		
		List<Person> persons = new ArrayList<Person>();
		
		Person p1 = new Person(8, "Wiesiek", Collections.<Project>emptyList());
		Person p2 = new Person(9, "Wiesiek", Collections.<Project>emptyList());
		
		persons.add(p1);
		persons.add(p2);
		
		return persons;
	}	
	
}
