package com.globant.restservice.cqrs.read.daos;

import com.globant.restservice.cqrs.read.models.ProductDisplay;
import com.globant.restservice.cqrs.read.models.ProductInventory;

import java.util.List;

public interface ProductsDao {
    public ProductDisplay findById(int productId);
    public List<ProductDisplay> findByName(String name);
    public List<ProductInventory> findOutOfStockProducts();
    public List<ProductDisplay> findRelatedProducts(int productId);
}
