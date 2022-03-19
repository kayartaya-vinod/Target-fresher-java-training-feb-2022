package com.targetindia.programs;

import com.targetindia.model.Employee;
import com.targetindia.utils.KeyboardUtil;

import java.io.*;

public class ObjectDeserializationDemo {
    public static void main(String[] args) throws Exception {

        String filename = "employees.data";
        try (
                FileInputStream file = new FileInputStream(filename);
                ObjectInputStream in = new ObjectInputStream(file);
        ) {
            while (true) {
                try {
                    Employee emp = (Employee) in.readObject();
                    System.out.println(emp);
                } catch (EOFException e) {
                    break;
                }
            }
        }// out.close() and file.close() called


    }
}
