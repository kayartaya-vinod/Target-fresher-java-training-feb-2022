package com.targetindia.programs;

import java.io.IOException;

public class ReadFromKeyboardDemo1 {

    public static void main(String[] args) throws IOException {
        String text = "";
        int b;

        System.out.print("Enter some text: ");
        while ((b = System.in.read()) != '\n') {
            text += (char) b;
        }
        System.out.println("Your input is: " + text);

    }
}
