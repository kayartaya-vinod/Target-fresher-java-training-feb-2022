package com.targetindia.model;

import java.util.Objects;

public class Employee implements Comparable<Employee> {
    private int id;
    private String name;
    private double salary;

    public Employee() {
    }

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        // if the content of two objects are identical, they must have identical hashcodes
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return getId() == employee.getId() && Double.compare(employee.getSalary(), getSalary()) == 0 && getName().equals(employee.getName());
    }

    @Override
    public int hashCode() {
        // if the content of two objects are identical, return true; else return false.
        return Objects.hash(getId(), getName(), getSalary());
    }

    @Override
    public String toString() {
        return "Employee {" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    // provides natural ordering to employees
    @Override
    public int compareTo(Employee other) {
        return Integer.compare(this.id, other.id);
    }
}
