package com.targetindia.programs;

import com.targetindia.entity.Employee;
import com.targetindia.utils.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class GetAllEmployees {
    public static void main(String[] args) {
        // SQL - SELECT * FROM employees
        // JPQL - SELECT e FROM Employee e
        //                 FROM Employee
        EntityManager em = JpaUtil.getEntityManager();
        TypedQuery<Employee> qry = em.createQuery("from Employee", Employee.class);
        List<Employee> list = qry.getResultList();
        em.close();

        for(Employee e: list){
            System.out.println(e.getFirstname() + " " + e.getLastname() + " earns Rs." + e.getSalary());
        }

    }
}
