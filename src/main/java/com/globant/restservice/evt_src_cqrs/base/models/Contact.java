package com.globant.restservice.evt_src_cqrs.base.models;

import lombok.Data;

@Data
public class Contact {
    private String type;
    private String detail;
    // getters and setters

    public Contact(String type, String detail) {
        this.type = type;
        this.detail = detail;
    }
}
