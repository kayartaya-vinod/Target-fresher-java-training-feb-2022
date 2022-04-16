package com.targetindia.programs;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.targetindia.config.AppConfig3;
import com.targetindia.dao.DaoException;
import com.targetindia.dao.EmployeeDao;

public class GetEmployeeCount {

	public static void main(String[] args) throws DaoException {
		
		// a variable of my dependency
		EmployeeDao dao;
		
		// an object representing the dependency; tight coupling
		// dao = new DummyEmployeeDao();
		
		// a variable representing the spring container
		AnnotationConfigApplicationContext ctx;
		
		// an object representing the spring container
		ctx = new AnnotationConfigApplicationContext(AppConfig3.class);
		// Spring container creates an object of the configuration class (AppConfig1.class) and using that object
		// calls all the methods annotated with @Bean, collects the return values and keeps them in the container
		// with the names of the functions as their ids.
		
		// ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");
		
		// bean lookup; to be replaced with dependency injection later.
		dao = ctx.getBean("jdbcEmployeeDao", EmployeeDao.class);
		
		// use the dependency
		long ec = dao.count();
		
		System.out.println("Employee count = " + ec);
		
		ctx.close();
	}
}
