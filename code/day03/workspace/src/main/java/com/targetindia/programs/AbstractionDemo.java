package com.targetindia.programs;

import com.targetindia.model.Circle;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AbstractionDemo {
    // main method is called by JRE
    public static void main(String[] args) {
        Circle circle1;

        circle1 = new Circle(-23.45);
        double area = circle1.getArea();
        log.trace("radius = {}, area = {}", circle1.getRadius(), area);
        circle1.setRadius(1.23); // exception received here will be delegated to the caller of main (i.e, JRE)
        area = circle1.getArea();
        log.trace("radius = {}, area = {}", circle1.getRadius(), area);

    }
}
