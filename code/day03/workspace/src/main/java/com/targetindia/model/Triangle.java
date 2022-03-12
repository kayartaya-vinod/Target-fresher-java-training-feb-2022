package com.targetindia.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// by implementing an interface, this class gets into a contract with the interface.
// it must provide (implement) method bodies for all abstract functions.
// This is the same effect, if Shape were a class and has an abstract method and this class inherits from Shape
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Triangle implements Shape{

    private double base;
    private double height;

    @Override
    public double getArea() {
        return 0.5 * base * height;
    }
}
