package com.targetindia.entity;

import lombok.Data;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name="customers")
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String firstname;
    private String lastname;
    private String gender;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String phone;
    private String address;
    private String city;
    private String state;
    private String country;
    private boolean isActive;
}
