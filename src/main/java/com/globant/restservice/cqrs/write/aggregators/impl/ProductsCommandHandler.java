package com.globant.restservice.cqrs.write.aggregators.impl;

import com.globant.restservice.cqrs.write.commands.ICommand;
import com.globant.restservice.cqrs.write.commands.impl.*;
import com.globant.restservice.cqrs.write.aggregators.ICommandHandler;
import com.globant.restservice.cqrs.repositories.IRepository;
import com.globant.restservice.cqrs.models.Product;

public class ProductsCommandHandler implements ICommandHandler<ICommand>
//public class ProductsCommandHandler implements
//        ICommandHandler<AddNewProduct>,
//        AddNewProductCommandHandler,
//        ICommandHandler<RateProduct>,
//        RateProductCommandHandler,
//        ICommandHandler<AddToInventory>,
//        AddToInventoryCommandHandler,
//        ICommandHandler<ConfirmItemShipped>,
//        ConfirmItemShippedCommandHandler,
//        ICommandHandler<UpdateStockFromInventoryRecount>
//        UpdateStockFromInventoryRecountCommandHandler
{

    private final IRepository<Product> repository;

    public ProductsCommandHandler(IRepository<Product> repository) {
        this.repository = repository;
    }

    @Override
    public void handle(ICommand command) {
        if (command instanceof AddNewProduct)
            handle((AddNewProduct) command);
        if (command instanceof RateProduct)
            handle((RateProduct) command);
        if (command instanceof AddToInventory)
            handle((AddToInventory) command);
        if (command instanceof ConfirmItemShipped)
            handle((ConfirmItemShipped) command);
        if (command instanceof UpdateStockFromInventoryRecount)
            handle((UpdateStockFromInventoryRecount) command);
    }

    public void handle(AddNewProduct command) {
        // ...
    }

    public void handle(RateProduct command) {
        Product product = repository.find(command.getProductId());
        if (product != null) {
            product.rateProduct(command.getUserId(), command.getRating());
            repository.save(product);
        }
    }

    public void handle (AddToInventory command) {
        // ...
    }

    public void handle (ConfirmItemShipped command) {
        // ...
    }

    public void handle (UpdateStockFromInventoryRecount command) {
        // ...
    }
}
