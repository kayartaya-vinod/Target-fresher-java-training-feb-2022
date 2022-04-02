package com.targetindia.ui;

import com.targetindia.entity.Employee;
import com.targetindia.service.EmployeeManager;
import com.targetindia.service.ServiceException;
import com.targetindia.utils.KeyboardUtil;

public class EmployeeUserInterface {

    EmployeeManager manager = new EmployeeManager();

    public void acceptAndAddEmployeeDetails() {
        String firstname = KeyboardUtil.getString("Enter firstname: ");
        String lastname = KeyboardUtil.getString("Enter lastname : ");
        String email = KeyboardUtil.getString("Enter email    : ");
        String phone = KeyboardUtil.getString("Enter phone    : ");
        double salary;
        try {
            salary = KeyboardUtil.getDouble("Enter salary   : ");
        } catch (Exception e) {
            System.out.println("Invalid salary entered. Assuming the default of 15000");
            salary = 15000;
        }

        Employee emp = new Employee();
        emp.setFirstname(firstname);
        emp.setLastname(lastname);
        emp.setSalary(salary);
        emp.setEmail(email);
        emp.setPhone(phone);

        try {
            emp = manager.addEmployee(emp);
            System.out.println("Employee details added with id " + emp.getId());

        } catch (ServiceException e) {
            System.out.println(e.getMessage());
        }
    }
}
