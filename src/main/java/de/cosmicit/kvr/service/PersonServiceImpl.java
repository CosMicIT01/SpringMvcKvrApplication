package de.cosmicit.kvr.service;

import de.cosmicit.kvr.dao.PersonDao;
import de.cosmicit.kvr.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("personService")
@Transactional
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDao personDao;

    public Person findById(long id) {
        return personDao.findById(id);
    }

    @Override
    public Person savePersonDetails(Person person) {
        return personDao.savePersonDetails(person);
    }

    @Override
    public void updatePersonDetails(Person person) {
        personDao.updatePersonDetails(person);
    }

    @Override
    public Person findByFirstNameAndLastName(Person person) {
        return personDao.findByFirstNameAndLastName(person);
    }

    @Override
    public List<Person>  searchByFirstNameLastName(String firstName, String lastName) {
        return personDao.findByFirstNameAndLastName(firstName, lastName);
    }

    @Override
    public List<Person> searchByFirstNameLastNamePhone(String firstName, String lastName, String phoneNumber) {
        return personDao.searchByFirstNameLastNamePhone(firstName, lastName, phoneNumber);
    }

    @Override
    public List<Person> searchByFirstName(String queryStringFirstName) {
        return personDao.searchByFirstName(queryStringFirstName);
    }

    @Override
    public List<Person> searchByLastName(String queryStringLastName) {
        return null;
    }

    @Override
    public List<Person> retrieveAllPersons() {
        return personDao.retrieveAllPersons();
    }

    @Override
    public boolean personAlreadyExists(Person person) {
        return personDao.personAlreadyExists(person);
    }
}
