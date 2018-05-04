package de.cosmicit.kvr.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class Person {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Date birthDate;
    private String gender;
    private String countryOfOrigin;
    private String phoneNumber;
    private List<Registration> registrations = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public Person setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Person setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Person setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Person setEmail(String email) {
        this.email = email;
        return this;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public Person setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public Person setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public Person setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Person setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public List<Registration> getRegistrations() {
        return registrations;
    }

    public Person setRegistrations(List<Registration> registrations) {
        this.registrations = registrations;
        return this;
    }
}
