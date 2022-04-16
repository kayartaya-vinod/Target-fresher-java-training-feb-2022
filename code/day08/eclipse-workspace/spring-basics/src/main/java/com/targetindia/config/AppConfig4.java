package com.targetindia.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.targetindia.entity.Employee;

@PropertySource("classpath:jdbc-info.properties")
@Configuration
@ComponentScan(basePackages = { "com.targetindia.dao" })
@EnableTransactionManagement // step#1 - enable transaction management
public class AppConfig4 {

	@Value("${jdbc.connection.driver-class-name}")
	private String driverClassName;
	@Value("${jdbc.connection.url}")
	private String url;
	@Value("${jdbc.connection.user}")
	private String username;
	@Value("${jdbc.connection.password}")
	private String password;
	
	// step#2 - create the transaction manager bean
	@Bean
	public HibernateTransactionManager txMgr(SessionFactory factory) {
		return new HibernateTransactionManager(factory); 
		// the same factory is used by our HibernateTemplate, which is used by our HibernateTemplateEmployeeDao
	}

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

	@Bean
	public LocalSessionFactoryBean sessionFactory(DataSource ds) { // dependency injection by Spring
		LocalSessionFactoryBean lsfb = new LocalSessionFactoryBean();
		lsfb.setDataSource(ds); // manual wiring by me
		lsfb.setAnnotatedClasses(Employee.class);

		Properties props = new Properties();
		props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		props.setProperty("hibernate.show_sql", "false");
		props.setProperty("hibernate.format_sql", "true");
		lsfb.setHibernateProperties(props);

		return lsfb;
	}

	@Bean
	public HibernateTemplate ht(SessionFactory factory) { // dependency injection by Spring
		// combines the capabilities of Hibernate's Session and Query APIs
		// this depends on SessionFactory
		return new HibernateTemplate(factory); // manual wiring by me
	}
}
