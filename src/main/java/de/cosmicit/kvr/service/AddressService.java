package de.cosmicit.kvr.service;

import de.cosmicit.kvr.model.Address;
import de.cosmicit.kvr.model.Person;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

public interface AddressService {

    Address findById(long id);

    void saveAddress(Address address);

    List<Address> findAllAddresssForPerson(Person personDetail);
}