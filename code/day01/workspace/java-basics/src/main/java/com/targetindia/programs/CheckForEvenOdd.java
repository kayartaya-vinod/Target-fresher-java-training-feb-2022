package com.targetindia.programs;

import java.util.Scanner;

public class CheckForEvenOdd {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = scanner.nextInt();

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
