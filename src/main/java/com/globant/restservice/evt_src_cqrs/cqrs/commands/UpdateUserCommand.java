package com.globant.restservice.evt_src_cqrs.cqrs.commands;

import com.globant.restservice.evt_src_cqrs.base.models.Address;
import com.globant.restservice.evt_src_cqrs.base.models.Contact;
import lombok.Data;

import java.util.Set;

@Data
public class UpdateUserCommand {
    private String userId;
    private Set<Address> addresses;
    private Set<Contact> contacts;
}
