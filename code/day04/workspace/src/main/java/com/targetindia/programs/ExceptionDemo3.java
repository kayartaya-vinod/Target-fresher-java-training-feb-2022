package com.targetindia.programs;

import com.targetindia.utils.KeyboardUtil;

import java.io.FileReader;

public class ExceptionDemo3 {
    public static void main(String[] args) {
        String filename = KeyboardUtil.getString(
                "Enter absolute / relative file path: ");

        try (
                FileReader reader = new FileReader(filename);
                MyBufferedReader in = new MyBufferedReader(reader);
        ) {
            String line;

            while((line=in.readLine())!=null){
                System.out.println(line);
                throw new RuntimeException("deliberate exception");
            }
        } // in.close() and reader.close() called automatically
        catch (Exception ex) {
            System.out.println("There wan error - " + ex.getMessage());
        }
    }
}
