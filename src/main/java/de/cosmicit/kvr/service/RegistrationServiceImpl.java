package de.cosmicit.kvr.service;

import de.cosmicit.kvr.dao.RegistrationDao;
import de.cosmicit.kvr.model.Address;
import de.cosmicit.kvr.model.Person;
import de.cosmicit.kvr.model.Registration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("registrationService")
@Transactional
public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	private RegistrationDao registrationDao;

	public Registration findById(long id) {
		return registrationDao.findById(id);
	}

	public Registration findByRegistrationByAddress(Address address) {
		Registration registration = registrationDao.findByRegistrationByAddress(address);
		return registration;
	}

	@Override
	public void saveRegistrationDetails(Registration registrationDetail) {
		registrationDao.saveRegistrationDetails(registrationDetail);
	}

	@Override
	public void deRegister(Registration registrationDetail) {
		registrationDao.deRegister(registrationDetail);
	}

	public List<Registration> findAllRegistrationsForPerson(Person personDetail)  {
		return registrationDao.findAllRegistrationsForPerson(personDetail);
	}

	public List<Registration> findAllRegistrationsForPerson(String firstName, String lastName)  {
		return registrationDao.findAllRegistrationsForPerson(firstName,lastName);
	}

	@Override
	public List<Registration> searchByPerson(Person searchPerson) {
		return registrationDao.findAllRegistrationsForPerson(searchPerson);
	}


}
