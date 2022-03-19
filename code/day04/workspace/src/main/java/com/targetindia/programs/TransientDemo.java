package com.targetindia.programs;

import com.targetindia.model.Employee;
import com.targetindia.utils.KeyboardUtil;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class TransientDemo {
    public static void main(String[] args) throws Exception {

        String filename = "employees_new.data";
        try (
                FileOutputStream file = new FileOutputStream(filename);
                ObjectOutputStream out = new ObjectOutputStream(file);
        ) {

            Employee emp = new Employee(9928, "Kelly", 34000);
            emp.getAddress().setStreet("1st cross, 2nd main");
            emp.getAddress().setArea("ACME Lyt");
            emp.getAddress().setCity("Bangalore");
            emp.getAddress().setState("Karnataka");
            emp.getAddress().setCountry("India");

            out.writeObject(emp);


        }// out.close() and file.close() called

        System.out.println("Data stored in the file");
    }
}
