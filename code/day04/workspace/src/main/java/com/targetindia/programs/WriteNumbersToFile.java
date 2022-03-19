package com.targetindia.programs;

import com.targetindia.utils.KeyboardUtil;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class WriteNumbersToFile {
    public static void main(String[] args) throws Exception {

        String filename = "numbers.data";
        try (
                FileOutputStream file = new FileOutputStream(filename);
                DataOutputStream out = new DataOutputStream(file);
        ) {
            while(true) {
                double num = KeyboardUtil.getDouble("Enter a number (0 to stop): ");
                if(num==0){
                    break;
                }

                out.writeDouble(num);
            }
            System.out.println("End of main");

        } // file.close() called here
    }
}
