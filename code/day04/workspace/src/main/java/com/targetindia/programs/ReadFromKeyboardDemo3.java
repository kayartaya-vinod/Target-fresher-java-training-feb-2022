package com.targetindia.programs;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadFromKeyboardDemo3 {

    public static void main(String[] args) throws IOException {

        // this is an adaptor; converts an InputStream to a Reader object
        InputStreamReader isr = new InputStreamReader(System.in);

        // this is a decorator; adds additional functionality to the underlying object
        BufferedReader in = new BufferedReader(isr);

        System.out.print("What's your name? ");
        String name = in.readLine();

        System.out.print("Where are you from? ");
        String city = in.readLine();

        System.out.print("How old are you? ");
        int age = Integer.valueOf(in.readLine());

        System.out.printf("%s from %s is %d years old.%n", name, city, age);
    }
}
