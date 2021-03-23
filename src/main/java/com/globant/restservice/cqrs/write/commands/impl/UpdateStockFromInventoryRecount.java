package com.globant.restservice.cqrs.write.commands.impl;

import com.globant.restservice.cqrs.write.commands.ICommand;
import lombok.Data;

import java.util.UUID;

@Data
public class UpdateStockFromInventoryRecount implements ICommand {

    public UUID id;

    public UpdateStockFromInventoryRecount() {
        this.id = UUID.randomUUID();
    }
}
