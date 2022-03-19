package com.targetindia.programs;

import com.targetindia.utils.KeyboardUtil;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionDemo2 {

    public static void main(String[] args) {
        String filename = KeyboardUtil.getString("Enter absolute/relative path of the file: ");
        FileReader reader = null;

        try {
            reader = new FileReader(filename);
            int ch;

            while ((ch = reader.read()) != -1) {
                System.out.print((char) ch);
                // throw new RuntimeException("deliberate exception");
            }

        } catch (FileNotFoundException e) {
            System.out.printf("File '%s' does not exist!%n", filename);
        } catch (IOException e) {
            System.out.println("Error while reading the content");
        }
        finally {
            if(reader!=null){
                try {
                    reader.close();
                    System.out.println("reader object is closed now");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
