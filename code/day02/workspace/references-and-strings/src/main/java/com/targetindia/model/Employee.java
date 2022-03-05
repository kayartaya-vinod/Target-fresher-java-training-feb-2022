package com.targetindia.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// by creating a class (or interface or enum or annotation), we created a data type
public class Employee {

    static Logger log = LoggerFactory.getLogger(Employee.class);

    // member variables of the class Employee; they belong to an object.
    // members have access modifiers - private --> (default/package-level) --> protected --> public
    public int id; // 4 bytes
    public String name; // String is a built-in class; hence 8 bytes for the reference
    public double salary; // 8 bytes

    public void printInfo(){
        log.trace("printInfo() is not ready yet");
    }

}
