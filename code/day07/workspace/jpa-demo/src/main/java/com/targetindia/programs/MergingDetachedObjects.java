package com.targetindia.programs;

import com.targetindia.entity.Employee;
import com.targetindia.utils.JpaUtil;
import com.targetindia.utils.KeyboardUtil;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

@Slf4j
public class MergingDetachedObjects {

    static Employee getEmployeeById(int id){
        EntityManager em = null;
        try{
            em = JpaUtil.getEntityManager();
            return em.find(Employee.class, id); // emp is a managed object
        }
        finally {
            if(em!=null) {
                em.close();
            }
        }
    }

    public static void main(String[] args) {
        int id = KeyboardUtil.getInt("Enter id to search: ");
        Employee emp = getEmployeeById(id); // emp is a detached (from the entity-manager) object
        log.trace("emp = {}", emp);

        double salary = KeyboardUtil.getDouble("Enter new salary for this employee: ");
        emp.setSalary(salary);

        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(emp); // now emp becomes a managed object again
        tx.commit(); // now a SELECT statement is executed to get the employee record from the DB corresponding
        // to the emp.id, a comparison between the "emp" object's data and the data in the fetched record is done.
        // if there is any change, then the data in the "emp" object is merged with DB table using an UPDATE
        // SQL statement.

        // In the output for the em.merge() + em.commit(), observe the SQL statements generated
        // SELECT --> ALWAYS
        // UPDATE --> ONLY IF THE SALARY ENTERED IS DIFFERENT FROM THE ONE THAT IS RETRIEVED
    }
}
