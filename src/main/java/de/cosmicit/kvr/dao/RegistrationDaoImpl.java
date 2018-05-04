package de.cosmicit.kvr.dao;

import de.cosmicit.kvr.model.Address;
import de.cosmicit.kvr.model.Person;
import de.cosmicit.kvr.model.Registration;
import de.cosmicit.kvr.model.mapper.RegistrationMapper;
//import org.apache.log4j.Logger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Repository("registrationDao")
public class RegistrationDaoImpl implements RegistrationDao {
    Logger log = LoggerFactory.getLogger(RegistrationDaoImpl.class);
//    Logger logger = Logger.getLogger(RegistrationDaoImpl.class);

    private final String INSERT_SQL = "INSERT INTO tbl_registration(registration_linkpersonid, registrationdate,createddate, lastregistrationdate, createdby, currentaddress,previousaddress, active) " +
            "values(:registration_linkpersonid, :registrationdate, :createddate, :lastRegistrationDate, :createdby, :currentaddress, :previousaddress, :active)";

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    PersonDao personDao;

    @Autowired
    AddressDao addressDao;

    @Override
    public Registration findById(long registrationId) {
        String searchRegistrationsSql = "SELECT reg.registration_id, " +
                "       reg.active, " +
                "       reg.createdby, " +
                "       reg.createddate, " +
                "       reg.modifiedby, " +
                "       reg.modifieddate, " +
                "       reg.registrationdate, " +
                "       reg.registration_linkpersonid, " +
                "       reg.lastregistrationdate, " +
                "       curraddress.street      AS `currentstreet`, " +
                "       curraddress.housenumber AS `currenthousenumber`, " +
                "       curraddress.city        AS `currentcity`, " +
                "       curraddress.zip         AS `currentzip`, " +
                "       prevaddress.street      AS `previousstreet`, " +
                "       prevaddress.housenumber AS `previoushousenumber`, " +
                "       prevaddress.city        AS `previouscity`, " +
                "       prevaddress.zip         AS `previouszip` " +
                "FROM   tbl_registration reg " +
                "       LEFT JOIN tbl_person per " +
                "              ON reg.registration_linkpersonid = per.person_id " +
                "       LEFT JOIN tbl_address curraddress " +
                "              ON reg.currentaddress = curraddress.address_id " +
                "       LEFT JOIN tbl_address prevaddress " +
                "              ON reg.previousaddress = prevaddress.address_id " +
                "WHERE  reg.registration_id = :registrationId " +
                "       AND reg.active = 'Y' ";
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("registrationId", registrationId);

        List<Registration> registrations = namedParameterJdbcTemplate.query(searchRegistrationsSql, namedParameters, new RegistrationMapper());

        if (registrations.isEmpty()){
            return null;
        }
        return registrations.get(0);

    }

    @Override
    public Registration findByRegistrationByAddress(Address address) {
        return null;
    }

    @Override
    public void saveRegistrationDetails(Registration registrationDetail) {
        String INSERT_SQL = "INSERT INTO tbl_registration(registration_linkpersonid, registrationdate,createddate, lastregistrationdate, createdby, currentaddress,previousaddress, active) " +
                "values(:registration_linkpersonid, :registrationdate, :createddate, :lastRegistrationDate, :createdby, :currentaddress, :previousaddress, :active)";


        Person person = registrationDetail.getPerson();
        List<Person> existingPersons = personDao.searchByFirstNameLastNamePhone(person.getFirstName(), person.getLastName(), person.getPhoneNumber());

        if (existingPersons.isEmpty()) {
            person = personDao.savePersonDetails(person);
            registrationDetail.getPerson().setId(person.getId());
        }

        Address currentAddress = addressDao.saveAddressDetails(registrationDetail.getCurrentAddress());
        registrationDetail.getCurrentAddress().setId(currentAddress.getId());
        if (!isFirstRegistration(registrationDetail)) {
            Address previousAddress = addressDao.saveAddressDetails(registrationDetail.getPreviousAddress());
            registrationDetail.getPreviousAddress().setId(previousAddress.getId());
        }

        // find and deactivate existing registrations for the person
        Registration existingRegistration = getRegistrationDetailsForPersonById(person.getId());
        if (existingRegistration != null) {
            deactivateRegistrationEntry(existingRegistration);
            registrationDetail.setLastRegistrationDate(existingRegistration.getRegistrationDate());
        }

        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("registration_linkpersonid", person.getId())
                .addValue("registrationdate", new Date())
                .addValue("createddate", new Date())
                .addValue("createdby", registrationDetail.getCreatedBy())
                .addValue("currentaddress", registrationDetail.getCurrentAddress().getId())
                .addValue("previousaddress", registrationDetail.getPreviousAddress().getId())
                .addValue("lastRegistrationDate", localTimeToDate(registrationDetail.getLastRegistrationDate()))
                .addValue("active", registrationDetail.getActive());
        namedParameterJdbcTemplate.update(INSERT_SQL, parameters, holder);
        // To create address Details
        registrationDetail.setId(holder.getKey().longValue());
    }

    public static java.sql.Date localTimeToDate(LocalDateTime lt) {
        if (lt==null) {
            return null;
        }
        return new java.sql.Date(lt.atZone(ZoneId.systemDefault()).toInstant()
                .toEpochMilli());
    }

    private Registration getRegistrationDetailsForPersonById(Long personId) {
        String sqlString = "SELECT * FROM tbl_registration where registration_linkpersonid = :personId and active = 'Y'";

        log.debug("Sql String {}", sqlString);
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("personId", personId);
        List<Registration> registrations = namedParameterJdbcTemplate.query(sqlString, namedParameters,
                (resultSet, i) -> {
                    Registration registration = new Registration()
                            .setId(resultSet.getLong("registration_id"))
                            .setActive(resultSet.getString("active"))
                            .setCreatedBy(resultSet.getString("createdby"))
                            .setCreatedDate(resultSet.getTimestamp("createddate").toLocalDateTime())
                            .setLastRegistrationDate(resultSet.getTimestamp("lastregistrationdate") != null ? resultSet.getTimestamp("lastregistrationdate").toLocalDateTime() : null)
                            .setModifiedBy(resultSet.getString("modifiedby"))
                            .setModifiedDate(resultSet.getTimestamp("modifieddate") != null ? resultSet.getTimestamp("modifieddate").toLocalDateTime() : null)
                            .setRegistrationDate(resultSet.getTimestamp("registrationdate") != null ? resultSet.getTimestamp("registrationdate").toLocalDateTime() : null)
                            .setRegisteredPersonId(resultSet.getLong("registration_linkpersonid"));
                    return registration;
                });
        if (registrations.isEmpty()) {
            return null;
        }
        return registrations.get(0);
    }

    private void deactivateRegistrationEntry(Registration registration) {
        String deactivateRegistrationSql = "UPDATE tbl_registration SET  active= 'N', modifiedby=:modifiedBy,modifieddate = :modifiedDate WHERE registration_id = :registrationId";
        SqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("modifiedBy", "ADMIN") // TODO will be taken from logged in profile.
                .addValue("modifiedDate", new Date())
                .addValue("registrationId", registration.getId());
        namedParameterJdbcTemplate.update(deactivateRegistrationSql, namedParameters);
    }

    private boolean isFirstRegistration(Registration registrationDetail) {
        return (registrationDetail.getPreviousAddress().getStreet().isEmpty() && registrationDetail.getPreviousAddress().getHouseNumber() == null);
    }

    @Override
    public void deRegister(Registration registrationDetai) {

    }

    @Override
    public List<Registration> findAllRegistrationsForPerson(Person personDetail) {

        String searchRegistrationsSql = "SELECT reg.registration_id, " +
                "       reg.active, " +
                "       reg.createdby, " +
                "       reg.createddate, " +
                "       reg.modifiedby, " +
                "       reg.modifieddate, " +
                "       reg.registrationdate, " +
                "       reg.registration_linkpersonid, " +
                "       reg.lastregistrationdate, " +
                "       curraddress.street      AS `currentstreet`, " +
                "       curraddress.housenumber AS `currenthousenumber`, " +
                "       curraddress.city        AS `currentcity`, " +
                "       curraddress.zip         AS `currentzip`, " +
                "       prevaddress.street      AS `previousstreet`, " +
                "       prevaddress.housenumber AS `previoushousenumber`, " +
                "       prevaddress.city        AS `previouscity`, " +
                "       prevaddress.zip         AS `previouszip` " +
                "FROM   tbl_registration reg " +
                "       LEFT JOIN tbl_person per " +
                "              ON reg.registration_linkpersonid = per.person_id " +
                "       LEFT JOIN tbl_address curraddress " +
                "              ON reg.currentaddress = curraddress.address_id " +
                "       LEFT JOIN tbl_address prevaddress " +
                "              ON reg.previousaddress = prevaddress.address_id " +
                "WHERE  per.person_id = :personId " +
                "       AND reg.active = 'Y' ";
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("personId", personDetail.getId());

        List<Registration> registrations = namedParameterJdbcTemplate.query(searchRegistrationsSql, namedParameters, new RegistrationMapper());

        return registrations;
    }

    @Override
    public List<Registration> findAllRegistrationsForPerson(String firstName, String lastName) {

        String searchRegistrationsSqlString = "SELECT reg.registration_id, " +
                "       reg.active, " +
                "       reg.createdby, " +
                "       reg.createddate, " +
                "       reg.modifiedby, " +
                "       reg.modifieddate, " +
                "       reg.registrationdate, " +
                "       reg.registration_linkpersonid, " +
                "       reg.lastregistrationdate, " +
                "       curraddress.street      AS `currentstreet`, " +
                "       curraddress.housenumber AS `currenthousenumber`, " +
                "       curraddress.city        AS `currentcity`, " +
                "       curraddress.zip         AS `currentzip`, " +
                "       prevaddress.street      AS `previousstreet`, " +
                "       prevaddress.housenumber AS `previoushousenumber`, " +
                "       prevaddress.city        AS `previouscity`, " +
                "       prevaddress.zip         AS `previouszip` " +
                "FROM   tbl_registration reg " +
                "       LEFT JOIN tbl_person per " +
                "              ON reg.registration_linkpersonid = per.person_id " +
                "       LEFT JOIN tbl_address curraddress " +
                "              ON reg.currentaddress = curraddress.address_id " +
                "       LEFT JOIN tbl_address prevaddress " +
                "              ON reg.previousaddress = prevaddress.address_id " +
                "WHERE  LOWER(per.firstname) LIKE LOWER(CONCAT('%', :firstName, '%')) " +
                "       AND LOWER(per.lastname) LIKE LOWER(CONCAT('%', :lastName, '%')) " +
                "       AND reg.active = 'Y'";

        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("firstName", firstName);
        namedParameters.addValue("lastName", lastName);

        List<Registration> registrations = namedParameterJdbcTemplate.query(searchRegistrationsSqlString, namedParameters, new RegistrationMapper());

        return registrations;
    }
}
