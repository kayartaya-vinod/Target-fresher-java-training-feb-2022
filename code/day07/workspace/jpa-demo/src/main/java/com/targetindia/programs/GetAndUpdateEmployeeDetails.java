package com.targetindia.programs;

import com.targetindia.entity.Employee;
import com.targetindia.utils.JpaUtil;
import com.targetindia.utils.KeyboardUtil;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

@Slf4j
public class GetAndUpdateEmployeeDetails {
    public static void main(String[] args) {
        int id = KeyboardUtil.getInt("Enter id to search: ");
        EntityManager em = JpaUtil.getEntityManager();

        Employee emp = em.find(Employee.class, id); // emp is a managed object
        if(emp==null){
            log.warn("No employee data was found for id {}", id);
            em.close();
            return;
        }
        log.trace("emp = {}", emp);
        double salary = KeyboardUtil.getDouble("Enter new salary for this employee: ");
        emp.setSalary(salary); // probably "emp" becomes "dirty"

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        tx.commit(); // fires INSERT/UPDATE/DELETE statements based on the tags associated with managed
        // objects in the EntityManager cache. There is no need to call em.merge(..).
        // Also, notice that there are no statements between tx.begin() and tx.commit(). "begin()" is required
        // only to end with "commit()" or "rollback()".
        log.trace("Data might have updated back to the db");

    }
}
