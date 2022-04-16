package com.targetindia.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:jdbc-info.properties")
@ComponentScan(basePackages = { "com.targetindia.dao" }) // class != component
public class AppConfig2 {
	
	@Value("${jdbc.connection.driver-class-name}")
	private String driverClassName;
	@Value("${jdbc.connection.url}")
	private String url;
	@Value("${jdbc.connection.user}")
	private String username;
	@Value("${jdbc.connection.password}")
	private String password;
	
	// BasicDataSource from Apache commons DBCP is the most widely used database connection pool
	@Bean
	public BasicDataSource dataSource() {
		BasicDataSource bds = new BasicDataSource();
		bds.setDriverClassName(driverClassName);
		bds.setUrl(url);
		bds.setUsername(username);
		bds.setPassword(password);
		
		bds.setInitialSize(5);
		bds.setMaxTotal(100);
		bds.setMaxWaitMillis(500);
		bds.setMaxIdle(20);
		return bds;
	}
	

}
