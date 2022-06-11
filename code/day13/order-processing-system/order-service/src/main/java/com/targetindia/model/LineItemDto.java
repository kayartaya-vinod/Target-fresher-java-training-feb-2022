package com.targetindia.model;

import lombok.Data;

@Data
public class LineItemDto {
    private ProductDto product;
    private Double unitPrice;
    private Integer quantity;
    private Double discount;
}
