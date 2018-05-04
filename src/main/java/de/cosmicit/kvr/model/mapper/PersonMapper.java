package de.cosmicit.kvr.model.mapper;


import de.cosmicit.kvr.model.Person;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonMapper implements RowMapper<Person> {
    public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
        Person person = new Person();
        person.setId(rs.getLong("person_id"))
        .setFirstName(rs.getString("firstname"))
        .setLastName(rs.getString("lastname"))
        .setPhoneNumber(rs.getString("phonenumber"))
        .setBirthDate(rs.getDate("birthdate"))
        .setCountryOfOrigin(rs.getString("countryoforigin"))
        .setGender(rs.getString("gender"))
        .setEmail(rs.getString("email"));
        return person;
    }
}
