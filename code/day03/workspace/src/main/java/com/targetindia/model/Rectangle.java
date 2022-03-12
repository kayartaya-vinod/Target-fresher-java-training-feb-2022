package com.targetindia.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rectangle implements Shape {
    private double length;
    private double width;

    @Override
    public double getArea() {
        return length * width;
    }
}
