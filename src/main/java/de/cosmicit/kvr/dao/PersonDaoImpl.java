package de.cosmicit.kvr.dao;

import de.cosmicit.kvr.model.Person;
import de.cosmicit.kvr.model.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository("personDao")
public class PersonDaoImpl  implements PersonDao {

    private final String INSERT_SQL = "INSERT INTO tbl_person(firstname, lastname,email,gender, birthdate, phonenumber) " +
            "values(:firstname, :lastname, :email, :gender, :birthdate, :phonenumber)";

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Person> retrieveAllPersons() {
        String sqlString = "SELECT * FROM tbl_person";
        List<Person> personList = namedParameterJdbcTemplate.query(sqlString,new PersonMapper() );
        return personList;
    }

    @Override
    public Person findById(long id) {
        String sqlString = "SELECT * FROM tbl_person where person_id = :id ";
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("id", id);
        Person person = namedParameterJdbcTemplate.queryForObject(sqlString,namedParameters,new PersonMapper() );
        return  person;
    }

    @Override
    public Person savePersonDetails(Person person) {
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("firstname", person.getFirstName())
                .addValue("lastname", person.getLastName())
                .addValue("email", person.getEmail())
                .addValue("gender", person.getGender())
                .addValue("birthdate", person.getBirthDate())
                .addValue("phonenumber", person.getPhoneNumber());
        namedParameterJdbcTemplate.update(INSERT_SQL, parameters, holder);
        person.setId(holder.getKey().longValue());
        return person;
    }

    @Override
    public void updatePersonDetails(Person person) {
        String SQL = "UPDATE tbl_person SET  email= :email, gender = :gender , birthdate = :birthdate WHERE person_id = :personId";
        SqlParameterSource namedParameters = new MapSqlParameterSource()
        .addValue("email", person.getEmail())
        .addValue("gender", person.getGender())
        .addValue("birthdate", person.getBirthDate())
        .addValue("personId", person.getId());
        namedParameterJdbcTemplate.update(SQL, namedParameters);
    }

    @Override
    public Person findByFirstNameAndLastName(Person person) {
        return null;
    }

    @Override
    public List<Person> findByFirstNameAndLastName(String firstName, String lastName) {
        String sqlString = "SELECT * FROM tbl_person where firstname = :firstName and lastname = :lastName";

        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("firstName", firstName);
        namedParameters.addValue("lastName", lastName);
//        Person person = (Person) namedParameterJdbcTemplate.qu(sqlString, namedParameters, new PersonMapper());

        List<Person> personList = namedParameterJdbcTemplate.query(sqlString,namedParameters,new PersonMapper() );

        return personList;
    }


    @Override
    public List<Person> searchByFirstNameLastNamePhone(String firstName, String lastName, String phoneNumber) {
        String sqlString = "SELECT * FROM tbl_person where firstname = :firstName and lastname = :lastName and phonenumber = :phoneNumber";

        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("firstName", firstName);
        namedParameters.addValue("lastName", lastName);
        namedParameters.addValue("phoneNumber", phoneNumber);

        List<Person> personList = namedParameterJdbcTemplate.query(sqlString,namedParameters,new PersonMapper() );

        return personList;
    }

    @Override
    public boolean personAlreadyExists(Person person) {
        String sqlString = "SELECT * FROM tbl_person per where per.firstname = :firstName and per.lastname = :lastName and per.phonenumber = :phoneNumber ";

        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("firstName", person.getFirstName());
        namedParameters.addValue("lastName", person.getLastName());
        namedParameters.addValue("phoneNumber", person.getPhoneNumber());

        List<Person> personList = namedParameterJdbcTemplate.query(sqlString, namedParameters,new PersonMapper() );

        return !personList.isEmpty();
    }

    @Override
    public List<Person> searchByFirstName(String firstName) {

        String sqlString = "SELECT * FROM tbl_person per where  LOWER(per.firstname) LIKE LOWER(CONCAT('%', :firstName, '%'))";

        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("firstName", firstName);

        List<Person> personList = namedParameterJdbcTemplate.query(sqlString, namedParameters,new PersonMapper() );

        return personList;
    }

    @Override
    public List<Person> searchByLastName(String lastName) {

        String sqlString = "SELECT * FROM tbl_person per where  LOWER(per.lastname) LIKE LOWER(CONCAT('%', :lastName, '%'))";

        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("lastName", lastName);

        List<Person> personList = namedParameterJdbcTemplate.query(sqlString, namedParameters,new PersonMapper() );

        return personList;
    }

    @Override
    public List<Person> searchByPhoneNumber(String phoneNumber) {

        String sqlString = "SELECT * FROM tbl_person per where LOWER(per.phonenumber) LIKE LOWER(CONCAT('%', :phoneNumber, '%'))";

        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("phoneNumber", phoneNumber);

        List<Person> personList = namedParameterJdbcTemplate.query(sqlString, namedParameters,new PersonMapper() );

        return personList;
    }
}
