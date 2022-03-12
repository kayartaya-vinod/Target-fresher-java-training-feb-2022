package com.targetindia.programs;

import com.targetindia.model.Person;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AggregationDemo {

    public static void main(String[] args) {

        Person p1;
        p1 = new Person("Vinod", "vinod@vinod.co");

        // using delegate methods
        p1.setStreet("1st crs, 1st mn, ISRO lyt");
        p1.setPincode("560078");
        // not using delegate methods
        p1.getAddress().setState("Karnataka");
        p1.getAddress().setCountry("India");
        log.trace("p1 = {}", p1);
    }
}
