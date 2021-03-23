package com.globant.restservice.evt_src_cqrs.base.models;

import lombok.Data;

import java.util.Set;

@Data
public class User {
    private String userId;
    private String firstName;
    private String lastName;
    private Set<Contact> contacts;
    private Set<Address> addresses;
    // getters and setters

    public User(String userId, String firstName, String lastName) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
