package com.targetindia.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String street;
    private String city = "Bangalore";
    private String state = "Karnataka";
    private String pincode;
    private String country = "India";
}
