package de.cosmicit.kvr.dao;

import de.cosmicit.kvr.model.Address;
import de.cosmicit.kvr.model.Person;
import de.cosmicit.kvr.model.Registration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface RegistrationDao {

    Registration findById(long id);

    Registration findByRegistrationByAddress(Address address);

    void saveRegistrationDetails(Registration registrationDetail);

    void deRegister(Registration registrationDetai);

    List<Registration> findAllRegistrationsForPerson(Person personDetail);

    List<Registration> findAllRegistrationsForPerson(String firstName, String lastName);

}

