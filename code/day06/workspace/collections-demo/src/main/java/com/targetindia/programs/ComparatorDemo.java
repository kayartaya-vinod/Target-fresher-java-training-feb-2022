package com.targetindia.programs;

import com.targetindia.model.Employee;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class ComparatorDemo {

    static class EmployeeNameComparator implements Comparator<Employee>{
        @Override
        public int compare(Employee emp1, Employee emp2) {
            return emp1.getName().compareTo(emp2.getName());
        }
    }

    public static void main(String[] args) {
//        Set<Employee> employees = new TreeSet<>(new EmployeeNameComparator());

//        Set<Employee> employees = new TreeSet<>(new Comparator<Employee>(){
//            public int compare(Employee emp1, Employee emp2) {
//                return Double.compare(emp1.getSalary(), emp2.getSalary());
//            }
//        });

        Set<Employee> employees = new TreeSet<>(
            (emp1, emp2) -> Double.compare(emp1.getSalary(), emp2.getSalary())
        );


        employees.add(new Employee(1122, "Vishal", 45000));
        employees.add(new Employee(2122, "Ramesh", 35000));
        employees.add(new Employee(7822, "Naveen", 45600));
        employees.add(new Employee(6726, "Neeraj", 65000));
        employees.add(new Employee(7833, "Nishchal", 35600));
        employees.add(new Employee(2122, "Ramesh", 35000));
        employees.add(new Employee(7822, "Naveen", 45600));
        employees.add(new Employee(6726, "Neeraj", 65000));

        for(Employee e: employees){
            System.out.println(e);
        }
    }
}
