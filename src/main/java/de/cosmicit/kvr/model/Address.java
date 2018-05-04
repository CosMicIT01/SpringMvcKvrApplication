package de.cosmicit.kvr.model;

import java.util.ArrayList;
import java.util.List;

public class Address {

    private Long id;
    private String street;
    private Integer houseNumber;
    private String city;
    private String zip;
    private String state;
    private String country;
    private String countryCode;
    private List<Registration> currentRegistrations = new ArrayList<>();
    private List<Registration> previousRegistrations = new ArrayList<>();


    public Long getId() {
        return id;
    }

    public Address setId(Long id) {
        this.id = id;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public Address setStreet(String street) {
        this.street = street;
        return this;
    }

    public Integer getHouseNumber() {
        return houseNumber;
    }

    public Address setHouseNumber(Integer houseNumber) {
        this.houseNumber = houseNumber;
        return this;
    }

    public String getCity() {
        return city;
    }

    public Address setCity(String city) {
        this.city = city;
        return this;
    }

    public String getZip() {
        return zip;
    }

    public Address setZip(String zip) {
        this.zip = zip;
        return this;
    }

    public String getState() {
        return state;
    }

    public Address setState(String state) {
        this.state = state;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public Address setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public Address setCountryCode(String countryCode) {
        this.countryCode = countryCode;
        return this;
    }

    public List<Registration> getCurrentRegistrations() {
        return currentRegistrations;
    }

    public Address setCurrentRegistrations(List<Registration> currentRegistrations) {
        this.currentRegistrations = currentRegistrations;
        return this;
    }

    public List<Registration> getPreviousRegistrations() {
        return previousRegistrations;
    }

    public Address setPreviousRegistrations(List<Registration> previousRegistrations) {
        this.previousRegistrations = previousRegistrations;
        return this;
    }
}
