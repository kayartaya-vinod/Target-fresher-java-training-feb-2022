package com.targetindia.programs;

import com.targetindia.model.Employee;
import com.targetindia.utils.KeyboardUtil;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class ObjectSerializationDemo {
    public static void main(String[] args) throws Exception {

        String filename = "employees.data";
        try (
                FileOutputStream file = new FileOutputStream(filename);
                ObjectOutputStream out = new ObjectOutputStream(file);
        ) {
            while (true) {
                int id = KeyboardUtil.getInt("Enter id: ");
                String name = KeyboardUtil.getString("Enter name: ");
                double salary = KeyboardUtil.getDouble("Enter salary: ");

                Employee emp = new Employee(id, name, salary);
                out.writeObject(emp);

                String choice = KeyboardUtil.getString(
                        "Want to add another? (yes/no) (yes) ");

                if (choice.equalsIgnoreCase("yes") == false &&
                        choice.trim().length() != 0) {
                    break;
                }
            }
        }// out.close() and file.close() called


    }
}
