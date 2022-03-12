package com.targetindia.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Circle implements Shape {
    // members with restricted access
    // only other member methods in this class can access these private members
    private String color;
    private double radius;

    // package level access applied; only classes in this package can access them.
    Circle(){
    }

    public Circle(double radius){
        this.setRadius(radius);
    }

    public void setRadius(double radius) {
        if(radius<0){
            throw new RuntimeException("Radius must be >= 0");
        }
        // Inside this block, we have access to two variables with name "radius".
        // one is the local/parameter variable; and other is the member variable.
        // to distinguish the member from the local, we use a prefix of "this."
        this.radius = radius;
    }

    public double getArea(){
        return this.radius * this.radius * Math.PI;
    }
}
