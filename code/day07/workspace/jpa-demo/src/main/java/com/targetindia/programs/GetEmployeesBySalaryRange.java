package com.targetindia.programs;

import com.targetindia.entity.Employee;
import com.targetindia.utils.JpaUtil;
import com.targetindia.utils.KeyboardUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class GetEmployeesBySalaryRange {
    public static void main(String[] args) {
        double min = KeyboardUtil.getDouble("Enter value for minimum salary: ");
        double max = KeyboardUtil.getDouble("Enter value for maximum salary: ");

        EntityManager em = JpaUtil.getEntityManager();
        // TypedQuery<Employee> qry = em.createQuery("select e from Employee e where e.salary between ?0 and ?1", Employee.class);
        TypedQuery<Employee> qry = em.createQuery("select e from Employee e where e.salary between :MIN_SAL and :MAX_SAL", Employee.class);

        // qry.setParameter(0, min);
        // qry.setParameter(1, max);

        qry.setParameter("MIN_SAL", min);
        qry.setParameter("MAX_SAL", max);

        List<Employee> list = qry.getResultList();
        em.close();

        for(Employee e: list){
            System.out.println(e.getFirstname() + " " + e.getLastname() + " earns Rs." + e.getSalary());
        }
    }
}
