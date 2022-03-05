package com.targetindia.programs;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StringDemo {

    public static void main(String[] args) {
        // The String class (defined in java.lang package) contains a final byte[]
        // which means once the size of the byte[] is defined, it cannot be changed.
        // Hence, Strings are immutable
        String name;

        name = new String(); // useless assignment, since I cannot change the value of this String

        name = new String("Vinod");
        // this is a totally new string object, and previous object is not considered as garbage
        String name1 = new String("Vinod");

        log.debug("name == name1 is {}", name == name1); // reference check
        log.debug("name.equals(name1) is {}", name.equals(name1)); // value check

        String str1 = "This is a string"; // since this string is found for the first time, String class creates a new
        // object and stores in the cache ('intern')

        String str2 = "This is a string"; // since this string is already in the cache, it is just being referenced by
        // str2

        // in other words, both str1 and str2 (2 references) are referencing to the same object in the cache
        // Hence, str1==str2 is also true; as well as str1.equals(str2);

        log.debug("str1==str2 is {} and str1.equals(str2) is {}", str1 == str2, str1.equals(str2));

        str2 += ", but a new one";
        log.debug("str1==str2 is {} and str1.equals(str2) is {}", str1 == str2, str1.equals(str2));
        str2 = "This is a string"; // once again, str2 refers to an already existing string in the caceh
        log.debug("str1==str2 is {} and str1.equals(str2) is {}", str1 == str2, str1.equals(str2));
    }
}
