package com.targetindia.programs;

import lombok.extern.slf4j.Slf4j;

import java.util.Locale;

@Slf4j
public class StringMethodsDemo {
    public static void main(String[] args) {

        String str = "My name is Vinod and I live in Bangalore. Bangalore is a nice city in Karnataka. Yes, Bangalore.";

        log.debug("str.length() is {}", str.length());
        str.toUpperCase(); // this has no effect; Strings are immutable
        // toUpperCase() creates a new String consisting of upper case version of 'str' and returns the same
        log.debug("str = {}", str);

        str = str.toUpperCase();
        log.debug("str = {}", str);

        int index = str.indexOf("VINOD");
        log.debug("index of VINOD in str = {}", index);

        index = str.indexOf("BANGALORE");
        log.debug("index of BANGALORE in str = {}", index);

        index = str.lastIndexOf("BANGALORE");
        log.debug("Last index of BANGALORE in str = {}", index);


        // find all indexes of "BANGALORE"
        int from = 0;
        while (true) {
            index = str.indexOf("BANGALORE", from);
            if (index == -1) {
                break;
            }
            log.debug("index = {}", index);
            from = index + 1;
        }

        // String in reverse order
        String rev = "";
        for (int i = 0, j = str.length(); i < j; i++) {
            rev = str.charAt(i) + rev;
        }
        log.debug("reversed string is {}", rev);

        log.debug("After 41st index, str contains \"{}\"", str.substring(42));
        log.debug("9 letters from 42nd index = \"{}\"", str.substring(42, 51));
        log.debug("After replacing BANGALORE with SHIVAMOGGA, str = \"{}\"",
                str.replaceAll("BANGALORE", "SHIVAMOGGA")
                        .replaceAll("I LIVE IN", "I AM FROM"));

        String name = "John Doe";
        int age = 45;
        String city = "Dallas";

        String str1 = String.format("%s (%d years old) lives in %s", name, age, city);
        log.debug("str1 = {}", str1);

    }
}
