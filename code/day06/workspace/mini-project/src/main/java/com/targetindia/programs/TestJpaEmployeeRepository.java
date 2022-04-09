package com.targetindia.programs;

import com.targetindia.entity.Employee;
import com.targetindia.repository.EmployeeRepository;
import com.targetindia.repository.RepositoryException;
import com.targetindia.repository.RepositoryFactory;

import java.util.List;

public class TestJpaEmployeeRepository {
    public static void main(String[] args) throws RepositoryException {

        EmployeeRepository repo = RepositoryFactory.getEmployeeRepository();
        Employee emp = repo.findByEmail("preetham.khanna@xmpl.com");
        System.out.println(emp);
        emp.setSalary(emp.getSalary() + 1000);
        repo.update(emp);
        emp = repo.findByEmail("preetham.khanna@xmpl.com");
        System.out.println(emp);
        repo.delete(1015); // Kishan lal
        emp = repo.findByEmail("preetham.khanna@xmpl.com");
        System.out.println(emp);

        emp = repo.findByPhone("9878767654");
        System.out.println(emp);

//        List<Employee> emps = repo.findBetweenSalary(30000, 40000);
//        System.out.println("Employees earning between Rs.30000/- and Rs.40000/-");
//        for(Employee e: emps){
//            System.out.println(e);
//        }
        System.out.println("Employees with lastname of 'Kumar': ");
        List<Employee> emps = repo.findByLastname("Kumar");
        for(Employee e: emps){
            System.out.println(e);
        }
    }
}
