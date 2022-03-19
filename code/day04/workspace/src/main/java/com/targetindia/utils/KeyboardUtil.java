package com.targetindia.utils;

import java.util.Scanner;

// don't let anyone inherit this class
public final class KeyboardUtil {

    // don't let anyone instantiate this class
    private KeyboardUtil(){}

    public static String getString(String message){
        System.out.print(message);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public static double getDouble(String message){
        System.out.print(message);
        Scanner sc = new Scanner(System.in);
        return sc.nextDouble();
    }
    public static int getInt(String message){
        System.out.print(message);
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
}
