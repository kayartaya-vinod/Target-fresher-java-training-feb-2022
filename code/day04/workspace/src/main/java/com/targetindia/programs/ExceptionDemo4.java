package com.targetindia.programs;

import com.targetindia.exceptions.InvalidEmployeeIdException;
import com.targetindia.exceptions.InvalidNameException;
import com.targetindia.exceptions.InvalidSalaryException;
import com.targetindia.model.Employee;

public class ExceptionDemo4 {

    public static void main(String[] args) {

        Employee emp1;

        try {
            emp1 = new Employee(123, "John Miller", 30900);
            System.out.println(emp1);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        try {
            emp1 = new Employee();
            emp1.setId(1122);
            emp1.setName("John");
            emp1.setSalary(59000);

            System.out.println(emp1);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }
}
