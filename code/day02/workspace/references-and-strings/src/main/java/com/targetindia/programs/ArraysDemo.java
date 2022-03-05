package com.targetindia.programs;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ArraysDemo {
    public static void main(String[] args) {
        String[] names = {"Vinod", "Shyam", "John", "Jane"};
        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            log.debug("name = {}", name);
        }

        log.debug("-".repeat(50));
        // enhanced for loop; since JDK 1.5
        for (String name : names) {
            log.debug("name = {}", name);
        }

        String joinedNames = String.join(", ", names);
        log.debug("joinedNams = {}", joinedNames);
    }
}
