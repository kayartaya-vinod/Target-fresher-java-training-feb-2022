package com.targetindia.model;

import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;

@Slf4j
@Data
@ToString(callSuper = true)
public class Employee extends Person{
    private int id;
    private double salary;

    // this method HIDES the visibility of the inherited log() function.
    // this is known as method overriding.
    // When overriding a method, access modifier can only be more stronger/visible and not less visible (or weaker)
    // (weakest) private --> package-level --> protected --> public (strongest)
    public void log(){
        log.trace("id       = {}", this.id);
        super.log(); // we can invoke super class method from here (or any other member function of this class)
        log.trace("salary   = {}", this.salary);
    }

    // method overloading; arguments of functions with same name must differ in types/order/number
    public void log(String level, String message){
    }

}
