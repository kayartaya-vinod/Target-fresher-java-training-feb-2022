package com.targetindia.programs;


import com.targetindia.utils.KeyboardUtil;

public class PrintMaxDaysInMonth {
    public static void main(String[] args) {

        int month = KeyboardUtil.getInt("Enter the month number (1-12): ");

        if (month < 1 || month > 12) {
            System.out.println("Invalid month number, must be between 1 and 12.");
        } else {
            if (month == 2) {
                System.out.println("There are 28 days in the month number " + month);
            } else if (month == 4 || month == 6 || month == 9 || month == 11) {
                System.out.println("The input month has 30 days");
            } else {
                System.out.println("The input month has 31 days");
            }
        }
    }
}
