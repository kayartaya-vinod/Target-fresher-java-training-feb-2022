package com.targetindia.programs;

import com.targetindia.utils.KeyboardUtil;

public class CheckForEvenOdd {

    public static void main(String[] args) {
        int num = KeyboardUtil.getInt("Enter a number: ");

        System.out.println("Value of num is " + num);

//        if (num % 2 == 0) {
//            System.out.println(num + " is an even number.");
//        }
//        else {
//            System.out.println(num + " is an odd number.");
//        }

        System.out.println(num + " is an " + (num % 2 == 0 ? "even" : "odd") + " number");
    }
}
