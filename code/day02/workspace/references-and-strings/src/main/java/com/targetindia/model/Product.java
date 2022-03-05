package com.targetindia.model;

import lombok.Data;

@Data
public class Product {
    private int id;
    private String name;
    private String description;
    private double unitPrice;
    private int unitsInStock;
}
