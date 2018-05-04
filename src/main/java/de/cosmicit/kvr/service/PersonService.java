package de.cosmicit.kvr.service;

import de.cosmicit.kvr.model.Person;

import java.util.List;

public interface PersonService {
	
	Person findById(long id);
	
	Person savePersonDetails(Person person);
	
	void updatePersonDetails(Person person);

	Person findByFirstNameAndLastName(Person person);

	List<Person>  searchByFirstNameLastName(String firstName, String lastName);

	List<Person>  searchByFirstNameLastNamePhone(String firstName, String lastName,String phoneNumber);

	List<Person> searchByFirstName(String queryStringFirstName);

	List<Person> searchByLastName(String queryStringLastName);

    List<Person> retrieveAllPersons();

	boolean personAlreadyExists(Person person);
}