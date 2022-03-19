package com.targetindia.model;

import com.targetindia.exceptions.InvalidEmployeeIdException;
import com.targetindia.exceptions.InvalidNameException;
import com.targetindia.exceptions.InvalidSalaryException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
@Getter
public class Employee {
    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) throws InvalidEmployeeIdException, InvalidNameException, InvalidSalaryException {
        setId(id);
        setName(name);
        setSalary(salary);
    }

    public void setId(int id) throws InvalidEmployeeIdException {
        if(id<=0){
            // communicate with the caller of setId() method
            throw new InvalidEmployeeIdException();
        }
        this.id = id;
    }

    public void setName(String name) throws InvalidNameException {
        if(name==null || name.trim().length() < 3){
            throw new InvalidNameException("Name cannot be null or less than 3 letters");
        }
        this.name = name;
    }

    public void setSalary(double salary) throws InvalidSalaryException {
        if(salary < 0) {
            throw new InvalidSalaryException("Negative value for salary not acceptable");
        }
        this.salary = salary;
    }

}
