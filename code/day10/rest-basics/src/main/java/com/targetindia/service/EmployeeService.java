package com.targetindia.service;

import com.targetindia.controller.EmployeeController;
import com.targetindia.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {

    private List<Employee> employeeList = new ArrayList<>();

    public EmployeeService(){
        Employee e;

        e = new Employee(UUID.randomUUID().toString(), "John", "Doe", "johndoe@xmpl.com", "9879875432", 25000.);
        employeeList.add(e);
        e = new Employee(UUID.randomUUID().toString(), "Robert", "Miller", "robertmiller@xmpl.com", "9870005432", 27000.);
        employeeList.add(e);
        e = new Employee(UUID.randomUUID().toString(), "Kishore", "Kumar", "kishorekumar@xmpl.com", "9111875432", 35000.);
        employeeList.add(e);
    }

    public Employee addNewEmployee(Employee employee){
        // must do some basic validations before adding to the collection
        // but skipping for now.
        employee.setId(UUID.randomUUID().toString());
        employeeList.add(employee);
        return employee;
    }

    public List<Employee> getAll(){
        return Collections.unmodifiableList(employeeList);
    }
}
