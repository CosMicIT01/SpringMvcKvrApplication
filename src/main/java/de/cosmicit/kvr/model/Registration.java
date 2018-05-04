package de.cosmicit.kvr.model;

import java.time.LocalDateTime;

public class Registration {

    private Long id;

    private LocalDateTime registrationDate;

    private LocalDateTime lastRegistrationDate;

    private String createdBy;

    private String modifiedBy;

    private Address currentAddress;

    private Address previousAddress;

    private LocalDateTime createdDate;

    private LocalDateTime modifiedDate;

    private Person person;

    private String active;

    private Long registeredPersonId;

    public Long getId() {
        return id;
    }

    public Registration setId(Long id) {
        this.id = id;
        return this;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public Registration setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
        return this;
    }

    public LocalDateTime getLastRegistrationDate() {
        return lastRegistrationDate;
    }

    public Registration setLastRegistrationDate(LocalDateTime lastRegistrationDate) {
        this.lastRegistrationDate = lastRegistrationDate;
        return this;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public Registration setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public Registration setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public Address getCurrentAddress() {
        return currentAddress;
    }

    public Registration setCurrentAddress(Address currentAddress) {
        this.currentAddress = currentAddress;
        return this;
    }

    public Address getPreviousAddress() {
        return previousAddress;
    }

    public Registration setPreviousAddress(Address previousAddress) {
        this.previousAddress = previousAddress;
        return this;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public Registration setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public Registration setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }

    public Person getPerson() {
        return person;
    }

    public Registration setPerson(Person person) {
        this.person = person;
        return this;
    }

    public String getActive() {
        return active;
    }

    public Registration setActive(String active) {
        this.active = active;
        return this;
    }

    public Long getRegisteredPersonId() {
        return registeredPersonId;
    }

    public Registration setRegisteredPersonId(Long registeredPersonId) {
        this.registeredPersonId = registeredPersonId;
        return this;
    }
}
