package com.targetindia.programs;

import com.targetindia.entity.Employee;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Slf4j
public class GetEmployeeById {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TARGET_PU");
        EntityManager em = emf.createEntityManager(); // creates a new DB connection; must be closed ASAP
        log.trace("em is an instanceof {}", em.getClass().getName());
        Employee emp = em.find(Employee.class, 1012); // SQL SELECT is fired here

        em.close(); // DB connection is now closed; connection is returned to the pool back;
        log.trace("emp = {}", emp);

    }
}
