package com.targetindia.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="customer-list")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
@NoArgsConstructor
public class CustomerList {
    @XmlElement(name="customer")
    private List<Customer> customers;

    public CustomerList(List<Customer> customers) {
        this.customers = customers;
    }
}
