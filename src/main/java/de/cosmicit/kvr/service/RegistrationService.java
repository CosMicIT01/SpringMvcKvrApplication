package de.cosmicit.kvr.service;

import de.cosmicit.kvr.model.Address;
import de.cosmicit.kvr.model.Person;
import de.cosmicit.kvr.model.Registration;

import java.util.List;

public interface RegistrationService {

    Registration findById(long id);

    Registration findByRegistrationByAddress(Address address);

    void saveRegistrationDetails(Registration registrationDetail);

    void deRegister(Registration registrationDetai);

    List<Registration> findAllRegistrationsForPerson(Person personDetail);

    List<Registration> searchByPerson(Person searchPerson);
}