package com.targetindia.programs;

import com.targetindia.model.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class ConsumerDemo {
    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1122, "Vishal", 45000));
        employees.add(new Employee(2122, "Ramesh", 35000));
        employees.add(new Employee(7827, "Naveen", 55600));
        employees.add(new Employee(6728, "Neeraj Kumar", 65000));
        employees.add(new Employee(7833, "Nishchal", 35600));
        employees.add(new Employee(2122, "Ramesh", 35000));
        employees.add(new Employee(7822, "Naveen", 45600));
        employees.add(new Employee(6726, "Neeraj Singh", 65000));

//        employees.forEach(e -> e.setName(e.getName().toUpperCase()));
//        employees.forEach(e -> System.out.println(e));
//        System.out.println("-".repeat(80));

        List<String> list = employees
                .stream()
                .filter(e -> e.getSalary() >= 50000)
                .map(e -> e.getName())
                // .map(name -> name.toUpperCase())
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println(list);

        employees
                .stream()
                .filter(e -> e.getSalary() >= 40000)
                // .sorted()
                .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                //.forEach(e -> System.out.println(e))
                .forEach(System.out::println);
    }
}
