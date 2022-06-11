package com.targetindia.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class OrderDto {
    private Integer id;
    private Date orderDate;
    private Date requiredDate;
    private Date shippedDate;
    private Double freight;
    private String shippingName;
    private String shippingAddress;
    private String shippingCity;
    private String shippingRegion;
    private String shippingPostalCode;
    private String shippingCountry;

    private ShipperDto shippedBy;
    private CustomerDto customer;
    private EmployeeDto employee;

    private List<LineItemDto> lineItems = new ArrayList<>();
}
