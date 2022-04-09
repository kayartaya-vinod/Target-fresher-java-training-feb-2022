package com.targetindia.programs;

import com.targetindia.entity.Employee;
import com.targetindia.utils.JpaUtil;
import com.targetindia.utils.KeyboardUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class GetEmployeesByPage {
    public static void main(String[] args) {

        int pageNo = KeyboardUtil.getInt("Enter page number: ");
        int pageSize = KeyboardUtil.getInt("Enter number of records per page: ");
        int offset = (pageNo-1) * pageSize;

        EntityManager em = JpaUtil.getEntityManager();
        TypedQuery<Employee> qry = em.createQuery("from Employee", Employee.class);
        qry.setMaxResults(pageSize); // LIMIT
        qry.setFirstResult(offset); // OFFSET
        List<Employee> list = qry.getResultList();
        em.close();

        for(Employee e: list){
            System.out.println(e);
        }

    }
}
