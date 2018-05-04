package de.cosmicit.kvr.dao;

import de.cosmicit.kvr.model.Address;
import de.cosmicit.kvr.model.Person;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface AddressDao {

    Address findById(long id);

    Address saveAddressDetails(Address addressDetail);

    List<Address> findAllAddressesForPerson(Person personDetail);

}

