package com.globant.restservice.evt_src_cqrs.join.aggregators;

import com.globant.restservice.evt_src_cqrs.base.models.Address;
import com.globant.restservice.evt_src_cqrs.base.models.Contact;
import com.globant.restservice.evt_src_cqrs.base.models.User;
import com.globant.restservice.evt_src_cqrs.cqrs.commands.CreateUserCommand;
import com.globant.restservice.evt_src_cqrs.cqrs.commands.UpdateUserCommand;
import com.globant.restservice.evt_src_cqrs.cqrs.repositories.UserWriteRepository;
import com.globant.restservice.evt_src_cqrs.evtsrc.events.Event;
import com.globant.restservice.evt_src_cqrs.evtsrc.events.impl.*;
import com.globant.restservice.evt_src_cqrs.evtsrc.stores.EventStore;
import com.globant.restservice.evt_src_cqrs.evtsrc.utils.UserUtility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserAggregate {
    private EventStore writeRepository;

    public UserAggregate(EventStore writeRepository) {
        this.writeRepository = writeRepository;
    }

    public List<Event> handleCreateUserCommand(CreateUserCommand command) {
        UserCreatedEvent event = new UserCreatedEvent(command.getUserId(), command.getFirstName(), command.getLastName());
        writeRepository.addEvent(command.getUserId(), event);
        return Arrays.asList(event);
    }

    public List<Event> handleUpdateUserCommand(UpdateUserCommand command) {
        User user = UserUtility.recreateUserState(writeRepository, command.getUserId());
        List<Event> events = new ArrayList<>();

        List<Contact> contactsToRemove = user.getContacts().stream()
                .filter(c -> !command.getContacts().contains(c))
                .collect(Collectors.toList());
        for (Contact contact : contactsToRemove) {
            UserContactRemovedEvent contactRemovedEvent = new UserContactRemovedEvent(contact.getType(), contact.getDetail());
            events.add(contactRemovedEvent);
            writeRepository.addEvent(command.getUserId(), contactRemovedEvent);
        }

        List<Contact> contactsToAdd = command.getContacts().stream()
                .filter(c -> !user.getContacts().contains(c))
                .collect(Collectors.toList());
        for (Contact contact : contactsToAdd) {
            UserContactAddedEvent contactAddedEvent = new UserContactAddedEvent(contact.getType(), contact.getDetail());
            events.add(contactAddedEvent);
            writeRepository.addEvent(command.getUserId(), contactAddedEvent);
        }

        List<Address> addressesToRemove = user.getAddresses().stream()
                .filter(a -> !command.getAddresses().contains(a))
                .collect(Collectors.toList());
        for (Address address : addressesToRemove) {
            UserAddressRemovedEvent addressRemovedEvent = new UserAddressRemovedEvent(address.getCity(), address.getState(), address.getPostCode());
            events.add(addressRemovedEvent);
            writeRepository.addEvent(command.getUserId(), addressRemovedEvent);
        }

        List<Address> addressesToAdd = command.getAddresses().stream()
                .filter(a -> !user.getAddresses().contains(a))
                .collect(Collectors.toList());
        for (Address address : addressesToAdd) {
            UserAddressAddedEvent addressAddedEvent = new UserAddressAddedEvent(address.getCity(), address.getState(), address.getPostCode());
            events.add(addressAddedEvent);
            writeRepository.addEvent(command.getUserId(), addressAddedEvent);
        }

        return events;
    }
}
