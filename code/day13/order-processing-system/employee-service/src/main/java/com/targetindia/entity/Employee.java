package com.targetindia.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "EMPLOYEES")
public class Employee {
    @Id
    @Column(name = "employee_id")
    private Integer id;
    @Column(name = "last_name")
    private String lastname;
    @Column(name = "first_name")
    private String firstname;
    private String title;
    @Column(name = "title_of_courtesy")
    private String titleOfCourtesy;
    @Column(name = "birth_date")
    private Date birthDate;
    @Column(name = "hire_date")
    private Date hireDate;
    private String address;
    private String city;
    private String region;
    @Column(name = "postal_code")
    private String postalCode;
    @Column(name = "home_phone")
    private String homePhone;
    private String extension;
    @JsonIgnore
    private byte[] photo;
    private String notes;
}
