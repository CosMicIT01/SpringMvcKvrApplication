package de.cosmicit.kvr.service;

import de.cosmicit.kvr.dao.AddressDao;
import de.cosmicit.kvr.model.Address;
import de.cosmicit.kvr.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("addressService")
@Transactional
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressDao dao;

    public Address findById(long id) {
        return dao.findById(id);
    }

    @Override
    public void saveAddress(Address address) {
        dao.saveAddressDetails(address);
    }

    @Override
    public List<Address> findAllAddresssForPerson(Person personDetail) {
        return dao.findAllAddressesForPerson(personDetail);
    }
}
