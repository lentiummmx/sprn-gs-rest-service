package com.globant.restservice.cqrs.write.aggregators.intfc;

import com.globant.restservice.cqrs.write.aggregators.ICommandHandler;
import com.globant.restservice.cqrs.write.commands.impl.AddToInventory;

public interface AddToInventoryCommandHandler extends ICommandHandler<AddToInventory> {
}
