package com.targetindia.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "ORDERS")
public class Order {
    @Id
    @Column(name = "order_id")
    private Integer id;
    @Column(name = "order_date")
    private Date orderDate;
    @Column(name = "required_date")
    private Date requiredDate;
    @Column(name = "shipped_date")
    private Date shippedDate;
    private Double freight;
    @Column(name = "ship_name")
    private String shippingName;
    @Column(name = "ship_address")
    private String shippingAddress;
    @Column(name = "ship_city")
    private String shippingCity;
    @Column(name = "ship_region")
    private String shippingRegion;
    @Column(name = "ship_postal_code")
    private String shippingPostalCode;
    @Column(name = "ship_country")
    private String shippingCountry;

    @Column(name = "ship_via")
    private Integer shippedBy;
    @Column(name = "customer_id")
    private String customerId;
    @Column(name = "employee_id")
    private Integer employeeId;

    // one-to-many mapping (one order has many line items)
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name="ORDER_ID")
    private List<LineItem> lineItems;
}
