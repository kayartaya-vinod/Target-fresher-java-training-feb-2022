package com.targetindia.programs;

import com.targetindia.utils.KeyboardUtil;

public class PrintFactorial {

    public static void main(String[] args) {
        int num = KeyboardUtil.getInt("Enter a positive number: ");
        if (num <= 0) {
            System.out.println("Hey, please input a positive number.");
            System.exit(1); // 0 --> normal exit; any other number is considered as abnormal/error
        }

        long fact = 1;

        while (num > 1) {
            fact *= num--;
        }

        System.out.printf("Factorial of %d is %d\n", num, fact);

    }
}
