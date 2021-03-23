package com.globant.restservice.cqrs.read.models;

import lombok.Data;

@Data
public class ProductInventory {

    public int id;
    public String name;
    public double currentStock;

}
