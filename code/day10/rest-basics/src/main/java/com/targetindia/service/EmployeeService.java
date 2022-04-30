package com.targetindia.service;

import com.targetindia.controller.EmployeeController;
import com.targetindia.model.Employee;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {

    private List<Employee> employeeList = new ArrayList<>();

    public EmployeeService() {
        Employee e;
        e = new Employee("8bc324ee-19ad-4915-a9f4-8551179a75d6", "John", "Doe", "johndoe@xmpl.com", "9879875432", 25000.);
        employeeList.add(e);
        e = new Employee("42c21abe-582b-4cdf-96fb-806f937bb287", "Robert", "Miller", "robertmiller@xmpl.com", "9870005432", 27000.);
        employeeList.add(e);
        e = new Employee("d5d59a76-7b05-4ce1-9239-da050e72f128", "Kishore", "Kumar", "kishorekumar@xmpl.com", "9111875432", 35000.);
        employeeList.add(e);
    }

    public Employee addNewEmployee(Employee employee) {
        // must do some basic validations before adding to the collection
        // 1. firstname, email, phone are mandatory
        // 2. email must be unique
        // 3. phone must be unique
        if (employee.getFirstname() == null || employee.getFirstname().isBlank()) {
            throw new ServiceException("Firstname is mandatory, but missing");
        }
        if (employee.getEmail() == null || employee.getEmail().isBlank()) {
            throw new ServiceException("Email is mandatory, but missing");
        }
        if (employee.getPhone() == null || employee.getPhone().isBlank()) {
            throw new ServiceException("Phone is mandatory, but missing");
        }

        Optional<String> op = this.employeeList.stream()
                .map(e -> e.getEmail())
                .filter(em -> em.equals(employee.getEmail()))
                .findFirst();
        if (op.isPresent()) {
            throw new ServiceException("Employee with this email already present - " + employee.getEmail());
        }

        op = this.employeeList.stream()
                .map(e -> e.getPhone())
                .filter(ph -> ph.equals(employee.getPhone()))
                .findFirst();
        if (op.isPresent()) {
            throw new ServiceException("Employee with this phone already present - " + employee.getPhone());
        }

        employee.setId(UUID.randomUUID().toString());
        employeeList.add(employee);
        return employee;
    }

    public List<Employee> getAll() {
        return Collections.unmodifiableList(employeeList);
    }

    public Employee getById(String id) {
        return this.employeeList.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
