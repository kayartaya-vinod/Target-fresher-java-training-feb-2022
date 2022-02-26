package com.targetindia.programs;

import com.targetindia.utils.KeyboardUtil;

public class DoWhileDemo {
    public static void main(String[] args) {

        int num1;
        int num2;
        int choice;

        num1 = KeyboardUtil.getInt("Enter number 1: ");
        num2 = KeyboardUtil.getInt("Enter number 1: ");

        do {

            System.out.println("1. Change inputs");
            System.out.println("2. Print sum");
            System.out.println("3. Print difference");
            System.out.println("4. Print product");
            System.out.println("5. Print quotient");
            System.out.println("6. Remainder");
            System.out.println("7. Exit");
            choice = KeyboardUtil.getInt("Enter your choice: ");

            switch (choice) {
                case 1:
                    num1 = KeyboardUtil.getInt("Enter number 1: ");
                    num2 = KeyboardUtil.getInt("Enter number 1: ");
                    break;
                case 2:
                    System.out.printf("Sum of %d and %d is %d\n", num1, num2, num1 + num2);
                    break;
                case 3:
                    System.out.printf("Difference of %d and %d is %d\n", num1, num2, num1 - num2);
                    break;
                case 4:
                    System.out.printf("Product of %d multiplied by %d is %d\n", num1, num2, num1 * num2);
                    break;
                case 5:
                    System.out.printf("Quotient of %d divided by %d is %d\n", num1, num2, num1 / num2);
                    break;
                case 6:
                    System.out.printf("Remainder of %d and %d is %d\n", num1, num2, num1 % num2);
                    break;
                case 7:
                    System.out.println("Thank you, have a nice day.");
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
            }
        } while (choice != 7);


    }
}
