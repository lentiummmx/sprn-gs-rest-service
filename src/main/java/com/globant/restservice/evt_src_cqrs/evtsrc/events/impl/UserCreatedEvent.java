package com.globant.restservice.evt_src_cqrs.evtsrc.events.impl;

import com.globant.restservice.evt_src_cqrs.evtsrc.events.Event;
import lombok.Data;

@Data
public class UserCreatedEvent extends Event {
    private String userId;
    private String firstName;
    private String lastName;

    public UserCreatedEvent(String userId, String firstName, String lastName) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
