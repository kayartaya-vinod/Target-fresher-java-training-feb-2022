package com.targetindia.programs;

import com.targetindia.utils.KeyboardUtil;

public class PrintMaxDaysInMonthAndYear {
    public static void main(String[] args) {
        int month = KeyboardUtil.getInt("Enter month number: (1-12) ");

        if(month<1 || month>12){
            System.out.println("Month must be between 1 and 12");
            return;
        }
        int year = KeyboardUtil.getInt("Enter year: (>=1900) ");

        if(year<1900){
            System.out.println("Year must be >= 1900");
            return; // takes the control away from the main()
        }

        switch(month){
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.printf("There are 30 days in %d/%d\n", month, year);
                break; // this takes the control outside the switch block
            case 2:
                if(year%400==0 || (year%4==0 && year%100!=0)){
                    System.out.printf("There are 29 days in %d/%d\n", month, year);
                }
                else {
                    System.out.printf("There are 28 days in %d/%d\n", month, year);
                }
                break;
            default:
                System.out.printf("There are 31 days in %d/%d\n", month, year);
        }

    }
}
