package com.globant.restservice.cqrs.write.aggregators.intfc;

import com.globant.restservice.cqrs.write.aggregators.ICommandHandler;
import com.globant.restservice.cqrs.write.commands.impl.ConfirmItemShipped;

public interface ConfirmItemShippedCommandHandler extends ICommandHandler<ConfirmItemShipped> {
}
