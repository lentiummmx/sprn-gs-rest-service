package com.globant.restservice.evt_src_cqrs.evtsrc.events.impl;

import com.globant.restservice.evt_src_cqrs.evtsrc.events.Event;
import lombok.Data;

@Data
public class UserContactAddedEvent extends Event {
    private String contactType;
    private String contactDetails;

    public UserContactAddedEvent(String contactType, String contactDetails) {
        this.contactType = contactType;
        this.contactDetails = contactDetails;
    }
}
