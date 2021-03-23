package com.globant.restservice.cqrs.write.commands.impl;

import com.globant.restservice.cqrs.write.commands.ICommand;
import lombok.Data;

import java.util.UUID;

@Data
public class RateProduct implements ICommand {

    public UUID id;
    public int productId;
    public int rating;
    public int userId;

    public RateProduct() {
        this.id = UUID.randomUUID();
    }
}
