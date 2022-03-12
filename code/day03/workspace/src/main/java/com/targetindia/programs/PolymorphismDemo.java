package com.targetindia.programs;

import com.targetindia.model.Animal;
import com.targetindia.model.Cat;
import com.targetindia.model.Dog;
import com.targetindia.model.Tiger;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PolymorphismDemo {

    public static void main(String[] args) {

        // just a reference variable; not referring any object currently
        Animal animal;

        animal = new Tiger();
        animal.whoAmI();
        animal.talk(); // compiler checks for the existence of this method in Animal;
        // JRE executes from the object that this reference is referencing to

        // if you wish to call a subclass (Tiger) method using the superclass variable when
        // it is referencing to an object of the subclass, down-castinng has to be done.
        // animal.dance(); // error; cannot call subclass function; even if animal is a Tiger instance
        ((Tiger) animal).dance();

        animal = new Cat();
        animal.whoAmI();
        animal.talk();


        animal = new Dog();
        animal.whoAmI();
        animal.talk();

        if(animal instanceof Dog){
            Dog dog;
            dog = (Dog) animal;
            log.trace("dog = {}", dog);
        }

        String str = "123";
        Integer num = Integer.valueOf(str);

    }
}
