package com.misys.simpleservice.service;

import java.util.List;

import com.misys.simpleservice.model.Person;

public interface PersonServiceInterface {

	List<Person> getAllPersons();

	Person getPerson(long id);

	Person addPerson(Person person);

	Person updatePerson(Person person);

	void deletePerson(long id);

}