package com.globant.restservice.evt_src_cqrs.evtsrc.stores;

import com.globant.restservice.evt_src_cqrs.evtsrc.events.Event;
import com.globant.restservice.evt_src_cqrs.evtsrc.events.impl.UserCreatedEvent;

import java.util.*;

/**
 * like repository
 */
public class EventStore {
    private Map<String, List<Event>> store = new HashMap<>();

    public void addEvent(String userId, Event event) {
        List<Event> events = Optional.ofNullable(store.get(userId)).orElse(new ArrayList<>());
        events.add(event);
        store.put(userId, events);
    }

    public List<Event> getEvents(String userId) {
        return Optional.ofNullable(store.get(userId)).orElse(new ArrayList<>());
    }
}
