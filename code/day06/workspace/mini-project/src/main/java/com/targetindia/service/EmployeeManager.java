package com.targetindia.service;

import com.targetindia.entity.Employee;
import com.targetindia.repository.EmployeeRepository;
import com.targetindia.repository.RepositoryException;
import com.targetindia.repository.RepositoryFactory;

public class EmployeeManager {

    // EmployeeRepository repo = new JdbcEmployeeRepository(); // tight coupling; need to get this object using factory
    EmployeeRepository repo;

    public EmployeeManager() throws ServiceException {
        try {
            this.repo =  RepositoryFactory.getEmployeeRepository(); // loose coupling
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }

    public Employee addEmployee(Employee employee) throws ServiceException {
        String firstname = employee.getFirstname();
        if (firstname == null || firstname.trim().length() == 0) {
            throw new ServiceException("Firstname is required, but missing");
        }
        double salary = employee.getSalary();
        if(salary < 15000){
            throw new ServiceException("Salary must be >= 15000");
        }

        try {
            return repo.insert(employee);
        } catch (RepositoryException e) {
            throw new ServiceException(e); // exception funnelling
        }
    }
}
