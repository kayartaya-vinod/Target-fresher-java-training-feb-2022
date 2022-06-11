package com.targetindia.model;

import lombok.Data;

@Data
public class ProductDto {
    private Integer productId;
    private String productName;
    private String quantityPerUnit;
    private Double unitPrice;
    private Integer unitsInStock;
    private Integer unitsOnOrder;
    private Integer reorderLevel;
    private Boolean discontinued;
}
