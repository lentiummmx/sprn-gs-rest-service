package com.globant.restservice.evt_src_cqrs.evtsrc.utils;

import com.globant.restservice.evt_src_cqrs.base.models.User;
import com.globant.restservice.evt_src_cqrs.evtsrc.events.Event;
import com.globant.restservice.evt_src_cqrs.evtsrc.stores.EventStore;

import java.util.List;

public class UserUtility {

    public static User recreateUserState(EventStore store, String userId) {
        List<Event> evts = store.getEvents(userId);

        return null;
    }
}
