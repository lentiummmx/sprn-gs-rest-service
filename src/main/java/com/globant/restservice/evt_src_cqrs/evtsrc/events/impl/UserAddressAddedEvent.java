package com.globant.restservice.evt_src_cqrs.evtsrc.events.impl;

import com.globant.restservice.evt_src_cqrs.evtsrc.events.Event;
import lombok.Data;

@Data
public class UserAddressAddedEvent extends Event {
    private String city;
    private String state;
    private String postCode;

    public UserAddressAddedEvent(String city, String state, String postCode) {
        this.city = city;
        this.state = state;
        this.postCode = postCode;
    }
}
