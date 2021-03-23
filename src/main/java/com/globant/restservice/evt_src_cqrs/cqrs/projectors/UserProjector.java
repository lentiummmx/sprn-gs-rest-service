package com.globant.restservice.evt_src_cqrs.cqrs.projectors;

import com.globant.restservice.evt_src_cqrs.base.models.Address;
import com.globant.restservice.evt_src_cqrs.base.models.Contact;
import com.globant.restservice.evt_src_cqrs.base.models.User;
import com.globant.restservice.evt_src_cqrs.cqrs.repositories.UserReadRepository;
import com.globant.restservice.evt_src_cqrs.cqrs.rmodels.UserAddress;
import com.globant.restservice.evt_src_cqrs.cqrs.rmodels.UserContact;

import java.util.*;

public class UserProjector {
    UserReadRepository repository = new UserReadRepository();

    public UserProjector(UserReadRepository repository) {
        this.repository = repository;
    }

    public void project(User user) {
        UserContact userContact = Optional.ofNullable(repository.getUserContact(user.getUserId())).orElse(new UserContact());
        Map<String, Set<Contact>> contactByType = new HashMap<>();
        for (Contact contact : user.getContacts()) {
            Set<Contact> contacts = Optional.ofNullable(contactByType.get(contact.getType())).orElse(new HashSet<>());
            contacts.add(contact);
            contactByType.put(contact.getType(), contacts);
        }
        userContact.setContactByType(contactByType);
        repository.addUserContact(user.getUserId(), userContact);

        UserAddress userAddress = Optional.ofNullable(repository.getUserAddress(user.getUserId())).orElse(new UserAddress());
        Map<String, Set<Address>> addressByRegion = new HashMap<>();
        for (Address address : user.getAddresses()) {
            Set<Address> addresses = Optional.ofNullable(addressByRegion.get(address.getState())).orElse(new HashSet<>());
            addresses.add(address);
            addressByRegion.put(address.getState(), addresses);
        }
        userAddress.setAddressByRegion(addressByRegion);
        repository.addUserAddress(user.getUserId(), userAddress);
    }

}
