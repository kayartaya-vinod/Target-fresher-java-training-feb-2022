package com.targetindia.programs;

import com.targetindia.model.Employee;

import java.util.Map;
import java.util.TreeMap;

public class MapDemo {
    public static void main(String[] args) {
        Map<Integer, Employee> employees = new TreeMap<>();
        employees.put(1122, new Employee(1122, "Vishal", 45000));
        employees.put(7822, new Employee(7822, "Naveen", 45600));
        employees.put(2122, new Employee(2122, "Ramesh", 35000));
        employees.put(6726, new Employee(6726, "Neeraj", 65000));
        employees.put(7833, new Employee(7833, "Nishchal", 35600));
        employees.put(2155, new Employee(2155, "Rajesh", 35000));
        employees.put(9822, new Employee(9822, "Nimesh", 45600));
        employees.put(6777, new Employee(6777, "Girija", 65000));
        employees.put(7822, new Employee(7822, "Naveen Kumar", 55000));

        System.out.println("size of employees is " + employees.size());
        Employee emp = employees.get(7822);
        System.out.println(emp);

        System.out.println("employees.containsKey(7788) is " + employees.containsKey(7788));

        // iterate over the keyset and then get one employee for the given key
        for (Integer key : employees.keySet()) {
            System.out.println(employees.get(key));
        }
        System.out.println("-".repeat(50));

        // iterate over all the values in the map
        for (Employee empl : employees.values()) {
            System.out.println(empl);
        }
        System.out.println("-".repeat(50));

        // iterate over a collection of entry (key+value)
        for (Map.Entry<Integer, Employee> entry : employees.entrySet()) {
            System.out.println(entry.getKey() + " --> " + entry.getValue());
        }
    }
}
