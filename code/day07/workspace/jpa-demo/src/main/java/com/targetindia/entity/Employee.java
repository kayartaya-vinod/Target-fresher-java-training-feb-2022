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
    private Integer id;
    @Column(name="firstname") // optional; since the name of the column matches the name of the field
    private String firstname;
    @Column // optional; since the name of the column matches the name of the field
    private String lastname;
    private String email;
    private String phone;
    private Double salary;
}
