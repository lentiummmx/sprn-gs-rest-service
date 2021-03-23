package com.globant.restservice.evt_src_cqrs.cqrs.rmodels;

import com.globant.restservice.evt_src_cqrs.base.models.Contact;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Data
public class UserContact {
    private Map<String, Set<Contact>> contactByType = new HashMap<>();
}
