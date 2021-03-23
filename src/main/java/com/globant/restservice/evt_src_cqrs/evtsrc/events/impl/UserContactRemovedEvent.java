package com.globant.restservice.evt_src_cqrs.evtsrc.events.impl;

import com.globant.restservice.evt_src_cqrs.evtsrc.events.Event;
import lombok.Data;

@Data
public class UserContactRemovedEvent extends Event {
    private String contactType;
    private String contactDetails;

    public UserContactRemovedEvent(String contactType, String contactDetails) {
        this.contactType = contactType;
        this.contactDetails = contactDetails;
    }
}
