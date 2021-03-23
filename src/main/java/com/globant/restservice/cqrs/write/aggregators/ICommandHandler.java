package com.globant.restservice.cqrs.write.aggregators;

import com.globant.restservice.cqrs.write.commands.ICommand;

public interface ICommandHandler<T extends ICommand> {
    public void handle(T command);
}
