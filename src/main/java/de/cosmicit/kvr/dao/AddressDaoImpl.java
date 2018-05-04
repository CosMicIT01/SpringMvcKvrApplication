package de.cosmicit.kvr.dao;

import de.cosmicit.kvr.model.Address;
import de.cosmicit.kvr.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("addressDao")
public class AddressDaoImpl implements AddressDao {


    private final String INSERT_SQL = "INSERT INTO tbl_address(city, country, countrycode, housenumber, state, street, zip )" +
            "values(:city, :country, :countrycode, :housenumber, :state, :street, :zip)";

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Address findById(long id) {
        return null;
    }

    @Override
    public Address saveAddressDetails(Address addressDetail) {
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("city", addressDetail.getCity())
                .addValue("country", addressDetail.getCountry())
                .addValue("countrycode", addressDetail.getCountryCode())
                .addValue("housenumber", addressDetail.getHouseNumber())
                .addValue("state", addressDetail.getState())
                .addValue("street", addressDetail.getStreet())
                .addValue("zip", addressDetail.getZip());
        namedParameterJdbcTemplate.update(INSERT_SQL, parameters, holder);
        addressDetail.setId(holder.getKey().longValue());
        return addressDetail;
    }

    @Override
    public List<Address> findAllAddressesForPerson(Person personDetail) {
        return null;
    }
}
