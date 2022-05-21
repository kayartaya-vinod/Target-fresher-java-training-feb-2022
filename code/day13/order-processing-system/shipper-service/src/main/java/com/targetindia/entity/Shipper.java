package com.targetindia.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "SHIPPERS")
public class Shipper {
    @Id
    @Column(name = "SHIPPER_ID")
    private Integer id;
    @Column(name = "COMPANY_NAME")
    private String companyName;
    private String phone;
}
