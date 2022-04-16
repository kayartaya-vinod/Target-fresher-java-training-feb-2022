package com.targetindia.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.targetindia.dao.DummyEmployeeDao;
import com.targetindia.dao.JdbcEmployeeDao;

@Configuration
@PropertySource("classpath:jdbc-info.properties")
public class AppConfig1 {

	public AppConfig1() {
		System.out.println("AppConfig1() called");
	}

	@Bean
	public DummyEmployeeDao dummyDao() {
		System.out.println("AppConfig1.dummyDao() called");
		return new DummyEmployeeDao();
	}

	@Bean
	public JdbcEmployeeDao jdbcDao() {
		System.out.println("AppConfig1.jdbcDao() called");
		return new JdbcEmployeeDao();
	}

}
