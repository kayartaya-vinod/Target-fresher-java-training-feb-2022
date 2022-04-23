package com.targetindia.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@XmlRootElement // required by JAXB 
@XmlAccessorType(XmlAccessType.FIELD) // refer only fields and not getters for generating XML 
@Data
@Entity
@Table(name="employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="empno")
    private Integer id;
    @Column(name="firstname") // optional; since the name of the column matches the name of the field
    private String firstname;
    @Column // optional; since the name of the column matches the name of the field
    private String lastname;
    private String email;
    private String phone;
    private Double salary;
}
