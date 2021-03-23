package com.globant.restservice.cqrs.write.commands;

import java.util.UUID;

public interface ICommand {
    public UUID getId();
}
