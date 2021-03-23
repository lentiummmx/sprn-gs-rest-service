package com.globant.restservice.cqrs.write.commands.impl;

import com.globant.restservice.cqrs.write.commands.ICommand;
import lombok.Data;

import java.util.UUID;

@Data
public class ConfirmItemShipped implements ICommand {

    public UUID id;

    public ConfirmItemShipped() {
        this.id = UUID.randomUUID();
    }
}
