package com.targetindia.programs;

import com.targetindia.utils.KeyboardUtil;

public class PrintMultipleFactorials {

    static long factorial(int num) {
        long fact = 1;

        while (num > 1) {
            fact *= num--;
        }

        return fact;
    }

    public static void main(String[] args) {

        int start = KeyboardUtil.getInt("Enter first number: ");
        int end = KeyboardUtil.getInt("Enter second number: ");

        if (start >= end) {
            System.out.println("Enter two distinct numbers in ascending sequence.");
            System.exit(1);
        }

        // expr1 -> initialized; executed exactly onces
        // expr2 -> loop criteria; loop executes, if this criteria (boolean) is true
        // expr3 -> loop controller; increments/decrements the loop variable
        for (int n = start; n <= end; n++) {
            System.out.printf("Factorial of %d is %d\n", n, factorial(n));
        }


    }
}
