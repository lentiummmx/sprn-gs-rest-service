package com.globant.restservice.evt_src_cqrs.evtsrc.events;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

public abstract class Event {
    public final UUID id = UUID.randomUUID();
    public final Date created = new Date();
}
