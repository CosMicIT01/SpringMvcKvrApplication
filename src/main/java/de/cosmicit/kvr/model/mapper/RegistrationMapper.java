package de.cosmicit.kvr.model.mapper;


import de.cosmicit.kvr.model.Address;
import de.cosmicit.kvr.model.Registration;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class RegistrationMapper implements RowMapper<Registration> {
    public Registration mapRow(ResultSet rs, int rowNum) throws SQLException {

        Address previousAddress = new Address()
                .setCity(rs.getString("previouscity"))
                .setStreet(rs.getString("previousstreet"))
                .setHouseNumber(rs.getInt("previoushousenumber"))
                .setZip(rs.getString("previouszip"));

        Address currentAddress = new Address()
                .setCity(rs.getString("currentcity"))
                .setStreet(rs.getString("currentstreet"))
                .setHouseNumber(rs.getInt("currenthousenumber"))
                .setZip(rs.getString("currentzip"));

        Registration registration = new Registration();
        registration.setId(rs.getLong("registration_id"))
        .setActive(rs.getString("active"))
        .setCreatedBy(rs.getString("createdby"))
        .setCreatedDate(handleNullLocalDateTime(rs.getTimestamp("createddate")))
        .setLastRegistrationDate(handleNullLocalDateTime(rs.getTimestamp("lastregistrationdate")))
        .setModifiedBy(rs.getString("modifiedby"))
        .setModifiedDate(handleNullLocalDateTime(rs.getTimestamp("modifieddate")))
        .setRegistrationDate(handleNullLocalDateTime(rs.getTimestamp("registrationdate")))
        .setPreviousAddress(previousAddress)
        .setCurrentAddress(currentAddress)
        .setRegisteredPersonId(rs.getLong("registration_linkpersonid"));
        return registration;
    }

    private LocalDateTime handleNullLocalDateTime(Timestamp dateTime) {
        return (dateTime!=null? dateTime.toLocalDateTime():null);
    }
}
