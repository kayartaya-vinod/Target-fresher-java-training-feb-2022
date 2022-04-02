package com.targetindia.programs;

import com.targetindia.model.Employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CollectionsUtilityDemo {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1122, "Vishal", 45000));
        employees.add(new Employee(2122, "Ramesh", 35000));
        employees.add(new Employee(7822, "Naveen", 45600));
        employees.add(new Employee(6726, "Neeraj", 65000));
        employees.add(new Employee(7833, "Nishchal", 35600));
        employees.add(new Employee(2155, "Rajesh", 35000));
        employees.add(new Employee(9822, "Nimesh", 45600));
        employees.add(new Employee(6777, "Girija", 65000));

        for (Employee emp : employees) {
            System.out.println(emp);
        }

        System.out.println("-".repeat(50));

        // Collections.sort(employees);
        // Collections.sort(employees, (e1, e2) -> e1.getName().compareTo(e2.getName()));
        Collections.sort(employees, (e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        for (Employee emp : employees) {
            System.out.println(emp);
        }

        System.out.println("-".repeat(50));

        Iterator<Employee> it = employees.iterator();

        while(it.hasNext()){
            Employee emp = it.next();
            System.out.println(emp);
        }
    }
}
