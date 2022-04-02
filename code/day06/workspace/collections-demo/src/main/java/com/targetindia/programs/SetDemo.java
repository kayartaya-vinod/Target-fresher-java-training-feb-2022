package com.targetindia.programs;

import com.targetindia.model.Employee;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {
    public static void main(String[] args) {
        Set<Integer> numbers = new TreeSet<>();
        numbers.add(12);
        numbers.add(12); // ignored
        numbers.add(124);
        numbers.add(12); // ignored
        numbers.add(543);
        numbers.add(112); // ignored
        numbers.add(323);
        System.out.println("Size of numbers is " + numbers.size());
        System.out.println(numbers);

        Set<String> names = new TreeSet<>();
        names.add("Vinod");
        names.add("Kushal");
        names.add("Naveen");
        names.add("Vinod");
        names.add("Kushal");
        names.add("Naveen");
        names.add("Vishal");
        names.add("Ramesh");
        System.out.println(names);

        Set<Employee> employees = new HashSet<>();
        Employee emp;

        emp = new Employee(1122, "Vishal", 45000);
        employees.add(emp);
        System.out.println(emp.hashCode());

        emp = new Employee(2122, "Ramesh", 35000);
        employees.add(emp);
        System.out.println(emp.hashCode());

        emp = new Employee(7822, "Naveen", 45600);
        employees.add(emp);
        System.out.println(emp.hashCode());

        emp = new Employee(6726, "Neeraj", 65000);
        employees.add(emp);
        System.out.println(emp.hashCode());

        emp = new Employee(7833, "Nishchal", 35600);
        employees.add(emp);
        System.out.println(emp.hashCode());

        emp = new Employee(2122, "Ramesh", 35000);
        employees.add(emp);
        System.out.println(emp.hashCode());

        emp = new Employee(7822, "Naveen", 45600);
        employees.add(emp);
        System.out.println(emp.hashCode());

        emp = new Employee(6726, "Neeraj", 65000);
        employees.add(emp);
        System.out.println(emp.hashCode());

        for(Employee e: employees){
            System.out.println(e);
        }
    }
}
