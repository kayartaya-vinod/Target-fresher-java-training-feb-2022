package com.targetindia.utils;

import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.targetindia.entity.Employee;

public class HibernateUtil {

	public static Session createSession() {
		Properties props = new Properties();
		props.setProperty("hibernate.connection.driverClassName", "com.mysql.cj.jdbc.Driver");
		props.setProperty("hibernate.connection.url", "jdbc:mysql://localhost/target_db");
		props.setProperty("hibernate.connection.username", "root");
		props.setProperty("hibernate.connection.password", "Welcome#123");
		props.setProperty("hibernate.hbm2ddl.auto", "update");
		props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");

		Configuration cfg = new Configuration();
		cfg.setProperties(props);
		cfg.addAnnotatedClass(Employee.class);

		SessionFactory factory = cfg.buildSessionFactory(); // represents the DB itself
		Session session = factory.openSession(); // new session; provides CRUD operations; represents a DB connection
		return session;
	}
}
