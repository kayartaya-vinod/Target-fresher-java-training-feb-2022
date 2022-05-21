package com.targetindia.model;

import lombok.Data;

import java.util.Date;

@Data
public class EmployeeDto {
    private Integer id;
    private String lastname;
    private String firstname;
    private String title;
    private String titleOfCourtesy;
    private Date birthDate;
    private Date hireDate;
    private String address;
    private String city;
    private String region;
    private String postalCode;
    private String homePhone;
    private String extension;
    private String notes;
}
