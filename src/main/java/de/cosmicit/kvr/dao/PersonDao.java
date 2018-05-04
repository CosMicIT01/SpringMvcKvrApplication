package de.cosmicit.kvr.dao;

import de.cosmicit.kvr.model.Person;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface PersonDao {

	Person findById(long id);

	Person savePersonDetails(Person person);

	void updatePersonDetails(Person person);

    Person findByFirstNameAndLastName(Person person);

	List<Person> findByFirstNameAndLastName(String firstName, String lastName);

    List<Person> retrieveAllPersons();

    boolean personAlreadyExists(Person person);

	List<Person> searchByFirstNameLastNamePhone(String firstName, String lastName, String phoneNumber);

    List<Person> searchByFirstName(String lastName);

    List<Person> searchByLastName(String lastName);

    List<Person> searchByPhoneNumber(String phoneNumber);
}

