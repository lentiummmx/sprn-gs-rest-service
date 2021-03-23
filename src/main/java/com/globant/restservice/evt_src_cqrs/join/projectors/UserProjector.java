package com.globant.restservice.evt_src_cqrs.join.projectors;

import com.globant.restservice.evt_src_cqrs.base.models.Address;
import com.globant.restservice.evt_src_cqrs.base.models.Contact;
import com.globant.restservice.evt_src_cqrs.cqrs.repositories.UserReadRepository;
import com.globant.restservice.evt_src_cqrs.cqrs.rmodels.UserAddress;
import com.globant.restservice.evt_src_cqrs.cqrs.rmodels.UserContact;
import com.globant.restservice.evt_src_cqrs.evtsrc.events.Event;
import com.globant.restservice.evt_src_cqrs.evtsrc.events.impl.UserAddressAddedEvent;
import com.globant.restservice.evt_src_cqrs.evtsrc.events.impl.UserAddressRemovedEvent;
import com.globant.restservice.evt_src_cqrs.evtsrc.events.impl.UserContactAddedEvent;
import com.globant.restservice.evt_src_cqrs.evtsrc.events.impl.UserContactRemovedEvent;

import java.util.*;

public class UserProjector {
    UserReadRepository repository = new UserReadRepository();

    public UserProjector(UserReadRepository repository) {
        this.repository = repository;
    }

    public void project(String userId, List<Event> events) {
        for (Event event : events) {
            if(event instanceof UserAddressAddedEvent)
                apply(userId, (UserAddressAddedEvent) event);
            if(event instanceof UserAddressRemovedEvent)
                apply(userId, (UserAddressRemovedEvent) event);
            if(event instanceof UserContactAddedEvent)
                apply(userId, (UserContactAddedEvent) event);
            if(event instanceof UserContactRemovedEvent)
                apply(userId, (UserContactRemovedEvent) event);
        }
    }

    public void apply(String userId, UserAddressAddedEvent event) {
        Address address = new Address(event.getCity(), event.getState(), event.getPostCode());
        UserAddress userAddress = Optional.ofNullable(repository.getUserAddress(userId)).orElse(new UserAddress());
        Set<Address> addresses = Optional.ofNullable(userAddress.getAddressByRegion().get(address.getState())).orElse(new HashSet<>());
        addresses.add(address);
        userAddress.getAddressByRegion().put(address.getState(), addresses);
        repository.addUserAddress(userId, userAddress);
    }

    public void apply(String userId, UserAddressRemovedEvent event) {
        Address address = new Address(event.getCity(), event.getState(), event.getState());
        UserAddress userAddress = repository.getUserAddress(userId);
        if (userAddress != null) {
            Set<Address> addresses = userAddress.getAddressByRegion().get(address.getState());
            if (addresses != null)
                addresses.remove(address);
            repository.addUserAddress(userId, userAddress);
        }
    }

    public void apply(String userId, UserContactAddedEvent event) {
        // Similarly handle UserContactAddedEvent event
        Contact contact = new Contact(event.getContactType(), event.getContactDetails());
        UserContact userContact = Optional.ofNullable(repository.getUserContact(userId)).orElse(new UserContact());
        Set<Contact> contacts = Optional.ofNullable(userContact.getContactByType().get(contact.getType())).orElse(new HashSet<>());
        contacts.add(contact);
        userContact.getContactByType().put(contact.getType(), contacts);
        repository.addUserContact(userId, userContact);
    }

    public void apply(String userId, UserContactRemovedEvent event) {
        // Similarly handle UserContactRemovedEvent event
        Contact contact = new Contact(event.getContactType(), event.getContactDetails());
        UserContact userContact = repository.getUserContact(userId);
        if (userContact != null) {
            Set<Contact> contacts = userContact.getContactByType().get(contact.getType());
            if (contacts != null)
                contacts.remove(contact);
            repository.addUserContact(userId, userContact);
        }
    }

}
