package com.globant.restservice.evt_src_cqrs.cqrs.queries;

import lombok.Data;

@Data
public class ContactByTypeQuery {
    private String userId;
    private String contactType;
}
