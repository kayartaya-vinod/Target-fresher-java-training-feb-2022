package com.targetindia.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.targetindia.dao.JdbcEmployeeDao;

@Configuration
public class AppConfig3 {

	@Bean
	public JdbcEmployeeDao jdbcEmployeeDao(DataSource dataSource) { // dependency; spring attempts to inject
		JdbcEmployeeDao dao = new JdbcEmployeeDao();
		dao.setDataSource(dataSource); // wiring; manual
		return dao;
	}
	
	@Bean
	public BasicDataSource dataSource() {
		BasicDataSource bds = new BasicDataSource();
		bds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		bds.setUrl("jdbc:mysql://localhost/target_db");
		bds.setUsername("root");
		bds.setPassword("Welcome#123");
		
		bds.setInitialSize(5);
		bds.setMaxTotal(100);
		bds.setMaxWaitMillis(500);
		bds.setMaxIdle(20);
		return bds;
	}
}
