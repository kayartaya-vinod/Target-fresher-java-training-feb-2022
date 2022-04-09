package com.targetindia.programs;

import com.targetindia.entity.Employee;
import com.targetindia.utils.JpaUtil;
import com.targetindia.utils.KeyboardUtil;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

@Slf4j
public class AddNewEmployeeDetails {

    public static void main(String[] args) {

        String firstname = KeyboardUtil.getString("Enter firstname: ");
        String lastname = KeyboardUtil.getString("Enter lastname : ");
        String email = KeyboardUtil.getString("Enter email    : ");
        String phone = KeyboardUtil.getString("Enter phone    : ");
        Double salary = KeyboardUtil.getDouble("Enter salary   : ");

        Employee emp = new Employee();
        emp.setFirstname(firstname);
        emp.setLastname(lastname);
        emp.setSalary(salary);
        emp.setEmail(email);
        emp.setPhone(phone);

        // at this point in time, "emp" is just an ordinary object (from the perspective of JPA,
        // it is called as "transient" object)

        EntityManager em = JpaUtil.getEntityManager();

        // "em" maintains a cache of objects, and at this time, there are no objects (from the perspective of JPA,
        // these objects would be called as "managed" objects; since JPA manages the lifecycle of the same).

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            em.persist(emp); // SQL INSERT is not created+fired here.

            // now "emp" becomes a managed object with a tag "new" associated with it

            tx.commit(); // JPA impl (eg, Hibernate) will now check all the managed objects for various tags,
            // (eg, new, dirty, removed) and appropriate SQL DML statements (INSERT/UPDATE/DELETE) are created
            // and executed
            log.trace("emp {} - added to successfully!", emp);
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
            log.warn("emp {} - couldn't add!", emp);
        }
        em.close();
    }
}
