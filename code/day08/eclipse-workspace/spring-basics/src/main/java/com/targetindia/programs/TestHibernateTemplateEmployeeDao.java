package com.targetindia.programs;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.targetindia.config.AppConfig4;
import com.targetindia.dao.DaoException;
import com.targetindia.dao.EmployeeDao;
import com.targetindia.entity.Employee;

public class TestHibernateTemplateEmployeeDao {

	static EmployeeDao dao;

	public static void main(String[] args) throws DaoException {
		AnnotationConfigApplicationContext ctx;
		ctx = new AnnotationConfigApplicationContext(AppConfig4.class);

		dao = ctx.getBean("htDao", EmployeeDao.class);
		
		System.out.println("dao is an instanceof " + dao.getClass().getName());
		
		// printEmployeeForId(123);
		// printEmployeeForEmail("surendra.nath@xmpl.com");
		// printEmployeeForPhone("9943646663");
		// printEmployeesForLastname("Kumar");
		// printEmployeesEarningBetween(40000., 50000.);
		// printAllEmployees();
		
//		Employee emp = new Employee();
//		emp.setFirstname("Manohar");
//		emp.setLastname("Rao");
//		emp.setSalary(47500.);
//		emp.setEmail("manohar.rao@xmpl.com");
//		emp.setPhone("6784561230");
//		dao.create(emp);
		
		Employee emp = dao.findById(123);
		System.out.println("Salary = Rs." + emp.getSalary()+"/-");
		emp.setSalary(emp.getSalary()+5000);
		emp = dao.update(emp);
		System.out.println("Salary = Rs." + emp.getSalary()+"/-");
		
		ctx.close();
	}

	static void printAllEmployees() throws DaoException {
		List<Employee> emps = dao.findAll();
		System.out.println("There are " + emps.size() + " employees.");
	}

	static void printEmployeesEarningBetween(double minSalary, double maxSalary) throws DaoException {
		List<Employee> emps = dao.findAllBySalaryRange(minSalary, maxSalary);
		System.out.println("There are " + emps.size() + " employees earning between Rs." + minSalary + "/- and Rs."
				+ maxSalary + "/-");
	}

	static void printEmployeesForLastname(String lastname) throws DaoException {
		List<Employee> emps = dao.findAllByLastname(lastname);
		for (Employee emp : emps) {
			System.out.println(emp);
		}
	}

	static void printEmployeeForPhone(String phone) throws DaoException {
		Employee emp = dao.findByPhone(phone);
		System.out.println(emp);
	}

	static void printEmployeeForEmail(String email) throws DaoException {
		Employee emp = dao.findByEmail(email);
		System.out.println(emp);
	}

	static void printEmployeeForId(Integer id) throws DaoException {
		Employee emp = dao.findById(123);
		System.out.println(emp);

	}

}
