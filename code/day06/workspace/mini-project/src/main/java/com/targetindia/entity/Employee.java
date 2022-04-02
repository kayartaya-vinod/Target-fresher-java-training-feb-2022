package com.targetindia.entity;

import lombok.Data;

@Data
public class Employee {
    private int id;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private double salary;
}
