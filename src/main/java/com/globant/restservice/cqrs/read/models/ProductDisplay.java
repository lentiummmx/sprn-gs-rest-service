package com.globant.restservice.cqrs.read.models;

import lombok.Data;

@Data
public class ProductDisplay {

    public int id;
    public String name;
    public String description;
    public double unitPrice;
    public boolean isOutOfStock;
    public double userRating;

}
