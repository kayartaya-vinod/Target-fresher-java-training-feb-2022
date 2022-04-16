package com.targetindia.programs;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.targetindia.config.AppConfig4;
import com.targetindia.entity.Employee;

public class HibernateTemplateDemo {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig4.class);
		HibernateTemplate ht = ctx.getBean(HibernateTemplate.class);

		List<Employee> list = (List<Employee>) ht.find("from Employee where salary between ?0 and ?1", 40000., 50000.);

		System.out.println("There are " + list.size() + " employees earning between Rs.40000/- and Rs.50000/-");
		
		ctx.close();
	}

}
