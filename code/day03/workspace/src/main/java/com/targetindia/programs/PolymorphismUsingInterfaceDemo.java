package com.targetindia.programs;

import com.targetindia.model.Circle;
import com.targetindia.model.Rectangle;
import com.targetindia.model.Shape;
import com.targetindia.model.Triangle;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PolymorphismUsingInterfaceDemo {

    // example of a polymorphic function
    // it is a good practice to pass and return interface types than class types
    static void printShapeInformation(Shape shape){
        log.trace("The variable shape refers to an object of {}", shape.getClass().getName());
        log.trace("Area of the shape is {} sq.units.", shape.getArea());
    }


    public static void main(String[] args) {
        Triangle t1 = new Triangle(12.3, 45.6);

        // t1 is an instance of Triangle
        // t1 is an instance of java.lang.Object
        // t1 is an instance of Shape (interface)

        printShapeInformation(t1);
        Circle c1 = new Circle(12.34);
        printShapeInformation(c1);
        printShapeInformation(new Rectangle(12.34, 56.78));
    }
}
