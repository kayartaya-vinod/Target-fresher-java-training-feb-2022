package com.targetindia.programs;

import org.hibernate.Session;

import com.targetindia.entity.Employee;
import com.targetindia.utils.HibernateUtil;

public class GetEmployeeById {

	public static void main(String[] args) {
		
		
		Session session = HibernateUtil.createSession();
		
		Employee emp = session.get(Employee.class, 222);
		session.close();
		
		System.out.println(emp);
		
	}

}
