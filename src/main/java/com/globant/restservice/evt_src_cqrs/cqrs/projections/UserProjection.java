package com.globant.restservice.evt_src_cqrs.cqrs.projections;

import com.globant.restservice.evt_src_cqrs.base.models.Address;
import com.globant.restservice.evt_src_cqrs.base.models.Contact;
import com.globant.restservice.evt_src_cqrs.cqrs.queries.AddressByRegionQuery;
import com.globant.restservice.evt_src_cqrs.cqrs.queries.ContactByTypeQuery;
import com.globant.restservice.evt_src_cqrs.cqrs.rmodels.UserAddress;
import com.globant.restservice.evt_src_cqrs.cqrs.rmodels.UserContact;
import com.globant.restservice.evt_src_cqrs.cqrs.repositories.UserReadRepository;

import java.util.Set;

public class UserProjection {
    private UserReadRepository readRepository;

    public UserProjection(UserReadRepository repository) {
        this.readRepository = repository;
    }

    public Set<Contact> handle(ContactByTypeQuery query) {
        UserContact userContact = readRepository.getUserContact(query.getUserId());
        return userContact.getContactByType().get(query.getContactType());
    }

    public Set<Address> handle(AddressByRegionQuery query) {
        UserAddress userAddress = readRepository.getUserAddress(query.getUserId());
        return userAddress.getAddressByRegion().get(query.getState());
    }
}
