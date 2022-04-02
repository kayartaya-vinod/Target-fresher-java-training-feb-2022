package com.targetindia.repository;

import com.targetindia.entity.Employee;

import java.util.List;

public interface EmployeeRepository {
    // CRUD Operations
    public Employee insert(Employee employee) throws RepositoryException;

    public Employee findById(int id) throws RepositoryException;

    public Employee update(Employee employee) throws RepositoryException;

    public Employee delete(int id) throws RepositoryException;

    // Queries

    public List<Employee> findAll() throws RepositoryException;

    public Employee findByEmail(String email) throws RepositoryException;

    public Employee findByPhone(String phone) throws RepositoryException;

    public List<Employee> findByLastname(String lastname) throws RepositoryException;

    public List<Employee> findBetweenSalary(double min, double max) throws RepositoryException;
}
