package com.targetindia.programs;

import java.io.IOException;

public class ReadFromKeyboardDemo2 {

    public static void main(String[] args) throws IOException {
        byte[] bytes = new byte[100];

        System.out.print("Enter some text: ");
        System.in.read(bytes);
        String text = new String(bytes).trim();

        System.out.println("Your input is: " + text + ".");

    }
}
