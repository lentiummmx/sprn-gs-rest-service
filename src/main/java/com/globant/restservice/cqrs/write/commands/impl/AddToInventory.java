package com.globant.restservice.cqrs.write.commands.impl;

import com.globant.restservice.cqrs.write.commands.ICommand;
import lombok.Data;

import java.util.UUID;

@Data
public class AddToInventory implements ICommand {

    public UUID id;

    public AddToInventory() {
        this.id = UUID.randomUUID();
    }
}
