package com.globant.restservice.cqrs.write.commands.impl;

import com.globant.restservice.cqrs.write.commands.ICommand;
import lombok.Data;

import java.util.UUID;

@Data
public class AddNewProduct implements ICommand {

    public UUID id;

    public AddNewProduct() {
        this.id = UUID.randomUUID();
    }
}
