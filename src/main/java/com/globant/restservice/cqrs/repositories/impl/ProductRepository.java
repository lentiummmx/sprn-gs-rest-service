package com.globant.restservice.cqrs.repositories.impl;

import com.globant.restservice.cqrs.repositories.IRepository;
import com.globant.restservice.cqrs.models.Product;

public class ProductRepository implements IRepository<Product> {
    @Override
    public Product find(int id) {
        return null;
    }

    @Override
    public Product save(Product entity) {
        return null;
    }
}
