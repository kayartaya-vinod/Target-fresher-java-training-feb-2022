package com.targetindia.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@NoArgsConstructor
public class Person {
    private String name;
    private String email;
    // aggregation
    @Delegate
    private Address address = new Address();

    public Person(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public void log(){
        log.trace("name     = {}", this.name);
        log.trace("email    = {}", this.email);
        log.trace("street   = {}", this.getStreet());
        log.trace("city     = {}", this.getStreet());
        log.trace("state    = {}", this.getState());
        log.trace("pincode  = {}", this.getPincode());
        log.trace("country  = {}", this.getCountry());
    }

}

