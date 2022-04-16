package com.targetindia.programs;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.targetindia.entity.Employee;
import com.targetindia.utils.HibernateUtil;

public class GetEmployeesBySalaryRange {

	public static void main(String[] args) {
		
		String hql = "from Employee where salary between ?0 and ?1";
		
		Session session = HibernateUtil.createSession();
		Query<Employee> qry = session.createQuery(hql, Employee.class);
		qry.setParameter(0, 40000.);
		qry.setParameter(1, 50000.);
		List<Employee> list = qry.getResultList();
		
		System.out.println("There are " + list.size() + " employees earning between Rs.40000/- and Rs.50000/-");
		session.close();
	}
}
