package com.targetindia.programs;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.targetindia.entity.Employee;
import com.targetindia.utils.HibernateUtil;

public class AddNewEmployee {

	public static void main(String[] args) {
		
		Employee emp = new Employee();
		emp.setFirstname("Surendra");
		emp.setLastname("Nath");
		emp.setSalary(45600.0);
		emp.setEmail("surendra.nath@xmpl.com");
		emp.setPhone("4567311223");
		
		Session session = HibernateUtil.createSession();
		Transaction tx = session.beginTransaction();
		
		try {
			session.persist(emp);
			tx.commit(); // actual SQL INSERT is executed here
			System.out.println("new employee added with id " + emp.getId());
		} catch (Exception e) {
			tx.rollback();
			System.out.println(e.getMessage());
		}
		
		session.close();
	}
}
