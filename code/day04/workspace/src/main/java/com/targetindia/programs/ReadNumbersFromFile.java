package com.targetindia.programs;

import com.targetindia.utils.KeyboardUtil;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadNumbersFromFile {
    public static void main(String[] args) throws Exception {

        String filename = "numbers.data";
        try (
                FileInputStream file = new FileInputStream(filename);
                DataInputStream in = new DataInputStream(file);
        ) {
            while(true) {
                try {
                    double num = in.readDouble();
                    System.out.println(num);
                } catch (EOFException e) {
                    break;
                }
            }
            System.out.println("End of main");

        } // file.close() called here
    }
}
