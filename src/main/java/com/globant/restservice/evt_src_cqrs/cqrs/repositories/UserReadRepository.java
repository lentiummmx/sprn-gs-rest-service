package com.globant.restservice.evt_src_cqrs.cqrs.repositories;

import com.globant.restservice.evt_src_cqrs.cqrs.rmodels.UserAddress;
import com.globant.restservice.evt_src_cqrs.cqrs.rmodels.UserContact;

import java.util.HashMap;
import java.util.Map;

public class UserReadRepository {
    private Map<String, UserAddress> userAddress = new HashMap<>();
    private Map<String, UserContact> userContact = new HashMap<>();
    // accessors and mutators

    public UserContact getUserContact(String userId) {
        return userContact.get(userId);
    }

    public UserAddress getUserAddress(String userId) {
        return userAddress.get(userId);
    }

    public void addUserContact(String userId, UserContact userContact) {
        this.userContact.put(userId, userContact);
    }

    public void addUserAddress(String userId, UserAddress userAddress) {
        this.userAddress.put(userId, userAddress);
    }
}
