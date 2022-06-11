package com.targetindia.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name="ORDER_DETAILS")
public class LineItem implements Serializable {
    @Id
    @Column(name="ORDER_ID")
    private Integer orderId;
    @Id
    @Column(name="PRODUCT_ID")
    private Integer productId;
    @Column(name="UNIT_PRICE")
    private Double unitPrice;
    private Integer quantity;
    private Double discount;
}
