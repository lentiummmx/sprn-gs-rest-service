package com.globant.restservice.evt_src_cqrs.cqrs.repositories;

import com.globant.restservice.evt_src_cqrs.base.models.User;

import java.util.HashMap;
import java.util.Map;

public class UserWriteRepository {
    private Map<String, User> store = new HashMap<>();
    // accessors and mutators

    public void addUser(String userId, User user) {
        store.put(userId, user);
    }

    public User getUser(String userId) {
        return store.get(userId);
    }
}
