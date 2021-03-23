package com.globant.restservice.evt_src_cqrs.base.models;

import lombok.Data;

@Data
public class Address {
    private String city;
    private String state;
    private String postCode;
    // getters and setters

    public Address(String city, String state, String postCode) {
        this.city = city;
        this.state = state;
        this.postCode = postCode;
    }
}
