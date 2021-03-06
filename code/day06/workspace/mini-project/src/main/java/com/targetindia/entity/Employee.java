package com.targetindia.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="empno")
    private int id;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private double salary;
}
