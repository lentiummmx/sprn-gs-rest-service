package com.globant.restservice.evt_src_cqrs.cqrs.rmodels;

import com.globant.restservice.evt_src_cqrs.base.models.Address;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Data
public class UserAddress {
    private Map<String, Set<Address>> addressByRegion = new HashMap<>();
}
