package com.targetindia.programs;

import com.targetindia.model.Employee;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InheritanceDemo {
    public static void main(String[] args) {
        Employee emp;

        emp = new Employee();

        // own members of Employee
        emp.setId(1122);
        emp.setSalary(3450.0);

        // inherited members of Employee
        emp.setName("John Doe");
        emp.setEmail("johndoe@xmpl.com");
        emp.setCity("Dallas");
        emp.setState("Texas");
        emp.setCountry("USA");

        log.trace("emp = {}", emp);

        emp.log(); // calling inherited method

    }
}
