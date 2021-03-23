package com.globant.restservice.cqrs.write.aggregators.intfc;

import com.globant.restservice.cqrs.write.aggregators.ICommandHandler;
import com.globant.restservice.cqrs.write.commands.impl.RateProduct;

public interface RateProductCommandHandler extends ICommandHandler<RateProduct> {
}
