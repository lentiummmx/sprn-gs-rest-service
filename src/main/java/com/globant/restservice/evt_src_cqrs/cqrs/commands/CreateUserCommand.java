package com.globant.restservice.evt_src_cqrs.cqrs.commands;

import lombok.Data;

@Data
public class CreateUserCommand {
    private String userId;
    private String firstName;
    private String lastName;
}
